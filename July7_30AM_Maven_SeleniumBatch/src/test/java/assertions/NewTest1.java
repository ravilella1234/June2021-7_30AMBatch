package assertions;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.project.July7_30AM_Maven_SeleniumBatch.BaseTest;

public class NewTest1 extends BaseTest
{
	
  @Test
  public void test3(ITestContext context) 
  {
	  System.out.println("test3");
	  System.out.println(context.getAttribute("x_value"));
  }
}
