package io.mikla.snake

import io.mikla.snake.render.AsciiConsoleRenderer

object Simulate extends App {

  val renderer = new AsciiConsoleRenderer

  val initSnake = Snake.init(Cord(4, 4))
  val initCommands = SnakeCommands.init(initSnake)

  val game = SnakeGame(10, 10, initSnake, initCommands, Cord(1, 1))

  val inputSequence: Seq[SnakeStep] = List(
    SnakeStep.Turn(SnakeTurn.Left),
    SnakeStep.Continue,
    SnakeStep.Continue,
    SnakeStep.Turn(SnakeTurn.Down),
    SnakeStep.Continue,
    SnakeStep.Continue
  )

  private val finalGameState = inputSequence.foldLeft(Option(game)) {
    case (g, step) =>
      g.flatMap(_.step(step))
  }

  finalGameState.fold(println("Game Over"))(renderer.render)

}
