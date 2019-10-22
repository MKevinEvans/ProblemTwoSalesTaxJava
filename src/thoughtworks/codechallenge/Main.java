package thoughtworks.codechallenge;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IllegalAccessException {
        List <String> desiredBasketReceipts = Arrays.asList("Input 1:", "Input 2:", "Input 3:");

        new TxtFileAdaptor("input.txt");
        for(Basket basket: Basket.allBaskets){
            if(desiredBasketReceipts.contains(basket.inputTitle))
                new Receipt(basket);
        }
    }
}
