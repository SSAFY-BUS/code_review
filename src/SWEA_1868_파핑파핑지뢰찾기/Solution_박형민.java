package SWEA_1868_파핑파핑지뢰찾기;
/**
적용 알고리즘
	시뮬레이션
	BFS

메모리
	64,456 KB

실행시간
	229 ms


*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_박형민 {
	static int N;
	static int[][] map;
	static boolean[][] b;
	static int answer;
	static int[] dR = {-1,-1,-1,0,1,1,1,0};
	static int[] dC = {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int test_case = 1; test_case<=TC; test_case++) {
			N = sc.nextInt();
			answer = N*N;
			map = new int[N][N];
			b = new boolean[N][N];
			for(int i=0;i<N;i++) {
				String s = sc.next();
				for(int j=0; j<N;j++) {
					if(s.charAt(j)=='*') {
						int nr,nc;
						for(int k=0;k<8;k++) {
							nr=i+dR[k];
							nc=j+dC[k];
							if(nr<0||nc<0||nr>=N||nc>=N) {
								continue;
							}
							if(map[nr][nc]!=-1) {
								map[nr][nc]++;
							}
						}
						map[i][j]=-1;
						answer--;
					}

				}

			}
			countZeroArea();
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static void countZeroArea() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0&&!b[i][j]) {
					b[i][j]=true;
					union(i,j);
				}
			}
		}
	}
	static void union(int r, int c) {
		int nr,nc,tr,tc;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(r);
		q.add(c);
		while(!q.isEmpty()) {
			tr=q.poll();
			tc=q.poll();
			for(int i=0;i<8;i++) {
				nr=tr+dR[i];
				nc=tc+dC[i];
				if(nr<0||nc<0||nr>=N||nc>=N) {
					continue;
				}
				if(map[nr][nc]==0&&!b[nr][nc]) {
					answer--;
					b[nr][nc]=true;
					q.add(nr);
					q.add(nc);
				}else if(map[nr][nc]>0&&!b[nr][nc]) {
					b[nr][nc]=true;
					answer--;
				}
			}
		}
	}

}

