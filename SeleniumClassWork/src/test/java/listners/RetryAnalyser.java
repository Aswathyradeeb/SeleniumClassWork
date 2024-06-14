package listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int count=0, retryLimit=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}

	
}
