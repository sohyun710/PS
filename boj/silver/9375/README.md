## [9375] 패션왕 신해빈

https://www.acmicpc.net/problem/9095  


### 문제 유형

해시맵

### 풀이 방법 도출
- 의상 종류별 개수 카운트하여 해시맵 작성
- res *= (cnt + 1)​

  의상 종류별 개수마다 +1하여 모두 곱함 (안 고르는 경우 포함) 
- res - 1

  아무것도 안 입는 경우 제외

### 참고
- **Map의 메서드**
  - put(key, value): 키-값 쌍 추가 또는 업데이트
  - get(key): 키값 반환
  - containsKey(key): 키 존재 여부 확인
  - remove(key): 키-값 쌍 삭제
  - **getOrDefault(key, defaultValue)**: Map에서 특정 키의 값 가져올 때, 키가 없으면 기본값(defaultValue) 대신 반환
  - keySet(): 키만 모아놓은 Set 반환
  - values(): 값만 모아놓은 Collection 반환
  - entrySet(): 키-값 쌍(Entry) 모아놓은 Set 반환

### 시간 복잡도
O(n)
