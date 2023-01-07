package io.mikla.snake

import io.mikla.snake.render.AsciiConsoleRenderer

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Play extends App {

  val renderer = new AsciiConsoleRenderer

  @tailrec
  def gameLoop(game: SnakeGame): Unit = {
    renderer.render(game)

    val command = readLine

    game.step(SnakeStep.fromString(command)) match {
      case Some(value) => gameLoop(value)
      case None        => println("Game Over")
    }
  }

  val initSnake = Snake.init(Cord(4, 4))
  val initCommands = SnakeCommands.init(initSnake)

  val game = SnakeGame(10, 10, initSnake, initCommands, Cord(1, 1))

  gameLoop(game)
}
