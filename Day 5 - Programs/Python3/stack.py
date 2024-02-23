class Stack:
    def __init__(self):
        self.stack = []
        self.top = -1
    
    def push(self, data):
        self.stack.append(data)
        self.top += 1
    
    def pop(self):
        if self.top == -1:
            return None
        self.top -= 1
        return self.stack.pop() 

    def peek(self):
        if self.top == -1:
            return None
        return self.stack[self.top]
    
    def is_empty(self):
        return self.top == -1
    
    def size(self):
        return self.top + 1
    
    def display(self):
        print(self.stack)

s = Stack()
s.push(1)
s.push(2)
s.push(3)
s.push(4)
s.push(5)
s.display()
print(s.pop())
print(s.peek())
print(s.is_empty())
print(s.size())