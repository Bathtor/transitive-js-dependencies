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
    name := "library-part",
    libraryDependencies ++= Seq(
      "org.scalatest" %%% "scalatest"      % "3.2.5"    % "test"
    ),
    jsDependencies += ProvidedJS / "TestJSCode.js"
  )

