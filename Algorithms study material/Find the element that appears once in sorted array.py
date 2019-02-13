#Given a sorted array A, size N, of integers; every element appears twice except for one. Find that element in linear time complexity

T = int(input())
while(T > 0):
    n = int(input())
    arr = list(input().split(' '))
    xorSum = 0
    for element in arr:
        if str.isnumeric(element):
            xorSum ^= int(element)
    print(xorSum)
    T-=1