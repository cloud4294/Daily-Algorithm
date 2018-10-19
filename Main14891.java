import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 *   Baekjoon Online Judge 14891번 - 톱니바퀴
 * 
 *    https://www.acmicpc.net/problem/14891
 *  
 */


public class Main14891 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character>[] data = new ArrayList[4];
		int result = 0;
		for (int i = 0; i < 4; i++) {
			data[i] = new ArrayList<Character>();
		}

		for (int i = 0; i < 4; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				data[i].add(input.charAt(j));
			}
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			String[] com = br.readLine().split(" ");
			int target = Integer.parseInt(com[0]) - 1;
			int dir = Integer.parseInt(com[1]);

			if (dir == 1) {
				char temp = data[target].get(data[target].size() - 1);
				data[target].remove(data[target].size() - 1);
				data[target].add(0, temp);
			} else if (dir == -1) {
				char temp = data[target].get(0);
				data[target].remove(0);
				data[target].add(temp);
			} // 중심이 되는 톱니 바퀴를 먼저 돌림
			int left = target - 1;
			int right = target + 1;
			int now = target;
			int nowdir = (-1) * dir;
			while (left >= 0) {

				if (nowdir == 1 && data[now].get(5) != data[left].get(2)) {
					char temp = data[left].get(data[left].size() - 1);
					data[left].remove(data[left].size() - 1);
					data[left].add(0, temp);
					now = left;
					left--;
					nowdir = (-1) * nowdir;
				} else if (nowdir == -1 && data[now].get(7) != data[left].get(2)) {
					char temp = data[left].get(0);
					data[left].remove(0);
					data[left].add(temp);

					now = left;
					left--;
					nowdir = (-1) * nowdir;
				} else
					break;
			} // 중심 바퀴부터 왼쪽으로 돌려나감

			now = target;
			nowdir = (-1) * dir;
			while (right < 4) {

				if (nowdir == 1 && data[right].get(6) != data[now].get(1)) {
					char temp = data[right].get(data[right].size() - 1);
					data[right].remove(data[right].size() - 1);
					data[right].add(0, temp);
					now = right;
					right++;
					nowdir = (-1) * nowdir;
				} else if (nowdir == -1 && data[right].get(6) != data[now].get(3)) {
					char temp = data[right].get(0);
					data[right].remove(0);
					data[right].add(temp);
					now = right;
					right++;
					nowdir = (-1) * nowdir;
				} else
					break;
			} // 나머지 오른쪽바퀴를 돌려나감
		}
		if (data[0].get(0) == '1')
			result += 1;
		if (data[1].get(0) == '1')
			result += 2;
		if (data[2].get(0) == '1')
			result += 4;
		if (data[3].get(0) == '1')
			result += 8;

		System.out.println(result);
	}

}
