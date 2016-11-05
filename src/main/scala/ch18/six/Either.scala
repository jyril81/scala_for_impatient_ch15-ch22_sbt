package ch18.six

/*
6. The Either type in the Scala library can be used for algorithms that return either a result or some
failure information. Write a function that takes two parameters: a sorted array of integers and an
integer value. Return either the index of the value in the array or the index of the element that is
closest to the value. Use an infix type as the return type.
 */
object Either extends App {

  /**
    * Helper structure to pass in foldLeft
    *
    * @param either       current best result
    * @param absDiff      abs of currently best diff
    * @param currentIndex index of the current elem in foldLeft function invocation
    */
  private case class Result(val either: Either[Int, Int], val absDiff: Int, val currentIndex: Int)

  //initial value to be returned when array is empty
  private val initial: Result = Result(Right(Int.MinValue), Int.MaxValue, 0)

  def closest(array: Array[Int], value: Int): Int Either Int = {
    //use foldLeft for traversing
    val r = array.foldLeft(initial) {
      (result, elem) => {
        val absDiff: Int = math.abs(value - elem)
        //exact match was already found
        if (result.absDiff == 0) Result(result.either, result.absDiff, result.currentIndex + 1)
        //exact match
        else if (absDiff == 0) Result(Left(result.currentIndex), absDiff, result.currentIndex + 1)
        //closer
        else if (absDiff < result.absDiff) Result(Right(result.currentIndex), absDiff, result.currentIndex + 1)
        //old result was closer
        else Result(result.either, result.absDiff, result.currentIndex + 1)
      }
    }
    r.either
  }


  val array = Array(1, 5, 10, 45)
  assert(Right(0).equals(closest(array, 0)))
  assert(Right(3).equals(closest(array, 100)))
  assert(Left(2).equals(closest(array, 10)))
  assert(Right(2).equals(closest(array, 20)))

}
