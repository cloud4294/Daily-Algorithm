import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Baekjoon Online Judge 2011�� - ��ȣ�ڵ� 
 * 
 * 	https://www.acmicpc.net/problem/2011
 * 
 */


public class Main2011 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int length = num.length();

		int[] data = new int[length + 1];
		for (int i = 0; i < length; i++) {
			data[i+1] = Integer.parseInt(num.substring(i, i + 1));
		}
		int[] dp = new int[length + 1];
		int mod = 1000000;
		dp[0] = 1;

		for (int i = 1; i <= length; i++) {

			if (data[i] >= 1 && data[i] <= 9) //���� ���� 1 ~ 9 ���̶�� ���� �ڸ��� ����� ���� �ջ�
				dp[i] = (dp[i] + dp[i - 1]) % mod; 

			if(i== 1) 
				continue; // ���� ���� ù��° �ڸ���� ���� �ڸ��� ����� �� �����Ƿ� �Ѿ
			if (data[i - 1] == 0) // ���� ���� 0�̶�� 10�̻��� ���ĺ��� ����Ҽ� �����Ƿ� �Ѿ
				continue;
			if (data[i - 1] * 10 + data[i] <= 26) //���� ���� ���簪�� ���Ͽ� 26������ ���� �ȴٸ� �����ڸ��� ����� ���� �ջ�
				dp[i] = (dp[i] + dp[i - 2]) % mod;

		}

		System.out.println(dp[length] % mod);

	}

}
