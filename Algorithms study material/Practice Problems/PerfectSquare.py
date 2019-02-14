#Given an integer x , Your task is to find the  square root of it. If x is not a perfect square, then return floor(√x).

T = int(input())
while(T > 0):
	num = int(input())
	if (math.sqrt(num) % 1 == 0):
		print(math.sqrt(num))
	T -=1