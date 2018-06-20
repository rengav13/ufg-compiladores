package semantico

import comum.TipoArgumento.IDENTIFICADOR
import comum.TipoDado.{LITERAL, isEquivalente}
import comum._

object RegrasSemanticas {

  val REGRAS_SEMANTICAS: Map[Int, (List[Simbolo] => Unit)] = Map(
    5 -> ((simbolos) => {
      ArquivoObjeto.novaLinha()
    }),
    6 -> (simbolos => {
      val TIPO: Simbolo = simbolos(2)
      val id: Simbolo = TabelaSimbolos.get(simbolos(1))
      id.tipoDado = TIPO.tipoDado
      ArquivoObjeto.imprimir(s"${TIPO.tipoDado} ${id.lexema};")
    }),
    7 -> (simbolos => {
      val TIPO: Simbolo = simbolos.head
      val inteiro: Simbolo = simbolos(1)
      TIPO.tipoDado = inteiro.tipoDado
    }),
    8 -> (simbolos => {
      val TIPO: Simbolo = simbolos.head
      val real: Simbolo = simbolos(1)
      TIPO.tipoDado = real.tipoDado
    }),
    9 -> (simbolos => {
      val TIPO: Simbolo = simbolos.head
      val literal: Simbolo = simbolos(1)
      TIPO.tipoDado = literal.tipoDado
    }),
    11 -> (simbolos => {
      val leia: Simbolo = simbolos(1)
      val id: Simbolo = TabelaSimbolos.get(simbolos(2))

      id.tipoDado match {
        case LITERAL => ArquivoObjeto.imprimir(s"""scanf("%s", ${id.lexema});""")
        case TipoDado.INTEIRO => ArquivoObjeto.imprimir(s"""scanf("%d", &${id.lexema});""")
        case TipoDado.REAL => ArquivoObjeto.imprimir(s"""scanf("%lf", &${id.lexema});""")
        case _ => throw new Exception("Erro: Variável não declarada.")
      }
    }),
    12 -> (simbolos => {
      val escreva: Simbolo = simbolos(1)
      val ARG: Simbolo = simbolos(2)

      if (IDENTIFICADOR.equals(ARG.tipoDado)) {
        ARG.atributo match {
          case LITERAL => ArquivoObjeto.imprimir(s"""printf("%s", ${ARG.lexema});""")
          case TipoDado.INTEIRO => ArquivoObjeto.imprimir(s"""printf("%d", ${ARG.lexema});""")
          case TipoDado.REAL => ArquivoObjeto.imprimir(s"""printf("%lf", ${ARG.lexema});""")
          case _ => throw new Exception("Erro: Variável não declarada.")
        }
      } else {
        ArquivoObjeto.imprimir(s"""printf(${ARG.lexema});""")
      }
    }),
    13 -> (simbolos => {
      val ARG: Simbolo = simbolos.head
      val lit: Simbolo = simbolos(1)
      ARG.lexema = lit.lexema
      ARG.tipoDado = TipoArgumento.CONSTANTE_LITERAL
    }),
    14 -> (simbolos => {
      val ARG: Simbolo = simbolos.head
      val num: Simbolo = simbolos(1)
      ARG.lexema = num.lexema
      ARG.tipoDado = TipoArgumento.NUMERO
    }),
    15 -> (simbolos => {
      val ARG: Simbolo = simbolos.head
      val id: Simbolo = TabelaSimbolos.get(simbolos(1))
      ARG.lexema = id.lexema
      ARG.tipoDado = IDENTIFICADOR
      ARG.atributo = id.tipoDado
    }),
    17 -> (simbolos => {
      val id: Simbolo = TabelaSimbolos.get(simbolos(1))
      val LD: Simbolo = simbolos(3)

      if (id.tipoDado != null) {
        if (id.tipoDado == LD.tipoDado) {
          ArquivoObjeto.imprimir(s"${id.lexema} = ${LD.lexema};")
        } else {
          throw new Exception("Erro: Tipos diferentes para atribuição.")
        }
      } else {
        throw new Exception("Erro: Variável não declarada.")
      }
    }),
    // TODO: Está incompleto
    // Em opm não pode ser tipoDado -> É necessário modificar o nome da variável para expressar um conceito mais conciso.
    18 -> (simbolos => {
      val LD: Simbolo = simbolos.head
      val OPRD1: Simbolo = simbolos(1)
      val opm: Simbolo = simbolos(2)
      val OPRD2: Simbolo = simbolos(3)

      if (isEquivalente(OPRD1.tipoDado, OPRD2.tipoDado)) {
        ContadorVariaveisTemporarias.up()
        val temporaria: String = s"T${ContadorVariaveisTemporarias.contador.toString}"

        LD.lexema = temporaria
        LD.tipoDado = TipoDado.getTipoComPrecedencia(OPRD1.tipoDado, OPRD2.tipoDado)
        ArquivoObjeto.imprimir(s"$temporaria = ${OPRD1.lexema} ${opm.lexema} ${OPRD2.lexema};")
      } else {
        throw new Exception("Erro: Operandos com tipos diferentes.")
      }
    }),
    19 -> (simbolos => {
      val LD: Simbolo = simbolos.head
      val OPRD: Simbolo = simbolos(1)

      LD.tipoDado = OPRD.tipoDado
      LD.lexema = OPRD.lexema
    }),
    20 -> (simbolos => {
      val OPRD: Simbolo = simbolos.head
      val id: Simbolo = TabelaSimbolos.get(simbolos(1))

      if (id.tipoDado != null) {
        OPRD.tipoDado = id.tipoDado
        OPRD.lexema = id.lexema
      } else {
        throw new Exception("Erro: Variável não declarada.")
      }
    }),
    21 -> (simbolos => {
      val OPRD: Simbolo = simbolos.head
      val num: Simbolo = simbolos(1)
      OPRD.tipoDado = num.tipoDado
      OPRD.lexema = num.lexema
    }),
    23 -> (simbolos => {
      ArquivoObjeto.imprimir("}")
    }),
    24 -> (simbolos => {
      val EXP_R: Simbolo = simbolos(3)
      ArquivoObjeto.imprimir(s"if (${EXP_R.lexema}) {")
    }),
    25 -> (simbolos => {
      val EXP_R: Simbolo = simbolos.head
      val OPRD1: Simbolo = simbolos(1)
      val opr: Simbolo = simbolos(2)
      val OPRD2: Simbolo = simbolos(3)

      if (TipoDado.isEquivalente(OPRD1.tipoDado, OPRD2.tipoDado)) {
        ContadorVariaveisTemporarias.up()
        val temporaria: String = s"T${ContadorVariaveisTemporarias.contador.toString}"

        EXP_R.lexema = temporaria
        ArquivoObjeto.imprimir(s"$temporaria = ${OPRD1.lexema} ${opr.lexema} ${OPRD2.lexema};")
      } else {
        throw new Exception("Erro: Operandos com tipos incompativeis.")
      }
    })
  )

  def existe(pos: Int): Boolean = this.REGRAS_SEMANTICAS.contains(pos)

  def executa(pos: Int, simbolos: List[Simbolo]): Unit = this.REGRAS_SEMANTICAS(pos)(simbolos)
}