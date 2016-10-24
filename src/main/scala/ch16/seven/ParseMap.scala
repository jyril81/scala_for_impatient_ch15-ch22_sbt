package ch16.seven

object ParseMap extends App {

  def parse(map: Map[String, String]): String = {
    "<dl>" +
      map.keys.map(k => "<dt>" + k + "</dt>" + "<dd>" + map.get(k).get + "</dd>").mkString +
      "</dl>"
  }

  println(parse(Map("A" -> "1", "B" -> "2")))
}
