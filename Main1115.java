import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 1115번 - 순열
 * 
 * 		https://www.acmicpc.net/problem/1115
 */

public class Main1115 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] A = new int[N];
		boolean[] checked = new boolean[N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			
			if(checked[i] == false) {
				count++;
				checked[i] = true;
				int next = A[i];
				while(checked[next] == false) {
					checked[next] = true;
					next = A[next];
				}
			}
		} // 완벽한순열은 순열A에서 하나의 cycle을 이루게 되므로 cycle의 갯수만큼 교환해주면된다. 

		System.out.println(count == 1 ? 0 : count);
		
	}

}
