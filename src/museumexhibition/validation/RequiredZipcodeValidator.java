package museumexhibition.validation;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class RequiredZipcodeValidator implements Validator {

    @Override
    public void validate(String object) throws ValidationException {
        if (object == null || object.isEmpty()) {
            throw new ValidationException("Zipcode value is required!");
        }
        try {
            Long.parseLong(object);
        } catch (NumberFormatException e) {
            throw new ValidationException("Zipcode must be a number!");
        }
    }

}
