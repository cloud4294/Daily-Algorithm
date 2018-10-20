import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 *   Baekjoon Online Judge 13458번 - 시험 감독
 * 
 *   https://www.acmicpc.net/problem/13458
 * 
 */

public class Main13458 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split(" ");
		int B = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		
		long count = 0;
		for (int i = 0; i < N; i++) {
			if(A[i] <= B) // 총감독관이 감시할 수 있는 응시자 수가 해당 시험장의 응시자 수보다 많으면 감독관수에 1을 더함
				count++;
			else {
				int temp = A[i] - B; // 총감독관의 감시인원을 제외하고
				if(temp % C == 0) { // 전체 인원에서 부감독관당 감시인원의 수를 나눠준다
					count += temp / C + 1;
				}else {
					count += temp / C + 2;
				}
				
			}
		}
		
		System.out.println(count);
		
		
	}

}
