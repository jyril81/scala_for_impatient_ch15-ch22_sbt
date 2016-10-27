package ch17.one

/**
  * 1. Define an immutable class Pair[T, S] with a method swap that returns a new pair with the
  * components swapped.
  */
object ImmutablePairSwap extends App {

  //swapping of positions of two different types works because we create new instance on swap
  class Pair[T, S](val first: T, val second: S) {
    def swap() = {
      new Pair(second, first)
    }

    override def toString = {
      "[" + first + ", " + second + "]"
    }
  }


  private val strPair = new Pair("first", "second")
  println(strPair + " swapped is " + strPair.swap())
  private val intPair = new Pair(10, 25)
  println(intPair + " swapped is " + intPair.swap())
  private val mixPair = new Pair(10, "abc")
  println(mixPair + " swapped is " + mixPair.swap())


}
