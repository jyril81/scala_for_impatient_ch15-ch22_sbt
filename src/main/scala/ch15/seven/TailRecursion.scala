/*
7. Give an example to show that the tail recursion optimization is not valid when a method can be
overridden.
*/

package ch15.seven

import scala.annotation.tailrec

object TailRecursion extends App {

  @tailrec def sum(partialSum: Int, elems: Seq[Int]): Int = {
    if (elems.isEmpty) partialSum
    else sum(partialSum + elems.head, elems.tail)
  }

  println(sum(0, Array(1, 2, 3, 4, 5)))
  println(TailRecExample().sum(0, Array(1, 2, 3, 4, 5)))

  case class TailRecExample() {

    //removing final modifier will result in compilation error with message
    //"Method annotated with @tailrec is neither private nor final (so can be overridden)"

    @tailrec final def sum(partialSum: Int, elems: Seq[Int]): Int = {
      if (elems.isEmpty) partialSum
      else sum(partialSum + elems.head, elems.tail)
    }
  }

}
