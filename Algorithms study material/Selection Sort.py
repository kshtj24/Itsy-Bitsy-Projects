def selectionSort(arr):
    for i in range(0,len(arr)):
        for j in range(i,len(arr)):
            if arr[i] > arr[j]:
                temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
    return arr
    
arr = list(map(int,(str.strip(input())).split(' ')))
print(selectionSort(arr))