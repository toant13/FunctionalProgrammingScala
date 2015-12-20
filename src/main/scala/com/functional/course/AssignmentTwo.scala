package com.functional.course

/**
  * Created by toantran on 12/20/15.
  */
object AssignmentTwo {


  def main(args: Array[String]) {
    val t = singletonSet(3)
    t(3)


    println("done")
  }

  type Set = Int => Boolean

  def singletonSet(elem: Int): Set = {
    (x: Int) => x == elem
  }


  /**
    * Indicates whether a set contains a given element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
    * Returns the union of the two given sets,
    * the sets of all elements that are in either `s` or `t`.
    */
  def union(s: Set, t: Set): Set = (x: Int) => s(x) || t(x)


  /**
    * Returns the intersection of the two given sets,
    * the set of all elements that are both in `s` and `t`.
    */
  def intersect(s: Set, t: Set): Set = (x: Int) => s(x) && t(x)


  /**
    * Returns the difference of the two given sets,
    * the set of all elements of `s` that are not in `t`.
    */
  def diff(s: Set, t: Set): Set = (x: Int) => s(x) && !t(x)


  /**
    * Returns the subset of `s` for which `p` holds.
    */
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)


  /**
    * The bounds for `forall` and `exists` are +/- 1000.
    */
  val bound = 1000

  /**
    * Returns whether all bounded integers within `s` satisfy `p`.
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s,a)) contains(p,a)
      else iter(a+1)
    }
    iter(-bound)
  }

}
