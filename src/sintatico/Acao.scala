package sintatico

import sintatico.TipoAcao.{ACEITAR, EMPILHAR, ERRO, REDUZIR}

class Acao(in: String) {
  val (tipo, valor) = toAcao(in)

  def getValor: Int = this.valor

  def isReduzir: Boolean = REDUZIR.equals(tipo)

  def isEmpilhar: Boolean = EMPILHAR.equals(tipo)

  def isAceitar: Boolean = ACEITAR.equals(tipo)

  def isErro: Boolean = ERRO.equals(tipo)

  def toAcao(in: String): (String, Int) = {
    in match {
      case _ if in.startsWith("S") => (in.substring(0, 1), in.substring(1, in.length).toInt)
      case _ if in.startsWith("R") => (in.substring(0, 1), in.substring(1, in.length).toInt)
      case _ if in.startsWith("ACC") => (in.substring(0, 3), null.asInstanceOf[Int])
      case _ if in.startsWith("ET") => (in.substring(0, 2), in.substring(2, in.length).toInt)
      case _ => throw new Exception("Ação não identificada: " + in)
    }
  }

  override def toString: String = s"[${this.tipo} ${this.valor}]"
}
