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
}
