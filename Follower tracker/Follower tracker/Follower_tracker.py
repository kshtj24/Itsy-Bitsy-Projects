import tkinter as tk


def getFollowersFromGit():




mainWindow = tk.Tk()

pane1 = tk.PanedWindow(mainWindow,orient='horizontal')#,height=100,width=100,bg='black')
pane2 = tk.PanedWindow(mainWindow, orient = 'horizontal')#,height=100,width=100,bg='blue')

oldList = tk.Listbox(pane1)
newList = tk.Listbox(pane1)
updateFollowers = tk.Button(pane2,text='Get followers')

pane1.add(oldList)
pane1.add(newList)
pane2.add(updateFollowers)

pane1.pack()
pane2.pack()
mainWindow.mainloop()