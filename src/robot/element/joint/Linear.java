package robot.element.joint;

public abstract class Linear extends Joint {

    private int value;

    public Linear(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = (value < 0) ? value : 0;
    }
}
