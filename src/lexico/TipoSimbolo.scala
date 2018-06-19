package lexico

object TipoSimbolo extends Enumeration {

  val NUMERO = "num"
  val CONSTANTE_LITERAL = "lit"
  val IDENTIFICADOR = "id"
  val COMENTARIO = "comentario"
  val FIM_ARQUIVO = "EOF"
  val OPERADOR_RELACIONAL = "opr"
  val ATRIBUICAO = "rcb"
  val OPERADOR_ARITMETICO = "opm"
  val ABRE_PARENTESES = "("
  val FECHA_PARENTESES = ")"
  val PONTO_VIRGULA = ";"
  val WHITE_SPACE = "WHITE_SPACE"
  val ERRO = "ERRO"

  // Palavras reservadas
  val INICIO = "inicio"
  val VAR_INICIO = "varinicio"
  val VAR_FIM = "varfim"
  val ESCREVA = "escreva"
  val LEIA = "leia"
  val SE = "se"
  val ENTAO = "entao"
  val FIM_SE = "fimse"
  val FIM = "fim"
  val INTEIRO = "inteiro"
  val LITERAL = "literal"
  val REAL = "real"

  val tipos: Seq[String] = Seq(NUMERO, CONSTANTE_LITERAL, IDENTIFICADOR, COMENTARIO, FIM_ARQUIVO, OPERADOR_RELACIONAL, ATRIBUICAO, OPERADOR_ARITMETICO, ABRE_PARENTESES, FECHA_PARENTESES, PONTO_VIRGULA, WHITE_SPACE, ERRO, INICIO, VAR_INICIO, VAR_FIM, ESCREVA, LEIA, SE, ENTAO, FIM_SE, FIM, INTEIRO, LITERAL, REAL)
  val reservadas: Seq[String] = Seq(INICIO, VAR_INICIO, VAR_FIM, ESCREVA, LEIA, SE, ENTAO, FIM_SE, FIM, INTEIRO, LITERAL, REAL)

  def isReservada(lexema: String): Boolean = this.reservadas.exists(_.equals(lexema))

  def getPalavraReservada(lexema: String): String =
    this.reservadas.filter(_.equals(lexema)).head

  def toTipoSimbolo(in: String): String = {
    this.tipos.filter(_.equals(in)).head
  }
}
