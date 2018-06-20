package comum

class Simbolo(var tipoSimbolo: String, var lexema: String, var tipoDado: String) {
  var atributo: String = null.asInstanceOf[String]

  tipoSimbolo match {
    case TipoSimboloTerminal.IDENTIFICADOR =>
      if (TipoSimboloTerminal.isReservada(lexema))
        preencherPalavraReservada(lexema)
    case _ =>
  }

  def this(tipoSimbolo: String, lexema: String) = this(tipoSimbolo, lexema, null.asInstanceOf[String])

  def this(lexema: String) = this(lexema, lexema)

  def preencherPalavraReservada(lexema: String): Unit = {
    if (TipoSimboloTerminal.isTipoDado(lexema)) {
      this.tipoDado = TipoDado.get(lexema)
    }
    this.tipoSimbolo = TipoSimboloTerminal.getPalavraReservada(lexema)
  }

  def setTipoDado(tipoDado: String): Unit = this.tipoDado = tipoDado

  override def toString: String = s"[ Simbolo: ${this.tipoSimbolo}, lexema: ${this.lexema}, tipoDado: ${this.tipoDado} ]"
}