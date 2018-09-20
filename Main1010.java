import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  1010�� �ٸ� ����
 *
 *  ����̴� �� ������ ������ �Ǿ���.�� ���ÿ��� ���ø� ���ʰ� �������� ������ ū ���� �帣�� �ִ�.������ ����̴� �ٸ��� ��� �ùε��� ���� �ǳʴµ� ū ������ �ް� ������ �˰� �ٸ��� ����� ����Ͽ���.
 *  �� �ֺ����� �ٸ��� ���⿡ ������ ���� ����Ʈ��� �Ѵ�.����̴� �� �ֺ��� ����� ������ �� ��� ���� ���ʿ��� N���� ����Ʈ�� �ְ� ���ʿ��� M���� ����Ʈ�� �ִٴ� ���� �˾Ҵ�.
 *  N��M)����̴� ������ ����Ʈ�� ������ ����Ʈ�� �ٸ��� �����Ϸ��� �Ѵ�.(�̶� �� ����Ʈ���� �ִ� �� ���� �ٸ��� ����� �� �ִ�.)����̴� �ٸ��� �ִ��� ���� �������� �ϱ� ������ ������ ����Ʈ ������ŭ(N��)�ٸ��� �������� �Ѵ�.
 *  �ٸ������� ���� ������ �� ���ٰ� �� �� �ٸ��� ���� �� �ִ� ����� ���� ���ϴ� ���α׷��� �ۼ��϶�.
 *  
*/
public class Main1010 {

	public static int solve(int n, int m) {

		int sum = 0;

		if (n == 1)
			return m; // ���ʿ��� �ϳ��� �ִٸ� ����Ǽ��� ���� ���� ���� ����

		for (int i = 0; i < m - n + 1; i++) {

			sum += solve(n - 1, m - (i + 1)); // ���ʿ��� �ϳ� ���ʿ��� �ϳ��� �����Ͽ� ���� ����� ���� ��������� �ջ�
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] output = new int[T];
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			output[i] = solve(N, M);
		}

		for (int out : output) {
			System.out.println(out);
		}

	}

}
