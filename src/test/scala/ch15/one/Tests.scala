/*
1. Write four JUnit test cases that use the @Test annotation with and without each of its arguments.
Run the tests with JUnit.
 */

package ch15.one

import org.junit.Assert._
import org.junit.Test

//must be a class (not object ) or sbt will not recognize the tests!
class Tests {

  @Test(timeout = 100, expected = classOf[NullPointerException])
  def test1(): Unit = {
    throw new NullPointerException
  }

  @Test(expected = classOf[NullPointerException]) def test2(): Unit = {
    throw new NullPointerException
  }

  @Test(timeout = 10) def test3(): Unit = {
    //Thread.sleep(100)
  }

  @Test() def test4(): Unit = {
    assertEquals(2, 2)
    //assertEquals(1, 2)
  }
}

