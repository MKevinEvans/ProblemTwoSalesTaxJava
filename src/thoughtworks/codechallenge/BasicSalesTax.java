package thoughtworks.codechallenge;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BasicSalesTax extends Tax {
    private List <String> exemptItems = Arrays.asList(
            "book", "box of chocolates", "chocolate bar", "packet of headache pills"
    );

    public BasicSalesTax(Good good) {
        this.bindToGood(good);
        this.checkIfExempt();
        this.amount = this.findAmount();
    }

    private void checkIfExempt(){
        if(exemptItems.contains(this.boundGood.name))
            this.boundGood.basicSalesTaxExempt = true;
        else
            this.boundGood.basicSalesTaxExempt = false;
    }

    private BigDecimal findAmount(){
        if(this.boundGood.basicSalesTaxExempt)
            return new BigDecimal("0.00");
        else
            return new BigDecimal("10.00");
    }
}
