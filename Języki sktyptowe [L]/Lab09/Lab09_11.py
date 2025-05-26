# Nieoczekiwane wyniki obliczeń, uzasadnij otrzymane wyniki dla podanych przypadków:
# 11. Wartość eps można znaleźć również interakcyjnie w sposób przybliżony, korzystając z definicji -
# startujemy od pewnej wartości poszukiwanej zmiennej, np. epsilon = 1, a następnie dzielimy ja
# na pół tak długo, aż po dodaniu do jedności wynik nie zmieni się (tzn. 1+epsilon = 1). Należy
# napisać skrypt w pytonie wyznaczający precyzję maszynowa wykonywanych obliczeń.

import numpy as np

epsilon = 1.0
while 1.0 + epsilon != 1.0:
    epsilon /= 2

print("Maszynowa precyzja (epsilon):", epsilon * 2)
print("Porównanie z numpy.finfo(float).eps:", np.finfo(float).eps)