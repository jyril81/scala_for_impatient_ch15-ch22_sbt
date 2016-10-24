/*
2. What is the result of
<ul>
<li>Opening bracket: [</li>
<li>Closing bracket: ]</li>
<li>Opening brace: {</li>
<li>Closing brace: }</li>
</ul>
How do you fix it?
 */

package ch16.two

object Brackets extends App {

  //Brackets have special meaning so you can fix it by using double brackets syntax to escape them
  val s = <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracket: ]</li>
    <li>Opening brace: {{</li>
    <li>Closing brace: }}</li>
  </ul>
  println(s)

  //Other solution is to use scala embedded expressions to generate those brackets
  val exp = "{</li>\n    <li>Closing brace: }"
  val s2 = <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracket: ]</li>
    <li>Opening brace:
      {exp}
    </li>
  </ul>
  println(s2)
}
