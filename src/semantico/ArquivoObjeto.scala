package semantico

import java.io.BufferedWriter
import java.nio.file.{Files, Path, Paths}

object ArquivoObjeto {
  val path: Path = Paths.get("D:\\Universidade\\9_semestre\\Compiladores\\Projeto\\ufg-compiladores\\compilador\\src\\codigo_objeto.c")
  val writer: BufferedWriter = Files.newBufferedWriter(path)

  var conteudo: String = ""

  def imprimir(conteudo: String): Unit = this.conteudo += conteudo + "\n"

  def imprimirInicio(conteudo: String): Unit = this.conteudo = conteudo + this.conteudo

  def novaLinha(): Unit = imprimir("")

  def escrever(): Unit = {
    println(this.conteudo)
    writer.write(this.conteudo)
    writer.close()
  }
}
