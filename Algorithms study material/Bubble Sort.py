def bubbleSort(arr,n):
    for i in range(0,n):
        for j in range(0,n-1):
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
    return arr
    
arr = list(map(int,input().split(' ')))
n = len(arr)

print(bubbleSort(arr,n))