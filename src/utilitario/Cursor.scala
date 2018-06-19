package utilitario

class Cursor {
  var linha: Int = 1
  var coluna: Int = 1

  def atualizar(caracter: Char): Unit = {
    this.coluna += 1
    if (caracter.equals('\n')) {
      this.coluna = 1
      this.linha += 1
    }
  }
}
