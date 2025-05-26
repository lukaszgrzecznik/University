import pickle
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
student1.notes = Note({"Matematyka": 5, "Biologia": 4, "Chemia": 3})

student2 = Student("Anna", "Nowak", 22, "54321")
student2.notes = Note({"Matematyka": 5, "Biologia": 4, "Chemia": 5})

class Group:
    def __init__(self, students):
        self.students = students

    def showGroup(self):
        for i, s in enumerate(self.students, 1):
            print(f"\n-- Student {i} --")
            print("Imię:", s.getName())
            print("Nazwisko:", s.getLastName())
            print("Wiek:", s.getAge())
            print("Indeks:", s.getIndexNr())
            if s.notes:
                print("Oceny:", s.notes.getNotes())


group = Group([student1, student2])
print("Grupa studentów: ")
group.showGroup()

def zapisywanie(group, filename):
    try:
        with open(filename, 'wb') as f:
            pickle.dump(group, f)
        print("Grupa zapisana.")
    except Exception as e:
        print("Błąd przy próbie zapisania:", e)

zapisywanie(group, "group.pkl")