import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 2580�� - ������
 * 
 * 		https://www.acmicpc.net/problem/2580
 * 
 */

public class Main2580 {

	static List<point> list;
	static boolean flag;

	static class point {
		int y;
		int x;

		public point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void solve(int[][] map, int length) {

		if(flag == false) { // ������ �ϼ� ���� �ʾҴٸ� 
			
			if (length == list.size()) { // �������� ��ĭ�� ä�� ������ ����Ʈ�� ������ ���ٸ� ��ü ��� 
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(map[i][j] +" ");
					}
					System.out.println();
				}
				flag = true; // ������ �ϼ�
				return;
			} else {
				point now = list.get(length); // ���� ��ġ 
				int[] check = new int[10];
				int y = now.y;
				int x = now.x;
				int bx = 0;  // 3*3 �����γ��������� ���� �¼��� ��ǥ 
				int by = 0;
				
				for (int i = 0; i < 9; i++) {
					if (check[map[y][i]] == 0) {
						check[map[y][i]]++;
					}
				} // ������ üũ 
				for (int i = 0; i < 9; i++) {
					if (check[map[i][x]] == 0) {
						check[map[i][x]]++;
					}
				} // ������ üũ 
				if (y >= 6)
					by = 6;
				else if (y >= 3)
					by = 3;
				
				if (x >= 6)
					bx = 6;
				else if (x >= 3)
					bx = 3;
				// �� �»�� ��ġ Ȯ�� 
				
				for (int i = by; i < by + 3; i++) {
					for (int j = bx; j < bx + 3; j++) {
						if (check[map[i][j]] == 0) {
							check[map[i][j]]++;
						}
					}
				} // �� üũ 
				for (int i = 1; i <= 9; i++) {
					if (check[i] == 0) {
						int[][] nextmap = new int[9][9];
						for (int j = 0; j < 9; j++) {
							nextmap[j] = Arrays.copyOf(map[j], 9);
						}
						nextmap[y][x] = i;
						if(flag == false)
							solve(nextmap, length + 1) ;
						
					}
				} // 1 ���� 9���� üũ���� ���� ���� �迭�� ä��� ���� ��ġ�� ä������� ��� ȣ�� ����
				
			}
		}
		
	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[9][9];
		list = new ArrayList<>();
		flag = false;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					list.add(new point(i, j));
				}
			}
		} // ������ ������ �ʱ�ȭ�ϸ� 0�� �κ��� ��ġ�� ����Ʈ�� ���� 
		solve(map, 0);

	}

}
