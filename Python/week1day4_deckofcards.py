import random

class Deck(object):
    def __init__(self):
        self.cards = []
        for i in "Spades Diamonds Clubs Hearts".split(" "):
            for j in "2 3 4 5 6 7 8 9 Jack Queen King".split(" "):
                self.cards.append("{} of {}".format(j,i))
    def shuffle(self):
        random.shuffle(self.cards)
    def deal(self,player):
        player.hand.append(self.cards.pop())
    def show(self):
        print self.cards

class Player(object):
    def __init__(self,name,hand):
        self.name = name
        self.hand = hand
    def discard(self):
        self.hand = []

myDeck = Deck()
myDeck.shuffle()