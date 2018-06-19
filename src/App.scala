import lexico.AnalisadorLexico
import sintatico.AnalisadorSintatico

/**
  * Desenvolvedores:
  * Vagner Luciano da Costa Silva #201403469
  * Christian Kalombo Mudiany     #200904787
  */
object App {

  def main(args: Array[String]) {
    println("Digite o caminho do código fonte ...")

    //new AnalisadorSintatico(Console.readLine()).analisar()
    new AnalisadorSintatico("D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\codigo_teste.mgol").analisar()
    /*
   val lexico = new AnalisadorLexico("D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\codigo_teste.mgol")
    while (!lexico.leituraFinalizada) {
      println(lexico.proximoSimbolo())
    }
*/
  }
}
