import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Baekjoon Online Judge 11005번 - 진법 변환 2
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
			
		} // div 진법으로 바꾸기 위해서 num을 div로 나눈 나머지를 역순으로 출력하면 num을 div진법으로 변환할수 있다
		
		int length = ans.length() - 1;
		for (int i = length; i >= 0; i--) {
			System.out.print(ans.charAt(i));
		}
		
	}

}
