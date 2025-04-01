package ra.validate;

public class StringRule {
    private final int min;
    private final int max;

    public StringRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isValidString(String value) {
        if (value == null) {
            return false;
        }
        return value.length() >= this.min && value.length() <= this.max;
    }
}
