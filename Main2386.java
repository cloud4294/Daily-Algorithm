import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *    Baekjoon Online Judge 2698번 - 인접한 비트의 개수
 * 
 * 	  https://www.acmicpc.net/problem/2386	
 * 
 */


public class Main2386 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			String[] input = br.readLine().split(" ");

			if (input[0].equals("#"))
				return; // 첫번째 문자가 #이면 종료
			else {
				char alpha = input[0].toUpperCase().charAt(0);
				int count = 0;
				for (int i = 1; i < input.length; i++) {
					input[i] = input[i].toUpperCase();
					for (int j = 0; j < input[i].length(); j++) {
						if (input[i].charAt(j) == alpha)
							count++;
					}
				}
				System.out.println(input[0] + " " + count);

			} // 입력받은 값을 모두 대문자로 바꾼뒤 선형 비교한다. 

		}

	}

}
