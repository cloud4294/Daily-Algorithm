import java.util.Scanner;

/*
 *   Baekjoon Online Judge 2563번 - 색종이
 * 
 *   https://www.acmicpc.net/problem/2563
 *   
 */

public class Main2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] check = new int[101][101];
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = y; j < y+10; j++) {
				for (int j2 = x; j2 < x+10; j2++) {
					check[j][j2] = 1;
				}
			}//전체 도화지에서 색종이의 크기만큼 칠함
					
		}
		int result = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if(check[i][j] == 1)
					result++;
			}
		}// 도화지에서 칠해진 부분만 확인함
		System.out.println(result);
		
	}

}
