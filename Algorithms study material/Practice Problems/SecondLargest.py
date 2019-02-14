def findMax(arr):
    arr = (sorted(arr))[::-1]
    return arr[1]

T = int(input())
while(T > 0):
    n = int(input())
    arr = list(map(int,(str.strip(input())).split(' ')))
    print(findMax(arr))
    T-=1