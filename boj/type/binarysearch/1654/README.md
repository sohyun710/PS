## [1654] 랜선 자르기

https://www.acmicpc.net/problem/1654
<br>
<br>

**문제 유형**

이진 탐색
<br>

**풀이 방법 도출**

- 각 랜선의 길이를 배열로 받으며 최댓값을 저장
 
- 이진 탐색

    - left = 1, right = max, mid = (left + right) / 2로 설정
    - 각 랜선의 길이를 mid로 나눈 몫의 총합(cnt)을 구함

- cnt >= N이면, left = mid + 1 하여 탐색 반복

  cnt < N이면, right = mid - 1 하여 탐색 반복

- 조건을 만족한 mid 값 중 가장 큰 값을 result로 출력
<br>

**시간 복잡도**

O(K logM)
