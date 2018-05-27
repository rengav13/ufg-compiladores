import sintatico.AnalisadorSintatico

/**
  * Desenvolvedores:
  * Vagner Luciano da Costa Silva #201403469
  * Christian Kalombo Mudiany     #200904787
  */
object App {

  def main(args: Array[String]) {
    println("Digite o caminho do cÓdigo fonte ...")

    new AnalisadorSintatico(Console.readLine()).analisar()
  }
}