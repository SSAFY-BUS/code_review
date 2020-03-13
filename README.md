# Code_Review
- 알고리즘 코드 리뷰 레포지토리
-  [코드 리뷰 ](https://github.com/SSAFY-BUS/code_review/issues)


# 처음 참여할 때
  - Git Bash나 Shell을 사용할 경우, [gitBash 간단 설명](https://gbsb.tistory.com/10)
  - SourceTree를 사용할 경우, [SouceTree 간단 설명](https://m.blog.naver.com/PostView.nhn?blogId=sule47&logNo=221041860776&proxyReferer=https%3A%2F%2Fwww.google.com%2F)
  - Eclipse를 사용할 경우, [eclipse 자세한 설명](https://developer0513.tistory.com/23?category=793605)
    + 해당 링크는 1~5까지 있으며 충돌 발생시 상황도 다루고 있어 이클립스 사용할꺼면 꼼꼼히 보면 좋을 듯.
  - IntelliJ를 사용할 경우, [IntelliJ 간단 설명](https://ddoriya.tistory.com/entry/Intellij-Git-%EC%82%AC%EC%9A%A9%EB%B2%95)

### Git 관련 참고 사이트
  - [Git에 관해 몇 가지 정리](https://39km.tistory.com/category/%EA%B0%9C%EC%9D%B8%20%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EC%A7%84%ED%96%89?page=1)


# 문제 올릴 때

- 처음 알고리즘 문제를 올릴 경우. 
  + **알고리즘사이트_문제번호_문제제목**으로 package를 만들 것.
  + 가능하면 **문제이름.md**로 **문제 링크** 및 **문제**를 써주고 **sample_input.txt**와 **sample_output.txt**를 만들어줄 것.   
  + **알고리즘사이트_문제번호_문제제목** 에서 **알고리즘사이트**는 다음으로 통일!   
    + 백준 -> BaekJoon   
    + 정올 -> JungOl   
    + SWEA -> SWEA   
    + 프로그래머스 -> Programmers   
    + 그 외 사이트는 최초자가 정한 후 README 수정.
  + 위 과정이 끝나면 아래 항목대로 Code 작성. 

- 올라온 문제에 대한 코드를 작성할 경우.
    + 백준/정올은 **Main_이름(별칭).java**로 코드 올리기. 
    + SWEA나 프로그래머스는 **Solution_이름(별칭).java로**로 코드 올리기.
    + 이외에 사이트는 _ 이름(별칭)을 지우면 바로 테스트 할 수 있는 클래스명_이름(별칭).java로 코드 올리기.

-  다음 링크 참고 할 것 :    
  [패키지 예제](https://github.com/SSAFY-BUS/code_review/tree/master/src/SWEA_1952_%EC%88%98%EC%98%81%EC%9E%A5)    
  [코드 예제](https://github.com/SSAFY-BUS/code_review/blob/master/src/SWEA_1952_%EC%88%98%EC%98%81%EC%9E%A5/Solution_%EB%B0%95%ED%98%95%EB%AF%BC.java)


- **다른 사람 Code는 왠만하면 손대지 말 것! 코드 리뷰는 Issue를 통해 할 것.**

- **코드를 올리기 위해 commit 및 push 하기전 반드시 pull 한 다음에 충돌 검사 후 push 할 것.**
    + **다른 사람 코드를 건드린게 아닌데 충돌이 일어났다면 변경하는 방향으로 충돌 제거 할 것.**

- commit 메시지에는 **무엇**을 **어떻게** **[작성/수정/삭제]** 했는지 명시하기

- merge/push 할 때, **충돌 여부 및 충돌 제거가 잘 이루어졌는지 확인**하고 merge/push 시키기! (헷갈리면 일단 보류하기)


# 코드 파일 구성
- **[구현] 완료 시, [구현] 표시 생략 가능**

    + 가능하면 **[메모리]** 및 **[실행시간]** 표기 && 적용한 **[알고리즘 기법]이나 [방법론]을** 제시할 것.
    + 위 **[문제 올릴때]** 항목의 **코드 예제** 참고.

- **[미구현]시 package 선언문 바로 아래에 주석으로 [미구현]임을 표시할 것.**
    + **가능한 자세하게 미구현 사유를 설명할 것.**


# 코드 리뷰 시
- 코드 리뷰 시, 이슈 등록을 통해 관리.
- 코드 리뷰 시, [머릿말]을 통해 가독성을 유지할 것.
    + 머릿말 선택하는 것이 아니라 사용자가 직접 작성
    + 머릿말의 다양해지면 분류가 어려우니 하단의 **머릿말 Style** 기준으로 통일
      + 필요시 머릿말 추가 및 수정
- 코드 리뷰 제목 작성 기준 **[머릿말]알고리즘사이트_문제번호_문제제목/이름** 으로 작성
- **이슈는 왠만하면 삭제하거나 close 시키지 않기.**
-  다음 링크 참조 : 
    [코드 리뷰 예제](https://github.com/SSAFY-BUS/code_review/issues)
    [코드 리뷰 방법](https://github.com/SSAFY-BUS/code_review/blob/master/HowToReview.md)

### 머릿말 style
  - [코드 효율]   [논리 지적]   [코드 질문]  [논리 질문]   [반례]   [기타 제안]  [코드 칭찬]


# Environment
- java : zulu 1.8 open jdk / java 9 이상의 version
- IDE : eclipse , IntelliJ
- OS : Windows10 / MacOS


# 참고 알고리즘 사이트
- [백준](https://www.acmicpc.net/)

- [정올](http://www.jungol.co.kr/)

- [SWEA](https://swexpertacademy.com/main/main.do)

- [프로그래머스](https://programmers.co.kr/)
