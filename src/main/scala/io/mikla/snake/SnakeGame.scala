package io.mikla.snake

import scala.util.Random

case class SnakeGame(
    width: Int,
    height: Int,
    snake: Snake,
    commands: SnakeCommands,
    foodPosition: Cord
) {

  def nextFood(snake: Snake): Cord = {
    val potentialCords = (for {
      x <- 0 until width
      y <- 0 until height
    } yield Cord(x, y)).filterNot(snake.sn.contains)

    potentialCords(Random.nextInt(potentialCords.length - 1))
  }

  /** @return None - if game is over, or next game state
    */
  def step(nextStep: SnakeStep): Option[SnakeGame] = {

    val nextCmd = nextStep match {
      case SnakeStep.Continue => commands.last
      case SnakeStep.Turn(to) =>
        if (commands.isValidNext(to)) to else commands.last
    }

    val cmds = commands.add(nextCmd)
    val newSnake = snake.move(cmds).normalize(width, height)
    val (extendedSnake, foodCord) = if (newSnake.isReachedFood(foodPosition)) {
      val extendSn = snake.addHead(foodPosition)
      (extendSn, nextFood(extendSn))
    } else (newSnake, foodPosition)

    Option.unless(extendedSnake.hasLoop)(
      copy(
        snake = extendedSnake,
        commands = cmds,
        foodPosition = foodCord
      )
    )
  }

}
