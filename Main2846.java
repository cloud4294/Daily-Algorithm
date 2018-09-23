import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/*
 * 
 * Baekjoon Online Judge 2846�� - ��������
 * 
 * ����̴� �����Ÿ� Ÿ�� ��Ѵ�. ������ ���� ��������, ��������, ������ �̷���� �ִ�. ����̴� ���� ù �� �����Ÿ� Ÿ�� ���鼭 ���� �Ÿ����� ���̸� �����ߴ�. ����̴� ���� ū ���������� ũ�⸦ ���Ϸ��� �Ѵ�.
 * ������ ���̴� ���̰� N�� ������ ��Ÿ�� �� �ִ�. ���⼭ ���������� ��� 2���� ���� �̷���� ���̰� �����ϴ� �κ� �����̴�. ���������� ũ��� �κ� ������ ù ��° ���ڿ� ������ ������ �����̴�.
 * ���� ���, ���̰� ������ ���� ���� �ִٰ� ����. 12 3 5 7 10 6 1 11. �� �濡�� 2 ���� ���������� �ִ�. �� �ٷ� ǥ�õ� �κ� ������ ���������̴�. ù ��° ���������� ũ��� 7�̰�, �� ��° ���������� ũ��� 10�̴�. ���̰� 12�� 6�� ���� �������濡 ������ �ʴ´�.
 * ���� ū ���������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * 
 * 
 * 
 */


public class Main2846 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(input[i]);
		}
		int length = 0;
		int max = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] > data[i - 1]) {
				length += data[i] - data[i - 1];
			} else {
				if(length > max) {
					max = length;
				}			
				length = 0;
			}
		}
		if(length > max) {
			System.out.println(length);
		}else {
			System.out.println(max);	
		}
		
	}
}

