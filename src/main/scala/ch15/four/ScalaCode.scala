/*
4. Write a Scala method sum with variable integer arguments that returns the sum of its arguments.
Call it from Java.
 */

package ch15.four

import scala.annotation.varargs

object ScalaCode {

  @varargs def sum(args: Int*): Int = {
    args.sum
  }
}
