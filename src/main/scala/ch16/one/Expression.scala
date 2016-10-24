/*
1. What is <fred/>(0)? <fred/>(0)(0)? Why?
 */
package ch16.one

import scala.xml.Elem

object Expression extends App {
  private val elem: Elem = <fred/>
  //xml elem is SeqLike[Node] (through NodeSeq parent class. Thus it has apply method with index
  //that returns a node on that index. Since returned type is also a node it can be
  //traversed indefinately on index 0. In other words a node with only one node is also a sequence.
  println(elem(0))
  println(elem(0)(0))
  println(elem(0)(0)(0))

}
