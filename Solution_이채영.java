package SWEA_4012_모의요리사;

/** 
 적용 알고리즘
 		조합
 
 메모리 
 		42,020kb
 
 실행시간
  		213m

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_이채영 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] s;
	static int min = Integer.MAX_VALUE;// 구하고자하는 최소값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T =Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 짝수 입력됨
			s = new int[n][n];
			
			
			for (int i = 0; i < s.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < s[i].length; j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//여기까지 입력
			
			// 조합으로 n/2 뽑기
			combi(0, new int[n / 2], 0);
			
			sb.append('#').append(tc).append(' ').append(min).append('\n');
			
			min = Integer.MAX_VALUE;
		}
		System.out.println(sb); // 최소 팀 능력치 차이
	
	}// end of main

	private static void combi(int cnt, int[] temp, int index) { // 그냥 조합을 구하는 코드
		if (cnt == temp.length) { // 절반 뽑음
			
			//temp에 스타트 팀이 들어있고 visit 사용해서  링크 팀 구하기
			int[] temp2 = new int[n/2];
			boolean[] visit = new boolean[n]; // 원소를 가지고 있는지 체크
			for (int i = 0; i < visit.length; i++) {
				for (int j = 0; j < temp.length; j++) {
					if(temp[j]==i) { // 가지고 있으면
						visit[i] = true;
					}
				}
			}
			
			int in=0;
			for (int i = 0; i < visit.length; i++) {
				if(!visit[i]) { // temp가 원소를 가지고 있지 않으면
					temp2[in] = i; // temp2에 넣기
					in++;
				}
			}
//			System.out.println("<현재 팀 조합>");
//			System.out.println(Arrays.toString(temp)+" "+Arrays.toString(temp2));
			//
			int start = power(temp); // 스타트 팀의 능력치
			int link = power(temp2);
//			System.out.println("스타트 능력치: "+start+" 링크 능력치 : "+link);
			
			int dif = Math.abs(start-link); // 두 팀의 차이 값

			if(min>dif)
				min = dif;
//			System.out.println("현재 최소값 : "+min);

			return;
		} else {
			for (int i = index; i < n; i++) {
				temp[cnt] = i;
				combi(cnt + 1, temp, i + 1);
			}
			
		}
	}//end of combi
	private static int power(int[] team) { // 각 팀의 능력치 구하기
		int sum=0; // 팀의 능력치
		for (int i = 0; i < team.length-1; i++) {
			for (int j = i+1; j < team.length; j++) {
				//능력치 더하기
				sum+=s[team[i]][team[j]]; //Sij
				sum+=s[team[j]][team[i]]; //Sji
			}
		}
		return sum;
	}

}// end of class
