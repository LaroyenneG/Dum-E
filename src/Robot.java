import element.Element;

import java.util.List;

public abstract class Robot {

    private Element[] elements;

    public Robot(List<Element> elementList) {
        elements = (Element[]) elementList.toArray();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();


        return new String(builder);
    }
}
