import java.util.Scanner;
/*
 * 		Baekjoon Online Judge 10824�� - �� �� 
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
		long sum2 = Long.parseLong(C+D); // String���� �Է¹޾� ���� �ڿ� parsing�Ͽ� �����Ѵ�.
		
		System.out.println(sum1+sum2);
	}

}
