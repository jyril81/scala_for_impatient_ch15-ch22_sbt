package ch17.two

/*
2. Define a mutable class Pair[T] with a method swap that swaps the components of the pair.
 */

object MutablePairSwap extends App {

  //here mutabe swap works because we have only one type param, it wouldnt work with Pair[T, S]
  class Pair[T](var first: T, var second: T) {
    def swap() = {
      val tmp = first
      first = second
      second = tmp
    }

    override def toString = {
      "[" + first + ", " + second + "]"
    }
  }

  private val pair = new Pair("one", "two")
  println(pair)
  pair.swap()
  println(pair)
}
