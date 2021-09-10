ThisBuild / scalaVersion := "2.13.6"

lazy val generated= project.in(file("generated"))
lazy val usage = project.in(file("usage")).dependsOn(generated)
