import java.util.Scanner;
/*
 * 		Baekjoon Online Judge 10824번 - 네 수 
 * 
 * 		https://www.acmicpc.net/problem/10824
 */


public class Main10824 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		String D = sc.next();

		long sum1 = Long.parseLong(A+B); 
		long sum2 = Long.parseLong(C+D); // String으로 입력받아 붙힌 뒤에 parsing하여 연산한다.
		
		System.out.println(sum1+sum2);
	}

}
