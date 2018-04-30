package lexico

object TipoToken extends Enumeration {
  // Tokens
  val NUMERO: TipoToken = new TipoToken("Num")
  val CONSTANTE_LITERAL: TipoToken = new TipoToken("Literal")
  val IDENTIFICADOR: TipoToken = new TipoToken("id")
  val COMENTARIO: TipoToken = new TipoToken("Comentario")
  val FIM_ARQUIVO: TipoToken = new TipoToken("EOF")
  val OPERADOR_RELACIONAL: TipoToken = new TipoToken("OPR")
  val ATRIBUICAO: TipoToken = new TipoToken("RCB")
  val OPERADOR_ARITMETICO: TipoToken = new TipoToken("OPM")
  val ABRE_PARENTESES: TipoToken = new TipoToken("AB_P")
  val FECHA_PARENTESES: TipoToken = new TipoToken("FC_P")
  val PONTO_VIRGULA: TipoToken = new TipoToken("PT_V")
  val ERRO: TipoToken = new TipoToken("ERRO")

  // Palavras reservadas
  val INICIO: TipoToken = new TipoToken("inicio")
  val VAR_INICIO: TipoToken = new TipoToken("varinicio")
  val VAR_FIM: TipoToken = new TipoToken("varfim")
  val ESCREVA: TipoToken = new TipoToken("escreva")
  val LEIA: TipoToken = new TipoToken("leia")
  val SE: TipoToken = new TipoToken("se")
  val ENTAO: TipoToken = new TipoToken("entao")
  val SENAO: TipoToken = new TipoToken("senao")
  val FIM_SE: TipoToken = new TipoToken("fimse")
  val FIM: TipoToken = new TipoToken("fim")
  val INTEIRO: TipoToken = new TipoToken("Inteiro")
  val LITERAL: TipoToken = new TipoToken("literal")
  val REAL: TipoToken = new TipoToken("real")

  class TipoToken(var lexema: String) extends Val

  implicit def convertValue(v: Value): TipoToken = v.asInstanceOf[TipoToken]

  private def getPalavrasReservadas: Seq[TipoToken] = Seq(INICIO, VAR_INICIO, VAR_FIM, ESCREVA, LEIA, SE, ENTAO, SENAO, FIM_SE, FIM, INTEIRO, LITERAL, REAL)

  def isTipoToken(tipo: String): Boolean = TipoToken.values.exists((e) => e.lexema.equals(tipo))

  def isPalavraReservada(lexema: String): Boolean = this.getPalavrasReservadas.exists((e) => e.lexema.equals(lexema))

  def getPalavraReservada(lexema: String): TipoToken =
    this.getPalavrasReservadas
      .filter((e) => e.lexema.equals(lexema))
      .collectFirst({ case tipo: TipoToken => tipo})
      .get
}
