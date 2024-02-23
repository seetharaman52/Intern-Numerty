import threading
import time

def printOdd():
    for i in range(1, 11, 2):
        print(i)
        time.sleep(1)

def printEven():
    for i in range(2, 11, 2):
        print(i)
        time.sleep(1)

printNumbersThread1 = threading.Thread(target=printOdd)
printNumbersThread2 = threading.Thread(target=printEven)
printNumbersThread1.start()
printNumbersThread2.start()