import java.util.Arrays;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16208번 - 귀찮음
 * 
 *   https://www.acmicpc.net/problem/16208
 */

public class Main16208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		long length = 0;
		long result = 0;
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
			length += data[i];
		}
		Arrays.sort(data); // 정렬 한뒤 작은 것부터 잘라냄
		long[] sum = new long[n];

		for (int i = 0; i < n; i++) {
			length -= data[i];
			sum[i] = length;
		} // 잘라 낼때마다 나머지를 길이를 먼저 계산해서 배열에 저장
		for (int i = 0; i < n; i++) {
			long now = sum[i] * data[i];
			result += now;
		} // 잘라낸 길이와 나머지를 곱하여 결과에 더함

		System.out.println(result);
	}

}
