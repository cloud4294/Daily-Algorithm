import java.util.Scanner;

/*
 *   Baekjoon Online Judge 6359번 - 만취한 상법
 * 
 *   https://www.acmicpc.net/problem/6359
 */

public class Main6359 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[] room = new int[n + 1];

			for (int j = 2; j <= n; j++) {
				for (int j2 = j; j2 <= n; j2 += j) {
					if (room[j2] == 0)
						room[j2] = 1;
					else if (room[j2] == 1)
						room[j2] = 0;
				}
			} // 각각의 배수별로 방문처리, 문이 열려있으면 닫고 문이 닫혀있으면 연다.
			
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if(room[j] == 0)
					count++;
			}
			System.out.println(count);

		}
	}

}
