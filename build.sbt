import sbt.Resolver
import sbt._
import Keys._

name := "paye-filing-exb-spike-acceptance-tests"

version := "0.2.0"

scalaVersion := "2.12.12"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

resolvers += "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"
resolvers += Resolver.bintrayRepo("hmrc", "releases")

  testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/html-report")
  testOptions in Test += Tests.Argument("-o")

libraryDependencies ++= Seq(
  "uk.gov.hmrc"                %% "webdriver-factory"       % "0.25.0"   % "test",
  "org.scalatest"              %% "scalatest"               % "3.2.10" % "test",
  "org.pegdown"                %  "pegdown"                 % "1.4.2" % "test",
  "com.typesafe"               %  "config"                  % "1.3.2",
  "org.scalatestplus"          %% "selenium-3-141"          % "3.2.10.0" % "test",
  "com.vladsch.flexmark"       % "flexmark-all"             % "0.62.2"
  )
