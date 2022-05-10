package Yaswanth;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner menuInput=new Scanner(System.in);
	DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00");
    
	HashMap<Integer,Integer>data=new HashMap<>();
	
	//validate login information customer number and pin number
	
	public void getLogin() throws IOException{
		int x=1;
		do {
			try {
				data.put(1234554321, 1234);
				data.put(876543210, 9876);
				System.out.println("Welcome to the ATM");
				
				System.out.print("Enter Your Customer Number:");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.print("Enter Your Pin Number:");
				setPinNumber(menuInput.nextInt());
			}
			catch(Exception e) {
				System.out.println("\n"+"Invalid charecter(s).Only numbers."+"\n");
				x=2;
			}
			for(java.util.Map.Entry<Integer, Integer> entry : data.entrySet()) {
				if(entry.getKey()==getCustomerNumber()&&entry.getValue()==getPinNumber())
					getAccountType();
			}
			System.out.println("\n"+"Wrong Customer Number or Pin Number."+"\n");
			
		}
		while(x==1);
	}


//Display Account Type Menu selection.

public void getAccountType() {
	System.out.println("Select the type of Account:");
	System.out.println("Type 1- Check Account");
	System.out.println("Type-2-Saving Account");
	System.out.println("Type-3-Exit");
	System.out.println("Choice:");
	
	int selection=menuInput.nextInt();
	switch (selection) {
	case 1:
		getChecking();
		break;
		
	case 2:
		getSaving();
		break;
		
	case 3:
		System.out.println("Thank you for using this ATM,bye");
		break;
		
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			getAccountType();
	}
	
}

//Display Checking Account with selections.

public void getChecking() {
	System.out.println("Checking  Account:");
	System.out.println("Type 1-Veiw Balance");
	System.out.println("Type-2-Withdraw Funds");
	System.out.println("Type-3-Deposit Funds");
	System.out.println("Type-4:Exit");
	System.out.println("Choice:");
	
	int selection=menuInput.nextInt();
	
	switch(selection) {
	case 1:
		System.out.println("Checking Account Balance:"+moneyFormat.format(getCheckingBalance()));
		getAccountType();
		break;
		
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for using this ATM bye.");
			break;
			
			default:
				System.out.println("Invalid choice");
				getChecking();
	}
}


//Display Saving Account with selections.

public void getSaving() {
	System.out.println("Saving  Account:");
	System.out.println("Type 1-Veiw Balance");
	System.out.println("Type-2-Withdraw Funds");
	System.out.println("Type-3-Deposit Funds");
	System.out.println("Type-4:Exit");
	System.out.println("Choice:");
	
	int selection=menuInput.nextInt();
	
	switch(selection) {
	case 1:
		System.out.println("Saving Account Balance:"+moneyFormat.format(getSavingBalance()));
		getAccountType();
		break;
		
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for using this ATM bye.");
			break;
			
			default:
				System.out.println("Invalid choice");
				getSaving();
	}
}
}
