package SWEA_1868_파핑파핑지뢰찾기;

/**
 * 적용 알고리즘
 * 		BFS
 * 
 * 메모리
 * 		45,356 kb
 * 
 * 실행시간
 * 		177 ms
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_이근화 {
	
	private static class Pair {
		
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int N;
	private static int cntClick;
	private static char[][] map;
	private static boolean[][] visited;
	private static Queue<Pair> q;
	
	private static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			cntClick = 0;
			
			map = new char[N][N];
			visited = new boolean[N][N];
			q = new LinkedList<>();
			
			// 지뢰찾기 지도 정보
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			// 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(map[i][j]=='.' && !visited[i][j] && possible(i,j)) {
						cntClick++;
						click(i,j);
					}
				}
			}
			
			int cntNotClick = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]=='.')
						cntNotClick++;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(cntClick+cntNotClick).append('\n');
			
		} // end of tc
		
		System.out.println(sb);
		
	} // end of main

	/** (x,y)는 이 기준 8방향 모두 .인 곳
	 *  (x,y)에 대해 8방탐색하며, 각 방향도 각 방향 기준 8방향이 모두 .이면 큐에 삽입
	 *  이렇게 돌며 한 번의 클릭으로 최대한 많이 map을 연쇄(펼치기)
	 *  */
	public static void click(int x, int y) {
		
		visited[x][y] = true;
		q.offer(new Pair(x,y));
		
		while(!q.isEmpty()) {
			
			Pair p = q.poll();
			
			int px = p.x;
			int py = p.y;
			
			for (int k = 0; k < 8; k++) {
				int nx = px + dx[k];
				int ny = py + dy[k];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N)
					continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					
					if(possible(nx, ny))
						q.offer(new Pair(nx,ny));
				}
			} // end of for
			
		} // end of while
		
		q.clear();
		
	} // end of click()

	/** (x,y) 기준 8방향 모두 지뢰가 없다면(모두 .이라면), true를 리턴 */
	public static boolean possible(int x, int y) {
		
		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N)
				continue;
			
			if(map[nx][ny]!='.')
				return false;
		}
		
		return true;
	} // end of possible()

} // end of class
