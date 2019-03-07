package com.ncu.main;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.File;

public class ReadCsvFileTest 
{
    public void read()
    {
      Scanner in=new Scanner(System.in);
      System.out.println("Enter the file name");
      String file=in.next();
      File f=null;
      try
      { //file is declared by the user
        f=new File(file);
        FileReader fin=new FileReader(f);
        BufferedReader bin=new BufferedReader(fin);
        String ar;
        System.out.println("\n\n");
        //runs till the file has any content
        while((ar=bin.readLine())!=null)
        {
        	//prints all the content of the file
          System.out.println(ar);
        }
        fin.close();
        bin.close();
      }
      catch (IOException e) 
      {
      	//throws exception if file doesnt exists
            System.out.println("file not found");
      }
      
    }
}

