import sys

def insertion_sort(): # A[1..N]을 오름차순 정렬한다.
    _, now = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))
    count = 0
    for i in range(1, len(A)):
        loc = i - 1
        newItem = A[i]

        # 이 지점에서 A[1..i-1]은 이미 정렬되어 있는 상태
        while (0 <= loc and newItem < A[loc]):
            count += 1
            A[loc + 1] = A[loc]
            if count == now:
                print(A[loc])
                return
            loc -= 1
        
        if (loc + 1 != i):
            count += 1
            A[loc + 1] = newItem
            if count == now:
                print(newItem)
                return
    
    if count < now:
        print(-1)

insertion_sort()