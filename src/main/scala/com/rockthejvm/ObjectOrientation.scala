package com.rockthejvm


object  ObjectOrientation extends  App {
  class Animal {
    val age: Int = 0

    def eat(): Unit = println("Im eating")
  }

  //inhertance
  class Dog(val name: String) extends Animal

  //abstact class
  abstract class WalkingAnimal {
    val haslegs = true

    def walk(): Unit
  }


  //interface = ultimate abastract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am editing, animal")

    def ?!(thought: String): Unit = println("I was thinking")
  }

  val anAnimal: Animal = new Animal


  val aDog = new Dog("bob")
  //constructor rguments are not fields:need to put a val before contructor argument
  println(aDog.name)

  //subtype polymorphism
  val aDeclaredAnimal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime


  val aCroc = new Crocodile
  aCroc.eat(aDog)
  //operators in Scala are actually methods
  val basicMath: Int = 1 + 2
  val anotherBasicMath: Int = 1.+(2)

  //anonymous class
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat anything")
  }
  // singleton object

  object MySingleton {
    // the only instance of the mysingleton type
    val mySpecialValue = 2112

    def mySpecialMethod(): Int = 5323

    def apply(x: Int): Int = x + 1
  }
  //invoking singleton class with apply function
  MySingleton(65)

  object Animal {
    //companion with animal classs
    //different instances
    val canLiveIndefenitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefenitely //"static fields/methods

  /* case classes = lightweight data structures with some boilerplate sensible
   - equals and hash code
   - quick serialization
   - automatic singleton with apply function
   */
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 54)
  try {
    val x: String = null
    x.length
  } catch {
    case g: Exception => "some error message"
  } finally {
    //execute code no matter what
  }

  //generics
  abstract class Mygen[T] {
    def head: T

    def tail: Mygen[T]
  }

  val aList: List[Int] = List(1, 2, 3)
  val first = aList.head
  val test = aList.tail
  //val aStringList = new Mygen[String]
  //val firstString = aStringList.head
  //println(firstString)

}

