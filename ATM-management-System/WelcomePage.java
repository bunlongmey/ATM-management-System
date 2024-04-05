import java.util.Scanner;
public class WelcomePage {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String reply;
	String replys;
	CustomerAuthentication obj = new CustomerAuthentication();
	do
	{
	System.out.println("=========================================");
	System.out.println("    WELCOME TO ATM MANAGEMENT SYSTEM");
	System.out.println("=========================================");
	System.out.println("1. SIGN UP ");
	System.out.println("2. SIGN IN ");
	System.out.println("Please select the option");
		if(sc.hasNextInt()) {
			int option = sc.nextInt();
			switch(option)
			{
				case 1: obj.signup();
					obj.writeArrayListToFile();
					break;
				case 2: String x= obj.signin();
				    	if (x=="Y") {
				    		System.out.println("Invalid username or PIN. Please try again.");
				    	}
				    	else {
				    		System.out.println("Login successful!");
				    	do {
				    		System.out.println("1. Withdraw Money ");
				    		System.out.println("2. Deposit Money ");
				    		System.out.println("3. Fast Cash ");
				    		System.out.println("4. ATM help ");
				    		System.out.println("5 View Account ");
				    		System.out.println("Please select the option from 1-5");
				    		int choice =sc.nextInt();
				
				    		switch(choice)
				    		{
							case 1: obj.readArrayListFromFile();
								obj.withdraw();	
								obj.writeArrayListToFile();
								break;							
							case 2:  obj.readArrayListFromFile();
								obj.deposit();
								obj.writeArrayListToFile();
								break;
							case 5: obj.viewaccount();
								break;							
				    		}
		System.out.println("Continue? Y/N ");
	        replys = sc.next();
		} 
		while (replys.equalsIgnoreCase("y"));
		break;
		}
				
		default:
			System.out.println("PLEASE ENTER VALID INPUT ");
		}
           }
		else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
		System.out.println("DO YOU WANT TO CONTINUE Y/N ");
            reply = sc.next();
        } while (reply.equalsIgnoreCase("y"));
        sc.close(); // Close the scanner when done
    }
				
}

		
				
