import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 13565번 - 침투
 * 
 * 
 * 인제대학교 생화학연구실에 재직중인 석교수는 전류가 침투(percolate) 할 수 있는 섬유 물질을 개발하고 있다. 
 * 이 섬유 물질은 2차원 M × N 격자로 표현될 수 있다. 편의상 2차원 격자의 위쪽을 바깥쪽(outer side), 아래쪽을 안쪽(inner side)라고 생각하기로 한다. 
 * 또한 각 격자는 검은색 아니면 흰색인데, 검은색은 전류를 차단하는 물질임을 뜻하고 흰색은 전류가 통할 수 있는 물질임을 뜻한다. 전류는 섬유 물질의 가장 바깥쪽 흰색 격자들에 공급되고, 
 * 이후에는 상하좌우로 인접한 흰색 격자들로 전달될 수 있다.김 교수가 개발한 섬유 물질을 나타내는 정보가 2차원 격자 형태로 주어질 때, 
 * 바깥쪽에서 흘려 준 전류가 안쪽까지 침투될 수 있는지 아닌지를 판단하는 프로그램을 작성하시오.
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

		for (int i = 0; i < n; i++) { // 첫번째 줄만 dfs 탐색
			dfs(i,0);
			if (flag == true) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");

	}

}
