# Main class to provide front-end to https://lyricsovh.docs.apiary.io/

import wx
import SongLyricsAppUI
import requests

class GetLyrics(SongLyricsAppUI.MainWindow):
	def __init__(self, parent):
		SongLyricsAppUI.MainWindow.__init__(self,parent)
		
	def getLyrics(self,event):
		artist = self.artist_name_txtControl.GetValue()
		song_title = self.song_title_txtControl.GetValue()
		print("https://api.lyrics.ovh/v1/" + artist + "/" + song_title)
		response = requests.get("https://api.lyrics.ovh/v1/" + artist + "/" + song_title)
		lyrics = response.json()['lyrics']
		
		self.lyrics_txtControl.SetValue(str(lyrics))
		
		
app = wx.App(False)
frame = GetLyrics(None)
frame.Show(True)
app.MainLoop()