package scaredis

trait SetterCommands {
  this: ConnectionInterface =>

  def +=[T](item: T) = ???
  def +=[T](items: T*) = ???

}
