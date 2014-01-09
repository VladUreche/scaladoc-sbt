import sbt._
import Keys._

object MyBuild extends Build {

  // settings need to be given for each subproject:
  val mysettings = Defaults.defaultSettings ++ Seq(
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:postfixOps"),
    // be more precise: give the absolute path to the rootdoc file:
    scalacOptions in (Compile, doc) ++= Seq("-doc-root-content", baseDirectory.value + "/rootdoc.txt")
  )

  lazy val proj_one = Project(
    id = "one",
    base = file("./proj_one"),
    settings = mysettings
  )

  lazy val  proj_two = Project(
    id = "two",
    base = file("./proj_two"),
    settings = mysettings
  )
}
