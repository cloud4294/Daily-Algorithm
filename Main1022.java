import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *   Baekjoon Online Judge 1022�� - �ҿ뵹�� ���ڰ� ����ϱ� 
 * 
 *   https://www.acmicpc.net/problem/1022
 */

public class Main1022 {

	static int[] mx = { 1, 0, -1, 0 };
	static int[] my = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int max = 0;
		if (Math.abs(r1) > max)
			max = Math.abs(r1);
		if (Math.abs(c1) > max)
			max = Math.abs(c1);
		if (Math.abs(r2) > max)
			max = Math.abs(r2);
		if (Math.abs(c2) > max)
			max = Math.abs(c2); // �ִ� ũ�⸦ ã�´� 

		int[][] map = new int[2 * max + 1][2 * max + 1]; // �ִ�ũ��� �ʻ���� ���Ѵ�

		int count = 1;
		int x = max;
		int y = max;
		int length = 1;
		map[max][max] = 1;

		while (count < (2 * max + 1) * (2 * max + 1)) {
			int check = 0;
			for (int i = 0; i < 4; i++) {
				check++;
				for (int j = 0; j < length; j++) {
					map[y][x] = count;
					if (count == (2 * max + 1) * (2 * max + 1))
						break;
					x += mx[i];
					y += my[i];
					count++;
				}
				if (check == 2) {
					length++;
					check = 0;
				} // �ι� ������ ���������� ���̰� �����Ѵ� 
			}

		}
		int check = 0;
		for (int i = max + r1; i <= max + r2; i++) {
			for (int j = max + c1; j <= max + c2; j++) {

				if (map[i][j] > check)
					check = map[i][j];
			}
		}
		int l = 0;
		while (check > 0) {
			check /= 10;
			l++;
		}// ��°��� ���� �䰪�� �ڸ����� ���Ѵ�

		for (int i = max + r1; i <= max + r2; i++) {
			for (int j = max + c1; j <= max + c2; j++) {

				String now = Integer.toString(map[i][j]);
				if(j == max + c1) {
					for (int k = 0; k < l - now.length(); k++) {
						System.out.print(" ");
					}
				}else {
					for (int k = 0; k <= l - now.length(); k++) {
						System.out.print(" ");
					}
					
				}
				

				System.out.print(now);

			}
			System.out.println();
		}// ������ǿ� �°� ����Ѵ�.

	}

}
