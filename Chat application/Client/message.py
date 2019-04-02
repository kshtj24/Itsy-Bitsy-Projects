# -*- coding: utf-8 -*-
"""
Created on Tue Apr  2 14:27:24 2019

@author: Acc.Guest
"""

from tkinter import *

top = Tk()
frame = Text(top, height=500, width=200)

for num in range (0,45):
    box = Message(frame, text='Message box number' + str(num))
    box.pack()

scroller = Scrollbar(top)
scroller.pack(side='right',fill='y')
frame.pack()
frame['yscrollcommand'] = scroller.set
scroller['command'] = frame.yview


#
#
#for num in range (0,45):
#    box = Message(frame, text='Message box number' + str(num))
#    box.pack()

top.mainloop()