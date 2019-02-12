#Given a sorted array A of size N and a number X, you need to find the number of occurrences of X in A.
def countOccurences(arr,x):
	count = 0
	for item in arr:
		if x == item:
			count += 1
    return count if count > 0 else -1

T = int(input())
while(T > 0):
    n,x = map(int,(str.strip(input())).split(' '))
    arr = list(map(int,(str.strip(input())).split(' ')))
    print(countOccurences(arr,x))
    T-=1