package ch17.three


/*
3. Given a class Pair[T, S], write a generic method swap that takes a pair as its argument and returns
a new pair with the components swapped.
 */

object GenericMethod extends App {

  class Pair[T, S](val first: T, val second: S) {
    override def toString = {
      "[" + first + ", " + second + "]"
    }
  }

  // note that here swap methods outside of the class
  def swap[T, S](p: Pair[T, S]) = {
    new Pair(p.second, p.first)
  }

  private val pair = new Pair("abc", 123)
  println(swap(pair))

}
