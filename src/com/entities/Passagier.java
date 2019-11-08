package com.entities;

public class Passagier {
	
	private String name;
	private int age;
	
	public Passagier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passagier(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Passagier [name=" + name + ", age=" + age + "]";
	}

}
