import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 *   Baekjoon Online Judge 14889번 - 스타트와 링크
 * 
 * 	 https://www.acmicpc.net/problem/14889
 * 
 */

public class Main14889 {
	static int N;
	static int data[][];
	static int result = Integer.MAX_VALUE;
	

	static void solve(int now,ArrayList<Integer> start,ArrayList<Integer> link) {
		if (now == N ) {
			check(start, link); 
			return;
		} else if (start.size() == N / 2) { // 한쪽팀이 N/2 가 되면 나머지를 모두 다른 팀에 채워 넣음
			for (int i = now; i < N; i++) {
				link.add(i);
			}
			check(start, link);
			return;

		} else if (link.size() == N / 2) {
			for (int i = now; i < N; i++) {
				start.add(i);
			}
			check(start, link);
			return;
		} 
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < start.size(); i++) {
				temp.add(start.get(i));
			}
			ArrayList<Integer> temp2 = new ArrayList<Integer>();
			for (int i = 0; i < link.size(); i++) {
				temp2.add(link.get(i));
			}
			temp.add(now); 
			solve(now + 1,temp,link); // 현재 팀원번호의 선수를 start 팀에 넣는 경우

			temp2.add(now);
			solve(now + 1,start,temp2) ; // 현재 팀원번호의 선수를 link 팀에 넣는 경우

		

	}

	static void check(ArrayList<Integer> start, ArrayList<Integer> link) {
		int startcount = 0;
		int linkcount = 0;
		for (int i = 0; i < N / 2; i++) {
			int checknow = start.get(i);
			for (int j = i+1; j < N / 2; j++) {
				int check = start.get(j);
				startcount += data[checknow][check] + data[check][checknow];

			}
		}
		for (int i = 0; i < N / 2; i++) {
			int checknow = link.get(i);
			for (int j = i+1; j < N / 2; j++) {
				int check = link.get(j);
				linkcount += data[checknow][check] + data[check][checknow];
			}
		} // 양 팀이 모두 채워지면 각 팀원 별로 능력치를 계산한다.

		int checknum = Integer.max(startcount, linkcount) - Integer.min(startcount, linkcount); 

		if (checknum < result) {
			result = checknum;
		} // 능력치의 차가 되도록 한다.

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(input[j]);
			}
		}

		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> link = new ArrayList<Integer>();
		solve(0,start,link);

		System.out.println(result);
	}

}
