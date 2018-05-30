package sintatico

import lexico.TipoToken
import lexico.TipoToken.TipoToken

import scala.io.BufferedSource

class MontadorTabela {

  val SEPARADOR_ARQUIVO_CSV: String = ","
  val CAMINHO_TABELA_NAO_TERMINAIS: String = "D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\sintatico\\TABELA_NAO_TERMINAIS.csv"
  val CAMINHO_TABELA_TERMINAIS: String = "D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\sintatico\\TABELA_TERMINAIS.csv"

  def montarTabelaNaoTerminais(): Map[Int, Map[String, Int]] = {
    this.montarTabela[Int, String, Int](CAMINHO_TABELA_NAO_TERMINAIS, _.toInt, _.toString, _.toInt)
  }

  def montarTabelaTerminais(): Map[Int, Map[TipoToken, Acao]] = {
    this.montarTabela[Int, TipoToken, Acao](CAMINHO_TABELA_TERMINAIS, _.toInt, toTipoToken, toAcao)
  }

  def toTipoToken(in: String): TipoToken = {
    in match {
      case _ if TipoToken.NUMERO.lexema.equals(in) => TipoToken.NUMERO
      case _ if TipoToken.CONSTANTE_LITERAL.lexema.equals(in) => TipoToken.CONSTANTE_LITERAL
      case _ if TipoToken.IDENTIFICADOR.lexema.equals(in) => TipoToken.IDENTIFICADOR
      case _ if TipoToken.COMENTARIO.lexema.equals(in) => TipoToken.COMENTARIO
      case _ if TipoToken.FIM_ARQUIVO.lexema.equals(in) => TipoToken.FIM_ARQUIVO
      case _ if TipoToken.OPERADOR_RELACIONAL.lexema.equals(in) => TipoToken.OPERADOR_RELACIONAL
      case _ if TipoToken.ATRIBUICAO.lexema.equals(in) => TipoToken.ATRIBUICAO
      case _ if TipoToken.OPERADOR_ARITMETICO.lexema.equals(in) => TipoToken.OPERADOR_ARITMETICO
      case _ if TipoToken.ABRE_PARENTESES.lexema.equals(in) => TipoToken.ABRE_PARENTESES
      case _ if TipoToken.FECHA_PARENTESES.lexema.equals(in) => TipoToken.FECHA_PARENTESES
      case _ if TipoToken.PONTO_VIRGULA.lexema.equals(in) => TipoToken.PONTO_VIRGULA
      case _ if TipoToken.WHITE_SPACE.lexema.equals(in) => TipoToken.WHITE_SPACE
      case _ if TipoToken.ERRO.lexema.equals(in) => TipoToken.ERRO
      case _ if TipoToken.INICIO.lexema.equals(in) => TipoToken.INICIO
      case _ if TipoToken.VAR_INICIO.lexema.equals(in) => TipoToken.VAR_INICIO
      case _ if TipoToken.VAR_FIM.lexema.equals(in) => TipoToken.VAR_FIM
      case _ if TipoToken.ESCREVA.lexema.equals(in) => TipoToken.ESCREVA
      case _ if TipoToken.LEIA.lexema.equals(in) => TipoToken.LEIA
      case _ if TipoToken.SE.lexema.equals(in) => TipoToken.SE
      case _ if TipoToken.ENTAO.lexema.equals(in) => TipoToken.ENTAO
      case _ if TipoToken.FIM_SE.lexema.equals(in) => TipoToken.FIM_SE
      case _ if TipoToken.FIM.lexema.equals(in) => TipoToken.FIM
      case _ if TipoToken.INTEIRO.lexema.equals(in) => TipoToken.INTEIRO
      case _ if TipoToken.LITERAL.lexema.equals(in) => TipoToken.LITERAL
      case _ if TipoToken.REAL.lexema.equals(in) => TipoToken.REAL
      case _ => throw new Exception("Tipo de simbolo inválido: " + in)
    }
  }

  def toAcao(in: String): Acao = {
    in match {
      case _ if in.startsWith("S") => new Acao(in.substring(0, 1), in.substring(1, in.length).toInt)
      case _ if in.startsWith("R") => new Acao(in.substring(0, 1), in.substring(1, in.length).toInt)
      case _ if in.startsWith("ACC") => new Acao(in.substring(0, 3))
      case _ => throw new Exception("Por favor verifique as informações da tabela de símbolos terminais: " + in)
    }
  }

  private def montarTabela[T, U, V](caminhoTabela: String, c1: (String) => T, c2: (String) => U, c3: (String) => V): Map[T, Map[U, V]] = {
    val bufferCSV: BufferedSource = this.carregarCSV(caminhoTabela)
    val arquivoCSV: Iterator[String] = bufferCSV.getLines()

    var mapa: Map[T, Map[U, V]] = Map()
    var chaves = arquivoCSV.next().split(SEPARADOR_ARQUIVO_CSV)

    while (arquivoCSV.hasNext) {
      val colunas = arquivoCSV.next().split(SEPARADOR_ARQUIVO_CSV)
      var mapaTmp = Map[U, V]()
      for (i <- 1 until colunas.length) {
        if (!colunas(i).equals("")) {
          mapaTmp = mapaTmp + (c2(chaves(i)) -> c3(colunas(i)))
        }
      }
      mapa = mapa + (c1(colunas(0)) -> mapaTmp)
    }
    bufferCSV.close
    mapa
  }

  private def carregarCSV(caminho: String): BufferedSource = {
    io.Source.fromFile(caminho)
  }
}
