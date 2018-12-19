import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 		Baekjoon Online Judge 6603번 - 로또 
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
		} // 6개의 숫자가 선택되면 출력
		
		for (int i = 1; i < length; i++) {
			if(!list.contains(data[i])) {
				int next = Integer.parseInt(data[i]);
				if(next > max) {
					list.add(data[i]);
					solve(n+1,list,next);
					list.remove(data[i]);
				}
			}
		}// 리스트에 현재값이 없고,리스트의 숫자중 가장 큰 수보다 현재값이 크면 리스트에 넣음, 모든 수에 대해 탐색 
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
