import java.util.InputMismatchException;
import java.util.Scanner;
//A program I made to work like a code only based Omnitrix from Ben 10
public class Main 
{
	public static void main(String[] args) 
	{
		//Declaring variables
		Functions F = new Functions();
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		int choice = 0;
		String alien = "none";
		String code_input, username;
		
		System.out.print("Enter your name: ");
		username = input.nextLine();
		
		do//Begin Omnitrix boot
		{
			//This section states the current details
		System.out.println("\nActive User: " + username +
				"\nTranformation active: " + F.isActive_transformation() +
				"\nTransformation: " + F.getAlien() +
				"\nRecharge Mode: " + F.isRecharge() +
				"\nMaster Control: " + F.isMaster_control());
		
		System.out.println("\nState the function you wish to use."
				+ "\n1. Transform"
				+ "\n2. Activate/Deactivate Master Control"
				+ "\n3. Return to human form."
				+ "\n4. Close");	
		
		//Begin try/catch block
		try
		{
			choice = input.nextInt();
			switch(choice) //Switch statement for activating or deactivating some functions
			{
				//This option is for tranforming
				case 1:
					if(F.isActive_transformation() == true && F.isMaster_control() == false)//This happens if the user is already transformed but lacks the master control.
						System.out.println("That function is not been available for you yet.");
					
					else if(F.isRecharge() == true)//This is when the user tries to transform with recharge mode active
						System.out.println("That function is not available.");
					
					else if(F.isMaster_control() == true)//Master control overrides any limits taking the user to its own function
						F.Master_Control();
					
					//If all else is good with MC off, this code block executes.
					else
					{
					System.out.println("Which alien from the original 10 are you going to use?");
					alien = input.nextLine();
					F.transform(alien);
					}
					break;//End case 1
			
				case 2: //This case wil activate or deactivate the Master Control
					if(F.isMaster_control() == true)//This block deactivates
					{
						System.out.println("It's done");
						F.setMaster_control(false);
					}
					
					else//This block activates it
					{
					System.out.println("Say the magic words....");
					code_input = input2.nextLine();
					F.activate_master_control(code_input);
					
					}
					break;//End case 2
					
				case 3://This case will return the user to human form
					if(F.isActive_transformation() == true)
					F.red();
					
					else//This block executes if the user is already in human form
						System.out.println("You're already in human form.");
					break;
					
				case 4:
					System.exit(0);
					break;
				default: //A funny comment for if the user in
					System.out.print("Your carelessness has caused the destruction of the universe. The end.");
					System.exit(0);
			}//End switch
		}//End try/catch block
		
		//Catch block for incorrect inputs
		catch(InputMismatchException ex)
		{
			System.out.println("INVALID input!");
			input.nextLine();
		}
		
		}while(choice < 4);//End Omnitrix boot
	}

	//This is the timer method used for active transformations and recharge mode
	public static void timer()
	{
		//This try/catch block uses a 20 second sleep allowing the transformation for 20 seconds before issuing a warning
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Warning: Recharge mode iminent!");
		
		//This try/catch block is used for the remaining 10 seconds after being given the warning.
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Recharge mode activated.");
	} //End of timer method
}
