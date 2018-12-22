package model.dume;

import model.dume.components.*;
import model.element.connexion.Connexion;
import model.element.robot.Robot;
import model.element.terminal.organ.TerminalOrgan;

public class DumE extends Robot {

    private static final Base BASE = new Base();

    private static final Turret TURRET = new Turret();

    private static final Girder GIRDER = new Girder();

    private static final Pole POLE = new Pole();

    private static final FirstPhalanx FIRST_PHALANX = new FirstPhalanx();

    private static final SecondPhalanx SECOND_PHALANX = new SecondPhalanx();

    private static final Grapnel GRAPNEL = new Grapnel();

    public DumE() {
        super((TerminalOrgan) GRAPNEL.clone(), (Connexion) BASE.clone(), (Connexion) TURRET.clone(), (Connexion) GIRDER.clone(), (Connexion) POLE.clone(), (Connexion) FIRST_PHALANX.clone(), (Connexion) SECOND_PHALANX.clone());
    }
}

