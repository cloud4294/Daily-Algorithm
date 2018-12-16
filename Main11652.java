import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 		Baekjoon Online Judge 11652�� - ī��
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
				if(count + 1 > max) { // �ִ�Ƚ���� ����, �ִ�Ƚ���� �������� key������ ����
					key = now;
					max = count + 1; 
				}else if(count + 1 == max && now < key) {// �ִ�Ƚ���� ���� ��� ������ ���� key������ ����
					key = now;
				} 
			}else {
				map.put(now, 1);
				if(max == 1 && now < key) {
					key = now;
				}
			}
		}// hashmap�� �̿��Ͽ� key�� ��, value�� countȽ���� ���� 
		
		System.out.println(key);
	}

}
