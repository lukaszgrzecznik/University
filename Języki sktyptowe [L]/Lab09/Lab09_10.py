# 10. W wyniku wystąpienia zjawiska zaokrąglenia liczba 0,2 została zapisana w pamięci maszynowej
# jako 0,1875. Wyznaczyć popełniony błąd bezwzględny i względny. Czy można oszacować na
# podstawie policzonych błędów dokładność reprezentacji zmiennoprzecinkowej użytej maszyny
# cyfrowej (ilość bitów mantysy)?

# Błąd bezwzględny to różnica między wartością rzeczywistą a zapisaną:
# błąd_bezwzględny = |0,2 - 0,1875| = 0,0125

# Błąd względny to stosunek błędu bezwzględnego do wartości rzeczywistej:
# błąd_względny = 0,0125 / 0,2 = 0,0625 (czyli 6,25%)

# Na podstawie błędu względnego można oszacować dokładność mantysy.
# 0,1875 = 3/16, czyli mantysa ma 3 bity (0,0011 w binarnym = 0,1875).
# Tak duży błąd oznacza bardzo małą liczbę bitów mantysy (niska precyzja).
# Im więcej bitów mantysy, tym mniejszy błąd względny.