package ch18.one

/**
  * 1. Implement a Bug class modeling a bug that moves along a horizontal line. The move method moves
  * in the current direction, the turn method makes the bug turn around, and the show method prints the
  * current position. Make these methods chainable. For example,
  * *
  *bugsy.move(4).show().move(6).show().turn().move(5).show()
  * should display 4 10 5.
  */
object Bug extends App {

  class Bug {
    private var position: Int = _

    def move(steps: Int): Bug = {
      position += steps
      this
    }

    def show(): Bug = {
      print(position + " ");
      this
    }

    def turn(): Bug = {
      position = 0
      this
    }
  }

  private val bugsy: Bug = new Bug
  bugsy.move(4).show().move(6).show().turn().move(5).show()
}
