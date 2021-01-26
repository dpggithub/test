package src.income;

public class Salary extends Income {

    public Salary(double income){
        super(income);
    }

    @Override
    public double getTax(){
        if(income<=5000){
            return 0;
        }
        return (income-BASE_INCOME)*0.2;
    }
}
