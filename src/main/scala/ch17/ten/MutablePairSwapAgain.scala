package ch17.ten

/**
  * 10. Given a mutable Pair[S, T] class, use a type constraint to define a swap method that can be called
  * if the type parameters are the same.
  */
object MutablePairSwapAgain extends App {

  class Pair[S, T](var first: S, var second: T) {

  }

  //using an upper bound and a type constraint
  def swap[S <: T, T](p: Pair[S, T])(implicit ev: T =:= S) = {
    val tmp = p.first
    p.first = p.second
    p.second = tmp
  }


  private val pair = new Pair(1, 2)
  private val pair2 = new Pair(1, "2")

  //will work
  swap(pair)

  //will not compile
  //swap(pair2)
}
