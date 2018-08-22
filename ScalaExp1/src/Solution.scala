import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Solution extends App {

  case class Square(Coner1: Int, Coner2: Int, Coner3: Int, Coner4: Int)

  var fileName = "src\\resource.txt"
  var figure = ArrayBuffer.empty[Square]
  readFile()


  def readFile() {
    val source = Source.fromFile(fileName, "UTF-8")
    val lines = source.getLines().toArray
    for (line <- lines) {
      val coners = line.split(" ").map(_.toInt)
      val square = Square(coners(0), coners(1), coners(2), coners(3))
      figure += square

    }
  }


}
