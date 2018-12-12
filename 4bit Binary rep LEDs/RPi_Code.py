import RPi.GPIO as gpio

class RPi_Code:

	#Converting the decimal value received to binary and returning the reversed string
	def convertToBinary(self, number):

		returnable = ''

		while(number != 0):

			returnable += str(number % 2)

			number = number // 2

		return returnable[::-1]


	#Using the GPIO pins 3, 5, 7, 11 for LEDs

	def displayInLEDs(self, binary):

		pinList = [3, 5, 7, 11]

		for i in range(0, len(binary) - 1):

			gpio.output(pinList[i], int(binary[i]))


	#Calling code
	def callingCode(self, operableValue):
		gpio.cleanup()
		gpio.setmode(gpio.BOARD)
		gpio.setup(3, gpio.OUT)
		gpio.setup(5, gpio.OUT)
		gpio.setup(7, gpio.OUT)
		gpio.setup(11, gpio.OUT)
		# print("Enter a 4 bit number to convert to binary")
		operableValue = convertToBinary(self, int(operableValue))
		print(type(operableValue))

		displayInLEDs(self, operableValue)
