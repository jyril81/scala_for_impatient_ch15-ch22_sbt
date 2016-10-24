/*
5. Print the names of all images in an XHTML file. That is, print all src attribute values inside img
elements.
 */
package ch16.five

import scala.xml.XML

object ImageNames extends App {
  val root = XML.loadFile("C:\\Users\\jyril\\git\\scala_for_impatient_ch15-ch22_sbt\\src\\main\\resources\\myfile.xml")

  root \\ "img" foreach (node => node.attribute("src").map(println(_)))

}
