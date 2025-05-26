class A:
    def metoda(self):
        print("Metoda A")

class B(A):
    def metoda(self):
        print("Metoda B")

class C(A):
    def metoda(self):
        print("Metoda C")

class D(B, C):
    pass

obj = D()
obj.metoda()

print(D.__mro__)