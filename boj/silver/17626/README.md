## [17626] Four Squares

https://www.acmicpc.net/problem/17626  

**문제 유형**

dp

<br>

**풀이 방법 도출**

1. dp[i]

  -> dp[i]는 정수 i를 제곱수들의 합으로 표현할 때의 최소 항 개수

2. 초기값 설정 dp[0] = 0
3. 점화식 dp[i] = min(dp[i - j^2] + 1)

  -> j^2 <= i인 모든 j에 대해 탐색

<br>

**시간 복잡도**

O(N√N)

j^2 <= i의 모든 루프를 도는 경우