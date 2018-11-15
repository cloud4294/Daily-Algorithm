import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16396번 - 선 그리기
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
