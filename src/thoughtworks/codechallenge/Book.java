package thoughtworks.codechallenge;

import java.math.BigDecimal;

public class Book extends Good {

    public Book(boolean isImported, BigDecimal price, String name, BigDecimal quantity){
        super (isImported, price, name, quantity);
    }

}
