//display all tables in main csv file
package com.ncu.main;
import java.io.*;
public class displayTable 
{ 
  void display()
  { 
    File dir = new File("C:\\Users\\RITIKA\\Desktop\\Major");
    File[] files = dir.listFiles();
    FileFilter fileFilter = new FileFilter() 
    {
      public boolean accept(File file) 
      {
        return file.isDirectory();
      }
    };
    String directoryPath = "C:\\Users\\RITIKA\\Desktop\\Major";
    File[] filesInDirectory = new File(directoryPath).listFiles();
    for(File f : filesInDirectory)
    {
      String filePath = f.getAbsolutePath();
      String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
      //display of path of file found
      if("csv".equals(fileExtenstion))
      {
        System.out.println("CSV file found -> " + filePath);
        
      }
    }     
  }
}
