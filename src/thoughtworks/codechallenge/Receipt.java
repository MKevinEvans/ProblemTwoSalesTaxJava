package thoughtworks.codechallenge;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Receipt {
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    private BigDecimal totalTax;
    private BigDecimal total;
    private String outputTitle;
    private String totalTaxDisplay;
    private String totalDisplay;
    private String[] itemsDisplay;



    public Receipt(Basket basket){
        this.outputTitle = basket.outputTitle;
        this.itemsDisplay = this.parseItems(basket);
        this.totalTaxDisplay = df.format(this.totalTax);
        this.totalDisplay = df.format(this.total);
        this.printReceipt();
    }

    private String[] parseItems(Basket basket){
        this.totalTax = new BigDecimal("0");
        this.total = new BigDecimal("0");
        itemsDisplay = new String[basket.items.length];
        int count = 0;
        for(Good item : basket.items){
            this.totalTax = item.totalTax.add(this.totalTax);
            this.total = this.total.add(item.priceWithTax.multiply(item.quantity));
            String importedText = item.isImported ? "imported " : "";
            itemsDisplay[count] = item.quantity+" " + importedText + item.name + ": " + df.format(item.priceWithTax.multiply(item.quantity));
            count++;
        }
        return itemsDisplay;
    }

    private void printReceipt(){
        System.out.println(this.outputTitle);
        for(String item : this.itemsDisplay){
            System.out.println(item);
        }
        System.out.println("Sales Taxes: " + this.totalTaxDisplay);
        System.out.println("Total: " + this.totalDisplay);
        System.out.println();
    }
}
