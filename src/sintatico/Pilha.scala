package sintatico

import lexico.Token

import scala.collection.mutable

class Pilha {

  var estados: mutable.Stack[Int] = new mutable.Stack[Int]()
  var tokens: mutable.Stack[Token] = new mutable.Stack[Token]()

  this.estados.push(0)

  def empilhar(token: Token, estado: Int): Unit = {
    this.tokens.push(token)
    this.estados.push(estado)
  }

  def desempilhar(): Unit = {
    this.tokens.pop()
    this.estados.pop()
  }

  def estado(): Int = {
    this.estados.top
  }

}
