import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 3273번 - 두 수의 합
 * 
 * https://www.acmicpc.net/problem/3273
 * 
 */

public class Main3273 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());
		int i = 0;
		int j = n - 1;
		int count = 0;

		Arrays.sort(data); // 입력받은 값을 정렬
		
		while (i < j) {
			if (data[i] + data[j] == x) { // 맨 앞의 수와 맨 뒤의 수를 더했을 때 x가 나오면 count를 증가하고 i,j를 안쪽으로 땡김
				i++;
				j--;
				count++;
			} else if (data[i] + data[j] < x) { // 합이 작을경우 앞의 수를 다음으로 넘긴다
				i++;
			} else if (data[i] + data[j] > x) { // 합이 클경우 뒤의 수를 이전으로 넘긴다
				j--;
			}

		}

		System.out.println(count);
	}

}
