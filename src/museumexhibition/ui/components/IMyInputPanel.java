package museumexhibition.ui.components;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface IMyInputPanel {

    void setStaticText(String text);

    void setInputText(String text);

    void setErrorText(String text);

    default void init(String staticText, String inputText, String errorText) {
        setStaticText(staticText);
        setInputText(inputText);
        setErrorText(errorText);
    }

    String getValue() throws Exception;
}
