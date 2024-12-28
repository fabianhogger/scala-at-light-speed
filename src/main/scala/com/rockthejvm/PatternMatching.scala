package com.rockthejvm

object PatternMatching extends App {
  val anInteger = 55
  val order = anInteger match{
    case 1=> "first"
    case 2=> "second"
    case 3=> "third"
    case _ => anInteger + "th"
  }
  //PM is an expression
  println(order)
  case class Person(name: String,age: Int)
  val bob= Person("Bob", 43)
  //case class decomposition
  val personGreeting = bob match{
    case Person(n,a) =>s"Hi my name is $n and i am $a years old."
    case _ => "Something else"
  }

  println(personGreeting)
  // decontructing tuples
  val aList = List(1,2,3)
  val listDescription = aList match{
    case List(_,2,_) =>"List containing 2 on its second position"
    case _ => "unkown list"
  }
  println(listDescription)
  // PM will throw Matcherror if it doesn't match anything so always put _case
  // PM will try all cases in SEQUENCE
}
 
