import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 2754번 - 학점계산
 * 
 * 		https://www.acmicpc.net/problem/2754
 */

public class Main2754 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		char f = n.charAt(0);
		if(f == 'F') {
			System.out.println(0.0);
			return;
		}
		
		char b = n.charAt(1);
		double output = 0.0;
		
		switch (f) {

		case 'A':
			output = 4;
			break;
		case 'B':
			output = 3;
			break;
		case 'C':
			output = 2;
			break;
		case 'D':
			output = 1;
			break;
		}

		switch (b) {

		case '+':
			output += 0.3;
			break;
		case '0':
			break;
		case '-':
			output -= 0.3;
			break;
		}

		System.out.println(output);
	}

}
