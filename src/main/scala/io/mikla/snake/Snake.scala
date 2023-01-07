package io.mikla.snake

/** Represent snake coordinates, head if the list - head of the snake
  */
case class Snake(sn: List[Cord]) {
  def addHead(newHead: Cord): Snake = copy(sn = newHead :: sn)
  def length: Int = sn.length
  def hasLoop: Boolean = sn.tail.contains(sn.head)
  def isReachedFood(foodPosition: Cord): Boolean =
    sn.head == foodPosition

  def move(commands: SnakeCommands): Snake = {
    Snake(
      sn.zip(commands.commands).map { case (cord, turn) =>
        cord.turn(turn)
      }
    )
  }

  def normalize(width: Int, height: Int): Snake =
    copy(sn = this.sn.map(_.normalize(width, height)))

}

object Snake {
  def init(head: Cord): Snake = Snake(List(head, head.down))
}
