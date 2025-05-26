# 0,25 (dec) = 01 (bin)
# 25/100 = 1/4 = 2^-2

# 1. **Zapis stałopozycyjny (fixed-point):**
# Liczba \(-245{,}25\) w systemie binarnym:
# - Część całkowita: 245 = 11110101₂
# - Część ułamkowa: 0,25 = 0,01₂
# Zatem: \(245{,}25_{10} = 11110101{,}01_2\)
# Znak: 1 (liczba ujemna)
# Zapis: \(-245{,}25_{10} = -11110101{,}01_2\)

# 2. **Zapis zmiennopozycyjny (floating-point):**
# Przedstawiamy liczbę w postaci:
# \(-1 \cdot 1{,}111010101 \cdot 2^7\)
# gdzie:
# - mantysa: 1,111010101
# - wykładnik: 7 (bo 245 = 11110101₂, czyli 8 bitów, więc przesuwamy przecinek o 7 pozycji)

# 3. **Minimalna liczba bitów:**
# - Znak: 1 bit
# - Część całkowita: 8 bitów (245)
# - Część ułamkowa: 2 bity (0,25)
# - Razem: 1 + 8 + 2 = **11 bitów** (stałopozycyjny)
# W zmiennopozycyjnym:
# - Znak: 1 bit
# - Mantysa: 9 bitów (1 + 8 cyfr)
# - Wykładnik: 4 bity (do zakodowania wartości 7)
# - Razem: 1 + 9 + 4 = **14 bitów**

# **Podsumowanie:**
# - Stałopozycyjny: \(-11110101{,}01_2\), min. 11 bitów
# - Zmiennopozycyjny: \(-1 \cdot 1{,}111010101 \cdot 2^7\), min. 14 bitów