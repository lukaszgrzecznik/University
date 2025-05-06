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


class Student(Person):
    def __init__(self, name, last_name, age, indexNr):
        super().__init__(name, last_name, age)
        self.indexNr = indexNr
        self.notes = None

    def getIndexNr(self):
        return self.indexNr


class Note:
    def __init__(self, notes):
        self.notes = notes

    def getNotes(self):
        return self.notes

student1 = Student("Jan", "Kowalski", 21, "12345")
student1.notes = Note({"Matematyka": 5, "Biologia": 4, "Chemia": 3, "Historia": 4})

student2 = Student("Anna", "Kowalska", 22, "67890")
student2.notes = Note({"Matematyka": 5, "Biologia": 4, "Chemia": 5, "Historia": 3})

class Group:
    def __init__(self, students):
        self.students = students

    def showGroup(self):
        for i, grupa in enumerate(self.students, 1):
            print(f"\n-- Student {i} --")
            print("Imię:", grupa.getName())
            print("Nazwisko:", grupa.getLastName())
            print("Wiek:", grupa.getAge())
            print("Indeks:", grupa.getIndexNr())
            if grupa.notes:
                print("Oceny:", grupa.notes.getNotes())

grupa = Group([student1, student2])
print("Grupa studentów: ")
grupa.showGroup()
