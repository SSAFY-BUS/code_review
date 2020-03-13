package SWEA_3378_스타일리쉬_들여쓰기;
/**
	적용 알고리즘
		순열, 완탐, 시뮬레이션

메모리
	44,376 kb
실행시간
	165 ms


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_임진섭 {
	static int[] arr = new int[3]; // 모든 경우의 수의 R C S를 구할 배열
	static int[][] cntM; // 마스터코드의 괄호의 개수를 담을 배열
	static int[] pointM; // 마스터코드의 각 줄마다의 점의 개수를 담을 배열(들여쓰기 횟수)
	static int[] pointY; // 당신의 코드 줄 마다의 들여쓰기의 개수
	static int[][] cntY; // 줄마다의 괄호 개수
	static int[][] right; // 유일하게 결정되지 않는 경우를 체크하기 위한 이차원 배열
	static int p, q;
	static int r, c, s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			String[] master = new String[p]; // 마스터 코드
			pointM = new int[p]; // 줄 마다의 점의 개수
			cntM = new int[p][6]; // 줄마다의 괄호 개수

			for (int i = 0; i < master.length; i++) { // 마스터코드 줄 수
				master[i] = br.readLine();

				for (int j = 0; j < master[i].length(); j++) { // 마스터코드 한 줄의 글자 하나씩
					if (master[i].charAt(j) == '(') {
						cntM[i][0]++;
					} else if (master[i].charAt(j) == ')') {
						cntM[i][1]++;
					} else if (master[i].charAt(j) == '{') {
						cntM[i][2]++;
					} else if (master[i].charAt(j) == '}') {
						cntM[i][3]++;
					} else if (master[i].charAt(j) == '[') {
						cntM[i][4]++;
					} else if (master[i].charAt(j) == ']') {
						cntM[i][5]++;
					}
				}

				if (master[i].charAt(0) == '.') { // 들여쓰기가 시작된다면 끝날때까지 들여쓰기 개수 체크
					for (int j = 0; j < master[i].length(); j++) {
						if (master[i].charAt(j) == '.') {
							pointM[i]++;
						} else // 들여쓰기가 아니면 종료
							break;
					}
				}

			} // end of master check

			String[] you = new String[q]; // 당신의 코드
			pointY = new int[q]; // 당신의 코드 줄 마다의 들여쓰기의 개수
			cntY = new int[q][6]; // 줄마다의 괄호 개수
			right = new int[q][2]; // 애매한 경우

			for (int i = 0; i < you.length; i++) { // 당신의 코드 줄 수
				you[i] = br.readLine();

				for (int j = 0; j < you[i].length(); j++) { // 한 줄의 글자 하나씩
					if (you[i].charAt(j) == '(') {
						cntY[i][0]++;
					} else if (you[i].charAt(j) == ')') {
						cntY[i][1]++;
					} else if (you[i].charAt(j) == '{') {
						cntY[i][2]++;
					} else if (you[i].charAt(j) == '}') {
						cntY[i][3]++;
					} else if (you[i].charAt(j) == '[') {
						cntY[i][4]++;
					} else if (you[i].charAt(j) == ']') {
						cntY[i][5]++;
					}
				}

			} // end of you check

			rcsMake(0, q);

			System.out.print("#" + tc + " ");
			for (int i = 0; i < you.length; i++) {
				System.out.print(right[i][0] + " ");
			}
			System.out.println();
		} // end of tc

	} // end of main

	private static void findPoints(int i, int[][] cntY, int[] pointY) { // 내 코드에 들여쓰기가 얼마나 필요한지 계산하는 함수
		int aa = 0; // (
		int ab = 0; // )
		int ba = 0; // {
		int bb = 0; // }
		int ca = 0; // [
		int cb = 0; // ]

		for (int line = 0; line < i; line++) { // 줄마다 괄호 누적합
			aa += cntY[line][0];
			ab += cntY[line][1];
			ba += cntY[line][2];
			bb += cntY[line][3];
			ca += cntY[line][4];
			cb += cntY[line][5];
		}

		int rcs = (r * (aa - ab)) + (c * (ba - bb)) + (s * (ca - cb));

		if (right[i][1] == 0) { // rcs가 한가지인 경우
			right[i][0] = rcs; // rcs값 0번 방에 저장
			right[i][1]++; // 계산 횟수 증가
		} else { // rcs가 한가지가 아닌 경우
			if (right[i][0] != rcs) { // 기존에 저장한 rcs값과 지금 계산한 rcs값이 다른경우(유일하게 결정되지 못함)
				right[i][0] = -1; // -1로 바꿔줌
			}
		}
	}

	private static void rcsMake(int index, int q) { // 중복 순열을 통해 모든 경우의 rcs를 구함
		if (index == 3) {
			boolean flag = rcsFind(arr);
			if (flag) { // 올바른 rcs이면
				r = arr[0];
				c = arr[1];
				s = arr[2];
				for (int i = 1; i < q; i++) {
					findPoints(i, cntY, pointY); // 들여쓰기의 수를 구하는 함수
				}
				return;
			}
			return;
		} else {
			for (int i = 1; i < 21; i++) {
				arr[index] = i;
				rcsMake(index + 1, q);
			}
		}
	}

	private static boolean rcsFind(int[] arr) { // 올바른 rcs인지 확인하는 함수
		int points = 0; // 점의 개수
		int cnt = 0;
		boolean[] flag = new boolean[p - 1];
		for (int i = 0; i < flag.length; i++) {
			points = pointM[i + 1]; // i+1번째 들여쓰기의 개수
			if (points == rcsResult(i, arr)) { // i번째의 괄호를 통해 i+1번째 줄의 들여쓰기 갯수를 구해서 비교
				flag[i] = true;
			}
		}
		for (int i = 0; i < flag.length; i++) { // flag 배열의 true 개수 체크한 후
			if (flag[i] == true)
				cnt++;
		}
		if (cnt == p - 1) // 모두 체크면 올바른 rcs
			return true;
		else // 아니면 잘못된 rcs
			return false;
	}

	private static int rcsResult(int i, int[] arr) { // 들여쓰기 횟수 구하는 함수
		int aa = 0; // (
		int ab = 0; // )
		int ba = 0; // {
		int bb = 0; // }
		int ca = 0; // [
		int cb = 0; // ]

		for (int line = 0; line <= i; line++) { // 줄마다 괄호 누적 합
			aa += cntM[line][0];
			ab += cntM[line][1];
			ba += cntM[line][2];
			bb += cntM[line][3];
			ca += cntM[line][4];
			cb += cntM[line][5];
		}
		int rcs = (arr[0] * (aa - ab)) + (arr[1] * (ba - bb)) + (arr[2] * (ca - cb)); // 계산

		return rcs;
	}

} // end of class

