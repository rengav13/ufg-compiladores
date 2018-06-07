package sintatico

import sintatico.TipoAcao.{ACEITAR, EMPILHAR, ERRO, REDUZIR}

class Acao(tipo: String, valor: Int) {

  def this(tipo: String) = this(tipo, null.asInstanceOf[Int])

  def getValor: Int = this.valor

  def isReduzir: Boolean = REDUZIR.equals(tipo)

  def isEmpilhar: Boolean = EMPILHAR.equals(tipo)

  def isAceitar: Boolean = ACEITAR.equals(tipo)

  def isErro: Boolean = ERRO.equals(tipo)

  override def toString: String = s"[${this.tipo} ${this.valor}]"
}