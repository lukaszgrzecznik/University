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
student1.notes = Note({"Math": 5, "Physics": 4, "Chemistry": 3})

student2 = Student("Anna", "Nowak", 22, "54321")
student2.notes = Note({"Biology": 5, "English": 4, "PE": 5})

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

def ladowanie(filename):
    try:
        with open(filename, 'rb') as f:
            group = pickle.load(f)
            print("Grupa załadowana.")
            group.showGroup()
    except Exception as e:
        print("Błąd podczas ładowania grupy:", e)

ladowanie("group.pkl")
ladowanie("grupaa.txt")