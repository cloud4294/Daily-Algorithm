import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  Baekjoon Online Judge 6588¹ø - °ñµå¹ÙÈåÀÇ ÃßÃø	
 * 
 *  https://www.acmicpc.net/problem/11653
 *  
 */

public class Main11653 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 2; i * i <= N; i++) {
			while(N % i == 0) {
				System.out.println(i);
				N /= i;
			}
		}
		if( N > 1)
			System.out.println(N);
		
	}

}
