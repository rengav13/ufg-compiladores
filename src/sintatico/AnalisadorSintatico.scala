package sintatico

import comum.Simbolo
import lexico.AnalisadorLexico
import semantico.{ArquivoObjeto, ContadorVariaveisTemporarias, RegrasSemanticas}

class AnalisadorSintatico(fonte: String) {

  val lexico: AnalisadorLexico = new AnalisadorLexico(fonte)
  var pilha: Pilha = new Pilha()
  var simbolo: Simbolo = _

  def analisar(): Unit = {
    this.inicializar(fonte)

    var acao: Acao = null
    do {
      acao = Automato.obterAcao(this.pilha.estado(), this.simbolo.tipoSimbolo)

      acao match {
        case _ if acao.isEmpilhar => empilhar(acao.getValor)
        case _ if acao.isReduzir => reduzir(acao.getValor)
        case _ if acao.isAceitar => aceitar()
        case _ if acao.isErro => throw new Exception(s"Erro sintático: ${Mensagens.get(acao.getValor)}: linha ${this.lexico.getCursor.linha} e coluna ${this.lexico.getCursor.coluna}, foi lido ${this.simbolo.lexema}")
        case _ => throw new Exception(s"Erro sintático: Erro desconhecido: linha ${this.lexico.getCursor.linha} e coluna ${this.lexico.getCursor.coluna}")
      }
    } while (!acao.isAceitar)
  }

  def empilhar(estado: Int): Unit = {
    this.pilha.empilhar(this.simbolo, estado)
    this.simbolo = this.lexico.proximoSimbolo()
  }

  def reduzir(indiceRegra: Int): Unit = {
    val regra: Regra = RegrasSintaticas.get(indiceRegra)

    var simbolos: List[Simbolo] = List()
    for (_ <- 1 to regra.getTamanho)
      simbolos = this.pilha.desempilhar() :: simbolos

    var estado: Int = Automato.desviar(this.pilha.estado(), regra.getProdutor)
    this.pilha.empilhar(new Simbolo(regra.getProdutor), estado)

    //println(s"${indiceRegra.toString}) ${regra.toString}")

    if (RegrasSemanticas.existe(indiceRegra))
      RegrasSemanticas.executa(indiceRegra, List(this.pilha.simbolo()) ::: simbolos)
  }

  def aceitar(): Unit = {
    var header: String = ""
    header += "#include<stdio.h>\n"
    header += "typedef char literal[256];\n"
    header += "void main(void) {\n"
    header += "/*----Variaveis temporarias----*/\n"
    for (index <- 1 to ContadorVariaveisTemporarias.contador) {
      header += s"int T${index.toString};\n"
    }
    header += "/*-----------------------------*/\n"
    ArquivoObjeto.imprimirInicio(header)
    ArquivoObjeto.imprimir("}")
    ArquivoObjeto.escrever()
  }

  def inicializar(fonte: String): Unit = {
    assert(!lexico.leituraFinalizada, "O arquivo está vázio")
    this.simbolo = this.lexico.proximoSimbolo()
  }
}
