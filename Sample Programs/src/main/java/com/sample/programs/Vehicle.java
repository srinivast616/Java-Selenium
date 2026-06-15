package com.sample.programs;


public class Vehicle {
	
	int cost;
	int mileage;
	String owner;
	int yearMade;
	
	public void start()
	{
		System.out.println("Vehcle Started");
	}
	
	public void drive()
	{
		System.out.println("Driving the vehicle");
	}
	
	public void stop()
	{
		System.out.println("Vehicle stopped");
	}
	
	Vehicle(int cost, int mileage, String owner, int yearMade)
	{
		this.cost = cost;
		this.mileage = mileage;
		this.owner = owner;
		this.yearMade = yearMade;
		
		System.out.println("cost="+cost+"  "+"mileage="+mileage+"  "+"owner="+owner+"  "+"yearMade="+yearMade);
		start();
		drive();
		stop();
	}
	
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(200000,60,"XXX",2020);
		Vehicle v2 = new Vehicle(500000,25,"KKK",2025);			
	}

}
