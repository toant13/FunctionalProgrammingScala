package com.functional

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]




/**
  * Created by toantran on 12/13/15.
  */
object ExerciseChap3 {


  def main(args: Array[String]) {
    val xs = List(1,2,3,4,5)
    length(xs)
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
    * excercise 3.10
    * @param as
    * @param z
    * @param f
    * @tparam A
    * @tparam B
    * @return
    */
  @annotation.tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B ={
    as match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z,x))(f)
    }
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  def sum[A][B](a:A,)


}
