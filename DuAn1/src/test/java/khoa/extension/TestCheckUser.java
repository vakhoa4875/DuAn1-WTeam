package khoa.extension;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import library.Extension;
import utilTest.ExcelDealer;

@RunWith(Parameterized.class)
public class TestCheckUser {

	private String username;
	private String pass;
	private String expected;

	public TestCheckUser(String username, String pass, String expected) {
		this.username = username;
		this.pass = pass;
		this.expected = expected;
	}

	private static Map<Integer, String> map;
	public static StringBuilder actualResult;
	public static int caseCount;
	public static String fileName = "test-case.xlsx";
	public static int sheetIndex = 0, rowIndex = 3, dataIndex = 3;
	public final static String tcID = "F-TC01-01";
	private static boolean wasSuccessfully = true;

	@BeforeClass
	public static void init() {
		map = Map.of(1, "login successfully", 0, "wrong password", -1, "account not found");
		actualResult = new StringBuilder();
		caseCount = 1;
	}

	@Parameters
	public static Collection<Object[]> data() {
		String[] param = new String[] { "username", "pass" };
		return ExcelDealer.getTestCaseInfo(fileName, sheetIndex, dataIndex, rowIndex, param);
	}

	@Test
	public void testCheckUser() {
		int res = Extension.checkUser(username, pass);
		String actual = map.get(res);

		actualResult.append("case " + String.valueOf(caseCount++) + ": " + actual + "\n");
		
		try {
			assertEquals(expected, actual);
        } catch (AssertionError e) {
        	wasSuccessfully = false;
            throw e;
        }

	}
	
	@AfterClass
	public static void tearDown() {
		try {
			ExcelDealer.writeActualResult(fileName, sheetIndex, dataIndex + 2, rowIndex, actualResult.toString().trim(), wasSuccessfully);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
