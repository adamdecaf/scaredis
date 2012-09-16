package scaredis

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import java.io.{BufferedReader, InputStreamReader, OutputStream, FileReader, File, FileOutputStream}
import java.net.Socket

class MockConnection extends ConnectionInterface with AllCommands {

  // Just default values that don't mean anything. There should be a better way of doing this...
  val host: String = ""
  val port: Int = 0
  lazy val socket = None
  lazy val outputStream = None
  lazy val inputStream = None

  var nextLine = ""
  def read: String = nextLine
  def write(str: String): Unit = nextLine = str
}

trait redisCommandBuildingContext extends Scope with Specification {

  type Result = org.specs2.execute.Result

  val mockRedis = new MockConnection()
  mockRedis.close

  // This assumes we've ran the command already
  def check[T](f: => T)(validResult: String): Result = {
    f; mockRedis.read === validResult
  }

  def checkNonEmpty[T](f: => T): Result = {
    f; mockRedis.read.size must be_>(0)
  }

}
