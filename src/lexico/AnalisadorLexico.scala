package lexico

import lexico.TipoToken.{IDENTIFICADOR, TipoToken}

import scala.io.{BufferedSource, Source}

class AnalisadorLexico(fonte: String) {
  val arquivo: BufferedSource = Source.fromFile(fonte)
  var lookAhead: Option[Char] = None
  val cursor: Cursor = new Cursor()

  def leituraFinalizada: Boolean = !arquivo.hasNext

  def proximoToken(): Token = {
    var entrada: Entrada = new Entrada()
    classificarToken(entrada)

    if (leituraFinalizada) {
      new Token(TipoToken.FIM_ARQUIVO, "EOF")
    }

    criarToken(entrada)
  }

  def classificarToken(entrada: Entrada): Unit = {
    while (ControladorAutomato.lexemaNaoFoiClassificado && arquivo.hasNext) {
      entrada.caracter(this.lookAhead.getOrElse(arquivo.next))
      this.lookAhead = None

      ControladorAutomato.irParaProximoEstado(entrada.simbolo)

      if (ControladorAutomato.lexemaNaoFoiClassificado) {
        entrada.concatenarLexema()
        this.cursor.atualizar(entrada.char)
      } else {
        this.lookAhead = Some(entrada.char)
      }
    }
  }

  def criarToken(entrada: Entrada): Token = {
    try {
      val tipoToken: TipoToken = ControladorAutomato.getTipoToken
      if (IDENTIFICADOR.equals(tipoToken)) {
        TabelaSimbolos.inserir(new Token(tipoToken, entrada.lexema))
      }
      new Token(tipoToken, entrada.lexema)
    } catch {
      case e: Exception => throw new Exception(s"Erro identificado na linha ${this.cursor.linha} e na coluna ${this.cursor.coluna} : ${e.getMessage}")
    }
  }

}
