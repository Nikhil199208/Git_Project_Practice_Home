package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion 

{

		@Test
		public void test()
		{
			//Assert.assertEquals("xyz", "xyz");
			//Assert.assertEquals(123,"XYZ");
			
			//Assert.assertEquals("XYZ", "xyz");
			//Assert.assertEquals("123", 123);
			
			//Assert.assertNotEquals(123, 123);
			//Assert.assertNotEquals(123, 321);
			
			//Assert.assertTrue(true);
			//Assert.assertTrue(false);
			
			//Assert.assertFalse(true);
			//Assert.assertFalse(false);
			
			//Assert.assertTrue(1==1);
			//Assert.assertTrue(1==2);
			
			//Assert.assertFalse(1==1);
			Assert.assertFalse(1==2);
		}

	}

