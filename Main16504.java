import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	  Baekjoon Online Judge 16504번 - 종이접기
 *  
 *    https://www.acmicpc.net/problem/16504
 * 
 */

public class Main16504 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				sum += Integer.parseInt(input[j]);
			}
		} //종이를 모두접으면 마지막에 남는수는 총합과 같다.
		
		System.out.println(sum);
	}

}
