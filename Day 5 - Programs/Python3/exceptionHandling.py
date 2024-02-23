try:
    num = int(input("Enter a number lesser than 5: "))
    if num > 5:
        raise ValueError("Error: Number is greater than 5")
except Exception as e:
    print(e)
