class Shoe(object):
    def __init__(self,brand,model,color,size):
        self.brand  = brand
        self.model  = model
        self.color  = color
        self.size   = size
        self.tied   = False
        self.steps  = 0

    def tie(self):
        self.tied = True
        print "{} {}'s laces are now tied, phew!\n".format(self.brand,self.model)

    def untie(self):
        self.tied = False
        print "{} {}'s laces have been untied! Watch your step!\n".format(self.model,self.brand)

    def run(self):
        if not self.tied:
            print "{} {}'s must be tied in order to run!\n".format(self.model,self.brand)
            return

        self.steps += 1
        print "{} {}'s are somehow running! {} steps have been taken so far!\n".format(self.brand,self.model,self.steps)
        return self

    def display(self):
        print "Brand: {}\nModel:{}\nColor:{}\nSize:{}\nLaces Tied:{}\n".format(
            self.brand,
            self.model,
            self.color,
            self.size,
            self.tied
        )

# Nike = Shoe(
#     "Nike",
#     "Air",
#     "White",
#     12
# )
# Nike.display()

# Jordan = Shoe(
#     "Jordan",
#     "Air",
#     "Blue",
#     11
# )
# Jordan.run()

# Tims = Shoe(
#     "Timberland",
#     "Classic",
#     "Brown",
#     10
# )
# Tims.tie()
# Tims.run().run().run()

###############################################################

class Dog(object):
    def __init__(self,name,breed,sound):
        self.name  = name
        self.breed = breed
        self.sound = sound

    def bark(self):
        print "{} says {}".format(self.name,self.sound)

class Chihuahua(Dog):
    def __init__(self,name,breed,sound):

        super(Chihuahua,self).__init__(name,breed,sound);

    def bark(self):
        print self.name+" the "+self.breed+" says *"+self.sound.lower()+"*";

class Mastiff(Dog):
    def __init__(self,name,breed,sound):
        super(Mastiff,self).__init__(name,breed,sound);

    def bark(self):
        print self.name+" the "+self.breed+" says *"+self.sound.upper()+"*";

# chihuahua = Chihuahua(
#     "Peanut",
#     "Chihuahua",
#     "RUFF"
# )
# chihuahua.bark()

# mastiff = Mastiff(
#     "Macho",
#     "Mastiff",
#     "rawr"
# )
# mastiff.bark()

###############################################################

def myVarArgs(*args):
    for i in args:
        print i
# myVarArgs(20,30,40)

def myKwargs(**args):
    for i in args:
        if i == "firstName":
            print "First Name: "+args[i]
        elif i == "lastName":
            print "Last Name: "+args[i]        
        elif i == "address":
            print "Address: "+args[i]

myKwargs(
    firstName="John",
    lastName="Smith",
    address="123 Dojo Ave."
)