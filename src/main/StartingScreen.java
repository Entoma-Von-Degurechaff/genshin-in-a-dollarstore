package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingScreen implements ActionListener {

    public static JLabel startGameText;

    public static JButton screenButton;
    public static JButton exitButton;
    public static JButton logInButton;
    static JButton verificationButton;
    static JButton termsAndConditionsButton;
    public static JComboBox<String> serverButton;
    static JFrame frame;

    public static ImageIcon exitButtonDarkMode = new ImageIcon("Learning_And_Mastering_Java Images\\exitButton.png");

    public static JLayeredPane layeredPaneStartingScreen;

    ImageIcon logInCompanyLogo = new ImageIcon("Learning_And_Mastering_Java Images\\Hoyoverse LogIn4.png");

    static ImageIcon startingScreenImage = new ImageIcon("Learning_And_Mastering_Java Images\\ezgif.com-gif-maker.gif");

    ImageIcon icon = new ImageIcon("Learning_And_Mastering_Java Images\\unknown (4).png");
    ImageIcon logInImage = new ImageIcon("Learning_And_Mastering_Java Images\\log in button image1.png");

    ImageIcon exitButtonImage = new ImageIcon("Learning_And_Mastering_Java Images\\exitButton1.png");

    ImageIcon verificationImage = new ImageIcon("Learning_And_Mastering_Java Images\\wrench icon1.png");

    ImageIcon termsAndConditionsImage = new ImageIcon("Learning_And_Mastering_Java Images\\forms logo 1.png");

    ImageIcon startGameBackground = new ImageIcon("Learning_And_Mastering_Java Images\\startgameBackground.png");

    public static JLabel logInRequiredText = new JLabel();

    public static JLabel tapToBegin = new JLabel();


    StartingScreen() {



        logInRequiredText.setVisible(false);
        ProgressBar.jLabelSetStringProgressBar.setVisible(false);
        NewWindow1.frameLogOutAndExitJDialog.setAlwaysOnTop(true);

        screenButton = new JButton();
        screenButton.setFocusable(false);
        screenButton.setBounds(0, 0, 840,560);
        screenButton.setForeground(Color.white);
        screenButton.setIcon(startingScreenImage);

        screenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (NewWindow1.emailLogInHoyoVerse.getText().contains("@")) {
//                    tapToBegin = new JLabel();
                    tapToBegin.setIcon(NewWindow1.logInBackgroundIcon);
                    tapToBegin.setText("Tap To Begin");
                    tapToBegin.setHorizontalTextPosition(JLabel.CENTER);
                    tapToBegin.setVerticalTextPosition(JLabel.CENTER);
                    tapToBegin.setFocusable(false);
                    tapToBegin.setForeground(Color.white);
                    tapToBegin.setFont(new Font("" , Font.PLAIN, 20));
                    tapToBegin.setBounds( 300,443,300,50);
                    tapToBegin.setVisible(false);

//                    ProgressBar.jLabelSetStringProgressBar.setVisible(false);
                    if (!ProgressBar.jLabelSetStringProgressBar.isVisible()) {
                        String[] progressBarStrings = {
                                "Verifying file Integrity",
                                "Preparing to download resources",
                                "Checking for environment",
                                "Checking for updates",
                                "Preparing to load data"};
                        ProgressBar progressBar = new ProgressBar(0,100, progressBarStrings, ProgressBar.multiple);
                        ProgressBar.jLabelSetStringProgressBar.setVisible(true);
                        progressBar.start();
                        startGameText.setVisible(false);
                        screenButton.removeActionListener(this);


                    }
                }
                if (!(NewWindow1.emailLogInHoyoVerse.getText().contains("@")))  {
                    logInRequiredText.setBounds(80, 90,700,368);
                    logInRequiredText.setVerticalTextPosition(JLabel.CENTER);
                    logInRequiredText.setHorizontalTextPosition(JLabel.CENTER);
//                    logInRequiredText.setBounds(250, 250,400,30);
                    logInRequiredText.setIcon(startGameBackground);
                    //                        screenButton.setEnabled(false);
                    logInRequiredText.setText("LOG IN REQUIRED TO START GAME");
                    logInRequiredText.setFont(new Font("", Font.BOLD, 20));
                    logInRequiredText.setForeground(Color.white);

                    if (!logInRequiredText.isVisible()) {
                        logInRequiredText.setVisible(true);
                        layeredPaneStartingScreen.add(logInRequiredText, Integer.valueOf(7));
                    }


                }

            }
        });


        startGameText = new JLabel();
        startGameText.setBounds(80, 90,700, 368);
        startGameText.setIcon(startGameBackground);
        startGameText.setText("START GAME");
        startGameText.setHorizontalTextPosition(JLabel.CENTER);
        startGameText.setVerticalTextPosition(JLabel.CENTER);
        startGameText.setFocusable(true);
        startGameText.setForeground(Color.white);
        startGameText.setFont(new Font("" , Font.PLAIN, 30));
        startGameText.setVisible(false);

        logInButton = new JButton();
        logInButton.setIcon(logInImage);
        logInButton.addActionListener(actionEvent -> {
            /* NewWindow1 logIn =*/ new NewWindow1(NewWindow1.LOGIN, null, logInCompanyLogo);
        });
        logInButton.addActionListener(this);
        logInButton.setBackground(Color.white);
        logInButton.setBounds( 760,460,20,22);
        logInButton.setOpaque(true);

        verificationButton = new JButton();
        verificationButton.setFocusable(false);
        verificationButton.setBounds(760, 430, 20, 22);
//        verificationButton.addActionListener(this);
        verificationButton.addActionListener(actionEvent -> {
            ProgressBar progressBar1 = new ProgressBar(0, 100, "Verifying file Integrity", ProgressBar.single);

//            ProgressBar.jLabelSetStringProgressBar.setVisible(false);
            if (!ProgressBar.jLabelSetStringProgressBar.isVisible()) {
                ProgressBar.jLabelSetStringProgressBar.setVisible(true);
                progressBar1.start();


            }


        });
        verificationButton.setIcon(verificationImage);
        verificationButton.setOpaque(true);

        termsAndConditionsButton = new JButton();
        termsAndConditionsButton.setFocusable(false);
        termsAndConditionsButton.setBounds(760, 400, 20, 22);
        termsAndConditionsButton.addActionListener(actionEvent -> {
            new NewWindow1(NewWindow1.TERMSANDCONDITIONS,"texts\\termsandconditions.txt",null);
            NewWindow1.jDialog.setVisible(true);
        });
        termsAndConditionsButton.setIcon(termsAndConditionsImage);
        termsAndConditionsButton.setOpaque(true);

        exitButton = new JButton();
        exitButton.setFocusable(false);
        exitButton.setBounds( 40,460,20,20);
        exitButton.addActionListener(actionEvent -> {
            new NewWindow1(NewWindow1.CONFIRMATIONEXITGAME, null,exitButtonDarkMode);
        });
        exitButton.setIcon(exitButtonImage);
        exitButton.setOpaque(true);

        String[] serverContinents = {"America","Europe", "Asia", "TW, HK, MO"};

        serverButton = new JComboBox<>(serverContinents);
        serverButton.addActionListener(this);
        serverButton.setBounds( 280,405,300,40);
        serverButton.setEditable(false);

        layeredPaneStartingScreen = new JLayeredPane();

        layeredPaneStartingScreen.setBounds(0,0, 840,560);
        layeredPaneStartingScreen.add(screenButton, Integer.valueOf(0));
        layeredPaneStartingScreen.add(startGameText, Integer.valueOf(1));
        layeredPaneStartingScreen.add(exitButton, Integer.valueOf(2));
        layeredPaneStartingScreen.add(logInButton, Integer.valueOf(3));
        layeredPaneStartingScreen.add(verificationButton, Integer.valueOf(4));
        layeredPaneStartingScreen.add(termsAndConditionsButton, Integer.valueOf(5));
        layeredPaneStartingScreen.add(serverButton, Integer.valueOf(6));

        frame = new JFrame();
        frame.add(layeredPaneStartingScreen);
        frame.setTitle("Genshin Impact");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setSize(840, 560);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}