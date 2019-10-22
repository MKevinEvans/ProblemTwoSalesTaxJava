package thoughtworks.codechallenge;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tax {
    BigDecimal amount;
    Good boundGood;

    public void bindToGood(Good good){
        this.boundGood = good;
    }

    private BigDecimal round(BigDecimal tax){
        //      multiply tax by 20 and round
        BigDecimal tempMultiplyBy20 = tax.multiply(new BigDecimal(20)).setScale(0, RoundingMode.UP);
//      divide by 20 for finalTax
        return tempMultiplyBy20.divide(new BigDecimal(20));
    }

    public BigDecimal apply(){
        return this.round((this.boundGood.price.multiply(this.amount)).divide(new BigDecimal("100")));
    }
}
