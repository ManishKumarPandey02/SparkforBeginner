/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/
package test
import org.apache.log4j.{Level, Logger}
import util.Property

object testProperty {

  def main(args:Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    var prop: Property = new Property
    //p.createProperties()
    //p.loadProperty()
    println(prop.getEmpDatasetPath())

  } // main ()

}
