/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/

package sparkexamples.dataset

import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.Encoders
import org.apache.spark.sql.types._
import java.sql.Date

// case class must be outside the object/main() else it gives error.
// if using date type in case calss then  import java.sql.Date
case class employee(empno: Int, ename: String, designation: String, manager: String,
                    hire_date: Date, sal:Int, deptno:Int)

object EmployeeDS {
  def main(args:Array[String]):Unit ={
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder().master("local[1]").appName("EmployeeDS").getOrCreate()

    // This import implicts is required else .as[employee] it will give error like "could-not-find-implicit-value-for-evidence-paramete"
    import spark.sqlContext.implicits._

    // spark-scala-cannot-up-cast-from-string-to-int-as-it-may-truncate
    // https://stackoverflow.com/questions/45414718/spark-scala-cannot-up-cast-from-string-to-int-as-it-may-truncate
    val schema = Encoders.product[employee].schema

    //val dspath = "F:\\Learning\\BigData\\Spark\\sparkexamples.dataset\\employee-data\\emp_data.csv"
    val datafilepath = "src\\main\\datasets\\empds\\emp_data.csv"
    val employeeDS = spark.read
      .option("header", "true")
      //.option("charset", "UTF8")
      .option("delimiter",",")
      .option("dateFormat", "MM/dd/yyyy")
      .schema(schema)
      .csv(datafilepath)
      .as[employee]

    employeeDS.createOrReplaceTempView("Emptable")
    val df = spark.sql("select * from Emptable")
    df.show()
    df.printSchema()
    // TO SHOW datatype is checked at compile time. so if you use string instead of 1000, they you will get error. which is not
    // the case in sparkexamples.dataframe.
    val df6 = employeeDS.filter(x => x.sal >1000)
    df6.show()

  } // main()
}
