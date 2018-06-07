package sintatico

import lexico.{AnalisadorLexico, Token}

class AnalisadorSintatico(fonte: String) {

  val lexico: AnalisadorLexico = new AnalisadorLexico(fonte)
  var pilha: Pilha = new Pilha()
  var token: Token = _

  def analisar(): Unit = {
    this.inicializar(fonte)

    var acao: Acao = null
    do {
      acao = Automato.obterAcao(this.pilha.estado(), this.token.tipoToken)

      acao match {
        case _ if acao.isEmpilhar => empilhar(acao.getValor)
        case _ if acao.isReduzir => reduzir(acao.getValor)
        case _ if acao.isAceitar => aceitar()
        case _ if acao.isErro => throw new Exception(s"Erro sintático: ${Mensagens.get(acao.getValor)}: linha ${this.lexico.getCursor.linha} e coluna ${this.lexico.getCursor.coluna}, foi lido ${this.token.lexema}")
        case _ => throw new Exception(s"Erro sintático: Erro desconhecido: linha ${this.lexico.getCursor.linha} e coluna ${this.lexico.getCursor.coluna}")
      }
    } while (!acao.isAceitar)
  }

  def empilhar(estado: Int): Unit = {
    this.pilha.empilhar(this.token, estado)
    this.token = this.lexico.proximoToken()
  }

  def reduzir(indiceProducao: Int): Unit = {
    val producao: Producao = Gramatica.get(indiceProducao)
    for (_ <- 1 to producao.getTamanho)
      this.pilha.desempilhar()

    var estado: Int = Automato.desviar(this.pilha.estado(), producao.getProdutor)
    this.pilha.empilhar(new Token(null, producao.getProdutor), estado)

    println(producao)
  }

  def aceitar(): Unit = {
    print("Aceitou")
  }

  def inicializar(fonte: String): Unit = {
    assert(!lexico.leituraFinalizada, "O arquivo está vázio")
    this.token = this.lexico.proximoToken()
  }
}
