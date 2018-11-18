import java.util.Arrays;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16435번 - 스네이크버드
 * 
 *   https://www.acmicpc.net/problem/16435
 */

public class Main16435 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] h = new int[N];
		for (int i = 0; i < N; i++) {
			h[i] = sc.nextInt();
		}
		Arrays.sort(h); // 모든 과일의 높이를 오름차순으로 정렬
		
		for (int i = 0; i < N; i++) {
			if(h[i] <= L)
				L++;
		} //현재 과일의 높이가 스네이크 버드의 길이보다 작거나 같으면 스네이크 버드의 길이를 증가
		
		System.out.println(L);
	}

}
