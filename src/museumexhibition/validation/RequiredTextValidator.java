package museumexhibition.validation;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class RequiredTextValidator implements Validator {

    @Override
    public void validate(String object) throws ValidationException {
        if (object == null) {
            throw new ValidationException("Value is null!");
        }
        if (object.isEmpty()) {
            throw new ValidationException("Value is empty!");
        }
    }

}
