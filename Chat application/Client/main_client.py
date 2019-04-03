"""
Chat client module
"""
import socket

class chat_backend():
    
    def __init__(self, HOST='localhost', PORT=9999):
        self.HOST = HOST
        self.PORT = PORT
    
    def send_message(self, message):
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as mSocket:
            mSocket.connect((self.HOST, self.PORT))
            mSocket.sendall(message.encode())

#HOST, PORT = 'localhost', 9999
#
#with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as mSocket:
#    mSocket.connect((HOST, PORT))
#    mSocket.sendall(input().encode())