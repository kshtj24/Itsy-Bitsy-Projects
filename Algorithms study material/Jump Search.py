from math import sqrt

def jumpSearch(arr, m, key, index):
    if(arr[index] == key):
        return index
    elif(arr[index] > key):
        for i in range(index - m, index):
            if(arr[i] == key):
                return i
    elif(arr[index] < key):
        return jumpSearch(arr,m,key,index+m)
    else:
        return -1


arr = list(map(int,input("Enter sorted array:").split(' ')))
key = int(input('Enter search key'))

print(jumpSearch(arr,int(sqrt(len(arr))),key,0))
