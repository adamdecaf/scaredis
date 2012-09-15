package scaredis

import scala.annotation.tailrec

trait BasicCommands {
  this: ConnectionInterface =>

  def info = {
    @tailrec
    def readOrReturn(current: String): String = {
      val line = read
      if (line.trim.isEmpty) current
      else readOrReturn(current + crlf + line)
    }

    write("INFO" + crlf)
    readOrReturn(read)
  }

}
