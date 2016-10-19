package ch15.two

//class, type parameter, primary ctor and ctor param
@deprecated class AnnotationDemo[@deprecated T] @deprecated()(@deprecated var data: T) {
  //field
  @deprecated var moreData: Map[T, T] = _

  //method and method param
  @deprecated def method(@deprecated p: T) = {
    //expression
    data = (moreData.get(p): @deprecated).get
  }

}
