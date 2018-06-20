package sintatico

import comum.Simbolo

import scala.collection.mutable

class Pilha {

  var estados: mutable.Stack[Int] = new mutable.Stack[Int]()
  var simbolos: mutable.Stack[Simbolo] = new mutable.Stack[Simbolo]()

  this.estados.push(0)

  def empilhar(simbolo: Simbolo, estado: Int): Unit = {
    this.simbolos.push(simbolo)
    this.estados.push(estado)
  }

  def desempilhar(): Simbolo = {
    this.estados.pop()
    this.simbolos.pop()
  }

  def estado(): Int = {
    this.estados.top
  }

  def simbolo(): Simbolo = {
    this.simbolos.top
  }

  override def toString: String = s"${this.simbolos} ${this.estados}"
}
