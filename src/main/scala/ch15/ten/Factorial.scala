package ch15.ten

object Factorial extends App {
  def factorial(n: Int): Int = {
    assert(n >= 0)
    if (n == 1) 1 else n * factorial(n - 1)
  }

  println(factorial(5))
  //will throw when compiling with default settings
  println(factorial(-1))
}

/*
When compiling without specials args assertions are enabled by default:
jyril@PLAYTECH-A1692 MINGW64 ~/git/scala_for_impatient_ch15-ch22_sbt/src/main/scala/ch15/ten/ch15/ten (master)
$ /c/Program\ Files/Java/jdk1.8.0_66/bin/javap -p -v Factorial$|grep asser
Warning: Binary file Factorial$ contains ch15.ten.Factorial$
#63 = Utf8               assert
#65 = NameAndType        #63:#64       // assert:(Z)V
#66 = Methodref          #59.#65       // scala/Predef$.assert:(Z)V
13: invokevirtual #66                 // Method scala/Predef$.assert:(Z)V

*/

/*
When compiling with assertions disabled:
 scalac -d . -Xelide-below MAXIMUM Factorial.scala

then picture changes:
jyril@PLAYTECH-A1692 MINGW64 ~/git/scala_for_impatient_ch15-ch22_sbt/src/main/scala/ch15/ten/ch15/ten (master)
$ /c/Program\ Files/Java/jdk1.8.0_66/bin/javap -p -v Factorial$|grep asser

Nothign anymore about assertion in generated byte code.
 */
