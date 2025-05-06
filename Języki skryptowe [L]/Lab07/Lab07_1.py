class A:
    def metoda(self):
        print("Metoda A")

class B:
    def metoda(self):
        print("Metoda B")

class C(A, B):
    pass

obj = C()
obj.metoda()

print(C.__mro__)