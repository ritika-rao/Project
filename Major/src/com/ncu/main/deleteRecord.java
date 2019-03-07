package com.ncu.main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class deleteRecord
{
	void removeRecord(String filepath,String removeTerm)
	{
		String tempFile="temp.csv";
		//creating a new file named temp
		File oldFile=new File(filepath);
		File newFile= new File(tempFile);
		String ID="";String name="";String age="";
		try
		{
			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			Scanner x=new Scanner(System.in);
			x=new Scanner(new File(filepath));
			//used to seperate columns by commas 
			x.useDelimiter("[,\n]");
			//this loop runs till the file has any content
			while(x.hasNext())
			{
				ID=x.next();
				name=x.next();
				age=x.next();
				//if the ID entered by user is not equal to the ID then it gets printed to the new file
				if(!ID.equals(removeTerm))
				{
					pw.println(ID+"," + name + "," + age);
				}
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();					//deleting old file
			File dump=new File(filepath);
			newFile.renameTo(dump);				//renaming the temp file with the old file name
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}

	}
}