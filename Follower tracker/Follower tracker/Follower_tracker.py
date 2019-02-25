import tkinter as tk
import requests as rq
import json

def getFollowersFromGit(username):
    url = "https://api.github.com/users/"+ username +"/followers"
    response = rq.get(url)
    data = json.loads(response.content)
    followerList = list()
    for dictElement in data:
        followerList.append(dictElement["login"])
    return followerList

def getFollowersFromLocal():
    return True

def updateLocalList():
    return True


mainWindow = tk.Tk()

pane1 = tk.PanedWindow(mainWindow,orient='horizontal')#,height=100,width=100,bg='black')
pane2 = tk.PanedWindow(mainWindow, orient = 'horizontal')#,height=100,width=100,bg='blue')

oldList = tk.Listbox(pane1)
newList = tk.Listbox(pane1)
updateFollowers = tk.Button(pane2,text='Get followers')

pane1.add(oldList)
pane1.add(newList)
pane2.add(updateFollowers)

print(getFollowersFromGit('kshtj24'))
pane1.pack()
pane2.pack()
mainWindow.mainloop()