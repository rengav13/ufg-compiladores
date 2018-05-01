package lexico

object ControladorAutomato {                    //Auxilia no controle do Automato:
  private var estado: Int = 0
  private var lexemaClassificado: Boolean = false
  
  def isLexemaClassificado: Boolean = this.lexemaClassificado   // A função recebera o lexema classificado   

  //Nessa função poderemos navegar pelo Automato pegando o próximo estado :
  def vaiParaProximoEstado(simbolo: String): Unit = {
    if (Automato.hasProximoEstado(this.estado, simbolo))   
    {
      this.estado = Automato.getProximoEstado(this.estado, simbolo) //O estado receberá o proximo estado do Automato
      this.lexemaClassificado = false                               //E o lexemaclassificado continuara com o com "valor: false" 
                                                                    //porque ainda tem um proximo estados a visitar no Automato
    }
    
    else if (!EstadosFinais.isFinal(this.estado)) {                 //Se o estado atual não for um estado final no final da navegação 
      this.lexemaClassificado = true                                //O lexemaclassificado recebe true sendo que foi completado a leitura dos carater compondo o lexema.
    }
    else if (EstadosFinais.isFinal(this.estado)) {
      this.lexemaClassificado = true
    }
  }

  //Função relacionada ao tipo de Token 
  def getTipoToken: TipoToken.TipoToken = {       
    if (!EstadosFinais.isFinal(this.estado)) {    //Se o estado não for estado final  
      this.estado = 0                             //voltamos para o estado inicial 
      TipoToken.ERRO                              //Com erro do TipoToken
    }
    // a variavel tipoToken recebera o estado final e associará a ela o tipo de Token relacionada na tabela  
    val tipoToken = EstadosFinais.getTipoToken(this.estado)
    this.estado = 0         //Assim o estado atual retornará ao estado inicial
    tipoToken              
  }
}
