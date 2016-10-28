package ch17.nine

/**
  * 9. It may seem strange to restrict method parameters in an immutable class Pair[+T]. However,
  * suppose you could define
  * def replaceFirst(newFirst: T)
  * in a Pair[+T]. The problem is that this method can be overridden in an unsound way.
  * Construct an example of the problem. Define a subclass NastyDoublePair of Pair[Double] that
  * overrides replaceFirst so that it makes a pair with the square root of newFirst. Then construct
  * the call replaceFirst("Hello") on a Pair[Any] that is actually a NastyDoublePair.
  */
object NastyPairExample extends App {

  abstract class Pair[+T](val first: T, val second: T) {
    //only this method signature will not compile in this example
    def replaceFirst(newFirst: T)
  }
  class NastyDoublePair(first: Double, second: Double) extends Pair(first, second) {
    //override
    def replaceFirst(newFirst: Double) = {
      new NastyDoublePair(math.sqrt(newFirst), second)
    }
  }

  //this will compile because Pair type param is +T and not just T
  //and this is the root issue that will allow following
  private val pair: Pair[Any] = new NastyDoublePair(1, 2)
  pair.replaceFirst("Hello")

  //If compiler would allow it then in runtime we would get type cast exception becaue you cannot assign
  // a string to a double
}
