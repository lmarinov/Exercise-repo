package WorkingWithAbstraction.Exercise.CardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = calculatePower();
    }

    private int calculatePower() {
        return this.getSuit().getValue() + this.getRank().getValue();
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.getRank().name(),
                this.getSuit().name(),
                this.getPower());
    }
}
