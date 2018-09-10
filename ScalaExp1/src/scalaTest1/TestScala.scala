package scalaTest1

import scala.collection.mutable
import scala.collection.mutable.Set

object TestScala {

  def main(args: Array[String]): Unit = {
    //      var i = 0
    //      var args2 = Array("Hello", "Scala")
    //      args2.foreach(arg => println(arg))
    //      args2.foreach((arg:String) =>println(arg))
    //      args2.foreach(println)
    //for (arg<-args2) println(arg)
    //      print(args2.apply(1))
    //      val jetSet = mutable.Set("Boeing", "Airbus")
    //      jetSet+="Lear"
    //      println(jetSet.contains("Exit"))
    //
    //
    val treasureMap = mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island")
    treasureMap += (2 -> "Find big")
    treasureMap += (3 -> "Dig")
    println(treasureMap(2))

    var b = 1
    var c = 2
    var a = b + c
    b = 3
    print(a)
  }
}

