package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate<Object>> requirements = new HashMap<>();

    protected final void addRequirement(String key, Predicate<Object> requirement) {
        requirements.put(key, requirement);
    }

    public final boolean isValid(Object obj) {
        for (Predicate<Object> requirement: requirements.values()) {
            if (!requirement.test(obj)) {
                return false;
            }
        }
        return true;
    }
}
