import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *   Baekjoon Online Judge 2805번 - 나무 자르기 
 * 
 *   https://www.acmicpc.net/problem/2805
 */

public class Main2805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] data = new int[N];
		int max = 0;
		long result = 0;
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			if (data[i] > max)
				max = data[i];
		}
		int left = 0;
		int right = max;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if(data[i] > mid) {
					sum += data[i] - mid;
				}
			}
			
			if(sum >= M) {
				if(result < mid)
					result = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		} // 이분탐색으로 최적값을 찾음
		
		System.out.println(result);

	}

}
