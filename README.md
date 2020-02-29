# Code_Review
- 알고리즘 코드 리뷰 레포지토리


# 처음 참여할 때
  - 참고 사이트 찾아서 업데이트 할게! 괜찮은 내용 찾으면 누구나 여기에 작성 가능!


# 문제 올릴 때

- 올리려는 문제에 pakage가 없을 경우. **알고리즘사이트_문제번호_문제제목**으로 package를 만든 후 가능하면 **문제이름.md**로 **문제 링크** 및 **문제**를 써주고 **sample_input.txt**와 **sample_output.txt**를 만들어줄 것.   
알고리즘 사이트는 다음으로 통일!   
백준 -> BaekJoon   
정올 -> JungOl   
SWEA -> SWEA   
프로그래머스 -> Programmers   

- 문제에 packege가 있거나 직접 생성한 경우 백준/정올 같은 경우 **Main_이름(별칭)으로**, SWEA나 프로그래머스 같은 경우 **Solution_이름(별칭)으로** java파일을 올릴 것. (이외에 사이트는 _ 이름(별칭)을 지우면 바로 테스트 할 수 있는 클래스 이름_이름(별칭)으로 java파일을 만들어 올릴 것.)

-  다음 링크 참고 할 것 :    
  [패키지 예제](https://github.com/SSAFY-BUS/code_review/tree/master/src/SWEA_1952_%EC%88%98%EC%98%81%EC%9E%A5)    
  [코드 예제](https://github.com/SSAFY-BUS/code_review/blob/master/src/SWEA_1952_%EC%88%98%EC%98%81%EC%9E%A5/Solution_%EB%B0%95%ED%98%95%EB%AF%BC.java)


- **다른 사람 Code는 왠만하면 손대지 말 것! 코드 리뷰는 Issue를 통해 할 것.**

- **코드를 올리기 위해 commit 및 push 하기전 반드시 commit하고 pull 한 다음에 충돌 검사 후 push 할 것.(다른 사람 코드를 건드린게 아닌데 충돌이 일어났다면 변경하는 방향으로 충돌 제거 할 것.)**

- commit 메시지는 **[무엇]**을 **[작성/수정/삭제]** 했는지 명시하기

- merge 할 때, **충돌 여부 및 충돌 제거가 잘 이루어졌는지 확인**하고 merge 시키기! (헷갈리면 일단 보류하기)


# 코드 파일 구성
- **[구현]시, [구현] 표시 생략 가능

- 가능하면 **[메모리]** 및 **[실행시간]** 표기 && 적용한 **[알고리즘 기법]이나 [방법론]을** 제시할 것.

- **[미구현]시 package 선언문 바로 아래에 주석으로 [미구현]임을 표시할 것. -> 가능한 자세하게 미구현 사유를 설명할 것.**


# 코드 리뷰 시
- 코드 리뷰 시, 이슈 등록을 통해 관리. 다음 링크 참조 : 
    [코드 리뷰 예제](https://github.com/SSAFY-BUS/code_review/issues)
- 코드 리뷰 시, [머릿말]을 통해 가독성 증가/ -> 머릿말 선택하는 것이 아니라 사용자가 직접 써주되, 머릿말의 다양해지면 분류가 어려우니 아래 **머릿말 Style** 기준으로 통일하되, 필요시 머릿말 추가 요청

- **머릿말 style : [코드 효율] [논리 지적] [코드 질문] [논리 질문] [반례] [기타 제안] [코드 칭찬]**
- **이슈는 왠만하면 삭제하거나 close 시키지 않기.**


# Environment
- java : zulu 1.8 open jdk / java 9 이상의 version
- IDE : eclipse , IntelliJ
- OS : Windows10 / MacOS


# 참고 알고리즘 사이트
- 백준 (https://www.acmicpc.net/)

- 정올 (http://www.jungol.co.kr/)

- SWEA (https://swexpertacademy.com/main/main.do)

- 프로그래머스 (https://programmers.co.kr/)
