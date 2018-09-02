package com.batch17
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import java.util.Properties
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import scala.io.Source
import java.io.File
//object sparkHive extends App with SparkConfParam{

  object sparkHive {

    def main(args: Array[String]){
      val warehouseLocation = new File("spark-warehouse").getAbsolutePath
  lazy val sparkConf = new SparkConf()
    .setAppName("Learn Spark")
    .setMaster("local")
    .set("spark.cores.max", "2")
    .set("spark.sql.parquet.binaryAsString","true")
  lazy val spark = SparkSession
    .builder()
    .config(sparkConf)
    .config("spark.sql.warehouse.dir", warehouseLocation)
 //   .enableHiveSupport()
    .getOrCreate()

  spark.sql("CREATE TABLE IF NOT EXISTS employee17(id INT, name STRING, age INT) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'")

  import spark.implicits._
  import spark.sql

  spark.sql("LOAD DATA LOCAL INPATH 'employee.txt' INTO TABLE employee17")

  spark.sql("FROM employee17 SELECT id, name, age").show()

  /*
   spark.sql("CREATE TABLE IF NOT EXISTS employee18(id INT, name STRING, age INT) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'")

 spark.sql("LOAD DATA LOCAL INPATH '/test/employee.txt' INTO TABLE employee18")




  spark.sql("LOAD DATA LOCAL INPATH '/test/employee.txt' INTO TABLE employee18")

  spark.sql("FROM employee18 SELECT id, name, age").show()

  spark.sql(s"CREATE EXTERNAL TABLE IF NOT EXISTS hive_extrnl17(id INT, name STRING, age INT) STORED AS PARQUET LOCATION '/home/test/par1'")

  spark.sql(s"CREATE EXTERNAL TABLE IF NOT EXISTS hive_extrnl18(id INT, name STRING, age INT) STORED AS PARQUET LOCATION '/home/test/par1'")

  val df = spark.table("employee17")

  df.show()

  df.write.parquet("/home/test/par1")

  spark.sql("SELECT * FROM hive_extrnl17").show()
  spark.sql("SELECT * FROM hive_extrnl18").show()

*/
}
  }
