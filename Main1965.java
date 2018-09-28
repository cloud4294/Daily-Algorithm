import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 *  Baekjoon Online Judge 1965�� - ���ڳֱ�
 * 
 * ���� 
 * ������ü ����� ���ڵ��� �Ϸķ� �þ �ִ�. ���ڵ鸶�� ũ�Ⱑ �־��� �ִµ�, �տ� �ִ� ������ ũ�Ⱑ �ڿ� �ִ� ������ ũ�⺸�� ������, �տ� �ִ� ���ڸ� �ڿ� �ִ� ���� �ȿ� ���� ���� �ִ�. ���� ��� �տ������� ������� ũ�Ⱑ (1, 5, 2, 3, 7)�� 5���� ���ڰ� �ִٸ�, ũ�� 1�� ���ڸ� ũ�� 5�� ���ڿ� �ְ�, �ٽ� �� ���ڵ��� ũ�� 7�� ���� �ȿ� ���� �� �ִ�. ������ �̷��� ���ڸ� ���� �� �ִ� ����� ���� ������ ���� �� �ִ�. ���� ������ ���ʴ�� ũ�Ⱑ 1, 2, 3, 7�� ���ڵ��� �����ϸ� �� 4���� ���ڰ� �� ���� ���ڿ� ���� �ȴ�.
 * ���ڵ��� ũ�Ⱑ �־��� ��, �� ���� ���� �� �ִ� �ִ��� ���� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� 
 * ������ ù ��° ���� ������ ���� n (1��n ��1000)�� ��Ÿ����. �� ��° �ٿ��� �� ���ڵ��� ũ�Ⱑ ������� �־�����.
 * 
 * ��� 
 * ù° �ٿ� �� �ٿ� ���� �� �ִ� �ִ��� ���� ������ ����Ѵ�.
 * 
 */



public class Main1965 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] data = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;	// �� ���ڴ� �ڽ��� �����Ͽ� �ּ� 1���� ���ڸ� ���� ���ִ�.
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(data[i] > data[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}// ���̳��� ���α׷���, ������� ũ�⺸�� ���� ���� �����߿��� ���ڸ� �������ִ� ������ ���Ͽ� ū ���� �����Ѵ�.
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			if(dp[i] > max)
				max = dp[i];
		}// �ִ밪�� ��󳻰� ����Ѵ�.
		
		System.out.println(max);
	}
}
