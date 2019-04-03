"""
Chat server module
"""
import socket
import threading

PRINT_LOCK = threading.Lock()
CLIENTS = []

class MultiThreadedChatServer():
    """
    Chat server using sockets and threading
    """

    def close_client_connection(self, client):
        client.close()        

    def handle_incoming_connection(self, client):
        while True:
            data = client.recv(1024)
            print(data)
            #TODO - logic to be inserted for checking the request type. ie Close connection or send message
            #TODO - logic to be inserted for adding client to the list of clients
            #TODO - logic to be inserted for sending the message to the client specified in the data

    def accept_incoming_connection(self):
        host = 'localhost'
        port = 9999
        server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server.bind((host, port))
        print('socket bound to post', port)
        server.listen(5)
        print('socket listening now')
        while True:
            client, addr = server.accept()
            PRINT_LOCK.acquire()
            print('Connected to :', addr[0], ':', addr[1])
            threading._start_new_thread(self.handle_incoming_connection, (client,))
        server.close()

if __name__ == '__main__':
    CALL_OBJ = MultiThreadedChatServer()
    CALL_OBJ.accept_incoming_connection()
