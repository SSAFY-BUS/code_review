package SWEA_1952_������;
/**
  	���� �˰���
  		���� ���α׷���(DP)
 
	�޸�
		24,372 KB
	����ð�
		149 ms
	
	
 */

import java.util.Scanner;

public class Solution_������ {
	static int answer;
	static int[] fare;
	static int[] month;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_caee=1;test_caee<=T;test_caee++) {
			fare=new int[4];
			month=new int[12];
			for(int i=0;i<4;i++) {
				fare[i]=sc.nextInt();
			}
			answer=fare[3];
			for(int i=0;i<12;i++) {
				month[i]=sc.nextInt();
			}
			go(0,0);
			
			System.out.println("#"+test_caee+" "+answer);
		}
	}
	
	public static void go(int index , int money) {
		if(index>=12) {
			answer=Math.min(money, answer);
			return;
		}
		if(month[index]==0) {
			go(index+1,money);
			return;
		}
		if(money>answer) {
			return;
		}
		
		go(index+1,money+(fare[0]*month[index]));
		go(index+1,money+fare[1]);
		go(index+3,money+fare[2]);
		
		
		
	}
}

