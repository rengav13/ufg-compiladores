package lexico

class Entrada {
  var char: Char = 0
  var simbolo: String = ""
  var lexema: String = ""

  def caracter(char: Char): Unit = {
    this.char = char
    this.simbolo = toSimbolo
  }

  def toSimbolo: String = {
    this.char match {
      case _ if Character.isDigit(this.char) => "D"
      case _ if 'E'.equals(this.char) || 'e'.equals(this.char) => "E"
      case _ if Character.isAlphabetic(this.char) => "L"
      case _ if Character.isWhitespace(this.char) => "F"
      case _ if this.char == 0 => "EOF"
      case _ if !Automato.isSimbolo(this.char) => "Q"
      case _ => this.char.toString
    }
  }

  def concatenarLexema(): Unit = {
    this.lexema += this.char.toString
  }
}
