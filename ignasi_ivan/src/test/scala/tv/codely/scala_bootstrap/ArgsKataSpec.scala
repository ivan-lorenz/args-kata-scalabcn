package tv.codely.scala_bootstrap

import org.scalatest._
import tv.codely.kata.Types.Schema
import tv.codely.kata._

final class ArgsKataSpec extends FlatSpec with Matchers {

  behavior of "Args Parsers"

  it should "identify a valid flag" in {

    val whitelist: Schema = Set(SingleFlag('a'))
    val input = "-a"
    ArgsParser.of(whitelist).parse(input) should be(Seq(ParsedFlag(SingleFlag('a'))))

  }

  it should "fail with an invalid flag" in {
    val whitelist: Schema = Set(SingleFlag('a'))
    val input = "-b"
    assertThrows[IllegalArgumentException]{
      ArgsParser.of(whitelist).parse(input)
    }
  }

  it should "fail with valid flag on invalid syntax" in {
    val whitelist: Schema = Set(SingleFlag('a'))
    val input = "a"
    assertThrows[IllegalArgumentException]{
      ArgsParser.of(whitelist).parse(input)
    }
  }

  it should "identify a flag with a value" in {
    val whitelist: Schema = Set(ValueFlag('a'))
    val input = "-a value"
    ArgsParser.of(whitelist).parse(input) should be(Seq(ParsedValueFlag(ValueFlag('a'), "value")))
  }

}
