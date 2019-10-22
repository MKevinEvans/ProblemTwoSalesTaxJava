package thoughtworks.codechallenge;

import java.math.BigDecimal;

public class ImportTax extends Tax {

    public ImportTax(Good good) {
        this.bindToGood(good);
        this.amount = this.findAmount();
    }

    private BigDecimal findAmount(){
        if(this.boundGood.isImported)
            return new BigDecimal("5.00");
        else
            return new BigDecimal("0.00");
    }
}

