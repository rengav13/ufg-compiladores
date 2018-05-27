package sintatico

class Producao(produtor: String, produzido: String, tamanho: Int) {

  def getTamanho: Int = tamanho

  def getProdutor: String = this.produtor

  override def toString: String = s"${this.produtor} -> ${this.produzido}"
}