import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16433번 - 주디와 당근농장
 * 
 *   https://www.acmicpc.net/problem/16433
 */

public class Main16433 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		int check = 0;
		
		if((R+C)%2 ==0)
			check = 0;
		else 
			check = 1;
		// 심어져있는 당근의 좌표 합이 홀수인지 짝수인지 확인함
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if((i+j)%2 == check)
					System.out.print('v');
				else 
					System.out.print('.');
			}
			System.out.println();
		}// 좌표합을 기준으로 홀수 짝수를 구분하여 출력
		
		
				
	}

}
