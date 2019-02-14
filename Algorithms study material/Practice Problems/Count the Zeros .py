#Given an array of size N consisting of only 0's and 1's ,which is sorted in such a manner that all the 1's are placed first and then they are followed by all the 0's.
#You have to find  the count of all the 0's.

def countZeros(arr):
    count = 0
    for element in arr[::-1]:
        if (element == '0'):
            count+=1
        else:
            return count
    return count

T = int(input())
while(T > 0):
    n = int(input())
    arr = list((str.strip(input())).split(' '))
    print(countZeros(arr))
    T-=1