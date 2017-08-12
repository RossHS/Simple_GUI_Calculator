package ru.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Ross on 10.08.2017.
 */
public class Calculator{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bsub,badd,bdec,beq,bdel;
    JTextField field;
    char operator;

    static double x, y, result;
    public static void main(String[] args) {
        new Calculator().calc();
    }

    public void calc() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        //задаем сетку для нашей панели
        panel.setLayout(new GridLayout(4,4));

        //задаем окно вывода и делаем его неизменяемым и
        //назначим стартовую позицию справа.
        field = new JTextField();
        field.setEditable(false);
        field.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(BorderLayout.NORTH, field);

        //задаем цвет панеле
        panel.setBackground(Color.CYAN);
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bdiv = new JButton("/");
        bmul = new JButton("*");
        bsub = new JButton("-");
        badd = new JButton("+");
        bdec = new JButton(".");
        beq = new JButton("=");
        bdel = new JButton("C");


        //Задаем шрифт
//        Font bigFont = new Font("serif", Font.BOLD,28);
//        b1.setFont(bigFont);

        //добавляем кнопки на панель
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bdiv);

        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bmul);

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bsub);

        panel.add(bdec);
        panel.add(b0);
        panel.add(beq);
        panel.add(badd);


        //Добавляем слушателя к кнопке
        b0.addActionListener(new b0Listener());
        b1.addActionListener(new b1Listener());
        b2.addActionListener(new b2Listener());
        b3.addActionListener(new b3Listener());
        b4.addActionListener(new b4Listener());
        b5.addActionListener(new b5Listener());
        b6.addActionListener(new b6Listener());
        b7.addActionListener(new b7Listener());
        b8.addActionListener(new b8Listener());
        b9.addActionListener(new b9Listener());
        bdiv.addActionListener(new bdivListener());
        bmul.addActionListener(new bmulListener());
        bsub.addActionListener(new bsubListener());
        bdec.addActionListener(new bdecListener());
        beq.addActionListener(new beqListener());
        badd.addActionListener(new baddListener());

        bdel.addActionListener(new bdelListener());


        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, bdel);


        //описываем панель полностью
        frame.pack();

        //задаем опред размер
        //frame.setSize(300,300);

        //не позволяем нашему фрейму менять размер
        frame.setResizable(false);


//        Можем установить начальное положение окна
//        frame.setLocation(1000,500);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //создаем внутр классы для реализации слушателя
    //concat() метод объединяет строки, путем добавления одной строки в конец к другой
    class b0Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("0"));
        }
    }

    class b1Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("1"));
        }
    }

    class b2Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("2"));
        }
    }

    class b3Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("3"));
        }
    }

    class b4Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("4"));
        }
    }

    class b5Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("5"));
        }
    }

    class b6Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("6"));
        }
    }

    class b7Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("7"));
        }
    }

    class b8Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("8"));
        }
    }

    class b9Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("9"));
        }
    }

    class bdivListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            x = Double.parseDouble(field.getText());
            operator = '/';
            field.setText("");
        }
    }

    class bmulListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            x = Double.parseDouble(field.getText());
            operator = '*';
            field.setText("");
        }
    }

    class bsubListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            x = Double.parseDouble(field.getText());
            operator = '-';
            field.setText("");
        }
    }

    class bdecListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(field.getText().concat("."));
        }
    }

    class beqListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            y = Double.parseDouble(field.getText());
            switch (operator){
                case '/':
                    result = x/y;
                    break;
                case '*':
                    result = x*y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '+':
                    //result += x;
                    result = x + y ;
                    break;

                default: result = 0;
            }
            field.setText("" + result);
            //x = 0;
        }
    }

    class baddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Забираем строку с экрана
            //и преобразовываем строку в тип double
            x = Double.parseDouble(field.getText());
            operator = '+';
            field.setText("");
        }
    }

    class bdelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            result = 0;
            y = 0;
            x = 0;
            operator = ' ';
            field.setText("");
        }
    }
}
