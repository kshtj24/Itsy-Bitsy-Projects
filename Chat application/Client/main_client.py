"""
Chat client module
"""
import socket

HOST, PORT = 'localhost', 9999

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as mSocket:
    mSocket.connect((HOST, PORT))
    mSocket.sendall(input().encode())



canvas = Canvas(top_frame)
    chat_frame = Frame(canvas)
    
    v_scroller = Scrollbar(top_frame,orient='vertical',command=canvas.yview)
    canvas.configure(yscrollcommand=v_scroller.set)
    
    
    v_scroller.pack(side='right',fill='y')
    canvas.pack(side='left')