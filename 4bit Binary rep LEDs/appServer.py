from flask import Flask, render_template, redirect, request, url_for

app = Flask(__name__)

@app.route('/')
def firstPage():
	return render_template('firstPage.html')

@app.route('/secondPage/<mValue>')
def secondPage(mValue):
	return render_template('secondPage.html', intVal = mValue)

@app.route('/firstPage', methods = ['POST','GET'])
def formPost():
	if request.method == 'POST':
		mDecimalValue = request.form['intVal']
		return redirect(url_for('secondPage', mValue = mDecimalValue))
	return render_template('firstPage.html')
		

if __name__ == '__main__':
	app.run(debug = True)