import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Baekjoon Online Judge 10974번 - 모든 순열
 * 
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 * 
 */


public class Main10974 {

	static int N;
	
	public static void solve(ArrayList<Integer> data,ArrayList<Integer> output) {
		
		if(output.size() == N) {
			for(int k:output)
				System.out.print(k +" ");
			System.out.println();
		}
		for (int i = 0; i < N; i++) {
			if(!output.contains(data.get(i))) {
				output.add(data.get(i));
				solve(data,output);
				output.remove(data.get(i));
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> data = new ArrayList<Integer>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			data.add(i);
		}
		
		solve(data,output);
		
	}

}
