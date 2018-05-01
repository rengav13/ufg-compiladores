package lexico

import scala.io.{BufferedSource, Source}

class AnalisadorLexico(fonte: String) {
  val arquivo: BufferedSource = Source.fromFile(fonte)
  var linha: Int = 0
  var coluna: Int = 0

  //Percorrendo o arquivo caractere por caractere, associando ele a um simbolo identificado usando a Função ToSimbolo:
  def proximoToken(): Token = {
    var char: Char = arquivo.next()
    var simbolo: String = this.toSimbolo(char)
    var lexema: String = char.toString

    // Enquanto o lexema não for classificado 
    while (!ControladorAutomato.isLexemaClassificado) {
      char = arquivo.next()                //Lendo por caracteres de cada Token        
      simbolo = this.toSimbolo(char)       //Passando o simbolo definido para o tipo de caracter lido
      this.atualizaPosicao(char)           //Ir para a próxima posição 
      lexema += char.toString              //lexema recebe a string dos caracteres lidos
      
      ControladorAutomato.vaiParaProximoEstado(simbolo)   //Com o simbolo o controladorAutomato nos passa o próximo estado do Automato
    }
    new Token(ControladorAutomato.getTipoToken, lexema)  //Associando o tipo do Token ao lexema
  }

  //Função para categorizar o tipo de caracter lido assiciando eles a um simbolo  
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
