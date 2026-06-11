import socket


# create socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# binding url and port
server.bind(("localhost", 5000))

# listening
server.listen()
print("Server is waiting for connections...")

client_socket, addr = server.accept()
print("Client connected on", addr)

while True:
    message = client_socket.recv(1024)

    if message.lower() == "exit":
        print("Client disconnected")
        break

    reply = input("Enter reply: ")
    print("Client said", message.decode())
    client_socket.send(reply.encode())


# socket closing
server.close()
