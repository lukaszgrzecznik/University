# 11101010
# x = S * 2^c * m
# m = 1010
# c = 10
# S = -
# m = 1 * 2^-1 + 0 * 2^-2 + 1 * 2^-3 + 0 * 2^-4 = 1/2 + 0 + 1/8 + 0 = 5/8
# c = 0 * 2^0 + 1 * 2^1 = 2
# x = -2^2 * 5/8 = -2,5

def bin_to_float(bits: str) -> float:
    if len(bits) != 8:
        raise ValueError("Input must be 8 bits")
    sign = -1 if bits[0] == "1" else 1
    exponent = int(bits[2:4], 2)
    mantissa_val = int(bits[4:], 2) / 16  # 4 bits: .xxxx
    value = sign * (2 ** exponent) * mantissa_val
    return value

przyklady = [
    "10101101",
    "11101010",
    "01001000",
    "01111011",
    "01000111",
]

for val in przyklady:
    result = bin_to_float(val)
    explanation = ""
    mantissa = int(val[3:], 2)
    if mantissa == 0:
        explanation = " (mantysa równa zero, więc wartość to zero)"
    elif int(val[1:3], 2) == 0 and mantissa != 0:
        explanation = " (cecha równa zero, więc wartość to tylko mantysa ze znakiem)"
    print(f"{val} = {result}{explanation}")