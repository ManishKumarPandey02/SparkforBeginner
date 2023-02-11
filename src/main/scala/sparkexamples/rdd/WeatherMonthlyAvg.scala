/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/

package sparkexamples.rdd

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object WeatherMonthlyAvg extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder().appName("Broadcastdf").master("local").getOrCreate()

  val rdd = spark.sparkContext.textFile("src\\main\\datasets\\weather.txt")

  val rdd_temp = rdd.map(x => {
              val a = x.split(",")
              (a(0) + "_" + a(1),a(3).toInt)
      })
  val rdd_m = rdd.map(x => {
    val a = x.split(",")
    (a(0) + "_" + a(1),1)
  })

  val rdd_m_count = rdd_m.reduceByKey(_+_)
  rdd_m_count.foreach(println)

  val rdd3 = rdd_temp.reduceByKey(_+_)
  rdd3.foreach(println)

  //def add(x:String,y:String):Int = (x.toInt + y.toInt)

 }
