package model.dume;

import model.dume.components.*;
import model.element.connexion.Connexion;
import model.element.robot.Robot;

public class DumE extends Robot {

    private static final Base BASE = new Base();

    private static final Turret TURRET = new Turret();

    private static final Girder GIRDER = new Girder();

    private static final Pole POLE = new Pole();

    private static final FirstPhalanx FIRST_PHALANX = new FirstPhalanx();

    private static final SecondPhalanx SECOND_PHALANX = new SecondPhalanx();

    public DumE() {
        super((Connexion) BASE.clone(), (Connexion) TURRET.clone(), (Connexion) GIRDER.clone(), (Connexion) POLE.clone(), (Connexion) FIRST_PHALANX.clone(), (Connexion) SECOND_PHALANX.clone());
    }
}

