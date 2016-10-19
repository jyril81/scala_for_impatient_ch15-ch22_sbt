/*
6. Write a Scala object with a volatile Boolean field. Have one thread sleep for some time, then
set the field to true, print a message, and exit. Another thread will keep checking whether the
field is true. If so, it prints a message and exits. If not, it sleeps for a short time and tries again.
What happens if the variable is not volatile?
 */

package ch15.six

object Threads extends App {
  //in theory, removing volatile  will break the logic because without volatile their is no guarantee that
  //one thread will see a change done to a variable by another thread
  //in practice on my machine results are identical, at least for a few times I tried it.
  @volatile var data: Boolean = false

  val t1: Thread = new Thread(new Runnable {
    override def run(): Unit = {
      Thread.sleep(1000)
      data = true
      println("Mutator: data set to true. Data =" + data)
    }
  })

  val t2: Thread = new Thread(new Runnable {
    override def run(): Unit = {
      while (data == false) {
        println("Checker: checking")
        Thread.sleep(50)
      }
      println("Checker: exiting, data became true. Data=" + true)
    }
  })

  t2.start()
  t1.start()

}
