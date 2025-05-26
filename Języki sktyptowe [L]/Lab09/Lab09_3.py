# [-512, 511]
# 2^9 - 1
# [-2^d, 2^d - 1]

# 1. `[-512, 511]`
# To jest zakres liczb całkowitych ze znakiem zapisanych na 10 bitach w systemie stałopozycyjnym (jeden bit na znak, 9 bitów na wartość):
# - Najmniejsza liczba: \(-2^{9} = -512\)
# - Największa liczba: \(2^{9} - 1 = 511\)

# 2. `2^9 - 1`
# To jest największa liczba dodatnia, jaką można zapisać na 10 bitach ze znakiem (czyli 511).

# 3. `[-2^d, 2^d - 1]`
# To jest ogólna postać zakresu dla liczby całkowitej ze znakiem na \(d+1\) bitach (1 bit na znak, \(d\) bitów na wartość).

# Dla zapisu zmiennopozycyjnego z mantysą 5-bitową zakres zależy od sposobu kodowania wykładnika i mantysy, ale nie jest to bezpośrednio żaden z powyższych wyników — zakres będzie znacznie większy, ale precyzja mniejsza (więcej liczb "rozrzuconych" po osi liczbowej).

# Podsumowanie dopasowania:
# - `[-512, 511]` — stałopozycyjny, 10 bitów, liczby całkowite ze znakiem
# - `2^9 - 1` — największa liczba dodatnia w tym systemie
# - `[-2^d, 2^d - 1]` — ogólna postać zakresu dla \(d+1\) bitów ze znakiem