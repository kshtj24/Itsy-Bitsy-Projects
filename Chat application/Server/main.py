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
    

    def close_client_connection():
        pass

    def handle_incoming_connection(self, client):
        while True:
            data = client.recv(1024)
            print(data)
            if not data[0]:
                print('Bye')
                PRINT_LOCK.release()
                break
            client.sendall(data[::-1])
        client.close()

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
            threading._start_new_thread(self.handle_incoming_connection, (client, None))
        server.close()

if __name__ == '__main__':
    CALL_OBJ = MultiThreadedChatServer()
    CALL_OBJ.accept_incoming_connection()
