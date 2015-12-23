name := "ScaleFunctionalProject"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12" % "test"
)

libraryDependencies += "com.novocode" % "junit-interface" % "0.11"


libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

libraryDependencies += "org.scala-lang.modules" % "scala-parser-combinators_2.11" % "1.0.4"
