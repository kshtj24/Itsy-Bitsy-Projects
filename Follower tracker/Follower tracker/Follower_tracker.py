import tkinter as tk
import requests as rq
import json
import pickle

#method to fetch the list of followers from GitHub
def getFollowersFromGit(username):
    url = "https://api.github.com/users/" + username + "/followers"
    response = rq.get(url)
    data = json.loads(response.content)
    followerList = list()
    for dictElement in data:
        followerList.append(dictElement["login"])
    return followerList

#Method to fetch the saved list of followers
def getFollowersFromLocal():
    file = open('oldList','rb')
    unpickle = pickle.Unpickler(file)
    items = unpickle.load()
    oldList.insert('end',*items)

#Method to update the locally saved list of followers
def updateLocalListCallBack(data):
    try:
        file = open('oldList','wb')
        #pickle.dump(data,file)
        #with open('outfile', 'wb') as fp:
        pickle.dump(data, file)
        return True
    except Exception:
        return False

def whoUnfollowed(old,new):
    old = set(old)
    new = set(new)
    return set.difference(old,new)

#Driver and UI code
mainWindow = tk.Tk()

#Creating containers
pane1 = tk.PanedWindow(mainWindow,orient='horizontal')#,height=100,width=100,bg='black')
pane2 = tk.PanedWindow(mainWindow, orient = 'horizontal')#,height=100,width=100,bg='blue')

#Creating components for user interaction
oldList = tk.Listbox(pane1,height=20,width=25)
newList = tk.Listbox(pane1,height=20,width=25)
updateFollowers = tk.Button(pane2,text='Get followers',command=getFollowersFromLocal)
savetolocal = tk.Button(pane2,text='Save to local',command=lambda:updateLocalListCallBack(newList.get(0,last=newList.size())))
unfollowedme = tk.Button(pane2,text='Who unfollowed',command=lambda:whoUnfollowed(oldList.get(0,last=newList.size()),newList.get(0,last=newList.size())))

#Adding the components to containers
pane1.add(oldList)
pane1.add(newList)
pane2.add(updateFollowers)
pane2.add(savetolocal)
pane2.add(unfollowedme)

#Populating the lists with required data
newList.insert('end',*getFollowersFromGit('kshtj24'))

pane1.pack()
pane2.pack()
mainWindow.mainloop()