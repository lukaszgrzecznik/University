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
    def __init__(self, name, last_name, age, IndexNr):
        super().__init__(name, last_name, age)
        self.IndexNr = IndexNr

    def getIndexNr(self):
        return self.IndexNr

class Note:
    def __init__(self, notes):
        self.notes = notes

    def getNotes(self):
        return self.notes

Student.notes = None

student1 = Student("Jan", "Kowalski", 21, "12345")
student1.notes = Note({"Matematyka": 5, "Biologia": 4,"Chemia": 3})

student2 = Student("Anna", "Nowak", 22, "54321")
student2.notes = Note({"Matematyka": 5, "Biologia": 4,"Chemia": 5})

print("Student 1 oceny:", student1.notes.getNotes())
print("Student 2 oceny:", student2.notes.getNotes())