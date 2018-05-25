package lexico

object ErrosPorEstado {
  val ESTADOS_FINAIS: Map[Int, String] = Map(
    0 -> "Caracter inválido.",
    3 -> "Valor númerico inválido, é necessário ter dígitos depois do ponto.",
    5 -> "Valor númerico inválido, é necessário ter dígitos depois do símbolo E.",
    6 -> "Valor númerico inválido, é necessário ter dígitos depois do sinal (+/-).",
    10 -> "String literal inválida, é necessário fechar as aspas.",
    13 -> "Comentário inválido, é necessário fechar }."
  )

  def pegarErro(estado: Int): String = this.ESTADOS_FINAIS(estado)
}
