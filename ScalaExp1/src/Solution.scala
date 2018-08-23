import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Solution {

  case class Square(coner1: Int, coner2: Int, coner3: Int, coner4: Int)

  var count = 0

  def main(args: Array[String]): Unit = {
    val date1 = new java.util.Date()
    date1.getTime
    //var figure = ArrayBuffer.empty[Square]
    val sumLimit = 10
    val fileName = "src\\resource.txt"
    val figure = readFile(fileName)
    permutation(0, figure, sumLimit)
    println("Figures count = " + count)
    val date2 = new java.util.Date()
    println(date2.getTime - date1.getTime)
  }

  private def readFile(fileName: String) :ArrayBuffer[Square]={
    var figure = ArrayBuffer.empty[Square]
    val source = Source.fromFile(fileName, "UTF-8")
    val lines = source.getLines().toArray
    for (line <- lines) {
      val coners = line.split(" ").map(_.toInt)
      val square = Square(coners(0), coners(1), coners(2), coners(3))
      figure += square
    }
    figure
  }

  private def isCorrectFigure(figure: ArrayBuffer[Square], sumLimit: Int): Boolean = {
      figure(0).coner2 + figure(1).coner1 <= sumLimit && // 1-2
        figure(0).coner3 + figure(2).coner2 + figure(3).coner1 <= sumLimit && //1-3-4
        figure(0).coner4 + figure(1).coner3 + figure(3).coner2 + figure(4).coner1 == sumLimit && // 1-2-4-5
        figure(1).coner4 + figure(4).coner2 + figure(5).coner1 <= sumLimit && // 2-5-6
        figure(2).coner3 + figure(6).coner1 <= sumLimit && // 3-7
        figure(2).coner4 + figure(3).coner3 + figure(6).coner2 + figure(7).coner1 == sumLimit && // 3-4-7-8
        figure(3).coner4 + figure(4).coner3 + figure(7).coner2 + figure(8).coner1 == sumLimit && // 4-5-8-9
        figure(4).coner4 + figure(5).coner3 + figure(8).coner2 + figure(9).coner1 == sumLimit && // 5-6-9-10
        figure(5).coner4 + figure(9).coner2 <= sumLimit && // 6-10
        figure(6).coner4 + figure(7).coner3 + figure(10).coner1 <= sumLimit && // 7-8-11
        figure(7).coner4 + figure(8).coner3 + figure(10).coner2 + figure(11).coner1 == sumLimit && // 8-9-11-12
        figure(8).coner4 + figure(9).coner3 + figure(11).coner2 <= sumLimit && // 9-10-12
        figure(10).coner4 + figure(11).coner3 <= sumLimit // 11-12
  }

  private def permutation(start: Int, figure: ArrayBuffer[Square], sumLimit: Int): Unit = {
    if (start == figure.size - 1) {
      if (isCorrectFigure(figure, sumLimit)) {
        count += 1
        figure.foreach(square => println(square.coner1 + " " + square.coner2 + " " + square.coner3 + " " + square.coner4))
        println()
      }
    }

    var i = start
    for (i <- start until figure.size) {
      val c = figure(i)
      figure(i) = figure(start)
      figure(start) = c
      permutation(start + 1, figure, sumLimit)
      val c2 = figure(i)
      figure(i) = figure(start)
      figure(start) = c2
    }
  }
}