package io.mikla.snake

import io.mikla.snake.SnakeTurn.Up

case class SnakeCommands(commands: List[SnakeTurn]) {
  def add(turn: SnakeTurn): SnakeCommands = copy(commands = turn :: commands)
  def last: SnakeTurn = commands.head
  def isValidNext(turn: SnakeTurn): Boolean =
    last.opposite != turn
}

object SnakeCommands {
  def init(initSnake: Snake): SnakeCommands = SnakeCommands(
    List.fill(initSnake.length)(Up)
  )
}
