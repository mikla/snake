package io.mikla.snake

/* Cartesian coordinate */
case class Cord(x: Int, y: Int) {

  def up: Cord = copy(y = y + 1)
  def down: Cord = copy(y = y - 1)
  def left: Cord = copy(x = x - 1)
  def right: Cord = copy(x = x + 1)

  def turn(t: SnakeTurn): Cord = t match {
    case SnakeTurn.Down  => down
    case SnakeTurn.Left  => left
    case SnakeTurn.Right => right
    case SnakeTurn.Up    => up
  }

  def normalize(width: Int, height: Int): Cord = {
    val xx = if (x < 0) width + x else x % width
    val yy = if (y < 0) height + y else y % height
    Cord(xx, yy)
  }

}
