package model;

import view.UserInterface;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String [] args){
        SwingUtilities.invokeLater(UserInterface::new);

    }
}
