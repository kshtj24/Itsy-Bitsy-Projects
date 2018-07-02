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
## Class MainWindow
###########################################################################

class MainWindow ( wx.Frame ):
	
	def __init__( self, parent ):
		wx.Frame.__init__ ( self, parent, id = wx.ID_ANY, title = u"Song Lyrics App", pos = wx.DefaultPosition, size = wx.Size( 480,600 ), style = wx.DEFAULT_FRAME_STYLE|wx.TAB_TRAVERSAL )
		
		self.SetSizeHintsSz( wx.Size( 480,600 ), wx.Size( 480,600 ) )
		
		sizerContainer = wx.BoxSizer( wx.VERTICAL )
		
		self.song_title_staticText = wx.StaticText( self, wx.ID_ANY, u"Song Title", wx.DefaultPosition, wx.Size( 460,-1 ), 0 )
		self.song_title_staticText.Wrap( -1 )
		sizerContainer.Add( self.song_title_staticText, 0, wx.ALL, 5 )
		
		self.song_title_txtControl = wx.TextCtrl( self, wx.ID_ANY, wx.EmptyString, wx.DefaultPosition, wx.Size( 460,-1 ), 0 )
		sizerContainer.Add( self.song_title_txtControl, 0, wx.ALL, 5 )
		
		self.artist_name_staticText = wx.StaticText( self, wx.ID_ANY, u"Artist Name", wx.DefaultPosition, wx.DefaultSize, 0 )
		self.artist_name_staticText.Wrap( -1 )
		sizerContainer.Add( self.artist_name_staticText, 0, wx.ALL, 5 )
		
		self.artist_name_txtControl = wx.TextCtrl( self, wx.ID_ANY, wx.EmptyString, wx.DefaultPosition, wx.Size( 460,-1 ), 0 )
		self.artist_name_txtControl.SetForegroundColour( wx.SystemSettings.GetColour( wx.SYS_COLOUR_WINDOWTEXT ) )
		
		sizerContainer.Add( self.artist_name_txtControl, 0, wx.ALL, 5 )
		
		self.get_lyrics_button = wx.Button( self, wx.ID_ANY, u"Get Lyrics", wx.DefaultPosition, wx.Size( 160,-1 ), 0 )
		sizerContainer.Add( self.get_lyrics_button, 0, wx.ALIGN_CENTER|wx.ALL, 5 )
		
		self.lyrics_txtControl = wx.TextCtrl( self, wx.ID_ANY, wx.EmptyString, wx.DefaultPosition, wx.Size( 460,390 ), wx.TE_MULTILINE|wx.TE_READONLY|wx.TE_RICH|wx.TE_WORDWRAP )
		sizerContainer.Add( self.lyrics_txtControl, 0, wx.ALL, 5 )
		
		
		self.SetSizer( sizerContainer )
		self.Layout()
		
		self.Centre( wx.BOTH )
		
		# Connect Events
		self.get_lyrics_button.Bind( wx.EVT_BUTTON, self.getLyrics )
	
	def __del__( self ):
		pass
	
	
	# Virtual event handlers, overide them in your derived class
	def getLyrics( self, event ):
		event.Skip()
	

