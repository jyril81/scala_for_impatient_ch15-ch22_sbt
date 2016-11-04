package ch18.four

object MemberEquals extends App {

  import scala.collection.mutable.ArrayBuffer

  class Network {

    class Member(val name: String) {
      private val network = Network.this
      val contacts = new ArrayBuffer[Member]

      override def equals(obj: scala.Any): Boolean = {
        if (obj.isInstanceOf[Member]) {
          val asMember = obj.asInstanceOf[Member]
          network == asMember.network
        } else {
          false
        }
      }
    }

    private val members = new ArrayBuffer[Member]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }

  private val network1: Network = new Network
  private val m1: _root_.ch18.four.MemberEquals.network1.Member = network1.join("m1")
  private val m2: _root_.ch18.four.MemberEquals.network1.Member = network1.join("m2")

  private val network2: Network = new Network
  private val m3: _root_.ch18.four.MemberEquals.network2.Member = network2.join("m3")

  //true
  println(m1.equals(m2))
  //false
  println(m1.equals(m3))

}
