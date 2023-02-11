/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 						                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/

package sparkexamples.dataframe

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object EmployeeDFJSON {
  def main(args:Array[String]):Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder().master("local[1]").appName("EmployeeDS").getOrCreate()
    val datafilepath_emp = "src\\main\\datasets\\empds\\emp_data.json"
    val df = spark.read.json(datafilepath_emp)

    df.createOrReplaceTempView("tbl1")

    val df_reorder = df.select("empno","ename","designation","manager")
    df_reorder.show()

  } // main

}
