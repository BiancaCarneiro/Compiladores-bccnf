# Ex entrada:
# 4
# 8
# +
# 3
# *

# Considerações:
#  - A entrada está separada por \n

def reverse_polish_notation_solver(entry):
    entry_array = entry.split()    
    priority = {"+":1, "-":1, "/":2, "*":2,}
    i = 0
    
    while len(entry_array) > 1:
        if i > len(entry_array):
            return 0
        if entry_array[i] == "+":
            entry_array[i-2] = int(entry_array[i-1]) + int(entry_array.pop(i-2))
            entry_array.pop(i-1)
            i = 0
        elif entry_array[i] == "-":
            entry_array[i-2] = int(entry_array[i-1]) - int(entry_array.pop(i-2))
            entry_array.pop(i-1)
            i = 0
        elif entry_array[i] == "*":
            entry_array[i-2] = int(entry_array[i-1]) * int(entry_array.pop(i-2))
            entry_array.pop(i-1)
            i = 0
        elif entry_array[i] == "/":
            entry_array[i-2] = int(entry_array[i-1]) / int(entry_array.pop(i-2))
            entry_array.pop(i-1)
            i = 0
        print(entry_array)
        i+=1
    return entry_array[0]

def main():
    entrada1 = "4\n8\n+\n3\n*"
    entrada2 = "10\n10\n+"
    print(reverse_polish_notation_solver(entrada1))
    print(reverse_polish_notation_solver(entrada2))

if __name__ == "__main__":
    main()