package lexico

object ControladorAutomato {
  private var estado: Int = 0
  private var lexemaClassificado: Boolean = false

  def isLexemaClassificado: Boolean = this.lexemaClassificado

  def vaiParaProximoEstado(simbolo: String): Unit = {
    if (Automato.hasProximoEstado(this.estado, simbolo)) {
      this.estado = Automato.getProximoEstado(this.estado, simbolo)
      this.lexemaClassificado = false
    } else {
      this.lexemaClassificado = true
    }
  }

  def getTipoToken: TipoToken.TipoToken = {
    if (!EstadosFinais.isFinal(this.estado)) {
      this.reiniciarEstadoAutomato()
      TipoToken.ERRO
    } else {
      val estadoAnterior = this.reiniciarEstadoAutomato()
      EstadosFinais.getTipoToken(estadoAnterior)
    }
  }

  private def reiniciarEstadoAutomato(): Int = {
    val estadoAnterior = this.estado
    this.estado = 0
    this.lexemaClassificado = false
    estadoAnterior
  }
}
