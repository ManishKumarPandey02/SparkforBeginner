/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   CopyrightÂ© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/
package sparkexamples.misc
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

//Status - worked
object BroadcastRDD extends App {

    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession.builder().appName("BroadcastwithRDD").master("local").getOrCreate()

    val data = Seq(("James","Smith","USA","CA"),
                  ("Michael","Rose","USA","NY"),
                  ("Robert","Williams","USA","CA"),
                  ("Maria","Jones","USA","FL"))

    val rdd = spark.sparkContext.parallelize(data)

    val states = Map(("NY","New York"),("CA","California"),("FL","Florida"))
    val countries = Map(("USA","United States of America"),("IN","India"))

    val broadcastStates = spark.sparkContext.broadcast(states)
    val broadcastCountries = spark.sparkContext.broadcast(countries)

    val rdd2 = rdd.map(f=> {
                          val country = f._3
                          val state = f._4
                          val fullCountry = broadcastCountries.value.get(country).get
                          val fullState = broadcastStates.value.get(state).get
                          (f._1,f._2,fullCountry,fullState)
                   })

    println(rdd2.collect().mkString("\n"))

}