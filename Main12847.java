import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 12847�� - �ܾƸ�����Ʈ
 * 
 * ��ȣ�� ���ֱ�� ������ ������ �����̴�. ���� ���������� Ư���� �ӱ� ü�踦 ������ �ִ�.
 * �� ������ ���� ���̶����� �ϸ��� �޿��� ������ �ִ�.
 * ��ȣ��  ���� ���� �ϱ��� ���� ���� ���Ͽ� �ش�.
 * ������ �� �� ��ŭ�� ���� ��Ų��.
 * �ѹ��̶� ������ �ڸ� �ٽ� ���� ��Ű�� �ʴ´�. (���� ������ �Ѵٸ�, ���� ���� �� ������ ���� ������ �Ϸ絵 ������ �ȵȴ�.)
 * ������ �Ƹ�����Ʈ�� ©�� �ؼ��� n+1�� �Ŀ� 001�� ������ ���� �ؼ� ��ȣ�� �������� �ִ� �������� �����Ϸ� �Ѵ�. ������ �ֺ� �����ڵ��� ���� �޿��� ������ �ľ��ߴ�. ���� �����ڵ��� �޿� ��踦 ���� ���� n�� �ı��� �ϱ� ������ �˾Ƴ´�. ������ �ؼ��� ������ �غ��ؾ� �ϱ⿡ �ִ� m�� �ۿ� ���� �� �� ����.
 * �������� ������ �����ϰ� ���ݵ� 001���� �ڰ� �ִ� �ؼ��� ���� �ڵ� ���ϴ� �������� ���� �ؼ� �� �� �ִ� �ִ� ������ �ؼ����� �� �˷��ֵ��� ����.
 * 
 */


public class Main12847 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		long[] data = new long[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		long cost = 0;
		for (int i = 0; i < m; i++) {
			cost += data[i];
		} // m�� �������� ���ϱ� ������ �ʱⰪ�� ù�� ���� m�ϱ��� ������ �Ѵ�.
		long max = cost;
		for (int i = 0; i < n - m; i++) {
			cost = cost + data[m + i] - data[i]; // ���̳��� ���α׷���. �Ϸ羿 �з����鼭 �ִ밪�� �� �Ѵ�.
			if(cost > max)
				max = cost;
		}

		System.out.println(max);

	}

}
