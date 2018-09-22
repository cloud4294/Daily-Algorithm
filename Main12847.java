import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 12847번 - 꿀아르바이트
 * 
 * 윤호는 퍼주기로 유명한 편의점 사장이다. 그의 편의점에는 특이한 임금 체계를 가지고 있다.
 * 각 날마다 일의 차이때문에 일마다 급여가 정해져 있다.
 * 윤호는  오차 없이 일급을 따박 따박 당일에 준다.
 * 정해진 일 수 만큼만 일을 시킨다.
 * 한번이라도 퇴직한 자를 다시 취직 시키지 않는다. (만약 취직을 한다면, 일을 시작 한 날부터 끝날 때까지 하루도 빠지면 안된다.)
 * 무서운 아르바이트를 짤린 준수는 n+1일 후에 001에 월세를 내야 해서 윤호가 사장으로 있는 편의점에 취직하려 한다. 다행히 주변 퇴직자들의 얘기로 급여에 관련해 파악했다. 또한 퇴직자들의 급여 통계를 통해 당장 n일 후까지 일급 정보를 알아냈다. 하지만 준수는 시험을 준비해야 하기에 최대 m일 밖에 일을 할 수 없다.
 * 어제까지 과제를 제출하고 지금도 001에서 자고 있는 준수를 위해 코딩 잘하는 여러분이 일을 해서 벌 수 있는 최대 이익을 준수에게 또 알려주도록 하자.
 * 
 */


public class Main12847 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		long[] data = new long[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		long cost = 0;
		for (int i = 0; i < m; i++) {
			cost += data[i];
		} // m일 연속으로 일하기 때문에 초기값은 첫날 부터 m일까지 합으로 한다.
		long max = cost;
		for (int i = 0; i < n - m; i++) {
			cost = cost + data[m + i] - data[i]; // 다이나믹 프로그래밍. 하루씩 밀려나면서 최대값을 비교 한다.
			if(cost > max)
				max = cost;
		}

		System.out.println(max);

	}

}
