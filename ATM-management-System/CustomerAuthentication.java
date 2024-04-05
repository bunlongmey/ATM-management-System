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
	private int cash;
	private int customerindexno = -1;
	private String x;
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
			
			System.out.println("Enter your Amount you want to put in: ");
			obj.setbalance(sc.nextInt());
		
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
  

  }catch(FileNotFoundException e){System.out.println(e.toString());}
   catch(IOException e) {System.out.print(e.toString());}
   catch(Exception e) {System.out.print(e.toString());}
  
}

public String signin() {
    // Read customer data from file
	isAuthenticated = false;
    readArrayListFromFile();

    // Proceed with sign-in process
    System.out.println("Enter your username: ");
    String username = sc.nextLine();

    System.out.println("Enter your pin code: ");
    String pin = sc.nextLine();

    for(int i=0; i< customerlist.size(); i++)
    {
    	CustomerMain tempobj = customerlist.get(i);
        if (tempobj.getcustomername().equals(username) && tempobj.getpin().equals(pin)) {
        	customerindexno = i;
            isAuthenticated = true;
            break;
        }
    }
    
    // Display authentication result
    if (isAuthenticated) {
       return "X";
    } 
    else {
       return "Y";
    	}
    
	}
public void withdraw() {	
	System.out.println("Enter the Amount that you want to withdraw: ");
	int cashs= sc.nextInt();	
	CustomerMain tempobj = customerlist.get(customerindexno);
		cash =tempobj.getbalance()- cashs;
		if (cash>=0)
		{
			tempobj.setbalance(cash);		
			customerlist.set(customerindexno, tempobj);		
			System.out.println("You Have Withdrawn:"+ cashs);
		}
		else {
			System.out.println("You Do Not Have Enough Amount To withdraw");
		}
	}
public void deposit() {	
	System.out.println("Enter the Amount that you want to Deposit: ");
	int cashs= sc.nextInt();	
	CustomerMain tempobj = customerlist.get(customerindexno);
		cash =tempobj.getbalance()+ cashs;	
		tempobj.setbalance(cash);	
		customerlist.set(customerindexno, tempobj);		
		System.out.println("You Have Deposited:"+ cashs);		
	}

	
public void viewaccount()	{
	CustomerMain tempobj = customerlist.get(customerindexno);
		System.out.println("User's ID: "+ tempobj.getcustomername());
		System.out.println("User's Name: "+ tempobj.getcustomerid());
		System.out.println("User's Balance: "+ tempobj.getbalance());
		System.out.println("User's Address: "+ tempobj.getaddress());
		System.out.println("User's Phone Number: "+ tempobj.getphoneno());
		System.out.println("User's Date Of Birth: "+ tempobj.getdob());
	
	}
}

// <<<<<<< main


// =======
// // Changes
// >>>>>>> main
