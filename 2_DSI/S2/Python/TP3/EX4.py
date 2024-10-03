def syracuse_sequence(n):
    if n == 1:
        return (1, 1, 1)

    if n % 2 == 0:
        next_term = n // 2
    else:
        next_term = 3 * n + 1

    initial_number, duration, altitude = syracuse_sequence(next_term)
    return (initial_number, duration + 1, max(altitude, next_term))

user_input = int(input("Enter a positive integer: "))

result = syracuse_sequence(user_input)

print("Initial number:", result[0])
print("Flight duration:", result[1])
print("Altitude:", result[2])
