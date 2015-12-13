package com.functional

/**
  * Created by toantran on 12/12/15.
  */
object ExerciseChap2 {

  def main(args: Array[String]) {

    println("answer to Exercise 2.1: " + fib(0))
    println("answer to Exercise 2.2: " + (isSorted(Array(1, 2, 3, 4, 5, 2), sortIntCompare)))


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

  private def sortIntCompare(n1: Int, n2: Int): Boolean = {
    n1 <= n2
  }


}
