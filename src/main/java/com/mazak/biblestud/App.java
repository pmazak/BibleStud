package com.mazak.biblestud;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;

import javax.swing.*;


public class App extends JFrame {

    private File currentDoc; // the I/O file stream
    JButton button_random = new JButton();
    JButton button_prev = new JButton();
    JButton button_next = new JButton();
    JButton button_first = new JButton();
    JButton button_last = new JButton();
    JTextArea richEdit1 = new JTextArea();
    JLabel outof = new JLabel();
    JLabel denom = new JLabel();
    JLabel numer = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label2_wpm = new JLabel();
    JLabel label1_grade = new JLabel();
    JLabel label_time = new JLabel();
    JButton button_done = new JButton();
    JLabel label_verse = new JLabel();
    String file, verse, text, word, specific = new String();
    int start, finish;

    //char wordcount[]=new char[]);
    Timer timer = new Timer();
    int grade = 0;
    int wpm = 0, ilength = 0, num = 0, num2 = 0;
    int total = 1;
    boolean first_time = true;

    public App() {
        load();
        initForm();
    }

    public void load() {
        wpm = 0;
        grade = 0;
        timer.reset();

        label_time.setText(timer.toString());
        label2_wpm.setText(String.valueOf(wpm));
        label1_grade.setText(String.valueOf(grade));
        richEdit1.setText("");
        richEdit1.setFocusable(true);
        button_done.setText("");



        // Read in ANSI characters to edit buffer
        try {
            file = new String(Files.readAllBytes(Paths.get("verses.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ilength = (int)file.length();
        char reversedfile[] = new char[file.length()];

        // Now move each character in `text' to the right place in `reversedText'
        for (int i = 0; i < file.length(); i++) {
            reversedfile[i] = file.charAt(file.length() - i - 1);
        }

        // `reversedText' is an array; Java will not allow us to use `drawString' to
        //   print an array (it can only print Strings). So we create a new String
        //   that has exactly the same text as `reversedtext'
        String r_file = new String(reversedfile);
        int last = (int)r_file.indexOf("#");

        ilength -= last;


    }

    public void random(Object source, ActionEvent e) {
        load();
        file = file.substring(0, ilength);
        int numa = 0, numb = 0, numc = 0;
        num = (int)file.charAt(ilength - 2) - 48;
        if (file.charAt(ilength - 3) != '#') {
            num += 10 * ((int)file.charAt(ilength - 3) - 48);
        }
        if (file.charAt(ilength - 4) != '#') {
            num += 100 * ((int)file.charAt(ilength - 4) - 48);
        }
        total = num;
        num2 = 0;
        while (num2 == 0) {
            num2 = Math.round((float)Math.random() * num);
        }
        num = num2;
        int end = file.indexOf("#" + String.valueOf(num) + "#") - 2;
        int beg = 0;
        if (num > 1) {
            beg = file.indexOf("#" + String.valueOf(num - 1) + "#") + 5;
            if (num - 1 > 9) {
                beg++;
            }
            if (num - 1 > 99) {
                beg++;
            }
        }
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific = file.substring(beg, end);
        int line1 = (int)specific.indexOf("\n") - 1;
        verse = specific.substring(0, line1);
        text = file.substring(beg + line1 + 2, end);

        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void next(Object source, ActionEvent e) {
        load();
        file = file.substring(0, ilength);
        int save = num;
        num = (int)file.charAt(ilength - 2) - 48;
        if (file.charAt(ilength - 3) != '#') {
            num += 10 * ((int)file.charAt(ilength - 3) - 48);
        }
        if (file.charAt(ilength - 4) != '#') {
            num += 100 * ((int)file.charAt(ilength - 4) - 48);
        }
        total = num;
        save++;
        if (save > num) {
            save = 1;
        }
        num = save;
        int end = file.indexOf("#" + String.valueOf(num) + "#") - 2;
        int beg = 0;
        if (num > 1) {
            beg = file.indexOf("#" + String.valueOf(num - 1) + "#") + 5;
            if (num - 1 > 9) {
                beg++;
            }
            if (num - 1 > 99) {
                beg++;
            }
        }
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific = file.substring(beg, end);
        int line1 = (int)specific.indexOf("\n") - 1;
        verse = specific.substring(0, line1);
        text = file.substring(beg + line1 + 2, end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void prev(Object source, ActionEvent e) {
        load();
        file = file.substring(0, ilength);
        int save = num;
        num = (int)file.charAt(ilength - 2) - 48;
        if (file.charAt(ilength - 3) != '#') {
            num += 10 * ((int)file.charAt(ilength - 3) - 48);
        }
        if (file.charAt(ilength - 4) != '#') {
            num += 100 * ((int)file.charAt(ilength - 4) - 48);
        }
        total = num;
        save--;
        if (save < 1) {
            save = num;
        }
        num = save;
        int end = file.indexOf("#" + String.valueOf(num) + "#") - 2;
        int beg = 0;
        if (num > 1) {
            beg = file.indexOf("#" + String.valueOf(num - 1) + "#") + 5;
            if (num - 1 > 9) {
                beg++;
            }
            if (num - 1 > 99) {
                beg++;
            }
        }
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific = file.substring(beg, end);
        int line1 = (int)specific.indexOf("\n") - 1;
        verse = specific.substring(0, line1);
        text = file.substring(beg + line1 + 2, end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void first(Object source, ActionEvent e) {
        load();
        file = file.substring(0, ilength);
        num = 1;
        int end = file.indexOf("#" + String.valueOf(num) + "#") - 2;
        int beg = 0;
        if (num > 1) {
            beg = file.indexOf("#" + String.valueOf(num - 1) + "#") + 5;
            if (num - 1 > 9) {
                beg++;
            }
            if (num - 1 > 99) {
                beg++;
            }
        }
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific = file.substring(beg, end);
        int line1 = (int)specific.indexOf("\n") - 1;
        verse = specific.substring(0, line1);
        text = file.substring(beg + line1 + 2, end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void last(Object source, ActionEvent e) {
        load();
        file = file.substring(0, ilength);
        num = (int)file.charAt(ilength - 2) - 48;
        if (file.charAt(ilength - 3) != '#') {
            num += 10 * ((int)file.charAt(ilength - 3) - 48);
        }
        if (file.charAt(ilength - 4) != '#') {
            num += 100 * ((int)file.charAt(ilength - 4) - 48);
        }
        total = num;
        int end = file.indexOf("#" + String.valueOf(num) + "#") - 2;
        int beg = 0;
        if (num > 1) {
            beg = file.indexOf("#" + String.valueOf(num - 1) + "#") + 5;
            if (num - 1 > 9) {
                beg++;
            }
            if (num - 1 > 99) {
                beg++;
            }
        }
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific = file.substring(beg, end);
        int line1 = (int)specific.indexOf("\n") - 1;
        verse = specific.substring(0, line1);
        text = file.substring(beg + line1 + 2, end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void calc_score() {
        String per, sin = new String();
        int hundred = text.length();
        int score = 0, count = 0, i = 0;
        boolean looking = true;
        char perfect[] = new char[text.length()];
        per = text.toLowerCase();
        per.getChars(0, per.length(), perfect, 0);
        char sinners[] = new char[richEdit1.getText().length()];
        sin = richEdit1.getText().toLowerCase();
        sin.getChars(0, sin.length(), sinners, 0);

        while (count < sinners.length) {
            i = 0;
            looking = true;
            while (looking == true) {
                if (i < perfect.length) {
                    if (sinners[count] == perfect[i]) {
                        looking = false;
                        if (i < perfect.length) {
                            perfect[i] = '~';
                        }
                        score++;
                    }
                }
                if (i >= perfect.length && looking == true) {
                    looking = false;
                    score--;
                }
                //label1.setText(String.valueOf(score));
                //label2.setText(String.valueOf(hundred));

                i++;
            }
            count++;
        }
        //label1.setText(String.valueOf(score));
        //label2.setText(String.valueOf(hundred));
        float temp = (Math.round(((float)score * (float)100 / (float)hundred)));
        score = (int)temp;
        //score=perfect.length;;
        label1_grade.setText(String.valueOf(score));

    }

    private void richEdit1_textChanged(Object source, KeyEvent e) {
        if (button_done.getText().equals("")) {
            timer.start();
            button_done.setText("Clear");

        }
        if (richEdit1.getText().indexOf("\n") != -1) {
            float finish = timer.elapsedTime();
            timer.stop();
            //richEdit1.getText().getChars(0,richEdit1.getText().length(), wordcount[], 0);
            float chars = (float)richEdit1.getText().length();
            float min = finish / 60;
            wpm = (int)((chars / min) / 5);
            label2_wpm.setText(String.valueOf(wpm));
            label_time.setText(timer.toString());
            timer.reset();
            richEdit1.setText(richEdit1.getText().substring(0, richEdit1.getText().indexOf("\n")));
            calc_score();

        } else {
            label_time.setText(timer.toString());
        }
    }

    private void button_click(Object source, ActionEvent e) {
        if (button_done.getText().equals("Clear")) {
            wpm = 0;
            grade = 0;
            timer.reset();

            label_time.setText(timer.toString());
            label2_wpm.setText(String.valueOf(wpm));
            label1_grade.setText(String.valueOf(grade));
            richEdit1.setText("");
            richEdit1.setFocusable(true);
            richEdit1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button_done.setText("");
        }

    }



    /**
     * NOTE: The following code is required by the Visual J++ form
     * designer.  It can be modified using the form editor.  Do not
     * modify it using the code editor.
     */


    private void initForm() {
        //                this.setForeColor(Color.BLACK);
        this.setTitle("Bible Stud");
        //        this.setAutoScaleBaseSize(5, 13);
        //        this.setClientSize(381, 291);
        //        this.setStartPosition(1);

        //        button_random.setAllowDrop(true);
        button_random.setFont(Font.getFont(Font.SANS_SERIF));
        button_random.setLocation(175, 40);
        button_random.setSize(20, 20);
        //        button_random.setTabIndex(6);
        button_random.setText("?");
        button_random.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                random(this, e);
            }
        });

        //        button_prev.setAllowDrop(true);
        button_prev.setFont(Font.getFont(Font.SANS_SERIF));
        button_prev.setLocation(150, 40);
        button_prev.setSize(20, 20);
        //        button_prev.setTabIndex(6);
        button_prev.setText("<");
        button_prev.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                prev(this, e);
            }
        });

        //        button_next.setAllowDrop(true);
        button_next.setFont(Font.getFont(Font.SANS_SERIF));
        button_next.setLocation(200, 40);
        button_next.setSize(20, 20);
        //        button_next.setTabIndex(6);
        button_next.setText(">");
        button_next.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                next(this, e);
            }
        });


        //        button_first.setAllowDrop(true);
        button_first.setFont(Font.getFont(Font.SANS_SERIF));
        button_first.setLocation(120, 40);
        button_first.setSize(25, 20);
        //        button_first.setTabIndex(6);
        button_first.setText("<<");
        button_first.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                first(this, e);
            }
        });

        //        button_last.setAllowDrop(true);
        button_last.setFont(Font.getFont(Font.SANS_SERIF));
        button_last.setLocation(225, 40);
        button_last.setSize(25, 20);
        //        button_last.setTabIndex(6);
        button_last.setText(">>");
        button_last.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                last(this, e);
            }
        });

        richEdit1.setFont(Font.getFont(Font.SANS_SERIF));
        //        richEdit1.setForeColor(Color.WINDOWTEXT);
        richEdit1.setBackground(Color.lightGray);
        richEdit1.setLocation(40, 72);
        richEdit1.setSize(296, 136);
        richEdit1.setLineWrap(true);
        richEdit1.setWrapStyleWord(true);
        //        richEdit1.setTabIndex(0);
        richEdit1.setText("");
        richEdit1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                richEdit1_textChanged(this, e);
            }
        });
        outof.setFont(Font.getFont(Font.SANS_SERIF));
        //        outof.setForeColor(Color.BLACK);
        outof.setLocation(303, 5);
        outof.setSize(15, 20);
        //        outof.setTabIndex(5);
        //        outof.setTabStop(false);
        outof.setText("of");

        denom.setFont(Font.getFont(Font.SANS_SERIF));
        //        denom.setForeColor(Color.BLACK);
        denom.setLocation(321, 5);
        denom.setSize(20, 20);
        //        denom.setTabIndex(5);
        //        denom.setTabStop(false);

        numer.setFont(Font.getFont(Font.SANS_SERIF));
        //        numer.setForeColor(Color.BLACK);
        numer.setLocation(278, 5);
        numer.setSize(20, 20);
        //        numer.setTabIndex(5);
        //        numer.setTabStop(false);

        label1.setFont(Font.getFont(Font.SANS_SERIF));
        //        label1.setForeColor(Color.BLUE);
        label1.setLocation(192, 232);
        label1.setSize(56, 16);
        //        label1.setTabIndex(5);
        //        label1.setTabStop(false);
        label1.setText("Grade:");

        label2.setFont(Font.getFont(Font.SANS_SERIF));
        //        label2.setForeColor(Color.BLUE);
        label2.setLocation(200, 256);
        label2.setSize(56, 16);
        //        label2.setTabIndex(4);
        //        label2.setTabStop(false);
        label2.setText("WPM:");

        label_time.setFont(Font.getFont(Font.SANS_SERIF));
        //        label_time.setForeColor(Color.DARKGRAY);
        label_time.setLocation(140, 279);
        label_time.setSize(180, 16);
        //        label_time.setTabIndex(4);
        //        label_time.setTabStop(false);
        label_time.setText(timer.toString());

        label2_wpm.setFont(Font.getFont(Font.SANS_SERIF));
        //        label2_wpm.setForeColor(new Color(64, 0, 0));
        label2_wpm.setLocation(256, 256);
        label2_wpm.setSize(56, 20);
        //        label2_wpm.setTabIndex(3);
        //        label2_wpm.setTabStop(false);
        label2_wpm.setText(String.valueOf(wpm));
        label2_wpm.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        label1_grade.setFont(Font.getFont(Font.SANS_SERIF));
        //        label1_grade.setForeColor(new Color(64, 0, 0));
        label1_grade.setLocation(256, 232);
        label1_grade.setSize(56, 20);
        //        label1_grade.setTabIndex(2);
        //        label1_grade.setTabStop(false);
        label1_grade.setText(String.valueOf(grade));
        label1_grade.setBorder(BorderFactory.createCompoundBorder());

        //        button_done.setAllowDrop(true);
        button_done.setFont(Font.getFont(Font.SANS_SERIF));
        button_done.setLocation(94, 237);
        button_done.setSize(55, 32);
        //        button_done.setTabIndex(6);
        button_done.setText("");
        button_done.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                button_click(this, e);
            }
        });
        //        button_done.processKeyEvent(new KeyEvent());
        //        button_done.addOnKeyPress(new KeyPressEventHandler(this.button_keypress));

        label_verse.setFont(Font.getFont(Font.SANS_SERIF));
        //        label_verse.setForeColor(new Color(192, 0, 0));
        label_verse.setLocation(37, 16);
        label_verse.setSize(296, 24);
        //        label_verse.setTabIndex(7);
        //        label_verse.setTabStop(false);

        //        label_verse.setTextAlign(HorizontalAlignment.CENTER);

        this.add(denom);
        this.add(numer);
        this.add(outof);
        this.add(label_verse);
        this.add(label1_grade);
        this.add(label2_wpm);
        this.add(label2);
        this.add(label_time);
        this.add(label1);
        this.add(richEdit1);
        this.add(button_random);
        this.add(button_prev);
        this.add(button_next);
        this.add(button_first);
        this.add(button_last);
        this.add(button_done);
        //        Object source = new Object();
        //        ActionEvent e = new ActionEvent();
        random(null, null);
        //        richEdit1.focus();
    }
}
