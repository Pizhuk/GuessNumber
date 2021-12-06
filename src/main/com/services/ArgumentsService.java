package main.com.services;

public class ArgumentsService {
    int min;
    int max;
    int amountOfAttempts;

    public ArgumentsService(int min, int max, int amountOfAttempts) {
        if (min < 1 || max > 200 || min > max || amountOfAttempts < 1 || amountOfAttempts > 15) {
            throw new IllegalArgumentException("Min should be >= 1, max should be <= 200, min should be <= max," +
                    " Amount of attempts should be >= 1 and <=15");
        }
        else {
            this.min = min;
            this.max = max;
            this.amountOfAttempts = amountOfAttempts;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getAmountOfAttempts() {
        return amountOfAttempts;
    }

}
