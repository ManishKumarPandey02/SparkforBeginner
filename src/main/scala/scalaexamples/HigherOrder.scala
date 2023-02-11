/****************************************************************
'*   Author:  Manish Kumar Pandey (Big Data, Cloud and Engineering Architect)   *
'*   Contact							                *
'*   Phone +91 9981472967           *
'*   email@ Manishkumarpandey02@yahoo.com                     *
'*   Copyright© 2018-2023     *
'*   Use only for learning purpose                              *
'***************************************************************/

package scalaexamples

object HigherOrder {

  def main(args:Array[String]) : Unit = {

    def getMax(x:Int,y:Int) : Int = if (x>y) x else y

    def getMaxOfThreeValues(X:Int,Y:Int, Z:Int, f:(Int,Int)=> Int) :Int = {
        val max_of_x_y = f(X,Y)
        val max_of_x_y_z = f(max_of_x_y,Z)
        max_of_x_y_z
    }
    val maxVal = getMaxOfThreeValues(50,20,30,getMax)
    println(maxVal)
  } // main

}
