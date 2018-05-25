import lexico.{AnalisadorLexico, TabelaSimbolos}

/**
  * Desenvolvedores:
  *   Vagner Luciano da Costa Silva #201403469
  *   Christian Kalombo Mudiany     #200904787
  */
object App {
  def main(args: Array[String]) {
    println("Digite o caminho do cÓdigo fonte ...")
    val lexico = new AnalisadorLexico(Console.readLine())
    println("Arquivo carregado com sucesso!")
    println()
    println("Digite enter para identificar o proximo caracter")
    while (true) {
      Console.readLine match {
        case "quit" => System.exit(0)
        case _ if lexico.hasProximoToken => println(lexico.proximoToken())
        case _ =>
          print("Código fonte finalizado")
          TabelaSimbolos.imprimir()
          System.exit(0)
      }
    }
  }
}