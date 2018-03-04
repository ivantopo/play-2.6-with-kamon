name := """play-2.6-with-kamon"""
organization := "kamon"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += "io.kamon" %% "kamon-core" % "1.1.0"
libraryDependencies += "io.kamon" %% "kamon-play-2.6" % "1.0.2"
libraryDependencies += "io.kamon" %% "kamon-logback" % "1.0.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "kamon.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "kamon.binders._"
