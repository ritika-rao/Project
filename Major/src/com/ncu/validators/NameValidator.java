package com.ncu.validators;
import com.ncu.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class NameValidator{
	public boolean nameValidator(String filename, String filetype){
		System.out.println("File name is: "+filename+" and its type is:"+filetype);
		boolean b;
		Properties prop = new Properties();
		FileInputStream input=null;
		String csvfilepath = "C:\\Users\\RITIKA\\Desktop\\Major";
		Logger logger = Logger.getLogger(NameValidator.class);
		PropertyConfigurator.configure("C:\\Users\\RITIKA\\Desktop\\Major\\configs\\logger\\logger.properties");
		try{	
			input = new FileInputStream("C:\\Users\\RITIKA\\Desktop\\Major\\configs\\constants\\exceptions.properties");
			prop.load(input);
			emptyFileName(filename);
			missingDot(filename);
			fileFormat(filename);
			fileLength(filename);
			fileFormat(filename);
			specialCharacter(filename);
			if(filetype=="csv"){
			csvOnly(filename);
			fileNotAvailable(csvfilepath+"\\"+filename);
			}
		}
		catch(EmptyFileNameException e){
			logger.error("\n \n"+e+prop.getProperty("emptyNameMessage")+"\n");
			return false;
		}
		catch(MissingExtensionException e){
			logger.error("\n \n"+e+prop.getProperty("extensionMessage")+"\n");
			return false;
		}
		catch(InvalidExtensionException e){
			logger.error("\n \n"+e+prop.getProperty("invalidException")+"\n");
			return false;
		}
		catch(FileNameLengthException e){
	    	logger.error("\n \n"+e+prop.getProperty("longFileNameMessage")+"\n"); 
			return false;
	    }
	    catch(SpecialCharacterException e){
	    	logger.error("\n \n"+e+prop.getProperty("specialcharacterMessage")+"\n"); 
			return false;
	    }
	    catch(FileNotAvailable e){
	    	logger.error("\n \n"+e+prop.getProperty("notAvailableMessage")+"\n"); 
			return false;
	    }
		catch(Exception e){
			System.out.println(e);
		}
		return true;
	}

	/* Generate "EmptyNameException" Exception if user enters blank space as a file name  */
	private void emptyFileName(String filename)throws EmptyFileNameException{
		if (filename=="")
			throw new EmptyFileNameException("Empty File Name Exception");
	}

	/* Generate "MissingExtensionException" Exception if user does not enter "." before file extension  */
	private void missingDot(String fileName)throws MissingExtensionException{
		Pattern costPattern = Pattern.compile("[.]");
		Matcher costMatcher = costPattern.matcher(fileName);
		boolean value = costMatcher.find();
		if (!value==true)			//Change here
			throw new MissingExtensionException("Missing Extension Exception");
	}
	private void fileFormat(String fileName) throws InvalidExtensionException{
		String [] extn = fileName.split("\\.");
		if (extn.length<=1) 
			throw new InvalidExtensionException("Invalid Extension Exception1"); 
	}
	private void fileLength(String fileName) throws FileNameLengthException{
		int fileLength=25;
		String namelength = fileName.split("\\.")[0];
		if(namelength.length()>fileLength)
			throw new FileNameLengthException("File Name Length Exception");
	}
	private void specialCharacter(String fileName) throws SpecialCharacterException{
		fileName = fileName.split("\\.")[0];
		Pattern  patternGet = Pattern.compile("[@#$%^&(,)_]");
		Matcher check = patternGet.matcher(fileName);
		boolean finalValue = check.find();
		if (finalValue == true)
			throw new SpecialCharacterException("Special Character Exception");
	}
	private void csvOnly(String fileName) throws InvalidExtensionException{
		String[] name = fileName.split("\\.");		
		//now name[0] contains the filename and name[1] contains the extension
		if(!(name[1].equals("csv")==true))				//change here
			throw new InvalidExtensionException("Invalid Extension Exception2");
	}
	private void fileNotAvailable(String fileName) throws FileNotAvailable {
		File f = new File(fileName);
		if(!f.exists())
			throw new FileNotAvailable("File Not Available");
	}
}
