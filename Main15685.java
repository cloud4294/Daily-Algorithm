import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Baekjoon Online Judge 15685�� - �巡�� Ŀ��
 * 
 * �巡�� Ŀ��� ������ ���� �� ���� �Ӽ����� �̷���� ������, ������ ��ǥ ��� ������ ���ǵȴ�. ��ǥ ����� x���� �� ����, y���� �� �����̴�.
 * ���� ��
 * ���� ����
 * ����
 * 0���� �巡�� Ŀ��� �Ʒ� �׸��� ���� ���̰� 1�� �����̴�. �Ʒ� �׸��� (0, 0)���� �����ϰ�, ���� ������ �������� 0���� �巡�� Ŀ���̴�.
 * 1���� �巡�� Ŀ��� 0���� �巡�� Ŀ�긦 �� ���� �������� �ð� �������� 90�� ȸ����Ų ���� 0���� �巡�� Ŀ���� �� ���� ���� ���̴�. �� ���̶� ���� ������ ������ Ÿ�� �̵����� ��, ���� �� �Ÿ��� �ִ� ���� �ǹ��Ѵ�.
 * 2���� �巡�� Ŀ�굵 1���븦 ���� ����� �̿��ؼ� ���� �� �ִ�. (�Ķ��� ������ ���� �߰��� ������ ��Ÿ����)
 * 3���� �巡�� Ŀ�굵 2���� �巡�� Ŀ�긦 �̿��� ���� �� �ִ�. �Ʒ� �׸��� 3���� �巡�� Ŀ���̴�.
 * ��, K(K > 1)���� �巡�� Ŀ��� K-1���� �巡�� Ŀ�긦 �� ���� �������� 90�� �ð� ���� ȸ�� ��Ų ����, �װ��� �� ���� ���� ���̴�.
 * ũ�Ⱑ 100��100�� ���� ���� �巡�� Ŀ�갡 N�� �ִ�. �̶�, ũ�Ⱑ 1��1�� ���簢���� �� �������� ��� �巡�� Ŀ���� �Ϻ��� ���簢���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ������ ��ǥ�� (x, y)�� ��Ÿ����, 0 �� x �� 100, 0 �� y �� 100�� ��ȿ�� ��ǥ�̴�.
 * 
 *
 */

public class Main15685 {

	static int[][] map = new int[101][101];

	static void solve(int x, int y, int d, int g) {

		ArrayList<Integer> listX = new ArrayList<Integer>();
		ArrayList<Integer> listY = new ArrayList<Integer>();
		listX.add(x);
		listY.add(y);

		map[listY.get(0)][listX.get(0)] = 1;

		if (d == 0) {
			listX.add(x + 1);
			listY.add(y);
		} else if (d == 1) {
			listX.add(x);
			listY.add(y - 1);

		} else if (d == 2) {
			listX.add(x - 1);
			listY.add(y);

		} else if (d == 3) {
			listX.add(x);
			listY.add(y + 1);
		}
		map[listY.get(1)][listX.get(1)] = 1; 

		for (int i = 0; i < g; i++) {
			check(listX, listY);
		}
	}

	static void check(ArrayList<Integer> listX, ArrayList<Integer> listY) {

		int endX = listX.get(listX.size() - 1);
		int endY = listY.get(listY.size() - 1); 
		int length = listX.size() - 2;

		for (int j = length; j >= 0; j--) {

			int tempX = listX.get(j) - endX; 
			int tempY = listY.get(j) - endY;

			if (tempX + endY >= 0 && -tempY + endX >= 0 && tempX + endY <= 100 && -tempY + endX <= 100) {
				map[tempX + endY][-tempY + endX] = 1;
				listX.add(-tempY + endX);
				listY.add(tempX + endY);
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];
		int[] d = new int[N];
		int[] g = new int[N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			x[i] = Integer.parseInt(input[0]);
			y[i] = Integer.parseInt(input[1]);
			d[i] = Integer.parseInt(input[2]);
			g[i] = Integer.parseInt(input[3]);
		}

		for (int i = 0; i < N; i++) {
			solve(x[i], y[i], d[i], g[i]);
		}

		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
					count++;
			}
			
		}

		System.out.println(count);
	}

}
