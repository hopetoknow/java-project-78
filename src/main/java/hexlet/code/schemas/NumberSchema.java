package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    private boolean isPositive;
    private boolean isRange;
    private int rangeStart;
    private int rangeEnd;

    @Override
    public boolean isValid(Object obj) {
        if (!getIsRequired() && obj == null) {
            return true;
        }

        if (!(obj instanceof Integer number)) {
            return false;
        }

        if (isPositive) {
            setIsValid(number > 0);
        }

        if (isRange) {
            setIsValid((number >= rangeStart) && (number <= rangeEnd));
        }

        return getIsValid();
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(int start, int end) {
        this.isRange = true;
        this.rangeStart = start;
        this.rangeEnd = end;
        return this;
    }
}
