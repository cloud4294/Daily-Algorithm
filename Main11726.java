import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 11726�� - 2xn Ÿ�ϸ�
 * 
 * 2��n ũ���� ���簢���� 1��2, 2��1 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Ʒ� �׸��� 2��5 ũ���� ���簢���� ä�� �� ���� ����� ���̴�.
 * 
 * �Է� 
 * ù° �ٿ� n�� �־�����. (1 �� n �� 1,000)
 * 
 * ��� 
 * ù° �ٿ� 2��n ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
 * 
 * 
 * 
 */

public class Main11726 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n + 1];

		data[0] = 1;
		data[1] = 1;

		for (int i = 2; i <= n; i++) {
			data[i] = (data[i - 1] + data[i - 2]) % 10007;
		} // ������ �߰��ϰ� dp�� ����� ���

		System.out.println(data[n]);

	}

}
