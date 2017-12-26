/*
https://sbt-native-packager.readthedocs.io/en/stable/formats/docker.html
 */

import com.typesafe.sbt.packager.docker._

dockerBaseImage := "openjdk:8u151-jre-alpine"

dockerCommands ++= Seq(
  Cmd("USER", "root"),
  ExecCmd("RUN", "apk", "update"),
  ExecCmd("RUN", "apk", "upgrade"),
  ExecCmd("RUN", "apk", "add", "bash"),
  Cmd("USER", "daemon")
)
