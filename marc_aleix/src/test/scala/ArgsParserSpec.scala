import org.scalatest.{Matchers, WordSpec}

final class ArgsParserSpec extends WordSpec with Matchers {

  "An ArgsParser" should {
    "return true when a '-l' argument is passed" in {
      val args = new ArgsParser("-l")
      args.booleanArgument("-l") shouldBe true
    }

    "return false when no '-l' argument is passed" in {
      val args = new ArgsParser("")
      args.booleanArgument("-l") shouldBe false
    }

    "return 8080 when '-p 8080'" in {
      val args = new ArgsParser("-p 8080")
      args.intArgument("-p") shouldBe 8080
    }

    "return 9090 when '-p 9090'" in {
      val args = new ArgsParser("-p 9090")
      args.intArgument("-p") shouldBe 9090
    }

    "return 0 when '-p' has no value, returns the default" in {
      val args = new ArgsParser("-p")
      args.intArgument("-p") shouldBe 0
    }

    "return '/usr/logs' when '-d /usr/logs'" in {
      val args = new ArgsParser("-d /usr/logs")
      args.stringArgument("-d") shouldBe "/usr/logs"
    }

    "return '/etc/host' when '-d /etc/host'" in {
      val args = new ArgsParser("-d /etc/host")
      args.stringArgument("-d") shouldBe "/etc/host"
    }

    "return an empty string when '-d' has no parameter" in {
      val args = new ArgsParser("-d")
      args.stringArgument("-d") shouldBe ""
    }

    "return true for '-l' argument and 9090 for '-p 9090' argument when '-l -p 9090'" in {
      val args = new ArgsParser("-l -p 9090")
      args.booleanArgument("-l") shouldBe true
      args.intArgument("-p") shouldBe 9090
    }

    "return true for '-l' argument and 9090 for '-p 9090' argument when '-p 9090 -l'" in {
      val args = new ArgsParser("-p 9090 -l")
      args.booleanArgument("-l") shouldBe true
      args.intArgument("-p") shouldBe 9090
    }

    "return empty string when '-d' is provided without parameters" in {
      val args = new ArgsParser("-d")
      args.stringArgument("-d") shouldBe ""
    }

    "return empty string when 'd' and 0 when '-p' is provided without parameters" in {
      val args = new ArgsParser("-d -p")
      args.stringArgument("-d") shouldBe ""
      args.intArgument("-p") shouldBe 0
    }
  }

}
