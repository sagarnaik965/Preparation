package com.javatechie.oop;

public class Child extends Parent {

    public static void m2() {
        System.out.println("child static m2()");
    }
    
    
	
	  public void m1() {
		   System.out.println("Whirphool");
	  }
	 

    public static void main(String[] args) {
		/*
		 * Parent.m2(); Child.m2();
		 */
        Parent p =new Parent();
        p.m1();
        Child p1 =new Child();
        p1.m1();
    }
}
