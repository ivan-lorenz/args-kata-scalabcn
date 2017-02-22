name := "args-kata-scalabcn"

version := "1.0"

scalaVersion := "2.12.1"

lazy val marc_aleix = (project in file("marc_aleix"))
  .settings(
    name                := "marc_aleix",
    scalaVersion        := "2.12.1",
    libraryDependencies ++= libraryDependenciesProd ++ libraryDependenciesTest
  )

/** ********* PROD DEPENDENCIES *****************/
lazy val libraryDependenciesProd = Seq(
  "com.github.nscala-time" %% "nscala-time" % "2.16.0",
  "com.lihaoyi"            %% "pprint"      % "0.4.4"
)

/** ********* TEST DEPENDENCIES *****************/
lazy val libraryDependenciesTest = Seq(
  "org.scalatest" %% "scalatest"                   % "3.0.1" % Test,
  "org.scalamock" %% "scalamock-scalatest-support" % "3.4.2" % Test
)
