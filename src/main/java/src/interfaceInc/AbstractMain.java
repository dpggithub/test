package src.interfaceInc;

public class AbstractMain {
    public static void main(String[] args) {

       src.interfaceInc.AbstractIncome[] incomes = new AbstractIncome[]{
                new AbstractIncome(5000),
                new AbstractSalary(7425.8),
                new AbstractStateCouncilSpecialAllowance(15000.5),
        };
        System.out.print("totalTax= ");
        System.out.printf("%.4f\n",totalTax(incomes));
        totalIncomeAfterTax(incomes);
    }

    public static double totalTax(AbstractIncome...incomes){
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
        double totalAt=total-totalTax(incomes)-incomes[0].getIncome();
        System.out.printf("%.4f\n",totalAt);
        return totalAt;
    }
}
