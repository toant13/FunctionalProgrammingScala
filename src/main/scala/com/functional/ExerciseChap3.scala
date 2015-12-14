package com.functional

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]


/**
  * Created by toantran on 12/13/15.
  */
object ExerciseChap3 {


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
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] ={

  }

}
