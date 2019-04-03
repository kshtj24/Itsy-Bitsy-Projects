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
        
    def send_message(self, message, commandtype='send'):
        while True:
            json_str = '{"to":getsomeip, "command":"' + commandtype + '"' + '"message":"'+ message +'"}'            
            self.server.send(json_str)
            data = self.server.recv(1024)
            return data
        