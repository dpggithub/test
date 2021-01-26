package src.income;

public class AbstractStateCouncilSpecialAllowance extends AbstractIncome{

    public AbstractStateCouncilSpecialAllowance(double income){
        super(income);
    }

    @Override
    public double getAbstractTax(){
        return 0;
    }
}
