package com.functional

/**
  * Created by toantran on 12/12/15.
  */
object ExerciseChap2 {

  def main(args: Array[String]) {

    println("answer to Exercise 2.1: " + fib(0))
    println("answer to Exercise 2.2 with function: " + (isSorted(Array(1, 2, 3, 4, 5, 2), sortIntCompare)))
    println("answer to Exercise 2.2 with inline: " + (isSorted(Array(1, 2, 3, 4, 3), (n1: Int, n2: Int) => n1 <= n2)))


  }

  /**
    * Exercise 2.1
    * @param n
    * @return
    */
  def fib(n: Int): Int = {
    def go(n: Int, ans: Int, prev: Int): Int = {
      if (n <= 0) ans
      else go(n - 1, ans + prev, ans)
    }

    if (n <= 1) n
    else go(n - 1, 1, 0)
  }

  /**
    * Exercise 2.2
    * @param as
    * @param ordered
    * @tparam A
    * @return
    */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(i: Int): Boolean = {
      if (i >= as.length - 1) true
      else if (ordered(as(i), as(i + 1))) loop(i + 1)
      else false
    }
    loop(0)
  }

  /**
    * helper function for isSorted Function
    *
    * @param n1
    * @param n2
    * @return
    */
  private def sortIntCompare(n1: Int, n2: Int): Boolean = {
    n1 <= n2
  }


  /**
    * Exercise 2.3
    * @param f
    * @tparam A
    * @tparam B
    * @tparam C
    * @return
    */
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a => b => f(a: A, b: B)
  }

  /**
    * Exercise 2.4
    * @param f
    * @tparam A
    * @tparam B
    * @tparam C
    * @return
    */
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  /**
    * Exercise 2.5
    * @param f
    * @param g
    * @tparam A
    * @tparam B
    * @tparam C
    * @return
    */
  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  }



}
