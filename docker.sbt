/*
https://sbt-native-packager.readthedocs.io/en/stable/formats/docker.html
 */

import com.typesafe.sbt.packager.docker._

dockerBaseImage := "openjdk:8u151-jre-alpine"

dockerExposedPorts := Seq(8443, 8080, 8081)

dockerExposedVolumes := Seq("/opt/docker/conf")