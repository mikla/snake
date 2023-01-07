package io.mikla.snake.render
import io.mikla.snake.{Cord, SnakeGame}

class AsciiConsoleRenderer extends Renderer {

  override def render(game: SnakeGame): Unit = {
    val snakeHead = game.snake.sn.head
    val snakeTail = game.snake.sn.tail.toSet

    val map = ((game.height - 1) to 0 by -1).map { y =>
      (0 until game.width).map { x =>
        val c = Cord(x, y)
        if (c == snakeHead) "o"
        else if (c == game.foodPosition) "@"
        else if (snakeTail.contains(c)) "x"
        else "."
      }
    }

    map.foreach { line =>
      println(line.mkString(""))
    }
  }

}
