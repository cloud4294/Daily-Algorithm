import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * 		Baekjoon Online Judge 7785�� - ȸ�翡 �ִ� ���
 * 
 * 		https://www.acmicpc.net/problem/7785
 */

public class Main7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String[] data = br.readLine().split(" ");
			if(data[1].equals("enter")) {
				set.add(data[0]);
			}else {
				set.remove(data[0]);
			}
		} // set�� ������ �߰� ������ ���� 
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder()); // set�� ����Ʈ�� �ٲ㼭 ���� ����
		
		for(String str: list) {
			System.out.println(str);
		}
		
	}

}
