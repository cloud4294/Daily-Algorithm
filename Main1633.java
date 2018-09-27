import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 1633�� - �ְ��� �������
 * 
 * ���� 
 * �� ��ȸ�� �ų� ����ü����ȸ�� ���� ���� ����� �ִ�. ���� ������ �÷����ϴ� 15��� ������ �÷����ϴ� 15��, �� 30������ �̷������. �� ��ȸ�� ������ �ְ��� ���� ������� �ϴµ� �� �÷��̾��� ��,�� �ɷ�ġ�� ���� 1���� 100������ ������ �־�����. ��ȸ�� ����Ǵ� ���� �÷��̾�� ��, �� �� �� ���������� ������ �ؾ��ϸ� ���� ��ü �ɷ�ġ�� �� �÷��̾��� �ɷ�ġ�� ���ѰͰ� �� �÷��̾��� �ɷ�ġ�� ���Ѱ��� ��� ���� ���̴�. ��� �ϸ� �� ��ȸ�� ������ ���� �ɷ�ġ�� ���� ����� ������.
 * 
 * �Է� 
 * �Է��� �� �÷��̾���� �ɷ�ġ�� �̷������. �� ���� �������� ���еǴ� �� ���� ������ �־�����. ù ��° ���ڴ� �ش� �÷��̾ ������ �÷��̸� �� �� �ɷ�ġ�� �� ��° ���ڴ� ������ �÷��̸� �� ���� �ɷ�ġ��. �ּ��� 30�� �̻��̸� 1000���� ���� �ʴ´�.
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
