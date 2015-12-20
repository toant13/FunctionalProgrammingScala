package com.functional

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


/**
  * Created by toantran on 12/20/15.
  */
@RunWith(classOf[JUnitRunner])
class AssignmentOneTest extends FunSuite {
  import com.functional.course.AssignmentOne.pascal

  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }
}
