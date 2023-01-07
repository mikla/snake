package io.mikla.snake

import org.scalatest.flatspec._
import org.scalatest.matchers._

class SnakeGameSpec extends AnyFlatSpec with should.Matchers {

  "Game" should "over when snake collides with itself" in {
    val initSnake =
      Snake(List(Cord(5, 5), Cord(5, 4), Cord(5, 3), Cord(5, 2), Cord(5, 1)))
    val initCommands = SnakeCommands.init(initSnake)

    val rightTurn = SnakeGame(10, 10, initSnake, initCommands, Cord(1, 1))
      .step(SnakeStep.Turn(SnakeTurn.Right))
      .get

    val downTurn = rightTurn.step(SnakeStep.Turn(SnakeTurn.Down)).get
    val over = downTurn.step(SnakeStep.Turn(SnakeTurn.Left))

    assert(over.isEmpty)
  }

  "Snake" should "grow when reaches food" in {
    val initSnake = Snake.init(Cord(4, 4))
    val initCommands = SnakeCommands.init(initSnake)

    val eatFood = SnakeGame(10, 10, initSnake, initCommands, Cord(4, 5))
      .step(SnakeStep.Continue)
      .get

    assert(eatFood.snake.length == 3)
    assert(eatFood.foodPosition != Cord(4, 5))
  }

}
