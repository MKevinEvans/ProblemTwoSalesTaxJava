package thoughtworks.codechallenge;

import java.math.BigDecimal;

public class GoodsFactory {

    public GoodsFactory() {
    }

    public Good makeGood(boolean isImported, BigDecimal price, String name, BigDecimal quantity) {
        Good result;
        switch (name) {
            case "book":
                result = new Book(isImported, price, name, quantity);
            break;
            case "box of chocolates":
                result = new BoxOfChocolates(isImported, price, name, quantity);
            break;
            case "music CD":
                result = new MusicCD(isImported, price, name, quantity);
            break;
            case "chocolate bar":
                result = new ChocolateBar(isImported, price, name, quantity);
            break;
            case "bottle of perfume":
                result = new ChocolateBar(isImported, price, name, quantity);
                break;
            case "packet of headache pills":
                result = new ChocolateBar(isImported, price, name, quantity);
                break;
            default:
                result = new Good(isImported, price, "Good Not Found", quantity);
        }
        return result;
    }
}
