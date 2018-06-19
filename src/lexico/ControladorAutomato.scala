package lexico

object ControladorAutomato {
  private var estado: Int = 0
  private var lexemaClassificado: Boolean = false

  def lexemaNaoFoiClassificado: Boolean = !this.lexemaClassificado

  def irParaProximoEstado(simbolo: String): Unit = {
    if (Automato.existeProximoEstado(this.estado, simbolo)) {
      this.estado = Automato.pegarProximoEstado(this.estado, simbolo)
      this.lexemaClassificado = false
    } else {
      this.lexemaClassificado = true
    }
  }

  def getTipoSimbolo: String = {
    val estadoAnterior: Int = this.reiniciar()
    if (EstadosFinais.classificou(estadoAnterior))
      EstadosFinais.getTipoSimbolo(estadoAnterior)
    else
      throw new Exception(ErrosPorEstado.pegarErro(estadoAnterior))
  }

  private def reiniciar(): Int = {
    val estadoAnterior = this.estado
    this.estado = 0
    this.lexemaClassificado = false
    estadoAnterior
  }
}

