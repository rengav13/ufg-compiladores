package sintatico

import lexico.TipoToken.TipoToken

/*
 * Significados dos simbolos:
 *  D: Digito [0-9]
 *  E: Letra ou parte da notação cientifica de um número.
 *  L: Letra  [a-zA-Z]
 *  F: Whitespace. Ex.: \n \r \t ' ' e etc...
 *  EOF: Fim de arquivo
 *  Q: Qualquer caracter
 */
object Automato {

  val TRASICOES_TERMINAIS: Map[Int, Map[TipoToken, Acao]] = Map(

  )

  val TRASICOES_NAO_TERMINAIS: Map[Int, Map[String, Int]] = Map(


  )

  def obterAcao(estado: Int, token: TipoToken): Acao = this.TRASICOES_TERMINAIS(estado)(token)

  def desviar(estado: Int, simbolo: String): Int = this.TRASICOES_NAO_TERMINAIS(estado)(simbolo)
}