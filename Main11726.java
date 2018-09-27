import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 11726번 - 2xn 타일링
 * 
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 * 
 * 입력 
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 * 
 * 출력 
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 * 
 * 
 * 
 */

public class Main11726 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n + 1];

		data[0] = 1;
		data[1] = 1;

		for (int i = 2; i <= n; i++) {
			data[i] = (data[i - 1] + data[i - 2]) % 10007;
		} // 패턴을 발견하고 dp로 만들어 계산

		System.out.println(data[n]);

	}

}
