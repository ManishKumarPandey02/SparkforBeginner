/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/

package sparkexamples.dataframe

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.util.SizeEstimator

object EmployeeDFwithSchema {

  def main(args:Array[String]) : Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder().master("local[1]").getOrCreate()

    val empSchema = StructType(
                            Array(
                              StructField("empno", IntegerType, true),
                              StructField("ename", StringType, true),
                              StructField("designation", StringType, true),
                              StructField("manager", StringType, true),
                              StructField("hire_date", DateType, true),
                              StructField("sal", DoubleType, true),
                              StructField("deptno", IntegerType, true)
                            )
                      )

    val datafilepath_emp = "src\\main\\datasets\\empds\\emp_data.csv"
    val df_csv = spark.read.format("csv")
                      .option("header","true")
                     // .option("mode", "DROPMALFORMED")
                    //  .option("delimiter", ",")
                      .option("dateFormat", "MM/dd/yyyy")
                      .schema(empSchema)
                      .load(datafilepath_emp)

    df_csv.show()
    df_csv.printSchema()


  } // main()

}
