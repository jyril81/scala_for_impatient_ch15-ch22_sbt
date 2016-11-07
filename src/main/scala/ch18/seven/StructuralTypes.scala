package ch18.seven

/**
  * 7. Implement a method that receives an object of any class that has a method
  * def close(): Unit
  * together with a function that processes that object. Call the function and invoke the close
  * method upon completion, or when any exception occurs.
  */
object StructuralTypes extends App {

  def acceptStructural(target: {def close(): Unit}, f: ({def close(): Unit}) => Unit) = {
    try {
      f(target)
    } finally {
      target.close()
    }
  }

  case class Structural(val id: String) {
    def close(): Unit = {
      println("Closing " + id)
    }
  }

  acceptStructural(Structural("123"), x => print("Processing " + x))
  acceptStructural(Structural("123"), x => {
    print("Processing " + x + ", and now exception happened")
    throw new RuntimeException("Exception")
  })
}


