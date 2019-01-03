import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {

	static int N;
	static int M;
	static int[][] map;
	static int[] my = { -1, 0, 1, 0 };
	static int[] mx = { 0, -1, 0, 1 };
	static int count;

	public static void solve(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			count++;
		} // û�ҵ����ʾҾҴٸ� 2�� üũ�ϰ� count ���� 

		for (int i = 1; i <= 4; i++) {

			int nd = (d + i) % 4;
			int ny = r + my[nd];
			int nx = c + mx[nd];
			if (map[ny][nx] == 0) {
				solve(ny, nx, nd);
				return;
			} // ���������� û�Ұ� ���� �ʾҴٸ� ���ȣ�� 
		}
		int dir = (d + 2) % 4; // �ڷΰ��� ����

		if (map[r + my[dir]][c + mx[dir]] != 1) {
			solve(r + my[dir], c + mx[dir], d);
			return;
		} // �ڷΰ��� ������ ���� �ƴ϶�� ���ȣ��
		
		return; //�۵��� ����

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = 0;

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // ���� �ʱ�ȭ
		if (d % 2 == 1) {
			d = (d + 2) % 4;
		} // ȸ������� �ʱ� ������ �ٸ��Ƿ� ��������Ѵ�.
		solve(r, c, d);

		System.out.println(count);

	}

}
