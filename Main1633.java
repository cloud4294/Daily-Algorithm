import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 1633번 - 최고의 팀만들기
 * 
 * 문제 
 * 꿍 협회는 매년 세계체스대회에 나갈 팀을 만들고 있다. 팀은 흑으로 플레이하는 15명과 백으로 플레이하는 15명, 총 30명으로 이루어진다. 꿍 협회는 가능한 최고의 팀을 만들려고 하는데 각 플레이어의 흑,백 능력치는 각각 1부터 100까지의 정수로 주어진다. 대회가 진행되는 동안 플레이어는 흑, 백 중 한 가지만으로 참여를 해야하며 팀의 전체 능력치는 흑 플레이어의 능력치를 합한것과 백 플레이어의 능력치를 합한것을 모두 더한 값이다. 어떻게 하면 꿍 협회는 가능한 높은 능력치의 팀을 만들수 있을까.
 * 
 * 입력 
 * 입력은 각 플레이어들의 능력치로 이루어진다. 각 줄은 공백으로 구분되는 두 개의 정수로 주어진다. 첫 번째 숫자는 해당 플레이어가 백으로 플레이를 할 때 능력치고 두 번째 숫자는 흑으로 플레이를 할 때의 능력치다. 최소한 30줄 이상이며 1000줄은 넘지 않는다.
 * 
 */


public class Main1633 {

	static int[] white = new int[1001];
	static int[] black = new int[1001];
	static int[][][] dp = new int[1001][16][16];
	static int index = 0;

	static int solve(int w, int b, int now) {

		if (now == index)
			return 0;

		if (dp[now][w][b] != 0)
			return dp[now][w][b];

		if (w > 0)
			dp[now][w][b] = Integer.max(dp[now][w][b], solve(w - 1, b, now + 1) + white[now]);	

		if (b > 0)
			dp[now][w][b] = Integer.max(dp[now][w][b], solve(w, b - 1, now + 1) + black[now]); 

		dp[now][w][b] = Integer.max(dp[now][w][b], solve(w, b, now + 1));

		return dp[now][w][b];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = 0;

		while (input != null) {
			String[] data = input.split(" ");
			white[count] = Integer.parseInt(data[0]);
			black[count++] = Integer.parseInt(data[1]);
			input = br.readLine();
		}
		index = count;

		System.out.println(solve(15, 15, 0));

	}

}
