package io.mikla.snake

import org.scalatest._
import flatspec._
import matchers._

class SnakeSpec extends AnyFlatSpec with should.Matchers {

  "Snake" should "init default coordinates" in {
    val snake = Snake.init(Cord(2, 2))
    snake.sn should be(List(Cord(2, 2), Cord(2, 1)))
  }

  it should "support coordinates normalization (right border)" in {
    val snake = Snake(List(Cord(5, 2), Cord(4, 2)))
    snake.normalize(5, 5).sn should be(List(Cord(0, 2), Cord(4, 2)))
  }

  it should "support coordinates normalization (left border)" in {
    val snake = Snake(List(Cord(-1, 2), Cord(0, 2)))
    snake.normalize(5, 5).sn should be(List(Cord(4, 2), Cord(0, 2)))
  }

  it should "support coordinates normalization (top border)" in {
    val snake = Snake(List(Cord(2, 5), Cord(2, 4)))
    snake.normalize(5, 5).sn should be(List(Cord(2, 0), Cord(2, 4)))
  }

  it should "support coordinates normalization (bottom border)" in {
    val snake = Snake(List(Cord(2, -1), Cord(2, 0)))
    snake.normalize(5, 5).sn should be(List(Cord(2, 4), Cord(2, 0)))
  }


}
