package automationpractice;

public class Calculator {

    public float divide(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException("cannot divide by 0!");
        }
        return a / b;
    }
}
