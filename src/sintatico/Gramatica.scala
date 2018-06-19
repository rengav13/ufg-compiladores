package sintatico

object Gramatica {

  val REGRAS: List[Regra] = List[Regra](
    new Regra("P'", "P", 1),
    new Regra("P", "inicio V A", 3),
    new Regra("V", "varinicio LV", 2),
    new Regra("LV", "D LV", 2),
    new Regra("LV", "varfim ;", 2),
    new Regra("D", "id TIPO ;", 3),
    new Regra("TIPO", "inteiro", 1),
    new Regra("TIPO", "real", 1),
    new Regra("TIPO", "literal", 1),
    new Regra("A", "ES A", 2),
    new Regra("ES", "leia id ;", 3),
    new Regra("ES", "escreva ARG ;", 3),
    new Regra("ARG", "lit", 1),
    new Regra("ARG", "num", 1),
    new Regra("ARG", "id", 1),
    new Regra("A", "CMD A", 2),
    new Regra("CMD", "id rcb LD ;", 4),
    new Regra("LD", "OPRD opm OPRD", 3),
    new Regra("LD", "OPRD", 1),
    new Regra("OPRD", "id", 1),
    new Regra("OPRD", "num", 1),
    new Regra("A", "COND A", 2),
    new Regra("COND", "CABECALHO CORPO", 2),
    new Regra("CABECALHO", "se ( EXP_R ) entao", 5),
    new Regra("EXP_R", "OPRD opr OPRD", 3),
    new Regra("CORPO", "ES CORPO", 2),
    new Regra("CORPO", "CMD CORPO", 2),
    new Regra("CORPO", "COND CORPO", 2),
    new Regra("CORPO", "fimse", 1),
    new Regra("A", "fim", 1),
  )

  def get(pos: Int): Regra = this.REGRAS(pos - 1)
}