package ch15


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

