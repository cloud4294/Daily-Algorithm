import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 11576�� - Base Conversion
 * 
 * 		https://www.acmicpc.net/problem/11576
 * 
 */


public class Main11576 {

	static int m;

	static void solve(int A, int B, String[] ans) {

		long dec = 0;
		ArrayList<Long> Bdata = new ArrayList<Long>();

		for (int i = 0; i < m; i++) {
			int current = Integer.parseInt(ans[i]);
			dec = dec * A + current;

		} // A������ ���� 10�������� ��ȯ�Ѵ�.

		while (dec > 0) {
			Bdata.add(dec % B);
			dec /= B;
		} // 10������ ���� B������ ���� ��ȯ�Ѵ�.
		int length = Bdata.size();

		for (int i = length - 1; i >= 0; i--) {
			System.out.print(Bdata.get(i) +" ");
		} // �迭�� ������ �����Ƿ� ����� ����Ѵ�.

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());

		String[] data = new String[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			data[i] = st.nextToken();
		}
		solve(A, B, data);

	}

}
