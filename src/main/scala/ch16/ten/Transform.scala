package ch16.ten

import scala.xml._
import scala.xml.parsing.XhtmlParser
import scala.xml.transform.{RewriteRule, RuleTransformer}

object Transform extends App {
  val parser = new XhtmlParser(scala.io.Source.fromFile("C:\\Users\\jyril\\git\\scala_for_impatient_ch15-ch22_sbt\\src\\main\\resources\\myfile_with_dtd_cdata.xml"))
  val root = parser.initialize.document

  def transform(xml: Document) = {
    val addMissingAlts = new RewriteRule {
      override def transform(n: Node) = n match {
        case e @< img > {
      _*
      }
      </ img > if e.attribute ("alt").isEmpty => {
      val elem = e.asInstanceOf[Elem]
      elem.copy (attributes = MetaData.concatenate (elem.attributes, Attribute (null, "alt", "TODO", Null) ) )
      }
        case _ => n
      }
    }
    new RuleTransformer(addMissingAlts).transform(xml)
  }

  val transformed = transform(root)
  XML.save("transformed.xhtml", transformed.head, enc = "UTF-8", true, null)

}
