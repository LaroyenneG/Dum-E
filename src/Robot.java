import element.Element;

public abstract class Robot {

    private Element[] elements;

    public Robot(Element... elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();


        return new String(builder);
    }
}
