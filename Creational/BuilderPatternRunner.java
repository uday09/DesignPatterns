package Creational;

// car builder ... car is complext machine you cant simply create it

class Car {

	private String engine; /// instead of String these itself can be complex objects
	private String manufactureYear;
	private String model;
	private String company;

	public Car(CarBuilder carBuilder) {
		this.company = carBuilder.company;
		this.model = carBuilder.model;
		this.manufactureYear = carBuilder.manufactureYear;
		this.engine = carBuilder.engine;
	}
	
	public String getEngine() {
		return engine;
	}

	public String getManufactureYear() {
		return manufactureYear;
	}

	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + ", manufactureYear=" + manufactureYear + ", model=" + model + ", company="
				+ company + "]";
	}

	public static class CarBuilder {
		private String engine;
		private String manufactureYear;
		private String model;
		private String company;

		public CarBuilder engine(String engine) {
			this.engine = engine;
			return this;
		}

		public CarBuilder manufactureYear (String manufactureYear) {
			this.manufactureYear = manufactureYear;
			return this;
		}

		public CarBuilder model (String model) {
			this.model = model;
			return this;
		}

		public CarBuilder company (String company) {
			this.company = company;
			return this;
		}

		public Car build(){
			Car car = new Car(this);
			return car;
		}
	}
}

public class BuilderPatternRunner {

	public static void main(String[] args) {
		Car car = new Car.CarBuilder()
				.company("TataMotors")
				.engine("1200 CC")
				.manufactureYear("2019")
				.model("Tata Indica :D")
				.build();
		
		System.out.println(car);
	}
}
