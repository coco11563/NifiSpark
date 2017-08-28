name := "NifiSpark"

version := "0.1"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-yarn_2.10" % "1.6.3",
  // https://mvnrepository.com/artifact/mysql/mysql-connector-java
  "mysql" % "mysql-connector-java" % "5.1.43",
  // https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2
  "org.apache.commons" % "commons-dbcp2" % "2.1.1"
)