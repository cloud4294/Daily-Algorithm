import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 		Baekjoon Online Judge 1780번 - 종이의 개수 
 * 
 * 		https://www.acmicpc.net/problem/1780
 */


public class Main1780 {

	static int[][] map;
	static int mcount = 0;
	static int pcount = 0;
	static int zcount = 0;

	static boolean check(int n, int y, int x) { // y,x 부터 n*n칸이 같은 값으로 되어있는 지 확인 

		for (int i = y; i < n+y; i++) {
			for (int j = x; j < n+x; j++) {
				if (map[y][x] != map[i][j]) {				
					return false;				
				}
			}
		}

		return true;
	} 

	static void solve(int n, int y, int x) { // y,x부터 n*n칸 탐색 
		
		if(n == 1) { // n이 1이면 그 칸에 가진 값의 카운트 증가
			if (map[y][x] == -1)
				mcount++;
			else if (map[y][x] == 0)
				zcount++;
			else if (map[y][x] == 1)
				pcount++;
			
		}else {
			
			boolean flag = check(n,y,x); // 체크 메소드 호출
			if (flag == false) { // n*n 칸에 다른 값이 섞인경우
				int term = n / 3 ; // 9칸으로 나누어 재귀 호출
				for (int i = y; i < n+y; i += term) {
					for (int j = x; j < n+x; j += term) {
						solve(term, i, j);
					}
				}
				
			} else {
				
				if (map[y][x] == -1)
					mcount++;
				else if (map[y][x] == 0)
					zcount++;
				else if (map[y][x] == 1)
					pcount++;
			}
			
		}
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
			
		}

		solve(n, 0, 0);
		
		
		System.out.println(mcount +" " + zcount + " "+pcount);

	}

}
