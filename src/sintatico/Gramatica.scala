package sintatico

object Gramatica {

  val PRODUCOES: List[Producao] = List[Producao](
    new Producao("P'", "P", 1),
    new Producao("P", "inicio V A", 3),
    new Producao("V", "varinicio LV", 2),
    new Producao("LV", "D LV", 2),
    new Producao("LV", "varfim ;", 2),
    new Producao("D", "id TIPO ;", 3),
    new Producao("TIPO", "inteiro", 1),
    new Producao("TIPO", "real", 1),
    new Producao("TIPO", "lit", 1),
    new Producao("A", "ES A", 2),
    new Producao("ES", "leia id ;", 3),
    new Producao("ES", "escreva ARG ;", 3),
    new Producao("ARG", "literal", 1),
    new Producao("ARG", "num", 1),
    new Producao("ARG", "id", 1),
    new Producao("A", "CMD A", 2),
    new Producao("CMD", "id rcb LD ;", 4),
    new Producao("LD", "OPRD opm OPRD", 3),
    new Producao("LD", "OPRD", 1),
    new Producao("OPRD", "id", 1),
    new Producao("OPRD", "num", 1),
    new Producao("A", "COND A", 2),
    new Producao("COND", "CABECALHO CORPO", 2),
    new Producao("CABECALHO", "se ( EXP_R ) entao", 5),
    new Producao("EXP_R", "OPRD opr OPRD", 3),
    new Producao("CORPO", "ES CORPO", 2),
    new Producao("CORPO", "CMD CORPO", 2),
    new Producao("CORPO", "COND CORPO", 2),
    new Producao("CORPO", "fimse", 1),
    new Producao("A", "fim", 1),
  )

  def get(pos: Int): Producao = this.PRODUCOES(pos - 1)
}