import java.util.Scanner;

/*
 *   Baekjoon Online Judge 2676번 - 라스칼 삼각형
 * 
 *   https://www.acmicpc.net/problem/2676
 */

public class Main2676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println(1 + (n - m) * m);

		}
	}// 규칙을 찾아 구현

}
