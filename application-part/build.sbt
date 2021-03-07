lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(JSDependenciesPlugin)
  .settings(
    inThisBuild(List(
      organization := "com.lkroll",
      version      := "0.1-SNAPSHOT",
      scalaVersion := "2.13.5"
    )),
    name := "application-part",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "1.1.0",
      "com.lkroll"  %%% "library-part"    % "0.1-SNAPSHOT",
      "org.scalatest" %%% "scalatest"      % "3.2.5"    % "test"
    ),
    scalaJSUseMainModuleInitializer := true,
    mainClass := Some("com.lkroll.testing.MainApp"),
    skip in packageJSDependencies := false
  )


// Automatically generate index-dev.html which uses *-fastopt.js
resourceGenerators in Compile += Def.task {
  val source = (resourceDirectory in Compile).value / "index.html"
  val target = (resourceManaged in Compile).value / "index-dev.html"

  val fullFileName = (artifactPath in (Compile, fullOptJS)).value.getName
  val fastFileName = (artifactPath in (Compile, fastOptJS)).value.getName

  IO.writeLines(target,
    IO.readLines(source).map {
      line => line.replace(fullFileName, fastFileName)
    }
  )

  Seq(target)
}.taskValue
