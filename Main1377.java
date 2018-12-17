import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
 * 		Baekjoon Online Judge 1377번 - 버블 소트
 * 
 * 		https://www.acmicpc.net/problem/1377
 * 
 */


public class Main1377 {

	static class pair {
		int index;
		int value;

		pair(int index, int value) {
			this.index = index;
			this.value = value;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<pair> list = new ArrayList<pair>();
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			list.add(new pair(i, now));
		}//인덱스, 값을 가지는 리스트 생성

		Collections.sort(list, new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				if (o1.value > o2.value)
					return 1;
				else if (o1.value == o2.value)
					return 0;
				else
					return -1;

			}

		}); //값을 기준으로 정렬 

		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			if(ans < list.get(i).index - i)
				ans = list.get(i).index - i;
		} // 가장많이 당겨진 인덱스의 차를 구함 

		System.out.println(ans + 1);
	}

}
