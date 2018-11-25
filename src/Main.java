import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    private static final String DUM_E_IMAGE =
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


    private static final DumE DUM_E = new DumE();

    private static final String EXIT_COMMAND = "stop";
    private static final String CURSOR = "Dum-E>";

    private static String readLineSafe(BufferedReader reader) {

        String line = "";

        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return line;
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            System.err.println("Usage : DumE");
            System.exit(-1);
        }

        System.out.println(DUM_E_IMAGE);
        System.out.println("==========================================================================================");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean stop = false;
        do {

            System.out.print(CURSOR);

            String line = readLineSafe(reader);

            if (line.equals(EXIT_COMMAND)) {
                stop = true;
            } else {

                boolean state = DUM_E.execute(line);

                if (!state) {
                    System.err.println("I'm sorry sir, i don't know this operation");
                }
            }
        } while (!stop);

        System.out.println("Good bye sir");
    }
}
