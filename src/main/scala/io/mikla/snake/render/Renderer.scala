package io.mikla.snake.render

import io.mikla.snake.SnakeGame

trait Renderer {
  def render(game: SnakeGame): Unit
}


