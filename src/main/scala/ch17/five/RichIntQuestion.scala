package ch17.five

/**
  *5. Why does RichInt implement Comparable[Int] and not Comparable[RichInt]?
  */
object RichIntQuestion extends App {
  //Implicit conversion from Int to RichInt does not mean that Comparable[Int] can be converted to Comparable[RichInt]

  // By design the type used by programmers is Int and not RichInt.
  // Thus RichInt implements several generic traits with type param Int.
  // So the original type bound to type variable is Int and thus all used bound conditions are based on T.
  // Thus it would be compile error to write "class Data[T < Comparable[T]]" and use it for Int
  // because if T=Int then Int does not implement Comparable[Int] and also if RichInt would implement only Comparable[RichInt]
  // then RichInt would not implement Comparabe[Int]. (because there is no inheritance relationship between Int and RichInt)


}
