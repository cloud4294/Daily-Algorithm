import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 		Baekjoon Online Judge 6588�� - �������� ����
 * 
 * 		https://www.acmicpc.net/problem/6588
 * 
 */


public class Main6588 {
	
	static int max = 1000001;
	static int[] check = new int[max];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> output = new ArrayList<String>();
		check[1] = 1;
		for (int i = 1; i * i < max; i++) {
			
			if(check[i] == 0) {
				for (int j = i * 2; j < max; j += i) {
					check[j] = 1;
				}
			}
		} // �������׳׽��� ü�� �����Ͽ� �Ҽ� �Ǻ�
		
		
		int T = Integer.parseInt(br.readLine());
		
		
		while(T != 0) {
			boolean flag = false;
			for (int i = 3; i <= T / 2; i+=2) {
				if(check[i] == 0 && check[T - i] ==0) { // �μ��� ���� �Ҽ��̸� ��¿� �߰��Ѵ�.
					flag = true;
					output.add(T + " = " + i + " + " +(T - i));
					break;
				}
			}
			
			if(flag == false)
				output.add("Goldbach's conjecture is wrong.");
			
			T = Integer.parseInt(br.readLine());		
		}
			
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
			
		
		
		
	}

}
