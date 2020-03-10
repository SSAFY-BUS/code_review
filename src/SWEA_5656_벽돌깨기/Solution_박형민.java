package SWEA_5656_벽돌깨기;
/**
	적용 알고리즘
		DFS

메모리
	64,136 KB

실행시간
	260 ms


*/

import java.util.Scanner;

public class Solution_박형민 {
	static int N,W,H;
	static int[][] map;
	static int answer;
	static int[] dR = {-1,1,0,0};
	static int[] dC = {0,0,-1,1};
	static int pos;
	static int remain;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			answer = Integer.MAX_VALUE;
			remain=0;
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]>0) {
						remain++;
					}
				}
			}
			cal(0);
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static void cal(int cnt) {

		if(cnt==N||remain==0) {
			answer = Math.min(answer, remain);
			return;
		}
		for(int i=0;i<W;i++) {
			int r = collide(i);
			if(r!=-1) {
				int tempRemain = remain;
				int[][] temp_map = new int[H][W];
				for(int j=0;j<H;j++) {
					temp_map[j]=map[j].clone();
				}
				bombBlock(r,i);
				down();
				cal(cnt+1);
				map = temp_map;
				remain=tempRemain;
			}
		}
	}

	static int collide(int index) {
		for(int i=0;i<H;i++) {
			if(map[i][index]>0) {
				return i;
			}
		}
		return -1;
	}



	static void bombBlock(int r, int c) {
		if(map[r][c]==0) {
			return ;
		}
		int nr,nc,val;
		val = map[r][c]-1;
		map[r][c]=0;
		remain--;
		for(int i=1;i<=val;i++) {
			for(int j=0;j<4;j++) {
				nr=r+dR[j]*i;
				nc=c+dC[j]*i;
				if(nr<0||nc<0||nr>=H||nc>=W) {
					continue;
				}
				bombBlock(nr, nc);
			}
		}
	}

	static void down() {
		for(int j=0;j<W;j++) {
			int r = H;
			for(int i=H-1;i>=0;i--) {
				if(map[i][j]!=0) {
					 r--;
	                 map[r][j] = map[i][j];
	                 if(i!=r) {
	                	 map[i][j] = 0;
	                 }
				}
			}
		}
	}




}


