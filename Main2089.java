import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 		Baekjoon Online Judge 2089번 - -2진수
 * 
 * 		https://www.acmicpc.net/problem/2089
 * 
 */

public class Main2089 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		if (n == 0) {
			System.out.println(0);
			return;
		}

		while (true) {
			if (n > 0) {
				sb.append(n % (-2)); // n이 양수일 경우 n을 -2로 나누었을때 나머지는 0,1 이므로 최종 출력에 더해준다.
				n /= (-2);
			} else if (n < 0) {
				if (n % (-2) == -1) { // n이 음수일 경우 나머지가 -1이 나올수 있으므로 몫에 1을더해 나머지를 1로 만든다.
					n /= (-2);
					sb.append(1);
					n++;
				} else {
					sb.append(n % (-2)); // 나머지가 0인경우이므로 더해준다.
					n /= (-2);
				}
			} else {
				break;
			}

		}
		int length = sb.length();

		for (int i = length - 1; i >= 0; i--) {
			System.out.print(sb.charAt(i));
		}

	}

}
