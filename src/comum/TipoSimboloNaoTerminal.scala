package comum

object TipoSimboloNaoTerminal {
  val PROGRAMA = "P"
  val VARIAVEIS = "V"
  val LISTA_ENTRADA_SAIDA = "A"
  val LISTA_VARIAVEIS = "LV"
  val DECLARACAO = "D"
  val TIPO = "TIPO"
  val ENTRADA_SAIDA = "ES"
  val ARGUMENTO = "ARG"
  val COMANDO = "CMD"
  val OPERANDO = "OPRD"
  val LADO_DIREITO_ATRIBUICAO = "LD"
  val CONDICAO = "COND"
  val CABECALHO = "CABECALHO"
  val CORPO = "CORPO"
  val EXPRESSAO_RELACIONAL = "EXP_R"

  val tipos: Seq[String] = Seq(PROGRAMA, VARIAVEIS, LISTA_ENTRADA_SAIDA, LISTA_VARIAVEIS, DECLARACAO, TIPO, ENTRADA_SAIDA, ARGUMENTO, COMANDO, OPERANDO, LADO_DIREITO_ATRIBUICAO, CONDICAO, CABECALHO, CORPO, EXPRESSAO_RELACIONAL)

  def getBy(lexema: String): String = {
    this.tipos.filter(_.equals(lexema)).head
  }
}
