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

object WordCountRDD extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder().appName("Broadcastdf").master("local").getOrCreate()

  val rdd_lines = spark.sparkContext.textFile("src\\main\\datasets\\wordcount.txt")
  rdd_lines.foreach(println)
  val rdd_words = rdd_lines.flatMap( w => w.split(" "))
  val rdd_kv = rdd_words.map(w => (w,1))
  val wordcount = rdd_kv.reduceByKey(_+_)
  println("-- word count output ---")
  wordcount.foreach(println)

}
