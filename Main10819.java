import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Baekjoon Online Judge 10819번 - 차이를 최대로
 *  
 * N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
 * |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * 
 * 
 */
public class Main10819 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> data = new ArrayList<Integer>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			data.add(Integer.parseInt(input[i]));
		}

		Collections.sort(data);	// 초기 데이터 정렬
		output.add(data.get(N - 1));
		int min = 0;
		int max = N - 2;
		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			count++;
			if (count <= 2) {
				if (i % 2 == 0) {
					output.add(0, data.get(min++));
				} else {
					output.add(data.get(min++));
				}
			} else {
				if (i % 2 == 0) {
					output.add(0, data.get(max--));
				} else {
					output.add(data.get(max--));
				}

				if (count == 4)
					count = 0;
			}
		}
		int sum1 = 0;
		for (int i = 0; i < output.size() - 1; i++) {
			int temp = output.get(i) - output.get(i + 1);
			if (temp < 0)
				temp *= -1;
			sum1 += temp;
		}	// 가장 큰 값을 기준으로 양옆으로 낮은숫자와 큰 숫자를 번갈아 붙인다.
		
		
		output.clear();
		output.add(data.get(0));
		min = 1;
		max = N - 1;
		count = 0;
		for (int i = 0; i < N - 1; i++) {
			count++;
			if (count <= 2) {
				if (i % 2 == 0) {
					output.add(0, data.get(max--));
				} else {
					output.add(data.get(max--));
				}
			} else {
				if (i % 2 == 0) {
					output.add(0, data.get(min++));
				} else {
					output.add(data.get(min++));
				}

				if (count == 4)
					count = 0;
			}
		}
		int sum2 = 0;
		for (int i = 0; i < output.size() - 1; i++) {
			int temp = output.get(i) - output.get(i + 1);
			if (temp < 0)
				temp *= -1;
			sum2 += temp;
		}
			//가장 작은 값을 기준으로 양옆으로 큰 숫자와 작은 숫자를 번갈아 붙인다.
		
		if (sum1 > sum2)
			System.out.println(sum1);
		else
			System.out.println(sum2);
		// 둘중에 큰 값을 출력한다.

	}

}
