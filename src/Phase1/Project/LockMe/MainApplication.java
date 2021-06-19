package Phase1.Project.LockMe;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {

	private static Scanner keyboard;
	private static Scanner input;
	private static Scanner inputLock;
	private static PrintWriter output;
	private static PrintWriter outputLock;
	private static UserCredentials user;
	private static UserLockCredentials userLock;
	private static String path="C:/Users/komats1/Documents/EclipseWorkspace/LockMe/Files";

	
	public static void main(String[] args) {
		loginData();
		welcomePage();
		signInOptions();
	}
	
	private static void loginData() {
		try 
		{
			String filePath = "Files/userCredentials.txt";
			File userCredentials = new File(filePath);
			//read data from userCredentials file
			input = new Scanner(userCredentials);
			keyboard = new Scanner(System.in);
			output = new PrintWriter(new FileWriter(userCredentials,true));
			user = new UserCredentials();
			
		} 
		catch (Exception e) 
		{
			System.out.println("Exception from loginData: "+e.getMessage());
		}
	}

	public static void welcomePage()
	{
		System.out.println("======================================");
		System.out.println("*   Welcome To LockMe.com		*");
		System.out.println("*   Your Personal Digital Locker	*");
		System.out.println("=======================================");
	}
	
	public static void signInOptions()
	{
		try 
		{
			System.out.println("1. SHOW AVAILABLE FILES");
			System.out.println("2. REGISTRATION");
			System.out.println("3. LOGIN");
			System.out.println("4. TO CLOSE THE APPLICATION");
			int option = keyboard.nextInt();
			switch(option)
			{
				case 1: 
					showFiles();
					break;
				case 2: 
					registerUser();
					break;
				case 3: 
					loginUser();
					break;
				case 4: 
					System.out.println("APPLICATION IS CLOSED");
		        	System.exit(0);
				default: 
					System.out.println("Please select 1 Or 2 Or 3 Or 4");				
		    }
			keyboard.close();
	    } 
		catch (Exception e) 
		{
			System.out.println("Exception from signInOptions: "+e.getMessage());
		}
				
	}

	private static void registerUser() {
		System.out.println("======================================");
		System.out.println("*   Welcome To REGISTER PAGE		*");
		System.out.println("=======================================");	
		try 
		{
			String filePath = "Files/userCredentials.txt";
			File userCredentials = new File(filePath);
			//read data from userCredentials file
			input = new Scanner(userCredentials);
			keyboard = new Scanner(System.in);
			output = new PrintWriter(new FileWriter(userCredentials,true));
			user = new UserCredentials();
			System.out.println("Enter the UserName");	
			String userName = keyboard.next();
			user.setUserName(userName);
			System.out.println("Enter the Password");
			String password = keyboard.next();
			user.setPassword(password);
			
			output.println(user.getUserName()+"-"+user.getPassword());
			
			System.out.println("User Registration is Successful!!");
			output.close();
			System.out.println("1. TO RETURN TO MAIN PAGE");
			System.out.println("2. TO CLOSE THE APPLICATION");
			int option = keyboard.nextInt();
			switch(option) 
			{
				case 1 : 
					signInOptions();
					break;	
				case 2 : 
					System.out.println("APPLICATION IS CLOSED");
	        		System.exit(0);
				default :
					System.out.println("Please select 1 Or 2");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception from registerUser: "+e.getMessage());
		}
		
	}
	
	private static void loginUser() {
		System.out.println("======================================");
		System.out.println("*   Welcome To LOGIN PAGE		*");
		System.out.println("=======================================");	
		try 
		{
			String filePath = "Files/userCredentials.txt";
			File userCredentials = new File(filePath);
			//read data from userCredentials file
			input = new Scanner(userCredentials);
			System.out.println("Enter the UserName");	
			String inputUserName = keyboard.next();
			System.out.println("Enter the Password");
			String inputPassword = keyboard.next();
			boolean found = false;
			String userCred = inputUserName+"-"+inputPassword;
			while(input.hasNext() && !found)
			{
					if(input.next().equals(userCred))
					{
						System.out.println("Login Successful !!!");
						found = true;
						lockerOptions(inputUserName);
						break;
				}
			}
			if(!found)
			{
				 System.out.println("User Not Found : Login Failure : 404");
				 System.out.println("1. TO RETURN TO MAIN PAGE");
				 System.out.println("2. TO CLOSE THE APPLICATION");
				 int option = keyboard.nextInt();
				 switch(option) 
				 {
					case 1 : 
						signInOptions();
						break;	
					case 2 : 
						System.out.println("APPLICATION IS CLOSED");
		        		System.exit(0);	  
					default :
						System.out.println("Please select 1 Or 2");
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception from loginUser: "+e.getMessage());
		}
	}

	private static void lockerOptions(String inputUserName) {
		System.out.println("======================================");
		System.out.println("*   Welcome To LOCKER OPTIONS		*");
		System.out.println("=======================================");	
		try 
		{
			System.out.println("1. FETCH ALL STORED CREDENTIALS ");
			System.out.println("2. STORED CREDENTIALS ");
			System.out.println("3. DELETE CREDENTIALS ");
			System.out.println("4. TO RETURN TO MAIN PAGE");
			System.out.println("5. TO CLOSE THE APPLICATION");
			int option = keyboard.nextInt();
			switch(option) 
			{
				case 1 : 
					fetchCredentials(inputUserName);
					break;
				case 2 :
					storeCredentials(inputUserName);
					break;
				case 3 :
					deleteCredentials(inputUserName);
					break;	
				case 4 : 
					signInOptions();
					break;	
				case 5 : 
					System.out.println("APPLICATION IS CLOSED");
	        		System.exit(0);				
				default :
					System.out.println("Please select 1 Or 2 Or 3");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception from lockerOptions: "+e.getMessage());	
		}
	}

	private static void fetchCredentials(String inputUserName) {
		System.out.println("==========================================");
		System.out.println("*   WELCOME TO DIGITAL LOCKER 	 *");
		System.out.println("*   YOUR CREDS ARE 	 *");
		System.out.println("==========================================");
		System.out.println(inputUserName);
		try 
		{
			String userLockName = "Files/"+inputUserName+".txt";
			File userLockCredentials = new File(userLockName);
			//read data from userCredentials file
			inputLock = new Scanner(userLockCredentials);
			keyboard = new Scanner (System.in);
			output = new PrintWriter(new FileWriter(userLockCredentials,true));
			userLock = new UserLockCredentials();
			while(inputLock.hasNext()) 
			{
				System.out.println(inputLock.next());
		    }
			inputLock.close();
			System.out.println("1. TO RETURN TO MAIN PAGE");
			System.out.println("2. TO CLOSE THE APPLICATION");
			int option = keyboard.nextInt();
			switch(option) 
			{
				case 1 : 
					signInOptions();
					break;	
				case 2 : 
					System.out.println("APPLICATION IS CLOSED");
	        		System.exit(0);				
				default :
					System.out.println("Please select 1 Or 2");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Lock Credentials File Not Found");
		}
		
	}
	
	private static void storeCredentials(String inputUserName) {
		System.out.println("======================================");
		System.out.println("*   Welcome To LOCK CREDENTIAL STORAGE PAGE		*");
		System.out.println("=======================================");	
		try 
		{
			String userLockName = "Files/"+inputUserName+".txt";
			File userCredentials = new File(userLockName);
			userLock = new UserLockCredentials();
			System.out.println("Enter the SiteName");	
			String siteName = keyboard.next();
			userLock.setSiteName(siteName);
			System.out.println("Enter the UserName");	
			String userName = keyboard.next();
			userLock.setUserName(userName);
			System.out.println("Enter the Password");
			String password = keyboard.next();
			userLock.setPassword(password);
			outputLock = new PrintWriter(new FileWriter(userCredentials,true));

			outputLock.println("siteName:-"+userLock.getSiteName()+",userName:-"+userLock.getUserName()+",Password:-"+userLock.getPassword());
			
			System.out.println("User LOCK Credentials are stored Successfully!!");
			outputLock.close();
			System.out.println("1. TO RETURN TO MAIN PAGE");
			System.out.println("2. TO CLOSE THE APPLICATION");
			int option = keyboard.nextInt();
			switch(option) 
			{
				case 1 : 
					signInOptions();
					break;	
				case 2 : 
					System.out.println("APPLICATION IS CLOSED");
	        		System.exit(0);			
				default :
					System.out.println("Please select 1 Or 2");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception from storeCredentials: "+e.getMessage());
		}
		
	}
	
	private static void deleteCredentials(String inputUserName) {
		try 
		{
			String userLockName = "Files/"+inputUserName+".txt";
			Files.delete(Paths.get(userLockName));
			System.out.println("File Deleted!");
			System.out.println("1. TO RETURN TO MAIN PAGE");
			System.out.println("2. TO CLOSE THE APPLICATION");
			int option = keyboard.nextInt();
			switch(option) 
			{
				case 1 : 
					signInOptions();
					break;	
				case 2 : 
					System.out.println("APPLICATION IS CLOSED");
	        		System.exit(0);					
				default :
					System.out.println("Please select 1 Or 2");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Lock Credentials File Not Found to perform delete");
			signInOptions();
		}
		
	}
	private static void showFiles() {
		try 
		{
			 String[] dirListing = null;
			 File dir = new File(path);
			 dirListing = dir.list();
			 Arrays.sort(dirListing);
			 System.out.println("Files Available are:- "+Arrays.deepToString(dirListing));
			 System.out.println("1. TO RETURN TO MAIN PAGE");
			 System.out.println("2. TO CLOSE THE APPLICATION");
			 int option = keyboard.nextInt();
			 switch(option) 
			 {
				case 1 : 
					signInOptions();
					break;	
				case 2 : 
					System.out.println("APPLICATION IS CLOSED");
	        		System.exit(0);				
				default :
					System.out.println("Please select 1 Or 2");
			}
		} 
		catch (Exception e)
		{
			System.out.println("Exception from showFiles: "+e.getMessage());
		}
		
	}

}
