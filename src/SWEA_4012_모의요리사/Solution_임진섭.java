package SWEA_4012_모의요리사;
/**
적용 알고리즘
	비트마스킹, 순열
메모리
	40,564 kb
실행시간
	528 ms
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_임진섭 {
	static int n;
	static int[][] arr;
	static int[] temp = new int[2];
	static boolean[] check;
	static int sum;
	static int one;
	static int two;
	static int min;
	static ArrayList<Integer> listOne = new ArrayList<Integer>();
	static ArrayList<Integer> listTwo = new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			StringTokenizer st;
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of input
			
			makeTeam();
			System.out.println("#" + tc + " " + + min);
		} // end of tc
		
		
	} // end of main
	private static void makeTeam() {
		int n = (int) Math.pow(2, arr.length);
		for (int i = 0; i < n; i++) {
			listOne.clear();
			listTwo.clear();
			for (int j = 0; j < arr.length; j++) {
				if ((i & (1 << j)) != 0) {
					listOne.add(j);
				} else
					listTwo.add(j);

			}
			if (listOne.size() == (arr.length / 2)) {
				check = new boolean[listOne.size()];
				sum = 0;
				makePermu(0, 2, listOne);
				one = sum;
				check = new boolean[listOne.size()];
				sum = 0;
				makePermu(0, 2, listTwo);
				two = sum;
				min = Math.min(min, Math.abs(one-two));
			}
		}
	}

	private static void makePermu(int index, int size, ArrayList<Integer> list) {
		if (index >= 2) {
			sum += arr[temp[0]][temp[1]];
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (!check[i]) {
					temp[index] = list.get(i);
					check[i] = true;
					makePermu(index + 1, size, list);
					check[i] = false;
				}
			}
		}
	}
} // end of class

