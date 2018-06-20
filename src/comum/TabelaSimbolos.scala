package comum

import scala.collection.mutable

object TabelaSimbolos {

  var TABELA: mutable.Map[String, Simbolo] = mutable.Map[String, Simbolo](
    "inicio" -> new Simbolo(PalavrasReservadas.INICIO, "inicio"),
    "varinicio" -> new Simbolo(PalavrasReservadas.VAR_INICIO, "varinicio"),
    "varfim" -> new Simbolo(PalavrasReservadas.VAR_FIM, "varfim"),
    "escreva" -> new Simbolo(PalavrasReservadas.ESCREVA, "escreva"),
    "leia" -> new Simbolo(PalavrasReservadas.LEIA, "leia"),
    "se" -> new Simbolo(PalavrasReservadas.SE, "se"),
    "entao" -> new Simbolo(PalavrasReservadas.ENTAO, "entao"),
    "fimse" -> new Simbolo(PalavrasReservadas.FIM_SE, "fimse"),
    "fim" -> new Simbolo(PalavrasReservadas.FIM, "fim"),
    "Inteiro" -> new Simbolo(PalavrasReservadas.INTEIRO, "Inteiro"),
    "literal" -> new Simbolo(PalavrasReservadas.LITERAL, "literal"),
    "real" -> new Simbolo(PalavrasReservadas.REAL, "real")
  )

  def inserir(simbolo: Simbolo): Unit = {
    if (simbolo != null && !this.TABELA.contains(simbolo.lexema))
      this.TABELA += (simbolo.lexema -> simbolo)
  }

  def get(simbolo: Simbolo): Simbolo = {
    this.TABELA(simbolo.lexema)
  }

  def imprimir(): Unit = println(this.TABELA)
}
