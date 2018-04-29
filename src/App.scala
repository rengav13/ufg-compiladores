import lexico.TabelaTransicoes

import scala.io.Source

object App {
  def main(args: Array[String]) {

    print(TabelaTransicoes.proximo("D"))
    print(TabelaTransicoes.proximo("L"))
    print(TabelaTransicoes.proximo("D"))
    print(TabelaTransicoes.proximo("D"))
  }
}


//val lexico = new Lexico(".\\source_code.txt")

/*
while (true) {
  val comando = Console.readLine match {
    case "quit" => System.exit(0)
    case "p" => println(lexico.proximo)
    case _ =>
  }
}
*/

/*
class Lexico(source: String) {
  val arquivo = new Arquivo(source)

  def proximo(): String = {
    //Deve decidir entre D, L ou o restante dos caracteres

    arquivo.proximo.toString
  }
}
*/

class Arquivo(caminho: String) {
  val arquivo = Source.fromFile(caminho)

  def proximo(): Char = this.arquivo.next

  def fechar(): Unit = this.arquivo.close
}
