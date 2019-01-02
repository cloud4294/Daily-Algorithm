import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 1022�� - �ҿ뵹�� ����� ����ϱ�
 * 
 * 		https://www.acmicpc.net/problem/1022
 * 
 */

public class Main1022 {

	public static int solve(int i, int j) {

		i = -i;
		if (i > 0 && Math.abs(j) <= Math.abs(i) && i != -j) {  

			return (Math.abs(i) * 2) * (Math.abs(i) * 2) - j - i + 1;
		} else if (i <= 0 && Math.abs(j) <= Math.abs(i)) {

			return (2 * Math.abs(i) + 1) * (2 * Math.abs(i) + 1) + (i + j);
		} else if (j > 0 && i < Math.abs(j)) {

			return (Math.abs(j - 1) + Math.abs(j)) * (Math.abs(j - 1) + Math.abs(j)) + i + j;
		} else if (j < 0 && i <= Math.abs(j) && i != j) {

			return (Math.abs(j) * 2) * (Math.abs(j) * 2) + 1 - (i + j);
		}

		return 0;

	}// ��Ģ�� ã�� ���� ����

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		int size = Integer.max(
				Integer.max(Integer.toString(solve(r1, c1)).length(), Integer.toString(solve(r1, c2)).length()),
				Integer.max(Integer.toString(solve(r2, c1)).length(), Integer.toString(solve(r2, c2)).length()));
		// �ڸ����� ���߱� ���� ����� ���� ã�� ���̸� ���� 
		
		int length = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int num = solve(i, j);
				length = Integer.toString(num).length();
				for (int k = 0; k < size - length; k++) {
					bw.write(" ");
				} // ������ �ڸ����� �������� ä��
				if(j != c1)
					bw.write(" "); // �������� �����ϱ� ���� ����
				
				bw.write(Integer.toString(num));

			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();

	}

}
