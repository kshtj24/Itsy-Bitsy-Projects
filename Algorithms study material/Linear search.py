arr = list(map(int,input().split(' ')))
key = int(input())

position = -1

for i in range(0,len(arr)):
    if key == arr[i]:
        position = i
        break

if position == -1:
    print("element not found")
else:
    print("element found at ",position)

