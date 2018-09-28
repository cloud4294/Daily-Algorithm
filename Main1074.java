import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 1074�� - Z
 * 
 * ���� 
 * �Ѽ��� 2���� �迭 (�׻� 2^N * 2^N ũ���̴�)�� Z������� Ž���Ϸ��� �Ѵ�. ���� ���, 2*2�迭�� ���� ��ĭ, ������ ��ĭ, ���� �Ʒ�ĭ, ������ �Ʒ�ĭ ������� �湮�ϸ� Z����̴�.
 * 
 * ����, 2���� �迭�� ũ�Ⱑ 2^N * 2^N�� ���� ���� �ִ� ĭ�� �ϳ��� �ƴ϶��, �迭�� 4��� �� �Ŀ� (ũ�Ⱑ ���� 2^(N-1)��) ��������� ������� �湮�Ѵ�.
 * ���� ���� 2^2 * 2^2 ũ���� �迭�� �湮�� �����̴�.
 * 
 * N�� �־����� ��, (r, c)�� �� ��°�� �湮�ϴ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ���� �׸��� N=3�� ���� ���̴�.
 * 
 * �Է� 
 * ù° �ٿ� N r c�� �־�����. N�� 15���� �۰ų� ���� �ڿ����̰�, r�� c�� 0���� ũ�ų� ����, 2^N-1���� �۰ų� ���� �����̴�
 * 
 * ��� 
 * ù° �ٿ� ������ ������ ����Ѵ�.
 * 
 * 
 */


public class Main1074 {

	static long count;
	static int r;
	static int c;

	static long solve(int n, int i, int j) {

		if (i == r && j == c) {
			count += 0;
			return count;
		} else if (i == r && j + 1 == c) {
			count += 1;
			return count;
		} else if (i + 1 == r && j == c) {
			count += 2;
			return count;
		} else if (i + 1 == r && j + 1 == c) {
			count += 3;
			return count;
		} else {
			int power = (int) Math.pow(2, n - 1); //�迭�� ũ�Ⱑ n�϶� Ÿ�� ������ ����
			int area = power * power;	// Ÿ�� ������ ��ü ����
			if (r < i + power && c < j + power)
				return solve(n - 1, i, j);
			else if (r < i + power) {
				count += area;
				return solve(n - 1, i, power + j);
			} else if (c < j + power) {
				count += area * 2;
				return solve(n - 1, power + i, j);
			} else {
				count += area * 3;
				return solve(n - 1, power + i, power + j);
			}	// ��ü�� ��� Ž���ϸ� �޸� �ʰ��� �߻��ϱ� ������ ã�� ��ġ�� Ÿ���� ��������� Ž��

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		count = 0;

		System.out.println(solve(N, 0, 0));
	}

}
