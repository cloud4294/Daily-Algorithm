import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 13565�� - ħ��
 * 
 * 
 * �������б� ��ȭ�п����ǿ� �������� �������� ������ ħ��(percolate) �� �� �ִ� ���� ������ �����ϰ� �ִ�. 
 * �� ���� ������ 2���� M �� N ���ڷ� ǥ���� �� �ִ�. ���ǻ� 2���� ������ ������ �ٱ���(outer side), �Ʒ����� ����(inner side)��� �����ϱ�� �Ѵ�. 
 * ���� �� ���ڴ� ������ �ƴϸ� ����ε�, �������� ������ �����ϴ� �������� ���ϰ� ����� ������ ���� �� �ִ� �������� ���Ѵ�. ������ ���� ������ ���� �ٱ��� ��� ���ڵ鿡 ���޵ǰ�, 
 * ���Ŀ��� �����¿�� ������ ��� ���ڵ�� ���޵� �� �ִ�.�� ������ ������ ���� ������ ��Ÿ���� ������ 2���� ���� ���·� �־��� ��, 
 * �ٱ��ʿ��� ��� �� ������ ���ʱ��� ħ���� �� �ִ��� �ƴ����� �Ǵ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * 
 * 
 */

public class Main13565 {

	static char[][] map;
	static int n, m;
	static boolean flag = false;
	
	public static void dfs(int x, int y) { 

		map[y][x] = '1';
		if (y == m - 1)
			flag = true;
		if (x > 0 && map[y][x - 1] == '0')
			dfs(x - 1, y);
		if (y > 0 && map[y - 1][x] == '0')
			dfs(x, y - 1);
		if (x < n - 1 && map[y][x + 1] == '0')
			dfs(x + 1, y);
		if (y < m - 1 && map[y + 1][x] == '0')
			dfs(x, y + 1);


	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) { // ù��° �ٸ� dfs Ž��
			dfs(i,0);
			if (flag == true) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");

	}

}
