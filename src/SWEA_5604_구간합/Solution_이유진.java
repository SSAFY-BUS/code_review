package SWEA_5604_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_이유진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		// 값 들이 크니까 long 사용하는 것 주의하자
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			long result = 0;
			
			// A~B이므로 0~B까지에서 1~A-1까지 합을 빼줌
			if(A!=0)
				result -= calc(A-1);
			if(B!=0)
				result += calc(B);
			
			System.out.println("#"+testCase+" "+result);
			
		} // end of testCase
		
	} // end of main

	private static long calc(long num) {
		if(num==0) // 0이면 0리턴
			return 0;
		
		// Math의 log10()과 pow()를 사용 할 때 double 형이라 값이 잘려서 오류가 날 수 있음 => 직접 만들어서 사용
		long digit = log(num); // 자리수
		long fNum = (num/pow(digit-1)); // 가장 높은 자리 수
		long restNum = num%pow(digit-1); // 가장 높은 자리 제외한 나머지 수
		
		// 자리수 따라서 계산
		if (digit==1) // 1의 자리수면 0 부터 num까지의 합 리턴
			return num*(num+1)/2;
		else
			// 세 부분으로 나누어서 계산한 뒤에 더함
			// ex.54321일 경우(0~54321) => (0~49999 까지의 숫자합 => 10^(5-1) * (5-1)*5/2(0~5까지 합) ) + (50000~54321까지 맨앞자리 5*5가 나오는 횟수) + (남은 4321을 재귀 호출)
			// (0부터 4까지의 합) * (10000(만의 자리는 만 번씩 나옴)) + (0부터 9까지의 합=45) * (1000번 * 천의 자리는 4개(자리수들의 개수)(천의 자리수 까지 각 값은 1000번씩 등장 )) * (5(만의 자리수 만큼 등장 0,1,2,3,4 5번)) => 첫 번째 부분
			// + (5 * (4321+1))(50000~54321 까지 5의 등장횟수=0~4321까지) + calc(4321)(50000~54321에서 만의자리 5는 계산을 마쳤으니 0000~4321의 계산이 필요, 재귀 호출) => 두 번째 부분 + 세 번째 부분
			return pow(digit-1) * (fNum-1) * fNum / 2  +  (45) * pow(digit-2) * (digit-1) * (fNum) // 10^(5-1) * (5-1*5/2) + 45 * (10^5-2) * (5-1) * 5 // 첫 번째 부분
					+ (fNum * (restNum+1)) + calc(restNum); // 5 * (4321+1) + calc(4321) // + 두 번째 부분 + 세번째 부분
	}

	private static long log(long num) { // log10 직접 만들어 사용
		long digit = 0;
		
		while(num>0) {
			num/=10;
			digit++;
		}
		return digit;
	}

	private static long pow(long digit) { // pow 직접 만들어 사용
		long result = 1;
		for (int i = 0; i < digit; i++) {
			result *= 10;
		}
		return result;
	}
} // end of class

