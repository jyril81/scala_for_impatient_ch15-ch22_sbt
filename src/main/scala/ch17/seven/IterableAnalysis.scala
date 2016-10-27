package ch17.seven

/**
  *7. Look through the methods of the Iterable[+A] trait. Which methods use the type parameter A? Why
  * is it in a covariant position in these methods?
  */
object IterableAnalysis {
  /**
    * Iterable[+A] means that Iterable[A] is covariant with A meaning that
    * if  T <: S then Iterable[T] <: Iterable[T].
    *
    * First thing to notice on javadoc is:
    * A base trait for iterable collections that are guaranteed immutable.
    * This is important since covariance is usually defined for immutable structures.
    *
    * Another thing to note is that you cannot find any method there similar to following:
    * def someMethod(p: A) = ...
    * because it would mean having covariant type in contravariant position
    *
    * In addition, when looking at the methods we can see following:
    * 1. when A is used as return value then it works because covariance works togetehr with producing values. Fort example:
    * def head: A
    * 2. When method param has a function that takes T then this is legal because
    * inside function param variance flips. For example:
    * def dropWhile(p: (A) ⇒ Boolean): Iterable[A]
    * 3. When method param has a function that needs to return a type in relation to A then this is not legal (because
    * flipped covariance is contra-variance and it is in producer position)
    * and temporary new (invariant) type is introduced for this method in order to solve it. For example:
    * def flatMap[B](f: (A) ⇒ GenTraversableOnce[B]): Iterable[B]
    * def reduceLeft[B >: A](op: (B, A) ⇒ B): B
    * 4. Arrays are exceptions as they are alwasy invariant. For example following works:
    * def copyToArray(xs: Array[A]): Unit
    *
    *
    */
}
