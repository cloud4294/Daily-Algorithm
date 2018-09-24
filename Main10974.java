import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Baekjoon Online Judge 10974�� - ��� ����
 * 
 * N�� �־����� ��, 1���� N������ ���� �̷���� ������ ���������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
