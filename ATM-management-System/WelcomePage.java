import java.util.Scanner;
public class WelcomePage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String reply;
		CustomerAuthentication obj = new CustomerAuthentication();
		do
		{
			System.out.println("WELCOME TO ATM MANAGEMENT SYSTEM");
			System.out.println("1. SIGN UP ");
			System.out.println("2. SIGN IN ");
			System.out.println("3. Withdraw Money ");
			System.out.println("4. Deposit Money ");
			System.out.println("5. Fast Cash ");
			System.out.println("6. ATM help ");
			System.out.println("7. View Account ");
			System.out.println("----------------------------------");
			System.out.println("Please select the option from 1-7");
			if(sc.hasNextInt()) {
				int option = sc.nextInt();
				switch(option)
				{
				case 1: obj.signup();
					obj.writeArrayListToFile();
					break;
				case 2: obj.signin();
					break;
	//			case 3: obj.withdraw();
	//			break;
	//			case 4: obj.deposit();
	//			break;
	//			case 5: obj.fastcash();
	//			break;
	//			case 6: obj.atmhelp();
	//			break;
	//			case 7: obj.viewaccount();
	//			break;
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

