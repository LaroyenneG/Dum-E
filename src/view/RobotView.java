package view;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.Canvas3D;
import javax.swing.*;
import java.awt.*;

public class RobotView extends JFrame {

    private static final int DEFAULT_WIDTH = 550;
    private static final int DEFAULT_HEIGHT = 550;

    private SimpleUniverse simpleUniverse;

    private Canvas3D canvas3D;

    public RobotView() {

        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        getContentPane().add(canvas3D);

        simpleUniverse = null;

        setTitle("Robot View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }


    public SimpleUniverse getSimpleUniverse() {

        if (simpleUniverse != null) {
            simpleUniverse.cleanup();
        }

        simpleUniverse = new SimpleUniverse(canvas3D);

        return simpleUniverse;
    }

    public Canvas3D getCanvas3D() {
        return canvas3D;
    }
}
