package lexico

import scala.io.{BufferedSource, Source}

class AnalisadorLexico(fonte: String) {
  val arquivo: BufferedSource = Source.fromFile(fonte)
  var linha: Int = 0
  var coluna: Int = 0

  def proximoToken(): Token = {
    var char: Char = arquivo.next()
    var simbolo: String = this.toSimbolo(char)
    var lexema: String = char.toString

    while (!ControladorAutomato.isLexemaClassificado) {
      char = arquivo.next()
      simbolo = this.toSimbolo(char)
      this.atualizaPosicao(char)
      lexema += char.toString
      ControladorAutomato.vaiParaProximoEstado(simbolo)
    }
    new Token(ControladorAutomato.getTipoToken, lexema)
  }

  def toSimbolo(char: Char): String = {
    char match {
      case _ if Character.isDigit(char) => "D"
      case _ if Character.isAlphabetic(char) => "L"
      case _ if this.isSimboloFormatador(char) => "F"
      case _ => char.toString
    }
  }

  def isSimboloFormatador(char: Char): Boolean = '\n'.equals(char) || ' '.equals(char) || '\t'.equals(char)

  def atualizaPosicao(caracter: Char): Unit = {
    this.coluna += 1
    if (caracter.equals('\n'))
      this.linha += 1
  }
}