package lexico

object Automato {
  val TRASICOES: Map[Int, Map[String, Int]] =
    Map(
      0 -> Map(
        "D" -> 1,
        "L" -> 9,
        '"' -> 7,
        "<" -> 13,
        ">" -> 17,
        "=" -> 19,
        "E" -> ,
        "+" -> 20,
        "-" -> ,
        "*" -> 22,
        "/" -> 23,
        ";" -> 12,
        "EOF" -> 11,
        "{" -> 10,
        "}" -> ,
        "(" -> 24,
        ")" -> 25,
      ),
      1 -> Map(
        "D" -> 1,
        "." -> 2,
        "E" -> 4
      ),
      2 -> Map("D" -> 3),
      3 -> Map(
        "D" -> 3,
        "E"-> 4
      ),
      4 -> Map(
        "D" -> 6,
        "-" -> 5,
        "+" -> 5
      ),
      5 -> Map("D" -> 6),
      6 -> Map("D" -> 6),
      7 -> Map('"' -> 8),
      8 -> Map(),
      9 -> Map(
        "D" -> 9,
        "L" -> 9,
        "-" -> 9
      ),
      10 -> Map("D" -> 10,
        "L" -> 10,
        "}"-> 0, "<" -> 10,
        ">" -> 10,
        "=" -> 10,
        "E" -> 10,
        "+" -> 10,
        "-" -> 10,
        "*" -> 10,
        "/" -> 10,
        ";" -> 10,
        "{" -> 10,
        "(" -> 10,
        ")" -> 10),
      11 -> Map(),
      12 -> Map(),
      13 -> Map("-" -> 14,
        "=" -> 16,
        ">" -> 15
      ),
      14 -> Map(),
      15 -> Map(),
      16 -> Map(),
      17 -> Map("=" -> 18),
      18 -> Map(),
      19 -> Map(),
      20 -> Map(),
      21 -> Map(),
      22 -> Map(),
      23 -> Map(),
      24 -> Map(),
      25 -> Map(),
    )

  def hasProximoEstado(estado: Int, entrada: String): Boolean = this.TRASICOES(estado).contains(entrada)

  def getProximoEstado(estado: Int, entrada: String): Int = this.TRASICOES(estado)(entrada)
}
