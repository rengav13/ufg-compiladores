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

  //
  def proximoToken(): Token = {
    var char: Char = 0
    var simbolo: String = ""
    var lexema: String = ""

    //Enquanto o lexema não for classificado
    while (!ControladorAutomato.isLexemaClassificado && arquivo.hasNext) {
      char = this.charTemporario.getOrElse(arquivo.next)    //Lendo por caracteres de cada Token TODO Char por char do arquivo e não do token.
      simbolo = this.toSimbolo(char)                        //Passando o simbolo definido para o tipo de caracter lido TODO Converte char para simbolo interpretavel pelo automato
      this.charTemporario = None

      ControladorAutomato.vaiParaProximoEstado(simbolo)     //Com o simbolo o controladorAutomato nos passa o próximo estado do Automato

      if (!ControladorAutomato.isLexemaClassificado) {
        lexema += char.toString                             //lexema recebe a string dos caracteres lidos
        this.atualizaPosicaoDoCursor(char)                  //Ir para a próxima posição TODO: Atualiza posição da linha e da coluna no arquivo
      } else
        this.charTemporario = Some(char)
    }

    if (!arquivo.hasNext) {
      this.finalizouVarredura = true
      obtemToken(TipoToken.FIM_ARQUIVO, "EOF").orNull
    } else
      obtemToken(ControladorAutomato.getTipoToken, lexema).orNull
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