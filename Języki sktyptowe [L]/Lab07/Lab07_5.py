class Person:
    def __init__(self, name, last_name, age):
        self.name = name
        self.last_name = last_name
        self.age = age

    def getName(self):
        return self.name

    def getLastName(self):
        return self.last_name

    def getAge(self):
        return self.age

class Employee(Person):
    def __init__(self, name, last_name, age, salary, position, index):
        super().__init__(name, last_name, age)
        self.salary = salary
        self.position = position
        self.index = index

pracownik = Employee("Jan", "Kowalski", 30, 3500, "Magazynier", 344)
print("--- Pracownik ---")
print("Imię: ", pracownik.getName())
print("Nazwisko: ", pracownik.getLastName())
print("Wiek: ", pracownik.getAge())
print("Płaca: ", pracownik.salary)
print("Stanowisko: ", pracownik.position)
print("Indeks: ", pracownik.index)