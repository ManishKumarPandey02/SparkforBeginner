/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact 				                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/
package util

import java.util.Properties
import java.io.{FileOutputStream, OutputStream, InputStream, FileInputStream}

class Property {
  //Constructor code
  private val prop : Properties = new Properties()
  private val inputStream : InputStream = new FileInputStream("application.properties")
  prop.load(inputStream)

  //it read from  "application.properties" F:\Learning\BigData\projects\Training\application.properties
  def getEmpDatasetPath() : String = {
    return prop.getProperty("dataset.emp.path")
  }

//  def loadProperty(): Unit = {
//    // method to load property file
//    var prop : Properties = new Properties()
//    var inputStream : InputStream = new FileInputStream("application.properties")
//    prop.load(inputStream)
//
//    println(prop.getProperty("url"))
//    println(prop.getProperty("userid"))
//
//  }

  def createProperties(): Unit ={
 // method to update property file
    var p : Properties = new Properties()
    var os : OutputStream = new FileOutputStream("application.properties")
    p.setProperty("url","localhost")
    p.setProperty("userid","testuser")
    p.store(os,null )

  }

}
