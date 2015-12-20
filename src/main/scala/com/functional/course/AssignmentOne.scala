package com.functional.course

/**
  * Created by toantran on 12/19/15.
  */
object AssignmentOne {


  def main(args: Array[String]) {
    println("Assignment 1")

    println(pascal(0, 0))



    val list = "()just an) example".toList
    println(balance(list))

  }

  /**
    * Exercise 1: Pascal's Triangle
    * @param c
    * @param r
    * @return
    */
  def pascal(c: Int, r: Int): Int = {
    if (c > r) throw new IllegalArgumentException("not triangle"); //need to replace this with Option to rid of side effects
    else if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  }

  /**
    * Exercise 2: Parentheses Balancing
    *
    * @param chars
    * @return
    */
  def balance(chars: List[Char]): Boolean = {
    def helper(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty) open == 0
      else if (chars.head == '(') helper(chars.tail, open + 1)
      else if (chars.head == ')') helper(chars.tail, open - 1)
      else helper(chars.tail, open)
    }
    helper(chars, 0)
  }


}
