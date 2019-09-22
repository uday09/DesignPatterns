package Creational.Builder;

public class BuilderPatternRunner {

	public static void main(String[] args) {
		Car car = new Car.CarBuilder()
				.company("TataMotors")
				.engine("1200 CC")
				.manufactureYear("2019")
				.model("Tata Indica :D")
				.build(); // private constructor called by static inner class in build()
		
		
		Car car2 = new Car.CarBuilder()
				.company("TataMotors")
			//	.engine("1200 CC")
			//	.manufactureYear("2019")
				.model("Tata Indica :D")
				.build(); 
		
		
		System.out.println(car);
		System.out.println(car2);
	}
}