/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/

package sparkexamples.misc

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.util.LongAccumulator

object accumulator {
  def main(args:Array[String]):Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder().master("local[1]").appName("LoadEmployee").getOrCreate()
    //empno,ename,designation,manager,hire_date,sal,deptno
    val dspath = "src\\main\\datasets\\empds\\emp_data.csv"
    val rdd = spark.sparkContext.textFile(dspath)

    /* use of non acumulator */
    println("-----count record using local variable----")
    var Count = 0
    val rdd1 = rdd.foreach(x => Count += 1 )
    println(Count)

    /* use of acumulator */
    println("-----count record using accumulator----")
    var countAccu = spark.sparkContext.longAccumulator("count1")

    val rdd2 = rdd.foreach(x => countAccu.add(1))
    println(countAccu.value)

  }
}
