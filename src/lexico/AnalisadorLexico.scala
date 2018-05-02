package lexico

import lexico.TipoToken.TipoToken

import scala.io.{BufferedSource, Source}

/*
 * ERROS:
 *  - Não está identificando +1 como OPR: +; Num: 1
 *  - Não está tratando números em notação cientifica.
 *  - Não está identificando ERRO: 2A -> NUMERO: 2 e ID: A
 */
class AnalisadorLexico(fonte: String) {
  val arquivo: BufferedSource = Source.fromFile(fonte)
  var charTemporario: Option[Char] = None
  var finalizouVarredura: Boolean = false
  var linha: Int = 0
  var coluna: Int = 0

  def hasProximoToken: Boolean = !this.finalizouVarredura

  // Percorendo caractere por caractere do arquivo identifica e retorna se tiver o token.
  def proximoToken(): Token = {
    var char: Char = 0
    var simbolo: String = ""
    var lexema: String = ""

    // percorendo o caractere do arquivo transitando entre os estados do automato até a classificaçao do lexema
    while (!ControladorAutomato.isLexemaClassificado && arquivo.hasNext) {
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



    if (!arquivo.hasNext) {
      this.finalizouVarredura = true
      obtemToken(TipoToken.FIM_ARQUIVO, "EOF").orNull
    } else {
      val tipoToken: TipoToken = ControladorAutomato.getTipoToken

      if (TipoToken.IDENTIFICADOR.equals(tipoToken)) {
        TabelaSimbolos.inserir(obtemToken(tipoToken, lexema).orNull)
      } else {
        obtemToken(tipoToken, lexema).orNull
      }
    }
  }

  def obtemToken(tipoToken: TipoToken, lexema: String): Option[Token] = {
    tipoToken match {
      case TipoToken.ERRO =>
        println(s"Foi encontrado um erro na linha ${this.linha} e na coluna ${this.coluna}")
        None
      case TipoToken.COMENTARIO => None
      case TipoToken.WHITE_SPACE => None
      case _ => Some(new Token(tipoToken, lexema))
    }
  }

  //Função para categorizar o tipo de caracter lido associando eles a um simbolo
  def toSimbolo(char: Char): String = {
    char match {
      case _ if Character.isDigit(char) => "D"
      case _ if Character.isAlphabetic(char) => "L"
      case _ if Character.isWhitespace(char) => "F"
      case _ if char == 0 => "EOF"
      case _ if !Automato.isSimbolo(char) => "Q"
      case _ => char.toString
    }
  }

  def atualizaPosicaoDoCursor(caracter: Char): Unit = {
    this.coluna += 1
    if (caracter.equals('\n')) {
      this.coluna = 0
      this.linha += 1
    }
  }
}