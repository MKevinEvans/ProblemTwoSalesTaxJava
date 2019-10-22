package thoughtworks.codechallenge;

import java.math.BigDecimal;

public class Good {
    public boolean isImported;
    public boolean basicSalesTaxExempt;
    public BigDecimal price;
    public String name;
    public BasicSalesTax basicSalesTax;
    public ImportTax importTax;
    public BigDecimal totalTax;
    public BigDecimal priceWithTax;
    public BigDecimal quantity;

    public Good(boolean isImported, BigDecimal price, String name, BigDecimal quantity){
        this.isImported = isImported;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.bindToTaxes();
    }


    public void bindToTaxes(){
        this.importTax = new ImportTax(this);
        this.basicSalesTax = new BasicSalesTax(this);
        this.totalTax = this.applyTaxes();
        this.priceWithTax = this.getPriceWithTax();
    }

    private BigDecimal applyTaxes(){
        return this.basicSalesTax.apply().add(this.importTax.apply());
    }

    private BigDecimal getPriceWithTax(){
        return this.totalTax.add(this.price);
    }
}
