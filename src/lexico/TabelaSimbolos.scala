package lexico

import scala.collection.mutable

object TabelaSimbolos {

  var TABELA: mutable.Map[String, Token] = mutable.Map[String, Token](
    "inicio" -> new Token(TipoToken.INICIO, "inicio"),
    "varinicio" -> new Token(TipoToken.VAR_INICIO, "varinicio"),
    "varfim" -> new Token(TipoToken.VAR_FIM, "varfim"),
    "escreva" -> new Token(TipoToken.ESCREVA, "escreva"),
    "leia" -> new Token(TipoToken.LEIA, "leia"),
    "se" -> new Token(TipoToken.SE, "se"),
    "entao" -> new Token(TipoToken.ENTAO, "entao"),
    "fimse" -> new Token(TipoToken.FIM_SE, "fimse"),
    "fim" -> new Token(TipoToken.FIM, "fim"),
    "Inteiro" -> new Token(TipoToken.INTEIRO, "Inteiro"),
    "literal" -> new Token(TipoToken.LITERAL, "literal"),
    "real" -> new Token(TipoToken.REAL, "real")
  )

  def inserir(token: Token): Unit = {
    if (token != null)
      this.TABELA += (token.lexema -> token)
  }

  def imprimir(): Unit = println(this.TABELA)
}
