package SWEA_4012_���ǿ丮��;

/** 
 ���� �˰���
 		����
 
 �޸� 
 		42,020kb
 
 ����ð�
  		213m

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_��ä�� {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] s;
	static int min = Integer.MAX_VALUE;// ���ϰ����ϴ� �ּҰ�

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T =Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // ¦�� �Էµ�
			s = new int[n][n];
			
			
			for (int i = 0; i < s.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < s[i].length; j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//������� �Է�
			
			// �������� n/2 �̱�
			combi(0, new int[n / 2], 0);
			
			sb.append('#').append(tc).append(' ').append(min).append('\n');
			
			min = Integer.MAX_VALUE;
		}
		System.out.println(sb); // �ּ� �� �ɷ�ġ ����
	
	}// end of main

	private static void combi(int cnt, int[] temp, int index) { // �׳� ������ ���ϴ� �ڵ�
		if (cnt == temp.length) { // ���� ����
			
			//temp�� ��ŸƮ ���� ����ְ� visit ����ؼ�  ��ũ �� ���ϱ�
			int[] temp2 = new int[n/2];
			boolean[] visit = new boolean[n]; // ���Ҹ� ������ �ִ��� üũ
			for (int i = 0; i < visit.length; i++) {
				for (int j = 0; j < temp.length; j++) {
					if(temp[j]==i) { // ������ ������
						visit[i] = true;
					}
				}
			}
			
			int in=0;
			for (int i = 0; i < visit.length; i++) {
				if(!visit[i]) { // temp�� ���Ҹ� ������ ���� ������
					temp2[in] = i; // temp2�� �ֱ�
					in++;
				}
			}
//			System.out.println("<���� �� ����>");
//			System.out.println(Arrays.toString(temp)+" "+Arrays.toString(temp2));
			//
			int start = power(temp); // ��ŸƮ ���� �ɷ�ġ
			int link = power(temp2);
//			System.out.println("��ŸƮ �ɷ�ġ: "+start+" ��ũ �ɷ�ġ : "+link);
			
			int dif = Math.abs(start-link); // �� ���� ���� ��

			if(min>dif)
				min = dif;
//			System.out.println("���� �ּҰ� : "+min);

			return;
		} else {
			for (int i = index; i < n; i++) {
				temp[cnt] = i;
				combi(cnt + 1, temp, i + 1);
			}
			
		}
	}//end of combi
	private static int power(int[] team) { // �� ���� �ɷ�ġ ���ϱ�
		int sum=0; // ���� �ɷ�ġ
		for (int i = 0; i < team.length-1; i++) {
			for (int j = i+1; j < team.length; j++) {
				//�ɷ�ġ ���ϱ�
				sum+=s[team[i]][team[j]]; //Sij
				sum+=s[team[j]][team[i]]; //Sji
			}
		}
		return sum;
	}

}// end of class
