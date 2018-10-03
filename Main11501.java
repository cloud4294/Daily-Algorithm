import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 11501번 - 주식
 * 
 * https://www.acmicpc.net/problem/11501
 * 
 */

public class Main11501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] output = new long[T];
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] data = new int[N];
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				data[j] = Integer.parseInt(input[j]);
			}
			int max = 0;
			long sum = 0;
			for (int j = N - 1; j >= 0; j--) {
				if(data[j] > max )
					max = data[j];
				else {
					sum += max - data[j];
				}
			}// 뒤에서 부터 최대값을 갱신하고 최대값보다 작은것은 그 차이를 얻은 이익에 추가한다

			output[i] = sum;
		}
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}

}
