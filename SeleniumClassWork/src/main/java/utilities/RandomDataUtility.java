package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	static Faker faker;
	
	public static String getFirstName() {
		faker= new Faker();
		String fname= faker.name().firstName();
		return fname;
	}
	public static String getLastName() {
		faker= new Faker();
		String lname= faker.name().lastName();
		return lname;
	}
}
