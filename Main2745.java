import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Baekjoon Online Judge 2745번 - 진법 변환 
 * 
 * 	https://www.acmicpc.net/problem/2745
 * 
 */


public class Main2745 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String data = input[0];
		int num = Integer.parseInt(input[1]);
		int result = 0;
		int length = input[0].length();

		for (int i = 0; i < length; i++) {

			if (data.charAt(i) >= 'A' && data.charAt(i) <= 'Z') {
				result = result * num + data.charAt(i) - ('A' - 10);
				
			} else {
				int current = Integer.parseInt(data.substring(i, i + 1));
				result = result * num + current;
			}
		}

		System.out.println(result);

	}

}
