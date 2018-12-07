import java.util.Scanner;

/*
 *      Baekjoon Online Judge 11383번 - 뚊
 * 
 * 		https://www.acmicpc.net/problem/11383
 * 
 */

public class Main11383 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] data1 = new char[N][M];
		char[][] data2 = new char[N][2 * M];

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < M; j++) {
				data1[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < 2 * M; j++) {
				data2[i][j] = input.charAt(j);
			}
		}

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int j2 = j * 2;
				if (data1[i][j] != data2[i][j2]) {
					System.out.println("Not Eyfa");
					return;
				}
				if (data1[i][j] != data2[i][j2+1]) {
					System.out.println("Not Eyfa");
					return;
				}
			}
		}// 두 입력을 받아 두개씩 비교 
		
		System.out.println("Eyfa");

	}

}
