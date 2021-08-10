package assertions;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.project.July7_30AM_Maven_SeleniumBatch.BaseTest;

public class NewTest extends BaseTest
{
	
  @Test
  public void test1(ITestContext context) 
  {
	  System.out.println("test1");
	  context.setAttribute("x_value", 200);
	  System.out.println(context.getAttribute("x_value"));
	  
  }
  
  @Test
  public void test2(ITestContext context) 
  {
	  System.out.println("test2");
	  
	  System.out.println(context.getAttribute("x_value"));
  }
}
