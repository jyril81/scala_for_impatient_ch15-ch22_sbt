package ch17.eight

/**
  * 8. In Section 17.10, “Co- and Contravariant Positions,” on page 238, the replaceFirst method has a
  * type bound. Why can’t you define an equivalent method on a mutable Pair[T]?
  * def replaceFirst[R >: T](newFirst: R) { first = newFirst } // Error
  */
object ReplaceFirst extends App {

  /**
    * First the original code in the book on page 238:
    */
  class Pair[+T](val first: T, val second: T) {
    //Error, will not compile
    //def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)

    //will work by using new temporary type variable
    //type bound is needed to make sure ctor compiles (because
    // first and second arg must be of same type)
    def replaceFirst[R >: T](newFirst: R) = new Pair[R](newFirst, second)
  }


  //Mutable pair is covariant to generic type T
  class MutablePair[T](var first: T, var second: T) {
    //Error. Why can’t you define an equivalent method on a mutable Pair[T]?
    //The problem is that newFirst is of type R that is supertype of T and
    //one  cannot assign supertype ref to subtype ref (basic subtype inheritance rule)
    //def replaceFirst[R >: T](newFirst: R) { first = newFirst}

    //Lets try to switch bounds
    // This will fix the issue
    def replaceFirst[R <: T](newFirst: R) {
      first = newFirst
    }

  }


}
