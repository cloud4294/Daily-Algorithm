import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 3273�� - �� ���� ��
 * 
 * https://www.acmicpc.net/problem/3273
 * 
 */

public class Main3273 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());
		int i = 0;
		int j = n - 1;
		int count = 0;

		Arrays.sort(data); // �Է¹��� ���� ����
		
		while (i < j) {
			if (data[i] + data[j] == x) { // �� ���� ���� �� ���� ���� ������ �� x�� ������ count�� �����ϰ� i,j�� �������� ����
				i++;
				j--;
				count++;
			} else if (data[i] + data[j] < x) { // ���� ������� ���� ���� �������� �ѱ��
				i++;
			} else if (data[i] + data[j] > x) { // ���� Ŭ��� ���� ���� �������� �ѱ��
				j--;
			}

		}

		System.out.println(count);
	}

}
