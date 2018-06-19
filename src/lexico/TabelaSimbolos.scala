package lexico

import scala.collection.mutable

object TabelaSimbolos {

  var TABELA: mutable.Map[String, Simbolo] = mutable.Map[String, Simbolo](
    "inicio" -> new Simbolo(TipoSimbolo.INICIO, "inicio"),
    "varinicio" -> new Simbolo(TipoSimbolo.VAR_INICIO, "varinicio"),
    "varfim" -> new Simbolo(TipoSimbolo.VAR_FIM, "varfim"),
    "escreva" -> new Simbolo(TipoSimbolo.ESCREVA, "escreva"),
    "leia" -> new Simbolo(TipoSimbolo.LEIA, "leia"),
    "se" -> new Simbolo(TipoSimbolo.SE, "se"),
    "entao" -> new Simbolo(TipoSimbolo.ENTAO, "entao"),
    "fimse" -> new Simbolo(TipoSimbolo.FIM_SE, "fimse"),
    "fim" -> new Simbolo(TipoSimbolo.FIM, "fim"),
    "Inteiro" -> new Simbolo(TipoSimbolo.INTEIRO, "Inteiro"),
    "literal" -> new Simbolo(TipoSimbolo.LITERAL, "literal"),
    "real" -> new Simbolo(TipoSimbolo.REAL, "real")
  )

  def inserir(simbolo: Simbolo): Unit = {
    if (simbolo != null)
      this.TABELA += (simbolo.lexema -> simbolo)
  }

  def imprimir(): Unit = println(this.TABELA)
}
