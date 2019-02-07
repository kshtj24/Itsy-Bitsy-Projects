from bisect import bisect_left 

def fibMonaccianSearch(arr, key, n): 
	fibMMm2 = 0
	fibMMm1 = 1
	fibM = fibMMm2 + fibMMm1

	while (fibM < n): 
		fibMMm2 = fibMMm1 
		fibMMm1 = fibM 
		fibM = fibMMm2 + fibMMm1 

	offset = -1; 

	while (fibM > 1): 
		
		i = min(offset+fibMMm2, n-1) 

		if (arr[i] < key): 
			fibM = fibMMm1 
			fibMMm1 = fibMMm2 
			fibMMm2 = fibM - fibMMm1 
			offset = i 

		elif (arr[i] > key): 
			fibM = fibMMm2 
			fibMMm1 = fibMMm1 - fibMMm2 
			fibMMm2 = fibM - fibMMm1 

		else : 
			return i 

	if(fibMMm1 and arr[offset+1] == key): 
		return offset+1; 

	return -1

arr = list(map(int,input('enter array ').split(' ')))
n = len(arr)
key = int(input('enter search key '))
print("Found at index:", 
	fibMonaccianSearch(arr, key, n)) 
