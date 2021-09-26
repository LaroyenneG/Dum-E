import controller.ControlGroup;
import model.dume.DumE;
import model.element.robot.Robot;
import view.RobotViewer;
import view.ViewRobotController;

import javax.swing.*;


public class App {

    private static void printDumE() {

        final String DUM_E_IMAGE =
                """
                                                                                     `....``                 \s
                                                                                   .:::::/o++-               \s
                                                                                 `-:+o+s/:ssso               \s
                                                                              -/+++:/soo:/hhy+               \s
                                                                           `-/++oyhhdNs/+yhso:`              \s
                                                                       `-:/+oyhdmmmm/shdmmmhyhs/`            \s
                                                                   `.:/+oyhdyo:.-+s: .smmmmmNd+++.           \s
                                                                .:/+oshdmh+.    `s:   .ohmNNmh++o+-          \s
                                                           ..-/+oshdddyo.``...  //:  .o./odyo+/++syyys.      \s
                                                        `-/hoshdhs+:.`       `--//:`--+: :+o++/+ohmNmmo.     \s
                                                 ``  .:+oshmmms-`              `-++::-` `/.ss++ydmmNddds.    \s
                                              .:ohy+syhddyo+/.                    .----:/+ommmNdyhmmdoy/     \s
                                     `    .-/ohNyNddmho:``-`                              `osymmmshmd/+y`    \s
                                    `ys:.:hyyyyMNNNmh.  .-                                    :ymmmmmmh:.````\s
                                 `-+ymmhyydhyyymNNmmh+.:-                                      `ohhsho:`  -//.
                              ./sdmNmNmdmmNyhhyoshdmmddd+                                      ``..`` `:.    \s
                            .hmNNNNNNNNMNNy`-mmdddhdmNNN/                                     `-       .:    \s
                            .NNNNNNNMNNhys+shmmddddNNNMy                                     -+-             \s
                             /mNNNNyo/+syddhsoddhdNMNNN-.`                                                   \s
                              .+/-/oshdddsydhyhmdmMMMMNmms`                                                  \s
                                  sddddmmh+dNNNNmmMMMdNNmmy.                                                 \s
                                  .yddddmms+hmNMMmmNMmdNNhdh/                                                \s
                                   .hmdddmms+sdmNMmmmmmmNNhhdo`                                              \s
                                    -yo::hmmy+ohdNMNmddddhmhyhy-                                             \s
                                     `   /sdm/-+ydmNNmdddhsmdydy.                                            \s
                                   `.-/osh:ymdoo+sddNNddddhoso+-`                                            \s
                               -:osysyddddmosmNdy+ohmNNmdddy.  ..`                                           \s
                               hsymNmhhdmmmmhdmmmhyhymMNddhhy.  `.`                                          \s
                               ymhsdNNmdNNmmmdmhmdhh::dNNmdhhy.  `....                                       \s
                               ommdsymNmmmmmmmdmmN/:m/-yNmddddy`  `ydy`                                      \s
                               +mmmmhsdNmmmmmdddmmmsNNo-ommddddy:/+dNdo:.`                                   \s
                               :mmmNNmsymNNmmmdNmNmmNMMy-ymmmmmmNNNNNmdhys+`                                 \s
                               `hmmmNmmhsdNNmmmNmmmdddNNddmNNmmmNNNNNNNNmhho                                 \s
                                .:/oyhsss+dmNNmNmmdddmNNmmmmmmddhhdNMMMNNdho                                 \s
                                     `   `..-:ommmmNNNMMNNmddmNmmmhdNNNmdhy+                                 \s
                                              :mmmNNNNMMMMMNmmmNNNmhddhhhyy-                                 \s
                                              -mmdysyhmNMMMMMNmNNNNdhhhhyyy.                                 \s
                                              -dh/---:ohNNMMMMNmNMNdhhhhys/`                                 \s
                                              .dh-----:omNMMMMNmNMNdhhs/-`                                   \s
                                              `dms:---:sNNMMMMNNNNNdh-`                                      \s
                                              `hmmhsoohNNNMMNNNNNmdmd                                        \s
                                              `hmmmmmmNNNNNNNNmmmmddh                                        \s
                                           `-+sdmmmmmmmNmNNNmmNmddddy                                        \s
                                        `-+shddmNmmmmmmNmmmmmNmmdddmh                                        \s
                                     `-+yhhdmmdNNNmmmmmNmhddNNmdmmmmo    ````...`````                        \s
                                  `:shddmNMNddmNNNmmmmmNmhhhNNmmmNNh+osoohyhdmNmdyo/++                       \s
                               ```sNNNMMMMMmdNmmNNNmmmNNNNmmNNNNNNmdNNmdddhddmNNmds//s.                      \s
                        ````.+yhhhmNdNNNNNNNmmNNNmNmmNNNNMMMNMMMMNNNmddddddhdmNmmd`                          \s
                        s/:+dNNNNNNmmdddmNNNNNmmmNNNmNNNNMMMMMMMMMNNmddddhhhdmNNNm.                          \s
                        o+/+sdmmmmmmNNNNNNMMMNNmmddmmmNNNNMMMMMMMNNNmddhhhddmNmmh:                           \s
                             hmNMMmmmmmdhhdmNNNNNmmmmNNMMMMMMMMMNNmddhhhhNNmy:::`                            \s
                             omNNmmdhyyyyyyyyhdmmNNNNMNNMMdNMMNNmdhhhhhdmms-                                 \s
                              oh/.--/syhhhyyyyyyyyhdmNNNMMmNMMMNdhhdNdmmo.                                   \s
                                      `./oyhhyyyyyyssyNNNMMMMMMNhhdNNdo.                                     \s
                                           .:+syyyysssdmNMMMMMMNdmNd+`                                       \s
                                               `-/oyyyhdddmmmNNNNd/`                                         \s
                                                    .:+hNNNNmNMNd`                                           \s
                                                       /dNNNNNNd`                                            \s
                                                        .ydmmm/`                                             \s
                                                          `--`                                                 \s""".indent(14);


        System.out.println(DUM_E_IMAGE);
    }

    public static void main(String[] args) {

        printDumE();

        System.out.println("Created by Laroyenne Guillaume, ENISISA student, on 27/12/2018");
        System.out.println("You can getting sources on this link : https://github.com/LaroyenneG/Dum-E");

        final Robot robot = new DumE();

        SwingUtilities.invokeLater(() -> {
            final RobotViewer view = new RobotViewer();
            final ViewRobotController viewRobotController = new ViewRobotController();

            new ControlGroup(robot, view, viewRobotController);
        });
    }
}
