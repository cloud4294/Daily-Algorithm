import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * Baekjoon Online Judge 2503번 - 숫자 야구
 * 
 * 정보문화진흥원 정보 영재 동아리에서 동아리 활동을 하던 영수와 민혁이는 쉬는 시간을 틈타 숫자야구 게임을 하기로 했다.
 * 영수는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 마음속으로 생각한다. (예: 324)
 * 민혁이는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 영수에게 묻는다. (예: 123)
 * 민혁이가 말한 세 자리 수에 있는 숫자들 중 하나가 영수의 세 자리 수의 동일한 자리에 위치하면 스트라이크 한 번으로 센다. 숫자가 영수의 세 자리 수에 있긴 하나 다른 자리에 위치하면 볼 한 번으로 센다.
 * 예) 영수가 324를 갖고 있으면 
 * 429는 1 스트라이크 1 볼이다.
 * 241은 0 스트라이크 2 볼이다.
 * 924는 2 스트라이크 0 볼이다.
 * 영수는 민혁이가 말한 수가 몇 스트라이크 몇 볼인지를 답해준다.
 * 민혁이가 영수의 세 자리 수를 정확하게 맞추어 3 스트라이크가 되면 게임이 끝난다. 아니라면 민혁이는 새로운 수를 생각해 다시 영수에게 묻는다.
 * 현재 민혁이와 영수는 게임을 하고 있는 도중에 있다. 민혁이가 영수에게 어떤 수들을 물어보았는지, 그리고 각각의 물음에 영수가 어떤 대답을 했는지가 입력으로 주어진다. 이 입력을 바탕으로 여러분은 영수가 생각하고 있을 가능성이 있는 수가 총 몇 개인지를 알아맞혀야 한다.
 * 아래와 같은 경우를 생각해보자.  
 * 민혁: 123
 * 영수: 1 스트라이크 1 볼.
 * 민혁: 356
 * 영수: 1 스트라이크 0 볼.
 * 민혁: 327
 * 영수: 2 스트라이크 0 볼.
 * 민혁: 489
 * 영수: 0 스트라이크 1 볼.
 * 이때 가능한 답은 324와 328, 이렇게 두 가지이다.
 * 영수는 동아리의 규율을 잘 따르는 착한 아이라 민혁이의 물음에 곧이곧대로 정직하게 답한다. 그러므로 영수의 답들에는 모순이 없다.
 * 민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 프로그램을 작성하시오.
 * 
 * 
 * 
 */



public class Main2503 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] data = new String[N];
		int[] strike = new int[N];
		int[] ball = new int[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			data[i] = input[0];
			strike[i] = Integer.parseInt(input[1]);
			ball[i] = Integer.parseInt(input[2]);
		}
		int count = 0;

		for (int i = 123; i <= 987; i++) { // 브루트 포스, 123부터 987까지 경우의 수와 입력받은 값 비교
			String current = Integer.toString(i);
			int check = 0;
			if (current.charAt(1) == '0' || current.charAt(2) == '0' || current.charAt(0) == current.charAt(1)
					|| current.charAt(1) == current.charAt(2) || current.charAt(0) == current.charAt(2)) // 0이 포함된 값과 각자리에 중복된 값이 있을 경우 제외 
				continue;
			else {
				for (int j = 0; j < N; j++) {
					int countstrike = 0;
					int countball = 0;
					for (int j2 = 0; j2 < data[j].length(); j2++) {
						if (data[j].charAt(j2) == current.charAt(j2))
							countstrike++;
						else if (data[j].contains(current.substring(j2, j2 + 1)))
							countball++;	
					}
					if (countstrike == strike[j] && countball == ball[j])
						check++; // 입력받은 값과 비교하여 strike와 ball의 갯수가 일치하는지 확인
				}
			}

			if (check == N) {
				count++; // N개의 입력값과 strike, ball 갯수가 모두 일치하면 최종 경우의수 1증가
			}

		}

		System.out.println(count);

	}

}
