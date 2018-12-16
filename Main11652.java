import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 		Baekjoon Online Judge 11652번 - 카드
 * 
 * 		https://www.acmicpc.net/problem/11652
 */


public class Main11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> map = new HashMap<>();
		
		int max = 1;
		long key = 0;
		for (int i = 0; i < N; i++) {
			long now = Long.parseLong(br.readLine());
			if(key == 0) {
				key = now;
			}
			
			if(map.containsKey(now)) {
				int count = map.get(now).intValue();
				map.replace(now,count,count + 1);
				if(count + 1 > max) { // 최대횟수를 갱신, 최대횟수를 가진수를 key변수로 갱신
					key = now;
					max = count + 1; 
				}else if(count + 1 == max && now < key) {// 최대횟수가 같을 경우 더작은 값을 key변수로 갱신
					key = now;
				} 
			}else {
				map.put(now, 1);
				if(max == 1 && now < key) {
					key = now;
				}
			}
		}// hashmap을 이용하여 key에 값, value에 count횟수를 넣음 
		
		System.out.println(key);
	}

}
