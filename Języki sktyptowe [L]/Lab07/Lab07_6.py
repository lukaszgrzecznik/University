class Person:
    def __init__(self, name, last_name, age, **kwargs):
        super().__init__(**kwargs) # **kwargs aby argumenty się nie zatrzymywały, bez tego program nie działa
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
    def __init__(self, indexNr, **kwargs):
        super().__init__(**kwargs)
        self.indexNr = indexNr
        self.notes = None

    def getIndexNr(self):
        return self.indexNr


class Employee(Person):
    def __init__(self, salary, position, **kwargs):
        super().__init__(**kwargs)
        self.salary = salary
        self.position = position


class WorkingStudent(Student, Employee):
    def __init__(self, name, last_name, age, indexNr, salary, position):
        super().__init__(
            name=name,
            last_name=last_name,
            age=age,
            indexNr=indexNr,
            salary=salary,
            position=position
        )

ws = WorkingStudent("Tomasz", "Lewandowski", 24, "67890", 4000, "Developer")
print(ws.getName(), ws.getLastName(), ws.getAge(), ws.getIndexNr(), ws.salary, ws.position)
