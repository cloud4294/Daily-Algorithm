import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 15686�� - ġŲ ���
 * 
 * ���� 
 * ũ�Ⱑ N��N�� ���ð� �ִ�. ���ô� 1��1ũ���� ĭ���� �������� �ִ�. ������ �� ĭ�� �� ĭ, ġŲ��, �� �� �ϳ��̴�. ������ ĭ�� (r, c)�� ���� ���·� ��Ÿ����, r�� c�� �Ǵ� ���������� r��° ĭ, ���ʿ������� c��° ĭ�� �ǹ��Ѵ�. r�� c�� 1���� �����Ѵ�.
 * �� ���ÿ� ��� ������� ġŲ�� �ſ� �����Ѵ�. ����, ������� "ġŲ �Ÿ�"��� ���� �ַ� ����Ѵ�. ġŲ �Ÿ��� ���� ���� ����� ġŲ�� ������ �Ÿ��̴�. ��, ġŲ �Ÿ��� ���� �������� ��������, ������ ���� ġŲ �Ÿ��� ������ �ִ�. ������ ġŲ �Ÿ��� ��� ���� ġŲ �Ÿ��� ���̴�.
 * ������ �� ĭ (r1, c1)�� (r2, c2) ������ �Ÿ��� |r1-r2| + |c1-c2|�� ���Ѵ�.
 * ���� ���, �Ʒ��� ���� ������ ���� ���ø� ���캸��.
 * 0 2 0 1 0
 * 1 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 1
 * 0 0 0 1 2
 * 0�� �� ĭ, 1�� ��, 2�� ġŲ���̴�.
 * (2, 1)�� �ִ� ���� (1, 2)�� �ִ� ġŲ������ �Ÿ��� |2-1| + |1-2| = 2, (5, 5)�� �ִ� ġŲ������ �Ÿ��� |2-5| + |1-5| = 7�̴�. ����, (2, 1)�� �ִ� ���� ġŲ �Ÿ��� 2�̴�.
 * (5, 4)�� �ִ� ���� (1, 2)�� �ִ� ġŲ������ �Ÿ��� |5-1| + |4-2| = 6, (5, 5)�� �ִ� ġŲ������ �Ÿ��� |5-5| + |4-5| = 1�̴�. ����, (5, 4)�� �ִ� ���� ġŲ �Ÿ��� 1�̴�.
 * �� ���ÿ� �ִ� ġŲ���� ��� ���� �����������̴�. ���������� ���翡���� ������ ������Ű�� ���� �Ϻ� ġŲ���� �����Ű���� �Ѵ�. ���� ���� ���� �� ���ÿ��� ���� ������ ���� �� �� �ִ�  ġŲ���� ������ �ִ� M����� ����� �˾Ƴ�����.
 * ���ÿ� �ִ� ġŲ�� �߿��� �ִ� M���� ����, ������ ġŲ���� ��� ������Ѿ� �Ѵ�. ��� ����, ������ ġŲ �Ÿ��� ���� �۰� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է� 
 * ù° �ٿ� N(2 �� N �� 50)�� M(1 �� M �� 13)�� �־�����.
 * ��° �ٺ��� N���� �ٿ��� ������ ������ �־�����.
 * ������ ������ 0, 1, 2�� �̷���� �ְ�, 0�� �� ĭ, 1�� ��, 2�� ġŲ���� �ǹ��Ѵ�. ���� ������ 2N���� ���� ������, ��� 1���� �����Ѵ�. ġŲ���� ������ M���� ũ�ų� ����, 13���� �۰ų� ����.
 * ��� 
 * ù° �ٿ� �����Ű�� ���� ġŲ���� �ִ� M���� ����� ��, ������ ġŲ �Ÿ��� �ּڰ��� ����Ѵ�.
 * 
 * 
 * 
 */
public class Main15686 {

	static ArrayList<chi> chihouse;
	static ArrayList<chi> house;
	static boolean[] visited;
	static int[] output;
	static int M;
	static int result;

	static class chi {
		int i;
		int j;

		chi(int i, int j) {
			this.i = i;
			this.j = j;

		}
	}

	static void solve(int start, int depth) {
		output[depth] = start + 1;

		for (int i = start; i < chihouse.size(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			solve(i, depth + 1); // i��° ġŲ���� �����ϰ� �����Ѱ����� depth�� ���� ��Ų�� ��� ȣ��
			visited[i] = false; 
		}

		if (depth == M - 1) { // ġŲ�� M���� ���������� �� ġŲ�Ÿ� ���
			int sum = 0;
			int current = 0;
			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					current = Math.abs(house.get(i).i - chihouse.get(output[j] - 1).i)
							+ Math.abs(house.get(i).j - chihouse.get(output[j] - 1).j);
					min = Math.min(min, current);
				}

				sum = sum + min;
			} // �� ������ ������ ġŲ�� ���� ���� ����� ���� �����Ͽ� ġŲ�Ÿ��տ� ����

			result = Math.min(result, sum); //result���� ����ġŲ�Ÿ��� ġŲ�Ÿ��� �� �� ���������� ����
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chihouse = new ArrayList<chi>();
		house = new ArrayList<chi>();
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					chi current = new chi(i, j);
					house.add(current);
				} else if (temp == 2) {
					chi current = new chi(i, j);
					chihouse.add(current);	
				}
				// �� ����Ʈ�� ġŲ�� ����Ʈ�� �и��Ͽ� ����
			}
		}
		visited = new boolean[chihouse.size()];
		output = new int[chihouse.size()];
		for (int i = 0; i < chihouse.size(); i++) {
			visited[i] = true;
			solve(i, 0);	//i ��° ġŲ���� ������ ���
			visited[i] = false;
		}

		System.out.println(result);
	}

}
