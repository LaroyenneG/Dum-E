import controller.ControlGroup;
import model.dume.DumE;
import model.element.robot.Robot;
import view.RobotViewer;
import view.ViewRobotController;

import javax.swing.*;


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

    public static void main(String[] args) {

        printDumE();

        System.out.println("Created by Laroyenne Guillaume, ENISISA student, on 27/12/2018");
        System.out.println("You can getting sources on this link : https://github.com/LaroyenneG/Dum-E");

        Robot robot = new DumE();

        SwingUtilities.invokeLater(() -> {
            RobotViewer view = new RobotViewer();
            ViewRobotController viewRobotController = new ViewRobotController();
            new ControlGroup(robot, view, viewRobotController);
        });
    }
}
