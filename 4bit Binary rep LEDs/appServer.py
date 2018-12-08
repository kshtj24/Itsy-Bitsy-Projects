import RPi.GPIO as gpio

#Code to deal with LEDs representation
def convertToBinary(number):

	returnable = ''

	while(number != 0):

		returnable += str(number % 2)

		number = number // 2

	return returnable[::-1]

#Using the GPIO pins 3, 5, 7, 11 for LEDs
def displayInLEDs(binary):

	pinList = [3, 5, 7, 11]

	for i in range(0, len(binary) - 1):

		gpio.output(pinList[i], int(binary[i]))

#Calling code
def callingCode(operableValue):
	gpio.cleanup()
	gpio.setmode(gpio.BOARD)
	gpio.setup(3, gpio.OUT)
	gpio.setup(5, gpio.OUT)
	gpio.setup(7, gpio.OUT)
	gpio.setup(11, gpio.OUT)
	# print("Enter a 4 bit number to convert to binary")
	operableValue = convertToBinary(int(operableValue))
	print(type(operableValue))
	displayInLEDs(operableValue)




#Web app code
from flask import Flask, render_template, redirect, request, url_for
app = Flask(__name__)


@app.route('/')
def firstPage():
	return render_template('firstPage.html')


@app.route('/secondPage/<mValue>')
def secondPage(mValue):
	# mObject = RPi_Code()
	# mObject.callingCode(self, mValue)
	callingCode(mValue)
	return render_template('secondPage.html', intVal=mValue)


@app.route('/firstPage', methods=['POST', 'GET'])
def formPost():
	if request.method == 'POST':
		mDecimalValue = request.form['intVal']
		return redirect(url_for('secondPage', mValue=mDecimalValue))
	return render_template('firstPage.html')


if __name__ == '__main__':
	app.run(debug=True, host='0.0.0.0', port=80)
