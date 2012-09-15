package scaredis

private[scaredis] object MessageDelineators {
  val SINGLE_LINE = "+"
  val ERROR = "-"
  val INTEGER = ":"
  val BULK_REPLY = "$"
  val MULTI_BULK_REPLY = "*"
}
