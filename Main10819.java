import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Baekjoon Online Judge 10819�� - ���̸� �ִ��
 *  
 * N���� ������ �̷���� �迭 A�� �־�����. �̶�, �迭�� ����ִ� ������ ������ ������ �ٲ㼭 ���� ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
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

		Collections.sort(data);	// �ʱ� ������ ����
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
		}	// ���� ū ���� �������� �翷���� �������ڿ� ū ���ڸ� ������ ���δ�.
		
		
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
			//���� ���� ���� �������� �翷���� ū ���ڿ� ���� ���ڸ� ������ ���δ�.
		
		if (sum1 > sum2)
			System.out.println(sum1);
		else
			System.out.println(sum2);
		// ���߿� ū ���� ����Ѵ�.

	}

}
