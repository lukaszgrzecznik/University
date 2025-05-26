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

student = Student("Jan", "Kowalski", 17, "123")
print("Student: ", student.getName(), student.getLastName(), student.getAge(), student.getIndexNr())