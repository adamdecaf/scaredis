package scaredis

object RedisClient {
  def apply(host: String = "localhost", port: Int = 6379) =
    new InitConnection(host: String, port: Int)
}
