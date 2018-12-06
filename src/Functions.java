import java.util.Scanner;

public class Functions extends Main
{
	//Declaring variables
	private static boolean master_control = false;
	private static boolean active_transformation = false;
	private static boolean recharge = false;
	private static String alien = "None";
	private static String[] aliens = {"Wildmutt", "Fourarms", "Grey Matter", "XLR8", "Upgrade",
			"Diamondhead", "Ripjaws", "Stinkfly", "Ghostfreak", "Heatblast"};
	
	public static void Master_Control()
	{
		System.out.println("Which alien will you turn into?");
		Scanner input = new Scanner(System.in);
		alien = input.nextLine();
		
		//Searches the array 
		for(int x = 0; x < aliens.length; x++)
		{
			if(aliens[x].equals(alien))
				setActive_transformation(true);
			
		}
		
		//This is for if the input name doesn't exist within the array.
				if(isActive_transformation() == false)
					System.out.println("This alien is not available for selection or doesn't exist.");
				
		//This area is for when the name is in the array.
		else
			System.out.println("Here we go!");
			setAlien(alien);
	}
	
	//For transformations while master control isn't active
	public static void transform(String alien)
	{
		Scanner input = new Scanner(System.in);
		alien = input.nextLine();
		
		//Searches the array 
		for(int x = 0; x < aliens.length; x++)
		{
			if(aliens[x].equals(alien))
				setActive_transformation(true);
			
		}
		
		//This is for if the input name doesn't exist within the array.
		if(isActive_transformation() == false)
			System.out.println("This alien is not available for selection or doesn't exist.");
		
		//This area is for when the name is in the array.
		else
		System.out.println("Here we go!");
		setAlien(alien);
		timer();
		red();
		
	}//End method
	
	//Activates recharge mode
	public static void red()
	{
		if(isActive_transformation() == true) //This if is for when a transformation is active
		{
			if(isMaster_control() == true) //Master control bypasses the need for recharge mode meaning changing back won't set it off
			{
				setRecharge(false);
				setActive_transformation(false);
				setAlien("None");
			}//Enter master control area
			
			else //This area is for if the master control isn't active
			{
				setRecharge(true);
				setActive_transformation(false);
				setAlien("None");
				
				//Begins countdown of recharge period
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//End countdown
				
				System.out.println("\n\n\n\n\n\nYou're free to transform again.");
				setRecharge(false);
			}//End non MC else
		}
		
		//This is when the user has no active transformations
		else
			System.out.println("That function isn't possible right now");
	}//End recharge mode
	
	
	//Activates or deactivates master control
	public static void activate_master_control(String code)
	{
		if(code.contains("Master Control, activate"))
		{
			setMaster_control(true);
			setRecharge(false);
		}
		else
			System.out.println("Invalid input");
	}

	
	//Getters and Setters
	public static boolean isMaster_control() {
		return master_control;
	}

	public static void setMaster_control(boolean master_control) {
		Functions.master_control = master_control;
	}

	public static boolean isActive_transformation() {
		return active_transformation;
	}

	public static void setActive_transformation(boolean active_transformation) {
		Functions.active_transformation = active_transformation;
	}

	public static boolean isRecharge() {
		return recharge;
	}

	public static void setRecharge(boolean recharge) {
		Functions.recharge = recharge;
	}

	public static String getAlien() {
		return alien;
	}

	public static void setAlien(String a) {
		Functions.alien = a;
	}
	
	
	
}
