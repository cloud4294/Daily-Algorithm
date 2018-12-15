import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 		Baekjoon Online Judge 11004번 - K번째 수
 * 
 * 		https://www.acmicpc.net/problem/11004
 */
public class Main11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// BufferedReader를 사용하면 제한시간내에 입력받을 수 있음
	
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
		}
		
		Arrays.sort(arr); 
		System.out.println(arr[K-1]);

	}

}
