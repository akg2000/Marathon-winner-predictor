//Aman Kumar Gupta
//Roll no. 2018217

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Node{

    //data Encapsulation by making all attributes private;
    private String marathon_name;
    private String name;
    private int time;
    private Node next=null;

    //default Constructor
    Node(){
        this.name="UNKNOWN";
        this.time=0;
        this.marathon_name="UNKNOWN";
    }
    
    //constructor overloaded
    Node(String name,boolean m1,boolean m2,boolean m3,int time){
        this.name=name;
        this.time=time;
        if(m1){
            this.marathon_name="Great Delhi Run";
        }
        else if(m3){
            this.marathon_name="Open 10k Run";
        }
        else{
            this.marathon_name="Half Marathon";
        }
    }

    //getters and setters for abstraction of data so that we can access the data indirectly
    public Node getNext(){
        return this.next;
    }
    public void setNext(Node abc){
        this.next=abc;
    }
    public String getName(){
        return this.name;
    }
    public String getMarathon_name(){
        return this.marathon_name;
    }
    public int getTime(){
        return this.time;
    }
}

class Linkedlist{
    //data encapsulation
    private Node head;
    private Node curr;
    private static int size;

    Linkedlist(){
        this.head=null;
        this.curr=this.head;
        this.size=0;
    }
    //getter function for traversal
    public Node getHead(){
        return this.head;
    }

    //add function to add nodes into the linked list
    public void add(String name,boolean m1,boolean m2,boolean m3,int time){
        Node temp = new Node(name,m1,m2,m3,time);
        if(this.head==null){
            this.head=temp;
            this.curr=this.head;
        }
        else{
            this.curr.setNext(temp);
            this.curr=this.curr.getNext();
        }
        this.size++;
    }

}

class Runner{

    //data encapsulation
    private Linkedlist llr1;
    private int first1,first2,first3,second1,second2,second3;
    
    //constructor
    Runner(Linkedlist ll1){
        this.llr1=ll1;
    }

    //function for finding the winner
    public String[] findwinner(Linkedlist ll){
        
        first1=Integer.MAX_VALUE;
        second1=Integer.MAX_VALUE;
        first2=Integer.MAX_VALUE;
        second2=Integer.MAX_VALUE;
        first3=Integer.MAX_VALUE;
        second3=Integer.MAX_VALUE;
        Node temp;
        String winner11="",winner21="",winner31="",winner12="",winner22="",winner32="";    
        String[] ans = new String[6];
        temp=ll.getHead();
        while(temp!=null){

            if(temp.getMarathon_name()=="Great Delhi Run"){
                if(temp.getTime()<first1){
                    second1=first1;
                    first1=temp.getTime();
                    winner11=temp.getName();
                }
                else if(temp.getTime()<second1 && temp.getTime()!=first1){
                    second1=temp.getTime();
                    winner12=temp.getName();
                }
            }
            else if(temp.getMarathon_name()=="Open 10k Run"){
                if(temp.getTime()<first2){
                    second2=first2;
                    first2=temp.getTime();
                    winner21=temp.getName();
                }
                else if(temp.getTime()<second2 && temp.getTime()!=first2){
                    second2=temp.getTime();
                    winner22=temp.getName();
                }                
            }
            else{
                if(temp.getTime()<first3){
                    second3=first3;
                    first3=temp.getTime();
                    winner31=temp.getName();
                }
                else if(temp.getTime()<second3 && temp.getTime()!=first3){
                    second3=temp.getTime();
                    winner32=temp.getName();
                }                
            }
            temp=temp.getNext();
        }
        
        ans[0]=winner11;
        ans[1]=winner12;
        ans[2]=winner21;
        ans[3]=winner22;
        ans[4]=winner31;
        ans[5]=winner32;
        
        return ans;
    }
}

public class application{

    //data encapsulation of each variable as they are not required anywhere else
    private static JPanel panel_name;
    private static JLabel label_name;
    private static JTextField text_name;

    private static JPanel panel_time;
    private static JLabel label_time;
    private static JTextField text_time;

    private static JPanel panel_marathon;
    private static JLabel label_marathon;
    
    private static JPanel panel_buttons;

    private static JPanel panel_message;
    private static JLabel label_message;
    private static JTextField text_message;

    private static JPanel panel_gdr;
    private static JPanel panel_o1r;
    private static JPanel panel_hm;

    private static JLabel label_gdr;
    private static JLabel label_o1r;
    private static JLabel label_hm;

    private static JTextField text_gdr;
    private static JTextField text_o1r;
    private static JTextField text_hm;

    private static Linkedlist ll = new Linkedlist();
 
    public static void main(String[] args) {
        
        //creation of the main frame
        JFrame frame = new JFrame("Marathon");

        //creation of the main panel
        JPanel panel_main = new JPanel();
        panel_main.setLayout(new BoxLayout(panel_main,BoxLayout.Y_AXIS));

        //adding the first panel name
        panel_name = new JPanel();
        panel_name.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_main.add(panel_name);

        //adding label and textfield of name in the panel name which is attached to the main panel
        label_name = new JLabel("Name");
        panel_name.add(label_name);

        text_name = new JTextField();
        text_name.setPreferredSize(new Dimension(150,50));
        panel_name.add(text_name);

        //creation of the panel for time
        panel_time = new JPanel();
        panel_time.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_main.add(panel_time);

        //addtion of the label and textfield of the time panel
        label_time = new JLabel("Time");
        panel_time.add(label_time);

        text_time = new JTextField();
        text_time.setPreferredSize(new Dimension(150,50));
        panel_time.add(text_time);

        //creation of the marathon frame
        JPanel panel_marathon = new JPanel();
        panel_marathon.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label_marathon = new JLabel("Marathon : ");
        panel_marathon.add(label_marathon);
        panel_main.add(panel_marathon);

        //creation of the radio buttons for marathons and grouping them together
        ButtonGroup marathon_joined = new ButtonGroup();
        JRadioButton rb_Half_Marathon = new JRadioButton("Half Marathon");
        JRadioButton rb_Open_10k_Run = new JRadioButton("Open 10k Run");
        JRadioButton rb_Great_Delhi_Run = new JRadioButton("Great Delhi Run");

        marathon_joined.add(rb_Great_Delhi_Run);
        marathon_joined.add(rb_Half_Marathon);
        marathon_joined.add(rb_Open_10k_Run);

        panel_marathon.add(rb_Great_Delhi_Run);
        panel_marathon.add(rb_Half_Marathon);
        panel_marathon.add(rb_Open_10k_Run);

        rb_Great_Delhi_Run.setSelected(true);

        //panel for writing results
        JPanel panel_message = new JPanel();
        panel_message.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label_message = new JLabel("Results :");
        panel_message.add(label_message);
        panel_main.add(panel_message);

        //panel for showing results of great delhi run
        JPanel panel_gdr = new JPanel();
        panel_gdr.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label_gdr = new JLabel("Great Delhi Run");
        JTextField text_gdr = new JTextField();
        text_gdr.setPreferredSize(new Dimension(300,50));
        panel_gdr.add(label_gdr);
        panel_gdr.add(text_gdr);
        panel_main.add(panel_gdr);
        
        //creation of the panel for displaying results of the open 10k run
        JPanel panel_o1r = new JPanel();
        panel_o1r.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label_o1r = new JLabel("Open 10K Run");
        JTextField text_o1r = new JTextField();
        text_o1r.setPreferredSize(new Dimension(300,50));
        panel_o1r.add(label_o1r);
        panel_o1r.add(text_o1r);
        panel_main.add(panel_o1r);

        //creation of the panel for displaying half marathon
        JPanel panel_hm = new JPanel();
        panel_hm.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label_hm = new JLabel("Half Marathon");
        JTextField text_hm = new JTextField();
        text_hm.setPreferredSize(new Dimension(300,50));
        panel_hm.add(label_hm);
        panel_hm.add(text_hm);
        panel_main.add(panel_hm);

        //creation of panel and buttons for the respective panel , next,result and exit button
        JPanel panel_buttons = new JPanel();
        panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton button_next = new JButton("Next");
        JButton button_results = new JButton("Result");
        JButton button_exit = new JButton("Exit");

        //next button function for registering the data
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                String n = text_name.getText();
                text_name.setText("");
                boolean m1 = rb_Great_Delhi_Run.isSelected();
                boolean m2 = rb_Half_Marathon.isSelected();
                boolean m3 = rb_Open_10k_Run.isSelected();
                if(!text_time.getText().equals(""));{
                    int t = Integer.parseInt(text_time.getText());
                    ll.add(n,m1,m2,m3,t);
                }
                text_gdr.setText("");
                text_hm.setText("");
                text_o1r.setText("");
                text_time.setText("");
                System.out.println("done");
            }
        });

        //result button ofr calculating the result
        button_results.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent f){
                Runner r = new Runner(ll);
                String[] ans = new String[6];
                ans=r.findwinner(ll);
                if(ans[0]==""){
                    text_gdr.setText("Not Enough Participants");
                }
                else if(ans[0]!="" && ans[1]==""){
                    text_gdr.setText("1st "+ans[0]+" 1,35,000");
                }
                else{
                    text_gdr.setText("1st "+ans[0]+" 1,35,000 ; 2nd "+ans[1]+" 1,15,000");
                }
                if(ans[2]==""){
                    text_o1r.setText("Not Enough Participants");
                }
                else if(ans[2]!="" && ans[3]==""){
                    text_o1r.setText("1st "+ans[0]+" 1,90,000");
                }
                else{
                    text_o1r.setText("1st "+ ans[2]+" 1,90,000 ; 2nd "+ans[3]+" 1,50,000");
                }
                if(ans[4]==""){
                    text_hm.setText("Not Enough Participants");
                }
                else if(ans[4]!="" && ans[5]==""){
                    text_hm.setText("1st "+ans[0]+" 2,80,000");
                }
                else{
                    text_hm.setText("1st "+ans[4]+" 2,80,000 ; 2nd "+ans[5]+" 2,10,000");
                }
            }
        });

        //button for exiting the application
        button_exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent g){
                frame.dispose();
            }
        });

        panel_buttons.add(button_next);
        panel_buttons.add(button_results);
        panel_buttons.add(button_exit);
        panel_main.add(panel_buttons);


        //enabling the frame and setting it to visible and setting its size
        frame.add(panel_main);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}