## [18870] 좌표 압축

https://www.acmicpc.net/problem/18870

<br>

**문제 유형**

해시맵

<br>

**풀이 방법 도출**

1. 배열에 원소 입력받아 저장
2. HashSet에 배열 원소 삽입하여 중복 제거
3. ArrayList로 변환하여 정렬 수행
4. HashMap에 (원소, 인덱스) 매핑
  - 인덱스는 자신보다 작은 원소의 개수와 같다

<br>

**시간 복잡도**

O(NlogN)