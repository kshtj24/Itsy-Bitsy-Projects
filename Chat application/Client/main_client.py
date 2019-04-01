"""
Chat client module
"""
import socket

HOST, PORT = 'localhost', 9999

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as mSocket:
    mSocket.connect((HOST, PORT))
    mSocket.sendall(input().encode())