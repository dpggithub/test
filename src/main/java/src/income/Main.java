package src.income;

public class Main {

    public static void main(String[] args) {

        Income[] incomes = new Income[]{
                new Income(5000),
                new Salary(7425.8),
                new StateCouncilSpecialAllowance(15000.5),
        };
        System.out.print("totalTax= ");
        System.out.printf("%.4f\n",totalTax(incomes));
        totalIncomeAfterTax(incomes);
    }

    public static double totalTax(Income ...incomes){
        double total = 0;

        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }

    public static double totalIncomeAfterTax(Income...incomes){
        double total=0;
        for(Income income: incomes){
            total=total+income.getIncome();
        }
        System.out.print("total= ");
        System.out.printf("%.4f\n",total-totalTax(incomes)-incomes[0].getIncome());
        return total-totalTax(incomes)-incomes[0].getIncome();
    }
}
