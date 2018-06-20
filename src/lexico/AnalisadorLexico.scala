package lexico

import comum.TipoSimboloTerminal.{FIM_ARQUIVO, IDENTIFICADOR, NUMERO, WHITE_SPACE}
import comum.{Simbolo, TabelaSimbolos, TipoSimboloTerminal}

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

    val (estado: Int, tipoSimbolo: String) = ControladorAutomato.getTipoSimbolo
    if (WHITE_SPACE.equals(tipoSimbolo)) {
      return proximoSimbolo()
    }

    criarSimbolo(entrada, estado, tipoSimbolo)
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

  def criarSimbolo(entrada: Entrada, estado: Int, tipoSimbolo: String): Simbolo = {
    try {
      if (IDENTIFICADOR.equals(tipoSimbolo)) {
        val simbolo: Simbolo = new Simbolo(tipoSimbolo, entrada.lexema)
        TabelaSimbolos.inserir(simbolo)
        simbolo
      } else if (NUMERO.equals(tipoSimbolo)) {
        new Simbolo(tipoSimbolo, entrada.lexema, EstadosFinais.getTipoConstanteNumerica(estado))
      } else {
        new Simbolo(tipoSimbolo, entrada.lexema)
      }
    } catch {
      case e: Exception => throw new Exception(s"Erro identificado na linha ${this.cursor.linha} e na coluna ${this.cursor.coluna} : ${e.getMessage}")
    }
  }

  def getCursor: Cursor = this.cursor
}
