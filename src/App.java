import controller.ControlGroup;
import model.dume.DumE;
import model.element.Solver;
import model.element.connexion.joint.JointInvalidValueException;
import model.element.robot.Robot;
import view.RobotView;

import javax.swing.*;
import javax.vecmath.Point3d;
import java.util.Arrays;

public class App {

    private static void printDumE() {

        final String DUM_E_IMAGE =
                "                                                                           `....``                  \n" +
                        "                                                                         .:::::/o++-                \n" +
                        "                                                                       `-:+o+s/:ssso                \n" +
                        "                                                                    -/+++:/soo:/hhy+                \n" +
                        "                                                                 `-/++oyhhdNs/+yhso:`               \n" +
                        "                                                             `-:/+oyhdmmmm/shdmmmhyhs/`             \n" +
                        "                                                         `.:/+oyhdyo:.-+s: .smmmmmNd+++.            \n" +
                        "                                                      .:/+oshdmh+.    `s:   .ohmNNmh++o+-           \n" +
                        "                                                 ..-/+oshdddyo.``...  //:  .o./odyo+/++syyys.       \n" +
                        "                                              `-/hoshdhs+:.`       `--//:`--+: :+o++/+ohmNmmo.      \n" +
                        "                                       ``  .:+oshmmms-`              `-++::-` `/.ss++ydmmNddds.     \n" +
                        "                                    .:ohy+syhddyo+/.                    .----:/+ommmNdyhmmdoy/      \n" +
                        "                           `    .-/ohNyNddmho:``-`                              `osymmmshmd/+y`     \n" +
                        "                          `ys:.:hyyyyMNNNmh.  .-                                    :ymmmmmmh:.```` \n" +
                        "                       `-+ymmhyydhyyymNNmmh+.:-                                      `ohhsho:`  -//.\n" +
                        "                    ./sdmNmNmdmmNyhhyoshdmmddd+                                      ``..`` `:.     \n" +
                        "                  .hmNNNNNNNNMNNy`-mmdddhdmNNN/                                     `-       .:     \n" +
                        "                  .NNNNNNNMNNhys+shmmddddNNNMy                                     -+-              \n" +
                        "                   /mNNNNyo/+syddhsoddhdNMNNN-.`                                                    \n" +
                        "                    .+/-/oshdddsydhyhmdmMMMMNmms`                                                   \n" +
                        "                        sddddmmh+dNNNNmmMMMdNNmmy.                                                  \n" +
                        "                        .yddddmms+hmNMMmmNMmdNNhdh/                                                 \n" +
                        "                         .hmdddmms+sdmNMmmmmmmNNhhdo`                                               \n" +
                        "                          -yo::hmmy+ohdNMNmddddhmhyhy-                                              \n" +
                        "                           `   /sdm/-+ydmNNmdddhsmdydy.                                             \n" +
                        "                         `.-/osh:ymdoo+sddNNddddhoso+-`                                             \n" +
                        "                     -:osysyddddmosmNdy+ohmNNmdddy.  ..`                                            \n" +
                        "                     hsymNmhhdmmmmhdmmmhyhymMNddhhy.  `.`                                           \n" +
                        "                     ymhsdNNmdNNmmmdmhmdhh::dNNmdhhy.  `....                                        \n" +
                        "                     ommdsymNmmmmmmmdmmN/:m/-yNmddddy`  `ydy`                                       \n" +
                        "                     +mmmmhsdNmmmmmdddmmmsNNo-ommddddy:/+dNdo:.`                                    \n" +
                        "                     :mmmNNmsymNNmmmdNmNmmNMMy-ymmmmmmNNNNNmdhys+`                                  \n" +
                        "                     `hmmmNmmhsdNNmmmNmmmdddNNddmNNmmmNNNNNNNNmhho                                  \n" +
                        "                      .:/oyhsss+dmNNmNmmdddmNNmmmmmmddhhdNMMMNNdho                                  \n" +
                        "                           `   `..-:ommmmNNNMMNNmddmNmmmhdNNNmdhy+                                  \n" +
                        "                                    :mmmNNNNMMMMMNmmmNNNmhddhhhyy-                                  \n" +
                        "                                    -mmdysyhmNMMMMMNmNNNNdhhhhyyy.                                  \n" +
                        "                                    -dh/---:ohNNMMMMNmNMNdhhhhys/`                                  \n" +
                        "                                    .dh-----:omNMMMMNmNMNdhhs/-`                                    \n" +
                        "                                    `dms:---:sNNMMMMNNNNNdh-`                                       \n" +
                        "                                    `hmmhsoohNNNMMNNNNNmdmd                                         \n" +
                        "                                    `hmmmmmmNNNNNNNNmmmmddh                                         \n" +
                        "                                 `-+sdmmmmmmmNmNNNmmNmddddy                                         \n" +
                        "                              `-+shddmNmmmmmmNmmmmmNmmdddmh                                         \n" +
                        "                           `-+yhhdmmdNNNmmmmmNmhddNNmdmmmmo    ````...`````                         \n" +
                        "                        `:shddmNMNddmNNNmmmmmNmhhhNNmmmNNh+osoohyhdmNmdyo/++                        \n" +
                        "                     ```sNNNMMMMMmdNmmNNNmmmNNNNmmNNNNNNmdNNmdddhddmNNmds//s.                       \n" +
                        "              ````.+yhhhmNdNNNNNNNmmNNNmNmmNNNNMMMNMMMMNNNmddddddhdmNmmd`                           \n" +
                        "              s/:+dNNNNNNmmdddmNNNNNmmmNNNmNNNNMMMMMMMMMNNmddddhhhdmNNNm.                           \n" +
                        "              o+/+sdmmmmmmNNNNNNMMMNNmmddmmmNNNNMMMMMMMNNNmddhhhddmNmmh:                            \n" +
                        "                   hmNMMmmmmmdhhdmNNNNNmmmmNNMMMMMMMMMNNmddhhhhNNmy:::`                             \n" +
                        "                   omNNmmdhyyyyyyyyhdmmNNNNMNNMMdNMMNNmdhhhhhdmms-                                  \n" +
                        "                    oh/.--/syhhhyyyyyyyyhdmNNNMMmNMMMNdhhdNdmmo.                                    \n" +
                        "                            `./oyhhyyyyyyssyNNNMMMMMMNhhdNNdo.                                      \n" +
                        "                                 .:+syyyysssdmNMMMMMMNdmNd+`                                        \n" +
                        "                                     `-/oyyyhdddmmmNNNNd/`                                          \n" +
                        "                                          .:+hNNNNmNMNd`                                            \n" +
                        "                                             /dNNNNNNd`                                             \n" +
                        "                                              .ydmmm/`                                              \n" +
                        "                                                `--`                                                  ";


        System.out.println(DUM_E_IMAGE);
    }

    public static void main(String[] args) throws JointInvalidValueException {

        printDumE();

        Robot robot = new DumE();

        Solver<Robot> solver = new Solver<>(robot, new Point3d(0.6, 0.1, 0.0));

        System.out.println(Arrays.toString(solver.compute()));

        SwingUtilities.invokeLater(() -> {
            RobotView view = new RobotView();
            new ControlGroup(robot, view);
        });
    }
}
