package ca.hccis.squash.entity;

/**
 * Entity class to hold the attributes of the external api call.
 * @author bjmaclean
 * @since 20261120
 */
public class ExternalApiEntity {
    private String input;
    private String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
