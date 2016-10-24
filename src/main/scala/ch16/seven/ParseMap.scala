package ch16.seven

object ParseMap extends App {

  //building a string
  def parse(map: Map[String, String]): String = {
    "<dl>" +
      map.keys.map(k => "<dt>" + k + "</dt>" + "<dd>" + map.get(k).get + "</dd>").mkString +
      "</dl>"
  }

  //improved version, building as xml
  def parse2(map: Map[String, String]) = {
    <dl>
      {map.keys.map(k => <dt>
      {k}
    </dt> <dd>
      {map.get(k).get}
    </dd>)}
    </dl>
  }

  println(parse(Map("A" -> "1", "B" -> "2")))
  println(parse2(Map("A" -> "1", "B" -> "2")))
}
