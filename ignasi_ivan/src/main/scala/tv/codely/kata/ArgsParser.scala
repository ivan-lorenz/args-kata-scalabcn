package tv.codely.kata

sealed trait Arg {
  def c: Char
}
case class SingleFlag(c: Char) extends Arg
case class ValueFlag(c: Char) extends Arg

sealed trait ParsedArgs
case class ParsedFlag(c: SingleFlag) extends ParsedArgs
case class ParsedValueFlag(c: ValueFlag, value: String) extends ParsedArgs

object Types {
  type Schema = Set[Arg]
  type Request = Seq[ParsedArgs]
}

import Types._

class ArgsParser(whitelist: Schema) {

  private val myValidChars = whitelist.map(_.c)

  private def recurs(input: List[String], partial: Request): Request = {
    input match {
      case Nil => partial
      case h :: t =>
        if (!h.matches("-[a-z]{1}") ||
          h.replace("-", "").length != 1 ||
          !myValidChars.contains(h.replace("-", "").charAt(0))) {
          throw new IllegalArgumentException
        } else {

          whitelist.find(_.c == h.replace("-", "").charAt(0)).get match {
            case s: SingleFlag => recurs(t, partial :+ ParsedFlag(s))
            case s: ValueFlag => recurs(t.tail, partial :+ ParsedValueFlag(s, t.head))
          }
        }
    }
  }

  def parse(input: String): Request = {

    val seqOfInputs: List[String] = input.split(" ").toList

    recurs(seqOfInputs, Seq.empty[ParsedArgs])
  }
}

object ArgsParser {
  def of(whitelist: Schema): ArgsParser = new ArgsParser(whitelist)
}


