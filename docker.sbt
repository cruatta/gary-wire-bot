/*
https://sbt-native-packager.readthedocs.io/en/stable/formats/docker.html
 */

enablePlugins(AshScriptPlugin)

import com.typesafe.sbt.packager.docker._

dockerUsername := Some("cruatta")

dockerBaseImage := "openjdk:8u151-jre-alpine"

dockerUpdateLatest := true

// Install JCE 8
dockerCommands ++= Seq(
  Cmd("USER", "root"),
  ExecCmd("RUN", "apk", "upgrade", "--update"),
  ExecCmd("RUN", "apk", "add", "curl", "unzip"),
  Cmd("RUN", "curl -jsSLH 'Cookie: oraclelicense=accept-securebackup-cookie' -o /tmp/unlimited_jce_policy.zip 'http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip'"),
  Cmd("RUN", "unzip -jo -d ${JAVA_HOME}/lib/security /tmp/unlimited_jce_policy.zip"),
  ExecCmd("RUN", "apk", "del", "curl", "unzip"),
  Cmd("RUN", "rm -rf /tmp/* /var/cache/apk/*"),
  Cmd("USER", "daemon")
)
