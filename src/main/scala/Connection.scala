package scaredis

import java.io.{BufferedReader, InputStreamReader, OutputStream}
import java.net.Socket

private[scaredis] trait ConnectionInterface {
  val host: String
  val port: Int
  val socket: Option[Socket]
  val outputStream: Option[OutputStream]
  val inputStream: Option[BufferedReader]
  def read: String
  def write(str: String): Unit

  def close: Unit = {
    inputStream.foreach { _.close() }
    outputStream.foreach { _.close() }
    socket.foreach{ _.close() }
  }

}

private[scaredis] class InitConnection(val host: String, val port: Int) extends ConnectionInterface {

  val socket = Some(new Socket(host, port))
  val outputStream = socket.map { _.getOutputStream }
  val inputStream = {
    if (socket.isDefined) Some(new BufferedReader(new InputStreamReader(socket.get.getInputStream)))
    else None
  }

  def read: String = {
    if (inputStream.isDefined) inputStream.get.readLine
    else ""
  }

  def write(str: String): Unit = {
    if (outputStream.isDefined) outputStream.get.write(str.getBytes)
  }

}
