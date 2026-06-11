import socket

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(("localhost", 5000))

while True:
    msg = input("You: ")
    client.send(msg.encode())

    if msg.lower() == "exit":
        break

    response = client.recv(1024).decode()
    print("Server said:", response)

client.close()
