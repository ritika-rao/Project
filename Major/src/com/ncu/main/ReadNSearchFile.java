package com.ncu.main;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadNSearchFile
{
	void readRecord(String searchTerm,String filepath) 
	{
		boolean found=false;
		String ID ="";
		String name1="";
		String age="";

		Scanner x=new Scanner(System.in);
		
		File g=null;
		g=new File(filepath);
		//reads the whole file line by line
		FileReader fin = new FileReader(g);
		BufferedReader bin=new BufferedReader(fin);
		try
		{	//to tell the program that columns are seperated by commas 
			x.useDelimiter("[,\n]");
			//runs till file has any content and ID is not found
			while(x.hasNext() && !found)
			{
				ID=x.next();
				name1=x.next();
				age=x.next();

				if(ID.equals(searchTerm))
				{
					found=true;
				}
			}
			if(found)
			{
				JOptionPane.showMessageDialog(null,"ID: "+ID+"Name: "+name1+"Age: "+age);
			}

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Record not found");
		}

	}
}