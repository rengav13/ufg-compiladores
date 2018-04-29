package lexico

object TabelaTransicoes {
  var estado: Int = 0

  val TRASICOES: Map[Int, Map[String, Int]] =
    Map(
      0 -> Map(
        "D" -> 2,
        "L" -> 9,
        "F" -> 0,
        "<" -> 18,
        ">" -> 17,
        "=" -> 20,
        "E" -> 9,
        "+" -> 1,
        "-" -> 1,
        "*" -> 8,
        "/" -> 8,
        ";" -> 24,
        "EOF" -> 16,
        "\"" -> 10,
        "{" -> 13,
        "(" -> 22,
        ")" -> 23
      ),
      1 -> Map("D" -> 2),
      2 -> Map("D" -> 2, "E" -> 5, "." -> 3),
      3 -> Map("D" -> 4),
      4 -> Map("D" -> 4, "E" -> 5),
      5 -> Map("D" -> 7, "+" -> 6, "-" -> 6),
      6 -> Map("D" -> 7),
      7 -> Map("D" -> 7),
      8 -> Map(),
      9 -> Map("D" -> 9, "L" -> 9, "-" -> 9),
      10 -> Map("." -> 11),
      11 -> Map("\"" -> 12, "." -> 11),
      12 -> Map(),
      13 -> Map("." -> 14),
      14 -> Map("." -> 14),
      15 -> Map(),
      16 -> Map(),
      17 -> Map("<" -> 19, "=" -> 19),
      18 -> Map(">" -> 19, "=" -> 19, "-" -> 21),
      19 -> Map(),
      20 -> Map(),
      21 -> Map(),
      22 -> Map(),
      23 -> Map(),
      24 -> Map()
    )

  val ESTADOS_FINAIS: Map[Int, String] = Map(
    0 -> "FIM_PALAVRA",
    1 -> "OPM",
    2 -> "Num",
    4 -> "Num",
    7 -> "Num",
    8 -> "OPM",
    9 -> "id",
    11 -> "Literal",
    15 -> "Comentario",
    16 -> "EOF",
    17 -> "OPR",
    18 -> "OPR",
    19 -> "OPR",
    20 -> "OPR",
    21 -> "RCB",
    22 -> "AB_P",
    23 -> "FC_P",
    24 -> "PT_V",
  )

  val PALAVRAS_RESERVADAS = List[String](
    "inicio",
    "varinicio",
    "varfim",
    "escreva",
    "leia",
    "se",
    "entao",
    "senao",
    "fimse",
    "fim",
    "Inteiro",
    "literal",
    "real"
  )

  def proximo(entrada: String): Option[String] = {
    if (this.hasProximoEstado(entrada)) {
      this.estado = this.TRASICOES(this.estado)(entrada)
      return None
    } else if (!this.isEstadoFinal(this.estado)) {
      this.estado = 0
      return Some("ERROR")
    } else if (this.isEstadoFinal(this.estado)) {
      val retorno:String = this.ESTADOS_FINAIS(this.estado)
      this.estado = 0

      if (retorno.eq("FIM_PALAVRA") || retorno.eq("Comentario"))
        return Some("")
      else if (retorno.eq("id") && this.isPalavraReservada(retorno))
        return null //Some(this.PALAVRAS_RESERVADAS(retorno))
    }
    return None
  }

  def hasProximoEstado(entrada: String): Boolean = {
    this.TRASICOES(this.estado).contains(entrada)
  }

  def isEstadoFinal(estado: Int): Boolean = this.ESTADOS_FINAIS.contains(this.estado)

  def isPalavraReservada(id: String): Boolean = this.PALAVRAS_RESERVADAS.contains(id)
}