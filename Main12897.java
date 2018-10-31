import java.util.Scanner;

/*
 *   Baekjoon Online Judge 12897번 - Candy
 * 
 *   https://www.acmicpc.net/problem/12897
 */

public class Main12897 {

	static int d = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long result = 1;

		for (int i = 1; i <= N; i++) {
			result = (result * 3) % d;
		}
		result -= 1; // 규칙 발견 3^k -1

		System.out.println(result % d);
	}

}
