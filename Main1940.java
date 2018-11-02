import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 *   Baekjoon Online Judge 1940번 - 주몽
 * 
 *   https://www.acmicpc.net/problem/1940
 * 
 */

public class Main1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		int count = 0;
		int head = 0;
		int tail = N - 1;
		
		Arrays.sort(data); // 고유번호을 오름차순으로 정렬
		
		while(head < tail) {
			if(data[head] + data[tail] == M) {
				count++;
				head++;
				tail--;
			}else if(data[head] + data[tail] < M) {
				head++;
			}else if(data[head] + data[tail] > M) {
				tail--;
			}
		} //head와 tail의 합을 M가 비교하여 head와 tail의 위치를 조정 
		
		System.out.println(count);

	}

}
