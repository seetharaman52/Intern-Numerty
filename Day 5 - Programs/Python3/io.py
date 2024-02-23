# Reading a file
file = open("file.txt", "r")
print(file.read())


# Writing to a file
file = open("file.txt", "w")
file.write("Hello, world!")
file.close()


# Appending to a file
file = open("file.txt", "a")
file.write("\nHello, world!")
file.close()

# Reading a file line by line
file = open("file.txt", "r")
print(file.readline())
file.close()

# Reading a file line by line using a loop
file = open("file.txt", "r")
for line in file:
    print(line)
file.close()

# Reading a file line by line using a loop and stripping the newline character
file = open("file.txt", "r")
for line in file:
    print(line.strip())
file.close()
