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
import org.apache.spark.storage.StorageLevel

object DFcachePersist {
  def main(args:Array[String]):Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder().master("local[1]").appName("EmployeeDF").getOrCreate()
    val datafilepath_emp = "src\\main\\datasets\\empds\\emp_data.csv"
    val df_emp = spark.read.format("csv")
                      .option("header", true)
                      .option("inferSchema", true)
                      .load(datafilepath_emp)

    //    import org.apache.spark.storage.StorageLevel
    df_emp.cache()
    df_emp.persist(StorageLevel.MEMORY_AND_DISK)
    df_emp.persist(StorageLevel.DISK_ONLY)

    df_emp.show()

  } // main()
}
