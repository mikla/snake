package io.mikla.snake

import io.mikla.snake.SnakeTurn.{Down, Left, Right, Up}

sealed trait SnakeStep

object SnakeStep {
  case class Turn(to: SnakeTurn) extends SnakeStep
  case object Continue extends SnakeStep

  def fromString(str: String): SnakeStep = str match {
    case "U" | "u" => Turn(Up)
    case "R" | "r" => Turn(Right)
    case "L" | "l" => Turn(Left)
    case "D" | "d" => Turn(Down)
    case _         => Continue

  }
}
