# -*- coding: utf-8 -*- 

###########################################################################
## Python code generated with wxFormBuilder (version Jun 17 2015)
## http://www.wxformbuilder.org/
##
## PLEASE DO "NOT" EDIT THIS FILE!
###########################################################################

import wx
import wx.xrc

###########################################################################
## Class QuoteDialog
###########################################################################

class QuoteDialog ( wx.Dialog ):
	
	def __init__( self, parent ):
		wx.Dialog.__init__ ( self, parent, id = wx.ID_ANY, title = u"Design Quotes", pos = wx.DefaultPosition, size = wx.Size( 419,230 ), style = wx.DEFAULT_DIALOG_STYLE )
		
		self.SetSizeHintsSz( wx.DefaultSize, wx.DefaultSize )
		self.SetExtraStyle( wx.DIALOG_EX_CONTEXTHELP|wx.DIALOG_EX_METAL )
		
		container = wx.BoxSizer( wx.VERTICAL )
		
		self.titleText = wx.TextCtrl( self, wx.ID_ANY, wx.EmptyString, wx.DefaultPosition, wx.Size( 400,-1 ), wx.TE_WORDWRAP )
		container.Add( self.titleText, 0, wx.ALL, 5 )
		
		self.quoteText = wx.TextCtrl( self, wx.ID_ANY, wx.EmptyString, wx.DefaultPosition, wx.Size( 400,100 ), wx.TE_CHARWRAP|wx.TE_MULTILINE|wx.TE_RICH|wx.TE_WORDWRAP )
		container.Add( self.quoteText, 0, wx.ALL, 5 )
		
		self.getButton = wx.Button( self, wx.ID_ANY, u"Click Me", wx.DefaultPosition, wx.Size( 400,-1 ), wx.BU_EXACTFIT )
		container.Add( self.getButton, 0, wx.ALL, 5 )
		
		
		self.SetSizer( container )
		self.Layout()
		
		self.Centre( wx.BOTH )
		
		# Connect Events
		self.getButton.Bind( wx.EVT_BUTTON, self.GetNewQuote )
	
	def __del__( self ):
		pass
	
	
	# Virtual event handlers, overide them in your derived class
	def GetNewQuote( self, event ):
		event.Skip()
	

