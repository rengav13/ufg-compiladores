package lexico

import lexico.TipoToken.TipoToken

object EstadosFinais {
  val ESTADOS_FINAIS: Map[Int, TipoToken.TipoToken] = Map(
    1 -> TipoToken.OPERADOR_ARITMETICO,
    2 -> TipoToken.NUMERO,
    4 -> TipoToken.NUMERO,
    7 -> TipoToken.NUMERO,
    8 -> TipoToken.OPERADOR_ARITMETICO,
    9 -> TipoToken.IDENTIFICADOR,
    11 -> TipoToken.LITERAL,
    15 -> TipoToken.COMENTARIO,
    16 -> TipoToken.FIM_ARQUIVO,
    17 -> TipoToken.OPERADOR_RELACIONAL,
    18 -> TipoToken.OPERADOR_RELACIONAL,
    19 -> TipoToken.OPERADOR_RELACIONAL,
    20 -> TipoToken.OPERADOR_RELACIONAL,
    21 -> TipoToken.ATRIBUICAO,
    22 -> TipoToken.ABRE_PARENTESES,
    23 -> TipoToken.FECHA_PARENTESES,
    24 -> TipoToken.PONTO_VIRGULA
  )

  def isFinal(estado: Int): Boolean = this.ESTADOS_FINAIS.contains(estado)

  def getTipoToken(estado: Int): TipoToken = this.ESTADOS_FINAIS(estado)
}
