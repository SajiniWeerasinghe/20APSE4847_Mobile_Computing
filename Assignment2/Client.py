import socket

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(("localhost", 5000))

while True:

    message = input("Client: ")
    client.send(message.encode())

    if message.lower() == "exit":
        break

    response = client.recv(1024).decode()
    print("Server said", response)

client.close()
