package fileStorageSystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileRunner {
	
public static void makeDirectory() {
	
	Path path = Paths.get("C://DemoFiles/");
	
	try {
		Files.createDirectory(path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
	}
	
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileRunner.makeDirectory();
		FileHandling fh = new FileHandling();

		System.out.println("--------------------------------------------------------");
		System.out.println("Company Lockers Pvt. Ltd. developed by Bhushan Shimpi");
		System.out.println("File handling application");


		int choice=0;
		do{
			System.out.println("Press 1 to retrieving the file names in an ascending order ");
			System.out.println("Press 2 to perform CRUD operations on files");
			System.out.println("Press 3 to close the application ");

			
			Scanner sc = new Scanner(System.in);

			try{
				choice  = sc.nextInt();
			}catch(Exception ex){
				System.out.println("Wrong  input choice");
				//break;
			}

			switch(choice){
			case 1:
				try {
				String files[] = fh.getFilesinAscending();
				for(String file:files){

					System.out.println(file);
				}
				}catch(FileException fe) {
					
					System.out.println(fe.getMessage());
				}
				System.out.println();
				break;

			case 2:
				int ch=0;
				do{

					System.out.println("Press 1 to add your file in directory");
					System.out.println("Press 2 to delete a file");
					System.out.println("Press 3 to search a file");
					System.out.println("Press 4 to read a file");
				    System.out.println("Press 5 to write data in a file");
					System.out.println("Press 6 to return to main menu");
					System.out.println();
					try{
						
						ch = sc.nextInt();

					}
					catch(Exception ex){
						
						System.out.println("Wrong input choice");	
						break;
					}

					switch(ch){

					case 1:
						System.out.println("Enter name of file to add");
						String fileName = sc.next();
					    fh.createFile(fileName);
					   
						break;

					case 2:	
						System.out.println("Enter name of file to delete");
						String fileName1 = sc.next();
						try{
							
							fh.deleteFile(fileName1);
							
						}catch(FileException ex){
							
							System.out.println(ex.getMessage());
						}
						
						break;
					case 3:
						System.out.println("Enter name of file to search");
						String fileName2 = sc.next();
						try{
							fh.searchFile(fileName2);
						}catch(FileException ex){
							System.out.println(ex.getMessage());
						}
						
						break;

					case 4: 
						System.out.println("Enter name of file to read");
						String fileName3 = sc.next();
						try {
							fh.readFile(fileName3);
							//System.out.println("End of file data\n");
						} catch (IOException e) {
							
							System.out.println(e.getMessage());
						}
						

						break;
					case 5:
						
						System.out.println("Enter name of file name to write data");
						String fileName4 = sc.next();
					    try {
							fh.updateFile(fileName4);
						} catch (IOException e) {
							
							System.out.println(e.getMessage());
						}
					   
						break;
						
					case 6:
						break;

					default:
						System.out.println("Please use proper choice.\n");
						
					}
				}while(ch!=6);

				break;
			case 3:
				System.out.println("Aplication closed.");
				break;

			default:	
				System.out.println("Please enter right choice.");
			}
		}while(choice!=3);
	}

}
