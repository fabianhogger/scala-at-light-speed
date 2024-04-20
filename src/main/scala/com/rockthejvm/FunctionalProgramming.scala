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
  println(aMappedList)
  println(aMappedList)




}
