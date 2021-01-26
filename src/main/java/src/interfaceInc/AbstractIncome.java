package src.interfaceInc;

import exception.BusinessException;

public class AbstractIncome implements InterfaceInc{

    protected static final double BASE_INCOME=5000.0;

    protected double income;

    public AbstractIncome(double income) {
        this.income=income;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public double getAbstractTax(){
        if (income <= 5000) {
            return income * 0;
        }else {
            throw new BusinessException("基础收入不能大于5000！");
        }
    }
}
