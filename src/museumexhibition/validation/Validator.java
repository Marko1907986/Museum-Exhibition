package museumexhibition.validation;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface Validator {

    void validate(String object) throws ValidationException;
}
