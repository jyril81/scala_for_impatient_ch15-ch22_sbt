/*
8. Add the allDifferent method to an object, compile and look at the bytecode. What methods did
the @specialized annotation generate?
 */

package ch15.eight

object Specialized {
  def allDifferent[T](x: T, y: T, z: T) = x != y && x != z && y != z
}
