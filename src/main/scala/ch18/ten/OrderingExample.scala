package ch18.ten

/*
10. Self types can usually be replaced with traits that extend classes, but there can be situations
where using self types changes the initialization and override orders. Construct such an example.
 */

object OrderingExample extends App {

  /** Using self types.
    */
  trait A {
    print("Init A ")
  }

  trait B {
    self: A =>
    print("Init B ")
  }

  trait C {
    self: A with B =>
    print("Init C ")
  }

  /**
    * Note how mixing in traits using different order does affect initialization order
    */
  //prints Init C Init A Init B
  new C with A with B
  println
  //prints Init C Init B Init A
  new C with B with A


  println
  println

  /**
    * Using inheritance.
    *
    */
  class AA {
    print("Init AA ")
  }

  trait BB extends AA {
    print("Init BB ")
  }

  trait CC extends BB {
    print("Init CC ")
  }

  /**
    * Note how mixing in traits using different order does not affect initialization order
    */
  //prints "Init AA Init BB Init CC"
  new AA with BB with CC
  println
  //prints "Init AA Init BB Init CC"
  new AA with CC with BB
}

