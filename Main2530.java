import java.util.Scanner;

/*
 *    Baekjoon Online Judge 2530�� - �ΰ����� �ð�
 * 
 *    https://www.acmicpc.net/problem/2530
 */

public class Main2530 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int time = sc.nextInt();
		
		int ah = (time / 3600) % 24; // 24�ð��� �Ѱ� ���ϴ� ��쵵 �ֱ� ������ 24�γ��� �������� ����
		time = time % 3600;
		int am = time / 60;
		time = time % 60;
		int as = time ;
		
		if(s + as >= 60) {
			am++;
			s = s + as - 60;
		}else {
			s += as;
		} // �ʴ����� ����Ͽ� 60���̻��̸� �д����� �ø�
		
		if(m + am >= 60) {
			ah++;
			m = m + am - 60;
		}else {
			m += am;
		} // �д��� ���
		
		if(h + ah >= 24) {
			
			h = h + ah - 24;
		}else {
			h += ah;
		} //�ð� ���� ���
		
		System.out.println(h +" "+ m +" "+ s);

	}

}
