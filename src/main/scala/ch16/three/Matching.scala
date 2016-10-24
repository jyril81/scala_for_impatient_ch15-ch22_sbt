/*
3. Contrast
Click here to view code image
<li>Fred</li> match { case <li>{Text(t)}</li> => t }
and
Click here to view code image
<li>{"Fred"}</li> match { case <li>{Text(t)}</li> => t }
Why do they act differently?
 */

package ch16.three

import scala.xml.Text

object Matching extends App {
  //this works as expected, it matches
  val s = <li>Fred</li> match {
    case <li>
      {Text(t)}
      </li> => t
    case _ => "No match"
  }
  println(s)

  //this will not work because embedded expression will generate an elem of type Atom[String]
  //and it will not match an elem of type Text
  val s2 = <li>
    {"Fred"}
  </li> match {
    case <li>
      {Text(t)}
      </li> => t
    case _ => "No match"
  }
  println(s2)

}
