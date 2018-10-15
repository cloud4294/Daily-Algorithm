import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 *   Baekjoon Online Judge 14888�� - ������ �����ֱ�
 * 
 *   https://www.acmicpc.net/problem/14888
 *   
 */

public class Main14888 {

	static int N;
	static int[] data;
	static int[] calc;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static void solve(int[] clac, ArrayList<Integer> order) {

		if (order.size() == N - 1) { // �������� ������ N - 1�̵Ǹ� ������ �����Ѵ�.
			int result = data[0];
			for (int i = 0; i < order.size(); i++) {
				int now = order.get(i);
				if (now == 0) {
					result += data[i + 1];
				} else if (now == 1) {
					result -= data[i + 1];
				} else if (now == 2) {
					result *= data[i + 1];
				} else if (now == 3) {
					result /= data[i + 1];
				}

			}
			if (result > max) {
				max = result;

			}
			if (result < min) {
				min = result;

			}

		}
		for (int i = 0; i < 4; i++) {

			ArrayList<Integer> noworder = new ArrayList<Integer>();
			int[] nowclac = clac;
			noworder = order;
			if (clac[i] > 0) { // �����ڰ� ���� ������� �ش翬���ڸ� ����Ʈ�� �ְ� ���� �Լ��� �ѱ��
				nowclac[i]--;
				noworder.add(i);
				solve(nowclac, noworder);
				nowclac[i]++;
				noworder.remove(noworder.size() - 1);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		calc = new int[4];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(input[i]);
		}
		ArrayList<Integer> empty = new ArrayList<Integer>();

		solve(calc, empty); // ������ ��� ����� �� üũ

		System.out.println(max);
		System.out.println(min);
	}

}
