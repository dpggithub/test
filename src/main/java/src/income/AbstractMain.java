package src.income;

import exception.BusinessException;

public class AbstractMain {

    public static void main(String[] args) {

        AbstractIncome[] incomes = new AbstractIncome[]{
                new AbstractIncome(5000) {
                    @Override
                    public double getAbstractTax() {
                        if (income <= 5000) {
                            return income * 0;
                        }else {
                            throw new BusinessException("基础收入不能大于5000！");
                        }
                    }
                },
                new AbstractSalary(7425.8),
                new AbstractStateCouncilSpecialAllowance(15000.5),
        };
        System.out.print("totalTax= ");
        System.out.printf("%.4f\n",totalTax(incomes));
        totalIncomeAfterTax(incomes);
    }

    public static double totalTax(AbstractIncome ...incomes){
        double total = 0;

        for (AbstractIncome income : incomes) {
            total = total + income.getAbstractTax();
        }
        return total;
    }

    public static double totalIncomeAfterTax(AbstractIncome...incomes){
        double total=0;
        for(AbstractIncome income: incomes){
            total=total+income.getIncome();
        }
        System.out.print("total= ");
        System.out.printf("%.4f\n",total-totalTax(incomes)-incomes[0].getIncome());
        return total-totalTax(incomes)-incomes[0].getIncome();
    }
}
