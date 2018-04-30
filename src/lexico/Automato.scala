package lexico

object Automato {
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

  def hasProximoEstado(estado: Int, entrada: String): Boolean = this.TRASICOES(estado).contains(entrada)

  def getProximoEstado(estado: Int, entrada: String): Int = this.TRASICOES(estado)(entrada)
}