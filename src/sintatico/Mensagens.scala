package sintatico

object Mensagens {

  val mensagens: Map[Int, String] = Map(
    0 -> "O codigo deverá iniciar com palavra: inicio",
    1 -> "Espera-se um terminador de cadeia",
    2 -> "Esperava-se ler: varinicio",
    3 -> "Esperava-se ler: identificador, leia, escreva, se ou fim",
    4 -> "Esperava-se ler: varfim ou identificador",
    5 -> "Esperava-se ler: identificador, leia, escreva, se ou fim",
    6 -> "Esperava-se ler: varfim ou identificador",
    7 -> "Esperava-se ler: ;",
    8 -> "Esperava-se ler: inteiro, real, literal ou constante númerica",
    12 -> "Esperava-se ler: varfim ou identificador",
    13 -> "Esperava-se ler: ;",
    16 -> "Esperava-se ler um terminador de cadeia",
    21 -> "Esperava-se ler: identificado",
    23 -> "Esperava-se ler: identificador, leia, escreva, se, fimse, fim",
    24 -> "Esperava-se ler: identificador, literal ou constante númerica",
    30 -> "Esperava-se ler uma atribuição",
    31 -> "Esperava-se ler: identificador ou um numero",
    34 -> "Esperava-se ler: identificador, ) ou ;",
    36 -> "Esperava-se ler: ;",
    39 -> "Esperava-se ler: identificador, leia, escreva, se ou fimse",
    40 -> "Esperava-se ler: ( ou )",
    42 -> "Esperava-se ler um operador aritmetico",
    44 -> "Esperava-se ler: (",
    46 -> "Esperava-se ler: entao",
    47 -> "Esperava-se ler: identificador, leia, escreva, se ou fimse",
  )

  def get(key: Int): String = {
    if (this.mensagens.contains(key))
      this.mensagens(key)
    else
      null
  }
}
