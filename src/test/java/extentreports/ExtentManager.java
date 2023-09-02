package extentreports;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BasePage;

public class ExtentManager extends BasePage {
	
	static String reportsFolderpath;
	
	
	
	
	public static ExtentReports getReport()
	{
		reportsFolderpath=System.getProperty("user.dir")+"\\reports";
		
		if(reports==null)
		{
			reports=new ExtentReports();
			
			File reportsFolder=new File(reportsFolderpath);
			
			reportsFolder.mkdir();
			

			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date=simpleDateFormat.format(new Date(0));
			date= date.replace(":", "-");
			
			
			String filePath=reportsFolderpath+"\\"+date+".html";
			
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(filePath);
			
			reporter.config().setDocumentTitle("Adactin  QA Regression Results");
			
			reporter.config().setReportName("Regression Reports");
			
			reports.attachReporter(reporter);
			
		}
		
		
		return reports;
	}

	}


