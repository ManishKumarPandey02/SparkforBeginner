/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 							                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   CopyrightÂ© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/

package sparkexamples.dataframe

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object EmployeeDFJoin {

  def main(args:Array[String]):Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder().master("local[1]").appName("EmployeeDF").getOrCreate()
    val datafilepath_emp = "src\\main\\datasets\\empds\\emp_data.csv"
    val df_emp = spark.read.format("csv")
                      .option("header", true)
                      .option("inferSchema", true)
                      .load(datafilepath_emp)

    val datafilepath_dept = "src\\main\\datasets\\empds\\emp_dept.csv"
    val df_dept = spark.read.format("csv")
                        .option("header", true)
                        .option("inferSchema", true)
                        .load(datafilepath_dept)

    df_emp.createOrReplaceTempView("emp_table")
    df_dept.createOrReplaceTempView("dept_table")
    //Option 1
    val df_final = spark.sql("SELECT emp.*, dept.* FROM emp_table emp FULL OUTER JOIN dept_table dept ON emp.deptno=dept.deptno")
    df_final.show()

    //Option 2
    val df3 = df_emp.join(df_dept,df_emp("deptno")===df_dept("deptno"),"INNER")
    df3.show()

  } // main()
  }
