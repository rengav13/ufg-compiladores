package lexico


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
  val TRASICOES: Map[Int, Map[String, Int]] =
    Map(
      0 -> Map(
        "D" -> 2,
        "L" -> 9,
        "F" -> 25,
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
      1 -> Map(),
      2 -> Map("D" -> 2, "E" -> 5, "." -> 3),
      3 -> Map("D" -> 4),
      4 -> Map("D" -> 4, "E" -> 5),
      5 -> Map("D" -> 7, "+" -> 6, "-" -> 6),
      6 -> Map("D" -> 7),
      7 -> Map("D" -> 7),
      8 -> Map(),
      9 -> Map("D" -> 9, "L" -> 9, "-" -> 9, "E" -> 9),
      10 -> Map(
        "D" -> 11,
        "L" -> 11,
        "F" -> 11,
        "<" -> 11,
        ">" -> 11,
        "=" -> 11,
        "E" -> 11,
        "+" -> 11,
        "-" -> 11,
        "*" -> 11,
        "/" -> 11,
        ";" -> 11,
        "\"" -> 12,
        "{" -> 11,
        "}" -> 11,
        "(" -> 11,
        ")" -> 11,
        "Q" -> 11
      ),
      11 -> Map(
        "D" -> 11,
        "L" -> 11,
        "F" -> 11,
        "<" -> 11,
        ">" -> 11,
        "=" -> 11,
        "E" -> 11,
        "+" -> 11,
        "-" -> 11,
        "*" -> 11,
        "/" -> 11,
        ";" -> 11,
        "\"" -> 12,
        "{" -> 11,
        "}" -> 11,
        "(" -> 11,
        ")" -> 11,
        "Q" -> 11),
      12 -> Map(),
      13 -> Map(
        "D" -> 14,
        "L" -> 14,
        "F" -> 14,
        "<" -> 14,
        ">" -> 14,
        "=" -> 14,
        "E" -> 14,
        "+" -> 14,
        "-" -> 14,
        "*" -> 14,
        "/" -> 14,
        ";" -> 14,
        "\"" -> 14,
        "{" -> 14,
        "}" -> 15,
        "(" -> 14,
        ")" -> 14,
        "Q" -> 14
      ),
      14 -> Map(
        "D" -> 11,
        "L" -> 11,
        "F" -> 11,
        "<" -> 11,
        ">" -> 11,
        "=" -> 11,
        "E" -> 11,
        "+" -> 11,
        "-" -> 11,
        "*" -> 11,
        "/" -> 11,
        ";" -> 11,
        "\"" -> 11,
        "{" -> 11,
        "}" -> 15,
        "(" -> 11,
        ")" -> 11,
        "Q" -> 11
      ),
      15 -> Map(),
      16 -> Map(),
      17 -> Map("<" -> 19, "=" -> 19),
      18 -> Map(">" -> 19, "=" -> 19, "-" -> 21),
      19 -> Map(),
      20 -> Map(),
      21 -> Map(),
      22 -> Map(),
      23 -> Map(),
      24 -> Map(),
      25 -> Map("F" -> 25)
    )

  def existeProximoEstado(estado: Int, entrada: String): Boolean = this.TRASICOES(estado).contains(entrada)

  def pegarProximoEstado(estado: Int, entrada: String): Int = this.TRASICOES(estado)(entrada)

  def isSimbolo(char: Char): Boolean = Seq("D", "L", "F", "<", ">", "=", "E", "+", "-", "*", "/", ";", "\"", "{", "}", "(", ")", ".", "Q").contains(char.toString)
}