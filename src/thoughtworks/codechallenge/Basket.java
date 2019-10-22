package thoughtworks.codechallenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Basket {
    public Good[] items;
    public String outputTitle;
    public String inputTitle;
    public static ArrayList<Basket> allBaskets = new ArrayList<>();

    public  Basket(){
    }

    public Basket(String[] basketInput){
        this.inputTitle = basketInput[0];
        this.outputTitle = this.createOutputTitle(this.inputTitle);
        this.items = this.parseItems(basketInput);
        allBaskets.add(this);
    }

    private String createOutputTitle(String inputTitle){
        return inputTitle.replace("Input", "Output");

    }

    private Good[] parseItems(String[] basketInput){
        BigDecimal quantity;
        BigDecimal price;
        String name;

        Good[] items = new Good[(basketInput.length-1)];
        String [] basketInputItems = Arrays.copyOfRange(basketInput, 1, basketInput.length);
        GoodsFactory factory = new GoodsFactory();
        for(int i = 0; i<basketInputItems.length; i++){
            String line = basketInputItems[i];
            String [] lineItems = line.split(" ");
            int atIndex = findAt(lineItems);
            quantity = new BigDecimal(lineItems[0]);
            String[] segment = Arrays.copyOfRange(lineItems, 1, atIndex);
            name = String.join(" ", segment);
            boolean isImported = this.checkImported(name);
            name = name.replace("imported ", "");
            price = new BigDecimal(lineItems[atIndex+1]);
            items[i] = factory.makeGood(isImported, price, name, quantity);
        }
        return items;
    }

    private static int findAt(String [] array){
        int result = -1;
        for(int i = 0; i < array.length; i++){
            if (array[i].equals("at"))
                result = i;
        }
        return result;
    }

    private boolean checkImported(String name){
        return name.contains("imported");
    }
}
