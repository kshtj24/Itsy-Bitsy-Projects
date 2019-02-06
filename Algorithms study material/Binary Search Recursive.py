def binary_search(arr,key,L,R):
    if R >= L:
        mid = int(L + (R - L)/2)
        if arr[mid] == key:
            return mid
        elif key < arr[mid]:
            return binary_search(arr,key,L,mid-1)
        elif key > arr[mid]:
            return binary_search(arr,key,mid+1,R)

print("enter sorted array elements")
arr = list(map(int,input().split(' ')))

print("enter seach key")
key = int(input())

print(binary_search(arr,key,0,len(arr)-1))
