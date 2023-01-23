package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;


public class NewWindow1 implements ActionListener /*Focuslistener*/{
    public static ImageIcon logInBackgroundIcon = new ImageIcon("Learning_And_Mastering_Java Images\\background spray41.png");
//    public JFrame jDialog;
    public static JButton submitButton;
    JTextField userNameTextField;
    JTextField emailTextField;
    JLabel imageLogo;
    JLayeredPane layeredPaneNewWindow;
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel tryAgainOrTryADifferentEMail = new JLabel();
    JLabel tryADifferentUserNameOrThisUserNameIsUnAvailable = new JLabel();

    static JDialog jDialog = new JDialog();


    public static int LOGIN =0;
    public static int TERMSANDCONDITIONS =1;
    public static int LOGOUTANDEXIT=2;
    public static int CONFIRMATIONEXITGAME=3;

    public NewWindow1(int num, String pathname, ImageIcon imageIcon) {
//            this.TermsAndConditions(pathname);
            if (num == 0) {
//            if (!frame.isVisible()) {
                this.LogIn(imageIcon);
//            }
            } else if (num == 1) {
                this.TermsAndConditions(pathname);
            } else if (num == 2) {
                this.LOGOUTANDEXIT(imageIcon);
            } else if (num == 3) {
                this.ConfirmationExitGame(imageIcon);
            }
    }

    private void TermsAndConditions(String pathname) {

        try {
            textArea = new JTextArea();
            textArea.read(new BufferedReader(new FileReader(pathname)),null);
            textArea.setEditable(false);

            scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


            scrollPane.setBounds(15, 31, 563, 314);


            jDialog = new JDialog();
            jDialog.setBounds(120, 80, 600, 400);
            jDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            jDialog.setLayout(null);
            jDialog.add(scrollPane);
            jDialog.setVisible(true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static JLabel logInBackground;
    public static JLabel userLogIn;
    public static JLabel emailLogInHoyoVerse = new JLabel();

    private void LogIn(ImageIcon imageIcon) {

        imageLogo = new JLabel();
        imageLogo.setIcon(imageIcon);
        imageLogo.setBounds(200,30,250,40);
        imageLogo.setFocusable(false);
        imageLogo.setIcon(imageIcon);

        emailTextField = new JTextField("E-mail");
        emailTextField.setBounds(200, 90, 200,40);
        emailTextField.setForeground(Color.gray);
        emailTextField.setBackground(Color.white);
        emailTextField.setFocusable(true);
        emailTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (emailTextField.getText().equals("E-mail")) {
                    emailTextField.setText("");
                    emailTextField.setForeground(Color.black);

                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText("E-mail");
                    emailTextField.setForeground(Color.gray);
                }
            }
        });

        userNameTextField = new JTextField("Username");
        userNameTextField.setBounds(200,150 , 200,40);
        userNameTextField.setForeground(Color.gray);
        userNameTextField.setBackground(Color.white);
//        userNameTextField.setText("Username");
        userNameTextField.setFocusable(true);
        userNameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (userNameTextField.getText().equals("Username")) {
                    userNameTextField.setText("");
                    userNameTextField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (userNameTextField.getText().isEmpty()) {
                    userNameTextField.setText("Username");
                    userNameTextField.setForeground(Color.gray);
                }
            }
        });

        submitButton = new JButton();
        submitButton.setText("Submit");
//        submitButton.setFocusable(false);
        submitButton.setBounds(200, 210 ,200, 40);
        submitButton.setForeground(new Color(218, 165, 32));
        submitButton.setBackground(Color.black);
        submitButton.addActionListener(this);

        layeredPaneNewWindow = new JLayeredPane();
        layeredPaneNewWindow.setBackground(Color.white);
        layeredPaneNewWindow.setBounds(0,0, 600,400);
        layeredPaneNewWindow.add(imageLogo, Integer.valueOf(0));
        layeredPaneNewWindow.add(emailTextField, Integer.valueOf(1));
        layeredPaneNewWindow.add(userNameTextField, Integer.valueOf(2));
        layeredPaneNewWindow.add(submitButton, Integer.valueOf(3));

        jDialog = new JDialog(StartingScreen.frame);
        jDialog.add(layeredPaneNewWindow);
        jDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jDialog.setResizable(false);
        jDialog.setLayout(null);
        jDialog.setVisible(true);
        jDialog.setAlwaysOnTop(true);
        jDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jDialog.setLocationRelativeTo(null);
        jDialog.setBounds(120, 80, 600, 400);
        jDialog.setVisible(true);

//        jDialog.setUndecorated(true);

//        frame = new JFrame();
//        frame.add(layeredPaneNewWindow);
//        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        frame.setForeground(Color.white);
//        frame.setAlwaysOnTop(true);
//        frame.setResizable(false);
//        frame.setLayout(null);
//        frame.setVisible(true);
//        frame.setBounds(120, 80, 600, 400);

//        StartingScreen.screenButton.setEnabled(false);
//        StartingScreen.verificationButton.setEnabled(false);
//        StartingScreen.termsAndConditionsButton.setEnabled(false);

//        StartingScreen.
    }

    private void LogInIdentification() {

        userLogIn = new JLabel();
        userLogIn.setText("User");
        userLogIn.setForeground(new Color(0x63CBE3));
//        userLogIn.setForeground(new Color(0xF9E167));
        userLogIn.setFont(new Font("" , Font.BOLD, 15));
        userLogIn.setBounds(335,450,100,40);


        int indexOfATSign = emailTextField.getText().indexOf('@');

        int lengthEmailTextField = emailTextField.getText().length();

        String email3RDChar = emailTextField.getText().substring(0,1);
        String email = emailTextField.getText().substring(indexOfATSign,lengthEmailTextField);
        String emailLogInHoyoVerseSetText = email3RDChar + "***"  + email;

        emailLogInHoyoVerse.setText(emailLogInHoyoVerseSetText);

        emailLogInHoyoVerse.setForeground(new Color(0xF9E167));
        emailLogInHoyoVerse.setFont(new Font("" , Font.BOLD, 15));
        emailLogInHoyoVerse.setBounds( 375,450,150,40);
        emailLogInHoyoVerse.setFocusable(false);

        logInBackground = new JLabel();
        logInBackground.setIcon(logInBackgroundIcon);
        logInBackground.setFocusable(false);
        logInBackground.setBounds( 300,443,300,50);

        StartingScreen.layeredPaneStartingScreen.add(logInBackground, Integer.valueOf(7));
        StartingScreen.layeredPaneStartingScreen.add(userLogIn, Integer.valueOf(8));
        StartingScreen.layeredPaneStartingScreen.add(emailLogInHoyoVerse, Integer.valueOf(9));
    }

    static JButton exitButtonNewWindow;
    static JButton logOut;
    JButton exitButtonConfirmation;

    static JLabel logOutOrExit;
    static JDialog frameLogOutAndExitJDialog = new JDialog();
    private void LOGOUTANDEXIT(ImageIcon imageIcon) {

        logOutOrExit = new JLabel();
        logOutOrExit.setText("Log Out Or Exit?");
        logOutOrExit.setBounds(140,50,300,40);
        logOutOrExit.setForeground(Color.black);
        logOutOrExit.setFont(new Font("" , Font.BOLD, 20));

        logOut = new JButton();
        logOut.setText("Log out");
        logOut.setBounds(40, 200 ,190, 40);
        logOut.setForeground(new Color(218, 165, 32));
        logOut.setBackground(Color.black);
        logOut.setIcon(imageIcon);
        logOut.addActionListener(this);

        exitButtonConfirmation = new JButton();
        exitButtonConfirmation.setText("Exit");
        exitButtonConfirmation.setBounds(260, 200 ,190, 40);
        exitButtonConfirmation.setForeground(Color.black);
        exitButtonConfirmation.setBackground(Color.white);
        exitButtonConfirmation.addActionListener(actionEvent -> {
            jDialog.dispose();
            ConfirmationExitGame(StartingScreen.exitButtonDarkMode);
        });

        JLayeredPane confirmationLogOutOrExitGameLayeredPane = new JLayeredPane();
        confirmationLogOutOrExitGameLayeredPane.setBounds(0,0, 500,300);
        confirmationLogOutOrExitGameLayeredPane.add(exitButtonConfirmation, Integer.valueOf(0));
        confirmationLogOutOrExitGameLayeredPane.add(logOut, Integer.valueOf(1));
        confirmationLogOutOrExitGameLayeredPane.add(logOutOrExit, Integer.valueOf(2));

        jDialog = new JDialog(StartingScreen.frame);
        jDialog.add(confirmationLogOutOrExitGameLayeredPane);
        jDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jDialog.setResizable(false);
        jDialog.setLayout(null);
        jDialog.setVisible(true);
        jDialog.setAlwaysOnTop(true);
        jDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jDialog.setLocationRelativeTo(null);
        jDialog.setBounds(180, 120, 500, 300);
        jDialog.setVisible(true);

        StartingScreen.screenButton.setEnabled(false);

        if (!StartingScreen.screenButton.isEnabled()) {
            if (userLogIn.isVisible()) {
                userLogIn.setVisible(false);
                emailLogInHoyoVerse.setVisible(false);
                logInBackground.setVisible(false);
            }
        }if (!StartingScreen.screenButton.isEnabled()) {
            if (userLogIn.isVisible()) {
                userLogIn.setVisible(false);
                emailLogInHoyoVerse.setVisible(false);
                logInBackground.setVisible(false);
            }
        }


    }

    JButton confirm;
    JButton cancel;
    JFrame frameConfirmation;
    public void ConfirmationExitGame(ImageIcon imageIcon) {

        JLabel confirmation = new JLabel();
        confirmation.setText("Are you sure you want to exit?");
        confirmation.setBounds(100,50,300,40);
        confirmation.setForeground(Color.black);
        confirmation.setFont(new Font("" , Font.BOLD, 20));


        confirm = new JButton();
        confirm.setText("confirm");
        confirm.setBounds(40, 200 ,190, 40);
        confirm.setForeground(new Color(218, 165, 32));
        confirm.setBackground(Color.black);
        confirm.addActionListener(actionEvent -> System.exit(0));
//        if (!(imageIcon==null)) {
        confirm.setIcon(imageIcon);
//        }

//        frameConfirmation =new JFrame();
        cancel = new JButton();
        cancel.setText("cancel");
        cancel.setBounds(260, 200 ,190, 40);
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);
        cancel.addActionListener(actionEvent -> jDialog.dispose());

        JLayeredPane confirmationExitGameLayeredPane = new JLayeredPane();
        confirmationExitGameLayeredPane.setBounds(0,0, 500,300);
        confirmationExitGameLayeredPane.add(cancel, Integer.valueOf(0));
        confirmationExitGameLayeredPane.add(confirm, Integer.valueOf(1));
        confirmationExitGameLayeredPane.add(confirmation, Integer.valueOf(2));

        jDialog = new JDialog(StartingScreen.frame);
        jDialog.add(confirmationExitGameLayeredPane);
        jDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jDialog.setResizable(false);
        jDialog.setLayout(null);
        jDialog.setVisible(true);
        jDialog.setAlwaysOnTop(true);
        jDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jDialog.setLocationRelativeTo(null);
        jDialog.setBounds(180, 120, 500, 300);

        jDialog.setVisible(true);

//        frameConfirmation = new JFrame();
//        frameConfirmation.add(confirmationExitGameLayeredPane);
//        frameConfirmation.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        frameConfirmation.setResizable(false);
//        frameConfirmation.setLayout(null);
//        frameConfirmation.setVisible(true);
//        frameConfirmation.setBounds(180, 120, 500, 300);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == submitButton) {

            StartingScreen.layeredPaneStartingScreen.remove(StartingScreen.logInRequiredText);


            String username = userNameTextField.getText();

            // try again email
            if (!(emailTextField.getText().contains("@") && emailTextField.getText().contains("."))|| emailTextField.getText().isEmpty()) {
                tryAgainOrTryADifferentEMail.setVisible(false);

                tryAgainOrTryADifferentEMail.setText("Try again or try a different E-mail");
                tryAgainOrTryADifferentEMail.setForeground(Color.red);
                tryAgainOrTryADifferentEMail.setFont(new Font("", Font.BOLD, 10));
                tryAgainOrTryADifferentEMail.setBounds(200, 120, 200, 30);

                if (!tryAgainOrTryADifferentEMail.isVisible()) {
                    tryAgainOrTryADifferentEMail.setVisible(true);
                    layeredPaneNewWindow.add(tryAgainOrTryADifferentEMail, Integer.valueOf(4));
                }


            }
            // try again username
            if (!username.isEmpty() /*|| !username.equals("Username")*/) {

                tryADifferentUserNameOrThisUserNameIsUnAvailable.setVisible(false);

                tryADifferentUserNameOrThisUserNameIsUnAvailable.setText("Try a different Username");
                tryADifferentUserNameOrThisUserNameIsUnAvailable.setForeground(Color.red);
                tryADifferentUserNameOrThisUserNameIsUnAvailable.setFont(new Font("", Font.BOLD, 10));
                tryADifferentUserNameOrThisUserNameIsUnAvailable.setBounds(200, 180, 200, 30);

                if (!tryADifferentUserNameOrThisUserNameIsUnAvailable.isVisible()) {
                    tryADifferentUserNameOrThisUserNameIsUnAvailable.setVisible(true);
                    layeredPaneNewWindow.add(tryADifferentUserNameOrThisUserNameIsUnAvailable, Integer.valueOf(5));
                }

            }

            // exit log out button
            if (emailTextField.getText().contains("@") && emailTextField.getText().contains(".") && /*!username.isEmpty()*/ !username.equals("Username")) {
                StartingScreen.screenButton.setEnabled(true);
                StartingScreen.verificationButton.setEnabled(true);
                StartingScreen.termsAndConditionsButton.setEnabled(true);
                StartingScreen.startGameText.setVisible(true);

                StartingScreen.logInButton.setVisible(false);
//                StartingScreen.logInRequiredText.setVisible(false);

                exitButtonNewWindow = new JButton();
                exitButtonNewWindow.setBounds(760, 460, 20, 22);
                exitButtonNewWindow.setIcon(StartingScreen.exitButton.getIcon());
                exitButtonNewWindow.setFocusable(false);


                exitButtonNewWindow.addActionListener(actionEvent1 -> {
                    LOGOUTANDEXIT(null);
//                    frame.dispose();
                });
                    StartingScreen.exitButton.setVisible(false);

                LogInIdentification();
                jDialog.dispose();
            }


            System.out.println(emailTextField.getText() + " " + userNameTextField.getText());
        } if (actionEvent.getSource() == logOut) {
//

            if (!StartingScreen.screenButton.isEnabled()) {
                if (userLogIn.isVisible()) {
                    userLogIn.setVisible(false);
                    emailLogInHoyoVerse.setVisible(false);
                    logInBackground.setVisible(true);
                }
            }

            StartingScreen.exitButton.setVisible(true);
            StartingScreen.logInButton.setVisible(true);
            StartingScreen.startGameText.setVisible(false);

            exitButtonNewWindow.setVisible(false);

            if (StartingScreen.tapToBegin.isVisible()) {
                StartingScreen.tapToBegin.setVisible(false);
            }

            jDialog.dispose();

            logInBackground.setVisible(false);
            emailLogInHoyoVerse.setText("");
            userLogIn.setVisible(false);
            if (StartingScreen.screenButton.getIcon() == ProgressBar.afterProgessBar) {
                StartingScreen.screenButton.setIcon(StartingScreen.startingScreenImage);
            }
        }

    }

}