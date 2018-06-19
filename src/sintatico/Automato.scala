package sintatico

import lexico.TipoSimbolo.toTipoSimbolo
import utilitario.MontadorTabela

object Automato {

  val TRASICOES_TERMINAIS: Map[Int, Map[String, Acao]] = TabelaAutomato.terminais()
  val TRASICOES_NAO_TERMINAIS: Map[Int, Map[String, Int]] = TabelaAutomato.naoTerminais()

  def obterAcao(estado: Int, tipoSimbolo: String): Acao = this.TRASICOES_TERMINAIS(estado)(tipoSimbolo)

  def desviar(estado: Int, tipoSimbolo: String): Int = this.TRASICOES_NAO_TERMINAIS(estado)(tipoSimbolo)
}

object TabelaAutomato {

  val CAMINHO_TABELA_NAO_TERMINAIS: String = "D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\sintatico\\TABELA_NAO_TERMINAIS.csv"
  val CAMINHO_TABELA_TERMINAIS: String = "D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\sintatico\\TABELA_TERMINAIS.csv"

  def naoTerminais(): Map[Int, Map[String, Int]] = {
    new MontadorTabela(CAMINHO_TABELA_NAO_TERMINAIS).montarTabela[Int, String, Int](_.toInt, _.toString, _.toInt)
  }

  def terminais(): Map[Int, Map[String, Acao]] = {
    new MontadorTabela(CAMINHO_TABELA_TERMINAIS).montarTabela[Int, String, Acao](_.toInt, toTipoSimbolo, new Acao(_))
  }
}