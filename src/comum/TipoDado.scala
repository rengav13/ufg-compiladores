package comum

object TipoDado {
  val INTEIRO = "int"
  val LITERAL = "literal"
  val REAL = "double"

  def get(tipo: String): String = {
    tipo match {
      case "inteiro" => INTEIRO
      case "literal" => LITERAL
      case "real" => REAL
      case _ => throw new Exception("Erro: Tipo de dado não é reconhecido")
    }
  }

  def isEquivalente(tipo1: String, tipo2: String): Boolean = {
    if (isNumerico(tipo1) && isNumerico(tipo2))
      true
    else if (LITERAL.equals(tipo1) && LITERAL.equals(tipo2))
      true
    else
      false
  }

  def isNumerico(tipo: String): Boolean =
    tipo match {
      case INTEIRO => true
      case REAL => true
      case _ => false
    }

  def getTipoComPrecedencia(tipo1: String, tipo2: String): String = {
    if (REAL.equals(tipo1) || REAL.equals(tipo2))
      REAL
    else if (INTEIRO.equals(tipo1) || INTEIRO.equals(tipo2))
      INTEIRO
    else if (LITERAL.equals(tipo1) || LITERAL.equals(tipo2))
      LITERAL
    else
      throw new Exception("Erro: Não foi possível identificar o tipo de dado.")
  }
}
