package lexico

import lexico.TipoToken.TipoToken

class Token(var tipoToken: TipoToken, var lexema: String) {
    tipoToken match {
        case TipoToken.IDENTIFICADOR =>
            if (TipoToken.isPalavraReservada(lexema))
                this.tipoToken = TipoToken.getPalavraReservada(lexema)
        case TipoToken.COMENTARIO =>
            this.tipoToken = null
            this.lexema = null
        case _ =>
    }

    override def toString: String = s"[ Token: ${this.tipoToken}, lexema: ${this.lexema} ]"
}