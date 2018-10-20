import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 *   Baekjoon Online Judge 13458�� - ���� ����
 * 
 *   https://www.acmicpc.net/problem/13458
 * 
 */

public class Main13458 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split(" ");
		int B = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		
		long count = 0;
		for (int i = 0; i < N; i++) {
			if(A[i] <= B) // �Ѱ������� ������ �� �ִ� ������ ���� �ش� �������� ������ ������ ������ ���������� 1�� ����
				count++;
			else {
				int temp = A[i] - B; // �Ѱ������� �����ο��� �����ϰ�
				if(temp % C == 0) { // ��ü �ο����� �ΰ������� �����ο��� ���� �����ش�
					count += temp / C + 1;
				}else {
					count += temp / C + 2;
				}
				
			}
		}
		
		System.out.println(count);
		
		
	}

}
