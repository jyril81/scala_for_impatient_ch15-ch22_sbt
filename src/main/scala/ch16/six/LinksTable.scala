/*
6. Read an XHTML file and print a table of all hyperlinks in the file, together with their URLs.
That is, print the child text and the href attribute of each a element.
 */

package ch16.six

import scala.xml.{Elem, XML}

object LinksTable extends App {

  //find all <a> nodes
  //store into a seq of pairs of text and href attribute value
  def parseToPairs(xml: Elem): Seq[(String, String)] = {
    (xml \\ "a").map(link => Tuple2(link.text, link.attribute("href").get.text))
  }

  def printToTable(pairs: Seq[(String, String)]) = {
    for (elem <- pairs) {
      println(elem._1 + " " + elem._2)
    }
  }


  val root = XML.loadFile("C:\\Users\\jyril\\git\\scala_for_impatient_ch15-ch22_sbt\\src\\main\\resources\\myfile.xml")
  private val pairs = parseToPairs(root)
  printToTable(pairs)
}
