import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Baekjoon Online Judge 6378�� - ������ ��Ʈ
 * 
 * ���� ���� N�� ������ ��Ʈ�� ���Ϸ��� N�� �̷�� �ִ� ��� �ڸ����� ���ؾ� �Ѵ�. �̶�, ���� ���� �� �ڸ� ���ڶ��, �� ���� N�� ������ ��Ʈ�� �ȴ�. �� �ڸ� �̻� ������ ��쿡�� �ٽ� �� ���� �̷�� �ִ� ��� �ڸ����� ���ؾ� �ϸ�, �� �ڸ� ���ڰ� �� �� ���� �ݺ��Ѵ�.
 * 24�� ������ ��Ʈ�� ���غ���. 2+4=6�̴�. 6�� �� �ڸ� �����̱� ������, 24�� ������ ��Ʈ�� 6�� �ȴ�. 39�� ��쿡�� 3+9=12�̱� ������, �� �� �� ���ؾ� �Ѵ�. ����, 1+2=3�� ������ ��Ʈ�� �ȴ�.
 * ���� ���� N�� �־����� ��, �� ���� ������ ��Ʈ�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 */



public class Main6378 {

	public static String solve(String input) {
		long sum = 0;
		for (int i = 0; i < input.length(); i++) {
			sum += Integer.parseInt(input.substring(i, i+1));
		}
		if(sum >= 10) {
			return solve(Long.toString(sum));
		}else {
			return Long.toString(sum);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		ArrayList<String> output = new ArrayList<String>();
		while (!input.equals("0")) {
			
			output.add(solve(input));
			input = br.readLine();
		}
		for(String out:output)
			System.out.println(out);

	}

}
