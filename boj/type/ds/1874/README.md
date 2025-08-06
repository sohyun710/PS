## [1874] 스택 수열

https://www.acmicpc.net/problem/1874
<br>
<br>

**문제 유형**

자료구조, 스택

<br>

**풀이 방법 도출**

1. target 변수를 입력받아 target 순번까지 오름차순으로 요소를 추가

2. 스택의 top 요소와 target이 같아지면 pop하고 새로운 target을 입력받음

3. 스택의 top 요소와 target을 비교할 때 LILO 구조를 위반하는 요소가 입력되면 'NO'를 출력하고 종료함

<br>

**시간 복잡도**

O(n)