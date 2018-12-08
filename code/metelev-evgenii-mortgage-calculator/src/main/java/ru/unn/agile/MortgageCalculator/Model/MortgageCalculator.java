package ru.unn.agile.MortgageCalculator.Model;

public class MortgageCalculator {
    private static final String NOT_CORRECT_DATA =  "Not correct data";
    private double fullCostOfApartment;
    private double initialPayment = 0;
    private int dateOfMortgage = MONTHS_IN_YEAR;
    private double interestRate;
    private double[] fullPriceAsArray;
    private double[] accruedInterestAsArray;

    private static final int MONTHS_IN_YEAR = 12;
    private static final double IS_PERCENT = 0.01;
    private static final double HUNDRED = 100;

    public void setFullCostOfApartment(final double sum) {
        if (sum > 0) {
            fullCostOfApartment = sum;
        } else {
            throw new NullPointerException(NOT_CORRECT_DATA);
        }
    }

    public double getFullCostOfApartment() {
        return fullCostOfApartment;
    }

    public void setInitialPayment(final double firstPayment) {
        if (firstPayment >= 0 && firstPayment <= fullCostOfApartment) {
            initialPayment = firstPayment;
        } else {
            throw new NullPointerException(NOT_CORRECT_DATA);
        }
    }

    public double getInitialPayment() {
        return initialPayment;
    }

    public void setDateOfMortgage(final int date) {
        if (date > 0) {
            dateOfMortgage = date;
        } else {
            throw new NullPointerException("Date is negative!");
        }
    }

    public int getDateOfMortgage() {
        return dateOfMortgage;
    }

    public void setInterestRate(final double percent) {
        if (percent >= 0 && percent <= HUNDRED) {
            interestRate = percent;
        } else {
            throw new NullPointerException(NOT_CORRECT_DATA);
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getPrincipalDebt() {
        fullCostOfApartment -= initialPayment;
        return round(fullCostOfApartment / dateOfMortgage);
    }

    public double getAccruedInterest(final double balanceOfFullCost) {
        return round(balanceOfFullCost * interestRate * IS_PERCENT / MONTHS_IN_YEAR);
    }

    public double getFullPrice(final double balanceOfFullCost) {
        return round(getPrincipalDebt() + getAccruedInterest(balanceOfFullCost));
    }

    public void setAccruedInterestArray() {
        accruedInterestAsArray = new double[dateOfMortgage];
        double balance = 0;
        fullCostOfApartment -= initialPayment;
        for (int curMonth = 0; curMonth < dateOfMortgage; curMonth++) {
            accruedInterestAsArray[curMonth] =
                    getAccruedInterest(fullCostOfApartment - balance);
            balance += getPrincipalDebt();
        }
    }

    public double[] getAccruedInterestArray() {
        return accruedInterestAsArray;
    }

    public void setFullPriceArray() {
        setAccruedInterestArray();
        fullPriceAsArray = new double[dateOfMortgage];
        for (int curMonth = 0; curMonth < dateOfMortgage; curMonth++) {
            fullPriceAsArray[curMonth] =
                    accruedInterestAsArray[curMonth] + getPrincipalDebt();
        }
    }

    public double[] getFullPriceArray() {
        return fullPriceAsArray;
    }
    private double round(final double roundedNum) {
        return Math.round(roundedNum * HUNDRED) / HUNDRED;
    }

    public double getFullPriceForMortgage() {
        double fullSum = 0;
        for (int curMonth = 0; curMonth < dateOfMortgage; curMonth++) {
            fullSum += fullPriceAsArray[curMonth];
        }
        return fullSum;
    }
}
