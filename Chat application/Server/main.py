"""
Chat server module
"""
import socketserver

class ChatServerHandler(socketserver.BaseRequestHandler):
    """
    Request handler for the chat application server.
    Will be instantiated once per connection to the server.
    """
    def handle(self):
        self.data = (self.request.recv(1024).strip()).decode()
        print("{} wrote ".format(self.client_address[0]))
        print(self.data)

if __name__ == '__main__':
    HOST, PORT = "localhost", 9999
    #Creating the server
    with socketserver.TCPServer((HOST, PORT), ChatServerHandler) as mServer:
        #Activating and enabling the server to keep running
        #untill interrupted using Ctrl + C
        print('Starting chat server')
        mServer.serve_forever()
