package main;

import javax.swing.*;
import java.awt.*;

public class ProgressBar extends Thread {
    public static ImageIcon afterProgessBar = new ImageIcon("Learning_And_Mastering_Java Images\\afterProgressBarStartingScreen.jpg");
    public static int progressBarMin;
    public static int progressBarMax;
    String[] multipleSetTextJLabel;
    String singleSetTextJLabel;

    int singleOrMultiple;

    static JProgressBar progressBar;

    static JLabel jLabelSetStringProgressBar = new JLabel();
    public static int multiple = 1;
    public static int single = 0;

    public ProgressBar(int progressBarMin, int progressBarMax, String[] multipleSetTextJLabel, int singleOrMultiple) {
        ProgressBar.progressBarMin = progressBarMin;
        ProgressBar.progressBarMax = progressBarMax;
        this.multipleSetTextJLabel = multipleSetTextJLabel;

        this.singleOrMultiple = singleOrMultiple;

    }

    public ProgressBar(int progressBarMin, int progressBarMax, String setTextJLabel, int singleOrMultiple) {
        ProgressBar.progressBarMin = progressBarMin;
        ProgressBar.progressBarMax = progressBarMax;
        this.singleSetTextJLabel = setTextJLabel;

        this.singleOrMultiple = singleOrMultiple;

    }

    @Override
    public void run() {
        if (singleOrMultiple == 0) {
            singleProgressBar(progressBarMin, progressBarMax, singleSetTextJLabel);
        } else if (singleOrMultiple == 1) {
            multipleProgressBars(progressBarMin, progressBarMax, multipleSetTextJLabel);
        }

    }

    public void singleProgressBar(int progressBarMin, int progressBarMax, String SingleSetTextJLabel) {


        jLabelSetStringProgressBar.setText(SingleSetTextJLabel);
        jLabelSetStringProgressBar.setFont(new Font("", Font.PLAIN, 10));
        jLabelSetStringProgressBar.setBounds(370,430, 150,30);
        jLabelSetStringProgressBar.setForeground(Color.white);

        progressBar = new JProgressBar(progressBarMin, progressBarMax);
        progressBar.setValue(progressBarMin);
        progressBar.setBounds(300,455,250,20);
        progressBar.setForeground(Color.white);
        progressBar.setBackground(Color.black);

        StartingScreen.termsAndConditionsButton.setEnabled(false);
        StartingScreen.exitButton.setEnabled(false);
        StartingScreen.logInButton.setEnabled(false);

        if (NewWindow1.emailLogInHoyoVerse.getText().contains("@")) {
            if (NewWindow1.exitButtonNewWindow.isVisible()) {
                NewWindow1.exitButtonNewWindow.setEnabled(false);
            }
        }

        if (StartingScreen.tapToBegin.isVisible()) {
            StartingScreen.tapToBegin.setVisible(false);
//            StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.tapToBegin);
        }

        if (StartingScreen.startGameText.isVisible()) {
            StartingScreen.startGameText.setVisible(false);
        }

        StartingScreen.layeredPaneStartingScreen.add(progressBar, Integer.valueOf(7));

        StartingScreen.layeredPaneStartingScreen.add(jLabelSetStringProgressBar, Integer.valueOf(8));

        StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.serverButton);


        if (!NewWindow1.emailLogInHoyoVerse.getText().isEmpty()) {

            StartingScreen.layeredPaneStartingScreen.remove(NewWindow1.userLogIn);
            StartingScreen.layeredPaneStartingScreen.remove(NewWindow1.emailLogInHoyoVerse);
            StartingScreen.layeredPaneStartingScreen.remove(NewWindow1.logInBackground);
        }

//        if ((NewWindow1.emailLogInHoyoVerse.getText().contains("@"))) {
//            if (!StartingScreen.startGameText.isVisible()) {
//                StartingScreen.startGameText.setVisible(true);
//            }
//        }



        while(progressBarMin<=progressBarMax) {

            progressBar.setValue(progressBarMin);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            progressBarMin +=1;
//            if (progressBarMin+1 !=progressBarMax) {

//            }

            if (progressBarMin == progressBarMax) {

                StartingScreen.termsAndConditionsButton.setEnabled(true);
                StartingScreen.exitButton.setEnabled(true);
                StartingScreen.logInButton.setEnabled(true);

                if (NewWindow1.emailLogInHoyoVerse.getText().contains("@")) {

                    NewWindow1.exitButtonNewWindow.setEnabled(true);
                }


//                if (!StartingScreen.tapToBegin.isVisible()) {
//                    StartingScreen.startGameText.setVisible(true);
//                    StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.startGameText);
//                    StartingScreen.serverButton.setVisible(false);
////                    StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.serverButton);
//                }

//                if (StartingScreen.screenButton.getIcon() == afterProgessBar) {
//                    if (!StartingScreen.tapToBegin.isVisible()) {
//                        StartingScreen.tapToBegin.setVisible(true);
//                    }
//                }



                if (StartingScreen.screenButton.getIcon() != afterProgessBar) {
                    StartingScreen.layeredPaneStartingScreen.add(StartingScreen.serverButton);

                    if (NewWindow1.emailLogInHoyoVerse.getText().contains("@")) {

                        NewWindow1.exitButtonNewWindow.setEnabled(true);


                        if (!StartingScreen.startGameText.isVisible()) {
                            StartingScreen.startGameText.setVisible(true);
                        }

                        StartingScreen.layeredPaneStartingScreen.add(NewWindow1.userLogIn);
                        NewWindow1.userLogIn.setVisible(true);
                        StartingScreen.layeredPaneStartingScreen.add(NewWindow1.emailLogInHoyoVerse);
                        NewWindow1.emailLogInHoyoVerse.setVisible(true);
                        StartingScreen.layeredPaneStartingScreen.add(NewWindow1.logInBackground);
                        NewWindow1.logInBackground.setVisible(true);
                    }
                }
                progressBar.setVisible(false);
                jLabelSetStringProgressBar.setVisible(false);
//                StartingScreen.layeredPaneStartingScreen.remove(progressBar);

//                StartingScreen.layeredPaneStartingScreen.remove(jLabelSetStringProgressBar);

            }
        }
    }
    public static int multipleSetTextJLabelLength;
    public void multipleProgressBars(int multipleProgressBarMin, int multipleProgressBarMax, String[] multipleSetTextJLabel) {

        multipleSetTextJLabelLength = multipleSetTextJLabel.length;
        jLabelSetStringProgressBar.setText(multipleSetTextJLabel[0]);

        jLabelSetStringProgressBar.setFont(new Font("", Font.PLAIN, 10));
        jLabelSetStringProgressBar.setBounds(370,430, 150,30);
        jLabelSetStringProgressBar.setForeground(Color.white);

        progressBar = new JProgressBar(multipleProgressBarMin, multipleProgressBarMax);
        progressBar.setValue(multipleProgressBarMin);
        progressBar.setBounds(300,455,250,20);
        progressBar.setForeground(Color.white);
        progressBar.setBackground(Color.black);

        StartingScreen.layeredPaneStartingScreen.add(progressBar, Integer.valueOf(7));

        StartingScreen.layeredPaneStartingScreen.add(jLabelSetStringProgressBar, Integer.valueOf(8));

        StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.serverButton);

        StartingScreen.startGameText.setVisible(false);

        if (!NewWindow1.emailLogInHoyoVerse.getText().isEmpty()) {

            StartingScreen.layeredPaneStartingScreen.remove(NewWindow1.userLogIn);
            StartingScreen.layeredPaneStartingScreen.remove(NewWindow1.emailLogInHoyoVerse);
            StartingScreen.layeredPaneStartingScreen.remove(NewWindow1.logInBackground);
        }

        StartingScreen.termsAndConditionsButton.setEnabled(false);
        StartingScreen.exitButton.setEnabled(false);
        StartingScreen.logInButton.setEnabled(false);
        StartingScreen.verificationButton.setEnabled(false);

        if (NewWindow1.emailLogInHoyoVerse.getText().contains("@")) {
            if (NewWindow1.exitButtonNewWindow.isVisible()) {
                NewWindow1.exitButtonNewWindow.setEnabled(false);
            }
        }

        try {
            for (int i = 1; i < multipleSetTextJLabelLength + 1; i++) {
                whileLoop(0, 100);
                jLabelSetStringProgressBar.setText(multipleSetTextJLabel[i]);


                if (i+1 == multipleSetTextJLabelLength) {
                    if (progressBarInt == progressBarMax+1) {

                        StartingScreen.verificationButton.setEnabled(true);
                        StartingScreen.termsAndConditionsButton.setEnabled(true);

                        if (NewWindow1.emailLogInHoyoVerse.getText().contains("@")) {

                            NewWindow1.exitButtonNewWindow.setEnabled(true);
                        }

                        StartingScreen.screenButton.setIcon(afterProgessBar);
                        StartingScreen.layeredPaneStartingScreen.add(StartingScreen.tapToBegin,Integer.valueOf(7));
                        StartingScreen.tapToBegin.setVisible(true);

                        removeAndSetIconScreenButton();

                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }
    public static int progressBarInt;
    public void whileLoop(int multipleProgressBarMin,int multipleProgressBarMax) {

        while(multipleProgressBarMin<=multipleProgressBarMax) {

            progressBar.setValue(multipleProgressBarMin);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            multipleProgressBarMin +=1;
            progressBarInt = multipleProgressBarMin;
        }

    }

    public void removeAndSetIconScreenButton() {
        ProgressBar.progressBar.setVisible(false);
        StartingScreen.layeredPaneStartingScreen.remove(progressBar);
        StartingScreen.layeredPaneStartingScreen.remove(jLabelSetStringProgressBar);

        StartingScreen.screenButton.addActionListener((actionEvent1 -> {
            ImageIcon genshinDoor = new ImageIcon("Learning_And_Mastering_Java Images\\ezgif.com-gif-maker (1).gif");
            StartingScreen.screenButton.setIcon(genshinDoor);

            StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.verificationButton);
            StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.termsAndConditionsButton);
            StartingScreen.layeredPaneStartingScreen.remove(NewWindow1.exitButtonNewWindow);

            StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.tapToBegin);
        }));

    }
}