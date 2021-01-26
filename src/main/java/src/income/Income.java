package src.income;

import exception.BusinessException;

public class Income {

    protected static final double BASE_INCOME=5000.0;

    protected double income;

    public double getIncome() {
        return income;
    }

    public Income(double income){
        this.income=income;
    }

    public double getTax() {
        if (income <= 5000) {
            return income * 0;
        }else {
            throw new BusinessException("基础收入不能大于5000！");
        }
    }
}
