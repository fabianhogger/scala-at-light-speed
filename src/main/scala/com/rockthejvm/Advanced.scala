package com.rockthejvm

import scala.util.{Failure, Success, Try}
import concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
object Advanced extends App{

  //lazy evaluation
  lazy val aLazyValue =2
  lazy val lazyValWithSideEffect={
    println("Im lazy")
    43
  }
  val eagerVal= lazyValWithSideEffect+1
  //useful in infinite collections
  //pseudo-collections:Option,Try
  def methodWhichCanreturnNull(): String = "Hello, Scala"
  /*  if(methodWhichCanreturnNull()==null){
      //defensive code
    }

   */
  // a 'collection which contains at most one element
  val anOption = Option(methodWhichCanreturnNull())
  // in the case where the function returns null now the element is instead
  //will be of type None
  //and now we can pattern match that
  val stringprocessing = anOption match{
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I have obtained nothing"
  }

  def methodWhichCanthrowException(): String = throw new RuntimeException
  //normally try{methodWhichCanthrowException()}
  val atry = Try(methodWhichCanthrowException())
  // a try = try collection with either a value or an exception
  // and now we can pattern match that
  val anotherStringProcessing = atry match {
    case Success(validValue) => s"I have obtained a vlaid string: $validValue"
    case Failure(ex) => s"i have obtained an eception :$ex"
  }
/* evaluate something on another thread (asynchronous programming*/

val aFuture = Future{
  println("loading")
  Thread.sleep(1000)
  println("I have computed a value")
  67
}
  //future is a collection which contains a value when it's evaluated
  //future is composable with map,flatMap and filter
  // monads
  Thread.sleep(2000)
  //IMPLICITS
  //USE CASES
  /*1 IMPLICIT ARGUMENTS*/
  def aMethodWithImplicitArgs(implicit arg:Int) = arg+1
  implicit val myImplicitInt = 46
  println(myImplicitInt)
  //#2 implicit conversions
  implicit  class MyRichInteger(n:Int){
    def isEven() = n%2 ==0

  }
  println(23.isEven()) //o complire katalavainei kai vriskei to class
  //xrisi me prosoxi
}


