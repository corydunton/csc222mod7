package exceptions;

import java.util.Scanner;

public class ArrayEx {

	public static void main(String[] args) {
		int[] numbers = new int[11];
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me a number between 1 and 10");
		int num = scan.nextInt();		
		numbers[num]++;
		System.out.println("Give me a number between 1 and 10");
		 num = scan.nextInt();
		numbers[num]++;
		System.out.println("Give me a number between 1 and 10");
		 num = scan.nextInt();
		numbers[num]++;
		
		for(int i=0;i<numbers.length;i++){
			System.err.println(numbers[i]);
		}

	}

}
