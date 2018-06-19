package lexico

object EstadosFinais {
  val ESTADOS_FINAIS: Map[Int, String] = Map(
    1 -> TipoSimbolo.OPERADOR_ARITMETICO,
    2 -> TipoSimbolo.NUMERO,
    4 -> TipoSimbolo.NUMERO,
    7 -> TipoSimbolo.NUMERO,
    8 -> TipoSimbolo.OPERADOR_ARITMETICO,
    9 -> TipoSimbolo.IDENTIFICADOR,
    11 -> TipoSimbolo.CONSTANTE_LITERAL,
    12 -> TipoSimbolo.CONSTANTE_LITERAL,
    14 -> TipoSimbolo.COMENTARIO,
    15 -> TipoSimbolo.COMENTARIO,
    16 -> TipoSimbolo.FIM_ARQUIVO,
    17 -> TipoSimbolo.OPERADOR_RELACIONAL,
    18 -> TipoSimbolo.OPERADOR_RELACIONAL,
    19 -> TipoSimbolo.OPERADOR_RELACIONAL,
    20 -> TipoSimbolo.OPERADOR_RELACIONAL,
    21 -> TipoSimbolo.ATRIBUICAO,
    22 -> TipoSimbolo.ABRE_PARENTESES,
    23 -> TipoSimbolo.FECHA_PARENTESES,
    24 -> TipoSimbolo.PONTO_VIRGULA,
    25 -> TipoSimbolo.WHITE_SPACE
  )

  def classificou(estado: Int): Boolean = this.ESTADOS_FINAIS.contains(estado)

  def getTipoSimbolo(estado: Int): String = this.ESTADOS_FINAIS(estado)
}
