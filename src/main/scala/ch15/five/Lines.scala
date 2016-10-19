/*
5. Write a Scala method that returns a string containing all lines of a file. Call it from Java.
 */

package ch15.five

import java.io.IOException

import scala.io.Source

object Lines {
  //throws annotation is needed to be able to catch checked exceptions in calling java code
  @throws(classOf[IOException]) def lines(fileName: String): String = {
    Source.fromFile(fileName).mkString
  }

}
