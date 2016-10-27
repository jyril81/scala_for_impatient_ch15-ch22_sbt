package ch17.six

/**
  *6. Write a generic method middle that returns the middle element from any Iterable[T]. For example,
  * middle("World") is 'r'.
  */
object Middle extends App {

  def middle[T](it: Iterable[T]) = {
    it.toSeq(it.size / 2)
  }


  println(middle("world"))
  println(middle(Array(1, 2, 3)))
  println(middle("ab"))
  println(middle("a"))
}
