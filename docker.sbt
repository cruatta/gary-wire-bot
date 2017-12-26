/*
https://sbt-native-packager.readthedocs.io/en/stable/formats/docker.html
 */

enablePlugins(AshScriptPlugin)

dockerUsername := Some("cruatta")

dockerBaseImage := "openjdk:8u151-jre-alpine"

dockerUpdateLatest := true
