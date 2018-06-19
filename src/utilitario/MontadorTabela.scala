package utilitario

import scala.io.BufferedSource

class MontadorTabela(caminho: String, separador: String) {
  var SEPARADOR_ARQUIVO_CSV: String = separador

  def this(caminho: String) = {
    this(caminho, ",")
  }

  def montarTabela[T, U, V](conversorKey1: (String) => T, conversorKey2: (String) => U, conversorValue: (String) => V): Map[T, Map[U, V]] = {
    val bufferCSV: BufferedSource = this.carregarCSV(caminho)
    val arquivoCSV: Iterator[String] = bufferCSV.getLines()

    var mapa: Map[T, Map[U, V]] = Map()
    var chaves = arquivoCSV.next().split(SEPARADOR_ARQUIVO_CSV)

    while (arquivoCSV.hasNext) {
      val colunas = arquivoCSV.next().split(SEPARADOR_ARQUIVO_CSV)
      var mapaTmp = Map[U, V]()
      for (i <- 1 until colunas.length) {
        if (!colunas(i).equals("")) {
          mapaTmp = mapaTmp + (conversorKey2(chaves(i)) -> conversorValue(colunas(i)))
        }
      }
      mapa = mapa + (conversorKey1(colunas(0)) -> mapaTmp)
    }
    bufferCSV.close
    mapa
  }

  private def carregarCSV(caminho: String): BufferedSource = {
    io.Source.fromFile(caminho)
  }
}
