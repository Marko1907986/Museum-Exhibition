package museumexhibition.validation;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class RequiredDurationInDaysValidator implements Validator {

    @Override
    public void validate(String object) throws ValidationException {
        if (object == null || object.isEmpty()) {
            throw new ValidationException("Duration in days value is required!");
        }
        try {
            Integer.parseInt(object);
            if (Integer.parseInt(object) <= 0) {
                throw new ValidationException("Duration in days must be at least 1 day!");
            }
        } catch (NumberFormatException e) {
            throw new ValidationException("Duration in days must be a number!");
        }
    }

}
