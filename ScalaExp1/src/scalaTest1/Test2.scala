package scalaTest1

object Test2 {
  var n1 = 3

  class Test2{
    var n2 = 6
  }

  def main(args: Array[String]): Unit ={
    val test2 = new Test2
    test2.n2 = 8
    println(n1)
    println(test2.n2)
    println("bar".take(2))
  }

  def find(): Unit ={

  }
}
