


def failingFn(i: Int): Int = {
  val y: Int = throw new Exception("fail!")
  try {
    val x = 42 + 5
    x + y
  }
  catch {
    case e: Exception => 43
  }
}
//println("failingFn")
failingFn(12)

def failingFn2(i: Int): Int = { try {
  val x = 42 + 5
  x + ((throw new Exception("fail!")): Int) }
catch { case e: Exception => 43 } }


failingFn2(12)
/*

val x = false && false
println("does it work " + x)


object overrides {
  println("test")
}

abstract class Base {
  def termifoo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar =3
}


val t = new Sub
println("foo is :" + t.foo)

*/

//def test(s:String*): Unit= {
//  println("printing: " + _)
//}
//
//test("test1","test2")

//val sum = List(1,2,3,4,5).reduceLeft(_-_)
//
//
//val sum1 = List(1,2,3,4,5).reduceRight(_-_)
//
//sealed trait List[+A]
//case object Nil extends List[Nothing]
//case class Cons[+A](head: A, tail: List[A]) extends List[A]
//
//val x = List(1,2,3,4,5) match {
//  case Cons(x, Cons(2, Cons(4, _))) => x
//  case Nil => 42
//  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
//  case Cons(h, t) => h + sum(t)
//  case _ => 101
//}
