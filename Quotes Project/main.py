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
#importing the ui class
import dialog

class GetQuotes
	def __init__(self, parent):
		dialog.MainWindow.__init____(self,parent)
		
	def GetNewQuote(self,event)
		quote = 