//////////////////////////////////////////////////////////////////////////////////////
///
///  PROBLEM STATEMENT
///  1.Automated file organizer by file type
///  Author Name:Shubham Isai
///
/// ///////////////////////////////////////////////////////////////////////////////////

// SOLUTION:

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Task1
{
    public static void main(String args[])
    {
        Scanner sobj=new Scanner(System.in);
        System.out.println("enter folder path:");
        String folderpath=sobj.nextLine();

        File folder=new File(folderpath);

        if(!folder.exists()||!folder.isDirectory())
        {
            System.out.println("invalid folder path!");
            sobj.close();
            return;
        }
        File files[]=folder.listFiles();
        if(files==null || files.length==0)
        {
            System.out.println("folder is empty");
            sobj.close();
            return;
        }
        for(File file:files)
        {
            if(file.isFile())
            {
                String filename=file.getName();
                String extension=" ";
                int index=filename.lastIndexOf('.');
                if(index>0)
                {
                    extension=filename.substring(index+1).toLowerCase();
                }
                String destinationFolder;
                switch(extension)
                {
                    case "jpg":
                    case "jpeg":
                    case "png":
                    case "gif":
                    destinationFolder="Immmmages";
                    break;

                    case "pdf":
                        destinationFolder="PDFs";
                        break;

                    case "txt":
                        destinationFolder="TextFiles";
                        break;
                    
                    case "mp3":
                    case "wav":
                    destinationFolder="music";
                    break;

                    case "mp4":
                    case "mkv":
                    case "avi":
                    destinationFolder="videos";
                    break;

                    case "doc":
                    case "docs":
                    destinationFolder="documents";
                    break;

                    case "xls":
                    case "xlsx":
                    destinationFolder="Excel";
                    break;

                    case "ppt":
                    case "pptx":
                    destinationFolder="compressed";
                    break;

                    default:
                    destinationFolder="others";
                }
                File newfolder=new File(folderpath+File.separator+destinationFolder);
                if(!newfolder.exists())
                {
                    newfolder.mkdir();
                }
                Path source = file.toPath();
                Path destination = new File(newfolder, file.getName()).toPath();
                try 
                {
                    Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(filename+"->"+destinationFolder);
                } 
                catch(IOException e) 
                {
                    System.out.println("Error moving file: " + filename);
                }
            }
        }
        System.out.println("\n all files organized successfully!");
        sobj.close();
    }
}