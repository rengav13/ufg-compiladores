package lexico

object ControladorAutomato {
  private var estado: Int = 0
  private var lexemaClassificado: Boolean = false

  def isLexemaClassificado: Boolean = this.lexemaClassificado

  def vaiParaProximoEstado(simbolo: String): Unit = {
    if (Automato.hasProximoEstado(this.estado, simbolo)) {
      this.estado = Automato.getProximoEstado(this.estado, simbolo)
      this.lexemaClassificado = false
    }
    else if (!EstadosFinais.isFinal(this.estado)) {
      this.lexemaClassificado = true
    }
    else if (EstadosFinais.isFinal(this.estado)) {
      this.lexemaClassificado = true
    }
  }

  def getTipoToken: TipoToken.TipoToken = {
    if (!EstadosFinais.isFinal(this.estado)) {
      this.estado = 0
      TipoToken.ERRO
    }
    val tipoToken = EstadosFinais.getTipoToken(this.estado)
    this.estado = 0
    tipoToken
  }
}
