import java.util.Scanner;
/*
 *    Baekjoon Online Judge 16561�� - 3�� ��� 
 * 
 *    https://www.acmicpc.net/problem/16561
 *    
 */
public class Main16561 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n % 3 != 0) {
			System.out.println(0);
			return;
		} // 3�� ����� �ƴϸ� 0�� ���
		int a = n / 3;
		int count = 0;

		for (int i = 1; i < a; i++) {
			for (int j = 1; j < a; j++) {
				if(i + j < a)
					count++;
			}
		} // 3�� ����߿��� �μ��� ���� a���� ������ count����
		
		System.out.println(count);

	}

}