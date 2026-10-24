import java.util.Scanner;

class Card{
    private String rank;
    private String suit;

    Card(String rank,String suit)
    {
        this.rank=rank;
        this.suit=suit;
    }


    public String toString()
    {
        return rank + " of " + suit;
    }

    public boolean equals(Card c)
    {
        return rank.equals(c.rank) && suit.equals(c.suit);
    }
}

 class Main6
 {
    public static void main(String[] args) {

        Card[] cards = new Card[5];

        cards[0] = new Card("Ace", "Spades");
        cards[1] = new Card("King", "Hearts");
        cards[2] = new Card("Ace", "Spades");

        boolean duplicate = false;

        for (int i = 0; i < 2; i++) {
            if (cards[2].equals(cards[i])) {
                duplicate = true;
                break;
            }
        }

        if (duplicate)
            System.out.println("Duplicate found: " + cards[2]);
    }
}
