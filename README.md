# Args Kata - ScalaBCN 22/02/17

[Meetup link](https://www.meetup.com/Scala-Developers-Barcelona/events/237631009/)

This repository aims to collect the kata solutions done at the coding dojo.

## How to include your solution

Fork the repository

Add the next code snipped to `build.sbt` file with your information

```Scala
lazy val <YOUR_NAMES> = (project in file("<YOUR_NAMES>"))
  .settings(
    name                := "<YOUR_NAMES>",
    scalaVersion        := "2.12.1",
    libraryDependencies ++= libraryDependenciesProd ++ libraryDependenciesTest
  )
```

Once the project is build, include your code

Create a pull request!