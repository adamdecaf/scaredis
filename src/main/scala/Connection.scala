package scaredis

import java.io.{BufferedReader, InputStreamReader, OutputStream}
import java.net.Socket

private[scaredis] trait ConnectionInterface {
  val host: String
  val port: Int
  val socket: Socket
  val outputStream: OutputStream
  val inputStream: BufferedReader
  def read: String
  def write(str: String): Unit
  def close: Unit
}

private[scaredis] class InitConnection(val host: String, val port: Int) extends ConnectionInterface {

  val socket = new Socket(host, port)
  val outputStream = socket.getOutputStream
  val inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream))

  def read: String = {
    inputStream.readLine
  }

  def write(str: String): Unit = {
    outputStream.write(str.getBytes)
  }

  def close: Unit = {
    inputStream.close()
    outputStream.close()
    socket.close()
  }

}
