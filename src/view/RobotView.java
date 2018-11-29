package view;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.Canvas3D;
import javax.swing.*;

public class RobotView extends JFrame {

    private static final int DEFAULT_WIDTH = 150;
    private static final int DEFAULT_HEIGHT = 150;

    private Canvas3D canvas3D;

    public RobotView(String name) {

        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        add(canvas3D);

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
/*
    @Override
    public void repaint() {
        canvas3D.preRender();
    }
*/


    public Canvas3D getCanvas3D() {
        return canvas3D;
    }
}
