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
		wx.Dialog.__init__ ( self, parent, id = wx.ID_ANY, title = wx.EmptyString, pos = wx.DefaultPosition, size = wx.Size( 419,319 ), style = wx.DEFAULT_DIALOG_STYLE )
		
		self.SetSizeHintsSz( wx.DefaultSize, wx.DefaultSize )
		
		container = wx.BoxSizer( wx.VERTICAL )
		
		self.titleText = wx.StaticText( self, wx.ID_ANY, u"Quote -", wx.DefaultPosition, wx.DefaultSize, wx.ALIGN_CENTRE )
		self.titleText.Wrap( -1 )
		container.Add( self.titleText, 0, wx.ALL, 5 )
		
		self.quoteText = wx.StaticText( self, wx.ID_ANY, u"MyLabel", wx.DefaultPosition, wx.DefaultSize, wx.ALIGN_CENTRE )
		self.quoteText.Wrap( -1 )
		container.Add( self.quoteText, 0, wx.ALL, 5 )
		
		self.getButton = wx.Button( self, wx.ID_ANY, u"Click Me", wx.DefaultPosition, wx.DefaultSize, wx.BU_EXACTFIT )
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
	

