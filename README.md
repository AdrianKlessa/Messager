# Messager
A simple command-line 2-person chat

Currently assumes the optimistic scenario that a connection can be made between the two terminals, otherwise it throws an exception. 
One needs to provide the IP address of the target computer (the most likely local IP is displayed when creating a server).
One can write 'quit' to exit the chat. Uses a separate thread for listening and writing.
