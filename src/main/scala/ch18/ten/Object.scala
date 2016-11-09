package ch18.ten

/*
10. Self types can usually be replaced with traits that extend classes, but there can be situations
where using self types changes the initialization and override orders. Construct such an example.
 */

object OrderingExample extends App {

  /**
    * First lest have an example how inheritance cane be replaced with self type without affecting initialization order
    */

  class A {
    print("Init A ")

  }

  class B extends A {
    print("Init B ")
  }

  trait T extends A {
    print("Init T ")
  }


  //Init AA Init BB Init TT
  val x = new B with T

  println

  class AA {
    print("Init AA ")

  }

  class BB extends AA {
    print("Init BB ")
  }

  trait TT {
    self: AA =>
    print("Init TT ")
  }

  //Init A Init B Init T
  private val bb = new BB with TT


  println()
  println()
  println()


  /**
    * Now lets construct an example where replacing inheritance with self type changes initialization order
    */
  //TODO


}
