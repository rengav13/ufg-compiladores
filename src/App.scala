import lexico.AnalisadorLexico

//Localizando e Carregando o arquivo .txt da linguagem Mgol a ser analizado

object App {
  def main(args: Array[String]) {
    val lexico = new AnalisadorLexico("D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\codigo_teste.mgol")
    
     
    while (true) {                      
      Console.readLine match          //Enquanto estiver lendo o arquivo
      {
        case "quit" => System.exit(0)  //quit para sair 
        case _ => println(lexico.proximoToken())
      }
    }
  }
}
