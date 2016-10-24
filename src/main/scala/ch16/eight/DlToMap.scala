/*
8. Write a function that takes a dl element and turns it into a Map[String, String]. This function should
be the inverse of the function in the preceding exercise, provided all dt children are distinct.
 */

package ch16.eight

import scala.collection.immutable.Map
import scala.xml.{Elem, NodeSeq}

object DlToMap extends App {
  def toMap(dlElem: Elem): Map[String, String] = {
    val dtNodes: NodeSeq = dlElem \\ "dt"
    val ddNodes: NodeSeq = dlElem \\ "dd"

    (dtNodes zip ddNodes).foldLeft(Map[String, String]())((map, tuple) => map + (tuple._1.text -> tuple._2.text))
  }

  println(toMap(<dl>
    <dt>A</dt> <dd>1</dd> <dt>B</dt> <dd>2</dd>
  </dl>))

}
