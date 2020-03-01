package BaekJoon_1633_최고의팀만들기;
/**
	적용 알고리즘
		동적 프로그래밍(DP)
			- 점화식과 메모이제이션 기법을 사용함.
			- 시간 제한 내 구현을 위해 여러 백트래킹 기법이 필요로 했음.
			 	if((black>0||white>0)&&memo[black][white][index]>=sum) {
					return;
				}
				여기서 memo[black][white][index]>sum 이것만 쓰면 시간이 초과가 되고,
				memo[black][white][index]>=sum를 하면 오답이 나와서
				(black>0||white>0)&&memo[black][white][index]>=sum 조건을 두니 제한 시간 내 정답이 나옴.
	
	메모리
		18,736 KB
	실행 시간
		480 ms
		
	기타 사항
		- 실행 시, 입력 버퍼에 EOF(End Of File)임을 알려주기 위해 마지막 행에 Ctrl+z를 입력해야 EOF를 인식함.
		
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main_박형민 {
	static ArrayList<Player> list;
	static int answer;
	static int[][][] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<Player>();
		answer=0;
		while(sc.hasNextInt()) {
			int white = sc.nextInt();
			int black = sc.nextInt();
			list.add(new Player(white, black));
		}
		
		memo= new int[16][16][list.size()];
		cal(0,0,0,0);
		System.out.println(answer);
		
	}
	static void cal(int index,int black,int white,int sum) {
		if(black==15&&white==15) {
			answer=Math.max(answer, sum);
			return;
		}
		if(index>=list.size()||black>15||white>15) {
			return ;
		}
		if((black>0||white>0)&&memo[black][white][index]>=sum) {
			return;
		}
		memo[black][white][index]=sum;
		if(black<15) {
			cal(index+1,black+1,white,sum+list.get(index).black);
		}
		if(white<15) {
			cal(index+1,black,white+1,sum+list.get(index).white);
		}
		if(list.size()-index > 30-(black+white)) {
			cal(index+1,black,white,sum);
		}
	}

}

class Player{
	int white;
	int black;
	Player(int white,int black){
		this.white=white;
		this.black=black;
	}
}
