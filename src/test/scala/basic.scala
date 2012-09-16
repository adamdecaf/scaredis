package scaredis

import org.specs2.mutable.Specification

object BasicCommandsSpec extends Specification {

  "Creating basic commands and prepping them for redis" should {
    "work as expected for meta commands" in new redisCommandBuildingContext {
      check(mockRedis.ping)("PING\r\n")
      checkNonEmpty(mockRedis.info)
      check(mockRedis.echo("hello"))("ECHO hello\r\n")
      check(mockRedis.bgsave)("BGSAVE\r\n")
      check(mockRedis.time)("TIME\r\n")
      check(mockRedis.quit)("QUIT\r\n")
    }
  }

}
