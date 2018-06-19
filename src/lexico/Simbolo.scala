package lexico

class Simbolo(var tipo: String, var lexema: String) {

    tipo match {
        case TipoSimbolo.IDENTIFICADOR =>
            if (TipoSimbolo.isReservada(lexema))
                this.tipo = TipoSimbolo.getPalavraReservada(lexema)
        case _ =>
    }

    override def toString: String = s"[ Simbolo: ${this.tipo}, lexema: ${this.lexema} ]"
}