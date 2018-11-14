import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16396번 - 선 그리기
 * 
 *   https://www.acmicpc.net/problem/16396
 *    
 */

public class Main16396 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] length = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			length[i] = false; 
		}// 전체를 false로 초기화
		
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j < b; j++) {
				length[j] = true;
			}
		}// 각 직선에 해당하는 부분을 true로 변경 
		
		int result = 0;
		for (int i = 1; i <= 10000; i++) {
			if(length[i] == true)
				result++;
		}// true인 부분만 확인하여 길이를 구함
		
		System.out.println(result);
		
	}

}
