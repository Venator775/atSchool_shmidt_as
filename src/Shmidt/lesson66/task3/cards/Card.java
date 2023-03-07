package Shmidt.lesson66.task3.cards;

public class Card {
    private CardType cardType;
    private CardSuit cardSuit;

    public Card(CardType cardType, CardSuit cardSuit) {
        this.cardType = cardType;
        this.cardSuit = cardSuit;
    }

    public Card() {
    }

    public int getPoints() {
        return this.cardType.getPoints();
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {
        String HEARTS = "♥";
        String CLUBS = "♣";
        String DIAMONDS = "♦";
        String SPADES = "♠";
        switch (this.cardSuit) {
//            case HEARTS: return HEARTS + this.cardType;
//            case CLUBS: return CLUBS + this.cardType;
//            case DIAMONDS: return DIAMONDS + this.cardType;
//            case SPADES: return SPADES + this.cardType;

            case HEARTS:return this.cardType + HEARTS;
            case CLUBS:return this.cardType + CLUBS;
            case DIAMONDS:return this.cardType + DIAMONDS;
            case SPADES:return this.cardType + SPADES;

            default:
                return this.cardType + " of " + this.cardSuit;
        }
    }
}
/*
класс Card
    находится в пакете cards
    содержит внутреннее поле тип карты CardType
    содержит внутреннее поле масть карты CardSuit

    общедоступный метод setCardType
        устанавливает значение типа карты
    общедоступный метод setCardSuit
        устанавливает значение масти
    общедоступный метод getPoints
        возвращает число очков карты
    общедоступный метод toString
        возвращает строку с типом и мастью карты (без очков)
 */