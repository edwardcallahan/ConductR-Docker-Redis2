import ByteConversions._
import com.typesafe.sbt.packager.docker._

lazy val commonSettings: Seq[Setting[_]] = Seq(
  version in ThisBuild := "2.0"
  )

lazy val root = (project in file(".")).
  enablePlugins(ConductRPlugin, JavaAppPackaging).
  settings(
    commonSettings,
    name := "redis2",
    dockerCommands := Seq(
      Cmd("FROM", "redis:2")
    ),
    scriptClasspathOrdering := Seq.empty,
    BundleKeys.system := "redis2",
    BundleKeys.bundleType := Docker,
    BundleKeys.nrOfCpus := 1.0,
    BundleKeys.memory := 128.MB,
    BundleKeys.diskSpace := 1.GB,
    BundleKeys.roles := Set("web"),
    BundleKeys.endpoints := Map(
      "redis" -> Endpoint("tcp", 6379, services = Set(uri("http://:6379/redis")))
    ),
    BundleKeys.startCommand := Seq.empty,
    BundleKeys.checks := Seq(uri("docker+$REDIS_HOST"))
  )
