package src.income;

public class AbstractSalary extends AbstractIncome {

    public AbstractSalary(double income){
        super(income);
    }

    @Override
    public double getAbstractTax() {
        if(income<=5000){
            return 0;
        }
        return (income-BASE_INCOME)*0.2;
    }
}
