// Noah Heath pd. 4 Semester 1 Project 1/8/2014
import java.util.*;
public class Table {

	public static void main(String[] args) throws InterruptedException{
		while(true){
			boolean tabletaken[]=new boolean[100];
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String Table="";
		int tablenum=1;
		int num;
	System.out.println("Welcome to Food'n'Stuff, we have really good food,\n\nand pretty good stuff.\n");	
	System.out.println("May I have the name of your party please?\n");
	
	String name = scan.nextLine();
	
	System.out.println("And how many people?\n");
	int party = scan.nextInt();
	if(party%4==0){
		tablenum=party/4;
	}
	if(party%4!=0){
	tablenum=(party/4)+1;
	}
	System.out.println("Do you need a special table?\n");
	String specialtable = scan.nextLine();
	String special = scan.nextLine();
	if(special.toLowerCase().startsWith("y")){		
		if(tablenum==1){
			num=rand.nextInt(5)+96;
			while(tabletaken[num-1]){
				num=rand.nextInt(5)+96;
			}
			if(tabletaken[num-1]){
				System.out.println("There are no tables available right now, it will be a "+(rand.nextInt(5)+1)+" minute wait");
				System.exit(0);
			}
			Table = " table "+num;
			System.out.println(name+" party of "+party+Table);
			tabletaken[num-1]=true;
		}
		if(tablenum>1&&tablenum<=5){
		num=rand.nextInt(5)+96;
		while(num>=101-tablenum){
		num=rand.nextInt(5)+96;
		while(tabletaken[num-1]){
			num=rand.nextInt(5)+96;
		}
		if(tabletaken[num-1]){
			System.out.println("There are no tables available right now, it will be a "+(rand.nextInt(5)+1)+" minute wait");
			System.exit(0);
		}
		}
		tabletaken[num-1]=true;
		while(tabletaken[num-1]){
			num=rand.nextInt(5)+96;
		}
		if(tabletaken[num-1]){
			System.out.println("There are no tables available right now, it will be a "+(rand.nextInt(5)+1)+" minute wait");
			System.exit(0);
		}
		System.out.println(name+" party of "+party);
		for(int i=0;i<tablenum;i++){
			Table = " table "+(num+i);
			System.out.println(Table);
			tabletaken[num-1+i]=true;
		}
		}
		if(tablenum>5){
			System.out.println("I'm sorry, there are no special tables available for a party of your size.");
		}
	}
	if(special.toLowerCase().startsWith("n")){
		if(tablenum==1){
			num=rand.nextInt(95)+1;
			while(tabletaken[num-1]){
				num=rand.nextInt(95)+1;
			}
			Table = " table "+num;
			System.out.println(name+" party of "+party+Table);
			tabletaken[num-1]=true;
		}
		if(tablenum>1){
			num=rand.nextInt(95)+1;
			while(num>=96-tablenum){
			num=rand.nextInt(95)+1;
			}
			while(tabletaken[num-1]){
				num=rand.nextInt(5)+96;
			}
			if(tabletaken[num-1]){
				System.out.println("There are no tables available right now, it will be a "+(rand.nextInt(5)+1)+" minute wait");
				System.exit(0);
			}
			tabletaken[num-1]=true;
			System.out.println(name+" party of "+party);
			for(int i=0;i<tablenum;i++){
				Table = " table "+(num+i);
				System.out.println(Table);
			}}}
	Thread.sleep(3000);
}}}