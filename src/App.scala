import lexico.{AnalisadorLexico, TabelaSimbolos}

object App {
  def main(args: Array[String]) {
    val lexico = new AnalisadorLexico("D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\codigo_teste.mgol")

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