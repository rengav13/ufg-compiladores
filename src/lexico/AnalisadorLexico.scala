package lexico

import lexico.TipoSimbolo.{FIM_ARQUIVO, IDENTIFICADOR, WHITE_SPACE}
import utilitario.Cursor

import scala.io.{BufferedSource, Source}

class AnalisadorLexico(fonte: String) {
  val arquivo: BufferedSource = Source.fromFile(fonte)
  var lookAhead: Option[Char] = None
  val cursor: Cursor = new Cursor()

  def leituraFinalizada: Boolean = !arquivo.hasNext

  def proximoSimbolo(): Simbolo = {
    var entrada: Entrada = new Entrada()
    classificarSimbolo(entrada)

    if (leituraFinalizada) {
      return new Simbolo(FIM_ARQUIVO, "EOF")
    }

    val tipoSimbolo: String = ControladorAutomato.getTipoSimbolo
    if (WHITE_SPACE.equals(tipoSimbolo)) {
      return proximoSimbolo()
    }

    criarSimbolo(entrada, tipoSimbolo)
  }

  def classificarSimbolo(entrada: Entrada): Unit = {
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

  def criarSimbolo(entrada: Entrada, tipoSimbolo: String): Simbolo = {
    try {
      if (IDENTIFICADOR.equals(tipoSimbolo)) {
        TabelaSimbolos.inserir(new Simbolo(tipoSimbolo, entrada.lexema))
      }
      new Simbolo(tipoSimbolo, entrada.lexema)
    } catch {
      case e: Exception => throw new Exception(s"Erro identificado na linha ${this.cursor.linha} e na coluna ${this.cursor.coluna} : ${e.getMessage}")
    }
  }

  def getCursor: Cursor = this.cursor
}
