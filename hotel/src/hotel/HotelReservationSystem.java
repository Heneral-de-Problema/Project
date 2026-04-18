package hotel;
import java.util.Scanner;

public class HotelReservationSystem {

	public static void main(String[] args) {
	
		
	Scanner sc = new Scanner(System.in);
	
		String name;
		int roomChoice, nights;
		double roomPrice = 0, roomCost, foodTotal = 0;
		double totalBill, cash, change;
		
		
		System.out.println("Enter Name:");
		name = sc.nextLine();
		System.out.println("\n Select Room Type:");
		
		System.out.println("1. Small Room - P500/night");
		
		System.out.println("2. Meduin Room - P700/night");
		System.out.println("3. Large Room - P1000/night");
		
		
		
		System.out.print("Enter chioce (1-3):");
		roomChoice = sc.nextInt();
		
		
		switch (roomChoice) {
		case 1:
			roomPrice = 500;
			break;
		case 2:
			roomPrice = 700;
			break;
		case 3: 
			roomPrice = 1000;
			break;
		default:
		
		System.out.println("Invalid Room Choice");
		return;
		
		}
		
		System.out.println("Enter number of Nights:");
		nights = sc.nextInt();
		
		roomCost = roomPrice * nights;
		
		System.out.println("\n=FOOD AND DRINKS MENU");
		
		System.out.println("Coke-P50");
		System.out.println("Rice-P5");
		System.out.println("Chicken Adobo-P100");
		System.out.println("Beef Steak-P175");
		System.out.println("Halo-Halo-250");
		
		int quantity;
		
		System.out.println("Enter quantity of coke:");
		quantity = sc.nextInt();
		foodTotal += quantity * 50;
		System.out.println("Enter quantity of rice");
		quantity = sc.nextInt();
		foodTotal += quantity * 5;
		System.out.println("Enter quantity of chicken adobo:");
		quantity = sc.nextInt();
		foodTotal += quantity * 100;
		System.out.println("Enter quantity of beef steak:");
		quantity = sc.nextInt();
		foodTotal += quantity * 175;
		System.out.println("Enter quantity of halo-halo:");
		quantity = sc.nextInt();
		foodTotal += quantity * 250;
		
		totalBill = roomCost + foodTotal;
		
		System.out.println("\nEnter Cash Amount:");
		cash = sc.nextDouble();
		if (cash < totalBill) {
			System.out.println("insuffecient Payment");
			return;
		}
		change = cash - totalBill;
		
		String roomType = "";
		if (roomChoice == 1) roomType = "SmallRoom";
		else if (roomChoice == 2) roomType = "Meduin";
		else if (roomChoice == 3) roomType = "Large";
		
		System.out.println("\n===SUMMARY===");
		System.out.println("Name:" + name);
		System.out.println("RoomType:" + roomType);
		System.out.println("Number of Nights:" + nights);
		System.out.println("Room Cost:" + roomCost);
		System.out.println("Food and Drinks:" + foodTotal);
		System.out.println("Room Cost: P" + roomCost);
		System.out.println("TotalBill: P" + totalBill);
		System.out.println("Cash: P" + cash);
		System.out.println("Change: P" + change);
	
		System.out.println("THANKS");
		
		sc.close();
	}

}
