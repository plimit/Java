import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI implements ActionListener {
    //This is the calculator GUI

    int frameWidth = 350;
    int frameHeight = 365;
    int panelWidth = 330;
    int panelHeight =  240;

    String firstVariable = "";

    String secondVariable = "";

    String operand;

    int nextFlag = 0;

    int showResult = 0;


    JTextField displayScreen;
    JTextField operatorBox;
    JTextField formula;


    public void main(){

        //Create Text field
        displayScreen = new JTextField(12);
        displayScreen.setEditable(false);
        displayScreen.setBorder(null);
        displayScreen.setFont(new Font("Verdana", Font.BOLD, 25));
        displayScreen.setHorizontalAlignment(SwingConstants.RIGHT);
        displayScreen.setBackground(null);

        operatorBox = new JTextField(10);
        operatorBox.setEditable(false);
        operatorBox.setVisible(false);

        formula = new JTextField(32);
        formula.setEditable(false);
        formula.setHorizontalAlignment(SwingConstants.RIGHT);
        formula.setLocation(90, 0);
        formula.setFont(new Font("verdana", Font.ITALIC, 10));
        formula.setBorder(null);
        formula.setBackground(null);



        //Create Buttons
        JButton one = new JButton("1");
        one.addActionListener(this);
        one.setFocusable(false);

        JButton two = new JButton("2");
        two.addActionListener(this);
        two.setFocusable(false);


        JButton three = new JButton("3");
        three.addActionListener(this);
        three.setFocusable(false);


        JButton four = new JButton("4");
        four.addActionListener(this);
        four.setFocusable(false);


        JButton five = new JButton("5");
        five.addActionListener(this);
        five.setFocusable(false);


        JButton six = new JButton("6");
        six.addActionListener(this);
        six.setFocusable(false);

        JButton seven = new JButton("7");
        seven.addActionListener(this);
        seven.setFocusable(false);

        JButton eight = new JButton("8");
        eight.addActionListener(this);
        eight.setFocusable(false);

        JButton nine = new JButton("9");
        nine.addActionListener(this);
        nine.setFocusable(false);

        JButton zero = new JButton("0");
        zero.addActionListener(this);
        zero.setFocusable(false);

        JButton dot = new JButton(".");
        dot.addActionListener(this);
        dot.setFocusable(false);

        JButton plus = new JButton("+");
        plus.addActionListener(this);
        plus.setFocusable(false);

        JButton minus = new JButton("-");
        minus.addActionListener(this);
        minus.setFocusable(false);

        JButton multiply = new JButton("x");
        multiply.addActionListener(this);
        multiply.setFocusable(false);

        JButton divide = new JButton("/");
        divide.addActionListener(this);
        divide.setFocusable(false);

        JButton equal = new JButton("=");
        equal.addActionListener(this);
        equal.setFocusable(false);
        equal.setBounds(0, 0, 328, 50);

        JButton clear = new JButton("C");
        clear.addActionListener(this);
        clear.setFocusable(false);

        //Create Display Panel
        JPanel displayPanel = new JPanel();
        displayPanel.setBounds(0, 0, 330, 60);
        displayPanel.setLocation(2, 10);
  //      displayPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        displayPanel.setBackground(Color.white);

        displayPanel.add(operatorBox);
        displayPanel.add(formula);
        displayPanel.add(displayScreen);

        //Panel for the EQUALS button
        JPanel equalPanel = new JPanel();
        equalPanel.setSize(330, 60);
        equalPanel.setLocation(2, 273);
    //    equalPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        equalPanel.setLayout(null);
        equalPanel.add(equal);


        //Create Button Panel
        JPanel buttonPanel = new JPanel();
      //  buttonPanel.setBackground(Color.blue);
        buttonPanel.setBounds(2, 80, panelWidth, panelHeight);
        buttonPanel.setLayout(new GridLayout(5, 4, 3, 3));
        buttonPanel.setFont(new Font("Tahoma", Font.BOLD, 20));
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(plus);
        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(minus);
        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);
        buttonPanel.add(multiply);
        buttonPanel.add(clear);
        buttonPanel.add(zero);
        buttonPanel.add(dot);
        buttonPanel.add(divide);




        //Create Frame
        JFrame frameUI = new JFrame();
        frameUI.setTitle("Calculator");
        frameUI.setSize(frameWidth, frameHeight);
        frameUI.setLayout(null);
        frameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUI.setResizable(false);
        frameUI.setLocationRelativeTo(null);
        frameUI.setVisible(true);


        //Add panel to frame
        frameUI.add(displayPanel);
        frameUI.add(equalPanel);
        frameUI.add(buttonPanel);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String x = e.getActionCommand();
        String currentText = displayScreen.getText();
        String operator = operatorBox.getText();

        if((x.equals("+")) || (x.equals("-")) || (x.equals("x")) || (x.equals("/"))){

            if(!currentText.isBlank()){
                if(operatorBox.getText().isBlank()){
                    firstVariable = currentText;
                    nextFlag = 1;
                }
                operatorBox.setText(x);
                formula.setText(currentText+" "+x);

            }

        } else if (x.equals("=")) {



            if(!firstVariable.isBlank() && nextFlag != 1 && showResult != 1 && !operand.isBlank()){
                secondVariable = currentText;
                String rez = new Compute(firstVariable, secondVariable, operand).compute();
                displayScreen.setText(rez);
                formula.setText(firstVariable+" "+operand+" "+secondVariable+" =");
                firstVariable = rez;
                secondVariable = "";
                operand = "";
                showResult = 1;


            }



        }
        else if (x.equals("C")) {

            operatorBox.setText("");
            displayScreen.setText("");
            formula.setText("");
            firstVariable = "0";
            secondVariable = "0";
            nextFlag = 0;
            showResult = 0;

        }
        else if (x.equals(".")) {

            if(nextFlag == 1) {
                //Send current display to variable1
                firstVariable = currentText;
                displayScreen.setText("0.");
                operand = operatorBox.getText();
                operatorBox.setText("");
                showResult = 0;
                nextFlag = 0;

            }

            if(currentText.isBlank() || showResult == 1) {
                displayScreen.setText("0.");
                showResult = 0;

            } else if (!currentText.contains(".")) {
                displayScreen.setText(currentText+x);
            }

        }
        else if (x.equals("0")) {



            if(!currentText.equals("0") && operatorBox.getText().isBlank()) {
                displayScreen.setText(currentText+x);
            }

            if(currentText.isBlank()){
                displayScreen.setText("0.");
            }

            if(nextFlag == 1) {
                //Send current display to variable1
                firstVariable = currentText;
                displayScreen.setText("0.");
                operand = operatorBox.getText();
                operatorBox.setText("");
                showResult = 0;
                nextFlag = 0;

            }

            if(showResult == 1){
                displayScreen.setText("0.");
                showResult = 0;
            }


        }else {
            if(nextFlag == 1) {
                //Send current display to variable1
                firstVariable = currentText;
                displayScreen.setText(x);
                operand = operatorBox.getText();
                operatorBox.setText("");
                showResult = 0;

            } else if (showResult == 1) {
                displayScreen.setText(x);
                formula.setText(x);
                showResult = 0;
            } else{
                displayScreen.setText(currentText + x);
            }
            nextFlag = 0;
        }
    }
}
