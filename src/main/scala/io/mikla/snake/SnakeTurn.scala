package io.mikla.snake

sealed trait SnakeTurn {
  def opposite: SnakeTurn
}

object SnakeTurn {
  case object Left extends SnakeTurn {
    override def opposite: SnakeTurn = Right
  }
  case object Right extends SnakeTurn {
    override def opposite: SnakeTurn = Left
  }
  case object Up extends SnakeTurn {
    override def opposite: SnakeTurn = Down
  }
  case object Down extends SnakeTurn {
    override def opposite: SnakeTurn = Up
  }

}
