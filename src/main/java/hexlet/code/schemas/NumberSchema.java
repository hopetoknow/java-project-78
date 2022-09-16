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

        if (isPositive && !(number > 0)) {
            return false;
        }

        if (isRange && !((number >= rangeStart) && (number <= rangeEnd))) {
            return false;
        }

        return true;
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
