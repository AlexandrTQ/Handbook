package alexandr.service;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    private final String numberPattern = "[ABEKMHOPCTY]{2}[0-9]{3}[ABEKMHOPCTY][0-9]{2}";

    public boolean incorrectNumber(String number) {
        return !number.matches(numberPattern);
    }

}
