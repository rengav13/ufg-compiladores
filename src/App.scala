import lexico.AnalisadorLexico

object App {
  def main(args: Array[String]) {
    val lexico = new AnalisadorLexico("D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\codigo_teste.mgol")

    while (true) {
      Console.readLine match {
        case "quit" => System.exit(0)
        case _ => println(lexico.proximoToken())
      }
    }
  }
}