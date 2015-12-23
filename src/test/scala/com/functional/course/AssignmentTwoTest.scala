package com.functional.course

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


/**
  * Created by toantran on 12/20/15.
  *
  * sbt command: sbt "testOnly *AssignmentTwoTest"
  *
  *
  */
@RunWith(classOf[JUnitRunner])
class AssignmentTwoTest extends FunSuite {

  import com.functional.course.AssignmentTwo._

  test("singletonSet with 3") {
    val test = singletonSet(3)
    assert(test(3) == true)
  }

  test("singletonSet with out of range") {
    val test = singletonSet(3)
    assert(test(4) == false)
  }
}
