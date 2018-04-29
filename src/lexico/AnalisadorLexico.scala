package lexico

import scala.io.Source

class AnalisadorLexico(fonte: String) {
  val arquivo = Source.fromFile(fonte)

  def proximo = {
    var palavra:String = ""
    var tmp:String = arquivo.next().toString()

    while (TabelaTransicoes.proximo(tmp).isEmpty) {

      tmp = arquivo.next().toString()
    }

  }



}
