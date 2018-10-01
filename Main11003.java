import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


/*
 * Baekjoon Online Judge 11003�� - �ּڰ� ã��
 * 
 * 
 * ���� 
 * N���� �� A1, A2, ..., AN�� L�� �־�����.
 * Di = Ai-L+1 ~ Ai ���� �ּڰ��̶�� �� ��, D�� ����� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. �̶�, i �� 0 �� Ai�� �����ϰ� D�� ���ؾ� �Ѵ�.
 * 
 * �Է� 
 * ù° �ٿ� N�� L�� �־�����. (1 �� L �� N �� 5,000,000)
 * ��° �ٿ��� N���� �� Ai�� �־�����. (-109 �� Ai �� 109)
 * 
 * ��� 
 * ù° �ٿ� Di�� �������� �����Ͽ� ������� ����Ѵ�.
 * 
 */



public class Main11003 {
	static class data {
		int data;
		int idx;

		data(int data, int idx) {
			this.data = data;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		Deque<data> window = new ArrayDeque<data>();
		data[] current = new data[N];
		int[] output = new int[N];
		for (int i = 0; i < N; i++) {
			current[i] = new data(Integer.parseInt(st.nextToken()), i);
		}

		for (int i = 0; i < N; i++) {

			if (!window.isEmpty() && i - window.peekFirst().idx >= L) {
				window.remove();
			} // ��ũ�� ù��° ���� ������ ����� ����� ����

			while (!window.isEmpty() && window.peekLast().data >= current[i].data) {
				window.removeLast();
			} // ��ũ�� ������ ���� ���簪���� ũ�ų� ������ ����

			window.addLast(current[i]); // ��ũ�� ���� �� �߰�

			output[i] = window.peekFirst().data;
		}

		for (int i = 0; i < output.length; i++) {
			bw.write(output[i] + " ");
		}
		bw.flush();
		bw.close();
	}

}
