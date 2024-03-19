/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ui;

import org.testng.Assert;
import org.testng.annotations.*;

//import junit.framework.TestCase;


public class TestBonus{

	@DataProvider(name = "bonusDataTrue")
	public Double[][] getBonusData() {
		return new Double[][] { { 0.0, 1.0 }, { 1.1, 1.0 }, { 1.4, 1.0 }, { 1.6, 2.0 } };
	}

//	
	private final Bonus bonus = new Bonus();

//	
	@Test(dataProvider = "bonusDataTrue")
	public void testBonus(double t, double result) {
		double res = bonus.maxN(t);

		Assert.assertEquals(result, res);
	}

//	@BeforeTest
//	public void init() {
//		bonus = new Bonus();
//	}

//
//	@Test
//	public void testBonusP1() {
//		int result = bonus.maxN(0.0);
//
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void testBonusP2() {
//		int result = bonus.maxN(1.1);
//
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void testBonusP3() {
//		int result = bonus.maxN(1.6);
//
//		assertEquals(2, result);
//	}
//	@Test
//	public void testBonusF1() {
//		int result = bonus.maxN(0.0);
//
//		assertEquals(0, result);
//	}
//	
//	@Test
//	public void testBonusF2() {
//		int result = bonus.maxN(1.1);
//
//		assertEquals(2, result);
//	}
//	
//	@Test
//	public void testBonusF3() {
//		int result = bonus.maxN(1.6);
//
//		assertEquals(1, result);
//	}

}

