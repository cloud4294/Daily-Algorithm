import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Baekjoon Online Judge 6378번 - 디지털 루트
 * 
 * 양의 정수 N의 디지털 루트를 구하려면 N을 이루고 있는 모든 자리수를 더해야 한다. 이때, 더한 값이 한 자리 숫자라면, 그 수가 N의 디지털 루트가 된다. 두 자리 이상 숫자인 경우에는 다시 그 수를 이루고 있는 모든 자리수를 더해야 하며, 한 자리 숫자가 될 때 까지 반복한다.
 * 24의 디지털 루트를 구해보자. 2+4=6이다. 6은 한 자리 숫자이기 때문에, 24의 디지털 루트는 6이 된다. 39의 경우에는 3+9=12이기 때문에, 한 번 더 더해야 한다. 따라서, 1+2=3이 디지털 루트가 된다.
 * 양의 정수 N이 주어졌을 때, 그 수의 디지털 루트를 구하는 프로그램을 작성하시오.
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
