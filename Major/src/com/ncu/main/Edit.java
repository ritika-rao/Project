package com.ncu.main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Edit
	{
		void editRecord(String filepath,String editTerm,String newID,String newName,String newAge)
		{

			String tempFile="temp.csv";
			File oldFile=new File(filepath);
			File newFile= new File(tempFile); //creating a new file named temp
			
			String ID =" ";
			String name=" ";
			String age=" ";
			try
			{
				FileWriter fw = new FileWriter(tempFile,true);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter pw= new PrintWriter(bw);
				Scanner x=new Scanner(System.in);
				x=new Scanner (new File(filepath));
				x.useDelimiter("[,\n]");
				while(x.hasNext()) // runs till the file has any content
				{ 
					ID=x.next();
					name=x.next();
					age=x.next();
					if(ID.equals(editTerm))
					{
						pw.println(newID +","+ newName +","+newAge); //if ID is equal to entered ID then it changes
					}
					else
					{
						pw.println(ID+","+ name +","+age);		//rest is printed normally
					}
				}
				x.close();
				pw.flush();
				pw.close();
				oldFile.delete();
				File dump=new File(filepath);
				newFile.renameTo(dump);
				System.out.println("build successful");
			}
			catch(Exception e)
			{
				System.out.println("ERROR");
			}
		}
	}

