# Zapisać w systemie dwójkowym, ósemkowym (oktalnym) i szesnastkowym (heksadecymalnym) liczby systemu dziesiętnego:
# a) 24
# b) 232
# c) 1025
# d) 4^6 - 1
# e) 125,625
# f) 0,325

# Konwersja części ułamkowej do wybranego systemu
def frac_to_base(frac, base, precision=8):
    result = []
    for _ in range(precision):
        frac *= base
        digit = int(frac)
        result.append("0123456789ABCDEF"[digit])
        frac -= digit
    return ''.join(result)

def float_to_base(num, base, precision=8):
    int_part = int(num)
    frac_part = num - int_part
    if base == 2:
        int_str = bin(int_part)[2:]
    elif base == 8:
        int_str = oct(int_part)[2:]
    elif base == 16:
        int_str = hex(int_part)[2:].upper()
    else:
        raise ValueError("Obsługiwane są tylko bazy 2, 8, 16")
    if frac_part > 0:
        frac_str = frac_to_base(frac_part, base, precision)
        return f"{int_str},{frac_str}"
    else:
        return int_str

liczby = [24, 232, 1025, 4**6 - 1, 125.625, 0.325]
for liczba in liczby:
    print(f"Liczba: {liczba}")
    print("System binarny:", float_to_base(liczba, 2))
    print("System ósemkowy:", float_to_base(liczba, 8))
    print("System szesnastkowy:", float_to_base(liczba, 16))
    print()