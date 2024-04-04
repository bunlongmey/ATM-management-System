import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerAuthentication {
    private ArrayList<CustomerMain> customerlist = new ArrayList<CustomerMain>();
	private Scanner sc = new Scanner(System.in);
	private boolean isAuthenticated = false;
	
public void signup()
	{
		String reply;
			boolean isDuplicate = false;
			
			CustomerMain obj = new CustomerMain();
			System.out.println("Enter account number: ");
			int id = sc.nextInt();
			sc.nextLine();
			obj.setcustomerid(id);
			
			for (CustomerMain customer : customerlist) {
				if(customer.getcustomerid() == id) {
					isDuplicate = true;
					break;
				}
			}
			
			if(isDuplicate) {
				System.out.println("This account already registered!");
				return;
			}
			
			obj.setcustomerid(id);
			
			System.out.println("Enter Customer Name: ");
			obj.setcustomername(sc.nextLine());
			
			System.out.println("Enter your address:  ");
			obj.setaddress(sc.nextLine());
			
			System.out.println("Enter your pin code: ");
			obj.setpin(sc.nextLine());
			
			System.out.println("Enter your phone number ###-###-###: ");
			obj.setphoneno(sc.nextLine());
			
			System.out.println("Enter your date of birth MM/DD/YYYY: ");
			obj.setdob(sc.nextLine());
		
			customerlist.add(obj);
			writeArrayListToFile();
}

public void writeArrayListToFile()
{
  try	
  {
	FileOutputStream fout = new FileOutputStream("D:\\CustomerRegistration.txt");
	ObjectOutputStream oout = new ObjectOutputStream(fout);
	//WRITE ARRAYLIST OBJECT INTO FILE 
	oout.writeObject(customerlist);
	
	System.out.println("Your account has been successfully registered!");
  
  }catch(FileNotFoundException e){System.out.println(e.toString());}
   catch(IOException e) {System.out.print(e.toString());}
   catch(Exception e) {System.out.print(e.toString());}
}

public void readArrayListFromFile()
{
  try
  {
	FileInputStream fin=new FileInputStream("D:\\CustomerRegistration.txt");
	ObjectInputStream oin=new ObjectInputStream(fin);
	//READ DATA FROM FILE AND STORE IT IN ARRAYLIST 
	customerlist = (ArrayList<CustomerMain>)oin.readObject();
  
	System.out.println("READING FROM FILE COMPLETED.....");
  }catch(FileNotFoundException e){System.out.println(e.toString());}
   catch(IOException e) {System.out.print(e.toString());}
   catch(Exception e) {System.out.print(e.toString());}
  
}

public void signin() {
    // Read customer data from file
	isAuthenticated = false;
    readArrayListFromFile();

    // Proceed with sign-in process
    System.out.println("Enter your username: ");
    String username = sc.nextLine();

    System.out.println("Enter your pin code: ");
    String pin = sc.nextLine();

    	
    for (CustomerMain customer : customerlist) {
        if (customer.getcustomername().equals(username) && customer.getpin().equals(pin)) {
            isAuthenticated = true;
            break;
        }
    }
    
    // Display authentication result
    if (isAuthenticated) {
        System.out.println("Login successful!");
    } 
    else {
        System.out.println("Invalid username or PIN. Please try again.");
    	}
    
	}
}

// Changes