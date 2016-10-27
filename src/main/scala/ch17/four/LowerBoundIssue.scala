package ch17.four

/**
  * 4. Why don’t we need a lower bound for the replaceFirst method in Section 17.3, “Bounds for Type
  * Variables,” on page 232 if we want to replace the first component of a Pair[Person] with a Student?
  */

object LowerBoundIssue extends App {

  class Person

  class Student extends Person

  class Pair[T](val first: T, val second: T) {
    //we dont need lower bound here because we dont use any methods of type T
    //In addition variance for type Pair[T] is not affected because:
    //1. method param assignment is done on Type T and not on Pair[T] so normal subtype inheritance rules apply
    //2. For the same reason it is ok to assign newFirst to constructor param first
    def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
  }


  private val persons = new Pair(new Person, new Person)
  private val mixed = persons.replaceFirst(new Student)
}
