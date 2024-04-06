package ESY_Assignment4_Complete;
/**
 * This class represents GFA test cases for a ManagementCompany object.
 * 
 * @author El Hadji Sy
 * @version 4/6/2024
 * 
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	Property sampleProperty2;
	ManagementCompany managementCo ;
	ManagementCompany managementCo2;
	ManagementCompany managementCo3;
	
	@Before
	public void setUp() throws Exception {
		managementCo= new ManagementCompany("Railey", "555555555",6);
		managementCo2 = new ManagementCompany(managementCo);
		managementCo3 = new ManagementCompany();
		
	}

	@After
	public void tearDown() throws Exception {
		managementCo=managementCo2=managementCo3=null;
	}
	
	@Test
	public void testManagementCompany() {
		assertTrue(managementCo3.getName() == "");	
	}
	
	@Test
	public void testManagementCompany2() {
		assertTrue(managementCo.getName() == managementCo2.getName());	
	}
	
	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		assertEquals(managementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
	}
	@Test
	public void testAddProperty2() {
		sampleProperty2 = new Property ("SuperCompany", "Me", 1534, "Me",1,5,3,4);	
		assertEquals(managementCo2.addProperty(sampleProperty2),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testAddProperty3() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		assertEquals(managementCo.addProperty(sampleProperty),0,0);	//property hasn't been added due to encompass error.
	}
	
	@Test
	public void testGetPropertiesCount1() {
		
		assertEquals(managementCo.getPropertiesCount(), 0);
	}
	
	@Test
	public void testIsPropertiesFull() {
		
		assertTrue(managementCo.isPropertiesFull() == false);
	}
	@Test
	public void testRemoveProperty() {	
		managementCo2.removeProperty();
		assertEquals(managementCo2.getPropertiesCount(),0);	
	}
	@Test
	public void testGetPropertiesCount2() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(managementCo.addProperty(sampleProperty),0,0);	
		assertEquals(managementCo.getPropertiesCount(), 1);
	}
	
	@Test
	public void testGetTotalRent() {
		assertEquals(managementCo.getTotalRent(), 0);	
	}
	
	@Test
	public void testGetName() {
		assertEquals(managementCo.getName(), "Railey");	
	}
	
	@Test
	public void getTaxID() {
		assertEquals(managementCo.getTaxID(),"555555555");	
	}
	
	@Test
	public void testGetTotalRent2() {
		assertTrue(managementCo2.getTotalRent() == 0);	
	}
	
	@Test
	public void TestMgmFeePer() {
		assertTrue(managementCo.getMgmFeePer() == 0);	
	}
	
	@Test
	public void testToString() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613.0, "BillyBob Wilson",2,5,2,2);
		assertEquals(managementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 156.78";
		assertEquals(expectedString, managementCo.toString());
				
	}

}
