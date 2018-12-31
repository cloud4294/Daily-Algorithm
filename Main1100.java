import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 		Baekjoon Online Judge 1100╧Ь - го╬А д╜
 * 
 * 		https://www.acmicpc.net/problem/1100
 */

public class Main1100 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		int t = 0;
		int count = 0;
		for (int i = 0; i < 8; i++) {
			input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				if(j % 2 == t && input.charAt(j) == 'F') {
					count++;
				}
			}
			if(t == 0)
				t++;
			else 
				t--;
		}
		
		

		System.out.println(count);
	}

}
