package ch18.ten

/*
10. Self types can usually be replaced with traits that extend classes, but there can be situations
where using self types changes the initialization and override orders. Construct such an example.
 */

object OrderingExample extends App {

  //so the goal is to come up with an example where in first case self type is used (without traits) and
  // in second case traits (without self types) is used.
  //Both examples should lead to similar result, but initialization/override order should be different

  //i think the key here is to understand the order of initialization when using traits (from right to left)



}
