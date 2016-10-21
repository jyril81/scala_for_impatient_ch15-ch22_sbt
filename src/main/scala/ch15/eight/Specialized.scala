/*
8. Add the allDifferent method to an object, compile and look at the bytecode. What methods did
the @specialized annotation generate?
 */

package ch15.eight

object Specialized {
  def allDifferent[@specialized T](x: T, y: T, z: T) = x != y && x != z && y != z
}


/**
  * Note that scala object code is generated into a file called "MyObjectname$.class"
  * Note the dollar sign at the end.
  *
  * $ /c/Program\ Files/Java/jdk1.8.0_66/bin/javap -p  Specialized$
  * Warning: Binary file Specialized$ contains ch15.eight.Specialized$
  * Compiled from "Specialized.scala"
  * public final class ch15.eight.Specialized$ {
  * public static final ch15.eight.Specialized$ MODULE$;
  * public static {};
  * public <T> boolean allDifferent(T, T, T);
  * public boolean allDifferent$mZc$sp(boolean, boolean, boolean);
  * public boolean allDifferent$mBc$sp(byte, byte, byte);
  * public boolean allDifferent$mCc$sp(char, char, char);
  * public boolean allDifferent$mDc$sp(double, double, double);
  * public boolean allDifferent$mFc$sp(float, float, float);
  * public boolean allDifferent$mIc$sp(int, int, int);
  * public boolean allDifferent$mJc$sp(long, long, long);
  * public boolean allDifferent$mSc$sp(short, short, short);
  * public boolean allDifferent$mVc$sp(scala.runtime.BoxedUnit, scala.runtime.BoxedUnit, scala.runtime.BoxedUnit);
  * private ch15.eight.Specialized$();
  * }
  *
  */
