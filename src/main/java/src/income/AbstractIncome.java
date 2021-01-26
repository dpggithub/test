package src.income;

public abstract class AbstractIncome {

    protected static final double BASE_INCOME=5000.0;

    protected double income;

    public AbstractIncome(double income) {
        this.income=income;
    }

    public double getIncome() {
        return income;
    }

    public abstract double getAbstractTax();
}
