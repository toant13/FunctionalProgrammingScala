package com.functional


//sealed trait Option[+A]
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]


/**
  * Created by toantran on 12/16/15.
  */
object ExerciseChap4 {
  def main(args: Array[String]) {
    println("Starting")
    failingFn(12)
  }

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


}

/** ***********Exercise  4.1 ****************************/
trait Option[+A] {
  def map[B](f: A => B): Option[B] = {
    this match {
      case None => None
      case Some(x) => Some(f(x))
    }

  }

  def flatMap[B](f: A => Option[B]): Option[B] = {
    map(f) getOrElse None
//    map(f).getOrElse(None) //equivalent as above
  }

  def getOrElse[B >: A](default: => B): B = {
    this match {
      case None => default
      case Some(x) => x
    }
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = {
    this map(Some(_)) getOrElse ob
  }

  def filter(f: A => Boolean): Option[A] = {
    flatMap(a => if (f(a)) Some(a) else None)
  }
}



/** *****************************************************/





