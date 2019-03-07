package com.ncu.main;
import com.ncu.exceptions.*;
import com.ncu.validators.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.Scanner;

class main_file
{
	public static void main(String[] args)
	{
		Logger logger=Logger.getLogger(main_file.class);
		PropertyConfigurator.configure("C:\\Users\\RITIKA\\Desktop\\Major\\logger\\logger.properties");
		int ch; char con;
		String f;
		NameValidator nv;
		Scanner in = new Scanner(System.in);
		System.out.println("****************WELCOME******************");
		//FileReader f=new FileReader();
		do
		{ 
			System.out.println(" ");
			System.out.println("\nChoose what operation you want to do: \n1)New table\n2)Edit Old table\n3)Select from Existing Tables\n4)Display all tables\n");
			ch=in.nextInt();
			logger.info("Option is selected by the user");
			switch(ch)
			{
				case 1:
				{  
					nv=new NameValidator();
					System.out.println("NEW CSV");
					File g=null;
					String ID,name,age,filepath;
					System.out.println("Enter the ID: ");
					ID=in.next();
					System.out.println("Enter the name: ");
					name=in.next();
					System.out.println("Enter the age: ");
					age=in.next();
					System.out.println("Enter the name of file");
					filepath=in.next();
					System.out.println("Enter the file extension");
					String fileex=in.next();
					WriteToCSV wcv=new WriteToCSV();
					wcv.saveRecord(ID,name,age,filepath);
					nv.nameValidator(filepath,fileex);
					break;
				}
				case 2:
				{ 
					System.out.println("Choose what kind of changes u want to make: \n\n1)Delete Record\n2)Insert Row\n3)Change row");
					int c=in.nextInt();
					switch(c)
					{ 
						case 1 :
						{ //delete record
							System.out.println("Enter the name of file");
							String filepath=in.next();
							System.out.println("Enter the ID you want to delete: ");
							String removeTerm=in.next();
							deleteRecord dr=new deleteRecord();
							dr.removeRecord(filepath,removeTerm);
							break;
						}
						case 2 :
						{	//insert 
							System.out.println("Enter the Filename: ");
							String filename=in.next();
							FileAppend fa=new FileAppend();
							fa.append(filename);
							break;
						}
						case 3:
						{	//change row
							System.out.println("Enter the file name: ");
							String filepath=in.next();
							System.out.println("Enter the ID you want to Change: ");
							String editTerm=in.next();
							System.out.println("Enter the new ID: ");
							String newID =in.next();
							System.out.println("Enter the new name: ");
							String newName =in.next();
							System.out.println("Enter the new age: ");
							String newAge=in.next();
							Edit er=new Edit();
							er.editRecord(filepath,editTerm,newID,newName,newAge);
							break;
						}
						default:
						{
							System.out.println("OOPS!! CHOOSE FROM THE ABOVE OPTIONS");
						}
					
					}
					break;
				}
				case 3:
				{ //show table
					ReadCsvFileTest s1=new ReadCsvFileTest();
					s1.read();
					break;
				}
				case 4:
				{ //display all tables in main csv
					displayTable d1=new displayTable();
					d1.display();
					break;
				}
				default:
				System.out.println("INVALID INPUT");
			}
			System.out.println("To make further Entries press 'y'");
			con=in.next().charAt(0);
		  }
	  while(con=='y');
	  logger.info("Code run successfully....");
	}
}		
		




	
