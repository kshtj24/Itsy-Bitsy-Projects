"""
Chat client module
"""
import socket

class chat_backend():
    
    def __init__(self):
        self.HOST = 'localhost'
        self.PORT = 9999
        self.server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.server.connect((self.HOST, self.PORT))
        
    def send_message(self, message):
        while True:
            self.server.send(message.encode('ascii'))
            data = self.server.recv(1024)
            return data
        