package ch18.two

/**
  * 2. Provide a fluent interface for the Bug class of the preceding exercise, so that one can write
  * bugsy move 4 and show and then move 6 and show turn around move 5 and show
  *
  */
object FluentBug extends App {

  /**
    * bugsy move 4 and show and then move 6 and show turn around move 5 and show
    *
    * is parsed as
    *
    * bugsy.move(4).and(show).and(then).move(6).and(show).turn(around).move(5).and(show)
    */

  object show

  object then

  object around

  class Bug {
    private var position: Int = _

    def move(steps: Int) = {
      position += steps
      this
    }

    def turn(obj: around.type) = {
      position = 0
      this
    }

    def and(obj: show.type) = {
      print(position + " ")
      this
    }

    def and(obj: then.type) = {
      this
    }
  }

  private val bugsy: Bug = new Bug
  bugsy move 4 and show and then move 6 and show turn around move 5 and show

}
