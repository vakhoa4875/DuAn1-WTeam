package khoa.extension;

import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import utilTest.ExcelDealer;
import utilTest.MailSender;

public class TestRunner {
	public static void main(String[] args) {
		String devEmail = "vakhoa4875@gmail.com";
		
		Result result = JUnitCore.runClasses(TestCheckUser.class);
		for (Failure failure : result.getFailures()) {
			try {
				ExcelDealer.writeTestDefect(TestCheckUser.fileName, 1, TestCheckUser.tcID, failure.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Result result2 = JUnitCore.runClasses(TestCheckUser2.class);
		for (Failure failure : result2.getFailures()) {
			try {
				ExcelDealer.writeTestDefect(TestCheckUser2.fileName, 1, TestCheckUser2.tcID, failure.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		MailSender.sendToDev(devEmail, TestCheckUser2.fileName);
	}
}
