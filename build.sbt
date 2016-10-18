name := "scala_for_impatient_ch15-ch22_sbt"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test->default"
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
