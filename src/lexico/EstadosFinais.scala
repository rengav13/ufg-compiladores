package lexico

import comum.{PalavrasReservadas, TipoDado, TipoSimboloTerminal}

object EstadosFinais {
  val ESTADOS_FINAIS: Map[Int, String] = Map(
    1 -> TipoSimboloTerminal.OPERADOR_ARITMETICO,
    2 -> TipoSimboloTerminal.NUMERO,
    4 -> TipoSimboloTerminal.NUMERO,
    7 -> TipoSimboloTerminal.NUMERO,
    8 -> TipoSimboloTerminal.OPERADOR_ARITMETICO,
    9 -> TipoSimboloTerminal.IDENTIFICADOR,
    11 -> TipoSimboloTerminal.CONSTANTE_LITERAL,
    12 -> TipoSimboloTerminal.CONSTANTE_LITERAL,
    14 -> TipoSimboloTerminal.COMENTARIO,
    15 -> TipoSimboloTerminal.COMENTARIO,
    16 -> TipoSimboloTerminal.FIM_ARQUIVO,
    17 -> TipoSimboloTerminal.OPERADOR_RELACIONAL,
    18 -> TipoSimboloTerminal.OPERADOR_RELACIONAL,
    19 -> TipoSimboloTerminal.OPERADOR_RELACIONAL,
    20 -> TipoSimboloTerminal.OPERADOR_RELACIONAL,
    21 -> TipoSimboloTerminal.ATRIBUICAO,
    22 -> TipoSimboloTerminal.ABRE_PARENTESES,
    23 -> TipoSimboloTerminal.FECHA_PARENTESES,
    24 -> TipoSimboloTerminal.PONTO_VIRGULA,
    25 -> TipoSimboloTerminal.WHITE_SPACE
  )

  def classificou(estado: Int): Boolean = this.ESTADOS_FINAIS.contains(estado)

  def getTipoSimbolo(estado: Int): String = this.ESTADOS_FINAIS(estado)

  def isConstanteNumerica(estado: Int): Boolean = TipoSimboloTerminal.NUMERO.equals(this.ESTADOS_FINAIS(estado))

  def getTipoConstanteNumerica(estado: Int): String = {
    if (estado == 2)
      TipoDado.INTEIRO
    else if (estado == 4 || estado == 7)
      TipoDado.REAL
    else
      null
  }
}
