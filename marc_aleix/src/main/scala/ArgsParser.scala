import scala.util.Try

class ArgsParser(arguments: String) {
  def stringArgument(s: String): String = {
    arguments.split(" ").length match {
      case 1 => ""
      case _ => {
        val parameters = arguments.split(" ").dropWhile(_ != s)(1)
        if (parameters.startsWith("-")) "" else parameters
      }
    }
  }

  def booleanArgument(s: String): Boolean = arguments.contains("-l")

  def intArgument(s: String): Int = {
    val portNumber = arguments.split(" ").dropWhile(_ != s)
    if (Try(portNumber(1).toInt).isSuccess) {
      portNumber(1).toInt
    } else {
      0
    }
  }
}
