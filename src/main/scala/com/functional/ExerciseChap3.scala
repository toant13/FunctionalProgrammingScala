package com.functional

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


/**
  * Created by toantran on 12/13/15.
  */
object ExerciseChap3 {


  def main(args: Array[String]) {


    val ex1: List[Int] = Cons(1, Cons(2, Nil))
    val ex2: List[Int] = Cons(3, Cons(4, Nil))



    println(length(ex1))
    //    val ret = appendWithLeft(ex1, ex2)
    //    println(ret)
    println("Done")

  }

  //exercise 3.1
  //

  /**
    * exercise 3.3
    * @param l
    * @tparam A
    * @return
    */
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("list is empty")
    case Cons(_, t) => t
  }


  /**
    * exercise 3.3
    * @param l
    * @tparam A
    * @return
    */
  def tail[A](l: List[A], head: A): List[A] = l match {
    case Nil => sys.error("list is empty")
    case Cons(_, t) => Cons(head, t)
  }

  /**
    * excercise 3.4
    * @param l
    * @param n
    * @tparam A
    * @return
    */
  def drop[A](l: List[A], n: Int): List[A] = {
    if (n <= 0) l
    else l match {
      case Nil => Nil
      case Cons(_, t) => drop(t, n - 1)
    }
  }

  /**
    * excercise 3.5
    * @param l
    * @param f
    * @tparam A
    * @return
    */
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
    l match {
      case Cons(x, xs) if f(x) => dropWhile(xs, f)
      case _ => l
    }

  }

  /**
    * excercise 3.6
    * @param l
    * @tparam A
    * @return
    */
  def init[A](l: List[A]): List[A] = {
    l match {
      case Cons(x, xs) if (xs != Nil) => Cons(x, init(xs))
      case Nil => l
    }
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }


  /**
    * excercise 3.9
    * @param as
    * @tparam A
    * @return
    */
  def length[A](as: List[A]): Int = {

    foldRight(as, 0)((_, xs) => xs + 1)

  }


  /**
    * excercise 3.11
    * @param ns
    * @return
    */
  def sumLeft(ns: List[Int]): Int = {
    foldLeft(ns, 0)((x, y) => x + y)
  }

  def productLeft(ns: List[Int]): Int = {
    foldLeft(ns, 1)((x, y) => x * y)
  }

  /**
    * excercise 3.11
    * @param ns
    * @return
    */
  def lengthLeft(ns: List[Int]): Int = {
    foldLeft(ns, 0)((x, y) => x + 1)
  }


  //  /**
  //    * excercise 3.12
  //    * @param l
  //    * @tparam A
  //    * @return
  //    */
  //  def reverseLeftFold[A](l: List[A]): List[A] = {
  //    foldLeft(l, List[A]())((acc, h) => Cons(h, acc))
  //  }


  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  /**
    * exercise 3.13
    * @param as
    * @param z
    * @param f
    * @tparam A
    * @tparam B
    * @return
    */
  def foldLeftWithRight[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
    //    foldRight(as, z) ((x,y)=> Cons(x,as))

    foldRight(as, (b: B) => b)((a, g) => b => g(f(b, a)))(z)
  }


  /**
    * Exercise 3.14
    * @param aList
    * @param bList
    * @tparam A
    * @return
    */
  def appendWithRight[A](aList: List[A], bList: List[A]): List[A] = {
    foldRight(aList, bList)((x, y) => Cons(x, y))
  }


  /**
    * excercise 3.10
    * @param as
    * @param z
    * @param f
    * @tparam A
    * @tparam B
    * @return
    */
  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

  //  /**
  //    * Exercise 3.14
  //    * @param aList
  //    * @param bList
  //    * @tparam A
  //    * @return
  //    */
  //  def appendWithLeft[A](aList: List[A], bList: List[A]): List[A] ={
  //    val rev = reverseLeftFold(aList)
  //    foldLeft(bList,aList)((x,y) => Cons(y,Nil))
  //  }


  /**
    * exercise 3.25
    * @param as
    * @tparam A
    * @return
    */
  def size[A](as: Tree[A]): Int = {
    as match {
      case Leaf(x) => 1
      case Branch(left, right) => 1 + size(left) + size(right)
    }
  }

  /**
    * exercise 3.26
    * @param as
    * @tparam A
    * @return
    */
  def maximum[A](as: Tree[Int]): Int = {
    as match {
      case Leaf(x) => Leaf(x).value
      case Branch(left, right) => maximum(left).max(maximum(right))
    }
  }

}
