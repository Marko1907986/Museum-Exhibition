package museumexhibition.validation;

import java.text.*;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class RequiredDateValidator implements Validator {

    private final DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");

    @Override
    public void validate(String object) throws ValidationException {
        if (object == null || object.isEmpty()) {
            throw new ValidationException("Date value is required!");
        }
        try {
            df.parse(object);
        } catch (ParseException ex) {
            throw new ValidationException("Date value must use dd.MM.yyyy. pattern!");
        }
    }

}
