# Main class to provide front-end to https://quotesondesign.com/api-v4-0/

#class CalcFrame(Demo.MainWindow): 
#   def __init__(self,parent): 
#      Demo.MainWindow.__init__(self,parent)  
		
   #def FindSquare(self,event): 
   #   num = int(self.textInput.GetValue()) 
   #   self.textResult.SetValue (str(num*num)) 
        
#app = wx.App(False) 
#frame = CalcFrame(None) 
#frame.Show(True) 
##start the applications 
#app.MainLoop() 

import wx
import dialog
import requests
from bs4 import BeautifulSoup

class GetQuotes(dialog.QuoteDialog):
	def __init__(self, parent):
		dialog.QuoteDialog.__init__(self,parent)
		
	def GetNewQuote(self,event):
		response = requests.get("http://quotesondesign.com/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1")
		
		title = response.json()[0]['title']
		quote = BeautifulSoup(response.json()[0]['content']).get_text()
		
		self.titleText.SetValue(str(title))
		self.quoteText.SetValue(str(quote))
		
app = wx.App(False)
frame = GetQuotes(None)
frame.Show(True)
app.MainLoop()