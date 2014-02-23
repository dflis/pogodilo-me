name := "pogodilo-me"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  "com.typesafe.play" %% "play-slick" % "0.6.0.1",
  "mysql" % "mysql-connector-java" % "5.1.24",
  cache
)     

play.Project.playScalaSettings
