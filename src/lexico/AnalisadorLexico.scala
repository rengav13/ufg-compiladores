package lexico

import lexico.TipoToken.TipoToken

import scala.io.{BufferedSource, Source}


/*
 * ERROS:
 *  - Não está identificando +1 como OPR: +; Num: 1
 *  - Não está tratando números em notação cientifica.
 *  - Dando erro em literais quando caracter não está mapeado
 *    - Solução: Criar lista com caracteres entendiveis pelo automato, caso contrario seta um simbolo especial.
 */
class AnalisadorLexico(fonte: String) {
  val arquivo: BufferedSource = Source.fromFile(fonte)
  var charTemporario: Option[Char] = None
  var linha: Int = 0
  var coluna: Int = 0

  def proximoToken(): Token = {
    var char: Char = 0
    var simbolo: String = ""
    var lexema: String = ""

    while (!ControladorAutomato.isLexemaClassificado) {
      char = this.charTemporario.getOrElse(arquivo.next)
      simbolo = this.toSimbolo(char)
      this.charTemporario = None

      ControladorAutomato.vaiParaProximoEstado(simbolo)

      if (!ControladorAutomato.isLexemaClassificado) {
        lexema += char.toString
        this.atualizaPosicaoDoCursor(char)
      } else
        this.charTemporario = Some(char)
    }

    val tipoToken: TipoToken = ControladorAutomato.getTipoToken
    //if (!Seq(TipoToken.COMENTARIO, TipoToken.WHITE_SPACE).contains(tipoToken))
    new Token(tipoToken, lexema)
    //else null
  }

  def toSimbolo(char: Char): String = {
    char match {
      case _ if Character.isDigit(char) => "D"
      case _ if Character.isAlphabetic(char) => "L"
      case _ if Character.isWhitespace(char) => "F"
      case _ => char.toString
    }
  }

  def atualizaPosicaoDoCursor(caracter: Char): Unit = {
    this.coluna += 1
    if (caracter.equals('\n'))
      this.linha += 1
  }
}