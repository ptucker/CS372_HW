import java.util.*;

public class OddOrEven{
	public static void main(String[] args){

		System.out.print("Hello, please input a number between 10 and 100. ");
		int num;
		do{
			Scanner scnr = new Scanner(System.in);
			num = scnr.nextInt();
		} while(num < 10 || num > 100);
		
		for (int i = num; i > 0; i--){

			String type = "odd";
			if ((i % 2) == 0)
				type = "even";
			System.out.printf("%d is %s\n",i,type);
		}
	}
}