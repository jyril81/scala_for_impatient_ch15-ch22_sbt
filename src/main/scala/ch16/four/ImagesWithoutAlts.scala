/*
4. Read an XHTML file and print all img elements that don’t have an alt attribute.
*/

package ch16.four

import scala.xml.XML

object ImagesWithoutAlts extends App {
  val root = XML.loadFile("C:\\Users\\jyril\\git\\scala_for_impatient_ch15-ch22_sbt\\src\\main\\resources\\myfile.xml")

  //using xpath + filter
  private val countAltless: Int = (root \\ "img").filter(node => node.attribute("alt").isEmpty).length
  println(countAltless)


  //using xpath + pattern matching
  private val length: Int = (root \\ "img").filter(imgElem =>
    imgElem match {
      case x if x.attribute("alt").isEmpty => true
      case _ => false
    }
  ).length
  println(length)
}
