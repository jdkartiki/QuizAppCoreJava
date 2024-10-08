package com.Test;

interface Animal {
 void eat();
}

interface Tiger {
 void run();
}

class Dog implements Animal, Tiger {
 @Override
 public void eat() {
     System.out.println("Dog is eating.");
 }
 @Override
 public void run() {
     System.out.println("Dog is running.");
 }
}

public class MultipleInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
	     dog.eat();
	     dog.run();
	}

}
