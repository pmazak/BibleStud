package com.mazak.biblestud;
import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.html.*;
import com.ms.wfc.io.*;
import java.util.*;
import java.lang.System;
import Timer;
import java.math.*;


/**
 * This class can take a variable number of parameters on the command
 * file. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Form1' is
 * created in the main() method.
 */

public class Form1 extends Form
{
    private File currentDoc; // the I/O file stream
    Container components = new Container();
    Button button_random = new Button();
    Button button_prev = new Button();
    Button button_next = new Button();
    Button button_first = new Button();
    Button button_last = new Button();
    RichEdit richEdit1 = new RichEdit();
    Label outof = new Label();
    Label denom = new Label();
    Label numer = new Label();
    Label label1 = new Label();
    Label label2 = new Label();
    Label label2_wpm = new Label();
    Label label1_grade = new Label();
    Label label_time = new Label();
    Button button_done = new Button();
    Label label_verse = new Label();
    String file,verse,text,word,specific = new String();
    int start,finish;

    //char wordcount[]=new char[]);
    Timer timer = new Timer();
    int grade=0;
    int wpm=0,ilength=0,num=0,num2=0;
    int total=1;
    boolean first_time=true;



    public Form1()
    {
        // Required for Visual J++ Form Designer support
        initForm();

        //TODO: Add any constructor code after initForm call
    }

    /**
     * Form1 overrides dispose so it can clean up the
     * component list.
     */
    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
    public void load()
    {
        wpm=0;
        grade=0;
        timer.reset();

        label_time.setText(timer.toString());
        label2_wpm.setText(String.valueOf(wpm));
        label1_grade.setText(String.valueOf(grade));
        richEdit1.setText("");
        richEdit1.focus();
        button_done.setText("");



        // Open a File stream on that filename
        currentDoc = File.open("verses.txt");
        // Retrieve the length of the file
        ilength = (int)currentDoc.getLength();
        // Read in ANSI characters to edit buffer
        file=currentDoc.readStringCharsAnsi(ilength);
        // Close the file handle
        currentDoc.close();

        char reversedfile[] = new char[file.length()];

        // Now move each character in `text' to the right place in `reversedText'
        for (int i = 0; i < file.length(); i++)
        {
            reversedfile[i] = file.charAt(file.length() - i - 1);
        }

        // `reversedText' is an array; Java will not allow us to use `drawString' to
        //   print an array (it can only print Strings). So we create a new String
        //   that has exactly the same text as `reversedtext'
        String r_file = new String(reversedfile);
        int last = (int)r_file.indexOf("#");

        ilength-=last;


    }
    public void random(Object source, Event e)
    {
        load();
        file=file.substring(0,ilength);
        int numa=0,numb=0,numc=0;
        num = (int)file.charAt(ilength-2)-48;
        if (file.charAt(ilength-3)!='#')
        {
            num+=10*((int)file.charAt(ilength-3)-48);
        }
        if (file.charAt(ilength-4)!='#')
        {
            num+=100*((int)file.charAt(ilength-4)-48);
        }
        total=num;
        num2=0;
        while (num2 == 0)
        {
            num2 = Math.round((float)Math.random()*num);
        }
        num=num2;
        int end = file.indexOf("#"+String.valueOf(num)+"#")-2;
        int beg = 0;
        if (num > 1){beg = file.indexOf("#"+String.valueOf(num-1)+"#")+5;
            if (num-1>9){beg++;}
            if (num-1>99){beg++;}}
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific=file.substring(beg,end);
        int line1 = (int)specific.indexOf("\n")-1;
        verse=specific.substring(0,line1);
        text=file.substring(beg+line1+2,end);

        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void next(Object source, Event e)
    {
        load();
        file=file.substring(0,ilength);
        int save=num;
        num = (int)file.charAt(ilength-2)-48;
        if (file.charAt(ilength-3)!='#')
        {
            num+=10*((int)file.charAt(ilength-3)-48);
        }
        if (file.charAt(ilength-4)!='#')
        {
            num+=100*((int)file.charAt(ilength-4)-48);
        }
        total=num;
        save++;
        if (save > num){save=1;}
        num=save;
        int end = file.indexOf("#"+String.valueOf(num)+"#")-2;
        int beg = 0;
        if (num > 1){beg = file.indexOf("#"+String.valueOf(num-1)+"#")+5;
            if (num-1>9){beg++;}
            if (num-1>99){beg++;}  }
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific=file.substring(beg,end);
        int line1 = (int)specific.indexOf("\n")-1;
        verse=specific.substring(0,line1);
        text=file.substring(beg+line1+2,end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void prev(Object source, Event e)
    {
        load();
        file=file.substring(0,ilength);
        int save=num;
        num = (int)file.charAt(ilength-2)-48;
        if (file.charAt(ilength-3)!='#')
        {
            num+=10*((int)file.charAt(ilength-3)-48);
        }
        if (file.charAt(ilength-4)!='#')
        {
            num+=100*((int)file.charAt(ilength-4)-48);
        }
        total=num;
        save--;
        if (save < 1){save=num;}
        num=save;
        int end = file.indexOf("#"+String.valueOf(num)+"#")-2;
        int beg = 0;
        if (num > 1){beg = file.indexOf("#"+String.valueOf(num-1)+"#")+5;
            if (num-1>9){beg++;}
            if (num-1>99){beg++;}}
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific=file.substring(beg,end);
        int line1 = (int)specific.indexOf("\n")-1;
        verse=specific.substring(0,line1);
        text=file.substring(beg+line1+2,end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void first(Object source, Event e)
    {
        load();
        file=file.substring(0,ilength);
        num=1;
        int end = file.indexOf("#"+String.valueOf(num)+"#")-2;
        int beg = 0;
        if (num > 1){beg = file.indexOf("#"+String.valueOf(num-1)+"#")+5;
            if (num-1>9){beg++;}
            if (num-1>99){beg++;}}
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific=file.substring(beg,end);
        int line1 = (int)specific.indexOf("\n")-1;
        verse=specific.substring(0,line1);
        text=file.substring(beg+line1+2,end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void last(Object source, Event e)
    {
        load();
        file=file.substring(0,ilength);
        num = (int)file.charAt(ilength-2)-48;
        if (file.charAt(ilength-3)!='#')
        {
            num+=10*((int)file.charAt(ilength-3)-48);
        }
        if (file.charAt(ilength-4)!='#')
        {
            num+=100*((int)file.charAt(ilength-4)-48);
        }
        total=num;
        int end = file.indexOf("#"+String.valueOf(num)+"#")-2;
        int beg = 0;
        if (num > 1){beg = file.indexOf("#"+String.valueOf(num-1)+"#")+5;
            if (num-1>9){beg++;}
            if (num-1>99){beg++;}}
        //beg = file.indexOf(String.valueOf(1))-1;
        //beg=10;
        specific=file.substring(beg,end);
        int line1 = (int)specific.indexOf("\n")-1;
        verse=specific.substring(0,line1);
        text=file.substring(beg+line1+2,end);
        label_verse.setText(verse);
        denom.setText(String.valueOf(total));
        numer.setText(String.valueOf(num));
    }

    public void calc_score()
    {
        String per,sin=new String();
        int hundred=text.length();
        int score=0,count=0,i=0;
        boolean looking=true;
        char perfect[] = new char[text.length()];
        per=text.toLowerCase();
        per.getChars(0,per.length(),perfect,0);
        char sinners[] = new char[richEdit1.getText().length()];
        sin=richEdit1.getText().toLowerCase();
        sin.getChars(0,sin.length(),sinners,0);

        while (count<sinners.length)
        {
            i=0;
            looking=true;
            while (looking==true)
            {
                if (i<perfect.length){
                    if (sinners[count] == perfect[i])
                    {
                        looking=false;
                        if (i<perfect.length){perfect[i]='~';}
                        score++;
                    }
                }
                if (i>=perfect.length && looking==true)
                {
                    looking=false;
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
        float temp=(Math.round(((float)score*(float)100/(float)hundred)));
        score = (int)temp;
        //score=perfect.length;;
        label1_grade.setText(String.valueOf(score));

    }

    private void richEdit1_textChanged(Object source, Event e)
    {
        if (button_done.getText().equals(""))
        {
            timer.start();
            button_done.setText("Clear");

        }
        if (richEdit1.getText().indexOf("\n")!=-1)
        {
            float finish=timer.elapsedTime();
            timer.stop();
            //richEdit1.getText().getChars(0,richEdit1.getText().length(), wordcount[], 0);
            float chars=(float)richEdit1.getText().length();
            float min=finish/60;
            wpm=(int)((chars/min)/5);
            label2_wpm.setText(String.valueOf(wpm));
            label_time.setText(timer.toString());
            timer.reset();
            richEdit1.setText(richEdit1.getText().substring(0,richEdit1.getText().indexOf("\n")-1));
            calc_score();

        }
        else
        {
            label_time.setText(timer.toString());
        }
    }

    private void button_click(Object source, Event e)
    {
        if (button_done.getText().equals("Clear"))
        {
            wpm=0;
            grade=0;
            timer.reset();

            label_time.setText(timer.toString());
            label2_wpm.setText(String.valueOf(wpm));
            label1_grade.setText(String.valueOf(grade));
            richEdit1.setText("");
            richEdit1.focus();
            button_done.setText("");
        }

    }



    /**
     * NOTE: The following code is required by the Visual J++ form
     * designer.  It can be modified using the form editor.  Do not
     * modify it using the code editor.
     */


    private void initForm()
    {
        this.setForeColor(Color.BLACK);
        this.setText("Bible Stud");
        this.setAutoScaleBaseSize(new Point(5, 13));
        this.setClientSize(new Point(381, 291));
        this.setStartPosition(1);

        button_random.setAllowDrop(true);
        button_random.setFont(new Font("Microsoft Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        button_random.setLocation(new Point(175, 40));
        button_random.setSize(new Point(20, 20));
        button_random.setTabIndex(6);
        button_random.setText("?");
        button_random.addOnClick(new EventHandler(this.random));

        button_prev.setAllowDrop(true);
        button_prev.setFont(new Font("Microsoft Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        button_prev.setLocation(new Point(150, 40));
        button_prev.setSize(new Point(20, 20));
        button_prev.setTabIndex(6);
        button_prev.setText("<");
        button_prev.addOnClick(new EventHandler(this.prev));

        button_next.setAllowDrop(true);
        button_next.setFont(new Font("Microsoft Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        button_next.setLocation(new Point(200, 40));
        button_next.setSize(new Point(20, 20));
        button_next.setTabIndex(6);
        button_next.setText(">");
        button_next.addOnClick(new EventHandler(this.next));


        button_first.setAllowDrop(true);
        button_first.setFont(new Font("Microsoft Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        button_first.setLocation(new Point(125, 40));
        button_first.setSize(new Point(20, 20));
        button_first.setTabIndex(6);
        button_first.setText("<<");
        button_first.addOnClick(new EventHandler(this.first));

        button_last.setAllowDrop(true);
        button_last.setFont(new Font("Microsoft Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        button_last.setLocation(new Point(225, 40));
        button_last.setSize(new Point(20, 20));
        button_last.setTabIndex(6);
        button_last.setText(">>");
        button_last.addOnClick(new EventHandler(this.last));

        richEdit1.setFont(Font.DEFAULT_GUI);
        richEdit1.setForeColor(Color.WINDOWTEXT);
        richEdit1.setLocation(new Point(40, 72));
        richEdit1.setSize(new Point(296, 136));
        richEdit1.setTabIndex(0);
        richEdit1.setText("");
        richEdit1.addOnTextChanged(new EventHandler(this.richEdit1_textChanged));

        outof.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        outof.setForeColor(Color.BLACK);
        outof.setLocation(new Point(303, 5));
        outof.setSize(new Point(15, 20));
        outof.setTabIndex(5);
        outof.setTabStop(false);
        outof.setText("of");

        denom.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        denom.setForeColor(Color.BLACK);
        denom.setLocation(new Point(321, 5));
        denom.setSize(new Point(20, 20));
        denom.setTabIndex(5);
        denom.setTabStop(false);

        numer.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        numer.setForeColor(Color.BLACK);
        numer.setLocation(new Point(278, 5));
        numer.setSize(new Point(20, 20));
        numer.setTabIndex(5);
        numer.setTabStop(false);



        label1.setFont(new Font("Arial", 12.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        label1.setForeColor(Color.BLUE);
        label1.setLocation(new Point(192, 232));
        label1.setSize(new Point(56, 16));
        label1.setTabIndex(5);
        label1.setTabStop(false);
        label1.setText("Grade:");

        label2.setFont(new Font("Arial", 12.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        label2.setForeColor(Color.BLUE);
        label2.setLocation(new Point(200, 256));
        label2.setSize(new Point(56, 16));
        label2.setTabIndex(4);
        label2.setTabStop(false);
        label2.setText("WPM:");

        label_time.setFont(new Font("Arial", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        label_time.setForeColor(Color.DARKGRAY);
        label_time.setLocation(new Point(140, 279));
        label_time.setSize(new Point(180, 16));
        label_time.setTabIndex(4);
        label_time.setTabStop(false);
        label_time.setText(timer.toString());

        label2_wpm.setFont(new Font("Arial", 12.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        label2_wpm.setForeColor(new Color(64, 0, 0));
        label2_wpm.setLocation(new Point(256, 256));
        label2_wpm.setSize(new Point(56, 20));
        label2_wpm.setTabIndex(3);
        label2_wpm.setTabStop(false);
        label2_wpm.setText(String.valueOf(wpm));
        label2_wpm.setBorderStyle(BorderStyle.FIXED_3D);

        label1_grade.setFont(new Font("Arial", 12.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
        label1_grade.setForeColor(new Color(64, 0, 0));
        label1_grade.setLocation(new Point(256, 232));
        label1_grade.setSize(new Point(56, 20));
        label1_grade.setTabIndex(2);
        label1_grade.setTabStop(false);
        label1_grade.setText(String.valueOf(grade));
        label1_grade.setBorderStyle(BorderStyle.FIXED_3D);

        button_done.setAllowDrop(true);
        button_done.setFont(new Font("Microsoft Sans Serif", 12.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        button_done.setLocation(new Point(94, 237));
        button_done.setSize(new Point(55, 32));
        button_done.setTabIndex(6);
        button_done.setText("");
        button_done.addOnClick(new EventHandler(this.button_click));
        //button_done.addOnKeyPress(new KeyPressEventHandler(this.button_keypress));

        label_verse.setFont(new Font("Times New Roman", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
        label_verse.setForeColor(new Color(192, 0, 0));
        label_verse.setLocation(new Point(37, 16));
        label_verse.setSize(new Point(296, 24));
        label_verse.setTabIndex(7);
        label_verse.setTabStop(false);

        label_verse.setTextAlign(HorizontalAlignment.CENTER);

        this.setNewControls(new Control[] {
                denom,
                numer,
                outof,
                label_verse,
                label1_grade,
                label2_wpm,
                label2,
                label_time,
                label1,
                richEdit1,
                button_random,
                button_prev,
                button_next,
                button_first,
                button_last,
                button_done});
        Object source= new Object();
        Event e= new Event();

        random(source, e);
        richEdit1.focus();
    }

    /**
     * The main entry point for the application.
     *
     * @param args Array of parameters passed to the application
     * via the command file.
     */
    public static void main(String args[])
    {
        Application.run(new Form1());

    }
}

