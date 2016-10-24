/*
9. Transform an XHTML document by adding an alt="TODO" attribute to all img elements without an
alt attribute, preserving everything else.
 */

package ch16.nine

import scala.xml._
import scala.xml.transform.{RewriteRule, RuleTransformer}

object AddTodos extends App {
  val root = XML.loadFile("C:\\Users\\jyril\\git\\scala_for_impatient_ch15-ch22_sbt\\src\\main\\resources\\myfile.xml")

  def transform(xml: Elem) = {
    val addMissingAlts = new RewriteRule {
      override def transform(n: Node) = n match {
        case e @ <img>{_*}</img> if e.attribute("alt").isEmpty =>  {
          val elem = e.asInstanceOf[Elem]
          elem.copy(attributes = MetaData.concatenate(elem.attributes, Attribute(null, "alt", "TODO", Null)))
        }
        case _ => n
      }
    }
    new RuleTransformer(addMissingAlts).transform(xml)
  }

  println(transform(root))
}
