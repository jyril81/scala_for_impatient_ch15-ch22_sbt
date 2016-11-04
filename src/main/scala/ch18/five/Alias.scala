package ch18.five

/*
5. Consider the type alias
Click here to view code image
type NetworkMember = n.Member forSome { val n: Network }
and the function

def process(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
How does this differ from the process function in Section 18.8, “Existential Types,” on page
252?
 */
object Alias extends App {

  import scala.collection.mutable.ArrayBuffer

  type NetworkMember = n.Member forSome {val n: Network}

  class Network {

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]
    }

    private val members = new ArrayBuffer[Member]
    private val netwrokMembers = new ArrayBuffer[NetworkMember]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }

    def joinAsNetworkMember(name: String) = {
      val m = new Member(name)
      netwrokMembers += m
      m
    }
  }

  //method from page 252
  //This method will accept members from the same network, but reject members from different ones (network n is fixed)
  def process1[M <: n.Member forSome {val n : Network}](m1: M, m2: M) = (m1, m2)


  //with type alis network n is not fixed
  def process2(m1: NetworkMember, m2: NetworkMember) = (m1, m2)


  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("Fred")
  val wilma = chatter.join("Wilma")
  val barney = myFace.join("Barney")

  process1(fred, wilma)
  // OK
  //process1(fred, barney) // Error

  val fredNM = chatter.joinAsNetworkMember("Fred")
  val wilmaNM = chatter.joinAsNetworkMember("Wilma")
  val barneyNM = myFace.joinAsNetworkMember("Barney")
  process2(fredNM, wilmaNM) // OK
  process2(fredNM, barneyNM) // OK

}
