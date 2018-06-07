package sintatico

object Mensagens {

  val mensagens: Map[Int, String] = Map(
    0 -> "Simbolo esperado ser lido neste estado: Inicio",
    1 -> "Simbolo aceito neste estado:  $",
    2 -> "Simbolo esperado ser lido neste estado: Varinicio",
    3 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fim",
    4 -> "Simbolo esperado ser lido neste estado: Varfim Id",
    5 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fim",
    6 -> "Simbolo esperado ser lido neste estado: Varfim Id",
    7 -> "Simbolo esperado ser lido neste estado: ;",
    8 -> "Simbolo esperado ser lido neste estado: Int Real Literal",
    5 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fim",
    5 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fim",
    7 -> "Simbolo esperado ser lido neste estado: ;",
    12 -> "Redução nos simbolos neste estado: Varfim Id",
    13 -> "Redução nos simbolos neste estado: ;",
    13 -> "Redução nos simbolos neste estado: ;",
    13 -> "Redução nos simbolos neste estado: ;",
    16 -> "Redução no simbolos neste estado: $",
    3 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fim",
    3 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fim",
    3 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fim",
    16 -> "Redução no simbolos neste estado: $",
    21 -> "Simbolo esperado ser lido neste estado: Id",
    7 -> "Simbolo esperado ser lido neste estado: ;",
    23 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    24 -> "Simbolo esperado ser lido neste estado: Id Literal num",
    7 -> "Simbolo esperado ser lido neste estado: ;",
    23 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    13 -> "Redução nos simbolos neste estado: ;",
    13 -> "Redução nos simbolos neste estado: ;",
    13 -> "Redução nos simbolos neste estado: ;",
    30 -> "Simbolo esperado ser lido neste estado: rcb",
    31 -> "Simbolo esperado ser lido neste estado: Id num",
    7 -> "Simbolo esperado ser lido neste estado: ;",
    23 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    34 -> "Redução nos simbolos neste estado: Id ) opr opm ;",
    34 -> "Redução nos simbolos neste estado: Id ) opr opm ;",
    36 -> "Simbolo esperado ser lido neste estado: opm e Redução nos simbolos neste estado ;",
    31 -> "Simbolo esperado ser lido neste estado: Id num",
    13 -> "Redução nos simbolos neste estado: ;",
    39 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fimse",
    40 -> "Simbolo esperado ser lido neste estado: (",
    31 -> "Simbolo esperado ser lido neste estado: Id num",
    42 -> "Simbolo esperado ser lido neste estado: opr",
    31 -> "Simbolo esperado ser lido neste estado: Id num",
    44 -> "Redução no simbolo neste estado: (",
    7 -> "Simbolo esperado ser lido neste estado: ;",
    46 -> "Simbolo esperado ser lido neste estado: então",
    47 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse",
    16 -> "Redução no simbolos neste estado: $",
    16 -> "Redução no simbolos neste estado: $",
    16 -> "Redução no simbolos neste estado: $",
    23 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    39 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fimse",
    39 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fimse",
    39 -> "Simbolo esperado ser lido neste estado: Id Leia Escreva Se Fimse",
    55 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    56 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    57 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    58 -> "Redução nos simbolos neste estado: Id Leia Escreva Se Fimse Fim",
    59 -> "Simbolo não terminal não identificado"
  )

  def get(key: Int): String = {
    if (this.mensagens.contains(key))
      this.mensagens(key)
    else
      null
  }
}
