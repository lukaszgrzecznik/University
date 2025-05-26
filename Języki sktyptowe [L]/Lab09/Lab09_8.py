# Nieoczekiwane wyniki obliczeń, uzasadnij otrzymane wyniki dla podanych przypadków:
# 8. Korzystając z funkcji pakietu numpy sprawdzić wartość stałej , oraz wartość funkcji sin():
# pi
# wynik = sin(pi)
# Czy wynik jest równy 0? Jaki jest błąd?

import numpy as np

pi = np.pi
wynik = np.sin(pi)
print("pi =", pi)
print("sin(pi) =", wynik)
print("Czy wynik jest równy 0?", wynik == 0)
print("Błąd bezwzględny:", abs(wynik))

# Wyjaśnienie:
# Wynik sin(pi) nie jest dokładnie 0, lecz bardzo bliską zeru liczbą (np. 1.2246467991473532e-16). Wynika to z niedokładności reprezentacji π oraz obliczeń na liczbach zmiennoprzecinkowych. Błąd ten to tzw. błąd numeryczny (zaokrągleń).