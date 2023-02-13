import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Helvetica", Font.PLAIN, 30);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clear");
        negButton = new JButton("(-)");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = eqButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        negButton.setBounds(30, 450, 100, 50);
        delButton.setBounds(150, 450, 100, 50);
        clrButton.setBounds(270, 450, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(numButtons[0]);
        panel.add(decButton);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(textfield);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc1 = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // decimal button
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        // add button
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        // subtract button
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        // multiply button
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        // divide button
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        // equals button - perform calculation
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case ('+'):
                    result = num1 + num2;
                    break;
                case ('-'):
                    result = num1 - num2;
                    break;
                case ('*'):
                    result = num1 * num2;
                    break;
                case ('/'):
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;

        }

        // clear button
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }

        // delete button
        if (e.getSource() == delButton) {
            String str = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }

        // negative button 
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= (-1);
            textfield.setText(String.valueOf(temp));
        }
    }
}