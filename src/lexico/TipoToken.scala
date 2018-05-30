package lexico

object TipoToken extends Enumeration {
  // Tokens
  val NUMERO: TipoToken = new TipoToken("num")
  val CONSTANTE_LITERAL: TipoToken = new TipoToken("lit")
  val IDENTIFICADOR: TipoToken = new TipoToken("id")
  val COMENTARIO: TipoToken = new TipoToken("comentario")
  val FIM_ARQUIVO: TipoToken = new TipoToken("EOF")
  val OPERADOR_RELACIONAL: TipoToken = new TipoToken("opr")
  val ATRIBUICAO: TipoToken = new TipoToken("rcb")
  val OPERADOR_ARITMETICO: TipoToken = new TipoToken("opm")
  val ABRE_PARENTESES: TipoToken = new TipoToken("(")
  val FECHA_PARENTESES: TipoToken = new TipoToken(")")
  val PONTO_VIRGULA: TipoToken = new TipoToken(";")
  val WHITE_SPACE: TipoToken = new TipoToken("WHITE_SPACE")
  val ERRO: TipoToken = new TipoToken("ERRO")

  // Palavras reservadas
  val INICIO: TipoToken = new TipoToken("inicio")
  val VAR_INICIO: TipoToken = new TipoToken("varinicio")
  val VAR_FIM: TipoToken = new TipoToken("varfim")
  val ESCREVA: TipoToken = new TipoToken("escreva")
  val LEIA: TipoToken = new TipoToken("leia")
  val SE: TipoToken = new TipoToken("se")
  val ENTAO: TipoToken = new TipoToken("entao")
  val FIM_SE: TipoToken = new TipoToken("fimse")
  val FIM: TipoToken = new TipoToken("fim")
  val INTEIRO: TipoToken = new TipoToken("inteiro")
  val LITERAL: TipoToken = new TipoToken("literal")
  val REAL: TipoToken = new TipoToken("real")

  class TipoToken(var lexema: String) extends Val

  implicit def convertValue(v: Value): TipoToken = v.asInstanceOf[TipoToken]

  private def getPalavrasReservadas: Seq[TipoToken] = Seq(INICIO, VAR_INICIO, VAR_FIM, ESCREVA, LEIA, SE, ENTAO, FIM_SE, FIM, INTEIRO, LITERAL, REAL)

  def isTipoToken(tipo: String): Boolean = TipoToken.values.exists((e) => e.lexema.equals(tipo))

  def isPalavraReservada(lexema: String): Boolean = this.getPalavrasReservadas.exists((e) => e.lexema.equals(lexema))

  def getPalavraReservada(lexema: String): TipoToken =
    this.getPalavrasReservadas
      .filter((e) => e.lexema.equals(lexema))
      .collectFirst({ case tipo: TipoToken => tipo})
      .get
}
