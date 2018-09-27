import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

/*
 * 
 * Baekjoon Online Judge 1793번 - 타일링
 * 
 * 문제 
 * 2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 아래 그림은 2×17 직사각형을 채운 한가지 예이다.
 * 
 * 입력 
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 숫자 0 ≤ n ≤ 250이 주어진다. 
 * 
 * 출력 
 * 입력으로 주어지는 각각의 n마다, 2×n 직사각형을 채우는 방법의 수를 출력한다.
 * 
 * 
 */


public class Main1793 {

	static BigInteger[] data;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		ArrayList<BigInteger> output = new ArrayList<BigInteger>();
		while ((input = br.readLine()) != null) { // 더이상 입력이 없을때 까지 반복한다.

			int n = Integer.parseInt(input);
			data = new BigInteger[n + 1]; // 출력값이 long의 범위를 넘어가기 때문에 BigInteger 클래스를 사용한다.

			data[0] = BigInteger.ONE;
			if (n > 0) {
				data[1] = BigInteger.ONE;
			}

			int togle = 1;
			for (int i = 2; i <= n; i++) {
				if(data[i] == null) {
					data[i] = data[i - 1].multiply(BigInteger.valueOf(2));
					if (togle == 1) {
						data[i] = data[i].add(BigInteger.ONE);
						togle = -1;
					} else if (togle == -1) {
						data[i] = data[i].subtract(BigInteger.ONE);
						togle = 1;
					}
				}
			} // 규칙을 찾아 다이나믹 프로그래밍을 시행한다. 

			output.add(data[n]);
		}
		for (int i = 0; i < output.size(); i++) {
			bw.write(output.get(i).toString()+"\n");
		}
		bw.flush();
		bw.close();
	}

}
