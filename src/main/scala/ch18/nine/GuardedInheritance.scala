package ch18.nine

/**
  * 9. Consider this class that models a physical dimension:
  *
  * abstract class Dim[T](val value: Double, val name: String) {
  * protected def create(v: Double): T
  * def +(other: Dim[T]) = create(value + other.value)
  * override def toString() = value + " " + name
  * }
  *
  * Here is a concrete subclass:
  *
  * class Seconds(v: Double) extends Dim[Seconds](v, "s") {
  * override def create(v: Double) = new Seconds(v)
  * }
  *
  * But now a knucklehead could define
  *
  * class Meters(v: Double) extends Dim[Seconds](v, "m") {
  * override def create(v: Double) = new Seconds(v)
  * }
  *
  * allowing meters and seconds to be added. Use a self type to prevent that.
  */


object GuardedInheritance extends App {


  abstract class Dim[T](val value: Double, val name: String) {

    this: T =>
      protected def create(v: Double): T

      def +(other: Dim[T]) = create(value + other.value)

      override def toString() = value + " " + name

  }

  class Seconds(v: Double) extends Dim[Seconds](v, "s") {
    override def create(v: Double) = new Seconds(v)
  }

  //will not compile since type param value Seconds does not confirm to self type Meters
  /*
  class Meters(v: Double) extends Dim[Seconds](v, "m") {
    override def create(v: Double) = new Seconds(v)
  }
  */

  println("hello")

}

