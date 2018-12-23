import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 1115�� - ����
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
		} // �Ϻ��Ѽ����� ����A���� �ϳ��� cycle�� �̷�� �ǹǷ� cycle�� ������ŭ ��ȯ���ָ�ȴ�. 

		System.out.println(count == 1 ? 0 : count);
		
	}

}
