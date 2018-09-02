name := "sparkSubmit"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark"  %%  "spark-core"      % "2.2.0" % "provided",
  "org.apache.spark"  %%  "spark-sql"       % "2.2.0",
  "org.apache.spark"  %%  "spark-mllib"     % "2.2.0",
  "org.apache.spark"  %%  "spark-streaming" % "2.2.0" % "provided",
  "org.apache.hive"   % "hive-jdbc" % "1.2.1"
  // https://mvnrepository.com/artifact/com.ibm.db2.jcc/db2jcc4

)
