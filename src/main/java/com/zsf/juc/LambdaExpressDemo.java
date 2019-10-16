package com.zsf.juc;

public class LambdaExpressDemo {
	public static void main(String[] args) {
		Foo.sayHelloWorld();
		
		/*Foo foo = new Foo() {
			
			@Override
			public int add(int x, int y) {
				return x+ y;
			}
		};*/
		

		
        Foo foo = (int x,int y) -> {return x +y;};
        
		foo.sayHello();
		
		System.out.println(foo.add(6, 3));
	}
}

@FunctionalInterface
interface Foo{
	public int add(int x,int y);
	default void sayHello() {
		System.out.println("Hello JUC");
	}
	static void sayHelloWorld() {
		System.out.println("Hello World!");
	}
}