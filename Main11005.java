import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Baekjoon Online Judge 11005�� - ���� ��ȯ 2
 * 
 *  https://www.acmicpc.net/problem/11005
 *  
 */

public class Main11005 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int num = Integer.parseInt(input[0]);
		int div = Integer.parseInt(input[1]);
		String ans ="";
		
		while(num > 0) {
			
			int current = num % div; 
			
			if(current >= 10 && current <= 36) {
				char temp = (char) ('A' - 10 + current);
				ans += temp;
			}else if(current < 10) {
				ans += Integer.toString(current);
			}
			
			num /= div;
			
		} // div �������� �ٲٱ� ���ؼ� num�� div�� ���� �������� �������� ����ϸ� num�� div�������� ��ȯ�Ҽ� �ִ�
		
		int length = ans.length() - 1;
		for (int i = length; i >= 0; i--) {
			System.out.print(ans.charAt(i));
		}
		
	}

}
