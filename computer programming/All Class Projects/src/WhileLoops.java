import java.util.Scanner;


public class WhileLoops {

	public static void main(String[] args) throws InterruptedException{
	/*
		int num=1;
		while(num>=1){
			System.out.println(num);
			num ++;
			Thread.sleep(50);
		}
	*/
		Scanner scan=new Scanner(System.in);
		int num=1;
		int sysnum=num+1;
		String buzzer;
		System.out.println(num);
		while(true){
			num=scan.nextInt();
			if(num!=num+2){
				System.out.println("You Lose");
			}
			if(num==num+2){
			sysnum=num+1;
			
			if((num+1)%5==0){
				int i=num+2;
				System.out.println("Buzz");
				num=scan.nextInt();
				if(num==i){
					System.out.println(sysnum);
				}
				else{
					System.out.println("You Lose");
				}
			}
			else{
				System.out.println(sysnum);
			}
			if((num+2)%5==0){
				buzzer = scan.nextLine();
				if(buzzer=="buzz"){
					System.out.println(sysnum+2);
				}
				else{
					System.out.println("You lose");
					break;
				}
			}
		}
	}
	}
	
}
