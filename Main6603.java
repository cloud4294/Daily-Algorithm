import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 		Baekjoon Online Judge 6603�� - �ζ� 
 * 
 * 		https://www.acmicpc.net/problem/6603
 * 
 */


public class Main6603 {
	
	static String[] data;
	static int length;
	
	public static void solve(int n, List<String> list,int max) {
		
		if(n == 6) {
			for(String out:list) {
				System.out.print(out+" ");
			}
			System.out.println();
			return;
		} // 6���� ���ڰ� ���õǸ� ���
		
		for (int i = 1; i < length; i++) {
			if(!list.contains(data[i])) {
				int next = Integer.parseInt(data[i]);
				if(next > max) {
					list.add(data[i]);
					solve(n+1,list,next);
					list.remove(data[i]);
				}
			}
		}// ����Ʈ�� ���簪�� ����,����Ʈ�� ������ ���� ū ������ ���簪�� ũ�� ����Ʈ�� ����, ��� ���� ���� Ž�� 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			data = br.readLine().split(" ");
			length = data.length;
			if(data[0].equals("0")) {
				return;
			}else {
				
				solve(0,new ArrayList<String>(),0);			
				System.out.println();
			}
			
			
			
		}

	}

}
