# Nieoczekiwane wyniki obliczeń, uzasadnij otrzymane wyniki dla podanych przypadków:
# 7. Porównać ze sobą wartości poniższych wyrażeń (zachować postać wyrażeń):
# a) (7.1 - 7)-0.1
# b) 7.1 - (7 + 0.1)

a = (7.1 - 7) - 0.1
b = 7.1 - (7 + 0.1)
print(a)  # Może wyjść np. -2.7755575615628914e-17
print(b)  # Może wyjść 0.0

# Wyjaśnienie:
# W wyrażeniu a) najpierw odejmujemy 7 od 7.1, co daje liczbę, która nie jest dokładnie 0.1 w reprezentacji binarnej, a potem odejmujemy 0.1, co powoduje powstanie bardzo małej liczby bliskiej zeru, ale nie dokładnie zera.
# W wyrażeniu b) suma 7 + 0.1 jest obliczana razem, a potem odejmowana od 7.1, co w tym przypadku daje dokładnie 0.0 (w granicach precyzji Pythona).

# Podsumowanie:
# Różnice wynikają z kolejności wykonywania operacji i niedokładności reprezentacji liczb zmiennoprzecinkowych