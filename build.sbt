ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "testScala",
    idePackagePrefix := Some("com.jmfg.training"),

    libraryDependencies += "org.typelevel" %% "cats-core" % "2.10.0",
    libraryDependencies += "org.typelevel" %% "cats-laws" % "2.10.0",
    libraryDependencies += "org.typelevel" %% "discipline-core" % "1.5.1",
    libraryDependencies += "org.typelevel" %% "discipline-scalatest" % "2.2.0",
    libraryDependencies += "com.github.javafaker" % "javafaker" % "1.0.2",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17"
  )
