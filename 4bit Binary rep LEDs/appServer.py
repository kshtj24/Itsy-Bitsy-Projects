from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def HelloWorld():
	return 'HelloWorld'


if __name__ == '__main__':
	app.run(host='0.0.0.0', port=80)
	
	
#Tasks
# -list the applications on the device hosted on server and ask the user to pick an application --refer flask variable rules section in tutorialspoint
# -display nicely designed html page to show the user fields to enter values and details of the application
# -take the decimal value from user and pass it to the rpi_code class
# -take the return value from the rpi_code class to show success
