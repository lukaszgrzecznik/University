# Napisz funkcję dectobin nie używając wbudowanych funkcji w Pythonie, która zamieni
# podaną jako parametr liczbę całkowitą w systemie dziesiętnym na liczbę w systemie binarnym.
# Funkcja ma zwrócić tą liczbę w systemie binarnym.

def dectobin(n):
    if n == 0:
        return '0'
    result = ''
    negative = n < 0
    n = abs(n)
    while n > 0:
        result = str(n % 2) + result
        n = n // 2
    if negative:
        result = '-' + result
    return result

n = 18
wynik = dectobin(n)
print(f'Liczba {n} w systemie binarnym to: {wynik}')