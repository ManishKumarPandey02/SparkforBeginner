/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   CopyrightÂ© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/
package sparkexamples.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext, Time}

object SqlNetworkWordCount {
  def main(args: Array[String]): Unit = {
//    if (args.length < 2) {
//      System.err.println("Usage: NetworkWordCount <hostname> <port>")
//      System.exit(1)
//    }
//
//    //StreamingExamples.setStreamingLogLevels()
//
//    // Create the context with a 2 second batch size
//    val sparkConf = new SparkConf().setAppName("SqlNetworkWordCount")
//    val ssc = new StreamingContext(sparkConf, Seconds(2))
//
//    // Create a socket stream on target ip:port and count the
//    // words in input stream of \n delimited text (eg. generated by 'nc')
//    // Note that no duplication in storage level only for running locally.
//    // Replication necessary in distributed scenario for fault tolerance.
//    val lines = ssc.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_AND_DISK_SER)
//    val words = lines.flatMap(_.split(" "))
//
//    // Convert RDDs of the words DStream to DataFrame and run SQL query
//    words.foreachRDD { (sparkexamples.dataframe.rdd: RDD[String], time: Time) =>
//                    // Get the singleton instance of SparkSession
//                    val spark = SparkSessionSingleton.getInstance(sparkexamples.dataframe.rdd.sparkContext.getConf)
//
//                    import spark.implicits._
//
//                    // Convert RDD[String] to RDD[case class] to DataFrame
//                    val wordsDataFrame = sparkexamples.dataframe.rdd.map(w => Record(w)).toDF()
//
//                    // Creates a temporary view using the DataFrame
//                    wordsDataFrame.createOrReplaceTempView("words")
//
//                    // Do word count on table using SQL and print it
//                    val wordCountsDataFrame =
//                      spark.sql("select word, count(*) as total from words group by word")
//                    println(s"========= $time =========")
//                    wordCountsDataFrame.show()
//                  }
//
//    ssc.start()
//    ssc.awaitTermination()
  }

}
