//-------imports---------
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.sikuli.script.Key;
import org.sikuli.script.Screen;


//logger
private static Logger LOGGER = Logger.getLogger("InfoLogging");
simpleHandler = new FileHandler("LogFileName.txt", true);
			simpleHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(simpleHandler);
LOGGER.info("Resovled: "+ input1.get(i)+" Trials:"+trials);

//fetch two inputs in multiple lines from file 
private static void fetchInput1AndInput2FromFile() 
	{
		// TODO Auto-generated method stub
		BufferedReader reader=null;
		input1=new ArrayList<String>();
		String sampleinput1="FirstInputFormat";
		input2=new ArrayList<String>();
		try {
			//s = new Scanner(new File("inc_and_res_msg.txt"));
			reader = new BufferedReader(new FileReader("inc_and_res_msg.txt"));
			String line="";
			while ((line = reader.readLine()) != null) 
			{
			    
				line=line.trim();
			    input1.add(line.substring(0,sampleinput1.length()));
			    input2.add(line.substring(sampleinput1.length()).trim());
			}
			if(reader!=null)
			{
				reader.close();
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		
	}
	
	//Try to search for image for 3 times(c=2) and if not found then set resolveFlag false and break
	private static void checkWhetherCertainThingIsThereOrNot(Screen s, String imgName,boolean bypassClose) throws InterruptedException
    {
		// TODO Auto-generated method stub
    	imgName=imgPath+imgName;
    	int c=2;
    	boolean flag=true;
		do
		{			
			if(c<0)
			{
				break;
			}
			c--;
			try
			{
				s.find(imgName);
				s.click();
				flag=true;
			}
			catch(Exception e)
			{
				System.out.println("Error: "+e.getMessage());
				flag=false;	
			}
			Thread.sleep(shortDelay);
		}while(!flag);
		
		if(!flag && !bypassClose)
		{
			clickOnImage(s,"inc_window_close_button.PNG");
			resolveStatus=false;
		}
	}
	//increase trials every time and timeout after given number of trials
	private static void trialsManager(Screen s) throws InterruptedException
    {
    	trials++;
		if(trials > maxTrialLimit)
		{
			clickOnImage(s,"inc_window_close_button.PNG");
			resolveStatus=false;
		}
    }
	
	////search of image infinitely and type on image when find
	private static void typeOnImage(Screen s, String imgName, String textTotype) throws InterruptedException 
	{
		// TODO Auto-generated method stub
	
		//trialsManager();
		imgName=imgPath+imgName;
		boolean flag=true;
		do
		{
			trialsManager(s);
			if(!resolveStatus)
			{
				//normalClickOnImage(s,"inc_window_close_button.PNG");
				break ;
			}
			try
			{
				s.find(imgName);
				s.type(imgName, textTotype);
				flag=true;
			}
			catch(Exception e)
			{
				System.out.println("Error: "+e.getMessage());
				flag=false;
				
			}
			Thread.sleep(shortDelay);
		}while(!flag);
	}
	
	//search of image infinitely and click when find
	private static void clickOnImage(Screen s, String imgName) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		//trialsManager();
		imgName=imgPath+imgName;
		boolean flag=true;
		do
		{
			trialsManager(s);
			if(!resolveStatus)
			{
				//normalClickOnImage(s,"inc_window_close_button.PNG");
				break ;
			}
			try
			{
				s.find(imgName);
				s.click();
				flag=true;
			}
			catch(Exception e)
			{
				System.out.println("Error: "+e.getMessage());
				flag=false;
				trialsManager(s);
			}
			Thread.sleep(shortDelay);
		}while(!flag);
	}
	
	//search of image infinitely and right click when find
	private static void rightClickOnImage(Screen s, String imgName) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		//trialsManager();
		imgName=imgPath+imgName;
		boolean flag=true;
		do
		{
			trialsManager(s);
			if(!resolveStatus)
			{
				//normalClickOnImage(s,"inc_window_close_button.PNG");
				break ;
			}
			try
			{
				s.find(imgName);
				s.rightClick();
				flag=true;
			}
			catch(Exception e)
			{
				System.out.println("Error: "+e.getMessage());
				flag=false;
				
			}
			Thread.sleep(shortDelay);
		}while(!flag);
	}
	