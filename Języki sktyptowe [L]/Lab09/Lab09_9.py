# Nieoczekiwane wyniki obliczeń, uzasadnij otrzymane wyniki dla podanych przypadków:
# 9. Sprawdzić i interpretować wynik działania: sqrt(1e-16 + 1) -1 = ?

import numpy as np

x = 1e-16
wynik = np.sqrt(1 + x) - 1
print("Wynik:", wynik)
print("Oczekiwany (przybliżony):", x / 2)
print("Błąd bezwzględny:", abs(wynik - x / 2))

# Interpretacja:
# Wynik nie jest dokładny z powodu ograniczonej precyzji obliczeń zmiennoprzecinkowych i utraty cyfr znaczących przy odejmowaniu liczb bliskich sobie. To typowy przykład problemów numerycznych w obliczeniach komputerowych.