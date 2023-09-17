import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class gui4 extends JFrame implements ActionListener {
    boolean limited = false, pvp,rev = false;
    HashMap<String,Hero> m1 = new HashMap<String,Hero>();
    HashMap<String,Hero> m2 = new HashMap<String,Hero>();
    JButton n,s,S,b1,b2,b3,b4, startButton, NextB1,NextB2,Undo,Back0, Back1,Back2, Ab, ab, hb, sb, tb, p1d1, p1d2, p1d3, p2d1, p2d2, p2d3, fa1,fa2,fa3,fb1,fb2,fb3,HA1,HA2,HA3,HB1,HB2,HB3,Home,playAgain;
    JLabel  startLabel,panel1Label,panel2Label,panel3Label, pvpPanel3Label,defendPanelLabel, fightPanelLabel,healPanelLabel,winPanelLabel,p1a1l,p1a2l,p1a3l,p2a1l,p2a2l,p2a3l,p1d1l,p1d2l,p1d3l,p2d1l,p2d2l,p2d3l;

    JPanel startPanel,panel1,panel2,panel3, pvpPanel3, defendPanel, fightPanel,healPanel,winPanel;

    int rounds, turn = 1, selected = 0,r = 1, damage;
    Player p1 = new Player(), p2;
    Computer computer;
    TextField panel3Textbox;
    String D1,D2,A1,A2;

    public void sortButtons(){
        if (computer.getDef().Class.equals(p2d1.getText())){
            p2d1.setBounds(900,450,300,60);
            p2d2.setBounds(1050,350,300,60);
            p2d3.setBounds(1050,550,300,60);

            fb1.setBounds(900,450,300,60);
            fb2.setBounds(1050,350,300,60);
            fb3.setBounds(1050,550,300,60);

            HB1.setBounds(900,450,300,60);
            HB2.setBounds(1050,350,300,60);
            HB3.setBounds(1050,550,300,60);

            p2d1l.setBounds(900,400,300,50);
            p2d2l.setBounds(1050,300,300,50);
            p2d3l.setBounds(1050,500,300,50);

            p2a1l.setBounds(900,500,300,50);
            p2a2l.setBounds(1050,400,300,50);
            p2a3l.setBounds(1050,600,300,50);
        }
        else if (computer.getDef().Class.equals(p2d2.getText())){
            p2d1.setBounds(1050,350,300,60);
            p2d2.setBounds(900,450,300,60);
            p2d3.setBounds(1050,550,300,60);

            fb1.setBounds(1050,350,300,60);
            fb2.setBounds(900,450,300,60);
            fb3.setBounds(1050,550,300,60);

            HB1.setBounds(1050,350,300,60);
            HB2.setBounds(900,450,300,60);
            HB3.setBounds(1050,550,300,60);

            p2d1l.setBounds(1050,300,300,50);
            p2d2l.setBounds(900,400,300,50);
            p2d3l.setBounds(1050,500,300,50);

            p2a1l.setBounds(1050,400,300,50);
            p2a2l.setBounds(900,500,300,50);
            p2a3l.setBounds(1050,600,300,50);
        }
        else{
            p2d1.setBounds(1050,350,300,60);
            p2d2.setBounds(1050,550,300,60);
            p2d3.setBounds(900,450,300,60);

            fb1.setBounds(1050,350,300,60);
            fb2.setBounds(1050,550,300,60);
            fb3.setBounds(900,450,300,60);

            HB1.setBounds(1050,350,300,60);
            HB2.setBounds(1050,550,300,60);
            HB3.setBounds(900,450,300,60);

            p2d1l.setBounds(1050,300,300,50);
            p2d2l.setBounds(1050,500,300,50);
            p2d3l.setBounds(900,400,300,50);

            p2a1l.setBounds(1050,400,300,50);
            p2a2l.setBounds(1050,600,300,50);
            p2a3l.setBounds(900,500,300,50);
        }

    }

    public void ComputerTurn(){
        if (turn == 2){
            p1d1l.setForeground(Color.RED);
            p1d2l.setForeground(Color.RED);
            p1d3l.setForeground(Color.RED);
            if (p1.FindSupport() && p1.support.nerfs > 0) {
                computer.getAt().Attack -= p1.support.Nerf();
                System.out.println("Computer " + computer.getDef().Class + " was nerfed");
                p1.support.nerfs--;
            }
            if (computer.FindSupport() && computer.getSupport().up > 0) {
                computer.getAt().Attack += computer.getSupport().Buff();
                computer.getSupport().up--;
                System.out.println("Computer " + computer.getAt().Class + " was buffed");
            }
            if (computer.FindAssassin() && computer.getAssassin().CutCount > 0) {
                m1.get(D1).HP -= computer.getAssassin().Bleed;
                System.out.println("Player 1 " + D1 + " is bleeding \t HP -" + computer.getAssassin().Bleed);
                computer.getAssassin().CutCount--;
            }
            if ((computer.FindHealer() && computer.getHealer().HP>0 && computer.getDef().HP<500)&& (r%2==0)||computer.FindHealer() &&computer.getHealer().Energy>=100){
                int heal;
                if ( computer.getHealer().Energy>=100){
                    heal = computer.getHealer().Super();
                }
                else{
                    heal = computer.getHealer().Skill();
                }
                if(p1.assassin!= null){
                    p1.assassin.CutCount =0;
                }
                computer.getDef().HP += heal;
                System.out.println("Computer "+ computer.getDef().Class+ " was healed to "+ computer.getDef().HP);
                p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                p2d1l.setForeground(new Color(10,255,120));
                p2d2l.setForeground(new Color(10,255,120));
                p2d3l.setForeground(new Color(10,255,120));
                if (computer.getDef().Class.equals(fb1.getText())){
                    p2d1l.setText(" +" +heal);
                    p2d1l.setVisible(true);
                }
                else if (computer.getDef().Class.equals(fb2.getText())){
                    p2d2l.setText(" +" +heal);
                    p2d2l.setVisible(true);
                }
                else{
                    p2d3l.setText(" +" +heal);
                    p2d3l.setVisible(true);
                }
            }
            else{
                System.out.println("Player 1 " + D1 + " had " + m1.get(D1).HP + " HP");
                if(computer.getAt().Energy>=100){
                    damage = computer.getAt().Super();
                }
                else if (r%2==0) {
                    damage = computer.getAt().Skill();
                }
                else{
                    damage= computer.getAt().Normal();
                }
                if(m1.get(D1).Class.equals("tank")){
                    if (damage > p1.tank.Shield){
                        p1.tank.HP -= (damage - p1.tank.Shield);
                    }
                    else{
                        damage = 0;
                        p1d1l.setForeground(Color.lightGray);
                        p1d2l.setForeground(Color.lightGray);
                        p1d3l.setForeground(Color.lightGray);

                    }
                    p1.tank.Shield = 50;
                }
                else{
                    m1.get(D1).HP -= damage;
                }
                if (D1.equals(fa1.getText())){
                    p1d1l.setText(" -" +damage);
                    p1d1l.setVisible(true);
                }
                else if (D1.equals(fa2.getText())){
                    p1d2l.setText(" -" +damage);
                    p1d2l.setVisible(true);
                }
                else{
                    p1d3l.setText(" -" +damage);
                    p1d3l.setVisible(true);
                }
                if (m1.get(D1).HP < 0) {
                    m1.get(D1).HP = 0;
                    System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                    p1.alive--;
                    if (p1.alive == 0) {
                        winPanelLabel.setText("Computer won!");
                        winPanel.setEnabled(true);
                        winPanel.setVisible(true);
                    }
                    else {
                        defendPanelLabel.setText("Select your defending hero");
                        defendPanel.setEnabled(true);
                        defendPanel.setVisible(true);
                    }
                    fightPanel.setVisible(false);
                    fightPanel.setEnabled(false);
                }

                else{
                    System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                }
                p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
            }
            if (computer.FindSupport() && computer.getSupport().Skips>0){
                System.out.println(("Player 1 was frozen"));
                fa1.setEnabled(false);
                fa2.setEnabled(false);
                fa3.setEnabled(false);
                if (p1.assassin!=null && p1.assassin.CutCount>0){
                    computer.getDef().HP-= p1.assassin.Bleed;
                    System.out.println("Computer " +computer.getDef().Class + " is bleeding \t HP -"+p1.assassin.Bleed);
                    p1.assassin.CutCount--;
                }
                computer.getSupport().Skips--;
                ComputerTurn();
            }

            if (m1.get(fa1.getText()).HP>0){
                fa1.setEnabled(true);
            }
            else{
                fa1.setEnabled(false);
            }
            if (m1.get(fa2.getText()).HP>0){
                fa2.setEnabled(true);
            }
            else{
                fa2.setEnabled(false);
            }
            if (m1.get(fa3.getText()).HP>0){
                fa3.setEnabled(true);
            }
            else{
                fa3.setEnabled(false);
            }

        }
        r++;
        fightPanelLabel.setText("Round "+ r);
        turn = 1;
    }

    public gui4(){
        this.setSize(1600, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon("sample cover.jpg");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(100, 60, 140));

        startPanel = new JPanel();
        startLabel = new JLabel("Contest of Heroes");
        startButton = new JButton();

        panel1 = new JPanel();
        panel1Label = new JLabel();
        b1 = new JButton();
        b2 = new JButton();
        Back0 = new JButton();

        panel2 = new JPanel();
        panel2Label = new JLabel();
        b3 = new JButton();
        b4 = new JButton();
        Back1 = new JButton();

        panel3 = new JPanel();
        panel3Label = new JLabel();
        panel3Textbox = new TextField();
        NextB1 = new JButton();

        pvpPanel3 = new JPanel();
        pvpPanel3Label = new JLabel();
        NextB2 = new JButton();
        Undo = new JButton();
        Back2 = new JButton();
        Ab = new JButton();
        ab = new JButton();
        hb = new JButton();
        sb = new JButton();
        tb = new JButton();

        defendPanel = new JPanel();
        defendPanelLabel = new JLabel();
        p1d1 = new JButton();
        p1d2 = new JButton();
        p1d3 = new JButton();
        p2d1 = new JButton();
        p2d2 = new JButton();
        p2d3 = new JButton();

        fightPanel = new JPanel();
        fightPanelLabel = new JLabel();
        fa1 = new JButton();
        fa2 = new JButton();
        fa3 = new JButton();
        fb1 = new JButton();
        fb2 = new JButton();
        fb3 = new JButton();

        p1a1l = new JLabel();
        p1a2l = new JLabel();
        p1a3l = new JLabel();
        p1d1l = new JLabel();
        p1d2l = new JLabel();
        p1d3l = new JLabel();

        p2a1l = new JLabel();
        p2a2l = new JLabel();
        p2a3l = new JLabel();
        p2d1l = new JLabel();
        p2d2l = new JLabel();
        p2d3l = new JLabel();
        n = new JButton();
        s = new JButton();
        S =new JButton();

        healPanel = new JPanel();
        healPanelLabel = new JLabel();
        HA1 = new JButton();
        HA2 = new JButton();
        HA3 = new JButton();
        HB1 = new JButton();
        HB2 = new JButton();
        HB3 = new JButton();

        winPanel = new JPanel();
        winPanelLabel = new JLabel();
        Home = new JButton();
        playAgain = new JButton();

        startPanel.setLayout(null);
        startPanel.setBackground(new Color(100, 60, 140));
        startPanel.setSize(1600, 800);


        startLabel.setBounds(300,300,1200,100);
        startLabel.setFont(new Font("Arial",Font.BOLD,120));
        startLabel.setForeground(new Color(255,30,0));
        startPanel.add(startLabel);
        startLabel.setVisible(true);

        startButton.setBounds(400, 500, 600, 100);
        startButton.setText("Click to start");
        startPanel.add(startButton);
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Comic Sans", Font.BOLD,50));
        startButton.setBorder(BorderFactory.createCompoundBorder());
        startButton.setEnabled(true);
        startButton.setVisible(true);

        this.add(startPanel);
        this.add(panel1);
        panel1.setVisible(false);
        panel1.setEnabled(false);
        panel1.setLayout(null);
        panel1.setBackground(new Color(100, 60, 140));
        panel1.setSize(1600, 800);

        panel1Label.setText("Choose your game mode");
        panel1Label.setVisible(false);
        panel1Label.setBounds(350, 200, 1200, 100);
        panel1Label.setFont(new Font("Arial", Font.BOLD, 60));
        panel1Label.setForeground(new Color(255, 30, 0));
        panel1Label.setVisible(true);
        panel1.add(panel1Label);

        b1.setBounds(500, 400, 400, 80);
        panel1.add(b1);
        b1.addActionListener(this);
        b1.setText("PvP");
        b1.setFocusable(false);
        b1.setFont(new Font("Comic Sans", Font.BOLD,35));
        b1.setBorder(BorderFactory.createCompoundBorder());
        b1.setEnabled(true);
        b1.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1){
                    pvp = true;
                    computer = null;
                    p2 = new Player();
                    fightPanelLabel.setText("Round "+ r+" Player 1 turn");
                    pvpPanel3Label.setText("Player 1 choose your Heroes");
                    defendPanelLabel.setText("Player 1 choose your defending Hero");
                    panel2.setEnabled(true);
                    panel2.setVisible(true);
                    panel1.setVisible(false);
                    panel1.setEnabled(false);
                }
            }
        });

        b2.setBounds(500, 600, 400, 80);
        panel1.add(b2);
        b2.addActionListener(this);
        b2.setText("PvE");
        b2.setFocusable(false);
        b2.setFont(new Font("Comic Sans", Font.BOLD,35));
        b2.setBorder(BorderFactory.createCompoundBorder());
        b2.setEnabled(true);
        b2.setVisible(true);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2){
                    pvp = false;
                    p2 = null;
                    fightPanelLabel.setText("Round "+ r);
                    pvpPanel3Label.setText("Choose your Heroes");
                    defendPanelLabel.setText("Choose your defending Hero");
                    computer = new Computer();
                    p2d1.setText(computer.chosen[0].Class);
                    p2d2.setText(computer.chosen[1].Class);
                    p2d3.setText(computer.chosen[2].Class);
                    fb1.setText(computer.chosen[0].Class);
                    fb2.setText(computer.chosen[1].Class);
                    fb3.setText(computer.chosen[2].Class);
                    HB1.setText(computer.chosen[0].Class);
                    HB2.setText(computer.chosen[1].Class);
                    HB3.setText(computer.chosen[2].Class);
                    p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                    p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                    p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                    panel2.setEnabled(true);
                    panel2.setVisible(true);
                    panel1.setVisible(false);
                    panel1.setEnabled(false);
                }
            }
        });

        Back0.setText("Back");
        Back0.setFocusable(false);
        Back0.setBounds(50,50,400,100);
        Back0.setFont(new Font("Arial",Font.BOLD,35));
        Back0.setVisible(true);
        Back0.setEnabled(true);
        panel1.add(Back0);
        Back0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Back0) {
                    panel1.setVisible(false);
                    panel1.setEnabled(false);
                    startPanel.setVisible(true);
                    startPanel.setEnabled(true);
                }
            }
        });

        panel2.setLayout(null);
        panel2.setBackground(new Color(100, 60, 140));
        panel2.setSize(1600, 800);

        panel2Label.setText("Rounds or Deathmatch");
        panel2Label.setVisible(false);
        panel2Label.setBounds(350, 200, 1200, 100);
        panel2Label.setFont(new Font("Arial", Font.BOLD, 60));
        panel2Label.setForeground(new Color(255, 30, 0));
        panel2Label.setVisible(true);
        panel2.add(panel2Label);

        b3.setBounds(500, 400, 400, 80);
        panel2.add(b3);
        b3.addActionListener(this);
        b3.setText("Rounds");
        b3.setFocusable(false);
        b3.setFont(new Font("Comic Sans", Font.BOLD,35));
        b3.setBorder(BorderFactory.createCompoundBorder());
        b3.setEnabled(true);
        b3.setVisible(true);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3){
                    limited = true;
                    panel2.setEnabled(false);
                    panel2.setVisible(false);
                    panel3.setEnabled(true);
                    panel3.setVisible(true);
                }
            }
        });

        b4.setBounds(500, 600, 400, 80);
        panel2.add(b4);
        b4.addActionListener(this);
        b4.setText("Deathmatch");
        b4.setFocusable(false);
        b4.setFont(new Font("Comic Sans", Font.BOLD,35));
        b4.setBorder(BorderFactory.createCompoundBorder());
        b4.setEnabled(true);
        b4.setVisible(true);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b4){
                    limited = false;
                    panel2.setVisible(false);
                    panel2.setEnabled(false);
                    pvpPanel3.setVisible(true);
                    pvpPanel3.setEnabled(true);
                }
            }
        });

        Back1.setText("Back");
        Back1.setFocusable(false);
        Back1.setBounds(50,50,400,100);
        Back1.setFont(new Font("Arial",Font.BOLD,35));
        Back1.setVisible(true);
        Back1.setEnabled(true);
        panel2.add(Back1);
        Back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Back1) {
                    panel2.setVisible(false);
                    panel2.setEnabled(false);
                    panel1.setVisible(true);
                    panel1.setEnabled(true);
                }
            }
        });

        this.add(panel2);
        panel2.setEnabled(false);
        panel2.setVisible(false);

        panel3.setLayout(null);
        panel3.setBackground(new Color(100, 60, 140));
        panel3.setSize(1600, 800);
        this.add(panel3);
        panel3.setEnabled(false);
        panel3.setVisible(false);

        panel3Label.setText("How many rounds do you want to play?");
        panel3Label.setBounds(200, 150, 1000, 100);
        panel3Label.setFont(new Font("Arial", Font.BOLD, 40));
        panel3Label.setForeground(new Color(255, 30, 0));
        panel3Label.setVisible(true);
        panel3.add(panel3Label);

        panel3Textbox.setBounds(400, 310, 400, 50);
        panel3Textbox.setFont(new Font("Arial", Font.BOLD, 50));
        panel3Textbox.setVisible(true);
        panel3Textbox.setEnabled(true);
        panel3.add(panel3Textbox);

        NextB1.setBounds(500, 400, 400, 80);
        panel3.add(NextB1);
        NextB1.addActionListener(this);
        NextB1.setText("Next");
        NextB1.setFocusable(false);
        NextB1.setFont(new Font("Comic Sans", Font.BOLD,35));
        NextB1.setBorder(BorderFactory.createCompoundBorder());
        NextB1.setEnabled(true);
        NextB1.setVisible(true);
        NextB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == NextB1){
                    rounds = Integer.parseInt(panel3Textbox.getText());
                    System.out.println(rounds +" rounds");
                    panel3.setVisible(false);
                    panel3.setEnabled(false);
                    pvpPanel3.setVisible(true);
                    pvpPanel3.setEnabled(true);
                }
            }
        });

        this.add(pvpPanel3);
        pvpPanel3.setVisible(false);
        pvpPanel3.setEnabled(false);
        pvpPanel3.setLayout(null);
        pvpPanel3.setBackground(new Color(100, 60, 140));
        pvpPanel3.setSize(1600, 800);

        pvpPanel3Label.setVisible(true);
        pvpPanel3Label.setBounds(200, 150, 1200, 100);
        pvpPanel3Label.setFont(new Font("Arial", Font.BOLD, 60));
        pvpPanel3Label.setForeground(new Color(255, 30, 0));
        pvpPanel3Label.setVisible(true);
        pvpPanel3.add(pvpPanel3Label);

        NextB2.setBounds(1000, 600, 120, 90);
        pvpPanel3.add(NextB2);
        NextB2.addActionListener(this);
        NextB2.setText("Next");
        NextB2.setFocusable(false);
        NextB2.setFont(new Font("Comic Sans", Font.BOLD,35));
        NextB2.setBorder(BorderFactory.createCompoundBorder());
        NextB2.setEnabled(false);
        NextB2.setVisible(true);
        NextB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == NextB2){
                    pvpPanel3.setEnabled(false);
                    pvpPanel3.setVisible(false);
                    if (pvp){
                        defendPanelLabel.setText("Player 1 choose your defending Hero");
                    }
                    else{
                        defendPanelLabel.setText("Choose your defending Hero");
                    }
                    fa1.setEnabled(true);
                    fa2.setEnabled(true);
                    fa3.setEnabled(true);

                    fb1.setEnabled(false);
                    fb2.setEnabled(false);
                    fb3.setEnabled(false);
                    p2d1.setEnabled(false);
                    p2d2.setEnabled(false);
                    p2d3.setEnabled(false);

                    defendPanel.setEnabled(true);
                    defendPanel.setVisible(true);
                    turn = 1;
                }
            }
        });

        Undo.setBounds(1100, 100, 120, 90);
        pvpPanel3.add(Undo);
        Undo.addActionListener(this);
        Undo.setText("Undo");
        Undo.setFocusable(false);
        Undo.setFont(new Font("Comic Sans", Font.BOLD,35));
        Undo.setBorder(BorderFactory.createCompoundBorder());
        Undo.setEnabled(true);
        Undo.setVisible(true);
        Undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Undo){
                    p1.assassin = null;
                    p1.assault= null;
                    p1.healer = null;
                    p1.support = null;
                    p1.tank = null;
                    if (pvp){
                        pvpPanel3Label.setText("Player 1 choose your Heroes");
                        p2.assassin = null;
                        p2.assault= null;
                        p2.healer = null;
                        p2.support = null;
                        p2.tank = null;
                    }
                    else{
                        pvpPanel3Label.setText("Choose your Heroes");
                    }
                    selected = 0;
                    turn = 1;
                    Ab.setEnabled(true);
                    ab.setEnabled(true);
                    hb.setEnabled(true);
                    sb.setEnabled(true);
                    tb.setEnabled(true);

                }
            }
        });

        Back2.setText("Back");
        Back2.setFocusable(false);
        Back2.setBounds(50,50,400,100);
        Back2.setFont(new Font("Arial",Font.BOLD,35));
        Back2.setVisible(true);
        Back2.setEnabled(true);
        pvpPanel3.add(Back2);
        Back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== Back2){
                    NextB2.setEnabled(false);
                    pvpPanel3.setVisible(false);
                    pvpPanel3.setEnabled(false);
                    if(pvp){
                        pvpPanel3Label.setText("Player 1 choose your Heroes");
                    }
                    else{
                        pvpPanel3Label.setText("Choose your Heroes");
                    }
                    selected = 0;
                    turn = 1;
                    Ab.setEnabled(true);
                    ab.setEnabled(true);
                    hb.setEnabled(true);
                    sb.setEnabled(true);
                    tb.setEnabled(true);
                    panel2.setVisible(true);
                    panel2.setEnabled(true);
                }
            }
        });

        Ab.setVisible(true);
        Ab.setEnabled(true);
        Ab.setBounds(300, 400, 200, 60);
        Ab.addActionListener(this);
        Ab.setText("Assault");
        Ab.setFocusable(false);
        Ab.setFont(new Font("Comic Sans", Font.BOLD,35));
        Ab.setBorder(BorderFactory.createCompoundBorder());
        pvpPanel3.add(Ab);
        Ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Ab ) {
                    if (selected < 3 && turn==1) {
                        Ab.setEnabled(false);
                        p1.assault = new Assault();
                        m1.put("assault",p1.assault);
                        p1.chosen[selected] = p1.assault;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                fa2.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp ){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose your Heroes");
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                    }
                    else if (selected < 3 && turn==2) {
                        Ab.setEnabled(false);
                        p2.assault = new Assault();
                        m2.put("assault",p2.assault);
                        p2.chosen[selected] = p2.assault;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(fb1.getText()).HP));
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(fb2.getText()).HP));
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(fb3.getText()).HP));

                            default:
                        }
                        selected++;
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        ab.setVisible(true);
        ab.setEnabled(true);
        ab.setBounds(650, 400, 200, 60);
        ab.addActionListener(this);
        ab.setText("Assassin");
        ab.setFocusable(false);
        ab.setFont(new Font("Comic Sans", Font.BOLD,35));
        ab.setBorder(BorderFactory.createCompoundBorder());
        pvpPanel3.add(ab);
        ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ab ) {
                    if (selected < 3 && turn==1) {
                        ab.setEnabled(false);
                        p1.assassin = new Assassin();
                        m1.put("assassin",p1.assassin);
                        p1.chosen[selected] = p1.assassin;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(fa1.getText()).HP));
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(fa2.getText()).HP));
                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(fa3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose your Heroes");
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                    }
                    else if (selected < 3 && turn==2) {
                        ab.setEnabled(false);
                        p2.assassin = new Assassin();
                        m2.put("assassin",p2.assassin);
                        p2.chosen[selected] = p2.assassin;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(fb1.getText()).HP));
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(fb2.getText()).HP));
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(fb3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        hb.setVisible(true);
        hb.setEnabled(true);
        hb.setBounds(1000, 400, 200, 60);
        hb.addActionListener(this);
        hb.setText("Healer");
        hb.setFocusable(false);
        hb.setFont(new Font("Comic Sans", Font.BOLD,35));
        hb.setBorder(BorderFactory.createCompoundBorder());
        pvpPanel3.add(hb);
        hb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == hb ) {
                    if (selected < 3 && turn==1) {
                        hb.setEnabled(false);
                        p1.healer = new Healer();
                        m1.put("healer",p1.healer);
                        p1.chosen[selected] = p1.healer;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(fa1.getText()).HP));
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(fa2.getText()).HP));
                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(fa3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp ){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose your Heroes");
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                    }
                    else if (selected < 3 && turn==2) {
                        hb.setEnabled(false);
                        p2.healer = new Healer();
                        m2.put("healer",p2.healer);
                        p2.chosen[selected] = p2.healer;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(fb1.getText()).HP));
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(fb2.getText()).HP));
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(fb3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        sb.setVisible(true);
        sb.setEnabled(true);
        sb.setBounds(400, 650, 200, 60);
        sb.addActionListener(this);
        sb.setText("Support");
        sb.setFocusable(false);
        sb.setFont(new Font("Comic Sans", Font.BOLD,35));
        sb.setBorder(BorderFactory.createCompoundBorder());
        pvpPanel3.add(sb);
        sb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sb ) {
                    if (selected < 3 && turn==1) {
                        sb.setEnabled(false);
                        p1.support = new Support();
                        m1.put("support",p1.support);
                        p1.chosen[selected] = p1.support;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(fa1.getText()).HP));
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(fa2.getText()).HP));
                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(fa3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose your Heroes");
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                    }
                    else if (selected < 3 && turn==2) {
                        sb.setEnabled(false);
                        p2.support = new Support();
                        m2.put("support",p2.support);
                        p2.chosen[selected] = p2.support;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(fb1.getText()).HP));
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(fb2.getText()).HP));
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(fb3.getText()).HP));

                            default:
                        }
                        selected++;
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        tb.setVisible(true);
        tb.setEnabled(true);
        tb.setBounds(750, 650, 200, 60);
        tb.addActionListener(this);
        tb.setText("Tank");
        tb.setFocusable(false);
        tb.setFont(new Font("Comic Sans", Font.BOLD,35));
        tb.setBorder(BorderFactory.createCompoundBorder());
        pvpPanel3.add(tb);
        tb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tb ) {
                    if (selected < 3 && turn==1) {
                        tb.setEnabled(false);
                        p1.tank = new Tank();
                        m1.put("tank",p1.tank);
                        p1.chosen[selected] = p1.tank;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(fa1.getText()).HP));
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(fa2.getText()).HP));
                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(fa3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose your Heroes");
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                    }
                    else if (selected < 3 && turn==2 ) {
                        tb.setEnabled(false);
                        p2.tank = new Tank();
                        m2.put("tank",p2.tank);
                        p2.chosen[selected] = p2.tank;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(fb1.getText()).HP));
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(fb2.getText()).HP));
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(fb3.getText()).HP));
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        this.add(defendPanel);
        defendPanel.add(defendPanelLabel);
        defendPanel.setEnabled(false);
        defendPanel.setVisible(false);

        defendPanel.setLayout(null);
        defendPanel.setBackground(new Color(100, 60, 140));
        defendPanel.setSize(1600, 800);
        this.add(defendPanel);
        defendPanel.setVisible(false);
        defendPanel.setEnabled(false);

        defendPanelLabel.setVisible(true);
        defendPanelLabel.setBounds(200, 150, 1200, 100);
        defendPanelLabel.setFont(new Font("Arial", Font.BOLD, 60));
        defendPanelLabel.setForeground(new Color(255, 30, 0));
        defendPanel.add(defendPanelLabel);

        p1d1.setFocusable(false);
        p1d1.setBounds(50,350,300,60);
        p1d1.setFont(new Font("Comic Sans", Font.BOLD,35));
        defendPanel.add(p1d1);
        p1d1.setVisible(true);
        p1d1.setEnabled(true);
        p1d1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p1d1){
                    D1 = p1d1.getText();
                    p1d1.setBounds(150,450,300,60);
                    p1d2.setBounds(50,350,300,60);
                    p1d3.setBounds(50,550,300,60);

                    fa1.setBounds(150,450,300,60);
                    fa2.setBounds(50,350,300,60);
                    fa3.setBounds(50,550,300,60);

                    HA1.setBounds(150,450,300,60);
                    HA2.setBounds(50,350,300,60);
                    HA3.setBounds(50,550,300,60);

                    p1d1l.setBounds(150,400,300,50);
                    p1d2l.setBounds(50,300,300,50);
                    p1d3l.setBounds(50,500,300,50);

                    p1a1l.setBounds(150,500,300,50);
                    p1a2l.setBounds(50,400,300,50);
                    p1a3l.setBounds(50,600,300,50);
                    p1d1.setEnabled(false);
                    if (pvp && m2.get(D2)== null){
                        defendPanelLabel.setText("Player 2 choose your defending hero");
                        p2d1.setEnabled(true);
                        p2d2.setEnabled(true);
                        p2d3.setEnabled(true);
                    }
                    else {
                        fb1.setEnabled(false);
                        fb2.setEnabled(false);
                        fb3.setEnabled(false);
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                        defendPanel.setVisible(false);
                        defendPanel.setEnabled(false);
                        fightPanel.setEnabled(true);
                        fightPanel.setVisible(true);
                    }
                }
            }
        });

        p1d2.setFocusable(false);
        p1d2.setBounds(150,450,300,60);
        p1d2.setFont(new Font("Comic Sans", Font.BOLD,35));
        defendPanel.add(p1d2);
        p1d2.setVisible(true);
        p1d2.setEnabled(true);
        p1d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p1d2){
                    D1 = p1d2.getText();
                    p1d1.setBounds(50,350,300,60);
                    p1d2.setBounds(150,450,300,60);
                    p1d3.setBounds(50,550,300,60);

                    fa1.setBounds(50,350,300,60);
                    fa2.setBounds(150,450,300,60);
                    fa3.setBounds(50,550,300,60);

                    HA1.setBounds(50,350,300,60);
                    HA2.setBounds(150,450,300,60);
                    HA3.setBounds(50,550,300,60);

                    p1d1l.setBounds(50,300,300,50);
                    p1d2l.setBounds(150,400,300,50);
                    p1d3l.setBounds(50,500,300,50);

                    p1a1l.setBounds(50,400,300,50);
                    p1a2l.setBounds(150,500,300,50);
                    p1a3l.setBounds(50,600,300,50);
                    p1d2.setEnabled(false);
                    if (pvp && m2.get(D2)== null) {
                        defendPanelLabel.setText("Player 2 choose your defending hero");
                        p2d1.setEnabled(true);
                        p2d2.setEnabled(true);
                        p2d3.setEnabled(true);
                    }
                    else {
                        fb1.setEnabled(false);
                        fb2.setEnabled(false);
                        fb3.setEnabled(false);
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                        defendPanel.setVisible(false);
                        defendPanel.setEnabled(false);
                        fightPanel.setEnabled(true);
                        fightPanel.setVisible(true);
                    }
                }
            }
        });


        p1d3.setFocusable(false);
        p1d3.setBounds(50,550,300,60);
        p1d3.setFont(new Font("Comic Sans", Font.BOLD,35));
        defendPanel.add(p1d3);
        p1d3.setVisible(true);
        p1d3.setEnabled(true);


        p1d3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p1d3){
                    D1 = p1d3.getText();
                    p1d1.setBounds(50,350,300,60);
                    p1d2.setBounds(50,550,300,60);
                    p1d3.setBounds(150,450,300,60);

                    fa1.setBounds(50,350,300,60);
                    fa2.setBounds(50,550,300,60);
                    fa3.setBounds(150,450,300,60);

                    HA1.setBounds(50,350,300,60);
                    HA2.setBounds(50,550,300,60);
                    HA3.setBounds(150,450,300,60);

                    p1d1l.setBounds(50,300,300,50);
                    p1d2l.setBounds(50,500,300,50);
                    p1d3l.setBounds(150,400,300,50);

                    p1a1l.setBounds(50,400,300,50);
                    p1a2l.setBounds(50,600,300,50);
                    p1a3l.setBounds(150,500,300,50);


                    p1d3.setEnabled(false);
                    if (pvp && m2.get(D2)== null) {
                        defendPanelLabel.setText("Player 2 choose your defending hero");
                        p2d1.setEnabled(true);
                        p2d2.setEnabled(true);
                        p2d3.setEnabled(true);
                    }
                    else {
                        fb1.setEnabled(false);
                        fb2.setEnabled(false);
                        fb3.setEnabled(false);
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                        defendPanel.setVisible(false);
                        defendPanel.setEnabled(false);
                        fightPanel.setEnabled(true);
                        fightPanel.setVisible(true);
                    }
                }
            }
        });


        p2d1.setFocusable(false);
        p2d1.setBounds(1050,350,300,60);
        p2d1.setFont(new Font("Comic Sans", Font.BOLD,35));
        defendPanel.add(p2d1);
        p2d1.setVisible(true);
        p2d1.setEnabled(true);
        p2d1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p2d1){
                    D2 = p2d1.getText();
                    p2d1.setBounds(900,450,300,60);
                    p2d2.setBounds(1050,350,300,60);
                    p2d3.setBounds(1050,550,300,60);

                    fb1.setBounds(900,450,300,60);
                    fb2.setBounds(1050,350,300,60);
                    fb3.setBounds(1050,550,300,60);

                    HB1.setBounds(900,450,300,60);
                    HB2.setBounds(1050,350,300,60);
                    HB3.setBounds(1050,550,300,60);

                    p2d1l.setBounds(900,400,300,50);
                    p2d2l.setBounds(1050,300,300,50);
                    p2d3l.setBounds(1050,500,300,50);

                    p2a1l.setBounds(900,500,300,50);
                    p2a2l.setBounds(1050,400,300,50);
                    p2a3l.setBounds(1050,600,300,50);
                    p2d1.setEnabled(false);
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    defendPanel.setVisible(false);
                    defendPanel.setEnabled(false);
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);
                    if (turn ==2&& pvp){
                        if (m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        fb1.setEnabled(false);
                        fb2.setEnabled(false);
                        fb3.setEnabled(false);
                    }

                }
            }
        });


        p2d2.setFocusable(false);
        p2d2.setBounds(900,450,300,60);
        p2d2.setFont(new Font("Comic Sans", Font.BOLD,35));
        defendPanel.add(p2d2);
        p2d2.setVisible(true);
        p2d2.setEnabled(true);
        p2d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p2d2){
                    D2 = p2d2.getText();
                    p2d1.setBounds(1050,350,300,60);
                    p2d2.setBounds(900,450,300,60);
                    p2d3.setBounds(1050,550,300,60);

                    fb1.setBounds(1050,350,300,60);
                    fb2.setBounds(900,450,300,60);
                    fb3.setBounds(1050,550,300,60);

                    HB1.setBounds(1050,350,300,60);
                    HB2.setBounds(900,450,300,60);
                    HB3.setBounds(1050,550,300,60);

                    p2d1l.setBounds(1050,300,300,50);
                    p2d2l.setBounds(900,400,300,50);
                    p2d3l.setBounds(1050,500,300,50);

                    p2a1l.setBounds(1050,400,300,50);
                    p2a2l.setBounds(900,500,300,50);
                    p2a3l.setBounds(1050,600,300,50);
                    p2d2.setEnabled(false);
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    defendPanel.setVisible(false);
                    defendPanel.setEnabled(false);
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);
                    if (turn ==2 && pvp){
                        if (m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        fb1.setEnabled(false);
                        fb2.setEnabled(false);
                        fb3.setEnabled(false);
                    }
                }
            }
        });


        p2d3.setFocusable(false);
        p2d3.setBounds(1050,550,300,60);
        p2d3.setFont(new Font("Comic Sans", Font.BOLD,35));
        defendPanel.add(p2d3);
        p2d3.setVisible(true);
        p2d3.setEnabled(true);
        p2d3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p2d3){
                    D2 = p2d3.getText();
                    p2d1.setBounds(1050,350,300,60);
                    p2d2.setBounds(1050,550,300,60);
                    p2d3.setBounds(900,450,300,60);

                    fb1.setBounds(1050,350,300,60);
                    fb2.setBounds(1050,550,300,60);
                    fb3.setBounds(900,450,300,60);

                    HB1.setBounds(1050,350,300,60);
                    HB2.setBounds(1050,550,300,60);
                    HB3.setBounds(900,450,300,60);

                    p2d1l.setBounds(1050,300,300,50);
                    p2d2l.setBounds(1050,500,300,50);
                    p2d3l.setBounds(900,400,300,50);

                    p2a1l.setBounds(1050,400,300,50);
                    p2a2l.setBounds(1050,600,300,50);
                    p2a3l.setBounds(900,500,300,50);
                    p2d3.setEnabled(false);
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    defendPanel.setVisible(false);
                    defendPanel.setEnabled(false);
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);
                    if (turn ==2 && pvp){
                        if (m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        fb1.setEnabled(false);
                        fb2.setEnabled(false);
                        fb3.setEnabled(false);
                    }
                }
            }
        });

        fightPanel.setLayout(null);
        fightPanel.setBackground(new Color(100, 60, 140));
        fightPanel.setSize(1600, 800);
        this.add(fightPanel);
        fightPanel.setVisible(false);
        fightPanel.setEnabled(false);

        fightPanelLabel.setBounds(200, 150, 1200, 100);
        fightPanelLabel.setFont(new Font("Arial", Font.BOLD, 60));
        fightPanelLabel.setForeground(new Color(255, 30, 0));
        fightPanelLabel.setVisible(true);
        fightPanel.add(fightPanelLabel);

        fa1.setFocusable(false);
        fa1.setBounds(50,350,300,60);
        fa1.setFont(new Font("Comic Sans", Font.BOLD,35));
        fightPanel.add(fa1);
        fa1.setVisible(true);
        fa1.setEnabled(true);
        fa1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fa1) {
                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    p2d1l.setForeground(Color.RED);
                    p2d2l.setForeground(Color.RED);
                    p2d3l.setForeground(Color.RED);

                    n.setEnabled(true);
                    A1 = fa1.getText();
                    if (r % 2 != 0) {
                        s.setEnabled(false);
                    }
                    else{
                        s.setEnabled(true);
                    }
                    if (m1.get(A1).Energy<100){
                        S.setEnabled(false);
                    }
                    else{
                        S.setEnabled(true);
                    }
                }
            }
        });

        fa2.setFocusable(false);
        fa2.setBounds(150,450,300,60);
        fa2.setFont(new Font("Comic Sans", Font.BOLD,35));
        fightPanel.add(fa2);
        fa2.setVisible(true);
        fa2.setEnabled(true);
        fa2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fa2) {
                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    p2d1l.setForeground(Color.RED);
                    p2d2l.setForeground(Color.RED);
                    p2d3l.setForeground(Color.RED);

                    n.setEnabled(true);
                    A1 = fa2.getText();
                    if (r % 2 != 0) {
                        s.setEnabled(false);
                    }
                    else{
                        s.setEnabled(true);
                    }
                    if (m1.get(A1).Energy<100){
                        S.setEnabled(false);
                    }
                    else{
                        S.setEnabled(true);
                    }
                }
            }
        });


        fa3.setFocusable(false);
        fa3.setBounds(50,550,300,60);
        fa3.setFont(new Font("Comic Sans", Font.BOLD,35));
        fightPanel.add(fa3);
        fa3.setVisible(true);
        fa3.setEnabled(true);
        fa3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fa3) {
                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    p2d1l.setForeground(Color.RED);
                    p2d2l.setForeground(Color.RED);
                    p2d3l.setForeground(Color.RED);

                    n.setEnabled(true);
                    A1 = fa3.getText();
                    if (r % 2 != 0) {
                        s.setEnabled(false);
                    }
                    else{
                        s.setEnabled(true);
                    }
                    if (m1.get(A1).Energy<100){
                        S.setEnabled(false);
                    }
                    else{
                        S.setEnabled(true);
                    }
                }
            }
        });

        fb1.setFocusable(false);
        fb1.setBounds(1050,350,300,60);
        fb1.setFont(new Font("Comic Sans", Font.BOLD,35));
        fightPanel.add(fb1);
        fb1.setVisible(true);
        fb1.setEnabled(true);
        fb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fb1) {
                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p1d1l.setForeground(Color.RED);
                    p1d2l.setForeground(Color.RED);
                    p1d3l.setForeground(Color.RED);


                    n.setEnabled(true);
                    A2 = fb1.getText();
                    if (r % 2 != 0) {
                        s.setEnabled(false);
                    }
                    else{
                        s.setEnabled(true);
                    }
                    if (m2.get(A2).Energy<100){
                        S.setEnabled(false);
                    }
                    else{
                        S.setEnabled(true);
                    }
                }
            }
        });


        fb2.setFocusable(false);
        fb2.setBounds(900,450,300,60);
        fb2.setFont(new Font("Comic Sans", Font.BOLD,35));
        fightPanel.add(fb2);
        fb2.setVisible(true);
        fb2.setEnabled(true);
        fb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fb2) {
                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p1d1l.setForeground(Color.RED);
                    p1d2l.setForeground(Color.RED);
                    p1d3l.setForeground(Color.RED);

                    n.setEnabled(true);
                    A2 = fb2.getText();
                    if (r % 2 != 0) {
                        s.setEnabled(false);
                    }
                    else{
                        s.setEnabled(true);
                    }
                    if (m2.get(A2).Energy<100){
                        S.setEnabled(false);
                    }
                    else{
                        S.setEnabled(true);
                    }
                }
            }
        });


        fb3.setFocusable(false);
        fb3.setBounds(1050,550,300,60);
        fb3.setFont(new Font("Comic Sans", Font.BOLD,35));
        fightPanel.add(fb3);
        fb3.setVisible(true);
        fb3.setEnabled(true);
        fb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fb3) {
                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p1d1l.setForeground(Color.RED);
                    p1d2l.setForeground(Color.RED);
                    p1d3l.setForeground(Color.RED);


                    n.setEnabled(true);
                    A2 = fb3.getText();
                    if (r % 2 != 0) {
                        s.setEnabled(false);
                    }
                    else{
                        s.setEnabled(true);
                    }
                    if (m2.get(A2).Energy<100){
                        S.setEnabled(false);
                    }
                    else{
                        S.setEnabled(true);
                    }
                }
            }
        });

        p1a1l.setForeground(Color.GREEN);
        p1a1l.setBounds(50,400,300,50);
        p1a1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p1a1l);
        p1a1l.setVisible(true);


        p1a2l.setForeground(Color.GREEN);
        p1a2l.setBounds(150,500,300,50);
        p1a2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p1a2l);
        p1a2l.setVisible(true);


        p1a3l.setForeground(Color.GREEN);
        p1a3l.setBounds(50,600,300,50);
        p1a3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p1a3l);
        p1a3l.setVisible(true);


        p2a1l.setForeground(Color.GREEN);
        p2a1l.setBounds(1050,400,300,50);
        p2a1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p2a1l);
        p2a1l.setVisible(true);


        p2a2l.setForeground(Color.GREEN);
        p2a2l.setBounds(900,500,300,50);
        p2a2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p2a2l);
        p2a2l.setVisible(true);


        p2a3l.setForeground(Color.GREEN);
        p2a3l.setBounds(1050,600,300,50);
        p2a3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p2a3l);
        p2a3l.setVisible(true);

        p1d1l.setForeground(Color.RED);
        p1d1l.setBounds(50,300,300,50);
        p1d1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p1d1l);
        p1d1l.setVisible(false);


        p1d2l.setForeground(Color.RED);
        p1d2l.setBounds(150,400,300,50);
        p1d2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p1d2l);
        p1d2l.setVisible(false);


        p1d3l.setForeground(Color.RED);
        p1d3l.setBounds(50,500,300,50);
        p1d3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p1d3l);
        p1d3l.setVisible(false);


        p2d1l.setForeground(Color.RED);
        p2d1l.setBounds(1050,300,300,50);
        p2d1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p2d1l);
        p2d1l.setVisible(false);


        p2d2l.setForeground(Color.RED);
        p2d2l.setBounds(900,400,300,50);
        p2d2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p2d2l);
        p2d2l.setVisible(false);


        p2d3l.setForeground(Color.RED);
        p2d3l.setBounds(1050,500,300,50);
        p2d3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPanel.add(p2d3l);
        p2d3l.setVisible(false);

        fightPanel.add(n);
        n.setBounds(500,600,100,120);
        n.setText("normal");
        n.setFocusable(false);
        n.setEnabled(true);
        n.setVisible(true);
        n.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== n){
                    rev = false;
                    if (turn == 1){
                        turn = 2;
                        if (p1.assassin!=null && p1.assassin.CutCount>0){
                            if (pvp){
                                m2.get(D2).HP-= p1.assassin.Bleed;
                                System.out.println("Player 2 " + D2 + " is bleeding \t HP -"+p1.assassin.Bleed);
                            }
                            else{
                                computer.getDef().HP-= p1.assassin.Bleed;
                                System.out.println("Computer " + computer.getDef().Class + " is bleeding \t HP -"+p1.assassin.Bleed);
                            }
                            p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                            p1.assassin.CutCount--;
                        }
                        if (pvp && p2.FindSupport()&& p2.support.nerfs>0){
                            m1.get(A1).Attack -= p2.support.Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            p2.support.nerfs--;
                        }
                        else if (computer != null && computer.FindSupport()&& computer.getSupport().nerfs>0){
                            m1.get(A1).Attack -= computer.getSupport().Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            computer.getSupport().nerfs--;
                        }

                        if (p1.FindSupport() && p1.support.up>0){
                            m1.get(A1).Attack += p1.support.Buff();
                            p1.support.up--;
                            System.out.println("Player 1 " +A1+ " was buffed");
                        }
                        if (pvp){
                            fa1.setEnabled(false);
                            fa2.setEnabled(false);
                            fa3.setEnabled(false);
                        }
                        damage = m1.get(A1).Normal();
                        if (pvp) {
                            System.out.println("Player 2 " + D2 + " had " +m2.get(D2).HP + " HP");
                            if (m2.get(D2).Class.equals("tank")) {
                                if (damage > p2.tank.Shield) {
                                    m2.get(D2).HP -= (damage - p2.tank.Shield);
                                } else {
                                    damage = 0;
                                    p2d1l.setForeground(Color.lightGray);
                                    p2d2l.setForeground(Color.lightGray);
                                    p2d3l.setForeground(Color.lightGray);
                                }
                                p2.tank.Shield = 50;
                            } else {
                                m2.get(D2).HP -= damage;
                            }
                            if (D2.equals(fb1.getText())){
                                p2d1l.setText(" -" +damage);
                                p2d1l.setVisible(true);
                            }
                            else if (D2.equals(fb2.getText())){
                                p2d2l.setText(" -" +damage);
                                p2d2l.setVisible(true);
                            }
                            else{
                                p2d3l.setText(" -" +damage);
                                p2d3l.setVisible(true);
                            }
                            if (m2.get(D2).HP<=0){
                                m2.get(D2).HP = 0;
                                p2.alive--;
                                if (p2.alive == 0){
                                    winPanelLabel.setText("Player 1 won!");
                                    winPanel.setEnabled(true);
                                    winPanel.setVisible(true);
                                }
                                else{
                                    defendPanelLabel.setText("Player 2 select defending hero");
                                    defendPanel.setEnabled(true);
                                    defendPanel.setVisible(true);
                                }
                                fightPanel.setVisible(false);
                                fightPanel.setEnabled(false);
                            }
                            p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                            System.out.println("Player 2 " + D2 + " has " +m2.get(D2).HP + " HP");
                            fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        else{
                            System.out.println("Computer " + computer.getDef().Class + " had " +computer.getDef().HP + " HP");
                            if(computer.getDef().Class.equals("tank")){
                                if(damage >computer.getDef().Shield){
                                    computer.getDef().HP -= (damage -computer.getDef().Shield);
                                }
                                else{
                                    damage = 0;
                                    p2d1l.setForeground(Color.lightGray);
                                    p2d2l.setForeground(Color.lightGray);
                                    p2d3l.setForeground(Color.lightGray);

                                }
                                computer.getDef().Shield = 50;
                            }
                            else{
                                computer.getDef().HP -= damage;
                            }
                            if (computer.getDef().Class.equals(fb1.getText())){
                                p2d1l.setText(" -" +damage);
                                p2d1l.setVisible(true);
                            }
                            else if (computer.getDef().Class.equals(fb2.getText())){
                                p2d2l.setText(" -" +damage);
                                p2d2l.setVisible(true);
                            }
                            else{
                                p2d3l.setText(" -" +damage);
                                p2d3l.setVisible(true);
                            }
                            sortButtons();
                            if (computer.getDef().HP<=0){
                                computer.getDef().HP = 0;
                                computer.alive--;
                                if (computer.alive == 0){
                                    winPanelLabel.setText("Player 1 won!");
                                    winPanel.setEnabled(true);
                                    winPanel.setVisible(true);
                                    fightPanel.setVisible(false);
                                    fightPanel.setEnabled(false);
                                }
                            }
                            p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                            p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                            p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                            System.out.println("Computer " +computer.getDef().Class  + " has " +computer.getDef().HP + " HP");
                            turn = 2;
                            ComputerTurn();
                            fightPanelLabel.setText("Round "+ r);
                        }
                        if (pvp && m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (pvp && m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (pvp && m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                    }
                    else {
                        if (p2.assassin!=null && p2.assassin.CutCount>0){
                            m1.get(D1).HP-= p2.assassin.Bleed;
                            System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                            p2.assassin.CutCount--;
                        }
                        if (p1!= null && p1.FindSupport()&& p1.support.nerfs>0){
                            m2.get(A2).Attack -= p1.support.Nerf();
                            System.out.println("Player 2 " +A2+ " was nerfed");
                            p1.support.nerfs--;
                        }
                        if (p2.FindSupport() && p2.support.up>0){
                            m2.get(A2).Attack += p2.support.Buff();
                            p2.support.up--;
                            System.out.println("Player 2 " +A2+ " was buffed");
                        }
                        fb1.setEnabled(false);
                        fb2.setEnabled(false);
                        fb3.setEnabled(false);
                        System.out.println("Player 1 " + D1 + " had " +m1.get(D1).HP + " HP");
                        damage = m2.get(A2).Normal();
                        if(m1.get(D1).Class.equals("tank")){
                            if (damage > p1.tank.Shield){
                                m1.get(D1).HP -= (damage -p1.tank.Shield);
                            }
                            else{
                                damage = 0;
                                p1d1l.setForeground(Color.lightGray);
                                p1d2l.setForeground(Color.lightGray);
                                p1d3l.setForeground(Color.lightGray);
                            }
                            p1.tank.Shield = 50;
                        }
                        else{
                            m1.get(D1).HP -= damage;
                        }
                        if (m1.get(fa1.getText()).HP>0){
                            fa1.setEnabled(true);
                        }
                        else{
                            fa1.setEnabled(false);
                        }
                        if (m1.get(fa2.getText()).HP>0){
                            fa2.setEnabled(true);
                        }
                        else{
                            fa2.setEnabled(false);
                        }
                        if (m1.get(fa3.getText()).HP>0){
                            fa3.setEnabled(true);
                        }
                        else{
                            fa3.setEnabled(false);
                        }
                        if (D1.equals(fa1.getText())){
                            p1d1l.setText(" -" +damage);
                            p1d1l.setVisible(true);
                        }
                        else if (D1.equals(fa2.getText())){
                            p1d2l.setText(" -" +damage);
                            p1d2l.setVisible(true);
                        }
                        else{
                            p1d3l.setText(" -" +damage);
                            p1d3l.setVisible(true);
                        }
                        if (m1.get(D1).HP< 0){
                            m1.get(D1).HP = 0;
                            p1.alive--;
                            if (p1.alive == 0){
                                winPanelLabel.setText("Player 2 won!");
                                winPanel.setEnabled(true);
                                winPanel.setVisible(true);
                            }
                            else{
                                defendPanelLabel.setText("Player 1 select your defending hero");
                                defendPanel.setEnabled(true);
                                defendPanel.setVisible(true);
                            }
                            fightPanel.setVisible(false);
                            fightPanel.setEnabled(false);
                        }
                        p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                        p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                        p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                        System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                        turn = 1;
                        r++;
                        fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                    }
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    if (pvp&& limited && r == rounds){
                        if (p1.alive>p2.alive){
                            winPanelLabel.setText("Player 1 won!");
                        }
                        else if (p1.alive<p2.alive){
                            winPanelLabel.setText("Player 2 won!");
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                        }
                        winPanel.setVisible(true);
                        winPanel.setEnabled(true);
                        fightPanel.setEnabled(false);
                        fightPanel.setVisible(false);
                    }
                    else if (!pvp&& limited && r == rounds){
                        if (p1.alive>computer.alive){
                            winPanelLabel.setText("Player 1 won!");
                        }
                        else if (p1.alive<computer.alive){
                            winPanelLabel.setText("Computer won!");
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                        }
                        winPanel.setVisible(true);
                        winPanel.setEnabled(true);
                        fightPanel.setEnabled(false);
                        fightPanel.setVisible(false);
                    }
                }

            }
        });

        fightPanel.add(s);
        s.setBounds(700,600,100,120);
        s.setText("skill");
        s.setFocusable(false);
        s.setEnabled(true);
        s.setVisible(true);
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== s){
                    rev = false;
                    if (turn == 1 ){
                        turn =2;
                        if (p1.assassin!=null && p1.assassin.CutCount>0){
                            if (pvp){
                                m2.get(D2).HP-= p1.assassin.Bleed;
                                System.out.println("Player 2 " + D2 + " is bleeding \t HP -"+p1.assassin.Bleed);
                            }
                            else{
                                computer.getDef().HP-= p1.assassin.Bleed;
                                System.out.println("Computer " + computer.getDef().Class + " is bleeding \t HP -"+p1.assassin.Bleed);
                            }
                            p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                            p1.assassin.CutCount--;
                        }
                        if (pvp && p2.FindSupport()&& p2.support.nerfs>0){
                            m1.get(A1).Attack -= p2.support.Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            p2.support.nerfs--;
                        }
                        else if (computer!= null && computer.FindSupport()&& computer.getSupport().nerfs>0){
                            m1.get(A1).Attack -= computer.getSupport().Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            computer.getSupport().nerfs--;
                        }

                        if (p1.FindSupport() && p1.support.up>0){
                            m1.get(A1).Attack += p1.support.Buff();
                            p1.support.up--;
                            System.out.println("Player 1 " +A1+ " was buffed");
                        }
                        if(!m1.get(A1).Class.equals("healer")){
                            damage = m1.get(A1).Skill();
                            if (pvp){
                                System.out.println("Player 2 " + D2 + " had " +m2.get(D2).HP + " HP");
                                if (m2.get(D2).Class.equals("tank")) {
                                    if (damage > p2.tank.Shield) {
                                        m2.get(D2).HP -= (damage - p2.tank.Shield);
                                    }
                                    else {
                                        damage = 0;
                                        p2d1l.setForeground(Color.lightGray);
                                        p2d2l.setForeground(Color.lightGray);
                                        p2d3l.setForeground(Color.lightGray);
                                    }
                                    p2.tank.Shield = 50;
                                } else {
                                    m2.get(D2).HP -= damage;
                                }
                                if (D2.equals(fb1.getText())){
                                    p2d1l.setText(" -" +damage);
                                    p2d1l.setVisible(true);
                                }
                                else if (D2.equals(fb2.getText())){
                                    p2d2l.setText(" -" +damage);
                                    p2d2l.setVisible(true);
                                }
                                else{
                                    p2d3l.setText(" -" +damage);
                                    p2d3l.setVisible(true);
                                }
                                if (m2.get(D2).HP<=0){
                                    m2.get(D2).HP = 0;
                                    p2.alive--;
                                    if (p2.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        winPanel.setEnabled(true);
                                        winPanel.setVisible(true);
                                    }
                                    else{
                                        defendPanelLabel.setText("Player 2 select defending hero");
                                        defendPanel.setEnabled(true);
                                        defendPanel.setVisible(true);
                                    }
                                    fightPanel.setVisible(false);
                                    fightPanel.setEnabled(false);
                                }
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                System.out.println("Player 2 " + D2 + " has " +m2.get(D2).HP + " HP");
                                if (p1.support != null && p1.support.Skips>0){
                                    System.out.println(("Player 2 was frozen"));
                                    turn = 1;
                                    fb1.setEnabled(false);
                                    fb2.setEnabled(false);
                                    fb3.setEnabled(false);
                                    p1.support.Skips--;
                                    r++;
                                    if (p2.assassin!=null && p2.assassin.CutCount>0){
                                        m1.get(D1).HP-= p2.assassin.Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                                        p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                        p2.assassin.CutCount--;
                                    }
                                }
                                else{
                                    if (m2.get(fb1.getText()).HP>0){
                                        fb1.setEnabled(true);
                                    }
                                    else{
                                        fb1.setEnabled(false);
                                    }
                                    if (m2.get(fb2.getText()).HP>0){
                                        fb2.setEnabled(true);
                                    }
                                    else{
                                        fb2.setEnabled(false);
                                    }
                                    if (m2.get(fb3.getText()).HP>0){
                                        fb3.setEnabled(true);
                                    }
                                    else{
                                        fb3.setEnabled(false);
                                    }
                                    fa1.setEnabled(false);
                                    fa2.setEnabled(false);
                                    fa3.setEnabled(false);
                                }

                                fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                                if (m2.get(fb1.getText()).HP>0){
                                    fb1.setEnabled(true);
                                }
                                else{
                                    fb1.setEnabled(false);
                                }
                                if (m2.get(fb2.getText()).HP>0){
                                    fb2.setEnabled(true);
                                }
                                else{
                                    fb2.setEnabled(false);
                                }
                                if (m2.get(fb3.getText()).HP>0){
                                    fb3.setEnabled(true);
                                }
                                else{
                                    fb3.setEnabled(false);
                                }

                            }
                            else{
                                System.out.println("Computer " + computer.getDef().Class + " had " +computer.getDef().HP + " HP");
                                damage = m1.get(A1).Skill();
                                if(computer.getDef().Class.equals("tank")){
                                    if (damage> computer.getDef().Shield){
                                        computer.getDef().HP -= (damage -computer.getDef().Shield);
                                    }
                                    else{
                                        damage = 0;
                                        p2d1l.setForeground(Color.lightGray);
                                        p2d2l.setForeground(Color.lightGray);
                                        p2d3l.setForeground(Color.lightGray);
                                    }
                                    computer.getDef().Shield = 50;
                                }
                                else{
                                    computer.getDef().HP -= damage;
                                }
                                if (computer.getDef().Class.equals(fb1.getText())){
                                    p2d1l.setText(" -" +damage);
                                    p2d1l.setVisible(true);
                                }
                                else if (computer.getDef().Class.equals(fb2.getText())){
                                    p2d2l.setText(" -" +damage);
                                    p2d2l.setVisible(true);
                                }
                                else{
                                    p2d3l.setText(" -" +damage);
                                    p2d3l.setVisible(true);
                                }
                                sortButtons();
                                if (computer.getDef().HP< 0){
                                    computer.getDef().HP = 0;
                                    computer.alive--;
                                    if (computer.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        winPanel.setEnabled(true);
                                        winPanel.setVisible(true);
                                        fightPanel.setVisible(false);
                                        fightPanel.setEnabled(false);
                                    }
                                }
                                p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                                p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                                p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                                System.out.println("Computer " + computer.getDef().Class + " has " +computer.getDef().HP + " HP");
                                if (p1.support != null && p1.support.Skips>0){
                                    turn =1;
                                    System.out.println(("computer was frozen"));
                                    p1.support.Skips--;
                                    r++;
                                    fightPanelLabel.setText("Round "+ r);
                                    if (computer.FindAssassin() &&computer.getAssassin()!=null && computer.getAssassin().CutCount>0){
                                        m1.get(D1).HP-= computer.getAssassin().Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+computer.getAssassin().Bleed);
                                        computer.getAssassin().CutCount--;
                                    }
                                }
                                else{
                                    ComputerTurn();
                                }
                            }
                        }
                        else {
                            if (m1.get(HA1.getText()).HP>0&& m1.get(HA1.getText()).HP< m1.get(HA1.getText()).cHP){
                                HA1.setEnabled(true);
                            }
                            else{
                                HA1.setEnabled(false);
                            }
                            if (m1.get(HA2.getText()).HP>0 && m1.get(HA2.getText()).HP< m1.get(HA2.getText()).cHP){
                                HA2.setEnabled(true);
                            }
                            else{
                                HA2.setEnabled(false);
                            }
                            if (m1.get(HA3.getText()).HP>0&& m1.get(HA3.getText()).HP< m1.get(HA3.getText()).cHP){
                                HA3.setEnabled(true);
                            }
                            else{
                                HA3.setEnabled(false);
                            }
                            healPanel.setEnabled(true);
                            healPanel.setVisible(true);

                            HB1.setEnabled(false);
                            HB2.setEnabled(false);
                            HB3.setEnabled(false);
                            fightPanel.setEnabled(false);
                            fightPanel.setVisible(false);
                            if (pvp&& p2.assassin!= null){
                                p2.assassin.CutCount= 0;
                            }
                            else if (!pvp && computer.FindAssassin()){
                                computer.getAssassin().CutCount= 0;
                            }
                            fa1.setEnabled(false);
                            fa2.setEnabled(false);
                            fa3.setEnabled(false);
                            fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        if (pvp && m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (pvp && m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (pvp && m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        turn = 1;
                        if (p2.assassin!=null && p2.assassin.CutCount>0){
                            m1.get(D1).HP-= p2.assassin.Bleed;
                            System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p2.assassin.CutCount--;
                        }
                        if (p1!= null && p1.FindSupport()&& p1.support.nerfs>0){
                            m2.get(A2).Attack -= p1.support.Nerf();
                            System.out.println("Player 2 " +A2+ " was nerfed");
                            p1.support.nerfs--;
                        }
                        if (p2.FindSupport() && p2.support.up>0){
                            m2.get(A2).Attack += p2.support.Buff();
                            p2.support.up--;
                            System.out.println("Player 2 " +A2+ " was buffed");
                        }
                        if(!m2.get(A2).Class.equals("healer")){
                            System.out.println("Player 1 " + D1 + " had " +m1.get(D1).HP + " HP");
                            damage = m2.get(A2).Skill();
                            if(m1.get(D1).Class.equals("tank")){
                                if (damage>p1.tank.Shield){
                                    m1.get(D1).HP -= (damage -p1.tank.Shield);
                                }
                                else{
                                    damage = 0;
                                    p1d1l.setForeground(Color.lightGray);
                                    p1d2l.setForeground(Color.lightGray);
                                    p1d3l.setForeground(Color.lightGray);
                                }
                                p1.tank.Shield = 50;
                            }
                            else{
                                m1.get(D1).HP -= damage;
                            }
                            if (m1.get(fa1.getText()).HP>0){
                                fa1.setEnabled(true);
                            }
                            else{
                                fa1.setEnabled(false);
                            }
                            if (m1.get(fa2.getText()).HP>0){
                                fa2.setEnabled(true);
                            }
                            else{
                                fa2.setEnabled(false);
                            }
                            if (m1.get(fa3.getText()).HP>0){
                                fa3.setEnabled(true);
                            }
                            else{
                                fa3.setEnabled(false);
                            }
                            if (D1.equals(fa1.getText())){
                                p1d1l.setText(" -" +damage);
                                p1d1l.setVisible(true);
                            }
                            else if (D1.equals(fa2.getText())){
                                p1d2l.setText(" -" +damage);
                                p1d2l.setVisible(true);
                            }
                            else{
                                p1d3l.setText(" -" +damage);
                                p1d3l.setVisible(true);
                            }
                            if (m1.get(D1).HP< 0){
                                m1.get(D1).HP = 0;
                                p1.alive--;
                                if (p1.alive == 0){
                                    winPanelLabel.setText("Player 2 won!");
                                    winPanel.setEnabled(true);
                                    winPanel.setVisible(true);
                                }
                                else{
                                    defendPanelLabel.setText("Player 1 select your defending hero");
                                    defendPanel.setEnabled(true);
                                    defendPanel.setVisible(true);
                                }
                                fightPanel.setVisible(false);
                                fightPanel.setEnabled(false);

                            }
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                            System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                            if (p2.support!= null && p2.support.Skips>0){
                                turn = 2;
                                System.out.println(("Player 1 was frozen"));
                                p2.support.Skips--;
                                fa1.setEnabled(false);
                                fa2.setEnabled(false);
                                fa3.setEnabled(false);
                                if (p1.assassin!=null && p1.assassin.CutCount>0){
                                    m2.get(D2).HP-= p1.assassin.Bleed;
                                    System.out.println("Player 2 " + D2 + " is bleeding \t HP -"+p1.assassin.Bleed);
                                    p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                    p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                    p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                    p1.assassin.CutCount--;
                                }
                            }
                            else{
                                fb1.setEnabled(false);
                                fb2.setEnabled(false);
                                fb3.setEnabled(false);
                                if (m1.get(fa1.getText()).HP>0){
                                    fa1.setEnabled(true);
                                }
                                else{
                                    fa1.setEnabled(false);
                                }
                                if (m1.get(fa2.getText()).HP>0){
                                    fa2.setEnabled(true);
                                }
                                else{
                                    fa2.setEnabled(false);
                                }
                                if (m1.get(fa3.getText()).HP>0){
                                    fa3.setEnabled(true);
                                }
                                else{
                                    fa3.setEnabled(false);
                                }
                            }
                            r++;
                            fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        else {
                            if (m2.get(HB1.getText()).HP>0&& m2.get(HB1.getText()).HP< m2.get(HB1.getText()).cHP){
                                HB1.setEnabled(true);
                            }
                            else{
                                HB1.setEnabled(false);
                            }
                            if (m2.get(HB2.getText()).HP>0&& m2.get(HB2.getText()).HP< m2.get(HB2.getText()).cHP){
                                HB2.setEnabled(true);
                            }
                            else{
                                HB2.setEnabled(false);
                            }
                            if (m2.get(HB3.getText()).HP>0&& m2.get(HB3.getText()).HP< m2.get(HB3.getText()).cHP){
                                HB3.setEnabled(true);
                            }
                            else{
                                HB3.setEnabled(false);
                            }
                            healPanel.setVisible(true);
                            healPanel.setEnabled(true);
                            fightPanel.setEnabled(false);
                            fightPanel.setVisible(false);
                            HA1.setEnabled(false);
                            HA2.setEnabled(false);
                            HA3.setEnabled(false);
                            if (p1.assassin!= null){
                                p1.assassin.CutCount= 0;
                            }
                            r++;
                            turn = 1;
                            fb1.setEnabled(false);
                            fb2.setEnabled(false);
                            fb3.setEnabled(false);
                            if (m1.get(fa1.getText()).HP==0){
                                fa1.setEnabled(false);
                            }
                            else{
                                fa1.setEnabled(true);
                            }
                            if (m1.get(fa2.getText()).HP== 0){
                                fa2.setEnabled(false);
                            }
                            else{
                                fa2.setEnabled(true);
                            }
                            if (m1.get(fa3.getText()).HP== 0){
                                fa3.setEnabled(false);
                            }
                            else{
                                fa3.setEnabled(true);
                            }
                        }
                    }
                    fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    if ( pvp && limited && r == rounds){
                        if (p1.alive>p2.alive){
                            winPanelLabel.setText("Player 1 won!");
                        }
                        else if (p1.alive<p2.alive){
                            winPanelLabel.setText("Player 2 won!");
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                        }
                        winPanel.setVisible(true);
                        winPanel.setEnabled(true);
                        fightPanel.setEnabled(false);
                        fightPanel.setVisible(false);
                    }
                    else if (!pvp&& limited && r == rounds){
                        if (p1.alive>computer.alive){
                            winPanelLabel.setText("Player 1 won!");
                        }
                        else if (p1.alive<computer.alive){
                            winPanelLabel.setText("Computer won!");
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                        }
                        winPanel.setVisible(true);
                        winPanel.setEnabled(true);
                        fightPanel.setEnabled(false);
                        fightPanel.setVisible(false);
                    }
                }
            }
        });

        fightPanel.add(S);
        S.setBounds(900,600,100,120);
        S.setText("super");
        S.setEnabled(true);
        S.setVisible(true);
        S.setFocusable(false);
        S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== S){
                    rev = true;
                    if (turn == 1 ){
                        turn =2;
                        if (p1.assassin!=null && p1.assassin.CutCount>0){
                            if (pvp){
                                m2.get(D2).HP-= p1.assassin.Bleed;
                                System.out.println("Player 2 " + D2 + " is bleeding \t HP -"+p1.assassin.Bleed);
                            }
                            else{
                                computer.getDef().HP-= p1.assassin.Bleed;
                                System.out.println("Computer " + computer.getDef().Class + " is bleeding \t HP -"+p1.assassin.Bleed);
                            }
                            p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                            p1.assassin.CutCount--;
                        }
                        if (pvp&& p2.FindSupport()&& p2.support.nerfs>0){
                            m1.get(A1).Attack -= p2.support.Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            p2.support.nerfs--;
                        }
                        else if (computer!= null && computer.FindSupport()&& computer.getSupport().nerfs>0){
                            m1.get(A1).Attack -= computer.getSupport().Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            computer.getSupport().nerfs--;
                        }

                        if (p1.FindSupport() && p1.support.up>0){
                            m1.get(A1).Attack += p1.support.Buff();
                            p1.support.up--;
                            System.out.println("Player 1 " +A1+ " was buffed");
                        }
                        if(!m1.get(A1).Class.equals("healer")){
                            damage = m1.get(A1).Super();
                            if (pvp){
                                System.out.println("Player 2 " + D2 + " had " +m2.get(D2).HP + " HP");
                                if (m2.get(D2).Class.equals("tank")) {
                                    if (damage > p2.tank.Shield) {
                                        m2.get(D2).HP -= (damage - p2.tank.Shield);
                                    }
                                    else {
                                        damage = 0;
                                        p2d1l.setForeground(Color.lightGray);
                                        p2d2l.setForeground(Color.lightGray);
                                        p2d3l.setForeground(Color.lightGray);
                                    }
                                    p2.tank.Shield = 50;
                                } else {
                                    m2.get(D2).HP -= damage;
                                }
                                if (D2.equals(fb1.getText())){
                                    p2d1l.setText(" -" +damage);
                                    p2d1l.setVisible(true);
                                }
                                else if (D2.equals(fb2.getText())){
                                    p2d2l.setText(" -" +damage);
                                    p2d2l.setVisible(true);
                                }
                                else{
                                    p2d3l.setText(" -" +damage);
                                    p2d3l.setVisible(true);
                                }
                                if (m2.get(D2).HP<=0){
                                    m2.get(D2).HP = 0;
                                    p2.alive--;
                                    if (p2.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        winPanel.setEnabled(true);
                                        winPanel.setVisible(true);
                                    }
                                    else{
                                        defendPanelLabel.setText("Player 2 select defending hero");
                                        defendPanel.setEnabled(true);
                                        defendPanel.setVisible(true);
                                    }
                                    fightPanel.setVisible(false);
                                    fightPanel.setEnabled(false);
                                }
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                System.out.println("Player 2 " + D2 + " has " +m2.get(D2).HP + " HP");
                                if (p1.support != null && p1.support.Skips>0){
                                    System.out.println(("Player 2 was frozen"));
                                    turn = 1;
                                    fb1.setEnabled(false);
                                    fb2.setEnabled(false);
                                    fb3.setEnabled(false);
                                    p1.support.Skips--;
                                    r++;
                                    if (p2.assassin!=null && p2.assassin.CutCount>0){
                                        m1.get(D1).HP-= p2.assassin.Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                                        p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                        p2.assassin.CutCount--;
                                    }
                                }
                                else{
                                    if (m2.get(fb1.getText()).HP>0){
                                        fb1.setEnabled(true);
                                    }
                                    else{
                                        fb1.setEnabled(false);
                                    }
                                    if (m2.get(fb2.getText()).HP>0){
                                        fb2.setEnabled(true);
                                    }
                                    else{
                                        fb2.setEnabled(false);
                                    }
                                    if (m2.get(fb3.getText()).HP>0){
                                        fb3.setEnabled(true);
                                    }
                                    else{
                                        fb3.setEnabled(false);
                                    }
                                    fa1.setEnabled(false);
                                    fa2.setEnabled(false);
                                    fa3.setEnabled(false);
                                }

                                fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                                if (m2.get(fb1.getText()).HP>0){
                                    fb1.setEnabled(true);
                                }
                                else{
                                    fb1.setEnabled(false);
                                }
                                if (m2.get(fb2.getText()).HP>0){
                                    fb2.setEnabled(true);
                                }
                                else{
                                    fb2.setEnabled(false);
                                }
                                if (m2.get(fb3.getText()).HP>0){
                                    fb3.setEnabled(true);
                                }
                                else{
                                    fb3.setEnabled(false);
                                }

                            }
                            else{
                                System.out.println("Computer " + computer.getDef().Class + " had " +computer.getDef().HP + " HP");
                                damage = m1.get(A1).Skill();
                                if(computer.getDef().Class.equals("tank")){
                                    computer.getDef().HP -= (damage -computer.getDef().Shield);
                                    computer.getDef().Shield = 50;
                                }
                                else{
                                    computer.getDef().HP -= damage;
                                }

                                if (computer.getDef().Class.equals(fb1.getText())){
                                    p2d1l.setText(" -" +damage);
                                    p2d1l.setVisible(true);
                                }
                                else if (computer.getDef().Class.equals(fb2.getText())){
                                    p2d2l.setText(" -" +damage);
                                    p2d2l.setVisible(true);
                                }
                                else{
                                    p2d3l.setText(" -" +damage);
                                    p2d3l.setVisible(true);
                                }
                                sortButtons();
                                if (computer.getDef().HP< 0){
                                    computer.getDef().HP = 0;
                                    computer.alive--;
                                    if (computer.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        winPanel.setEnabled(true);
                                        winPanel.setVisible(true);
                                        fightPanel.setVisible(false);
                                        fightPanel.setEnabled(false);
                                    }
                                }
                                p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                                p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                                p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                                System.out.println("Computer " + computer.getDef().Class + " has " +computer.getDef().HP + " HP");
                                if (p1.support != null && p1.support.Skips>0){
                                    turn =1;
                                    System.out.println(("computer was frozen"));
                                    p1.support.Skips--;
                                    r++;
                                    fightPanelLabel.setText("Round "+ r);
                                    if (computer.FindAssassin() &&computer.getAssassin()!=null && computer.getAssassin().CutCount>0){
                                        m1.get(D1).HP-= computer.getAssassin().Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+computer.getAssassin().Bleed);
                                        computer.getAssassin().CutCount--;
                                    }
                                }
                                else{
                                    ComputerTurn();
                                }
                            }
                        }
                        else {
                            if (m1.get(HA1.getText()).HP== m1.get(HA1.getText()).cHP){
                                HA1.setEnabled(false);
                            }
                            else{
                                HA1.setEnabled(true);
                            }
                            if (m1.get(HA2.getText()).HP== m1.get(HA2.getText()).cHP){
                                HA2.setEnabled(false);
                            }
                            else{
                                HA2.setEnabled(true);
                            }
                            if (m1.get(HA3.getText()).HP== m1.get(HA3.getText()).cHP){
                                HA3.setEnabled(false);
                            }
                            else{
                                HA3.setEnabled(true);
                            }
                            healPanel.setEnabled(true);
                            healPanel.setVisible(true);

                            HB1.setEnabled(false);
                            HB2.setEnabled(false);
                            HB3.setEnabled(false);
                            fightPanel.setEnabled(false);
                            fightPanel.setVisible(false);
                            if (pvp&& p2.assassin!= null){
                                p2.assassin.CutCount= 0;
                            }
                            else if (!pvp && computer.FindAssassin()){
                                computer.getAssassin().CutCount= 0;
                            }
                            fa1.setEnabled(false);
                            fa2.setEnabled(false);
                            fa3.setEnabled(false);
                            fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        if (pvp && m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (pvp && m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (pvp && m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        turn = 1;
                        if (p2.assassin!=null && p2.assassin.CutCount>0){
                            m1.get(D1).HP-= p2.assassin.Bleed;
                            System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p2.assassin.CutCount--;
                        }
                        if (p1!= null && p1.FindSupport()&& p1.support.nerfs>0){
                            m2.get(A2).Attack -= p1.support.Nerf();
                            System.out.println("Player 2 " +A2+ " was nerfed");
                            p1.support.nerfs--;
                        }
                        if (p2.FindSupport() && p2.support.up>0){
                            m2.get(A2).Attack += p2.support.Buff();
                            p2.support.up--;
                            System.out.println("Player 2 " +A2+ " was buffed");
                        }
                        if(!m2.get(A2).Class.equals("healer")){
                            System.out.println("Player 1 " + D1 + " had " +m1.get(D1).HP + " HP");
                            damage = m2.get(A2).Super();
                            if(m1.get(D1).Class.equals("tank")){
                                if (damage>p1.tank.Shield){
                                    m1.get(D1).HP -= (damage -p1.tank.Shield);
                                }
                                else{
                                    damage = 0;
                                    p1d1l.setForeground(Color.lightGray);
                                    p1d2l.setForeground(Color.lightGray);
                                    p1d3l.setForeground(Color.lightGray);
                                }
                                p1.tank.Shield = 50;
                            }
                            else{
                                m1.get(D1).HP -= damage;
                            }
                            if (m1.get(fa1.getText()).HP>0){
                                fa1.setEnabled(true);
                            }
                            else{
                                fa1.setEnabled(false);
                            }
                            if (m1.get(fa2.getText()).HP>0){
                                fa2.setEnabled(true);
                            }
                            else{
                                fa2.setEnabled(false);
                            }
                            if (m1.get(fa3.getText()).HP>0){
                                fa3.setEnabled(true);
                            }
                            else{
                                fa3.setEnabled(false);
                            }
                            if (D1.equals(fa1.getText())){
                                p1d1l.setText(" -" +damage);
                                p1d1l.setVisible(true);
                            }
                            else if (D1.equals(fa2.getText())){
                                p1d2l.setText(" -" +damage);
                                p1d2l.setVisible(true);
                            }
                            else{
                                p1d3l.setText(" -" +damage);
                                p1d3l.setVisible(true);
                            }
                            if (m1.get(D1).HP< 0){
                                m1.get(D1).HP = 0;
                                p1.alive--;
                                if (p1.alive == 0){
                                    winPanelLabel.setText("Player 2 won!");
                                    winPanel.setEnabled(true);
                                    winPanel.setVisible(true);
                                }
                                else{
                                    defendPanelLabel.setText("Player 1 select your defending hero");
                                    defendPanel.setEnabled(true);
                                    defendPanel.setVisible(true);
                                }
                                fightPanel.setVisible(false);
                                fightPanel.setEnabled(false);

                            }
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                            System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                            if (p2.support!= null && p2.support.Skips>0){
                                turn = 2;
                                System.out.println(("Player 1 was frozen"));
                                p2.support.Skips--;
                                fa1.setEnabled(false);
                                fa2.setEnabled(false);
                                fa3.setEnabled(false);
                                if (p1.assassin!=null && p1.assassin.CutCount>0){
                                    m2.get(D2).HP-= p1.assassin.Bleed;
                                    System.out.println("Player 2 " + D2 + " is bleeding \t HP -"+p1.assassin.Bleed);
                                    p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                    p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                    p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                    p1.assassin.CutCount--;
                                }
                            }
                            else{
                                fb1.setEnabled(false);
                                fb2.setEnabled(false);
                                fb3.setEnabled(false);
                                if (m1.get(fa1.getText()).HP>0){
                                    fa1.setEnabled(true);
                                }
                                else{
                                    fa1.setEnabled(false);
                                }
                                if (m1.get(fa2.getText()).HP>0){
                                    fa2.setEnabled(true);
                                }
                                else{
                                    fa2.setEnabled(false);
                                }
                                if (m1.get(fa3.getText()).HP>0){
                                    fa3.setEnabled(true);
                                }
                                else{
                                    fa3.setEnabled(false);
                                }
                            }
                            r++;
                            fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        else {
                            if (m2.get(HB1.getText()).HP== m2.get(HB1.getText()).cHP){
                                HB1.setEnabled(false);
                            }
                            else{
                                HB1.setEnabled(true);
                            }
                            if (m2.get(HB2.getText()).HP== m2.get(HB2.getText()).cHP){
                                HB2.setEnabled(false);
                            }
                            else{
                                HB2.setEnabled(true);
                            }
                            if (m2.get(HB3.getText()).HP== m2.get(HB3.getText()).cHP){
                                HB3.setEnabled(false);
                            }
                            else{
                                HB3.setEnabled(true);
                            }
                            healPanel.setVisible(true);
                            healPanel.setEnabled(true);
                            fightPanel.setEnabled(false);
                            fightPanel.setVisible(false);
                            HA1.setEnabled(false);
                            HA2.setEnabled(false);
                            HA3.setEnabled(false);
                            if (p1.assassin!= null){
                                p1.assassin.CutCount= 0;
                            }
                            r++;
                            turn = 1;
                            fb1.setEnabled(false);
                            fb2.setEnabled(false);
                            fb3.setEnabled(false);
                            if (m1.get(fa1.getText()).HP==0){
                                fa1.setEnabled(false);
                            }
                            else{
                                fa1.setEnabled(true);
                            }
                            if (m1.get(fa2.getText()).HP== 0){
                                fa2.setEnabled(false);
                            }
                            else{
                                fa2.setEnabled(true);
                            }
                            if (m1.get(fa3.getText()).HP== 0){
                                fa3.setEnabled(false);
                            }
                            else{
                                fa3.setEnabled(true);
                            }
                        }
                    }
                    fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    if (pvp&& limited && r == rounds){
                        if (p1.alive>p2.alive){
                            winPanelLabel.setText("Player 1 won!");
                        }
                        else if (p1.alive<p2.alive){
                            winPanelLabel.setText("Player 2 won!");
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                        }
                        winPanel.setVisible(true);
                        winPanel.setEnabled(true);
                        fightPanel.setEnabled(false);
                        fightPanel.setVisible(false);
                    }
                    else if (!pvp&& limited && r == rounds){
                        if (p1.alive>computer.alive){
                            winPanelLabel.setText("Player 1 won!");
                        }
                        else if (p1.alive<computer.alive){
                            winPanelLabel.setText("Computer won!");
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                        }
                        winPanel.setVisible(true);
                        winPanel.setEnabled(true);
                        fightPanel.setEnabled(false);
                        fightPanel.setVisible(false);
                    }
                }
            }
        });

        healPanel.setLayout(null);
        healPanel.setBackground(new Color(100, 60, 140));
        healPanel.setSize(1600, 800);
        this.add(healPanel);
        healPanel.setVisible(false);
        healPanel.setEnabled(false);

        healPanelLabel.setText("Choose your character to heal");
        healPanelLabel.setBounds(200, 150, 1200, 100);
        healPanelLabel.setFont(new Font("Arial", Font.BOLD, 60));
        healPanelLabel.setForeground(new Color(255, 30, 0));
        healPanelLabel.setVisible(true);
        healPanel.add(healPanelLabel);

        HA1.setFocusable(false);
        HA1.setBounds(50,350,300,60);
        HA1.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPanel.add(HA1);
        HA1.setVisible(true);
        HA1.setEnabled(true);
        HA1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HA1) {
                    if(rev){
                        if( m1.get(HA1.getText()).HP==0){
                            p1.alive++;
                            p1d1.setEnabled(true);
                        }
                        m1.get(HA1.getText()).HP += p1.healer.Super();
                        p1d1l.setText("+"+p1.healer.Super());
                    }
                    else{
                        m1.get(HA1.getText()).HP += p1.healer.Skill();
                        p1d1l.setText("+"+p1.healer.Skill());
                    }
                    if( m1.get(HA1.getText()).HP>  m1.get(HA1.getText()).cHP){
                        m1.get(HA1.getText()).HP =  m1.get(HA1.getText()).cHP;
                    }
                    p1d1l.setForeground(new Color(10,255,120));
                    p1d1l.setVisible(true);
                    p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                    System.out.println(HA1.getText()+" was healed to "+  m1.get(HA1.getText()).HP +" HP");
                    healPanel.setVisible(false);
                    healPanel.setEnabled(false);
                    if (pvp){
                        fa1.setEnabled(false);
                        fa2.setEnabled(false);
                        fa3.setEnabled(false);
                        if (m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        ComputerTurn();
                    }
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);

                }
            }
        });

        HA2.setFocusable(false);
        HA2.setBounds(150,450,300,60);
        HA2.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPanel.add(HA2);
        HA2.setVisible(true);
        HA2.setEnabled(true);
        HA2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HA2) {
                    if(rev){
                        if( m1.get(HA2.getText()).HP==0){
                            p1.alive++;
                            p1d2.setEnabled(true);
                        }
                        m1.get(HA2.getText()).HP += p1.healer.Super();
                        p1d2l.setText("+"+p1.healer.Super());
                    }
                    else{
                        m1.get(HA2.getText()).HP += p1.healer.Skill();
                        p1d2l.setText("+"+p1.healer.Skill());
                    }
                    if( m1.get(HA2.getText()).HP>  m1.get(HA2.getText()).cHP){
                        m1.get(HA2.getText()).HP =  m1.get(HA2.getText()).cHP;
                    }
                    p1d2l.setForeground(new Color(10,255,120));
                    p1d2l.setVisible(true);
                    p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                    System.out.println(HA2.getText()+" was healed to "+  m1.get(HA2.getText()).HP +" HP");
                    healPanel.setVisible(false);
                    healPanel.setEnabled(false);
                    if (pvp){
                        fa1.setEnabled(false);
                        fa2.setEnabled(false);
                        fa3.setEnabled(false);
                        if (m2.get(fb1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(fb2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(fb3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        ComputerTurn();
                    }
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);

                }
            }
        });


        HA3.setFocusable(false);
        HA3.setBounds(50,550,300,60);
        HA3.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPanel.add(HA3);
        HA3.setVisible(true);
        HA3.setEnabled(true);
        HA3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HA3) {
                    if(rev){
                        if( m1.get(HA3.getText()).HP==0){
                            p1.alive++;
                            p1d3.setEnabled(true);
                        }
                        m1.get(HA3.getText()).HP += p1.healer.Super();
                        p1d3l.setText("+"+p1.healer.Super());
                    }
                    else{
                        m1.get(HA3.getText()).HP += p1.healer.Skill();

                        p1d3l.setText("+"+p1.healer.Skill());
                    }
                    if( m1.get(HA3.getText()).HP>  m1.get(HA3.getText()).cHP){
                        m1.get(HA3.getText()).HP =  m1.get(HA3.getText()).cHP;
                    }
                    p1d3l.setForeground(new Color(10,255,120));
                    p1d3l.setVisible(true);
                    p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                    System.out.println(HA3.getText()+" was healed to "+  m1.get(HA3.getText()).HP +" HP");
                    healPanel.setVisible(false);
                    healPanel.setEnabled(false);
                    if (pvp) {
                        fa1.setEnabled(false);
                        fa2.setEnabled(false);
                        fa3.setEnabled(false);
                        if (m2.get(fb1.getText()).HP > 0) {
                            fb1.setEnabled(true);
                        } else {
                            fb1.setEnabled(false);
                        }
                        if (m2.get(fb2.getText()).HP > 0) {
                            fb2.setEnabled(true);
                        } else {
                            fb2.setEnabled(false);
                        }
                        if (m2.get(fb3.getText()).HP > 0) {
                            fb3.setEnabled(true);
                        } else {
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        ComputerTurn();
                    }
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);


                }
            }
        });


        HB1.setFocusable(false);
        HB1.setBounds(1050,350,300,60);
        HB1.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPanel.add(HB1);
        HB1.setVisible(true);
        HB1.setEnabled(true);
        HB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HB1) {
                    if(rev){
                        if( m2.get(HB1.getText()).HP==0){
                            p2.alive++;
                            p2d1.setEnabled(true);
                        }
                        m2.get(HB1.getText()).HP += p2.healer.Super();
                        p2d1l.setText("+"+p2.healer.Super());
                    }
                    else{
                        m2.get(HB1.getText()).HP += p2.healer.Skill();
                        p2d1l.setText("+"+p2.healer.Skill());
                    }
                    if( m2.get(HB1.getText()).HP>  m2.get(HB1.getText()).cHP){
                        m2.get(HB1.getText()).HP =  m2.get(HB1.getText()).cHP;
                    }
                    p2d1l.setForeground(new Color(10,255,120));
                    p2d1l.setVisible(true);
                    p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                    System.out.println(HB1.getText()+" was healed to "+  m2.get(HB1.getText()).HP +" HP");
                    healPanel.setVisible(false);
                    healPanel.setEnabled(false);
                    if (m1.get(fa1.getText()).HP>0){
                        fa1.setEnabled(true);
                    }
                    else{
                        fa1.setEnabled(false);
                    }
                    if (m1.get(fa2.getText()).HP>0){
                        fa2.setEnabled(true);
                    }
                    else{
                        fa2.setEnabled(false);
                    }
                    if (m1.get(fa3.getText()).HP>0){
                        fa3.setEnabled(true);
                    }
                    else{
                        fa3.setEnabled(false);
                    }
                    fb1.setEnabled(false);
                    fb2.setEnabled(false);
                    fb3.setEnabled(false);
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);
                }
            }
        });


        HB2.setFocusable(false);
        HB2.setBounds(900,450,300,60);
        HB2.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPanel.add(HB2);
        HB2.setVisible(true);
        HB2.setEnabled(true);
        HB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HB2) {
                    if(rev){
                        if( m2.get(HB2.getText()).HP==0){
                            p2.alive++;
                            p2d2.setEnabled(true);
                        }
                        m2.get(HB2.getText()).HP += p2.healer.Super();
                        p2d2l.setText("+"+p2.healer.Super());
                    }
                    else{
                        m2.get(HB2.getText()).HP += p2.healer.Skill();
                        p2d2l.setText("+"+p2.healer.Skill());
                    }
                    if( m2.get(HB2.getText()).HP>  m2.get(HB2.getText()).cHP){
                        m2.get(HB2.getText()).HP =  m2.get(HB2.getText()).cHP;
                    }
                    p2d2l.setForeground(new Color(10,255,120));
                    p2d2l.setVisible(true);
                    p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                    System.out.println(HB2.getText()+" was healed to "+  m2.get(HB2.getText()).HP +" HP");
                    healPanel.setVisible(false);
                    healPanel.setEnabled(false);
                    if (m1.get(fa1.getText()).HP>0){
                        fa1.setEnabled(true);
                    }
                    else{
                        fa1.setEnabled(false);
                    }
                    if (m1.get(fa2.getText()).HP>0){
                        fa2.setEnabled(true);
                    }
                    else{
                        fa2.setEnabled(false);
                    }
                    if (m1.get(fa3.getText()).HP>0){
                        fa3.setEnabled(true);
                    }
                    else{
                        fa3.setEnabled(false);
                    }
                    fb1.setEnabled(false);
                    fb2.setEnabled(false);
                    fb3.setEnabled(false);
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);
                }
            }
        });


        HB3.setFocusable(false);
        HB3.setBounds(1050,550,300,60);
        HB3.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPanel.add(HB3);
        HB3.setVisible(true);
        HB3.setEnabled(true);
        HB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HB3) {
                    if(rev){
                        if( m2.get(HB3.getText()).HP==0){
                            p2.alive++;
                            p2d3.setEnabled(true);
                        }
                        m2.get(HB3.getText()).HP += p2.healer.Super();
                        p2d3l.setText("+"+p2.healer.Super());
                    }
                    else{
                        m2.get(HB3.getText()).HP += p2.healer.Skill();
                        p2d3l.setText("+"+p2.healer.Skill());
                    }
                    if( m2.get(HB3.getText()).HP>  m2.get(HB3.getText()).cHP){
                        m2.get(HB3.getText()).HP =  m2.get(HB3.getText()).cHP;
                    }
                    p2d3l.setForeground(new Color(10,255,120));
                    p2d3l.setVisible(true);
                    p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                    System.out.println(HB3.getText()+" was healed to "+  m2.get(HB3.getText()).HP +" HP");
                    healPanel.setVisible(false);
                    healPanel.setEnabled(false);
                    if (m1.get(fa1.getText()).HP>0){
                        fa1.setEnabled(true);
                    }
                    else{
                        fa1.setEnabled(false);
                    }
                    if (m1.get(fa2.getText()).HP>0){
                        fa2.setEnabled(true);
                    }
                    else{
                        fa2.setEnabled(false);
                    }
                    if (m1.get(fa3.getText()).HP>0){
                        fa3.setEnabled(true);
                    }
                    else{
                        fa3.setEnabled(false);
                    }
                    fb1.setEnabled(false);
                    fb2.setEnabled(false);
                    fb3.setEnabled(false);
                    fightPanel.setEnabled(true);
                    fightPanel.setVisible(true);
                }
            }
        });

        this.add(winPanel);
        winPanel.setVisible(false);
        winPanel.setEnabled(false);
        winPanel = new JPanel();
        winPanel.setLayout(null);
        winPanel.setBackground(new Color(100, 60, 140));
        winPanel.setSize(1600, 800);
        this.add(winPanel);
        winPanel.setVisible(false);
        winPanel.setEnabled(false);

        winPanelLabel = new JLabel();
        winPanelLabel.setVisible(true);
        winPanelLabel.setBounds(300,300,1200,100);
        winPanelLabel.setFont(new Font("Arial",Font.BOLD,120));
        winPanelLabel.setForeground(new Color(255,30,0));
        winPanelLabel.setVisible(true);
        winPanel.add(winPanelLabel);

        Home.setBounds(1000, 200, 120, 90);
        winPanel.add(Home);
        Home.addActionListener(this);
        Home.setText("Home");
        Home.setFocusable(false);
        Home.setFont(new Font("Comic Sans", Font.BOLD,35));
        Home.setBorder(BorderFactory.createCompoundBorder());
        Home.setEnabled(true);
        Home.setVisible(true);
        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Home){
                    turn = 1;
                    p1 = new Player();
                    p2 = null;
                    D2 = null;
                    selected = 0;
                    if (pvp){
                        fightPanelLabel.setText("Round "+r+ " Player "+turn+" turn" );
                    }
                    else{
                        fightPanelLabel.setText("Round "+r );
                    }
                    r = 1;
                    Ab.setEnabled(true);
                    ab.setEnabled(true);
                    hb.setEnabled(true);
                    sb.setEnabled(true);
                    tb.setEnabled(true);
                    p1d1.setEnabled(true);
                    p1d2.setEnabled(true);
                    p1d3.setEnabled(true);
                    p2d1.setEnabled(true);
                    p2d2.setEnabled(true);
                    p2d3.setEnabled(true);
                    fa1.setEnabled(true);
                    fa2.setEnabled(true);
                    fa3.setEnabled(true);
                    winPanel.setEnabled(false);
                    winPanel.setVisible(false);
                    startPanel.setEnabled(true);
                    startPanel.setVisible(true);
                }
            }
        });

        playAgain.setBounds(600, 500, 400, 90);
        winPanel.add(playAgain);
        playAgain.addActionListener(this);
        playAgain.setText("Play Again");
        playAgain.setFocusable(false);
        playAgain.setFont(new Font("Comic Sans", Font.BOLD,35));
        playAgain.setBorder(BorderFactory.createCompoundBorder());
        playAgain.setEnabled(true);
        playAgain.setVisible(true);
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == playAgain){
                    selected = 0;
                    turn = 1;
                    r = 1;

                    p1 = new Player();
                    if (pvp){
                        pvpPanel3Label.setText("Player 1 choose your Heroes");
                        fightPanelLabel.setText("Round "+r+ " Player "+turn+" turn" );
                        p2 = new Player();
                        D2 = null;
                    }
                    else{
                        pvpPanel3Label.setText("Choose your Heroes");
                        fightPanelLabel.setText("Round "+r );
                        computer = new Computer();
                        p2d1.setText(computer.chosen[0].Class);
                        p2d2.setText(computer.chosen[1].Class);
                        p2d3.setText(computer.chosen[2].Class);
                        fb1.setText(computer.chosen[0].Class);
                        fb2.setText(computer.chosen[1].Class);
                        fb3.setText(computer.chosen[2].Class);
                        HB1.setText(computer.chosen[0].Class);
                        HB2.setText(computer.chosen[1].Class);
                        HB3.setText(computer.chosen[2].Class);
                        p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                        p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                        p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                        sortButtons();
                    }
                    r = 0;

                    Ab.setEnabled(true);
                    ab.setEnabled(true);
                    hb.setEnabled(true);
                    sb.setEnabled(true);
                    tb.setEnabled(true);
                    p1d1.setEnabled(true);
                    p1d2.setEnabled(true);
                    p1d3.setEnabled(true);
                    p2d1.setEnabled(true);
                    p2d2.setEnabled(true);
                    p2d3.setEnabled(true);
                    fa1.setEnabled(true);
                    fa2.setEnabled(true);
                    fa3.setEnabled(true);
                    winPanel.setEnabled(false);
                    winPanel.setVisible(false);
                    panel2.setEnabled(true);
                    panel2.setVisible(true);
                }
            }
        });



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== startButton){
            startPanel.setVisible(false);
            startPanel.setEnabled(false);
            panel1.setVisible(true);
            panel1.setEnabled(true);
        }
    }
}
