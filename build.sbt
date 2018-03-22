name := "gary-wire-bot"

version := "0.2"

organization := "com.ruatta"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

resolvers ++= Seq(
  "wire-snapshots" at "https://dl.bintray.com/wire-android/snapshots",
  "wire-releases" at "https://dl.bintray.com/wire-android/releases",
  "dkovacevic-lithium" at "https://packagecloud.io/dkovacevic/lithium/maven2"
)

enablePlugins(JavaAppPackaging)

val circeVersion = "0.8.0"
val scalaTestVersion = "3.0.4"
val wireBotVersion = "2.9.3"
val scalaJVersion = "2.3.0"
val mockitoVersion = "2.10.0"

val circeDependencies = Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
  "org.mockito" % "mockito-core" % mockitoVersion % "test"
)

libraryDependencies ++= Seq(
  //"com.wire.bots" % "bot-sdk" % wireBotVersion,
  "com.wire.bots" % "lithium" % wireBotVersion,
  "org.scalaj" %% "scalaj-http" % scalaJVersion,
  "org.scalactic" %% "scalactic" % scalaTestVersion
) ++ circeDependencies ++ testDependencies

