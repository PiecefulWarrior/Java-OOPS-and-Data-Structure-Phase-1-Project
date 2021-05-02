package fileStorageSystem;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileHandling {




	public boolean createFile(String fileName){
		File file  = new File("C://DemoFiles/"+fileName);
		try {
			file.createNewFile();
			System.out.println("Your file has been created successfully at location :"+file.getAbsolutePath()+".\n");
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
		//return true;
	}

	public boolean deleteFile(String fileName) throws FileException{
		File file = new File("C://DemoFiles/"+fileName);

		if(file.exists()){
			String filePath = file.getAbsolutePath();	
			file.delete();
			System.out.println("Your file has been deleted successfully from location :"+filePath+".\n");

		}else{
			throw  new FileException("File not found");
		} 
		return true;
	}

	public void searchFile(String fileName) throws FileException{

		File file = new File("C://DemoFiles/"+fileName);
		if(file.exists()){
			System.out.println("Your file is found at location  :"+file.getAbsolutePath()+"\n");
		}else{

			throw  new FileException("File with this name does not exists");

		}


	}

	public boolean updateFile(String fileName) throws IOException{

		//FileWriter fos = new FileWriter("C://DemoFiles/"+fileName);
		File file = new File("C://DemoFiles/"+fileName);
		System.out.println("Write the data you want to insert in file and type enter if you are finished");
		
		FileOutputStream out = new FileOutputStream(file);
		
		Scanner sc =new Scanner(System.in);
		
		String str = sc.nextLine();
		char arr[] = str.toCharArray();
		
		int i=0;
		while(i<arr.length){
		
		out.write(arr[i]);
		out.flush();
		i++;
		}
		out.close();
		
		System.out.println("Your data has been stored in file successfully.\n");
		return true;
	}

	public String[] getFilesinAscending() throws FileException {

		File file = new File("C://DemoFiles/");

		String allFiles[] = file.list();
		
		if(allFiles==null || allFiles.length==0)
			throw new FileException("No files available to fetch");

		for(int i=0;i<allFiles.length-1;i++){

			for(int j=0;j<allFiles.length-1-i;j++){

				if(allFiles[j].compareToIgnoreCase(allFiles[j+1])>0){

					String temp = allFiles[j+1];
					allFiles[j+1] =allFiles[j];
					allFiles[j]=temp;

				}

			}
		}

		return allFiles;
	}

	public void readFile(String fileName) throws IOException{

		FileInputStream fis =new FileInputStream("C://DemoFiles/"+fileName);


		int i=0;
		while((i=fis.read())!=-1){
			System.out.print((char)i);
		}
		System.out.println();

	}
}
