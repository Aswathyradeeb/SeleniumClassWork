package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
@DataProvider(name="InvalidDataCredentials")
public Object[][] verifyUserCredentialsData(){
	Object[][] data= new Object[3][2];
	data[0][0]= "test@gmail.com";
	data[0][1]= "123456";
	
	data[1][0]= "testmail@gmail.com";
	data[1][1]= "123456";
	
	data[2][0]= "testUser@gmail.com";
	data[2][1]= "123456";
	return data;
}
}
