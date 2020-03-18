package SWEA_5604_구간합;

import java.util.Scanner;
/**
적용 알고리즘
	Greedy
	
메모리
	27,208 KB

실행시간
	136 ms


*/

public class Solution_박형민 {
	static long answer,a,b;
	static int nine;
	static long[] digitA;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int test_case = 1; test_case<=TC; test_case++ ) {
			a = sc.nextLong();
			b = sc.nextLong();
			digitA = new long[10];
			
			long sumB = calSum(b);
			
			
			digitA = new long[10];
			if(a>0) {
				a--;
			}
			long sumA = calSum(a);
			
			answer = sumB-sumA;
			if(answer<0) {
				answer=0;
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
		
		public static long calSum(long num){
			
			long sum=0;
			long temp = num;	// 입력 받은 숫자를 변경하며 저장하기 위해 만든 변수
			long ten=1;			// 10^n을 구하기 위한 변수. 초기값은 10^0=1
			
			while(true) {
				if(temp<10) {
					break;
				}
				temp/=10;
				ten*=10;
			}	// 입력 받은 숫자(num)의 10^(n-1)인지 구함. (n을 구하는 것이 아니라 10^n을 구함)
			
			
			long prev=0;
			// 앞자리 수가 무엇이었는지 저장하기 위한 변수. 처음 자리에는 앞이 없으므로 0으로 초기화
			
			while(ten>0) {
				
				long front=num/ten;
				//한자리를 구하기 위한 변수 n자리인 num을 10^(n-1)으로 나눔.
				
				long end=num%ten;
				//나머지 뒤에 있는 숫자들
				
				
				
				
				
				/*
					주어진 숫자가 5자리 숫자 abcde라고 하고 현재 세번째 자리에서 1~9가 각각 나오는 횟수를 구한다고 하면
					0~abcde에서 [1-9]가 나오는 횟수는 0~ab000에서 나오는 횟수 + ab000~abcde에서 나오는 횟수와 같다.
					(그리고 ab000~abcde에서 세번째 자리에 1-9가 나오는 횟수는 000~cde에서 세번째 자리에 1-9가 나오는 횟수는 같다.)
					
					
					
				 */
				
				
				/*
					아래 반복문은 0~ab000에 3번째 자리에 1~9가 나오는 횟수를 증가하는 함수인데
					각각의 숫자들은 세번째 자리에  ab*10^2번 나옴.
					
					아래 prev에 현재 ab가 담겨져있고 ten=10^2임.
				 */
				for(int i=1;i<10;i++) {
					digitA[i]+=prev*ten;
				}
				
				
				/*
					아래 반복문은 ab000~abcde에 3번째 자리에 1~9가 나오는 횟수를 증가하는 함수인데
					위 범위를 000~cde라 고치면 세번째 자리에 0~(c-1)까지 10^2개만큼 나옴
					[참고 N00~(N+1)00까지 N은 100번 나옴.]
					c는 0~de까지 de+1번 나옴.
					 
					현재, 아래 front=c이고 ten=10^2이고 end=de임.
				 */
				for(int i=1;i<front;i++) {
					digitA[i]+=ten;
				}
				digitA[(int)front]+=end+1;
				
				
				/*
					현재 front가 c이므로
					현재 prev에 ab가 담겨져있으므로 10을 곱한뒤 c를 더하면 prev에 abc가 담김.
					현재 num은 cde인데 c*10^2을 더한뒤 빼므로 num=de가 됨. (아래 식 대신, num=end라고 해도 됨.)
					ten의 지수를 한단계 낮춤.
				 */
				prev*=10;
				prev+=front;
				num-=(front*ten);
				ten/=10;
			}
			
			///////////////////////////////////////////////////// 다 구했으니 이제 더하기
			for(int i=1;i<10;i++) {
				sum+=i*digitA[i];
			}
			return sum;
		}
		
		public static long brute(long N) {
			long sum=0;
			for(long i=1;i<=N;i++) {
				long tmp=i;
				while(tmp>0) {
					sum+=tmp%10;
					tmp/=10;
				}
			}
			
			return sum;
		}
		
	
	

}
