import socket

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(("localhost", 5000))
server.listen()
print("Server is waiting for connection")

client_socket, addr = server.accept()
print("client connected on", addr)

while True:
    message = client_socket.recv(1024).decode()

    if message == "exit":
        print("Client exit ")
        break

    print("Client said", message)

    reply = input("Server: ")
    client_socket.send(reply.encode())

client_socket.close()
server.close()
