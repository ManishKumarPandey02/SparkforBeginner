/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/
package test
import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}

object JsonExample {

  def main(args:Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession.builder().master("local[1]").appName("EmployeeDF").getOrCreate()
    val df = spark.read.json("F:\\Learning\\BigData\\Spark\\sparkexamples.dataset\\employee-data\\emp_data.json")
    df.show()

  }// main
  }
