import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class TicTacToe {

    Random random = new Random(); //randomly determines who's turn is first 
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9]; //creates an array of buttons, 9 for the tic tac toe game
    boolean player1_turn; //true if player1's turn, false if its not




    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        //for the text on screen
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);


        //working on title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);


        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);

        //button panel
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        frame.add(button_panel);

        //adding the buttons using a forloop
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        firstTurn();

}

public void actionPerformed(ActionEvent e) {

    for (int i = 0; i < 9; i++){
        if (e.getSource() == buttons[i]) {
            if (player1_turn){ //if it is player 1's turn
                if (buttons[i].getText() == ""){
                    buttons[i].setForeground(new Color(255, 0, 0));
                    buttons[i].setText("X");
                    player1_turn = false;
                    textfield.setText("O Turn");
                    check();


                }

            }
            else {
                if (buttons[i].getText() == ""){
                    buttons[i].setForeground(new Color(0, 0, 255));
                    buttons[i].setText("0");
                    player1_turn = true;
                    textfield.setText("X Turn");
                    check();



            }

        }
    }

}

public void firstTurn(){

 
try {
    Thread.sleep(2000); //waits 2000 milliseconds before displaying the next text
} catch (InterruptedException e){
    e.printStackTrace();
}

if(random.nextInt(2) == 0){
    player1_turn = true; //if random generates 0 then it is player 1's turn
    textfield.setText("X's Turn");
} else {
    player1_turn = false; //if random generates 1 then it is player 2's turn
    textfield.setText("O's Turn");
}

}


public void check(){ 
    //this method checks if x or o wins
    if ((buttons[0].getText()== "X") &&  (buttons[1].getText()=="X") && (buttons[2].getText()== "X")) {
        xWins(0, 1, 2);
    }

    if ((buttons[3].getText()== "X") &&  (buttons[4].getText()=="X") && (buttons[5].getText()== "X")) {
        xWins(3, 4, 5);
    }

    if ((buttons[6].getText()== "X") &&  (buttons[7].getText()=="X") && (buttons[8].getText()== "X")) {
        xWins(6, 7, 8);
    }

    if ((buttons[0].getText()== "X") &&  (buttons[3].getText()=="X") && (buttons[6].getText()== "X")) {
        xWins(0, 3, 6);
    }

    if ((buttons[1].getText()== "X") &&  (buttons[4].getText()=="X") && (buttons[7].getText()== "X")) {
        xWins(1, 4, 7);
    }

    if ((buttons[2].getText()== "X") &&  (buttons[5].getText()=="X") && (buttons[8].getText()== "X")) {
        xWins(2, 5, 8);
    }

    if ((buttons[0].getText()== "X") &&  (buttons[4].getText()=="X") && (buttons[8].getText()== "X")) {
        xWins(0, 4, 8);
    }

    if ((buttons[2].getText()== "X") &&  (buttons[4].getText()=="X") && (buttons[6].getText()== "X")) {
        xWins(2, 4, 6);
    }

    //end of checking all combos for x 

    if ((buttons[0].getText()== "O") &&  (buttons[1].getText()=="O") && (buttons[2].getText()== "O")) {
        oWins(0, 1, 2);
    }

    if ((buttons[3].getText()== "O") &&  (buttons[4].getText()=="O") && (buttons[5].getText()== "O")) {
        oWins(3, 4, 5);
    }

    if ((buttons[6].getText()== "O") &&  (buttons[7].getText()=="O") && (buttons[8].getText()== "O")) {
        oWins(6, 7, 8);
    }

    if ((buttons[0].getText()== "O") &&  (buttons[3].getText()=="O") && (buttons[6].getText()== "O")) {
        oWins(0, 3, 6);
    }

    if ((buttons[1].getText()== "O") &&  (buttons[4].getText()=="O") && (buttons[7].getText()== "O")) {
        oWins(1, 4, 7);
    }

    if ((buttons[2].getText()== "O") &&  (buttons[5].getText()=="O") && (buttons[8].getText()== "O")) {
        oWins(2, 5, 8);
    }

    if ((buttons[0].getText()== "O") &&  (buttons[4].getText()=="O") && (buttons[8].getText()== "O")) {
        oWins(0, 4, 8);
    }

    if ((buttons[2].getText()== "O") &&  (buttons[4].getText()=="O") && (buttons[6].getText()== "O")) {
        oWins(2, 4, 6);
    }

}

public void xWins(int a, int b, int c){ // if x wins
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);


    for (int i =0; i < 9; i++){
        buttons[i].setEnabled(false);
    }

    textfield.setText("X wins");

}

public void oWins(int a, int b, int c){
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);


    for (int i =0; i < 9; i++){
        buttons[i].setEnabled(false);
    }

    textfield.setText("O wins");

}

}



}


 

