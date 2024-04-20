package com.rockthejvm

object FunctionalProgramming extends App {
  //scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }
  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) //Invoking bob as a function === bob.apply(43)

  /*
  * Scala runs on the JVM
  * FUNCTIONAL PROGRAMMING:
  * - compose functions
  * - pass functions as arguments
  * - return them as results
  *  Conclusion? --> FunctionX
  */
  //instatiated a trait
  val simpleIncrementer = new Function1[Int, Int]{
    override def apply(arg: Int): Int = arg+1
  }
  simpleIncrementer.apply(23)
  simpleIncrementer(23)//same
  //grafontai esoterika etsi ta functions gia na douleuei sto jvm
  // all scala functions are instance of these function_x types
  val stringConcatenator = new Function2[String, String, String]{
    override def apply(arg1: String, arg2:String): String = arg1 + arg2
  }

  stringConcatenator("I love ","Scala")

  //usefull syntax sugars
  // val doubler: Function1[Int,Int] = (x: Int) => 2*x
  // val doubler: Int => Int = (x: Int) => 2* x
  val doubler  = (x: Int) => 2*x
  doubler(4)

  //Higher Order Functions
  //map method of list object
  val aMappedList = List(1,2,3).map(x => x + 1)

  //flat-map
  val aFlatMappedList = List(1,2,3).flatMap(x=>List(x,2 * x))
  println(aFlatMappedList)
  //curly brace syntax
  val aFlatMappedList2 = List(1,2,3).flatMap{ x=>
    List(x,2 * x)
  }//alternative

  //filter function
  val aFilteredList = List(1,2,3,4,5).filter(x => x<= 3)
  //shortest syntax
  val aFilteredList2 = List(1,2,3,4,5).filter(_ <=3)
  println(aFilteredList2)
  /*these functions return a new instance of a list
  * since values are immutable in scala
  * they can be chained
   */
  //all pairs between the numbers 1,2,3 and letters a,b,c
  val allPairs = List(1,2,3).flatMap(x=> List('a','b','c').map(letter => s"$x-$letter"))
  println(allPairs)
  //for comprehensions are a way to write these chains more clearly
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number-$letter"

  /** collections
   *
   *
   * */
  val  aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList //List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 //List(0,1,2,3,4,5,6)
  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence(1)
  println(aSequence)
  println(accessedElement)
  //vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)
  val fiV= aVector(0)
  //sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3)
  val setHas5 = aSet.contains(5)
  val anAddedSet = aSet + 5
  println(anAddedSet)
  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x=> 2*x).toList
  println(twoByTwo)
  // tuples
  val aTuple =("Bon","JOvi",1992,"Rock")
  // maps
  val aPhonebook=Map[String,Int](("al",1),"gr"->2)
  println((aPhonebook)



  )



}
