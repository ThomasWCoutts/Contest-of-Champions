import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class gui4 extends JFrame implements ActionListener {
     boolean limited = false, pvp,rev = false;
     HashMap<String,Hero> m1 = new HashMap<String,Hero>();
     HashMap<String,Hero> m2 = new HashMap<String,Hero>();
     JButton n,s,S,b1,b2,b3,b4, startButton, NextB1,NextB2,Undo,Undo2,Back0, Back1,Back2, Ab, ab, hb, sb, tb, p1d1, p1d2, p1d3, p2d1, p2d2, p2d3, fa1,fa2,fa3,fb1,fb2,fb3,HA1,HA2,HA3,HB1,HB2,HB3,Home,playAgain,p1b1,p1b2,p1b3,p2b1,p2b2,p2b3,helpButton,assaultb,assassinb,healerb,supportb,tankb,helpClose,apc,aspc,hpc,spc,tpc,assaultb1, assassinb1, healerb1, supportb1, tankb1, apc1, aspc1, hpc1, spc1, tpc1,Butt;
     JLabel  startLabel,startpic,panel1Label,deathLabel,roundsLabel,panel2Label,panel3Label, pvpPanel3Label,defendPanelLabel, fightPanelLabel,healPanelLabel,winPanelLabel,p1a1l,p1a2l,p1a3l,p2a1l,p2a2l,p2a3l,p1d1l,p1d2l,p1d3l,p2d1l,p2d2l,p2d3l,freeze1,freeze2,bleed1 = new JLabel(),bleed2 = new JLabel(),p1s1,p1attack1,p1spec1,p1e1,p1s2,p1attack2,p1spec2,p1e2,p1s3,p1attack3,p1spec3,p1e3 = new JLabel(),p2s1,p2attack1 = new JLabel(),p2spec1,p2e1 = new JLabel(),p2s2,p2attack2 = new JLabel(),p2spec2,p2e2 = new JLabel(),p2s3,p2attack3 = new JLabel(),p2spec3,p2e3 = new JLabel(),p1life1l,p1life2l,p1life3l,p2life1l,p2life2l,p2life3l,Player1,Player11,Player12,Player13,Player2,Player21,Player22,Player23,assaultPanelLabel,assassinPanelLabel,healerPanelLabel,supportPanelLabel,tankPanelLabel,l1,p11,p12,p13,p21,p22,p23,aI,asI,hI,sI,tI,p11d,p12d,p13d,p21d,p22d,p23d,p11f,p12f,p13f,p21f,p22f,p23f,p11h,p12h,p13h,p21h,p22h,p23h,c1,c2,c3,c4,c5,charda1,charda2,charda3,charfa1,charfa2,charfa3,charha1,charha2,charha3,chardb1,chardb2,chardb3,charfb1,charfb2,charfb3,charhb1,charhb2,charhb3,p1health1l,p1health2l,p1health3l,p2health1l,p2health2l,p2health3l, bg3,bgop,bgs,bgh,bgd,bgc,bgm,bgm2,side11,side12,side2;
     JLayeredPane thePane, pane1, pane2,pane3,defendPane,fightPane,healPane,startPane,pane21, winPane;
     ImageIcon sky,dIcon,rIcon,p1aa,p1ad,p1af,p1ah,p1ai,p1an,p1asa,p1asd,p1asf,p1ash,p1asi,p1asn,p1hd,p1hf,p1hh,p1hi,p1hn,p1sa,p1sd,p1sf,p1sh,p1si,p1sn,p1ta,p1td,p1tf,p1th,p1ti,p1tn,p2aa,p2ad,p2af,p2ah,p2ai,p2an,p2asa,p2asd,p2asf,p2ash,p2asi,p2asn,p2hi,p2hd,p2hf,p2hh,p2hn,p2sa,p2sd,p2sf,p2sh,p2si,p2sn,p2ta,p2td,p2tf,p2th,p2ti,p2tn,sIcon,bg3Icon,p1asb,p1ab,p1hb,p1sb,p1tb,p2asb,p2ab,p2hb,p2sb,p2tb;
     JPanel panel1,panel2,panel3, pvpPanel3, defendPanel, fightPanel,healPanel,winPanel,p1p1,p1p2,p1p3,p2p1,p2p2,p2p3,helpPanel,assaultPanel,assassinPanel,healerPanel,supportPanel,tankPanel, assaultPanel1, assassinPanel1, healerPanel1, supportPanel1, tankPanel1;
     JTextArea assaultText1, assassinText1, healerText, supportText1, tankText1;
     int rounds, turn = 1, selected = 0,r = 1, damage;
     Player p1 = new Player(), p2;
     Computer computer;
     TextField panel3Textbox;
     String D1,D2,A1,A2;
     Timerr timer1,timer2,timer3,timer4,timer5,timer6,timer7,timer8;
     TimerTask task;
     

    public void playSound()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("track.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        FloatControl fc = (FloatControl)clip1.getControl(FloatControl.Type.MASTER_GAIN);
        fc.setValue(-7.0f);
        clip1.loop(Clip.LOOP_CONTINUOUSLY);
        clip1.start();
    }

    public void playHit()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("hit.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        FloatControl fc = (FloatControl)clip1.getControl(FloatControl.Type.MASTER_GAIN);
        fc.setValue(6.0f);
        clip1.start();
    }

    public void playBlob()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("blob.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.start();
    }

    public void playBuff()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("buff.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.start();
    }

    public void playFreeze()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("freeze.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        //clip1.setMicrosecondPosition();
        clip1.start();
    }

    public void playDie()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("die.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.start();
    }

    public void playHeal()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("heal.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.setMicrosecondPosition(3000);
        clip1.start();
    }

    public void playBack()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("back.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.setMicrosecondPosition(3000);
        clip1.start();
    }

    public void playSelect()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("select.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.start();
    }


    public void playClick()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("click.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.start();
    }

    public void playDraw()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("draw.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.start();
    }

    public void playWin()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        File f1 = new File("win.wav");
        AudioInputStream a1 = AudioSystem.getAudioInputStream(f1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(a1);
        clip1.start();
    }

    public  void getImages(){
        try{
            p1aa = new ImageIcon("P1 Assault Attack.png");
            p1ad = new ImageIcon("P1 Assault Dead.png");
            p1af = new ImageIcon("P1 Assault Freeze.png");
            p1ah = new ImageIcon("P1 Assault Heal.png");
            p1ai = new ImageIcon("P1 Assault Idle.png");
            p1an = new ImageIcon("P1 Assault Nerf.png");
            p1asa = new ImageIcon("P1 Assassin Attack.png");
            p1asd = new ImageIcon("P1 Assassin Dead.png");
            p1asf = new ImageIcon("P1 Assassin Freeze.png");
            p1ash = new ImageIcon("P1 Assassin Heal.png");
            p1asi = new ImageIcon("P1 Assassin Idle.png");
            p1asn = new ImageIcon("P1 Assassin Nerf.png");
            //p1hi = new ImageIcon("P1 Healer Attack.png");
            p1hd = new ImageIcon("P1 Healer Dead.png");
            p1hf = new ImageIcon("P1 Healer Freeze.png");
            p1hh = new ImageIcon("P1 Healer Heal.png");
            p1hi = new ImageIcon("P1 Healer Idle.png");
            p1hn = new ImageIcon("P1 Healer Nerf.png");
            p1sa = new ImageIcon("P1 Support Attack.png");
            p1sd = new ImageIcon("P1 Support Dead.png");
            p1sf = new ImageIcon("P1 Support Freeze.png");
            p1sh = new ImageIcon("P1 Support Heal.png");
            p1si = new ImageIcon("P1 Support Idle.png");
            p1sn = new ImageIcon("P1 Support Nerf.png");
            p1ta = new ImageIcon("P1 Tank Attack.png");
            p1td = new ImageIcon("P1 Tank Dead.png");
            p1tf = new ImageIcon("P1 Tank Freeze.png");
            p1th = new ImageIcon("P1 Tank Heal.png");
            p1ti = new ImageIcon("P1 Tank Idle.png");
            p1tn = new ImageIcon("P1 Tank Nerf.png");

            p2aa = new ImageIcon("P2 Assault Attack.png");
            p2ad = new ImageIcon("P2 Assault Dead.png");
            p2af = new ImageIcon("P2 Assault Freeze.png");
            p2ah = new ImageIcon("P2 Assault Heal.png");
            p2ai = new ImageIcon("P2 Assault Idle.png");
            p2an = new ImageIcon("P2 Assault Nerf.png");
            p2asa = new ImageIcon("P2 Assassin Attack.png");
            p2asd = new ImageIcon("P2 Assassin Dead.png");
            p2asf = new ImageIcon("P2 Assassin Freeze.png");
            p2ash = new ImageIcon("P2 Assassin Heal.png");
            p2asi = new ImageIcon("P2 Assassin Idle.png");
            p2asn = new ImageIcon("P2 Assassin Nerf.png");
            //p2hi = new ImageIcon("P2 Healer Attack.png");
            p2hd = new ImageIcon("P2 Healer Dead.png");
            p2hf = new ImageIcon("P2 Healer Freeze.png");
            p2hh = new ImageIcon("P2 Healer Heal.png");
            p2hi = new ImageIcon("P2 Healer Idle.png");
            p2hn = new ImageIcon("P2 Healer Nerf.png");
            p2sa = new ImageIcon("P2 Support Attack.png");
            p2sd = new ImageIcon("P2 Support Dead.png");
            p2sf = new ImageIcon("P2 Support Freeze.png");
            p2sh = new ImageIcon("P2 Support Heal.png");
            p2si = new ImageIcon("P2 Support Idle.png");
            p2sn = new ImageIcon("P2 Support Nerf.png");
            p2ta = new ImageIcon("P2 Tank Attack.png");
            p2td = new ImageIcon("P2 Tank Dead.png");
            p2tf = new ImageIcon("P2 Tank Freeze.png");
            p2th = new ImageIcon("P2 Tank Heal.png");
            p2ti = new ImageIcon("P2 Tank Idle.png");
            p2tn = new ImageIcon("P2 Tank Nerf.png");
            boolean t = true;
            p1ab = new ImageIcon("P1 Assault Buff.png");
            p1asb = new ImageIcon("P1 Assassin Buff.png");
            p1hb = new ImageIcon("P1 Healer Buff.png");
            p1sb = new ImageIcon("P1 Support Buff.png");
            p1tb = new ImageIcon("P1 Tank Buff.png");


            p2ab = new ImageIcon("P2 Assault Buff.png");
            p2asb = new ImageIcon("P2 Assassin Buff.png");
            p2hb = new ImageIcon("P2 Healer Buff.png");
            p2sb = new ImageIcon("P2 Support Buff.png");
            p2tb = new ImageIcon("P2 Tank Buff.png");
            //sIcon = new ImageIcon(A1);
            dIcon = new ImageIcon("DeathMatch.png");
            rIcon = new ImageIcon("TimeTrial.png");
            bg3Icon = new ImageIcon("bg3.png");
            sky = new ImageIcon("sky1.png");

            if(!t){
                throw new IOException();
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public  void sortButtons(){
        if (computer.getDef().Class.equals(p2d1.getText())){
            p2d1.setBounds(1100,270,100,100);
            p2d2.setBounds(950,350,100,100);
            p2d3.setBounds(1100,430,100,100);

            p21d.setBounds(1100, 270,100,100);
            p21f.setBounds(1100, 270,100,100);
            p21h.setBounds(1100, 270,100,100);

            p22d.setBounds(950, 350,100,100);
            p22f.setBounds(950, 350,100,100);
            p22h.setBounds(950, 350,100,100);

            p23d.setBounds(1100, 430,100,100);
            p23f.setBounds(1100, 430,100,100);
            p23h.setBounds(1100, 430,100,100);

            chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
            chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
            chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
            charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
            charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
            charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
            charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
            charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
            charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

            fb1.setBounds(1100,270,100,100);
            fb2.setBounds(950,350,100,100);
            fb3.setBounds(1100,430,100,100);

            HB1.setBounds(1100,270,100,100);
            HB2.setBounds(950,350,100,100);
            HB3.setBounds(1100,430,100,100);

            p2d1l.setBounds(920,295,300,50);
            p2d2l.setBounds(920,295,300,50);
            p2d3l.setBounds(920,295,300,50);

            p2a1l.setBounds(1100,400,300,50);
            p2a2l.setBounds(950,480,300,50);
            p2a3l.setBounds(1100,550,300,50);

            p2life1l.setBounds(1100,400,300,50);
            p2life2l.setBounds(950,480,300,50);
            p2life3l.setBounds(1100,550,300,50);

            p2health1l.setBounds(1100,400,300,50);
            p2health2l.setBounds(950,480,300,50);
            p2health3l.setBounds(1100,550,300,50);

        }
        else if (computer.getDef().Class.equals(p2d2.getText())){
                    p2d1.setBounds(950,350,100,100);
                    p2d2.setBounds(1100,270,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(950, 350,100,100);
                    p21f.setBounds(950, 350,100,100);
                    p21h.setBounds(950, 350,100,100);

                    p22d.setBounds(1100, 270,100,100);
                    p22f.setBounds(1100, 270,100,100);
                    p22h.setBounds(1100, 270,100,100);

                    p23d.setBounds(1100, 430,100,100);
                    p23f.setBounds(1100, 430,100,100);
                    p23h.setBounds(1100, 430,100,100);

                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    fb1.setBounds(950,350,100,100);
                    fb2.setBounds(1100,270,100,100);
                    fb3.setBounds(1100,430,100,100);

                    HB1.setBounds(950,350,100,100);
                    HB2.setBounds(1100,270,100,100);
                    HB3.setBounds(1100,430,100,100);

                    p2d1l.setBounds(920,295,300,50);
                    p2d2l.setBounds(920,295,300,50);
                    p2d3l.setBounds(920,295,300,50);

                    p2a1l.setBounds(950,480,300,50);
                    p2a2l.setBounds(1100,400,300,50);
                    p2a3l.setBounds(1100,550,300,50);

                    p2life1l.setBounds(950,480,300,50);
                    p2life2l.setBounds(1100,400,300,50);
                    p2life3l.setBounds(1100,550,300,50);

                    p2health1l.setBounds(950,480,300,50);
                    p2health2l.setBounds(1100,400,300,50);
                    p2health3l.setBounds(1100,550,300,50);

        }
        else{
                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(1100,430,100,100);
                    p2d3.setBounds(950,350,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p21f.setBounds(1100, 270,100,100);
                    p21h.setBounds(1100, 270,100,100);

                    p22d.setBounds(1100, 430,100,100);
                    p22f.setBounds(1100, 430,100,100);
                    p22h.setBounds(1100, 430,100,100);

                    p23d.setBounds(950, 350,100,100);
                    p23f.setBounds(950, 350,100,100);
                    p23h.setBounds(950, 350,100,100);

                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    fb1.setBounds(1100,270,100,100);
                    fb2.setBounds(1100,430,100,100);
                    fb3.setBounds(950,350,100,100);

                    HB1.setBounds(1100,270,100,100);
                    HB2.setBounds(1100,430,100,100);
                    HB3.setBounds(950,350,100,100);

                    p2d1l.setBounds(920,295,300,50);
                    p2d2l.setBounds(920,295,300,50);
                    p2d3l.setBounds(920,295,300,50);

                    p2a1l.setBounds(1100,400,300,50);
                    p2a2l.setBounds(1100,550,300,50);
                    p2a3l.setBounds(950,480,300,50);

                    p2life1l.setBounds(1100,400,300,50);
                    p2life2l.setBounds(1100,550,300,50);
                    p2life3l.setBounds(950,480,300,50);

                    p2health1l.setBounds(1100,400,300,50);
                    p2health2l.setBounds(1100,550,300,50);
                    p2health3l.setBounds(950,480,300,50);
        }

    }

    public  void ComputerTurn()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        if (turn == 2){
            p1d1l.setForeground(Color.RED);
            p1d2l.setForeground(Color.RED);
            p1d3l.setForeground(Color.RED);
            p2d1l.setVisible(false);
            p2d2l.setVisible(false);
            p2d3l.setVisible(false);
            if (p1.FindSupport() && p1.support.nerfs > 0) {
                computer.getAt().Attack -= p1.support.Nerf();
                System.out.println("Computer " + computer.getAt().Class + " was nerfed");
                p1.support.nerfs--;
                try{
                    nerfp2();
                }
                catch(UnsupportedAudioFileException x){
                    x.getStackTrace();
                }
                catch(IOException f){
                    f.getStackTrace();
                }
                catch(LineUnavailableException g){
                    g.getStackTrace();
                }

                //p2reset();
            }
            else{
                p2reset();
            }
            if (computer.FindSupport() && computer.getSupport().up > 0) {
                computer.getAt().Attack += computer.getSupport().Buff();
                computer.getSupport().up=0;
                p2reset();
                System.out.println("Computer " + computer.getAt().Class + " was buffed");
                freeze2.setText("buffed*");
                freeze2.setForeground(new Color(255,95,31));
                freeze2.setVisible(true);
            }
            if (computer.FindAssassin() && computer.getAssassin().CutCount > 0) {
                m1.get(D1).HP -= computer.getAssassin().Bleed;
                System.out.println("Player 1 " + D1 + " is bleeding \t HP -" + computer.getAssassin().Bleed);
                computer.getAssassin().CutCount--;
                bleed1.setText("-"+computer.assassin.Bleed);
                bleed1.setVisible(true);
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
                p2heal(computer.getDef().Class);
                p1reset();
                p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                p2health1l.setText(String.valueOf(computer.chosen[0].HP));
                p2health2l.setText(String.valueOf(computer.chosen[1].HP));
                p2health3l.setText(String.valueOf(computer.chosen[2].HP));
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
                p1reset();
                p2hit(computer.getAt().Class);
                System.out.println("Player 1 " + D1 + " had " + m1.get(D1).HP + " HP");
                if (!computer.getAt().Class.equals("healer")){
                    if(computer.getAt().Energy>=100){
                        damage = computer.getAt().Super();

                    }
                    else if (r%2==0) {
                        damage = computer.getAt().Skill();
                    }
                    else{
                        damage= computer.getAt().Normal();
                    }
                }
                else{
                    damage = computer.getAt().Normal();
                }
                if (computer.FindSupport()&& computer.getSupport().nerfs>0){
                    freeze1.setText("nerfed*");
                    freeze1.setForeground(new Color(3,75,3));
                    freeze1.setVisible(true);
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
                p2hit(computer.getAt().Class);
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
                if (m1.get(D1).HP <=0) {
                    m1.get(D1).HP = 0;
                    System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                    killp1(computer.getAt().Class, D1);
                    p1.alive--;
                    if (m1.get(HA1.getText()).HP>0){
                        p1d1.setEnabled(true);
                        charha1.setBackground(Color.WHITE);
                    }
                    else{
                        p1d1.setEnabled(false);
                        charha1.setBackground(null);
                    }
                    if (m1.get(HA2.getText()).HP>0){
                        p1d2.setEnabled(true);
                        charha2.setBackground(Color.WHITE);
                    }
                    else{
                        p1d2.setEnabled(false);
                        charha2.setBackground(null);
                    }
                    if (m1.get(HA3.getText()).HP>0){
                        p1d3.setEnabled(true);
                        charha3.setBackground(Color.WHITE);
                    }
                    else{
                        p1d3.setEnabled(false);
                        charha3.setBackground(null);
                    }
                    
                    if (p1.alive == 0) {
                        winPanelLabel.setText("Computer won!");
                        winPane.setEnabled(true);
                        winPane.setVisible(true);
                    }
                    else {
                        defendPanelLabel.setText("Select your defending hero");
                        defendPane.setEnabled(true);
                        defendPane.setVisible(true);
                    }
                    fightPane.setVisible(false);
                    fightPane.setEnabled(false);
                }

                else{
                    System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                }
                p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
            }
            p2e1.setText("Energy: "+ m2.get(HB1.getText()).Energy);
            p2attack1.setText("Attack Strength: "+ m2.get(HB1.getText()).Attack);
            p2e2.setText("Energy: "+ m2.get(HB2.getText()).Energy);
            p2attack2.setText("Attack Strength: "+ m2.get(HB2.getText()).Attack);
            p2e3.setText("Energy: "+ m2.get(HB3.getText()).Energy);
            p2attack3.setText("Attack Strength: "+ m2.get(HB3.getText()).Attack);
            if (computer.FindSupport() && computer.getSupport().Skips>0){
                System.out.println(("Player 1 was frozen"));
                freezep1();
                p2reset();
                freeze1.setForeground(new Color(0,255,255));
                freeze1.setVisible(true);
                fa1.setEnabled(false);
                fa2.setEnabled(false);
                fa3.setEnabled(false);
                r++;
                fightPanelLabel.setText("       Round "+ r);
                if (limited && r == rounds+1){
                    if (p1.alive>computer.alive){
                        winPanelLabel.setText("Player 1 won!");
                        try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                    }
                    else if (p1.alive<computer.alive){
                        winPanelLabel.setText("Computer won!");
                        try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                    }
                    else{
                        winPanelLabel.setText("Draw !");
                        try{
                                playDraw();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                    }
                    winPane.setVisible(true);
                    winPane.setEnabled(true);
                    fightPane.setEnabled(false);
                    fightPane.setVisible(false);
                }
                else{
                    if (p1.assassin!=null && p1.assassin.CutCount>0){
                        computer.getDef().HP-= p1.assassin.Bleed;
                        System.out.println("Computer " +computer.getDef().Class + " is bleeding \t HP -"+p1.assassin.Bleed);
                        p1.assassin.CutCount--;
                        bleed2.setText("-"+p1.assassin.Bleed);
                        bleed2.setVisible(true);
                    }
                    computer.getSupport().Skips = 0;
                    timer1.start();;
                }
                if(computer.FindSupport()&&computer.support.up>0){
                    freeze2.setText("buffed*");
                    freeze2.setForeground(new Color(255,95,31));
                    freeze2.setVisible(true);
                    try{
                        buffp2();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                }
            }
            if (computer.FindSupport() && computer.support.nerfs > 0) {
                try{
                    nerfp1();
                }
                catch(UnsupportedAudioFileException x){
                    x.getStackTrace();
                }
                catch(IOException f){
                    f.getStackTrace();
                }
                catch(LineUnavailableException g){
                    g.getStackTrace();
                }
                //System.out.println("Computer " + computer.getAt().Class + " was nerfed");
                computer.support.nerfs--;
                //p2reset();
            }
            if (m1.get(HA1.getText()).HP>0){
                fa1.setEnabled(true);
            }
            else{
                fa1.setEnabled(false);
            }
            if (m1.get(HA2.getText()).HP>0){
                fa2.setEnabled(true);
            }
            else{
                fa2.setEnabled(false);
            }
            if (m1.get(HA3.getText()).HP>0){
                fa3.setEnabled(true);
            }
            else{
                fa3.setEnabled(false);
            }
            
        }
        r++;
        fightPanelLabel.setText("       Round "+ r);
        turn = 1;
        if (limited && r == rounds+1){
            if (p1.alive>computer.alive){
                winPanelLabel.setText("Player 1 won!");
                try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
            }
            else if (p1.alive<computer.alive){
                winPanelLabel.setText("Computer won!");
                try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
            }
            else{
                winPanelLabel.setText("Draw !");try{
                                playDraw();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }

            }
            winPane.setVisible(true);
            winPane.setEnabled(true);
            fightPane.setEnabled(false);
            fightPane.setVisible(false);
        }
    }

    public void nerfp1()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playBlob();
        if(m1.get(p1.chosen[0].Class).HP>0){
            switch(p1.chosen[0].Class){
                case "assault":
                    p11f.setIcon(p1an);
                    p11d.setIcon(p1an);

                break;
                case "assassin":
                    p11f.setIcon(p1asn);
                    p11d.setIcon(p1asn);

                break;

                case "healer":
                    p11f.setIcon(p1hn);
                    p11d.setIcon(p1hn);
                break;
                case "support":
                    p11f.setIcon(p1sn);
                    p11d.setIcon(p1sn);

                break;
                case "tank":
                    p11f.setIcon(p1tn);
                    p11d.setIcon(p1tn);

                break;
                default:
            }
        }
        
        if(m1.get(p1.chosen[1].Class).HP>0){
            switch(p1.chosen[1].Class){
                case "assault":
                    p12f.setIcon(p1an);
                    p12d.setIcon(p1an);
                break;
                case "assassin":
                    p12f.setIcon(p1asn);
                    p12d.setIcon(p1asn);

                break;

                case "healer":
                    p12f.setIcon(p1hn);
                    p12d.setIcon(p1hn);

                break;
                case "support":
                    p12f.setIcon(p1sn);
                    p12d.setIcon(p1sn);

                break;
                case "tank":
                    p12f.setIcon(p1tn);
                    p12d.setIcon(p1tn);
                break;
                default:
            }
        }
        
        if(m1.get(p1.chosen[2].Class).HP>0){
            switch(p1.chosen[2].Class){
                case "assault":
                    p13f.setIcon(p1an);
                    p13d.setIcon(p1an);
                break;
                case "assassin":
                    p13f.setIcon(p1asn);
                    p13d.setIcon(p1asn);

                break;

                case "healer":
                    p13f.setIcon(p1hn);
                    p13d.setIcon(p1hn);

                break;
                case "support":
                    p13f.setIcon(p1sn);
                    p13d.setIcon(p1sn);

                break;
                case "tank":
                    p13f.setIcon(p1tn);
                    p13d.setIcon(p1tn);

                break;
                default:
            }
        }
    }

    public void nerfp2()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playBlob();
        if(pvp){
            if(m2.get(p2.chosen[0].Class).HP>0){
            switch(p2.chosen[0].Class){
                case "assault":
                    p21f.setIcon(p2an);
                    p21d.setIcon(p2an);
                break;
                case "assassin":
                    p21f.setIcon(p2asn);
                    p21d.setIcon(p2asn);

                break;

                case "healer":
                    p21f.setIcon(p2hn);
                    p21d.setIcon(p2hn);

                break;
                case "support":
                    p21f.setIcon(p2sn);
                    p21d.setIcon(p2sn);

                break;
                case "tank":
                    p21f.setIcon(p2tn);
                    p21d.setIcon(p2tn);

                break;
                default:
            }
            }
        
            if(m2.get(p2.chosen[1].Class).HP>0){
            switch(p2.chosen[1].Class){
                case "assault":
                    p22f.setIcon(p2an);
                    p22d.setIcon(p2an);
                break;
                case "assassin":
                    p22f.setIcon(p2asn);
                    p22d.setIcon(p2asn);

                break;

                case "healer":
                    p22f.setIcon(p2hn);
                    p22d.setIcon(p2hn);

                break;
                case "support":
                    p22f.setIcon(p2sn);
                    p22d.setIcon(p2sn);
                break;
                case "tank":
                    p22f.setIcon(p2tn);
                    p22d.setIcon(p2tn);

                break;
                default:
            }
            }
        
            if(m2.get(p2.chosen[2].Class).HP>0){
            switch(p2.chosen[2].Class){
                case "assault":
                    p23f.setIcon(p2an);
                    p23d.setIcon(p2an);
                break;
                case "assassin":
                    p23f.setIcon(p2asn);
                    p23d.setIcon(p2asn);

                break;

                case "healer":
                    p23f.setIcon(p2hn);
                    p23d.setIcon(p2hn);

                break;
                case "support":
                    p23f.setIcon(p2sn);
                    p23d.setIcon(p2sn);

                break;
                case "tank":
                    p23f.setIcon(p2tn);
                    p23d.setIcon(p2tn);

                break;
                default:
            }
        }
    }
        else{
            if(m2.get(computer.chosen[0].Class).HP>0){
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21f.setIcon(p2an);
                        p21d.setIcon(p2an);
                    break;
                    case "assassin":
                        p21f.setIcon(p2asn);
                        p21d.setIcon(p2asn);
    
                    break;
    
                    case "healer":
                        p21f.setIcon(p2hn);
                        p21d.setIcon(p2hn);
    
                    break;
                    case "support":
                        p21f.setIcon(p2sn);
                        p21d.setIcon(p2sn);
    
                    break;
                    case "tank":
                        p21f.setIcon(p2tn);
                        p21d.setIcon(p2tn);
    
                    break;
                    default:
                }
            
            }
                if(m2.get(computer.chosen[1].Class).HP>0){
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22f.setIcon(p2an);
                        p22d.setIcon(p2an);
                    break;
                    case "assassin":
                        p22f.setIcon(p2asn);
                        p22d.setIcon(p2asn);
    
                    break;
    
                    case "healer":
                        p22f.setIcon(p2hn);
                        p22d.setIcon(p2hn);
    
                    break;
                    case "support":
                        p22f.setIcon(p2sn);
                        p22d.setIcon(p2sn);
                    break;
                    case "tank":
                        p22f.setIcon(p2tn);
                        p22d.setIcon(p2tn);
    
                    break;
                    default:
                }
                }
            
                if(m2.get(computer.chosen[2].Class).HP>0){
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23f.setIcon(p2an);
                        p23d.setIcon(p2an);
                    break;
                    case "assassin":
                        p23f.setIcon(p2asn);
                        p23d.setIcon(p2asn);
    
                    break;
    
                    case "healer":
                        p23f.setIcon(p2hn);
                        p23d.setIcon(p2hn);
    
                    break;
                    case "support":
                        p23f.setIcon(p2sn);
                        p23d.setIcon(p2sn);
    
                    break;
                    case "tank":
                        p23f.setIcon(p2tn);
                        p23d.setIcon(p2tn);
    
                    break;
                    default:
                }
            }
            
        }
        
    }


    public void buffp1()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playBuff();
        if(m1.get(p1.chosen[0].Class).HP>0){
            switch(p1.chosen[0].Class){
                case "assault":
                    p11f.setIcon(p1ab);
                    p11d.setIcon(p1ab);

                break;
                case "assassin":
                    p11f.setIcon(p1asb);
                    p11d.setIcon(p1asb);

                break;

                case "healer":
                    p11f.setIcon(p1hb);
                    p11d.setIcon(p1hb);
                break;
                case "support":
                    p11f.setIcon(p1sb);
                    p11d.setIcon(p1sb);

                break;
                case "tank":
                    p11f.setIcon(p1tb);
                    p11d.setIcon(p1tb);

                break;
                default:
            }
        }
        
        if(m1.get(p1.chosen[1].Class).HP>0){
            switch(p1.chosen[1].Class){
                case "assault":
                    p12f.setIcon(p1ab);
                    p12d.setIcon(p1ab);
                break;
                case "assassin":
                    p12f.setIcon(p1asb);
                    p12d.setIcon(p1asb);

                break;

                case "healer":
                    p12f.setIcon(p1hb);
                    p12d.setIcon(p1hb);

                break;
                case "support":
                    p12f.setIcon(p1sb);
                    p12d.setIcon(p1sb);

                break;
                case "tank":
                    p12f.setIcon(p1tb);
                    p12d.setIcon(p1tb);
                break;
                default:
            }
        }
        
        if(m1.get(p1.chosen[2].Class).HP>0){
            switch(p1.chosen[2].Class){
                case "assault":
                    p13f.setIcon(p1ab);
                    p13d.setIcon(p1ab);
                break;
                case "assassin":
                    p13f.setIcon(p1asb);
                    p13d.setIcon(p1asb);

                break;

                case "healer":
                    p13f.setIcon(p1hb);
                    p13d.setIcon(p1hb);

                break;
                case "support":
                    p13f.setIcon(p1sb);
                    p13d.setIcon(p1sb);

                break;
                case "tank":
                    p13f.setIcon(p1tb);
                    p13d.setIcon(p1tb);

                break;
                default:
            }
        }
    }

    public void buffp2()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playBuff();
        if(pvp){
            if(m2.get(p2.chosen[0].Class).HP>0){
            switch(p2.chosen[0].Class){
                case "assault":
                    p21f.setIcon(p2ab);
                    p21d.setIcon(p2ab);
                break;
                case "assassin":
                    p21f.setIcon(p2asb);
                    p21d.setIcon(p2asb);

                break;

                case "healer":
                    p21f.setIcon(p2hb);
                    p21d.setIcon(p2hb);

                break;
                case "support":
                    p21f.setIcon(p2sb);
                    p21d.setIcon(p2sb);

                break;
                case "tank":
                    p21f.setIcon(p2tb);
                    p21d.setIcon(p2tb);

                break;
                default:
            }
        }
        
        if(m2.get(p2.chosen[1].Class).HP>0){
            switch(p2.chosen[1].Class){
                case "assault":
                    p22f.setIcon(p2ab);
                    p22d.setIcon(p2ab);
                break;
                case "assassin":
                    p22f.setIcon(p2asb);
                    p22d.setIcon(p2asb);

                break;

                case "healer":
                    p22f.setIcon(p2hb);
                    p22d.setIcon(p2hb);

                break;
                case "support":
                    p22f.setIcon(p2sb);
                    p22d.setIcon(p2sb);
                break;
                case "tank":
                    p22f.setIcon(p2tb);
                    p22d.setIcon(p2tb);

                break;
                default:
            }
        }
        
        if(m2.get(p2.chosen[2].Class).HP>0){
            switch(p2.chosen[2].Class){
                case "assault":
                    p23f.setIcon(p2ab);
                    p23d.setIcon(p2ab);
                break;
                case "assassin":
                    p23f.setIcon(p2asb);
                    p23d.setIcon(p2asb);

                break;

                case "healer":
                    p23f.setIcon(p2hb);
                    p23d.setIcon(p2hb);

                break;
                case "support":
                    p23f.setIcon(p2sb);
                    p23d.setIcon(p2sb);

                break;
                case "tank":
                    p23f.setIcon(p2tb);
                    p23d.setIcon(p2tb);

                break;
                default:
            }
        }
        }
        
    }
   
    public void freezep1()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playFreeze();
        if(m1.get(p1.chosen[0].Class).HP>0){
            switch(p1.chosen[0].Class){
                case "assault":
                    p11f.setIcon(p1af);
                    p11d.setIcon(p1af);
                break;
                case "assassin":
                    p11f.setIcon(p1asf);
                    p11d.setIcon(p1asf);

                break;

                case "healer":
                    p11f.setIcon(p1hf);
                    p11d.setIcon(p1hf);

                break;
                case "support":
                    p11f.setIcon(p1sf);
                    p11d.setIcon(p1sf);

                break;
                case "tank":
                    p11f.setIcon(p1tf);
                    p11d.setIcon(p1tf);

                break;
                default:
            }
        }
        
        if(m1.get(p1.chosen[1].Class).HP>0){
            switch(p1.chosen[1].Class){
                case "assault":
                    p12f.setIcon(p1af);
                    p12d.setIcon(p1af);
                break;
                case "assassin":
                    p12f.setIcon(p1asf);
                    p12d.setIcon(p1asf);

                break;

                case "healer":
                    p12f.setIcon(p1hf);
                    p12d.setIcon(p1hf);

                break;
                case "support":
                    p12f.setIcon(p1sf);
                    p12d.setIcon(p1sf);

                break;
                case "tank":
                    p12f.setIcon(p1tf);
                    p12d.setIcon(p1tf);

                break;
                default:
            }
        }
        
        if(m1.get(p1.chosen[2].Class).HP>0){
            switch(p1.chosen[2].Class){
                case "assault":
                    p13f.setIcon(p1af);
                    p13d.setIcon(p1af);
                break;
                case "assassin":
                    p13f.setIcon(p1asf);
                    p13d.setIcon(p1asf);

                break;

                case "healer":
                    p13f.setIcon(p1hf);
                    p13d.setIcon(p1hf);

                break;
                case "support":
                    p13f.setIcon(p1sf);
                    p13d.setIcon(p1sf);

                break;
                case "tank":
                    p13f.setIcon(p1tf);
                    p13d.setIcon(p1tf);

                break;
                default:
            }
        }
        else{
            if(!pvp&&m2.get(computer.chosen[0].Class).HP>0){
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21f.setIcon(p2an);
                        p21d.setIcon(p2an);
                    break;
                    case "assassin":
                        p21f.setIcon(p2asn);
                        p21d.setIcon(p2asn);
    
                    break;
    
                    case "healer":
                        p21f.setIcon(p2hn);
                        p21d.setIcon(p2hn);
    
                    break;
                    case "support":
                        p21f.setIcon(p2sn);
                        p21d.setIcon(p2sn);
    
                    break;
                    case "tank":
                        p21f.setIcon(p2tn);
                        p21d.setIcon(p2tn);
    
                    break;
                    default:
                }
            }
            
            if(m2.get(computer.chosen[1].Class).HP>0){
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22f.setIcon(p2an);
                        p22d.setIcon(p2an);
                    break;
                    case "assassin":
                        p22f.setIcon(p2asn);
                        p22d.setIcon(p2asn);
    
                    break;
    
                    case "healer":
                        p22f.setIcon(p2hn);
                        p22d.setIcon(p2hn);
    
                    break;
                    case "support":
                        p22f.setIcon(p2sn);
                        p22d.setIcon(p2sn);
                    break;
                    case "tank":
                        p22f.setIcon(p2tn);
                        p22d.setIcon(p2tn);
    
                    break;
                    default:
                }
            }
            
            if(m2.get(computer.chosen[2].Class).HP>0){
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23f.setIcon(p2an);
                        p23d.setIcon(p2an);
                    break;
                    case "assassin":
                        p23f.setIcon(p2asn);
                        p23d.setIcon(p2asn);
    
                    break;
    
                    case "healer":
                        p23f.setIcon(p2hn);
                        p23d.setIcon(p2hn);
    
                    break;
                    case "support":
                        p23f.setIcon(p2sn);
                        p23d.setIcon(p2sn);
    
                    break;
                    case "tank":
                        p23f.setIcon(p2tn);
                        p23d.setIcon(p2tn);
    
                    break;
                    default:
                }
            }
        }
    }
    public void freezep2()throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playFreeze();
        if(pvp){
            if(m2.get(p2.chosen[0].Class).HP>0){
            switch(p2.chosen[0].Class){
                case "assault":
                    p21f.setIcon(p2af);
                    p21d.setIcon(p2af);
                break;
                case "assassin":
                    p21f.setIcon(p2asf);
                    p21d.setIcon(p2asf);

                break;

                case "healer":
                    p21f.setIcon(p2hf);
                    p21d.setIcon(p2hf);

                break;
                case "support":
                    p21f.setIcon(p2sf);
                    p21d.setIcon(p2sf);

                break;
                case "tank":
                    p21f.setIcon(p2tf);
                    p21d.setIcon(p2tf);

                break;
                default:
            }
        }
        
        if(m2.get(p2.chosen[1].Class).HP>0){
            switch(p2.chosen[1].Class){
                case "assault":
                    p22f.setIcon(p2af);
                    p22d.setIcon(p2af);
                break;
                case "assassin":
                    p22f.setIcon(p2asf);
                    p22d.setIcon(p2asf);
                break;

                case "healer":
                    p22f.setIcon(p2hf);
                    p22d.setIcon(p2hf);
                break;
                case "support":
                    p22f.setIcon(p2sf);
                    p22d.setIcon(p2sf);
                break;
                case "tank":
                    p22f.setIcon(p2tf);
                    p22d.setIcon(p2tf);
                break;
                default:
            }
        }
        
        if(m2.get(p2.chosen[2].Class).HP>0){
            switch(p2.chosen[2].Class){
                case "assault":
                    p23f.setIcon(p2af);
                    p23d.setIcon(p2af);
                break;
                case "assassin":
                    p23f.setIcon(p2asf);
                    p23d.setIcon(p2asf);

                break;

                case "healer":
                    p23f.setIcon(p2hf);
                    p23d.setIcon(p2hf);

                break;
                case "support":
                    p23f.setIcon(p2sf);
                    p23d.setIcon(p2sf);

                break;
                case "tank":
                    p23f.setIcon(p2tf);
                    p23d.setIcon(p2tf);

                break;
                default:
            }
        }
        }
        else{
            if(m2.get(computer.chosen[0].Class).HP>0){
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21f.setIcon(p2af);
                        p21d.setIcon(p2af);
                    break;
                    case "assassin":
                        p21f.setIcon(p2asf);
                        p21d.setIcon(p2asf);
    
                    break;
    
                    case "healer":
                        p21f.setIcon(p2hf);
                        p21d.setIcon(p2hf);
    
                    break;
                    case "support":
                        p21f.setIcon(p2sf);
                        p21d.setIcon(p2sf);
    
                    break;
                    case "tank":
                        p21f.setIcon(p2tf);
                        p21d.setIcon(p2tf);
    
                    break;
                    default:
                }
            }
            
            if(m2.get(computer.chosen[1].Class).HP>0){
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22f.setIcon(p2af);
                        p22d.setIcon(p2af);
                    break;
                    case "assassin":
                        p22f.setIcon(p2asf);
                        p22d.setIcon(p2asf);
                    break;
    
                    case "healer":
                        p22f.setIcon(p2hf);
                        p22d.setIcon(p2hf);
                    break;
                    case "support":
                        p22f.setIcon(p2sf);
                        p22d.setIcon(p2sf);
                    break;
                    case "tank":
                        p22f.setIcon(p2tf);
                        p22d.setIcon(p2tf);
                    break;
                    default:
                }
            }
            
            if(m2.get(computer.chosen[2].Class).HP>0){
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23f.setIcon(p2af);
                        p23d.setIcon(p2af);
                    break;
                    case "assassin":
                        p23f.setIcon(p2asf);
                        p23d.setIcon(p2asf);
    
                    break;
    
                    case "healer":
                        p23f.setIcon(p2hf);
                        p23d.setIcon(p2hf);
    
                    break;
                    case "support":
                        p23f.setIcon(p2sf);
                        p23d.setIcon(p2sf);
    
                    break;
                    case "tank":
                        p23f.setIcon(p2tf);
                        p23d.setIcon(p2tf);
    
                    break;
                    default:
                }
            }
        }
        
    }

    public void p1heal(String h1)throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playHeal();
        p1reset();
        if(h1.equals(p1.chosen[0].Class)){
            p11f.setBounds(p11f.getX(), p11f.getY(), 120, 120);
            switch(p1.chosen[0].Class){
                case "assault":
                    p11f.setIcon(p1ah);
                break;
                case "assassin":
                    p11f.setIcon(p1ash);

                break;

                case "healer":
                    p11f.setIcon(p1hh);

                break;
                case "support":
                    p11f.setIcon(p1sh);

                break;
                case "tank":
                    p11f.setIcon(p1th);

                break;
                default:
            }
            
        }
        
        else if(h1.equals(p1.chosen[1].Class)){
            p12f.setBounds(p12f.getX(), p12f.getY(), 120, 120);
            switch(p1.chosen[1].Class){
                case "assault":
                    p12f.setIcon(p1ah);
                break;
                case "assassin":
                    p12f.setIcon(p1ash);

                break;

                case "healer":
                    p12f.setIcon(p1hh);

                break;
                case "support":
                    p12f.setIcon(p1sh);

                break;
                case "tank":
                    p12f.setIcon(p1th);

                break;
                default:
            }
            
        }
        else{
            p13f.setBounds(p13f.getX(), p13f.getY(), 120, 120);
            switch(p1.chosen[2].Class){

                case "assault":
                    p13f.setIcon(p1ah);
                break;
                case "assassin":
                    p13f.setIcon(p1ash);

                break;

                case "healer":
                    p13f.setIcon(p1hh);

                break;
                case "support":
                    p13f.setIcon(p1sh);

                break;
                case "tank":
                    p13f.setIcon(p1th);

                break;
                default:
            }
            
        }
    
    }

    public void p2heal(String h2)throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playHeal();
        p2reset();
        if(pvp){
            if(h2.equals(p2.chosen[0].Class)){
                p21f.setBounds(p21f.getX(), p21f.getY(), 120, 120);
                switch(p2.chosen[0].Class){
                    case "assault":
                        p21f.setIcon(p2ah);
                    break;
                    case "assassin":
                        p21f.setIcon(p2ash);

                    break;

                    case "healer":
                        p21f.setIcon(p2hh);

                    break;
                    case "support":
                        p21f.setIcon(p2sh);

                    break;
                    case "tank":
                        p21f.setIcon(p2th);

                    break;
                    default:
                }
            
            }
            
            else if(h2.equals(p2.chosen[1].Class)){
                p22f.setBounds(p22f.getX(), p22f.getY(), 120, 120);
                switch(p2.chosen[1].Class){
                    case "assault":
                        p22f.setIcon(p2ah);
                    break;
                    case "assassin":
                        p22f.setIcon(p2ash);

                    break;

                    case "healer":
                        p22f.setIcon(p2hh);

                    break;
                    case "support":
                        p22f.setIcon(p2sh);

                    break;
                    case "tank":
                        p22f.setIcon(p2th);

                    break;
                    default:
                }
                
            }
            else{
                p23f.setBounds(p23f.getX(), p23f.getY(), 120, 120);
                switch(p2.chosen[2].Class){
                    case "assault":
                        p23f.setIcon(p2ah);
                    break;
                    case "assassin":
                        p23f.setIcon(p2ash);

                    break;

                    case "healer":
                        p23f.setIcon(p2hh);

                    break;
                    case "support":
                        p23f.setIcon(p2sh);

                    break;
                    case "tank":
                        p23f.setIcon(p2th);

                    break;
                    default:
                }
                
            }
        }
        else{
            if(h2.equals(computer.chosen[0].Class)){
                p21f.setBounds(p21f.getX(), p21f.getY(), 120, 120);
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21f.setIcon(p2ah);
                    break;
                    case "assassin":
                        p21f.setIcon(p2ash);
    
                    break;
    
                    case "healer":
                        p21f.setIcon(p2hh);
    
                    break;
                    case "support":
                        p21f.setIcon(p2sh);
    
                    break;
                    case "tank":
                        p21f.setIcon(p2th);
    
                    break;
                    default:
                }
                
            }
            
            else if(h2.equals(computer.chosen[1].Class)){
                p22f.setBounds(p22f.getX(), p22f.getY(), 120, 120);
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22f.setIcon(p2ah);
                    break;
                    case "assassin":
                        p22f.setIcon(p2ash);
    
                    break;
    
                    case "healer":
                        p22f.setIcon(p2hh);
    
                    break;
                    case "support":
                        p22f.setIcon(p2sh);
    
                    break;
                    case "tank":
                        p22f.setIcon(p2th);
    
                    break;
                    default:
                }
                
            }
            else{
                p23f.setBounds(p23f.getX(), p23f.getY(), 120, 120);
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23f.setIcon(p2ah);
                    break;
                    case "assassin":
                        p23f.setIcon(p2ash);
    
                    break;
    
                    case "healer":
                        p23f.setIcon(p2hh);
    
                    break;
                    case "support":
                        p23f.setIcon(p2sh);
    
                    break;
                    case "tank":
                        p23f.setIcon(p2th);
    
                    break;
                    default:
                }
                
            }
        }
        
    }

    public void killp1(String A2, String D1)throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playDie();
        if(pvp){
            if(A2.equals(p2.chosen[0].Class)){
                p21d.setBounds(660,350,100,100);
                switch(p2.chosen[0].Class){
                    case "assault":
                        p21d.setIcon(p2aa);
                    break;
                    case "assassin":
                        p21d.setIcon(p2asa);

                    break;

                    case "healer":
                        p21d.setIcon(p2hi);

                    break;
                    case "support":
                        p21d.setIcon(p2sa);

                    break;
                    case "tank":
                        p21d.setIcon(p2ta);

                    break;
                    default:
                }
            }
            else if(A2.equals(p2.chosen[1].Class)){
                p22d.setBounds(660,350,100,100);
                switch(p2.chosen[1].Class){
                    case "assault":
                        p22d.setIcon(p2aa);
                    break;
                    case "assassin":
                        p22d.setIcon(p2asa);

                    break;

                    case "healer":
                        p22d.setIcon(p2hi);

                    break;
                    case "support":
                        p22d.setIcon(p2sa);

                    break;
                    case "tank":
                        p22d.setIcon(p2ta);

                    break;
                    default:
                }
                
            }
            else{
                p23d.setBounds(660,350,100,100);
                switch(p2.chosen[2].Class){
                    case "assault":
                        p23d.setIcon(p2aa);
                    break;
                    case "assassin":
                        p23d.setIcon(p2asa);

                    break;

                    case "healer":
                        p23d.setIcon(p2hi);

                    break;
                    case "support":
                        p23d.setIcon(p2sa);

                    break;
                    case "tank":
                        p23d.setIcon(p2ta);

                    break;
                    default:
                }
                
            }
        }
        else{
            if(A2.equals(computer.chosen[0].Class)){
                p21d.setBounds(660,350,100,100);
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21d.setIcon(p2aa);
                    break;
                    case "assassin":
                        p21d.setIcon(p2asa);
    
                    break;
    
                    case "healer":
                        p21d.setIcon(p2hi);
    
                    break;
                    case "support":
                        p21d.setIcon(p2sa);
    
                    break;
                    case "tank":
                        p21d.setIcon(p2ta);
    
                    break;
                    default:
                }
                
            }
            
            else if(A2.equals(computer.chosen[1].Class)){
                p22d.setBounds(660,350,100,100);
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22d.setIcon(p2aa);
                    break;
                    case "assassin":
                        p22d.setIcon(p2asa);
    
                    break;
    
                    case "healer":
                        p22d.setIcon(p2hi);
    
                    break;
                    case "support":
                        p22d.setIcon(p2sa);
    
                    break;
                    case "tank":
                        p22d.setIcon(p2ta);
    
                    break;
                    default:
                }
                
            }
            else{
                p23d.setBounds(660,350,100,100);
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23d.setIcon(p2aa);
                    break;
                    case "assassin":
                        p23d.setIcon(p2asa);
    
                    break;
    
                    case "healer":
                        p23d.setIcon(p2hi);
    
                    break;
                    case "support":
                        p23d.setIcon(p2sa);
    
                    break;
                    case "tank":
                        p23d.setIcon(p2ta);
    
                    break;
                    default:
                }
                
            }
        }        
        if (p1.chosen[0].Class.equals(D1)){
            p11d.setOpaque(false);
            switch(p1.chosen[0].Class){
                case "assault":
                    p11d.setIcon(p1ad);
                    p11f.setIcon(p1ad);
                    p11h.setIcon(p1ad);
                break;
                case "assassin":
                    p11d.setIcon(p1asd);
                    p11f.setIcon(p1asd);
                    p11h.setIcon(p1asd);

                break;

                case "healer":
                    p11d.setIcon(p1hd);
                    p11f.setIcon(p1hd);
                    p11h.setIcon(p1hd);

                break;
                case "support":
                    p11d.setIcon(p1sd);
                    p11f.setIcon(p1sd);
                    p11h.setIcon(p1sd);

                break;
                case "tank":
                    p11d.setIcon(p1td);
                    p11f.setIcon(p1td);
                    p11h.setIcon(p1td);

                break;
                default:
            }
        }
        else if(p1.chosen[1].Class.equals(D1)){
            p12d.setOpaque(false);
            switch(p1.chosen[1].Class){
                case "assault":
                    p12d.setIcon(p1ad);
                    p12f.setIcon(p1ad);
                    p12h.setIcon(p1ad);
                break;
                case "assassin":
                    p12d.setIcon(p1asd);
                    p12f.setIcon(p1asd);
                    p12h.setIcon(p1asd);

                break;

                case "healer":
                    p12d.setIcon(p1hd);
                    p12f.setIcon(p1hd);
                    p12h.setIcon(p1hd);

                break;
                case "support":
                    p12d.setIcon(p1sd);
                    p12f.setIcon(p1sd);
                    p12h.setIcon(p1sd);

                break;
                case "tank":
                    p12d.setIcon(p1td);
                    p12f.setIcon(p1td);
                    p12h.setIcon(p1td);

                break;
                default:
            }
        }
        else{
            p13d.setOpaque(false);
            switch(p1.chosen[2].Class){
                case "assault":
                    p13d.setIcon(p1ad);
                    p13f.setIcon(p1ad);
                    p13h.setIcon(p1ad);
                break;
                case "assassin":
                    p13d.setIcon(p1asd);
                    p13f.setIcon(p1asd);
                    p13h.setIcon(p1asd);
                break;
                case "healer":
                    p13d.setIcon(p1hd);
                    p13f.setIcon(p1hd);
                    p13h.setIcon(p1hd);

                break;
                case "support":
                    p13d.setIcon(p1sd);
                    p13f.setIcon(p1sd);
                    p13h.setIcon(p1sd);

                break;
                case "tank":
                    p13d.setIcon(p1td);
                    p13f.setIcon(p1td);
                    p13h.setIcon(p1td);

                break;
                default:
            }
        }
   
    }

    public void killp2(String A1, String D2)throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        playDie();
        if(A1.equals(p1.chosen[0].Class)){
            p11d.setBounds(850,350,100,100);
            switch(p1.chosen[0].Class){
                case "assault":
                    p11d.setIcon(p1aa);
                break;
                case "assassin":
                    p11d.setIcon(p1asa);

                break;

                case "healer":
                    p11d.setIcon(p1hi);

                break;
                case "support":
                    p11d.setIcon(p1sa);

                break;
                case "tank":
                    p11d.setIcon(p1ta);

                break;
                default:
            }
            
        }
        
        else if(A1.equals(p1.chosen[1].Class)){
            p12d.setBounds(850,350,100,100);
            switch(p1.chosen[1].Class){
                case "assault":
                    p12d.setIcon(p1aa);
                break;
                case "assassin":
                    p12d.setIcon(p1asa);

                break;

                case "healer":
                    p12d.setIcon(p1hi);

                break;
                case "support":
                    p12d.setIcon(p1sa);

                break;
                case "tank":
                    p12d.setIcon(p1ta);

                break;
                default:
            }
            
        }
        else{
            p13d.setBounds(850,350,100,100);
            switch(p1.chosen[2].Class){
                case "assault":
                    p13d.setIcon(p1aa);
                break;
                case "assassin":
                    p13d.setIcon(p1asa);

                break;

                case "healer":
                    p13d.setIcon(p1hi);

                break;
                case "support":
                    p13d.setIcon(p1sa);

                break;
                case "tank":
                    p13d.setIcon(p1ta);

                break;
                default:
            }
            
        }
        if (pvp){
            if (p2.chosen[0].Class.equals(D2)){
                p21d.setOpaque(false);
                switch(p2.chosen[0].Class){
                    case "assault":
                    
                        p21d.setIcon(p2ad);
                        p21f.setIcon(p2ad);
                        p21h.setIcon(p2ad);
                    break;
                    case "assassin":
                        p21d.setIcon(p2asd);
                        p21f.setIcon(p2asd);
                        p21h.setIcon(p2asd);

                    break;

                    case "healer":
                        p21d.setIcon(p2hd);
                        p21f.setIcon(p2hd);
                        p21h.setIcon(p2hd);

                    break;
                    case "support":
                        p21d.setIcon(p2sd);
                        p21f.setIcon(p2sd);
                        p21h.setIcon(p2sd);

                    break;
                    case "tank":
                        p21d.setIcon(p2td);
                        p21f.setIcon(p2td);
                        p21h.setIcon(p2td);

                    break;
                    default:
                }
            }
            else if(p2.chosen[1].Class.equals(D2)){
                p22d.setOpaque(false);
                switch(p2.chosen[1].Class){
                    case "assault":
                        p22d.setIcon(p2ad);
                        p22f.setIcon(p2ad);
                        p22h.setIcon(p2ad);
                    break;
                    case "assassin":
                        p22d.setIcon(p2asd);
                        p22f.setIcon(p2asd);
                        p22h.setIcon(p2asd);

                    break;

                    case "healer":
                        p22d.setIcon(p2hd);
                        p22f.setIcon(p2hd);
                        p22h.setIcon(p2hd);

                    break;
                    case "support":
                        p22d.setIcon(p2sd);
                        p22f.setIcon(p2sd);
                        p22h.setIcon(p2sd);

                    break;
                    case "tank":
                        p22d.setIcon(p2td);
                        p22f.setIcon(p2td);
                        p22h.setIcon(p2td);

                    break;
                    default:
                }
            }
            else{
                p23d.setOpaque(false);
                switch(p2.chosen[2].Class){
                    case "assault":
                        p23d.setIcon(p2ad);
                        p23f.setIcon(p2ad);
                        p23h.setIcon(p2ad);
                    break;
                    case "assassin":
                        p23d.setIcon(p2asd);
                        p23f.setIcon(p2asd);
                        p23h.setIcon(p2asd);
                    break;
                    case "healer":
                        p23d.setIcon(p2hd);
                        p23f.setIcon(p2hd);
                        p23h.setIcon(p2hd);

                    break;
                    case "support":
                        p23d.setIcon(p2sd);
                        p23f.setIcon(p2sd);
                        p23h.setIcon(p2sd);

                    break;
                    case "tank":
                        p23d.setIcon(p2td);
                        p23f.setIcon(p2td);
                        p23h.setIcon(p2td);

                    break;
                    default:
                }
            }
        }
        else{
            if (computer.chosen[0].Class.equals(D2)){
                p21d.setOpaque(false);
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21d.setIcon(p2ad);
                        p21f.setIcon(p2ad);
                        p21h.setIcon(p2ad);
                    break;
                    case "assassin":
                        p21d.setIcon(p2asd);
                        p21f.setIcon(p2asd);
                        p21h.setIcon(p2asd);
    
                    break;
    
                    case "healer":
                        p21d.setIcon(p2hd);
                        p21f.setIcon(p2hd);
                        p21h.setIcon(p2hd);
    
                    break;
                    case "support":
                        p21d.setIcon(p2sd);
                        p21f.setIcon(p2sd);
                        p21h.setIcon(p2sd);
    
                    break;
                    case "tank":
                        p21d.setIcon(p2td);
                        p21f.setIcon(p2td);
                        p21h.setIcon(p2td);
    
                    break;
                    default:
                }
            }
            else if(computer.chosen[1].Class.equals(D2)){
                p22d.setOpaque(false);
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22d.setIcon(p2ad);
                        p22f.setIcon(p2ad);
                        p22h.setIcon(p2ad);
                    break;
                    case "assassin":
                        p22d.setIcon(p2asd);
                        p22f.setIcon(p2asd);
                        p22h.setIcon(p2asd);
    
                    break;
    
                    case "healer":
                        p22d.setIcon(p2hd);
                        p22f.setIcon(p2hd);
                        p22h.setIcon(p2hd);
    
                    break;
                    case "support":
                        p22d.setIcon(p2sd);
                        p22f.setIcon(p2sd);
                        p22h.setIcon(p2sd);
    
                    break;
                    case "tank":
                        p22d.setIcon(p2td);
                        p22f.setIcon(p2td);
                        p22h.setIcon(p2td);
    
                    break;
                    default:
                }
            }
            else{
                p23d.setOpaque(false);
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23d.setIcon(p2ad);
                        p23f.setIcon(p2ad);
                        p23h.setIcon(p2ad);
                    break;
                    case "assassin":
                        p23d.setIcon(p2asd);
                        p23f.setIcon(p2asd);
                        p23h.setIcon(p2asd);
                    break;
                    case "healer":
                        p23d.setIcon(p2hd);
                        p23f.setIcon(p2hd);
                        p23h.setIcon(p2hd);
    
                    break;
                    case "support":
                        p23d.setIcon(p2sd);
                        p23f.setIcon(p2sd);
                        p23h.setIcon(p2sd);
    
                    break;
                    case "tank":
                        p23d.setIcon(p2td);
                        p23f.setIcon(p2td);
                        p23h.setIcon(p2td);
    
                    break;
                    default:
                }
            }
        }   
        
    }


    public  void p1hit(String A1)throws UnsupportedAudioFileException,IOException,LineUnavailableException{  
        playHit();
        if(A1.equals(p1.chosen[0].Class)){
            p11f.setBounds(850,350,100,100);
            switch(p1.chosen[0].Class){
                case "assault":
                    p11f.setIcon(p1aa);
                break;
                case "assassin":
                    p11f.setIcon(p1asa);

                break;

                case "healer":
                    p11f.setIcon(p1hi);

                break;
                case "support":
                    p11f.setIcon(p1sa);

                break;
                case "tank":
                    p11f.setIcon(p1ta);

                break;
                default:
            }
            
        }
        
        else if(A1.equals(p1.chosen[1].Class)){
            p12f.setBounds(850,350,100,100);
            switch(p1.chosen[1].Class){
                case "assault":
                    p12f.setIcon(p1aa);
                break;
                case "assassin":
                    p12f.setIcon(p1asa);

                break;

                case "healer":
                    p12f.setIcon(p1hi);

                break;
                case "support":
                    p12f.setIcon(p1sa);

                break;
                case "tank":
                    p12f.setIcon(p1ta);

                break;
                default:
            }
            
        }
        else{
            p13f.setBounds(850,350,100,100);
            switch(p1.chosen[2].Class){
                case "assault":
                    p13f.setIcon(p1aa);
                break;
                case "assassin":
                    p13f.setIcon(p1asa);

                break;

                case "healer":
                    p13f.setIcon(p1hi);

                break;
                case "support":
                    p13f.setIcon(p1sa);

                break;
                case "tank":
                    p13f.setIcon(p1ta);

                break;
                default:
            }
            
        }
    }

    public  void p2hit(String A2)throws UnsupportedAudioFileException,IOException,LineUnavailableException{  
        playHit();
        if(pvp){
            if(A2.equals(p2.chosen[0].Class)){
            p21f.setBounds(660,350,100,100);
            switch(p2.chosen[0].Class){
                case "assault":
                    p21f.setIcon(p2aa);
                break;
                case "assassin":
                    p21f.setIcon(p2asa);

                break;

                case "healer":
                    p21f.setIcon(p2hi);

                break;
                case "support":
                    p21f.setIcon(p2sa);

                break;
                case "tank":
                    p21f.setIcon(p2ta);

                break;
                default:
            }
            
        }
        
        else if(A2.equals(p2.chosen[1].Class)){
            p22f.setBounds(660,350,100,100);
            switch(p2.chosen[1].Class){
                case "assault":
                    p22f.setIcon(p2aa);
                break;
                case "assassin":
                    p22f.setIcon(p2asa);

                break;

                case "healer":
                    p22f.setIcon(p2hi);

                break;
                case "support":
                    p22f.setIcon(p2sa);

                break;
                case "tank":
                    p22f.setIcon(p2ta);

                break;
                default:
            }
            
        }
        else{
            p23f.setBounds(660,350,100,100);
            switch(p2.chosen[2].Class){
                case "assault":
                    p23f.setIcon(p2aa);
                break;
                case "assassin":
                    p23f.setIcon(p2asa);

                break;

                case "healer":
                    p23f.setIcon(p2hi);

                break;
                case "support":
                    p23f.setIcon(p2sa);

                break;
                case "tank":
                    p23f.setIcon(p2ta);

                break;
                default:
            }
            
        }
        }
        else{
            if(A2.equals(computer.chosen[0].Class)){
                p21f.setBounds(660,350,100,100);
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21f.setIcon(p2aa);
                    break;
                    case "assassin":
                        p21f.setIcon(p2asa);
    
                    break;
    
                    case "healer":
                        p21f.setIcon(p2hi);
    
                    break;
                    case "support":
                        p21f.setIcon(p2sa);
    
                    break;
                    case "tank":
                        p21f.setIcon(p2ta);
    
                    break;
                    default:
                }
                
            }
            
            else if(A2.equals(computer.chosen[1].Class)){
                p22f.setBounds(660,350,100,100);
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22f.setIcon(p2aa);
                    break;
                    case "assassin":
                        p22f.setIcon(p2asa);
    
                    break;
    
                    case "healer":
                        p22f.setIcon(p2hi);
    
                    break;
                    case "support":
                        p22f.setIcon(p2sa);
    
                    break;
                    case "tank":
                        p22f.setIcon(p2ta);
    
                    break;
                    default:
                }
                
            }
            else{
                p23f.setBounds(660,350,100,100);
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23f.setIcon(p2aa);
                    break;
                    case "assassin":
                        p23f.setIcon(p2asa);
    
                    break;
    
                    case "healer":
                        p23f.setIcon(p2hi);
    
                    break;
                    case "support":
                        p23f.setIcon(p2sa);
    
                    break;
                    case "tank":
                        p23f.setIcon(p2ta);
    
                    break;
                    default:
                }
                
            }
        }
        
    }

    public  void p1reset(){
        p11f.setBackground(null);
        p12f.setBackground(null);
        p13f.setBackground(null); 
        p11f.setBounds(p11h.getX(),p11h.getY(),100,100);
        p12f.setBounds(p12h.getX(),p12h.getY(),100,100);
        p13f.setBounds(p13h.getX(),p13h.getY(),100,100);
            if(m1.get(p1.chosen[0].Class).HP>0){
                switch(p1.chosen[0].Class){
                    case "assault":
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11f.setIcon(p1ab);
                            p11h.setIcon(p1ab);
                        }
                        else{
                            p11f.setIcon(p1ai);
                            p11h.setIcon(p1ai);
                        }
                    break;
                    case "assassin":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11f.setIcon(p1asb);
                            p11h.setIcon(p1asb);
                        }
                        else{
                            p11f.setIcon(p1asi);
                        p11h.setIcon(p1asi);
                        }

                    break;

                    case "healer":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11f.setIcon(p1hb);
                            p11h.setIcon(p1hb);
                        }
                        else{
                            p11f.setIcon(p1hi);
                        p11h.setIcon(p1hi);
                        }

                    break;
                    case "support":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11f.setIcon(p1sb);
                            p11h.setIcon(p1sb);
                        }
                        else{
                            p11f.setIcon(p1si);
                        p11h.setIcon(p1si);
                        }

                    break;
                    case "tank":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11f.setIcon(p1tb);
                            p11h.setIcon(p1tb);
                        }
                        else{
                            p11f.setIcon(p1ti);
                        p11h.setIcon(p1ti);
                        }

                    break;
                    default:
                } 
        }
            if(m1.get(p1.chosen[1].Class).HP>0){
                switch(p1.chosen[1].Class){
                    case "assault":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12f.setIcon(p1ab);
                            p12h.setIcon(p1ab);
                        }
                        else{
                            p12f.setIcon(p1ai);
                        p12h.setIcon(p1ai);
                        }
                    break;
                    case "assassin":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12f.setIcon(p1asb);
                            p12h.setIcon(p1asb);
                        }
                        else{
                            p12f.setIcon(p1asi);
                        p12h.setIcon(p1asi);
                        }

                    break;

                    case "healer":
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12f.setIcon(p1hb);
                            p12h.setIcon(p1hb);
                        }
                        else{
                            p12f.setIcon(p1hi);
                            p12h.setIcon(p1hi);
                        }

                    break;
                    case "support":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12f.setIcon(p1sb);
                            p12h.setIcon(p1sb);
                        }
                        else{
                            p12f.setIcon(p1si);
                            p12h.setIcon(p1si);
                        }

                    break;
                    case "tank":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12f.setIcon(p1tb);
                            p12h.setIcon(p1tb);
                        }
                        else{
                            p12f.setIcon(p1ti);
                        p12h.setIcon(p1ti);
                        }

                    break;
                    default:
                }
            }
            if(m1.get(p1.chosen[2].Class).HP>0){
                switch(p1.chosen[2].Class){
                    case "assault":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13f.setIcon(p1ab);
                            p13h.setIcon(p1ab);
                        }
                        else{
                            p13f.setIcon(p1ai);
                        p13h.setIcon(p1ai);
                        }
                    break;
                    case "assassin":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13f.setIcon(p1asb);
                            p13h.setIcon(p1asb);
                        }
                        else{
                            p13f.setIcon(p1asi);
                        p13h.setIcon(p1asi);
                        }

                    break;

                    case "healer":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13f.setIcon(p1hb);
                            p13h.setIcon(p1hb);
                        }
                        else{
                            p13f.setIcon(p1hi);
                        p13h.setIcon(p1hi);
                        }


                    break;
                    case "support":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13f.setIcon(p1sb);
                            p13h.setIcon(p1sb);
                        }
                        else{
                            p13f.setIcon(p1si);
                        p13h.setIcon(p1si);
                        }

                    break;
                    case "tank":
                        
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13f.setIcon(p1tb);
                            p13h.setIcon(p1tb);
                        }
                        else{
                            p13f.setIcon(p1ti);
                        p13h.setIcon(p1ti);
                        }

                    break;
                    default:
                }
            }
    }

    public  void p2reset(){
        p21f.setBackground(null);
        p22f.setBackground(null);
        p23f.setBackground(null); 
        p21f.setBounds(p21h.getX(),p21h.getY(),100,100);
        p22f.setBounds(p22h.getX(),p22h.getY(),100,100);
        p23f.setBounds(p23h.getX(),p23h.getY(),100,100);
        if(pvp){
            if(m2.get(p2.chosen[0].Class).HP>0){
                switch(p2.chosen[0].Class){
                    case "assault":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21f.setIcon(p2ab);
                            p21h.setIcon(p2ab);
                        }
                        else{
                            p21f.setIcon(p2ai);
                        p21h.setIcon(p2ai);
                        }
                    break;
                    case "assassin":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21f.setIcon(p2asb);
                            p21h.setIcon(p2asb);
                        }
                        else{
                            p21f.setIcon(p2asi);
                        p21h.setIcon(p2asi);
                        }

                    break;

                    case "healer":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21f.setIcon(p2hb);
                            p21h.setIcon(p2hb);
                        }
                        else{
                            p21f.setIcon(p2hi);
                        p21h.setIcon(p2hi);
                        }

                    break;
                    case "support":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21f.setIcon(p2sb);
                            p21h.setIcon(p2sb);
                        }
                        else{
                            p21f.setIcon(p2si);
                        p21h.setIcon(p2si);
                        }

                    break;
                    case "tank":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21f.setIcon(p2tb);
                            p21h.setIcon(p2tb);
                        }
                        else{
                            p21f.setIcon(p2ti);
                        p21h.setIcon(p2ti);
                        }

                    break;
                    default:
                }
            }  
            if(m2.get(p2.chosen[1].Class).HP>0){
                switch(p2.chosen[1].Class){
                    case "assault":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22f.setIcon(p2ab);
                            p22h.setIcon(p2ab);
                        }
                        else{
                            p22f.setIcon(p2ai);
                        p22h.setIcon(p2ai);
                        }
                    break;
                    case "assassin":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22f.setIcon(p2asb);
                            p22h.setIcon(p2asb);
                        }
                        else{
                            p22f.setIcon(p2asi);
                        p22h.setIcon(p2asi);
                        }
                    break;

                    case "healer":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22f.setIcon(p2hb);
                            p22h.setIcon(p2hb);
                        }
                        else{
                            p22f.setIcon(p2hi);
                        p22h.setIcon(p2hi);
                        }

                    break;
                    case "support":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22f.setIcon(p2sb);
                            p22h.setIcon(p2sb);
                        }
                        else{
                            p22f.setIcon(p2si);
                        p22h.setIcon(p2si);
                        }

                    break;
                    case "tank":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22f.setIcon(p2tb);
                            p22h.setIcon(p2tb);
                        }
                        else{
                            p22f.setIcon(p2ti);
                        p22h.setIcon(p2ti);
                        }

                    break;
                    default:
                }
            }
                
            if(m2.get(p2.chosen[2].Class).HP>0){
                switch(p2.chosen[2].Class){
                    case "assault":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23f.setIcon(p2ab);
                            p23h.setIcon(p2ab);
                        }
                        else{
                            p23f.setIcon(p2ai);
                        p23h.setIcon(p2ai);
                        }
                    break;
                    case "assassin":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23f.setIcon(p2asb);
                            p23h.setIcon(p2asb);
                        }
                        else{
                            p23f.setIcon(p2asi);
                        p23h.setIcon(p2asi);
                        }

                    break;

                    case "healer":
                       
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23f.setIcon(p2hb);
                            p23h.setIcon(p2hb);
                        }
                        else{
                             p23f.setIcon(p2hi);
                        p23h.setIcon(p2hi);
                        }
                    break;
                    case "support":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23f.setIcon(p2sb);
                            p23h.setIcon(p2sb);
                        }
                        else{
                            p23f.setIcon(p2si);
                        p23h.setIcon(p2si);
                        }

                    break;
                    case "tank":
                        
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23f.setIcon(p2tb);
                            p23h.setIcon(p2tb);
                        }
                        else{
                            p23f.setIcon(p2ti);
                        p23h.setIcon(p2ti);
                        }

                    break;
                    default:
                }
            }
        }
        else{
            if(m2.get(computer.chosen[0].Class).HP>0){
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21f.setIcon(p2ai);
                        p21h.setIcon(p2ai);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21f.setIcon(p2ab);
                            p21h.setIcon(p2ab);
                        }
                        
                    break;
                    case "assassin":
                        p21f.setIcon(p2asi);
                        p21h.setIcon(p2asi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21f.setIcon(p2asb);
                            p21h.setIcon(p2asb);
                        }

                    break;

                    case "healer":
                        p21f.setIcon(p2hi);
                        p21h.setIcon(p2hi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21f.setIcon(p2hb);
                            p21h.setIcon(p2hb);
                        }

                    break;
                    case "support":
                        p21f.setIcon(p2si);
                        p21h.setIcon(p2si);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21f.setIcon(p2sb);
                            p21h.setIcon(p2sb);
                        }

                    break;
                    case "tank":
                        p21f.setIcon(p2ti);
                        p21h.setIcon(p2ti);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21f.setIcon(p2tb);
                            p21h.setIcon(p2tb);
                        }

                    break;
                    default:
                }
            }  
            if(m2.get(computer.chosen[1].Class).HP>0){
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22f.setIcon(p2ai);
                        p22h.setIcon(p2ai);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22f.setIcon(p2ab);
                            p22h.setIcon(p2ab);
                        }
                    break;
                    case "assassin":
                        p22f.setIcon(p2asi);
                        p22h.setIcon(p2asi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22f.setIcon(p2asb);
                            p22h.setIcon(p2asb);
                        }
                    break;

                    case "healer":
                        p22f.setIcon(p2hi);
                        p22h.setIcon(p2hi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22f.setIcon(p2hb);
                            p22h.setIcon(p2hb);
                        }

                    break;
                    case "support":
                        p22f.setIcon(p2si);
                        p22h.setIcon(p2si);
                        if(computer.FindSupport() && computer.support.up>0){
                            p22f.setIcon(p2sb);
                            p22h.setIcon(p2sb);
                        }

                    break;
                    case "tank":
                        p22f.setIcon(p2ti);
                        p22h.setIcon(p2ti);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22h.setIcon(p2tb);
                            p22f.setIcon(p2tb);
                        }


                    break;
                    default:
                }
            }
                
            if(m2.get(computer.chosen[2].Class).HP>0){
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23f.setIcon(p2ai);
                        p23h.setIcon(p2ai);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23h.setIcon(p2ab);
                            p23f.setIcon(p2ab);
                        }

                    break;
                    case "assassin":
                        p23f.setIcon(p2asi);
                        p23h.setIcon(p2asi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23h.setIcon(p2asb);
                            p23f.setIcon(p2asb);
                        }

                    break;

                    case "healer":
                        p23f.setIcon(p2hi);
                        p23h.setIcon(p2hi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23h.setIcon(p2hb);
                            p23f.setIcon(p2hb);
                        }

                    break;
                    case "support":
                        p23f.setIcon(p2si);
                        p23h.setIcon(p2si);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23h.setIcon(p2sb);
                            p23f.setIcon(p2sb);
                        }
                    break;
                    case "tank":
                        p23f.setIcon(p2ti);
                        p23h.setIcon(p2ti);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23h.setIcon(p2tb);
                            p23f.setIcon(p2tb);
                        }

                    break;
                    default:
                }
            }
        }
            

    }

    public  void p1resetd(){
        p11d.setBackground(null);
        p12d.setBackground(null);
        p13d.setBackground(null); 
        p11d.setBounds(p11h.getX(),p11h.getY(),100,100);
        p12d.setBounds(p12h.getX(),p12h.getY(),100,100);
        p13d.setBounds(p13h.getX(),p13h.getY(),100,100);
            if(m1.get(p1.chosen[0].Class).HP>0){
                switch(p1.chosen[0].Class){
                    case "assault":
                        p11d.setIcon(p1ai);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11d.setIcon(p1ab);
                        
                        }
                    break;
                    case "assassin":
                        p11d.setIcon(p1asi);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11d.setIcon(p1asb);
                        
                        }

                    break;

                    case "healer":
                        p11d.setIcon(p1hi);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11d.setIcon(p1hb);
                        
                        }

                    break;
                    case "support":
                        p11d.setIcon(p1si);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11d.setIcon(p1sb);
                        
                        }

                    break;
                    case "tank":
                        p11d.setIcon(p1ti);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p11d.setIcon(p1tb);
                        
                        }

                    break;
                    default:
                } 
        }
            if(m1.get(p1.chosen[1].Class).HP>0){
                switch(p1.chosen[1].Class){
                    case "assault":
                        p12d.setIcon(p1ai);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12d.setIcon(p1ab);
                        
                        }
                    break;
                    case "assassin":
                        p12d.setIcon(p1asi);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12d.setIcon(p1asb);
                        
                        }

                    break;

                    case "healer":
                        p12d.setIcon(p1hi);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12d.setIcon(p1hb);
                        
                        }


                    break;
                    case "support":
                        p12d.setIcon(p1si);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12d.setIcon(p1sb);
                        
                        }

                    break;
                    case "tank":
                        p12d.setIcon(p1ti);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p12d.setIcon(p1tb);
                        
                        }

                    break;
                    default:
                }
            }
            if(m1.get(p1.chosen[2].Class).HP>0){
                switch(p1.chosen[2].Class){
                    case "assault":
                        p13d.setIcon(p1ai);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13d.setIcon(p1ab);
                        
                        }
                    break;
                    case "assassin":
                        p13d.setIcon(p1asi);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13d.setIcon(p1asb);
                        
                        }

                    break;

                    case "healer":
                        p13d.setIcon(p1hi);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13d.setIcon(p1hb);
                        
                        }

                    break;
                    case "support":
                        p13d.setIcon(p1si);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13d.setIcon(p1sb);
                        
                        }

                    break;
                    case "tank":
                        p13d.setIcon(p1ti);
                        if(p1.FindSupport()&&p1.support.up>0){
                            p13d.setIcon(p1tb);
                        
                        }

                    break;
                    default:
                }
            }
    }

    public  void p2resetd(){
        p21d.setBackground(null);
        p22d.setBackground(null);
        p23d.setBackground(null); 
        p21d.setBounds(p21h.getX(),p21h.getY(),100,100);
        p22d.setBounds(p22h.getX(),p22h.getY(),100,100);
        p23d.setBounds(p23h.getX(),p23h.getY(),100,100);
        if(pvp){
                if(m2.get(p2.chosen[0].Class).HP>0){
                switch(p2.chosen[0].Class){
                    case "assault":
                        p21d.setIcon(p2ai);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21d.setIcon(p2ab);
                        
                        }
                    break;
                    case "assassin":
                        p21d.setIcon(p2asi);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21d.setIcon(p2asb);
                        
                        }

                    break;

                    case "healer":
                        p21d.setIcon(p2hi);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21d.setIcon(p2hb);
                        
                        }

                    break;
                    case "support":
                        p21d.setIcon(p2si);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21d.setIcon(p2sb);
                        
                        }

                    break;
                    case "tank":
                        p21d.setIcon(p2ti);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p21d.setIcon(p2tb);
                        
                        }

                    break;
                    default:
                }
            }  
            if(m2.get(p2.chosen[1].Class).HP>0){
                switch(p2.chosen[1].Class){
                    case "assault":
                        p22d.setIcon(p2ai);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22d.setIcon(p2ab);
                        
                        }
                    break;
                    case "assassin":
                        p22d.setIcon(p2asi);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22d.setIcon(p2asb);
                        
                        }

                    break;

                    case "healer":
                        p22d.setIcon(p2hi);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22d.setIcon(p2hb);
                        
                        }

                    break;
                    case "support":
                        p22d.setIcon(p2si);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22d.setIcon(p2sb);
                        
                        }

                    break;
                    case "tank":
                        p22d.setIcon(p2ti);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p22d.setIcon(p2tb);
                        
                        }

                    break;
                    default:
                }
            }
                
            if(m2.get(p2.chosen[2].Class).HP>0){
                switch(p2.chosen[2].Class){
                    case "assault":
                        p23d.setIcon(p2ai);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23d.setIcon(p2ab);
                        
                        }
                    break;
                    case "assassin":
                        p23d.setIcon(p2asi);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23d.setIcon(p2asb);
                        
                        }

                    break;

                    case "healer":
                        p23d.setIcon(p2hi);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23d.setIcon(p2hb);
                        
                        }

                    break;
                    case "support":
                        p23d.setIcon(p2si);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23d.setIcon(p2sb);
                        
                        }

                    break;
                    case "tank":
                        p23d.setIcon(p2ti);
                        if(p2.FindSupport()&&p2.support.up>0){
                            p23d.setIcon(p2tb);
                        
                        }
                    break;
                    default:
                }
            }
        }
        else{
            if(m2.get(computer.chosen[0].Class).HP>0){
                switch(computer.chosen[0].Class){
                    case "assault":
                        p21d.setIcon(p2ai);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21d.setIcon(p2ab);
                        
                        }
                    break;
                    case "assassin":
                        p21d.setIcon(p2asi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21d.setIcon(p2asb);
                        }

                    break;

                    case "healer":
                        p21d.setIcon(p2hi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21d.setIcon(p2hb);
                        
                        }                        
                    break;
                    case "support":
                        p21d.setIcon(p2si);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21d.setIcon(p2sb);
                        
                        }

                    break;
                    case "tank":
                        p21d.setIcon(p2ti);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p21d.setIcon(p2tb);
                        
                        }
                    break;
                    default:
                }
            }  
            if(m2.get(computer.chosen[1].Class).HP>0){
                switch(computer.chosen[1].Class){
                    case "assault":
                        p22d.setIcon(p2ai);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22d.setIcon(p2ab);
                        
                        }
                    break;
                    case "assassin":
                        p22d.setIcon(p2asi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22d.setIcon(p2asb);
                        
                        }
                        

                    break;

                    case "healer":
                        p22d.setIcon(p2hi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22d.setIcon(p2hb);
                        
                        }

                    break;
                    case "support":
                        p22d.setIcon(p2si);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22d.setIcon(p2sb);
                        
                        }

                    break;
                    case "tank":
                        p22d.setIcon(p2ti);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p22d.setIcon(p2tb);
                        
                        }
                    break;
                    default:
                }
            }
                
            if(m2.get(computer.chosen[2].Class).HP>0){
                switch(computer.chosen[2].Class){
                    case "assault":
                        p23d.setIcon(p2ai);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23d.setIcon(p2ab);
                        
                        }
                    break;
                    case "assassin":
                        p23d.setIcon(p2asi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23d.setIcon(p2asb);
                        
                        }
                    break;
                    case "healer":
                        p23d.setIcon(p2hi);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23d.setIcon(p2hb);
                        
                        }
                    break;
                    case "support":
                        p23d.setIcon(p2si);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23d.setIcon(p2sb);
                        
                        }
                    break;
                    case "tank":
                        p23d.setIcon(p2ti);
                        if(computer.FindSupport()&&computer.support.up>0){
                            p23d.setIcon(p2tb);
                        
                        }
                    break;
                    default:
                }
            }
        }
            

    }
    public class Timerr{
        private Timer timer;
        public Timerr(){
            timer = new Timer();
            start();
        }
     
        public void start(){
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    try{
                        ComputerTurn();
                    } 
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    }  
                }
            }, 2000);
        }
     
        public void reset(){
            timer.cancel();
            //timer.purge();
            //start();
        }
    
    }

    public gui4()throws IOException,UnsupportedAudioFileException,LineUnavailableException{
        playSound();
        //System.out.println();
        this.setSize(1600, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon("sample cover.jpg");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(100, 60, 140));

        timer1 = new Timerr();
        timer2 = new Timerr();
        timer3 = new Timerr();
        timer4 = new Timerr();
        timer5 = new Timerr();
        timer6 = new Timerr();
        timer7 = new Timerr();
        timer8 = new Timerr();
        task = new TimerTask(){
            @Override
            public void run(){
                try{
                    ComputerTurn();
                }
                catch(IOException ex){
                    ex.getStackTrace();
                }
                catch(UnsupportedAudioFileException g){
                    g.getStackTrace();
                }
                catch(LineUnavailableException f){
                    f.getStackTrace();
                }  
            }
        };
        

        
        startPane = new JLayeredPane();
        startpic = new JLabel(sIcon);
        startLabel = new JLabel("Contest of Heroes");
        startButton = new JButton();

        panel1 = new JPanel();
        panel1Label = new JLabel();
        
        b1 = new JButton();
        b2 = new JButton();
        Back0 = new JButton();

        pane2 = new JLayeredPane();
        panel2 = new JPanel();
        panel2Label = new JLabel();
        b3 = new JButton();
        b4 = new JButton();
        Back1 = new JButton();

        pane21 = new JLayeredPane();
        panel3Label = new JLabel();
        panel3Textbox = new TextField();
        NextB1 = new JButton();

        pane3 = new JLayeredPane();
        getImages();

        pvpPanel3 = new JPanel();
        pvpPanel3Label = new JLabel();
        NextB2 = new JButton();
        Undo = new JButton();
        Undo2 = new JButton();
        Back2 = new JButton();
        Ab = new JButton();
        ab = new JButton();
        hb = new JButton();
        sb = new JButton();
        tb = new JButton();

        c1 = new JLabel();
        c2 = new JLabel();
        c3 = new JLabel();
        c4 = new JLabel();
        c5 = new JLabel();	
        
        charda1 = new JLabel();
        charda2 = new JLabel();
        charda3 = new JLabel();

	    chardb1 = new JLabel();
        chardb2 = new JLabel();
        chardb3 = new JLabel();

	    charfa1 = new JLabel();
        charfa2 = new JLabel();
        charfa3 = new JLabel();

	    charfb1 = new JLabel();
        charfb2 = new JLabel();
        charfb3 = new JLabel();

	    charha1 = new JLabel();
        charha2 = new JLabel();
        charha3 = new JLabel();

	    charhb1 = new JLabel();
        charhb2 = new JLabel();
        charhb3 = new JLabel();



        Player1 = new JLabel();
	    Player11 = new JLabel();
        Player12 = new JLabel();
        Player13 = new JLabel();

        Player2 = new JLabel();
	    Player21 = new JLabel();
        Player22 = new JLabel();
        Player23 = new JLabel();

        aI = new JLabel(p1ai);
        asI = new JLabel(p1asi);
        hI = new JLabel(p1hi);
        sI = new JLabel(p1si);
        tI = new JLabel(p1ti);

        p11h = new JLabel();
        p12h = new JLabel();
        p13h = new JLabel();
        p21h = new JLabel();
        p22h = new JLabel();
        p23h = new JLabel();

        p11f = new JLabel();
        p12f = new JLabel();
        p13f = new JLabel();
        p21f = new JLabel();
        p22f = new JLabel();
        p23f = new JLabel();

        p11d = new JLabel();
        p12d = new JLabel();
        p13d = new JLabel();
        p21d = new JLabel();
        p22d = new JLabel();
        p23d = new JLabel();



        defendPanel = new JPanel();
        defendPanelLabel = new JLabel();
        p1d1 = new JButton();
        p1d2 = new JButton();
        p1d3 = new JButton();
        p2d1 = new JButton();
        p2d2 = new JButton();
        p2d3 = new JButton();

        p1life1l = new JLabel();
        p1life2l = new JLabel();
        p1life3l = new JLabel();

	    p2life1l = new JLabel();
        p2life2l = new JLabel();
        p2life3l = new JLabel();

        fightPanel = new JPanel();
        fightPanelLabel = new JLabel();
        JLabel bg3 = new JLabel();
        JLabel bgop = new JLabel();
        JLabel bgh = new JLabel();
        JLabel bgs = new JLabel();
        JLabel bgd = new JLabel();
        JLabel bgc = new JLabel();
        JLabel bgm2 = new JLabel();
        JLabel bgm3 =new JLabel(sky);
        JLabel bgm = new JLabel();
        JLabel bgw = new JLabel();

        bgop.setSize(1600,800);
        bgop.setLayout(null);
        //bgop.setBackground(new Color(100, 60, 140));
        bgop.setVisible(true);
        bgop.setOpaque(true);

        bgop.setIcon(sky);

        bgh.setSize(1600,800);
        bgh.setLayout(null);
        //bgh.setBackground(new Color(100, 60, 140));
        bgh.setVisible(true);
        bgh.setOpaque(true);

        bgh.setIcon(bg3Icon);

        bgs.setSize(1600,800);
        bgs.setLayout(null);
        //bgs.setBackground(new Color(100, 60, 140));
        bgs.setVisible(true);
        bgs.setOpaque(true);

        bgs.setIcon(sky);

        bgd.setSize(1600,800);
        bgd.setLayout(null);
        //bgd.setBackground(new Color(100, 60, 140));
        bgd.setVisible(true);
        bgd.setOpaque(true);

        bgd.setIcon(bg3Icon);

        bgc.setSize(1600,800);
        bgc.setLayout(null);
        //bgc.setBackground(new Color(100, 60, 140));
        bgc.setVisible(true);
        bgc.setOpaque(true);

        bgc.setIcon(sky);
        bgm.setSize(1600,800);
        bgm.setLayout(null);
        //bgm.setBackground(new Color(100, 60, 140));
        bgm.setVisible(true);
        bgm.setOpaque(true);

        bgm.setIcon(sky);

        bgm2.setSize(1600,800);
        bgm2.setLayout(null);
        //bgm2.setBackground(new Color(100, 60, 140));
        bgm2.setVisible(true);
        bgm2.setOpaque(true);

        bgm2.setIcon(sky);

        bgm3.setSize(1600,800);
        bgm2.setLayout(null);
        //bgm2.setBackground(new Color(100, 60, 140));
        bgm3.setVisible(true);
        bgm3.setOpaque(true);

        bgm3.setIcon(sky);

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

        freeze1 = new JLabel();
        freeze2 = new JLabel();

    JLabel bleed1 = new JLabel();
    JLabel bleed2 = new JLabel();

        JPanel p1p1 = new JPanel();
JLabel p1s1 = new JLabel();
JLabel p1attack1 = new JLabel("Attack Strength: ");
JLabel p1e1 = new JLabel("Energy: ");
JLabel p1spec1 = new JLabel();
JButton p1b1 = new JButton();


JPanel p1p2 = new JPanel();
JLabel p1s2 = new JLabel();
JLabel p1attack2 = new JLabel("Attack Strength: ");
JLabel p1e2 = new JLabel("Energy: ");
JLabel p1spec2 = new JLabel();
JButton p1b2 = new JButton();


JPanel p1p3 = new JPanel();
JLabel p1s3 = new JLabel();
JLabel p1attack3 = new JLabel("Attack Strength: ");
JLabel p1e3 = new JLabel("Energy: ");
JLabel p1spec3 = new JLabel();
JButton p1b3 = new JButton();


JPanel p2p1 = new JPanel();
JLabel p2s1 = new JLabel();
JLabel p2attack1 = new JLabel("Attack Strength: ");
JLabel p2e1 = new JLabel();
JLabel p2spec1 = new JLabel();
JButton p2b1 = new JButton();

JPanel p2p2 = new JPanel();
JLabel p2s2 = new JLabel();
JLabel p2attack2 = new JLabel("Attack Strength: ");
JLabel p2e2 = new JLabel("Energy: ");
JLabel p2spec2 = new JLabel();
JButton p2b2 = new JButton();

JPanel p2p3 = new JPanel();
JLabel p2s3 = new JLabel();
JLabel p2attack3 = new JLabel("Attack Strength: ");
JLabel p2e3 = new JLabel("Energy: ");
JLabel p2spec3 = new JLabel();
JButton p2b3 = new JButton();


        healPanel = new JPanel();
        healPanelLabel = new JLabel();
        HA1 = new JButton();
        HA2 = new JButton();
        HA3 = new JButton();
        HB1 = new JButton();
        HB2 = new JButton();
        HB3 = new JButton();

        p1health1l = new JLabel();
        p1health2l = new JLabel();
        p1health3l = new JLabel();

	    p2health1l = new JLabel();
        p2health2l = new JLabel();
        p2health3l = new JLabel();

        winPanel = new JPanel();
        winPanelLabel = new JLabel();
        Home = new JButton();
        playAgain = new JButton();

        helpPanel = new JPanel();
        assaultPanel = new JPanel();
        assassinPanel = new JPanel();
        healerPanel = new JPanel();
        supportPanel = new JPanel();
        tankPanel  =new JPanel();

        assaultPanelLabel = new JLabel();
        assassinPanelLabel = new JLabel();
        healerPanelLabel = new JLabel();
        supportPanelLabel = new JLabel();
        tankPanelLabel = new JLabel();

        helpButton = new JButton("?");
        assaultb = new JButton();
        assassinb = new JButton();
        healerb = new JButton();
        supportb = new JButton();
        tankb = new JButton();

        helpClose = new JButton();
        apc = new JButton();
        aspc = new JButton();
        hpc = new JButton();
        spc = new JButton();
        tpc = new JButton();





        startPane.setLayout(null);
        startPane.setBackground(new Color(100, 60, 140));
        startPane.setSize(1600, 800);


        startLabel.setBounds(300,300,1200,100);
        startLabel.setFont(new Font("Press Start 2P",Font.BOLD,120));
        startLabel.setForeground(new Color(255,30,0));
        startPane.add(startLabel,JLayeredPane.DRAG_LAYER);
        startPane.add(bgop,JLayeredPane.DEFAULT_LAYER);
        startLabel.setVisible(true);

        startButton.setBounds(500, 500, 600, 100);
        startButton.setText("Click to start");
        startPane.add(startButton,JLayeredPane.DRAG_LAYER);
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Comic Sans", Font.BOLD,50));
        startButton.setBorder(BorderFactory.createCompoundBorder());
        startButton.setEnabled(true);
        startButton.setVisible(true);

        this.add(startPane);
        this.add(panel1);
        thePane = new JLayeredPane();
        this.add(thePane);
        thePane.setSize(1600, 800);
        thePane.setBackground(new Color(100, 60, 140));
        thePane.setVisible(false);
        thePane.setEnabled(true);
        thePane.setLayout(null);
        l1 = new JLabel("YES");
        l1.setFont(new Font("Press Start 2P", Font.BOLD, 60));
        thePane.add(l1,JLayeredPane.DRAG_LAYER);
        l1.setVisible(true);
        l1.setBounds(200,100,600,100);
        l1.setForeground(Color.RED);
        l1.setOpaque(true);

        panel1.setVisible(false);
        panel1.setEnabled(false);
        panel1.setLayout(null);
        panel1.setBackground(new Color(100, 60, 140));
        panel1.setSize(1600, 800);

        pane1 = new JLayeredPane();
        this.add(pane1);
        pane1.setVisible(false);
        pane1.setEnabled(false);
        pane1.setLayout(null);
        pane1.setBackground(new Color(100, 60, 140));
        pane1.setSize(1600, 800);
        pane1.add(bgc,JLayeredPane.DEFAULT_LAYER);

        side11 = new JLabel(p1asb);
        side12 = new JLabel(p2asb);

        side2 = new JLabel(p1asb);



        side11.setVisible(true);
        side11.setOpaque(false);
        side11.setBackground(null);
        pane1.add(side11,JLayeredPane.DRAG_LAYER);
	    side11.setBounds(380, 300, 250, 250);

	    side12.setVisible(true);
        side12.setOpaque(false);
        side12.setBackground(null);
        pane1.add(side12,JLayeredPane.DRAG_LAYER);
	    side12.setBounds(460, 300, 250, 250);

        side2.setVisible(true);
        side2.setOpaque(false);
        side2.setBackground(null);
        pane1.add(side2,JLayeredPane.DRAG_LAYER);
        
        side2.setBounds(800, 300, 250, 250);

        panel1Label.setText("Choose your game mode");
        panel1Label.setVisible(true);
        panel1Label.setBounds(400, 200, 1200, 100);
        panel1Label.setFont(new Font("Press Start 2P", Font.BOLD, 60));
        panel1Label.setForeground(new Color(255, 30, 0));
        panel1Label.setVisible(true);
        pane1.add(panel1Label,JLayeredPane.DRAG_LAYER);

        	
JLabel side1l = new JLabel("Two Player");

JLabel side2l = new JLabel("One Player");
side1l.setVisible(true);
side1l.setOpaque(false);
side1l.setBackground(null);
pane1.add(side1l,JLayeredPane.DRAG_LAYER);
side1l.setBounds(420, 500, 400, 60);
side1l.setFont(new Font("Comic Sans", Font.BOLD,50));
side1l.setForeground(Color.BLUE);

side2l.setVisible(true);
side2l.setOpaque(false);
side2l.setBackground(null);
pane1.add(side2l,JLayeredPane.DRAG_LAYER);
side2l.setBounds(800, 500, 400, 60);
side2l.setForeground(Color.RED);
            side2l.setFont(new Font("Comic Sans", Font.BOLD,50));

        deathLabel = new JLabel(dIcon);
        roundsLabel = new JLabel(rIcon);

        deathLabel.setVisible(true);
        deathLabel.setOpaque(false);
        deathLabel.setBackground(null);
        
        roundsLabel.setVisible(true);
        roundsLabel.setOpaque(false);
        roundsLabel.setBackground(null);
        
        deathLabel.setBounds(800, 300, 250, 250);
        roundsLabel.setBounds(400, 300, 250, 250);

        JLabel test = new JLabel();
        panel1.add(test);
        test.setVisible(true);
        test.setBounds(500,400,400,80);
        //test.setOpaque(false);
        
        test.setFont(new Font("Comic Sans", Font.BOLD,35));
        test.setBackground(this.getBackground());
        test.setForeground(Color.RED);
        test.setText("Test");
        
        b1.setBounds(400, 300, 250, 250);
        pane1.add(b1,JLayeredPane.DEFAULT_LAYER);
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
                    try{
                        playSelect();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
            } 
                    pvp = true;
                    r = 1;
                    computer = null;
                    p2 = new Player();
                    fightPanelLabel.setText("       Round "+ r+" Player 1 turn");
                    pvpPanel3Label.setText("Player 1 choose 3 Heroes");
                    defendPanelLabel.setText("Player 1 choose your defending Hero");
                    pane2.setEnabled(true);
                    pane2.setVisible(true);
                    pane1.setVisible(false);
                    pane1.setEnabled(false);
                    Player1.setForeground(Color.BLUE);
                    Player1.setBounds(400,450,300,60);
                    Player1.setFont(new Font("Comic Sans", Font.BOLD,50));
                    

                    Player11.setForeground(Color.BLUE);
                    Player11.setBounds(400,500,300,50);
                    Player11.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    
                    Player12.setForeground(Color.BLUE);
                    Player12.setBounds(400,550,300,50);
                    Player12.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    
                    Player13.setForeground(Color.BLUE);
                    Player13.setBounds(400,600,300,50);
                    Player13.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    

                    Player2.setForeground(Color.RED);
                    Player2.setBounds(700,450,300,60);
                    Player2.setFont(new Font("Comic Sans", Font.BOLD,50));
                    
                    

                    Player21.setForeground(Color.RED);
                    Player21.setBounds(700,500,300,50);
                    Player21.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    

                    Player22.setForeground(Color.RED);
                    Player22.setBounds(700,550,300,50);
                    Player22.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    

                    Player23.setForeground(Color.RED);
                    Player23.setBounds(700,600,300,50);
                    Player23.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    
                }
            }
        });

        b2.setBounds(800, 300, 250, 250);
        pane1.add(b2,JLayeredPane.DEFAULT_LAYER);
        
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
                    try{
                        playClick();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    pvp = false;
                    //p2 = null;
                    r = 1;
                    Player2.setVisible(false);
                    Player1.setForeground(Color.BLUE);
                    Player1.setBounds(400,450,300,60);
                    Player1.setFont(new Font("Comic Sans", Font.BOLD,50));
                    

                    Player11.setForeground(Color.BLUE);
                    Player11.setBounds(400,500,300,50);
                    Player11.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    
                    Player12.setForeground(Color.BLUE);
                    Player12.setBounds(400,550,300,50);
                    Player12.setFont(new Font("Comic Sans", Font.PLAIN,35));
                    
                    Player13.setForeground(Color.BLUE);
                    Player13.setBounds(400,600,300,50);
                    Player13.setFont(new Font("Comic Sans", Font.PLAIN,35));

                    Player1.setBounds(550,450,300,60);
                    Player11.setBounds(550,500,300,50);
                    Player12.setBounds(550,550,300,50);
                    Player13.setBounds(550,600,300,50);
                    fightPanelLabel.setText("       Round "+ r);
                    pvpPanel3Label.setText("Choose 3 Heroes");
                    defendPanelLabel.setText("Choose your defending Hero");
                    computer = new Computer();
                    p2d1.setText(computer.chosen[0].Class);
                    p2d2.setText(computer.chosen[1].Class);
                    p2d3.setText(computer.chosen[2].Class);
                    p2s1.setText(computer.chosen[0].Class);
                    p2s2.setText(computer.chosen[1].Class);
                    p2s3.setText(computer.chosen[2].Class);
                    chardb1.setText(computer.chosen[0].Class);
                    chardb2.setText(computer.chosen[1].Class);
                    chardb3.setText(computer.chosen[2].Class);
                    charfb1.setText(computer.chosen[0].Class);
                    charfb2.setText(computer.chosen[1].Class);
                    charfb3.setText(computer.chosen[2].Class);
                    charhb1.setText(computer.chosen[0].Class);
                    charhb2.setText(computer.chosen[1].Class);
                    charhb3.setText(computer.chosen[2].Class);
                    fb1.setText(computer.chosen[0].Class);
                    fb2.setText(computer.chosen[1].Class);
                    fb3.setText(computer.chosen[2].Class);
                    HB1.setText(computer.chosen[0].Class);
                    HB2.setText(computer.chosen[1].Class);
                    HB3.setText(computer.chosen[2].Class);

                    m2.put(computer.chosen[0].Class,computer.chosen[0]);
                    m2.put(computer.chosen[1].Class,computer.chosen[1]);
                    m2.put(computer.chosen[2].Class,computer.chosen[2]);
                                        


                    p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                    p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                    p2a3l.setText(String.valueOf(computer.chosen[2].HP));
                    p2health1l.setText(String.valueOf(computer.chosen[0].HP));
                    p2health2l.setText(String.valueOf(computer.chosen[1].HP));
                    p2health3l.setText(String.valueOf(computer.chosen[2].HP));
                    p2life1l.setText(String.valueOf(computer.chosen[0].HP));
                    p2life2l.setText(String.valueOf(computer.chosen[1].HP));
                    p2life3l.setText(String.valueOf(computer.chosen[2].HP));
                    pane2.setEnabled(true);
                    pane2.setVisible(true);
                    pane1.setVisible(false);
                    pane1.setEnabled(false);
                }
            }
        });

        Back0.setText("Back");
        Back0.setFocusable(false);
        Back0.setBounds(50,50,400,100);
        Back0.setFont(new Font("Press Start 2P",Font.BOLD,35));
        Back0.setVisible(true);
        Back0.setEnabled(true);
        pane1.add(Back0,JLayeredPane.DRAG_LAYER);
        Back0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Back0) {
                    try{
                        playBack();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    pane1.setVisible(false);
                    pane1.setEnabled(false);
                    startPane.setVisible(true);
                    startPane.setEnabled(true);
                }
            }
        });

    

        pane2 = new JLayeredPane();
        pane3 = new JLayeredPane();
        defendPane = new JLayeredPane();
        fightPane = new JLayeredPane();
        healPane = new JLayeredPane();

        pane2.setLayout(null);
        pane2.setBackground(new Color(100, 60, 140));
        pane2.setSize(1600, 800);
        pane2.setVisible(false);
        pane2.setEnabled(false);

        pane3.setLayout(null);
        pane3.setBackground(new Color(100, 60, 140));
        pane3.setSize(1600, 800);
        pane3.setVisible(false);
        pane3.setEnabled(false);
        pane3.add(bgs, JLayeredPane.DEFAULT_LAYER);


        Player1.setText("Player 1");
        Player1.setVisible(true);
        pane3.add(Player1,JLayeredPane.DRAG_LAYER);
        pane3.add(Player11,JLayeredPane.DRAG_LAYER);
        Player11.setVisible(false);
        pane3.add(Player12,JLayeredPane.DRAG_LAYER);
        Player12.setVisible(false);
        pane3.add(Player13,JLayeredPane.DRAG_LAYER);
        Player13.setVisible(false);
        

        Player2.setText("Player 2");
        Player2.setVisible(true);
        pane3.add(Player2,JLayeredPane.DRAG_LAYER);
        pane3.add(Player21,JLayeredPane.DRAG_LAYER);
        Player21.setVisible(false);
        pane3.add(Player22,JLayeredPane.DRAG_LAYER);
        Player22.setVisible(false);
        pane3.add(Player23,JLayeredPane.DRAG_LAYER);
        Player23.setVisible(false);
        pane3.add(c1,JLayeredPane.DRAG_LAYER);
        pane3.add(c2,JLayeredPane.DRAG_LAYER);
        pane3.add(c3,JLayeredPane.DRAG_LAYER);
        pane3.add(c4,JLayeredPane.DRAG_LAYER);
        pane3.add(c5,JLayeredPane.DRAG_LAYER);
        //pane3.add(bgs,JLayeredPane.DEFAULT_LAYER);
        

        c1.setText("assault");
        c1.setForeground(Color.BLUE);
        c1.setVisible(true);
        c1.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        c1.setBounds(230, 400, 100, 40);

        c2.setText("assassin");
        c2.setForeground(Color.BLUE);
        c2.setVisible(true);
        c2.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        c2.setBounds(430, 400, 100, 40);

        c3.setText("healer");
        c3.setForeground(Color.BLUE);
        c3.setVisible(true);
        c3.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        c3.setBounds(630, 400, 100, 40);

        c4.setText("support");
        c4.setForeground(Color.BLUE);
        c4.setVisible(true);
        c4.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        c4.setBounds(830, 400, 100, 40);

        c5.setText("tank");
        c5.setForeground(Color.BLUE);
        c5.setVisible(true);
        c5.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        c5.setBounds(1030, 400, 100, 40);

        defendPane.setLayout(null);
        defendPane.setBackground(new Color(100, 60, 140));
        defendPane.setSize(1600, 800);
        defendPane.setVisible(false);
        defendPane.setEnabled(false);

        fightPane.setLayout(null);
        fightPane.setBackground(new Color(100, 60, 140));
        fightPane.setSize(1600, 800);
        fightPane.setVisible(false);
        fightPane.setEnabled(false);

        healPane.setLayout(null);
        healPane.setBackground(new Color(100, 60, 140));
        healPane.setSize(1600, 800);
        healPane.setVisible(false);
        healPane.setEnabled(false);

        this.add(pane2);
        this.add(pane3);
        this.add(defendPane);
        this.add(fightPane);
        this.add(healPane);



        panel2Label.setText("   Rounds  or  Deathmatch");
        panel2Label.setVisible(true);
        panel2Label.setBounds(350, 200, 1200, 100);
        panel2Label.setFont(new Font("Press Start 2P", Font.BOLD, 60));
        panel2Label.setForeground(new Color(255, 30, 0));
        panel2Label.setVisible(true);
        
        pane2.add(panel2Label,JLayeredPane.DRAG_LAYER);
        pane2.add(deathLabel,JLayeredPane.DRAG_LAYER);
        pane2.add(roundsLabel,JLayeredPane.DRAG_LAYER);
        pane2.add(b3,JLayeredPane.DEFAULT_LAYER);
        pane2.add(b4,JLayeredPane.DEFAULT_LAYER);
        pane2.add(Back1,JLayeredPane.DRAG_LAYER);
        pane2.add(bgm,JLayeredPane.DEFAULT_LAYER);

        b3.setBounds(410, 310, 230, 230);

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
                    try{
                        playClick();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    limited = true;
                    pane2.setEnabled(false);
                    pane2.setVisible(false);
                    pane21.setEnabled(true);
                    pane21.setVisible(true);
                    aI.setBackground(null);
                    asI.setBackground(null);
                    hI.setBackground(null);
                    sI.setBackground(null);
                    tI.setBackground(null);
                    aI.setIcon(p1ai);
                    //aI.setVerticalAlignment(JLabel.BOTTOM);
                    //aI.setHorizontalAlignment(JLabel.RIGHT);
                    asI.setIcon(p1asi);
                    hI.setIcon(p1hi);
                    sI.setIcon(p1si);
                    tI.setIcon(p1ti);
                }
            }
        });

        b4.setBounds(810, 310, 230, 230);
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
                    try{
                        playClick();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    limited = false;
                    pane2.setVisible(false);
                    pane2.setEnabled(false);
                    pane3.setVisible(true);
                    pane3.setEnabled(true);
                    aI.setBackground(null);
                    asI.setBackground(null);
                    hI.setBackground(null);
                    sI.setBackground(null);
                    tI.setBackground(null);
                    aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                    aI.setAlignmentX(50);
                    aI.setAlignmentY(50);
                    aI.setIcon(p1ai);
                    asI.setIcon(p1asi);
                    hI.setIcon(p1hi);
                    sI.setIcon(p1si);
                    tI.setIcon(p1ti);
                }
            }
        });

        Back1.setText("Back");
        Back1.setFocusable(false);
        Back1.setBounds(50,50,400,100);
        Back1.setFont(new Font("Press Start 2P",Font.BOLD,35));
        Back1.setVisible(true);
        Back1.setEnabled(true);
        
        Back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Back1) {
                    try{
                        playBack();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    pane2.setVisible(false);
                    pane2.setEnabled(false);
                    pane1.setVisible(true);
                    pane1.setEnabled(true);
                }
            }
        });

        //this.add(panel2);
        panel2.setEnabled(false);
        panel2.setVisible(false);

        pane21.setLayout(null);
        pane21.setBackground(new Color(100, 60, 140));
        pane21.setSize(1600, 800);
        this.add(pane21);
        pane21.setEnabled(false);
        pane21.setVisible(false);

        pane21.add(NextB1,JLayeredPane.DRAG_LAYER);
        pane21.add(panel3Textbox,JLayeredPane.DRAG_LAYER);
        pane21.add(bgm3,JLayeredPane.DEFAULT_LAYER);
        panel3Label.setText("How many rounds do you want to play?");
        panel3Label.setBounds(80, 150, 1600, 100);
        panel3Label.setFont(new Font("Press Start 2P", Font.BOLD, 70));
        panel3Label.setForeground(new Color(255, 30, 0));
        panel3Label.setVisible(true);
        pane21.add(panel3Label,JLayeredPane.DRAG_LAYER);
        

        //panel3.add();

        panel3Textbox.setBounds(500, 310, 400, 50);
        panel3Textbox.setFont(new Font("Press Start 2P", Font.BOLD, 50));
        panel3Textbox.setVisible(true);
        panel3Textbox.setEnabled(true);
        

        NextB1.setBounds(500, 500, 400, 130);
        NextB1.addActionListener(this);
        NextB1.setText("Next");
        NextB1.setFocusable(false);
        NextB1.setFont(new Font("Comic Sans", Font.BOLD,80));
        NextB1.setBorder(BorderFactory.createCompoundBorder());
        NextB1.setEnabled(true);
        NextB1.setVisible(true);
        NextB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == NextB1){
                    try{
                        playClick();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    rounds = Integer.parseInt(panel3Textbox.getText());
                    System.out.println(rounds +" rounds");
                    pane21.setVisible(false);
                    pane21.setEnabled(false);
                    pane3.setVisible(true);
                    pane3.setEnabled(true);
                    aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                }
            }
        });

        pvpPanel3Label.setVisible(true);
        pvpPanel3Label.setBounds(400, 100, 1200, 100);
        pvpPanel3Label.setFont(new Font("Press Start 2P", Font.BOLD, 60));
        pvpPanel3Label.setForeground(new Color(255, 30, 0));
        pvpPanel3Label.setVisible(true);
        pane3.add(pvpPanel3Label,JLayeredPane.DRAG_LAYER);

        NextB2.setBounds(1350, 600, 120, 90);
        pane3.add(NextB2,JLayeredPane.DRAG_LAYER);
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
                    try{
                        playClick();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    p2resetd();
                    p2reset();
                    r = 1;
                    pane3.setVisible(false);
                    pane3.setEnabled(false);
                    p1d1.setBounds(410,270,100,100);
                    p1d2.setBounds(560,350,100,100);
                    p1d3.setBounds(410,430,100,100);

                    
                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);


                    p1life1l.setBounds(420,400,300,50);
                    p1life2l.setBounds(570,480,300,50);
                    p1life3l.setBounds(420,550,300,50);


                    if (pvp){
                        defendPanelLabel.setText("Player 1 choose your defending Hero");
                    }
                    else{
                        defendPanelLabel.setText("Choose your defending Hero");
                        sortButtons();
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

                    c1.setForeground(Color.BLUE);
                    c2.setForeground(Color.BLUE);
                    c3.setForeground(Color.BLUE);
                    c4.setForeground(Color.BLUE);
                    c5.setForeground(Color.BLUE);

                    defendPane.setEnabled(true);
                    defendPane.setVisible(true);
                    turn = 1;

                    Player11.setVisible(false);
                    Player12.setVisible(false);
                    Player13.setVisible(false);
                    Player21.setVisible(false);
                    Player22.setVisible(false);
                    Player23.setVisible(false);

                    p11d.setBackground(Color.WHITE);
                    p12d.setBackground(Color.WHITE);
                    p13d.setBackground(Color.WHITE);

                    p21d.setBackground(null);
                    p22d.setBackground(null);
                    p23d.setBackground(null);
                    p21d.setOpaque(false);
                    p22d.setOpaque(false);
                    p23d.setOpaque(false);

                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(950,350,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p21f.setBounds(1100, 270,100,100);
                    p21h.setBounds(1100, 270,100,100);

                    p22d.setBounds(950, 350,100,100);
                    p22f.setBounds(950, 350,100,100);
                    p22h.setBounds(950, 350,100,100);

                    p23d.setBounds(1100, 430,100,100);
                    p23f.setBounds(1100, 430,100,100);
                    p23h.setBounds(1100, 430,100,100);

                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    fb1.setBounds(1100,270,100,100);
                    fb2.setBounds(950,350,100,100);
                    fb3.setBounds(1100,430,100,100);

                    HB1.setBounds(1100,270,100,100);
                    HB2.setBounds(950,350,100,100);
                    HB3.setBounds(1100,430,100,100);

                    p2d1l.setBounds(920,295,300,50);
                    p2d2l.setBounds(920,295,300,50);
                    p2d3l.setBounds(920,295,300,50);

                    p2a1l.setBounds(1100,400,300,50);
                    p2a2l.setBounds(950,480,300,50);
                    p2a3l.setBounds(1100,550,300,50);

                    p2life1l.setBounds(1100,400,300,50);
                    p2life2l.setBounds(950,480,300,50);
                    p2life3l.setBounds(1100,550,300,50);

                    p2health1l.setBounds(1100,400,300,50);
                    p2health2l.setBounds(950,480,300,50);
                    p2health3l.setBounds(1100,550,300,50);

                    
                    p1e1.setText("Energy: "+ m1.get(HA1.getText()).Energy);
                    p1attack1.setText("Attack Strength: "+ m1.get(HA1.getText()).Attack);
                    if(fa1.getText().equals("tank")){
                        p1spec1.setText("Shield Strength: "+ m1.get("tank").Shield);
                    }
                    else if(fa1.getText().equals("healer")){
                        p1spec1.setText("HealPotency: "+(int) (m1.get("healer").HP * 0.3));
                    }
                    else{
                        p1spec1.setText("");
                    }

                    p1e2.setText("Energy: "+ m1.get(HA2.getText()).Energy);
                    p1attack2.setText("Attack Strength: "+ m1.get(HA2.getText()).Attack);
                    if(fa2.getText().equals("tank")){
                        p1spec2.setText("Shield Strength: "+ m1.get("tank").Shield);
                    }
                    else if(fa2.getText().equals("healer")){
                        p1spec2.setText("HealPotency: "+(int) (m1.get("healer").HP * 0.3));
                    }
                    else{
                        p1spec2.setText("");
                    }


                    p1e3.setText("Energy: "+ m1.get(HA3.getText()).Energy);
                    p1attack3.setText("Attack Strength: "+ m1.get(HA3.getText()).Attack);
                    if(fa3.getText().equals("tank")){
                        p1spec3.setText("Shield Strength: "+ m1.get("tank").Shield);
                    }
                    else if(fa3.getText().equals("healer")){
                        p1spec3.setText("HealPotency: "+(int) (m1.get("healer").HP * 0.3));
                    }
                    else{
                        p1spec3.setText("");
                    }



                    p2e1.setText("Energy: "+ m2.get(HB1.getText()).Energy);
                    p2attack1.setText("Attack Strength: "+ m2.get(HB1.getText()).Attack);
                    if(fb1.getText().equals("tank")){
                        p2spec1.setText("Shield Strength: "+ m2.get("tank").Shield);
                    }
                    else if(fb1.getText().equals("healer")){
                        p2spec1.setText("HealPotency: "+(int) (m2.get("healer").HP * 0.3));
                    }
                    else{
                        p2spec1.setText("");
                    }

                    p2e2.setText("Energy: "+ m2.get(HB2.getText()).Energy);
                    p2attack2.setText("Attack Strength: "+ m2.get(HB2.getText()).Attack);
                    if(fb2.getText().equals("tank")){
                        p2spec2.setText("Shield Strength: "+ m2.get("tank").Shield);
                    }
                    else if(fb2.getText().equals("healer")){
                        p2spec2.setText("HealPotency: "+(int) (m2.get("healer").HP * 0.3));
                    }
                    else{
                        p2spec2.setText("");
                    }

                    p2e3.setText("Energy: "+ m2.get(HB3.getText()).Energy);
                    p2attack3.setText("Attack Strength: "+ m2.get(HB3.getText()).Attack);
                    if(fb3.getText().equals("tank")){
                        p2spec3.setText("Shield Strength: "+ m2.get("tank").Shield);
                    }
                    else if(fb3.getText().equals("healer")){
                        p2spec3.setText("HealPotency: "+(int) (m2.get("healer").HP * 0.3));
                    }
                    else{
                        p2spec3.setText("");
                    }
                    p11d.setOpaque(true);
                    p12d.setOpaque(true);
                    p13d.setOpaque(true);

p11d.setBackground(Color.WHITE);
                    p12d.setBackground(Color.WHITE);
                    p13d.setBackground(Color.WHITE);

                }
            }
        });

        Undo.setBounds(1380, 100, 120, 50);
        pane3.add(Undo,JLayeredPane.DRAG_LAYER);
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
                    try{
                        playBack();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    NextB2.setEnabled(false);
                    p11d.setIcon(null);
                    p11f.setIcon(null);
                    p11h.setIcon(null);
                    p12d.setIcon(null);
                    p12f.setIcon(null);
                    p12h.setIcon(null);
                    p13d.setIcon(null);
                    p13f.setIcon(null);
                    p13h.setIcon(null);

                    p1.assassin = null;
                    p1.assault= null;
                    p1.healer = null;
                    p1.support = null;
                    p1.tank = null;
                    Player11.setText("");
                    Player12.setText("");
                    Player13.setText("");
                    aI.setBackground(null);
                    asI.setBackground(null);
                    hI.setBackground(null);
                    sI.setBackground(null);
                    tI.setBackground(null);
                    aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                    aI.setIcon(p1ai);
                    asI.setIcon(p1asi);
                    hI.setIcon(p1hi);
                    sI.setIcon(p1si);
                    tI.setIcon(p1ti);
                    c1.setForeground(Color.BLUE);
                    c2.setForeground(Color.BLUE);
                    c3.setForeground(Color.BLUE);
                    c4.setForeground(Color.BLUE);
                    c5.setForeground(Color.BLUE);

                    if (pvp){
                        pvpPanel3Label.setText("Player 1 choose 3 Heroes");
                        p2.assassin = null;
                        p2.assault= null;
                        p2.healer = null;
                        p2.support = null;
                        p2.tank = null;
                        p21d.setIcon(null);
                        p21h.setIcon(null);
                        p21f.setIcon(null);
                        p22d.setIcon(null);
                        p22h.setIcon(null);
                        p22f.setIcon(null);
                        p23d.setIcon(null);
                        p23h.setIcon(null);
                        p23f.setIcon(null);
                    }
                    else{
                        pvpPanel3Label.setText("Choose 3 Heroes");
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

        Undo2.setBounds(1380, 100, 120, 50);
        pane3.add(Undo2,JLayeredPane.DRAG_LAYER);
        Undo2.addActionListener(this);
        Undo2.setText("Undo");
        Undo2.setFocusable(false);
        Undo2.setFont(new Font("Comic Sans", Font.BOLD,35));
        Undo2.setBorder(BorderFactory.createCompoundBorder());
        Undo2.setEnabled(false);
        Undo2.setVisible(false);
        Undo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Undo2){
                    try{
                        playBack();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    NextB2.setEnabled(false);
                    p2.assassin = null;
                    p2.assault= null;
                    p2.healer = null;
                    p2.support = null;
                    p2.tank = null;
                    aI.setBackground(null);
                    asI.setBackground(null);
                    hI.setBackground(null);
                    sI.setBackground(null);
                    tI.setBackground(null);
                    aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                    aI.setIcon(p2ai);
                    asI.setIcon(p2asi);
                    hI.setIcon(p2hi);
                    sI.setIcon(p2si);
                    tI.setIcon(p2ti);
                    Player21.setText("");
                    Player22.setText("");
                    Player23.setText("");

                    pvpPanel3Label.setText("Player 2 choose 3 Heroes");
                    p2.assassin = null;
                    p2.assault= null;
                    p2.healer = null;
                    p2.support = null;
                    p2.tank = null;
                
                    selected = 0;
                    turn = 2;
                    Ab.setEnabled(true);
                    ab.setEnabled(true);
                    hb.setEnabled(true);
                    sb.setEnabled(true);
                    tb.setEnabled(true);

                    Undo.setEnabled(true);
                    Undo.setVisible(true);

                    Undo2.setEnabled(false);
                    Undo2.setVisible(false);

                }
            }
        });

        Back2.setText("Back");
        Back2.setFocusable(false);
        Back2.setBounds(50,50,200,100);
        Back2.setFont(new Font("Press Start 2P",Font.BOLD,35));
        Back2.setVisible(true);
        Back2.setEnabled(true);
        pane3.add(Back2,JLayeredPane.DRAG_LAYER);
        Back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== Back2){
                    try{
                        playBack();
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    aI.setBackground(null);
                    asI.setBackground(null);
                    hI.setBackground(null);
                    sI.setBackground(null);
                    tI.setBackground(null);
                    aI.setIcon(p1ai);
                    asI.setIcon(p1asi);
                    hI.setIcon(p1hi);
                    sI.setIcon(p1si);
                    tI.setIcon(p1ti);
                    c1.setForeground(Color.BLUE);
                    c2.setForeground(Color.BLUE);
                    c3.setForeground(Color.BLUE);
                    c4.setForeground(Color.BLUE);
                    c5.setForeground(Color.BLUE);
                    NextB2.setEnabled(false);
                    pane3.setVisible(false);
                    pane3.setEnabled(false);
                    if(pvp){
                        pvpPanel3Label.setText("Player 1 choose 3 Heroes");
                    }
                    else{
                        pvpPanel3Label.setText("Choose 3 Heroes");
                    }

                    Player11.setText("");
                    Player12.setText("");
                    Player13.setText("");


                    Player21.setText("");
                    Player22.setText("");
                    Player23.setText("");
                    selected = 0;
                    turn = 1;
                    Ab.setEnabled(true);
                    ab.setEnabled(true);
                    hb.setEnabled(true);
                    sb.setEnabled(true);
                    tb.setEnabled(true);
                    pane2.setVisible(true);
                    pane2.setEnabled(true);
                }
            }
        });


        aI.setBounds(200, 250, 150, 150);
        pane3.add(aI,JLayeredPane.DRAG_LAYER);
        aI.setBackground(null);
        aI.setOpaque(false);
        aI.setVisible(true);
        //aI.setLayout(null);

        Ab.setVisible(true);
        Ab.setEnabled(true);
        Ab.setBounds(200, 250, 150, 150);
        Ab.addActionListener(this);
        Ab.setText("Assault");
        Ab.setFocusable(false);
        Ab.setFont(new Font("Comic Sans", Font.BOLD,35));
        Ab.setBorder(BorderFactory.createCompoundBorder());
        pane3.add(Ab,JLayeredPane.DEFAULT_LAYER);
        Ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Ab ) {
                    try{
                            playBuff();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    if (selected < 3 && turn==1) {
                        
                        Undo.setEnabled(true);
                        
                        Undo.setVisible(true);
                        aI.setBackground(Color.BLUE);
                        aI.setOpaque(true);
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
                                p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                Player11.setText("assault");
                                Player11.setVisible(true);
                                p1s1.setText("assault");
                                p11d.setIcon(p1ai);
                                p11h.setIcon(p1ai);
                                p11f.setIcon(p1ai);
                                charda1.setText("assault");
                                charha1.setText("assault");
                                charfa1.setText("assault");
                                break;
                            case 1:
                                p1s2.setText("assault");
                                p1d2.setText(p1.chosen[selected].Class);
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                Player12.setText("assault");
                                Player12.setVisible(true);
                                p12d.setIcon(p1ai);
                                p12h.setIcon(p1ai);
                                p12f.setIcon(p1ai);
                                charda2.setText("assault");
                                charha2.setText("assault");
                                charfa2.setText("assault");
                                break;
                            case 2:
                                p1s3.setText("assault");
                                p1d3.setText(p1.chosen[selected].Class);
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                Player13.setText("assault");
                                Player13.setVisible(true);
                                p13d.setIcon(p1ai);
                                p13h.setIcon(p1ai);
                                p13f.setIcon(p1ai);
                                charda3.setText("assault");
                                charha3.setText("assault");
                                charfa3.setText("assault");
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp ){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose 3 Heroes");
                        aI.setBackground(null);
                        asI.setBackground(null);
                        hI.setBackground(null);
                        sI.setBackground(null);
                        tI.setBackground(null);
                        aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                        aI.setIcon(p2ai);
                        asI.setIcon(p2asi);
                        hI.setIcon(p2hi);
                        sI.setIcon(p2si);
                        tI.setIcon(p2ti);

                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                        c1.setForeground(Color.RED);
                        c2.setForeground(Color.RED);
                        c3.setForeground(Color.RED);
                        c4.setForeground(Color.RED);
                        c5.setForeground(Color.RED);
                    }
                    else if (selected < 3 && turn==2) {
                        Ab.setEnabled(false);
                        aI.setOpaque(true);
                        aI.setBackground(Color.RED);
                        p2.assault = new Assault();
                        m2.put("assault",p2.assault);
                        p2.chosen[selected] = p2.assault;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                p2s1.setText("assault");
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                Player21.setText("assault");
                                Player21.setVisible(true);
                                p21d.setIcon(p2ai);
                                p21h.setIcon(p2ai);
                                p21f.setIcon(p2ai);
                                chardb1.setText("assault");
                                charhb1.setText("assault");
                                charfb1.setText("assault");
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                p2s2.setText("assault");
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                Player22.setText("assault");
                                Player22.setVisible(true);
                                p22d.setIcon(p2ai);
                                p22h.setIcon(p2ai);
                                p22f.setIcon(p2ai);
                                chardb2.setText("assault");
                                charhb2.setText("assault");
                                charfb2.setText("assault");
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                p2s3.setText("assault");
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                Player23.setText("assault");
                                Player23.setVisible(true);
                                p23d.setIcon(p2ai);
                                p23h.setIcon(p2ai);
                                p23f.setIcon(p2ai);
                                chardb3.setText("assault");
                                charhb3.setText("assault");
                                charfb3.setText("assault");
                            default:
                        }
                        selected++;
                        if(selected >0){
                            Undo.setEnabled(false);
                            Undo.setVisible(false);
                            Undo2.setEnabled(true);
                            Undo2.setVisible(true);
                        }
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        asI.setBounds(400, 250, 150, 150);
        pane3.add(asI,JLayeredPane.DRAG_LAYER);
        asI.setBackground(null);
        asI.setOpaque(false);
        asI.setVisible(true);

        ab.setVisible(true);
        ab.setEnabled(true);
        ab.setBounds(400, 250, 150, 150);
        ab.addActionListener(this);
        ab.setText("Assassin");
        ab.setFocusable(false);
        ab.setFont(new Font("Comic Sans", Font.BOLD,35));
        ab.setBorder(BorderFactory.createCompoundBorder());
        pane3.add(ab,JLayeredPane.DEFAULT_LAYER);
        ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ab ) {
                    try{
                            playBuff();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    if (selected < 3 && turn==1) {
                        
                        Undo.setEnabled(true);
                        Undo.setVisible(true);
                        asI.setOpaque(true);
                        asI.setBackground(Color.BLUE);
                        ab.setEnabled(false);
                        p1.assassin = new Assassin();
                        m1.put("assassin",p1.assassin);
                        p1.chosen[selected] = p1.assassin;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                p1s1.setText("assassin");
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                Player11.setText("assassin");
                                Player11.setVisible(true);
                                p11d.setIcon(p1asi);
                                p11h.setIcon(p1asi);
                                p11f.setIcon(p1asi);
                                charda1.setText("assassin");
                                charha1.setText("assassin");
                                charfa1.setText("assassin");


                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                p1s2.setText("assassin");
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                Player12.setText("assassin");
                                Player12.setVisible(true);
                                p12d.setIcon(p1asi);
                                p12h.setIcon(p1asi);
                                p12f.setIcon(p1asi);
                                charda2.setText("assassin");
                                charha2.setText("assassin");
                                charfa2.setText("assassin");

                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                p1s3.setText("assassin");
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                Player13.setText("assassin");
                                Player13.setVisible(true);
                                p13d.setIcon(p1asi);
                                p13h.setIcon(p1asi);
                                p13f.setIcon(p1asi);
                                charda3.setText("assassin");
                                charha3.setText("assassin");
                                charfa3.setText("assassin");
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose 3 Heroes");
                        aI.setBackground(null);
                        asI.setBackground(null);
                        hI.setBackground(null);
                        sI.setBackground(null);
                        tI.setBackground(null);
                        aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                        aI.setIcon(p2ai);
                        asI.setIcon(p2asi);
                        hI.setIcon(p2hi);
                        sI.setIcon(p2si);
                        tI.setIcon(p2ti);

                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;

                        c1.setForeground(Color.RED);
                        c2.setForeground(Color.RED);
                        c3.setForeground(Color.RED);
                        c4.setForeground(Color.RED);
                        c5.setForeground(Color.RED);
                    }
                    else if (selected < 3 && turn==2) {
                        asI.setOpaque(true);
                        asI.setBackground(Color.RED);
                        ab.setEnabled(false);
                        p2.assassin = new Assassin();
                        m2.put("assassin",p2.assassin);
                        p2.chosen[selected] = p2.assassin;
                        switch (selected){
                            case 0:
                                p21d.setIcon(p2asi);
                                p2s1.setText("assassin");
                                p21h.setIcon(p2asi);
                                p21f.setIcon(p2asi);
                                p2d1.setText(p2.chosen[selected].Class);
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                Player21.setText("assassin");
                                Player21.setVisible(true);
                                chardb1.setText("assassin");
                                charhb1.setText("assassin");
                                charfb1.setText("assassin");
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                p2s2.setText("assassin");
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                Player22.setText("assassin");
                                Player22.setVisible(true);
                                p22d.setIcon(p2asi);
                                p22h.setIcon(p2asi);
                                p22f.setIcon(p2asi);
                                chardb2.setText("assassin");
                                charhb2.setText("assassin");
                                charfb2.setText("assassin");
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                p2s3.setText("assassin");
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                Player23.setText("assassin");
                                Player23.setVisible(true);
                                p23d.setIcon(p2asi);
                                p23h.setIcon(p2asi);
                                p23f.setIcon(p2asi);
                                chardb3.setText("assassin");
                                charhb3.setText("assassin");
                                charfb3.setText("assassin");
                            default:
                        }
                        selected++;
                        if(selected >0){
                            Undo.setEnabled(false);
                            Undo.setVisible(false);
                            Undo2.setEnabled(true);
                            Undo2.setVisible(true);
                        }
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });


        hI.setBounds(600, 250,150,150);
        pane3.add(hI,JLayeredPane.DRAG_LAYER);
        hI.setBackground(null);
        hI.setOpaque(false);
        hI.setVisible(true);

        hb.setVisible(true);
        hb.setEnabled(true);
        hb.setBounds(600, 250, 150, 150);
        hb.addActionListener(this);
        hb.setText("Healer");
        hb.setFocusable(false);
        hb.setFont(new Font("Comic Sans", Font.BOLD,35));
        hb.setBorder(BorderFactory.createCompoundBorder());
        pane3.add(hb,JLayeredPane.DEFAULT_LAYER);
        hb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == hb ) {
                    try{
                            playBuff();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    if (selected < 3 && turn==1) {
                        Undo.setEnabled(true);
                        Undo.setVisible(true);
                        hI.setOpaque(true);
                        hI.setBackground(Color.BLUE);
                        hb.setEnabled(false);
                        p1.healer = new Healer();
                        m1.put("healer",p1.healer);
                        p1.chosen[selected] = p1.healer;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                p1s1.setText("healer");
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                Player11.setText("healer");
                                Player11.setVisible(true);
                                p11d.setIcon(p1hi);
                                p11h.setIcon(p1hi);
                                p11f.setIcon(p1hi);
                                charda1.setText("healer");
                                charha1.setText("healer");
                                charfa1.setText("healer");
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                p1s2.setText("healer");
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP));  
                                p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));  
                                Player12.setText("healer");
                                Player12.setVisible(true);
                                p12d.setIcon(p1hi);
                                p12h.setIcon(p1hi);
                                p12f.setIcon(p1hi);
                                charda2.setText("healer");
                                charha2.setText("healer");
                                charfa2.setText("healer");
                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                p1s3.setText("healer");
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                Player13.setText("healer");
                                Player13.setVisible(true);
                                p13d.setIcon(p1hi);
                                p13h.setIcon(p1hi);
                                p13f.setIcon(p1hi);
                                charda3.setText("healer");
                                charha3.setText("healer");
                                charfa3.setText("healer");
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp ){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose 3 Heroes");
                        aI.setBackground(null);
                        asI.setBackground(null);
                        hI.setBackground(null);
                        sI.setBackground(null);
                        tI.setBackground(null);
                        aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                        aI.setIcon(p2ai);
                        asI.setIcon(p2asi);
                        hI.setIcon(p2hi);
                        sI.setIcon(p2si);
                        tI.setIcon(p2ti);
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                        c1.setForeground(Color.RED);
                        c2.setForeground(Color.RED);
                        c3.setForeground(Color.RED);
                        c4.setForeground(Color.RED);
                        c5.setForeground(Color.RED);
                    }
                    else if (selected < 3 && turn==2) {
                        hb.setEnabled(false);
                        hI.setOpaque(true);
                        hI.setBackground(Color.RED);
                        p2.healer = new Healer();
                        m2.put("healer",p2.healer);
                        p2.chosen[selected] = p2.healer;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                p2s1.setText("healer");
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                Player21.setText("healer");
                                Player21.setVisible(true);
                                p21d.setIcon(p2hi);
                                p21h.setIcon(p2hi);
                                p21f.setIcon(p2hi);
                                chardb1.setText("healer");
                                charhb1.setText("healer");
                                charfb1.setText("healer");
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                p2s2.setText("healer");
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                Player22.setText("healer");
                                Player22.setVisible(true);
                                p22d.setIcon(p2hi);
                                p22h.setIcon(p2hi);
                                p22f.setIcon(p2hi);
                                chardb2.setText("healer");
                                charhb2.setText("healer");
                                charfb2.setText("healer");

                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                fb3.setText(p2.chosen[selected].Class);
                                p2s3.setText("healer");
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                Player23.setText("healer");
                                Player23.setVisible(true);
                                p23d.setIcon(p2hi);
                                p23h.setIcon(p2hi);
                                p23f.setIcon(p2hi);
                                chardb3.setText("healer");
                                charhb3.setText("healer");
                                charfb3.setText("healer");
                            default:
                        }
                        selected++;
                        if(selected >0){
                            Undo.setEnabled(false);
                            Undo.setVisible(false);
                            Undo2.setEnabled(true);
                            Undo2.setVisible(true);
                        }
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        sI.setBounds(800, 250, 150, 150);
        pane3.add(sI,JLayeredPane.DRAG_LAYER);
        sI.setBackground(null);
        sI.setOpaque(false);
        sI.setVisible(true);

        sb.setVisible(true);
        sb.setEnabled(true);
        sb.setBounds(800, 250, 150, 150);
        sb.addActionListener(this);
        sb.setText("Support");
        sb.setFocusable(false);
        sb.setFont(new Font("Comic Sans", Font.BOLD,35));
        sb.setBorder(BorderFactory.createCompoundBorder());
        pane3.add(sb,JLayeredPane.DEFAULT_LAYER);
        
        sb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sb ) {
                    try{
                            playBuff();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    if (selected < 3 && turn==1) {
                        Undo.setEnabled(true);
                        Undo.setVisible(true);
                        sI.setOpaque(true);
                        sI.setBackground(Color.BLUE);
                        sb.setEnabled(false);
                        p1.support = new Support();
                        m1.put("support",p1.support);
                        p1.chosen[selected] = p1.support;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                p1s1.setText("support");
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                Player11.setText("support");
                                Player11.setVisible(true);
                                p11d.setIcon(p1si);
                                p11h.setIcon(p1si);
                                p11f.setIcon(p1si);
                                charda1.setText("support");
                                charha1.setText("support");
                                charfa1.setText("support");
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                p1s2.setText("support");
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                Player12.setText("support");
                                Player12.setVisible(true);
                                p12d.setIcon(p1si);
                                p12h.setIcon(p1si);
                                p12f.setIcon(p1si);
                                charda2.setText("support");
                                charha2.setText("support");
                                charfa2.setText("support");

                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                p1s3.setText("support");
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                Player13.setText("support");
                                Player13.setVisible(true);
                                p13d.setIcon(p1si);
                                p13h.setIcon(p1si);
                                p13f.setIcon(p1si);
                                charda3.setText("support");
                                charha3.setText("support");
                                charfa3.setText("support");
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp){
                        selected = 0;
                        pvpPanel3Label.setText("Player 2 Choose 3 Heroes");
                        aI.setBackground(null);
                        asI.setBackground(null);
                        hI.setBackground(null);
                        sI.setBackground(null);
                        tI.setBackground(null);
                        aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                        aI.setIcon(p2ai);
                        asI.setIcon(p2asi);
                        hI.setIcon(p2hi);
                        sI.setIcon(p2si);
                        tI.setIcon(p2ti);
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                        c1.setForeground(Color.RED);
                        c2.setForeground(Color.RED);
                        c3.setForeground(Color.RED);
                        c4.setForeground(Color.RED);
                        c5.setForeground(Color.RED);
                    }
                    else if (selected < 3 && turn==2) {
                        sb.setEnabled(false);
                        sI.setOpaque(true);
                        sI.setBackground(Color.RED);
                        p2.support = new Support();
                        m2.put("support",p2.support);
                        p2.chosen[selected] = p2.support;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                p2s1.setText("support");
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                Player21.setText("support");
                                Player21.setVisible(true);
                                p21d.setIcon(p2si);
                                p21h.setIcon(p2si);
                                p21f.setIcon(p2si);
                                chardb1.setText("support");
                                charhb1.setText("support");
                                charfb1.setText("support");
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                p2s2.setText("support");
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                Player22.setText("support");
                                Player22.setVisible(true);
                                p22d.setIcon(p2si);
                                p22h.setIcon(p2si);
                                p22f.setIcon(p2si);
                                chardb2.setText("support");
                                charhb2.setText("support");
                                charfb2.setText("support");
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                p2s3.setText("support");
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                Player23.setText("support");
                                Player23.setVisible(true);
                                p23d.setIcon(p2si);
                                p23h.setIcon(p2si);
                                p23f.setIcon(p2si);
                                chardb3.setText("support");
                                charhb3.setText("support");
                                charfb3.setText("support");
                            default:
                        }
                        selected++;
                        if(selected >0){
                            Undo.setEnabled(false);
                            Undo.setVisible(false);
                            Undo2.setEnabled(true);
                            Undo2.setVisible(true);
                        }
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });

        tb.setVisible(true);
        tb.setEnabled(true);
        tb.setBounds(1000, 250, 150, 150);

        tI.setBounds(1000, 250, 150, 150);
        pane3.add(tI,JLayeredPane.DRAG_LAYER);
        tI.setBackground(null);
        tI.setOpaque(false);
        tI.setVisible(true);

        tb.addActionListener(this);
        tb.setText("Tank");
        tb.setFocusable(false);
        tb.setFont(new Font("Comic Sans", Font.BOLD,35));
        tb.setBorder(BorderFactory.createCompoundBorder());
        pane3.add(tb,JLayeredPane.DEFAULT_LAYER);
        tb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tb ) {
                    try{
                            playBuff();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    if (selected < 3 && turn==1) {
                        Undo.setEnabled(true);
                        tI.setOpaque(true);
                        Undo.setVisible(true);
                        tI.setBackground(Color.BLUE);
                        tb.setEnabled(false);
                        p1.tank = new Tank();
                        m1.put("tank",p1.tank);
                        p1.chosen[selected] = p1.tank;
                        switch (selected){
                            case 0:
                                p1d1.setText(p1.chosen[selected].Class);
                                p1s1.setText("tank");
                                fa1.setText(p1.chosen[selected].Class);
                                HA1.setText(p1.chosen[selected].Class);
                                p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                Player11.setText("tank");
                                Player11.setVisible(true);
                                p11d.setIcon(p1ti);
                                p11h.setIcon(p1ti);
                                p11f.setIcon(p1ti);
                                charda1.setText("tank");
                                charha1.setText("tank");
                                charfa1.setText("tank");
                                break;
                            case 1:
                                p1d2.setText(p1.chosen[selected].Class);
                                p1s2.setText("tank");
                                fa2.setText(p1.chosen[selected].Class);
                                HA2.setText(p1.chosen[selected].Class);
                                p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP)); 
                                p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));         
                                Player12.setText("tank");
                                Player12.setVisible(true);
                                p12d.setIcon(p1ti);
                                p12h.setIcon(p1ti);
                                p12f.setIcon(p1ti);
                                charda2.setText("tank");
                                charha2.setText("tank");
                                charfa2.setText("tank");
                                break;
                            case 2:
                                p1d3.setText(p1.chosen[selected].Class);
                                p1s3.setText("tank");
                                fa3.setText(p1.chosen[selected].Class);
                                HA3.setText(p1.chosen[selected].Class);
                                p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                                Player13.setText("tank");
                                Player13.setVisible(true);
                                p13d.setIcon(p1ti);
                                p13h.setIcon(p1ti);
                                p13f.setIcon(p1ti);
                                charda3.setText("tank");
                                charha3.setText("tank");
                                charfa3.setText("tank");
                            default:
                        }
                        selected++;
                    }
                    if (selected == 3 && turn ==1 && pvp){
                        selected = 0;
                        aI.setOpaque(false);
                        asI.setOpaque(false);
                        hI.setOpaque(false);
                        sI.setOpaque(false);
                        tI.setOpaque(false);
                        aI.setBackground(null);
                        asI.setBackground(null);
                        hI.setBackground(null);
                        sI.setBackground(null);
                        tI.setBackground(null);
                        aI.setIcon(p2ai);
                        asI.setIcon(p2asi);
                        hI.setIcon(p2hi);
                        sI.setIcon(p2si);
                        tI.setIcon(p2ti);

                        pvpPanel3Label.setText("Player 2 Choose 3 Heroes");
                        Ab.setEnabled(true);
                        ab.setEnabled(true);
                        hb.setEnabled(true);
                        sb.setEnabled(true);
                        tb.setEnabled(true);
                        turn = 2;
                        c1.setForeground(Color.RED);
                        c2.setForeground(Color.RED);
                        c3.setForeground(Color.RED);
                        c4.setForeground(Color.RED);
                        c5.setForeground(Color.RED);
                    }
                    else if (selected < 3 && turn==2 ) {
                        tb.setEnabled(false);
                        tI.setOpaque(true);
                        tI.setBackground(Color.RED);
                        p2.tank = new Tank();
                        m2.put("tank",p2.tank);
                        p2.chosen[selected] = p2.tank;
                        switch (selected){
                            case 0:
                                p2d1.setText(p2.chosen[selected].Class);
                                p2s1.setText("tank");
                                fb1.setText(p2.chosen[selected].Class);
                                HB1.setText(p2.chosen[selected].Class);
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                Player21.setText("tank");
                                Player21.setVisible(true);
                                p21d.setIcon(p2ti);
                                p21h.setIcon(p2ti);
                                p21f.setIcon(p2ti);
                                chardb1.setText("tank");
                                charhb1.setText("tank");
                                charfb1.setText("tank");
                                break;
                            case 1:
                                p2d2.setText(p2.chosen[selected].Class);
                                p2s2.setText("tank");
                                fb2.setText(p2.chosen[selected].Class);
                                HB2.setText(p2.chosen[selected].Class);
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                Player22.setText("tank");
                                Player22.setVisible(true);
                                p22d.setIcon(p2ti);
                                p22h.setIcon(p2ti);
                                p22f.setIcon(p2ti);
                                chardb2.setText("tank");
                                charhb2.setText("tank");
                                charfb2.setText("tank");
                                break;
                            case 2:
                                p2d3.setText(p2.chosen[selected].Class);
                                p2s3.setText("tank");
                                fb3.setText(p2.chosen[selected].Class);
                                HB3.setText(p2.chosen[selected].Class);
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                Player23.setText("tank");
                                Player23.setVisible(true);
                                p23d.setIcon(p2ti);
                                p23h.setIcon(p2ti);
                                p23f.setIcon(p2ti);
                                chardb3.setText("tank");
                                charhb3.setText("tank");
                                charfb3.setText("tank");
                            default:
                        }
                        selected++;
                        if(selected >0){
                            Undo.setEnabled(false);
                            Undo.setVisible(false);
                            Undo2.setEnabled(true);
                            Undo2.setVisible(true);
                        }
                    }
                    if (selected == 3){
                        NextB2.setEnabled(true);
                    }
                }
            }
        });


             
        defendPane.add(defendPanelLabel,JLayeredPane.DRAG_LAYER);
        defendPane.add(p1life1l,JLayeredPane.DRAG_LAYER);
        defendPane.add(p1life2l,JLayeredPane.DRAG_LAYER);
        defendPane.add(p1life3l,JLayeredPane.DRAG_LAYER);
        defendPane.add(p2life1l,JLayeredPane.DRAG_LAYER);
        defendPane.add(p2life2l,JLayeredPane.DRAG_LAYER);
        defendPane.add(p2life3l,JLayeredPane.DRAG_LAYER);
        
        defendPane.add(charda1,JLayeredPane.DRAG_LAYER);
        defendPane.add(charda2,JLayeredPane.DRAG_LAYER);
        defendPane.add(charda3,JLayeredPane.DRAG_LAYER);
        defendPane.add(chardb1,JLayeredPane.DRAG_LAYER);
        defendPane.add(chardb2,JLayeredPane.DRAG_LAYER);
        defendPane.add(chardb3,JLayeredPane.DRAG_LAYER);
        defendPane.add(bgd,JLayeredPane.DEFAULT_LAYER);
        defendPane.add(p1d1,JLayeredPane.DEFAULT_LAYER);
        defendPane.add(p1d2,JLayeredPane.DEFAULT_LAYER);
        defendPane.add(p1d3,JLayeredPane.DEFAULT_LAYER);
        defendPane.add(p2d1,JLayeredPane.DEFAULT_LAYER);
        defendPane.add(p2d2,JLayeredPane.DEFAULT_LAYER);
        defendPane.add(p2d3,JLayeredPane.DEFAULT_LAYER);   

        p11d.setBounds(410, 270,100,100);
        defendPane.add(p11d,JLayeredPane.DRAG_LAYER);
        p11d.setBackground(null);
        p11d.setOpaque(true);
        p11d.setVisible(true);

        p12d.setBounds(560, 350,100,100);
        defendPane.add(p12d,JLayeredPane.DRAG_LAYER);
        p12d.setBackground(null);
        p12d.setOpaque(true);
        p12d.setVisible(true);

        p13d.setBounds(410, 430,100,100);
        defendPane.add(p13d,JLayeredPane.DRAG_LAYER);
        p13d.setBackground(null);
        p13d.setOpaque(true);
        p13d.setVisible(true);

        p21d.setBounds(1100, 270,100,100);
        defendPane.add(p21d,JLayeredPane.DRAG_LAYER);
        p21d.setBackground(null);
        p21d.setOpaque(true);
        p21d.setVisible(true);

        p22d.setBounds(950, 350,100,100);
        defendPane.add(p22d,JLayeredPane.DRAG_LAYER);
        p22d.setBackground(null);
        p22d.setOpaque(true);
        p22d.setVisible(true);

        p23d.setBounds(1100, 430,100,100);
        defendPane.add(p23d,JLayeredPane.DRAG_LAYER);
        p23d.setBackground(null);
        p23d.setOpaque(true);
        p23d.setVisible(true);

        	
        charda1.setForeground(Color.BLUE);
        charda1.setVisible(true);
        charda1.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);

	
        charda2.setForeground(Color.BLUE);
        charda2.setVisible(true);
        charda2.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);

	
        charda3.setForeground(Color.BLUE);
        charda3.setVisible(true);
        charda3.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);

	
        chardb1.setForeground(Color.RED);
        chardb1.setVisible(true);
        chardb1.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);

	
        chardb2.setForeground(Color.RED);
        chardb2.setVisible(true);
        chardb2.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);

	
        chardb3.setForeground(Color.RED);
        chardb3.setVisible(true);
        chardb3.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
        //this.add(defendPanel);
        
        defendPane.setEnabled(false);
        defendPane.setVisible(false);

        defendPanel.setLayout(null);
        defendPanel.setBackground(new Color(100, 60, 140));
        defendPanel.setSize(1600, 800);
        //this.add(defendPanel);
        defendPane.setVisible(false);
        defendPane.setEnabled(false);

        defendPanelLabel.setVisible(true);
        defendPanelLabel.setBounds(500, 50, 1200, 100);
        defendPanelLabel.setFont(new Font("Press Start 2P", Font.BOLD, 60));
        defendPanelLabel.setForeground(new Color(255, 30, 0));
        

        p1life1l.setForeground(Color.GREEN);
        p1life1l.setBounds(50,400,300,50);
        p1life1l.setFont(new Font("Comic Sans", Font.PLAIN,35));   
        p1life1l.setVisible(true);

	    p1life2l.setForeground(Color.GREEN);
        p1life2l.setBounds(150,500,300,50);
        p1life2l.setFont(new Font("Comic Sans", Font.PLAIN,35));    
        p1life2l.setVisible(true);

	    p1life3l.setForeground(Color.GREEN);
        p1life3l.setBounds(50,600,300,50);
        p1life3l.setFont(new Font("Comic Sans", Font.PLAIN,35));    
        p1life3l.setVisible(true);


        p2life1l.setForeground(Color.GREEN);
        p2life1l.setBounds(1050,400,300,50);
        p2life1l.setFont(new Font("Comic Sans", Font.PLAIN,35));   
        p2life1l.setVisible(true);


        p2life2l.setForeground(Color.GREEN);
        p2life2l.setBounds(900,500,300,50);
        p2life2l.setFont(new Font("Comic Sans", Font.PLAIN,35));   
        p2life2l.setVisible(true);


        p2life3l.setForeground(Color.GREEN);
        p2life3l.setBounds(1050,600,300,50);
        p2life3l.setFont(new Font("Comic Sans", Font.PLAIN,35));    
        p2life3l.setVisible(true);

        p1d1.setFocusable(false);
        p1d1.setBounds(410,270,100,100);
        p1d1.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        p1d1.setVisible(true);
        p1d1.setEnabled(true);
        p1d1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p1d1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    D1 = p1d1.getText();
                    p1d1.setBounds(560,350,100,100);
                    p1d2.setBounds(410,270,100,100);
                    p1d3.setBounds(410,430,100,100);
                    p11d.setBounds(560, 350,100,100);
                    p11f.setBounds(560, 350,100,100);
                    p11h.setBounds(560, 350,100,100);

                    p12d.setBounds(410, 270,100,100);
                    p12f.setBounds(410, 270,100,100);
                    p12h.setBounds(410, 270,100,100);

                    p13d.setBounds(410, 430,100,100);
                    p13f.setBounds(410, 430,100,100);
                    p13h.setBounds(410, 430,100,100);

                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charha1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charha2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charha3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charfa1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charfa2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charfa3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);


                    fa1.setBounds(560,350,100,100);
                    fa2.setBounds(410,270,100,100);
                    fa3.setBounds(410,430,100,100);

                    HA1.setBounds(560,350,100,100);
                    HA2.setBounds(410,270,100,100);
                    HA3.setBounds(410,430,100,100);

                    p1d1l.setBounds(570, 295,300,50);
                    p1d2l.setBounds(570, 295,300,50);
                    p1d3l.setBounds(570, 295,300,50);

                    p1a1l.setBounds(570,480,300,50);
                    p1a2l.setBounds(420,400,300,50);
                    p1a3l.setBounds(420,550,300,50);

                    p1life1l.setBounds(570,480,300,50);
                    p1life2l.setBounds(420,400,300,50);
                    p1life3l.setBounds(420,550,300,50);

                    p1health1l.setBounds(570,480,300,50);
                    p1health2l.setBounds(420,400,300,50);
                    p1health3l.setBounds(420,550,300,50);

                    p1d1.setEnabled(false);
                    p1d2.setEnabled(false);
                    p1d3.setEnabled(false);
                    p11d.setBackground(null);
                    p12d.setBackground(null);
                    p13d.setBackground(null);
                    
p11d.setOpaque(false);
p12d.setOpaque(false);
p13d.setOpaque(false);

                    if (pvp && m2.get(D2)== null){
                        defendPanelLabel.setText("Player 2 choose your defending hero");
                        p2d1.setEnabled(true);
                        p2d2.setEnabled(true);
                        p2d3.setEnabled(true);
                        p21d.setBackground(Color.WHITE);
                        p22d.setBackground(Color.WHITE);
                        p23d.setBackground(Color.WHITE);
                        p21d.setOpaque(true);
p22d.setOpaque(true);
p23d.setOpaque(true);
                    }
                    else {
                            if(turn == 2){
                                if (pvp && m2.get(HB1.getText()).HP>0){
                                fb1.setEnabled(true);
                                p21d.setBackground(Color.WHITE);
                            }
                            else{
                                fb1.setEnabled(false);
                                p21d.setBackground(null);
                            }
                            if (m2.get(HB2.getText()).HP>0){
                                fb2.setEnabled(true);
                                p22d.setBackground(Color.WHITE);
                            }
                            else{
                                fb2.setEnabled(false);
                                p22d.setBackground(null);
                            }
                            if (m2.get(HB3.getText()).HP>0){
                                fb3.setEnabled(true);
                                p23d.setBackground(Color.WHITE);
                            }
                            else{
                                fb3.setEnabled(false);
                                p23d.setBackground(null);
                            }
                        }
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                        defendPane.setVisible(false);
                        defendPane.setEnabled(false);
                        fightPane.setEnabled(true);
                        fightPane.setVisible(true);
                    }
                    if(r>1){
                    p1resetd();
                    p2resetd();
                    }
                    
                }
            }
        });

        p1d2.setFocusable(false);
        p1d2.setBounds(560,350,100,100);
        p1d2.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        p1d2.setVisible(true);
        p1d2.setEnabled(true);
        p1d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p1d2){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    D1 = p1d2.getText();
                    p1d1.setBounds(410,270,100,100);
                    p1d2.setBounds(560,350,100,100);
                    p1d3.setBounds(410,430,100,100);       

                    p11d.setBounds(410, 270,100,100);
                    p11f.setBounds(410, 270,100,100);
                    p11h.setBounds(410, 270,100,100);

                    p12d.setBounds(560, 350,100,100);
                    p12f.setBounds(560, 350,100,100);
                    p12h.setBounds(560, 350,100,100);

                    p13d.setBounds(410, 430,100,100);
                    p13f.setBounds(410, 430,100,100);
                    p13h.setBounds(410, 430,100,100);

                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charha1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charha2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charha3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charfa1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charfa2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charfa3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);


                    fa1.setBounds(410,270,100,100);
                    fa2.setBounds(560,350,100,100);
                    fa3.setBounds(410,430,100,100);

                    HA1.setBounds(410,270,100,100);
                    HA2.setBounds(560,350,100,100);
                    HA3.setBounds(410,430,100,100);

                    p1d1l.setBounds(570, 295,300,50);
                    p1d2l.setBounds(570, 295,300,50);
                    p1d3l.setBounds(570, 295,300,50);

                    p1a1l.setBounds(420,400,300,50);
                    p1a2l.setBounds(570,480,300,50);
                    p1a3l.setBounds(420,550,300,50);

                    p1life1l.setBounds(420,400,300,50);
                    p1life2l.setBounds(570,480,300,50);
                    p1life3l.setBounds(420,550,300,50);

                    p1health1l.setBounds(420,400,300,50);
                    p1health2l.setBounds(570,480,300,50);
                    p1health3l.setBounds(420,550,300,50);

                    p1d1.setEnabled(false);
                    p1d2.setEnabled(false);
                    p1d3.setEnabled(false);
                    p11d.setBackground(null);
                    p12d.setBackground(null);
                    p13d.setBackground(null);
                    
p11d.setOpaque(false);
p12d.setOpaque(false);
p13d.setOpaque(false);
                    if (pvp && m2.get(D2)== null) {
                        defendPanelLabel.setText("Player 2 choose your defending hero");
                        p2d1.setEnabled(true);
                        p2d2.setEnabled(true);
                        p2d3.setEnabled(true);
                        p21d.setBackground(Color.WHITE);
                        p22d.setBackground(Color.WHITE);
                        p23d.setBackground(Color.WHITE);
                        p21d.setOpaque(true);
p22d.setOpaque(true);
p23d.setOpaque(true);
                    }
                    else {
                        if(pvp && turn == 2){
                            if (m2.get(HB1.getText()).HP>0){
                                fb1.setEnabled(true);
                                p21d.setBackground(Color.WHITE);
                            }
                            else{
                                fb1.setEnabled(false);
                                p21d.setBackground(null);
                            }
                            if (m2.get(HB2.getText()).HP>0){
                                fb2.setEnabled(true);
                                p22d.setBackground(Color.WHITE);
                            }
                            else{
                                fb2.setEnabled(false);
                                p22d.setBackground(null);
                            }
                            if (m2.get(HB3.getText()).HP>0){
                                fb3.setEnabled(true);
                                p23d.setBackground(Color.WHITE);
                            }
                            else{
                                fb3.setEnabled(false);
                                p23d.setBackground(null);
                            }
                        }
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                        defendPane.setVisible(false);
                        defendPane.setEnabled(false);
                        fightPane.setEnabled(true);
                        fightPane.setVisible(true);
                    }
                    if(r>1){
                        p1resetd();
                        p2resetd();
                    }
                }
            }
        });


        p1d3.setFocusable(false);
        p1d3.setBounds(410,430,100,100);
        p1d3.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        p1d3.setVisible(true);
        p1d3.setEnabled(true);


        p1d3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p1d3){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    D1 = p1d3.getText();
                    p1d1.setBounds(410,270,100,100);
                    p1d2.setBounds(410,430,100,100);
                    p1d3.setBounds(560,350,100,100);

                    

                    p11d.setBounds(410, 270,100,100);
                    p11f.setBounds(410, 270,100,100);
                    p11h.setBounds(410, 270,100,100);



                    p12d.setBounds(410, 430,100,100);
                    p12f.setBounds(410, 430,100,100);
                    p12h.setBounds(410, 430,100,100);

                    p13d.setBounds(560, 350,100,100);
                    p13f.setBounds(560, 350,100,100);
                    p13h.setBounds(560, 350,100,100);

                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charha1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charha2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charha3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charfa1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charfa2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charfa3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40); 
                    

                    fa1.setBounds(410,270,100,100);
                    fa2.setBounds(410,430,100,100);
                    fa3.setBounds(560,350,100,100);

                    HA1.setBounds(410,270,100,100);
                    HA2.setBounds(410,430,100,100);
                    HA3.setBounds(560,350,100,100);

                    p1d1l.setBounds(570, 295,300,50);
                    p1d2l.setBounds(570, 295,300,50);
                    p1d3l.setBounds(570, 295,300,50);

                    p1a1l.setBounds(420,400,300,50);
                    p1a2l.setBounds(420,550,300,50);
                    p1a3l.setBounds(570,480,300,50);

                    p1life1l.setBounds(420,400,300,50);
                    p1life2l.setBounds(420,550,300,50);
                    p1life3l.setBounds(570,480,300,50);

                    p1health1l.setBounds(420,400,300,50);
                    p1health2l.setBounds(420,550,300,50);
                    p1health3l.setBounds(570,480,300,50);;

                    p1d1.setEnabled(false);
                    p1d2.setEnabled(false);
                    p1d3.setEnabled(false);
                    p11d.setBackground(null);
                    p12d.setBackground(null);
                    p13d.setBackground(null);
                    
p11d.setOpaque(false);
p12d.setOpaque(false);
p13d.setOpaque(false);

                    if (pvp && m2.get(D2)== null) {
                        defendPanelLabel.setText("Player 2 choose your defending hero");
                        p2d1.setEnabled(true);
                        p2d2.setEnabled(true);
                        p2d3.setEnabled(true);
                        p21d.setBackground(Color.WHITE);
                        p22d.setBackground(Color.WHITE);
                        p23d.setBackground(Color.WHITE);
                        p21d.setOpaque(true);
p22d.setOpaque(true);
p23d.setOpaque(true);
                    }
                    else {
                        if(pvp && turn == 2){
                            if (m2.get(HB1.getText()).HP>0){
                            fb1.setEnabled(true);
                            p21d.setBackground(Color.WHITE);
                            }
                            else{
                                fb1.setEnabled(false);
                                p21d.setBackground(null);
                            }
                            if (m2.get(HB2.getText()).HP>0){
                                fb2.setEnabled(true);
                                p22d.setBackground(Color.WHITE);
                            }
                            else{
                                fb2.setEnabled(false);
                                p22d.setBackground(null);
                            }
                            if (m2.get(HB3.getText()).HP>0){
                                fb3.setEnabled(true);
                                p23d.setBackground(Color.WHITE);
                            }
                            else{
                                fb3.setEnabled(false);
                                p23d.setBackground(null);
                            }
                        }
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                        defendPane.setVisible(false);
                        defendPane.setEnabled(false);
                        fightPane.setEnabled(true);
                        fightPane.setVisible(true);
                    }
                    if(r>1){
                        p1resetd();
                        p2resetd();
                    }
                }
            }
        });


        p2d1.setFocusable(false);
        p2d1.setBounds(1100,270,100,100);
        p2d1.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        p2d1.setVisible(true);
        p2d1.setEnabled(true);
        p2d1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p2d1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    D2 = p2d1.getText();
                    p2d1.setBounds(950,350,100,100);
                    p2d2.setBounds(1100,270,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(950, 350,100,100);
                    p21f.setBounds(950, 350,100,100);
                    p21h.setBounds(950, 350,100,100);

                    p22d.setBounds(1100, 270,100,100);
                    p22f.setBounds(1100, 270,100,100);
                    p22h.setBounds(1100, 270,100,100);

                    p23d.setBounds(1100, 430,100,100);
                    p23f.setBounds(1100, 430,100,100);
                    p23h.setBounds(1100, 430,100,100);

                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    fb1.setBounds(950,350,100,100);
                    fb2.setBounds(1100,270,100,100);
                    fb3.setBounds(1100,430,100,100);

                    HB1.setBounds(950,350,100,100);
                    HB2.setBounds(1100,270,100,100);
                    HB3.setBounds(1100,430,100,100);

                    p2d1l.setBounds(920,295,300,50);
                    p2d2l.setBounds(920,295,300,50);
                    p2d3l.setBounds(920,295,300,50);

                    p2a1l.setBounds(950,480,300,50);
                    p2a2l.setBounds(1100,400,300,50);
                    p2a3l.setBounds(1100,550,300,50);

                    p2life1l.setBounds(950,480,300,50);
                    p2life2l.setBounds(1100,400,300,50);
                    p2life3l.setBounds(1100,550,300,50);

                    p2health1l.setBounds(950,480,300,50);
                    p2health2l.setBounds(1100,400,300,50);
                    p2health3l.setBounds(1100,550,300,50);

                    p2d1.setEnabled(false);
                    p2d2.setEnabled(false);
                    p2d3.setEnabled(false);
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    defendPane.setVisible(false);
                    defendPane.setEnabled(false);
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);
                    if (turn ==2&& pvp){
                        if (m2.get(HB1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(HB2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(HB3.getText()).HP>0){
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
                    if(r>1){
                        p1resetd();
                        p2resetd();
                    }

                }
            }
        });


        p2d2.setFocusable(false);
        p2d2.setBounds(950,350,100,100);
        p2d2.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        p2d2.setVisible(true);
        p2d2.setEnabled(true);
        p2d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p2d2){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    D2 = p2d2.getText();
                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(950,350,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p21f.setBounds(1100, 270,100,100);
                    p21h.setBounds(1100, 270,100,100);

                    p22d.setBounds(950, 350,100,100);
                    p22f.setBounds(950, 350,100,100);
                    p22h.setBounds(950, 350,100,100);

                    p23d.setBounds(1100, 430,100,100);
                    p23f.setBounds(1100, 430,100,100);
                    p23h.setBounds(1100, 430,100,100);

                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    fb1.setBounds(1100,270,100,100);
                    fb2.setBounds(950,350,100,100);
                    fb3.setBounds(1100,430,100,100);

                    HB1.setBounds(1100,270,100,100);
                    HB2.setBounds(950,350,100,100);
                    HB3.setBounds(1100,430,100,100);

                    p2d1l.setBounds(920,295,300,50);
                    p2d2l.setBounds(920,295,300,50);
                    p2d3l.setBounds(920,295,300,50);

                    p2a1l.setBounds(1100,400,300,50);
                    p2a2l.setBounds(950,480,300,50);
                    p2a3l.setBounds(1100,550,300,50);

                    p2life1l.setBounds(1100,400,300,50);
                    p2life2l.setBounds(950,480,300,50);
                    p2life3l.setBounds(1100,550,300,50);

                    p2health1l.setBounds(1100,400,300,50);
                    p2health2l.setBounds(950,480,300,50);
                    p2health3l.setBounds(1100,550,300,50);

                    
                    p2d1.setEnabled(false);
                    p2d2.setEnabled(false);
                    p2d3.setEnabled(false);

                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    defendPane.setVisible(false);
                    defendPane.setEnabled(false);
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);
                    if (turn ==2 && pvp){
                        if (m2.get(HB1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(HB2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(HB3.getText()).HP>0){
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
                    if(r>1){
                        p1resetd();
                        p2resetd();
                    }
                }
            }
        });


        p2d3.setFocusable(false);
        p2d3.setBounds(1100,430,100,100);
        p2d3.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        p2d3.setVisible(true);
        p2d3.setEnabled(true);
        p2d3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== p2d3){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    D2 = p2d3.getText();
                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(1100,430,100,100);
                    p2d3.setBounds(950,350,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p21f.setBounds(1100, 270,100,100);
                    p21h.setBounds(1100, 270,100,100);

                    p22d.setBounds(1100, 430,100,100);
                    p22f.setBounds(1100, 430,100,100);
                    p22h.setBounds(1100, 430,100,100);

                    p23d.setBounds(950, 350,100,100);
                    p23f.setBounds(950, 350,100,100);
                    p23h.setBounds(950, 350,100,100);

                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    fb1.setBounds(1100,270,100,100);
                    fb2.setBounds(1100,430,100,100);
                    fb3.setBounds(950,350,100,100);

                    HB1.setBounds(1100,270,100,100);
                    HB2.setBounds(1100,430,100,100);
                    HB3.setBounds(950,350,100,100);

                    p2d1l.setBounds(920,295,300,50);
                    p2d2l.setBounds(920,295,300,50);
                    p2d3l.setBounds(920,295,300,50);

                    p2a1l.setBounds(1100,400,300,50);
                    p2a2l.setBounds(1100,550,300,50);
                    p2a3l.setBounds(950,480,300,50);

                    p2life1l.setBounds(1100,400,300,50);
                    p2life2l.setBounds(1100,550,300,50);
                    p2life3l.setBounds(950,480,300,50);

                    p2health1l.setBounds(1100,400,300,50);
                    p2health2l.setBounds(1100,550,300,50);
                    p2health3l.setBounds(950,480,300,50);

                    p2d1.setEnabled(false);
                    p2d2.setEnabled(false);
                    p2d3.setEnabled(false);

                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    defendPane.setVisible(false);
                    defendPane.setEnabled(false);
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);
                    if (turn ==2 && pvp){
                        if (m2.get(HB1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(HB2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(HB3.getText()).HP>0){
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
                    if(r>1){
                        p1resetd();
                        p2resetd();
                    }
                }
            }
        });

        fightPanel.setLayout(null);
        fightPanel.setBackground(new Color(100, 60, 140));
        fightPanel.setSize(1600, 800);
        //this.add(fightPanel);
        fightPane.setVisible(false);
        fightPane.setEnabled(false);

        fightPanelLabel.setBounds(400, 50, 1200, 100);
        fightPanelLabel.setFont(new Font("Press Start 2P", Font.BOLD, 60));
        fightPanelLabel.setForeground(new Color(255, 30, 0));
        fightPanelLabel.setVisible(true);

        bg3.setSize(1600,800);
        bg3.setLayout(null);
        bg3.setBackground(new Color(100, 60, 140));
        bg3.setVisible(true);
        bg3.setOpaque(true);

        bg3.setIcon(bg3Icon);

        bgw.setSize(1600,800);
        bgw.setLayout(null);
        bgw.setBackground(new Color(100, 60, 140));
        bgw.setVisible(true);
        bgw.setOpaque(true);
        bgw.setIcon(sky);

        fightPane.add(bg3, JLayeredPane.DEFAULT_LAYER);
        fightPane.add(fightPanelLabel,JLayeredPane.DRAG_LAYER);
        fightPane.add(fa1,JLayeredPane.DEFAULT_LAYER);
        fightPane.add(fa2,JLayeredPane.DEFAULT_LAYER);
        fightPane.add(fa3,JLayeredPane.DEFAULT_LAYER);
        fightPane.add(fb1,JLayeredPane.DEFAULT_LAYER);
        fightPane.add(fb2,JLayeredPane.DEFAULT_LAYER);
        fightPane.add(charfa1,JLayeredPane.DRAG_LAYER);
        fightPane.add(charfa2,JLayeredPane.DRAG_LAYER);
        fightPane.add(charfa3,JLayeredPane.DRAG_LAYER);
        fightPane.add(charfb1,JLayeredPane.DRAG_LAYER);
        fightPane.add(charfb2,JLayeredPane.DRAG_LAYER);
        fightPane.add(charfb3,JLayeredPane.DRAG_LAYER);
        
        
        charfa1.setForeground(Color.BLUE);
        charfa1.setVisible(true);
        charfa1.setFont(new Font("Press Start 2P",Font.PLAIN,20));


        charfa2.setForeground(Color.BLUE);
        charfa2.setVisible(true);
        charfa2.setFont(new Font("Press Start 2P",Font.PLAIN,20));


        charfa3.setForeground(Color.BLUE);
        charfa3.setVisible(true);
        charfa3.setFont(new Font("Press Start 2P",Font.PLAIN,20));


        charfb1.setForeground(Color.RED);
        charfb1.setVisible(true);
        charfb1.setFont(new Font("Press Start 2P",Font.PLAIN,20));
        charfb1.setBounds(230, 400, 100, 40);


        charfb2.setForeground(Color.RED);
        charfb2.setVisible(true);
        charfb2.setFont(new Font("Press Start 2P",Font.PLAIN,20));

        charfb3.setForeground(Color.RED);
        charfb3.setVisible(true);
        charfb3.setFont(new Font("Press Start 2P",Font.PLAIN,20));

        fa1.setFocusable(false);
        fa1.setBounds(410,270,100,100);
        fa1.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        fa1.setVisible(true);
        fa1.setEnabled(true);
        fa1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fa1) {
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    p2reset();
                    p1resetd();
                    p2resetd();
                    p11f.setBackground(Color.BLUE);
                    p11f.setOpaque(true);
                    p12f.setOpaque(false);
                    p13f.setOpaque(false);
                    p12f.setBackground(null);
                    p13f.setBackground(null);
                    
                    p1p1.setVisible(true);
                    p1p1.setEnabled(true);

                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    p2d1l.setForeground(Color.RED);
                    p2d2l.setForeground(Color.RED);
                    p2d3l.setForeground(Color.RED);

                    bleed1.setVisible(false);
                    bleed2.setVisible(false);
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
                    if(fa1.getText().equals("healer")){
                        if (r%2==0){
                            if((m1.get(HA1.getText()).HP == 0 || m1.get(HA1.getText()).HP == m1.get(HA1.getText()).cHP)&&(m1.get(HA2.getText()).HP == 0 || m1.get(HA2.getText()).HP == m1.get(HA2.getText()).cHP)&&(m1.get(HA3.getText()).HP == 0 || m1.get(HA3.getText()).HP == m1.get(HA3.getText()).cHP)){
                                s.setEnabled(false);
                            }
                        }
                        if(m1.get(HA1.getText()).Energy>=100){
                            if(m1.get(HA1.getText()).HP == m1.get(HA1.getText()).cHP&& m1.get(HA2.getText()).HP == m1.get(HA2.getText()).cHP && m1.get(HA3.getText()).HP == m1.get(HA3.getText()).cHP){
                                S.setEnabled(false);
                            }
                        }
                    }
                }
            }
        });

        fa2.setFocusable(false);
        fa2.setBounds(560,350,100,100);
        fa2.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        fa2.setVisible(true);
        fa2.setEnabled(true);
        fa2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fa2) {
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    p1resetd();
                    p2resetd();
                    p2reset();
                    if(pvp&&p2.FindSupport()&&p2.support.nerfs>0){
                        try{
                            nerfp1();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        }  
                        
                    }
                    else{
                        p1reset();
                    }
                    p12f.setBackground(Color.BLUE);
                    p12f.setOpaque(true);
                    p11f.setOpaque(false);
                    p13f.setOpaque(false);
                    p11f.setBackground(null);
                    p13f.setBackground(null);

                    p1p2.setVisible(true);
                    p1p2.setEnabled(true);

                    bleed1.setVisible(false);
                    bleed2.setVisible(false);

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
                    if(fa2.getText().equals("healer")){
                        if (r%2==0){
                            if((m1.get(HA1.getText()).HP == 0 || m1.get(HA1.getText()).HP == m1.get(HA1.getText()).cHP)&&(m1.get(HA2.getText()).HP == 0 || m1.get(HA2.getText()).HP == m1.get(HA2.getText()).cHP)&&(m1.get(HA3.getText()).HP == 0 || m1.get(HA3.getText()).HP == m1.get(HA3.getText()).cHP)){
                                s.setEnabled(false);
                            }
                        }
                        if(m1.get(HA2.getText()).Energy>=100){
                            if(m1.get(HA1.getText()).HP == m1.get(HA1.getText()).cHP&& m1.get(HA2.getText()).HP == m1.get(HA2.getText()).cHP && m1.get(HA3.getText()).HP == m1.get(HA3.getText()).cHP){
                                S.setEnabled(false);
                            }
                        }
                    }
                }
            }
        });


        fa3.setFocusable(false);
        fa3.setBounds(410,430,100,100);
        fa3.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        fa3.setVisible(true);
        fa3.setEnabled(true);
        fa3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fa3) {
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    p1resetd();
                    p2resetd();
                    p2reset();
                    if(pvp&&p2.FindSupport()&&p2.support.nerfs>0){
                        try{
                            nerfp1();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        }  
                        
                    }
                    else{
                        p1reset();
                    }
                    p13f.setBackground(Color.BLUE);
                    p13f.setOpaque(true);
                    p12f.setOpaque(false);
                    p11f.setOpaque(false);
                    p12f.setBackground(null);
                    p11f.setBackground(null);
                    
                    p1p3.setVisible(true);
                    p1p3.setEnabled(true);

                    bleed1.setVisible(false);
                    bleed2.setVisible(false);

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
                    if (m1.get(fa3.getText()).Energy<100){
                        S.setEnabled(false);
                    }
                    else{
                        S.setEnabled(true);
                    }
                    if(fa3.getText().equals("healer")){
                        if (r%2==0){
                            if((m1.get(HA1.getText()).HP == 0 || m1.get(HA1.getText()).HP == m1.get(HA1.getText()).cHP)&&(m1.get(HA2.getText()).HP == 0 || m1.get(HA2.getText()).HP == m1.get(HA2.getText()).cHP)&&(m1.get(HA3.getText()).HP == 0 || m1.get(HA3.getText()).HP == m1.get(HA3.getText()).cHP)){
                                s.setEnabled(false);
                            }
                        }
                        if(m1.get(HA3.getText()).Energy>=100){
                            if(m1.get(HA1.getText()).HP == m1.get(HA1.getText()).cHP&& m1.get(HA2.getText()).HP == m1.get(HA2.getText()).cHP && m1.get(HA3.getText()).HP == m1.get(HA3.getText()).cHP){
                                S.setEnabled(false);
                            }
                        }
                    }
                }
            }
        });

        fb1.setFocusable(false);
        fb1.setBounds(1100,270,100,100);
        fb1.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        fb1.setVisible(true);
        fb1.setEnabled(true);
        fb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fb1) {
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    p1resetd();
                    p2resetd();
                    p1reset();
                    if(p1.FindSupport()&&p1.support.nerfs>0){
                        try{
                            nerfp2();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        }  
    
                        
                    }
                    else{
                        p2reset();
                    }
                    p21f.setBackground(Color.RED);
                    p21f.setOpaque(true);
                    p22f.setOpaque(false);
                    p23f.setOpaque(false);
                    p22f.setBackground(null);
                    p23f.setBackground(null);
                    
            
                    p2p1.setEnabled(true);
                    p2p1.setVisible(true);

                    bleed1.setVisible(false);
                    bleed2.setVisible(false);

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
                    if(fb1.getText().equals("healer")){
                        if (r%2==0){
                            if((m2.get(HB1.getText()).HP == 0 || m2.get(HB1.getText()).HP == m2.get(HB1.getText()).cHP)&&(m2.get(HB2.getText()).HP == 0 || m2.get(HB2.getText()).HP == m2.get(HB2.getText()).cHP)&&(m2.get(HB3.getText()).HP == 0 || m2.get(HB3.getText()).HP == m2.get(HB3.getText()).cHP)){
                                s.setEnabled(false);
                            }
                        }
                        if(m2.get(HB1.getText()).Energy>=100){
                            if(m2.get(HB1.getText()).HP == m2.get(HB1.getText()).cHP&& m2.get(HB2.getText()).HP == m2.get(HB2.getText()).cHP && m2.get(HB3.getText()).HP == m2.get(HB3.getText()).cHP){
                                S.setEnabled(false);
                            }
                        }
                    }
                }
            }
        });


        fb2.setFocusable(false);
        fb2.setBounds(950,350,100,100);
        fb2.setFont(new Font("Comic Sans", Font.BOLD,35));
        
        fb2.setVisible(true);
        fb2.setEnabled(true);
        fb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fb2) {
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    p1resetd();
                    p2resetd();
                    p1reset();
                    if(p1.FindSupport()&&p1.support.nerfs>0){
                        try{
                            nerfp2();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        }  
                        
                    }
                    else{
                        p2reset();
                    }
                    p22f.setBackground(Color.RED);
                    p22f.setOpaque(true);
                    p21f.setOpaque(false);
                    p23f.setOpaque(false);
                    p21f.setBackground(null);
                    p23f.setBackground(null);
                    

                    p2p2.setEnabled(true);
                    p2p2.setVisible(true);

                    bleed1.setVisible(false);
                    bleed2.setVisible(false);

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
                    if(fb2.getText().equals("healer")){
                        if (r%2==0){
                            if((m2.get(HB1.getText()).HP == 0 || m2.get(HB1.getText()).HP == m2.get(HB1.getText()).cHP)&&(m2.get(HB2.getText()).HP == 0 || m2.get(HB2.getText()).HP == m2.get(HB2.getText()).cHP)&&(m2.get(HB3.getText()).HP == 0 || m2.get(HB3.getText()).HP == m2.get(HB3.getText()).cHP)){
                                s.setEnabled(false);
                            }
                        }
                        if(m2.get(HB2.getText()).Energy>=100){
                            if(m2.get(HB1.getText()).HP == m2.get(HB1.getText()).cHP&& m2.get(HB2.getText()).HP == m2.get(HB2.getText()).cHP && m2.get(HB3.getText()).HP == m2.get(HB3.getText()).cHP){
                                S.setEnabled(false);
                            }
                        }
                    }
                }
            }
        });


        fb3.setFocusable(false);
        fb3.setBounds(1100,430,100,100);
        fb3.setFont(new Font("Comic Sans", Font.BOLD,35));
        fightPane.add(fb3);
        fb3.setVisible(true);
        fb3.setEnabled(true);
        fb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fb3) {
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    p1resetd();
                    p2resetd();
                    p1reset();
                    if(p1.FindSupport()&&p1.support.nerfs>0){
                        try{
                            nerfp2();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        }  
    
                        
                    }
                    else{
                        p2reset();
                    }
                    p23f.setBackground(Color.RED);
                    p23f.setOpaque(true);
                    p22f.setOpaque(false);
                    p21f.setOpaque(false);
                    p22f.setBackground(null);
                    p21f.setBackground(null);
                    

                    p2p3.setEnabled(true);
                    p2p3.setVisible(true);

                    bleed1.setVisible(false);
                    bleed2.setVisible(false);

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
                    if(fb3.getText().equals("healer")){
                        if (r%2==0){
                            if((m2.get(HB1.getText()).HP == 0 || m2.get(HB1.getText()).HP == m2.get(HB1.getText()).cHP)&&(m2.get(HB2.getText()).HP == 0 || m2.get(HB2.getText()).HP == m2.get(HB2.getText()).cHP)&&(m2.get(HB3.getText()).HP == 0 || m2.get(HB3.getText()).HP == m2.get(HB3.getText()).cHP)){
                                s.setEnabled(false);
                            }
                        }
                        if(m2.get(HB3.getText()).Energy>=100){
                            if(m2.get(HB1.getText()).HP == m2.get(HB1.getText()).cHP&& m2.get(HB2.getText()).HP == m2.get(HB2.getText()).cHP && m2.get(HB3.getText()).HP == m2.get(HB3.getText()).cHP){
                                S.setEnabled(false);
                            }
                        }
                    }
                }
            }
        });

        p1a1l.setForeground(Color.GREEN);
        p1a1l.setBounds(50,400,300,50);
        p1a1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p1a1l,JLayeredPane.DRAG_LAYER);
        p1a1l.setVisible(true);


        p1a2l.setForeground(Color.GREEN);
        p1a2l.setBounds(150,500,300,50);
        p1a2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p1a2l,JLayeredPane.DRAG_LAYER);
        p1a2l.setVisible(true);


        p1a3l.setForeground(Color.GREEN);
        p1a3l.setBounds(50,600,300,50);
        p1a3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p1a3l,JLayeredPane.DRAG_LAYER);
        p1a3l.setVisible(true);


        p2a1l.setForeground(Color.GREEN);
        p2a1l.setBounds(1050,400,300,50);
        p2a1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p2a1l,JLayeredPane.DRAG_LAYER);
        p2a1l.setVisible(true);


        p2a2l.setForeground(Color.GREEN);
        p2a2l.setBounds(900,500,300,50);
        p2a2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p2a2l,JLayeredPane.DRAG_LAYER);
        p2a2l.setVisible(true);


        p2a3l.setForeground(Color.GREEN);
        p2a3l.setBounds(1050,600,300,50);
        p2a3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p2a3l,JLayeredPane.DRAG_LAYER);
        p2a3l.setVisible(true);

        p1d1l.setForeground(Color.RED);
        p1d1l.setBounds(570, 295,300,50);
        p1d1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p1d1l,JLayeredPane.DRAG_LAYER);
        p1d1l.setVisible(false);


        p1d2l.setForeground(Color.RED);
        p1d2l.setBounds(150,400,300,50);
        p1d2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p1d2l,JLayeredPane.DRAG_LAYER);
        p1d2l.setVisible(false);


        p1d3l.setForeground(Color.RED);
        p1d3l.setBounds(50,500,300,50);
        p1d3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p1d3l,JLayeredPane.DRAG_LAYER);
        p1d3l.setVisible(false);


        p2d1l.setForeground(Color.RED);
        p2d1l.setBounds(920, 295,300,50);
        p2d1l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p2d1l,JLayeredPane.DRAG_LAYER);
        p2d1l.setVisible(false);


        p2d2l.setForeground(Color.RED);
        p2d2l.setBounds(920, 295,300,50);
        p2d2l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p2d2l,JLayeredPane.DRAG_LAYER);
        p2d2l.setVisible(false);


        p2d3l.setForeground(Color.RED);
        p2d3l.setBounds(920, 295,300,50);
        p2d3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(p2d3l,JLayeredPane.DRAG_LAYER);
        p2d3l.setVisible(false);

        freeze1.setText("frozen*");
        freeze1.setForeground(new Color(0,255,255));
        freeze1.setBounds(600,300,300,50);
        freeze1.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(freeze1,JLayeredPane.DRAG_LAYER);
        freeze1.setVisible(false);

        freeze2.setText("frozen*");
        freeze2.setForeground(new Color(0,255,255));
        freeze2.setBounds(900,300,300,50);
        freeze2.setFont(new Font("Comic Sans", Font.PLAIN,35));
        fightPane.add(freeze2,JLayeredPane.DRAG_LAYER);
        freeze2.setVisible(false);

        
        bleed1.setForeground(Color.ORANGE);
        bleed1.setBounds(550,340,100,50);
        bleed1.setFont(new Font("Comic Sans", Font.PLAIN,16));
        fightPane.add(bleed1,JLayeredPane.DRAG_LAYER);
        bleed1.setVisible(false);

	    
        bleed2.setForeground(Color.ORANGE);
        bleed2.setBounds(1050,340,100,50);
        bleed2.setFont(new Font("Comic Sans", Font.PLAIN,16));
        fightPane.add(bleed2,JLayeredPane.DRAG_LAYER);
        bleed2.setVisible(false);

        fightPane.add(n,JLayeredPane.DRAG_LAYER);
        n.setBounds(500,600,100,120);
        n.setText("normal");
        n.setFocusable(false);
        n.setEnabled(true);
        n.setVisible(true);
        n.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== n){
                    p11f.setOpaque(false);
                    p12f.setOpaque(false);
                    p13f.setOpaque(false);
                    p21f.setOpaque(false);
                    p22f.setOpaque(false);
                    p23f.setOpaque(false);
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    p11f.setBackground(null);
                    p12f.setBackground(null);
                    p13f.setBackground(null);
                    p21f.setBackground(null);
                    p22f.setBackground(null);
                    p23f.setBackground(null);
                    p1p1.setEnabled(false);
                    p1p2.setEnabled(false);
                    p1p3.setEnabled(false);
                    p2p1.setEnabled(false);
                    p2p2.setEnabled(false);
                    p2p3.setEnabled(false);
                    freeze1.setVisible(false);
                    freeze2.setVisible(false);
                    rev = false;
                    if (turn == 1){
                        try{
                            p1hit(A1);
                        }
                        catch(IOException ex){
                        ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        }  
                        
                        ;
                        p2reset();
                        turn = 2;
                        if (pvp){
                            fa1.setEnabled(false);
                            fa2.setEnabled(false);
                            fa3.setEnabled(false);
                        }
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
                            p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                            p1.assassin.CutCount--;
                            bleed2.setText("-"+p1.assassin.Bleed);
                            bleed2.setVisible(true);
                        }
                        else{
                            bleed2.setVisible(false);
                        }
                        if (pvp && p2.FindSupport()&& p2.support.nerfs>0){
                            m1.get(A1).Attack -= p2.support.Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            p2.support.nerfs--;
                            //p1reset();
                        }
                        else if (computer != null && computer.FindSupport()&& computer.getSupport().nerfs>0){
                            m1.get(A1).Attack -= computer.getSupport().Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            computer.getSupport().nerfs--;
                            try{
                                nerfp1();
                            }
                            catch(UnsupportedAudioFileException x){
                                x.getStackTrace();
                            }
                            catch(IOException f){
                                f.getStackTrace();
                            }
                            catch(LineUnavailableException g){
                                g.getStackTrace();
                            }
                        }

                        if (p1.FindSupport() && p1.support.up>0){
                            m1.get(A1).Attack += p1.support.Buff();
                            p1.support.up=0;
                            p1reset();
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
                                p1resetd();
                                try{
                                    killp2(A1, D2);
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
                               
                                p1reset();
                                if (m2.get(p2d1.getText()).HP>0){
                                    p2d1.setEnabled(true);
                                    p21d.setBackground(Color.WHITE);
                                }
                                else{
                                    p2d1.setEnabled(false);
                                    p21d.setBackground(null);

                                }
                                if (m2.get(p2d2.getText()).HP>0){
                                    p2d2.setEnabled(true);
                                    p22d.setBackground(Color.WHITE);
                                }
                                else{
                                    p2d2.setEnabled(false);
                                    p22d.setBackground(null);
                                }
                                if (m2.get(p2d3.getText()).HP>0){
                                    p2d3.setEnabled(true);
                                    p23d.setBackground(Color.WHITE);
                                }
                                else{
                                    p2d3.setEnabled(false);
                                    p23d.setBackground(null);

                                }
                               
                                if (p2.alive == 0){
                                    winPanelLabel.setText("Player 1 won!");
                                    winPane.setEnabled(true);
                                    winPane.setVisible(true);
                                }
                                else if((limited&& r <rounds)|| !limited){
                                    defendPanelLabel.setText("Player 2 select defending hero");
                                    defendPane.setEnabled(true);
                                    defendPane.setVisible(true);
                                }
                                fightPane.setVisible(false);
                                fightPane.setEnabled(false);
                            }
                            p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                            p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                            p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                            System.out.println("Player 2 " + D2 + " has " +m2.get(D2).HP + " HP");   
                        }
                        else{
                            String DC = computer.getDef().Class;
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
                            
                            if (m2.get(DC).HP<=0){
                                m2.get(DC).HP = 0;
                                computer.alive--;
                                try{
                                    killp2(A1, D2);
                                    p1hit(A1);
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
            
                                
                                p1resetd();
                                sortButtons();
                                if (computer.alive == 0){
                                    winPanelLabel.setText("Player 1 won!");
                                    winPane.setEnabled(true);
                                    winPane.setVisible(true);
                                    fightPane.setVisible(false);
                                    fightPane.setEnabled(false);
                                }
                            }
                            p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                            p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                            p2a3l.setText(String.valueOf(computer.chosen[2].HP));

                            p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                            p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                            System.out.println("Computer " +computer.getDef().Class  + " has " +computer.getDef().HP + " HP");
                            turn = 2;
                            fightPanelLabel.setText("       Round "+ r);
                            timer2.start();
                        }
                        if(pvp){
                            fightPanelLabel.setText("       Round "+ r+ " Player "+ turn+ " turn");
                        }
                        if (pvp && m2.get(HB1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (pvp && m2.get(HB2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (pvp && m2.get(HB3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                        p1e1.setText("Energy: "+ m1.get(HA1.getText()).Energy);
                        p1attack1.setText("Attack Strength: "+ m1.get(HA1.getText()).Attack);
                        p1e2.setText("Energy: "+ m1.get(HA2.getText()).Energy);
                        p1attack2.setText("Attack Strength: "+ m1.get(HA2.getText()).Attack);
                        p1e3.setText("Energy: "+ m1.get(HA3.getText()).Energy);
                        p1attack3.setText("Attack Strength: "+ m1.get(HA3.getText()).Attack);

                    }
                    else{
                        try{
                            p2hit(A2);
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        }  
                        
                        p1reset();
                        turn = 1;
                        if (pvp &&p2.assassin!=null && p2.assassin.CutCount>0){
                            m1.get(D1).HP-= p2.assassin.Bleed;
                            System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                            bleed1.setText("-"+p2.assassin.Bleed);
                            bleed1.setVisible(true);
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p2.assassin.CutCount--;
                        }
                        else{
                            bleed1.setVisible(false);
                        }
                        if (p1!= null && p1.FindSupport()&& p1.support.nerfs>0){
                            m2.get(A2).Attack -= p1.support.Nerf();
                            System.out.println("Player 2 " +A2+ " was nerfed");
                            p1.support.nerfs--;
                            //p2reset();
                        }
                        if (p2.FindSupport() && p2.support.up>0){
                            m2.get(A2).Attack += p2.support.Buff();
                            p2.support.up=0;
                            p2reset();
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
                        
                        if (m1.get(HA1.getText()).HP>0){
                            fa1.setEnabled(true);
                        }
                        else{
                            fa1.setEnabled(false);
                        }
                        if (m1.get(HA2.getText()).HP>0){
                            fa2.setEnabled(true);
                        }
                        else{
                            fa2.setEnabled(false);
                        }
                        if (m1.get(HA3.getText()).HP>0){
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
                        if (m1.get(D1).HP<=0){
                            m1.get(D1).HP = 0;
                            p1.alive--;
                            p2resetd();
                            try{
                                killp1(A2, D1);
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }  
                            
                            p2reset();
                            if (m1.get(p1d1.getText()).HP>0){
                                p1d1.setEnabled(true);
                                p11d.setBackground(Color.WHITE);
                            }
                            else{
                                p1d1.setEnabled(false);
                                p11d.setBackground(null);
                            }
                            if (m1.get(p1d2.getText()).HP>0){
                                p1d2.setEnabled(true);
                                p12d.setBackground(Color.WHITE);
                            }
                            else{
                                p1d2.setEnabled(false);
                                p12d.setBackground(null);
                            }
                            if (m1.get(p1d3.getText()).HP>0){
                                p1d3.setEnabled(true);
                                p13d.setBackground(Color.WHITE);
                            }
                            else{
                                p1d3.setEnabled(false);
                                p13d.setBackground(null);
                            }
                            
                            if (p1.alive == 0){
                                winPanelLabel.setText("Player 2 won!");
                                winPane.setEnabled(true);
                                winPane.setVisible(true);
                            }
                            else if((limited&& r <rounds)|| !limited){
                                defendPanelLabel.setText("Player 1 select your defending hero");
                                defendPane.setEnabled(true);
                                defendPane.setVisible(true);
                            }
                            fightPane.setVisible(false);
                            fightPane.setEnabled(false);
                        }
                        p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                        p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                        p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                        p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                        p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                        p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                        p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                        p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                        p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                        System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                        r++;
                        fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");

                        p2e1.setText("Energy: "+ m2.get(HB1.getText()).Energy);
                        p2attack1.setText("Attack Strength: "+ m2.get(HB1.getText()).Attack);
                        p2e2.setText("Energy: "+ m2.get(HB2.getText()).Energy);
                        p2attack2.setText("Attack Strength: "+ m2.get(HB2.getText()).Attack);
                        p2e3.setText("Energy: "+ m2.get(HB3.getText()).Energy);
                        p2attack3.setText("Attack Strength: "+ m2.get(HB3.getText()).Attack);
                    }
                    
                    if (pvp&& limited && r == rounds+1){
                        if (p1.alive>p2.alive){
                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            } 
                            winPanelLabel.setText("Player 1 won!");
                        }
                        else if (p1.alive<p2.alive){
                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                            winPanelLabel.setText("Player 2 won!");
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                            try{
                            playDraw();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                        }
                        winPane.setVisible(true);
                        winPane.setEnabled(true);
                        fightPane.setEnabled(false);
                        fightPane.setVisible(false);
                    }

                    
            }
            }
        });

        fightPane.add(s,JLayeredPane.DRAG_LAYER);
        s.setBounds(700,600,100,120);
        s.setText("skill");
        s.setFocusable(false);
        s.setEnabled(true);
        s.setVisible(true);
        s.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== s){
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    p11f.setOpaque(false);
                    p12f.setOpaque(false);
                    p13f.setOpaque(false);
                    p21f.setOpaque(false);
                    p22f.setOpaque(false);
                    p23f.setOpaque(false);
                    p11f.setBackground(null);
                    p12f.setBackground(null);
                    p13f.setBackground(null);
                    p21f.setBackground(null);
                    p22f.setBackground(null);
                    p23f.setBackground(null);
                    p1p1.setEnabled(false);
                    p1p2.setEnabled(false);
                    p1p3.setEnabled(false);
                    p2p1.setEnabled(false);
                    p2p2.setEnabled(false);
                    p2p3.setEnabled(false);

                    freeze1.setVisible(false);
                    freeze2.setVisible(false);
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
                            p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                            p1.assassin.CutCount--;
                            bleed2.setText("-"+p1.assassin.Bleed);
                            bleed2.setVisible(true);
                        }
                        else{
                            bleed2.setVisible(false);
                        }
                        if (pvp && p2.FindSupport()&& p2.support.nerfs>0){
                            m1.get(A1).Attack -= p2.support.Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            p2.support.nerfs--;
                            //p1reset();
                        }
                        else if (computer!= null && computer.FindSupport()&& computer.getSupport().nerfs>0){
                            m1.get(A1).Attack -= computer.getSupport().Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            computer.getSupport().nerfs--;
                        }

                        if (p1.FindSupport() && p1.support.up>0){
                            m1.get(A1).Attack += p1.support.Buff();
                            p1.support.up=0;
                            p1reset();
                            
                        }
                        if(!m1.get(A1).Class.equals("healer")){
                            damage = m1.get(A1).Skill();
                            try{
                                p1hit(A1);
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }  
                            
                            p2reset();
                            if (p1.FindSupport()&& p1.support.nerfs>0){
                                freeze2.setText("nerfed*");
                                freeze2.setForeground(new Color(3,75,3));
                                freeze2.setVisible(true);
                                try{
                                    nerfp2();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
                                
                            }
                            if(p1.FindSupport()&&p1.support.up>0){
                                try{
                                    buffp1();
                                    System.out.println("Player 1 " +A1+ " was buffed");
                                    freeze1.setText("buffed*");
                                    freeze1.setForeground(new Color(255,95,31));
                                    freeze1.setVisible(true);
                                }
                                catch(UnsupportedAudioFileException x){
                                    x.getStackTrace();
                                }
                                catch(IOException f){
                                    f.getStackTrace();
                                }
                                catch(LineUnavailableException g){
                                    g.getStackTrace();
                                }
                            }
                            if (p1.support != null && p1.support.Skips>0){
                                    System.out.println(("Player 2 was frozen"));
                                    freeze2.setText("frozen*");
                                    p1reset();
                                    freeze2.setForeground(new Color(0,255,255));
                                    freeze2.setVisible(true);
                                    turn = 1;
                                    fb1.setEnabled(false);
                                    fb2.setEnabled(false);
                                    fb3.setEnabled(false);
                                    p1.support.Skips = 0;
                                    try{
                                        freezep2();
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                                    
                                    //p1reset();
                                    r++;
                                    if (pvp&&p2.assassin!=null && p2.assassin.CutCount>0){
                                        m1.get(D1).HP-= p2.assassin.Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                                        p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                                        p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                                        p2.assassin.CutCount--;
                                        bleed1.setText("-"+p2.assassin.Bleed);
                                        bleed1.setVisible(true);
                                    }
                                    else if (!pvp&& computer.assassin!=null && computer.assassin.CutCount>0){
                                        m1.get(D1).HP-= computer.assassin.Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+computer.assassin.Bleed);
                                        p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                                        p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                                        computer.assassin.CutCount--;
                                        bleed1.setText("-"+computer.assassin.Bleed);
                                        bleed1.setVisible(true);

                                        
                                    }
                                    if(!pvp){
                                        r--;
                                        if (limited && r == rounds+1){
                                            if (p1.alive>computer.alive){
                                                winPanelLabel.setText("Player 1 won!");
                                                try{
                                                    playWin();
                                                }
                                                catch(IOException ex){
                                                    ex.getStackTrace();
                                                }
                                                catch(UnsupportedAudioFileException g){
                                                    g.getStackTrace();
                                                }
                                                catch(LineUnavailableException f){
                                                    f.getStackTrace();
                                                }
                                            }
                                            else if (p1.alive<computer.alive){
                                                winPanelLabel.setText("Computer won!");
                                                try{
                                                    playWin();
                                                }
                                                catch(IOException ex){
                                                    ex.getStackTrace();
                                                }
                                                catch(UnsupportedAudioFileException g){
                                                    g.getStackTrace();
                                                }
                                                catch(LineUnavailableException f){
                                                    f.getStackTrace();
                                                }
                                            }
                                            else{
                                                winPanelLabel.setText("Draw !");
                                                try{
                                                    playDraw();
                                                }
                                                catch(IOException ex){
                                                    ex.getStackTrace();
                                                }
                                                catch(UnsupportedAudioFileException g){
                                                    g.getStackTrace();
                                                }
                                                catch(LineUnavailableException f){
                                                    f.getStackTrace();
                                                }
                                            }
                                            winPane.setVisible(true);
                                            winPane.setEnabled(true);
                                            fightPane.setEnabled(false);
                                            fightPane.setVisible(false);
                                        }
                    
                                    }
                            else{
                                bleed1.setVisible(false);
                            }
                        }
                    else{
                        if(pvp){
                            fa1.setEnabled(false);
                            fa2.setEnabled(false);
                            fa3.setEnabled(false);
                            if (m2.get(HB1.getText()).HP>0){
                                fb1.setEnabled(true);
                            }
                            else{
                                fb1.setEnabled(false);
                            }
                            if (m2.get(HB2.getText()).HP>0){
                                fb2.setEnabled(true);
                            }
                            else{
                                fb2.setEnabled(false);
                            }
                            if (m2.get(HB3.getText()).HP>0){
                                fb3.setEnabled(true);
                            }
                            else{
                                fb3.setEnabled(false);
                            }
                        }
                        /*else{
                            timer4.start();
                        }*/
                                
                            }
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
                                    p1resetd();
                                    try{
                                        killp2(A1, D2);
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                                    
                                    p1reset();
                                    if (m2.get(p2d1.getText()).HP>0){
                                        p2d1.setEnabled(true);
                                        p21d.setBackground(Color.WHITE);
                                    }
                                    else{
                                        p2d1.setEnabled(false);
                                        p21d.setBackground(null);
                                    }
                                    if (m2.get(p2d2.getText()).HP>0){
                                        p2d2.setEnabled(true);
                                        p22d.setBackground(Color.WHITE);
                                    }
                                    else{
                                        p2d2.setEnabled(false);
                                        p22d.setBackground(null);
                                    }
                                    if (m2.get(p2d3.getText()).HP>0){
                                        p2d3.setEnabled(true);
                                        p23d.setBackground(Color.WHITE);
                                    }
                                    else{
                                        p2d3.setEnabled(false);
                                        p23d.setBackground(null);
                                    }
                                    if (p2.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        winPane.setEnabled(true);
                                        winPane.setVisible(true);
                                    }
                                    else if((limited&& r <rounds)|| !limited){
                                        defendPanelLabel.setText("Player 2 select defending hero");
                                        defendPane.setEnabled(true);
                                        defendPane.setVisible(true);
                                    }
                                    fightPane.setVisible(false);
                                    fightPane.setEnabled(false);
                                }
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
						        p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
						        p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
						        p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
						        p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                System.out.println("Player 2 " + D2 + " has " +m2.get(D2).HP + " HP");
                                if(turn ==2){
                                    
                                    fa1.setEnabled(false);
                                    fa2.setEnabled(false);
                                    fa3.setEnabled(false);
                                }
                                fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");

                            }
                            else{
                                String DC = computer.getDef().Class;
                                System.out.println("Computer " + computer.getDef().Class + " had " +computer.getDef().HP + " HP");
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
                                
                                if (m2.get(DC).HP<= 0){
                                    m2.get(DC).HP = 0;
                                    computer.alive--;
                                    try{
                                        killp2(A1, D2);
                                        p1hit(A1);
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                                    
                                    p1resetd();
                                    sortButtons();
                                    if (computer.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        try{
                                            playWin();
                                        }
                                        catch(IOException ex){
                                            ex.getStackTrace();
                                        }
                                        catch(UnsupportedAudioFileException g){
                                            g.getStackTrace();
                                        }
                                        catch(LineUnavailableException f){
                                            f.getStackTrace();
                                        }
                                        winPane.setEnabled(true);
                                        winPane.setVisible(true);
                                        fightPane.setVisible(false);
                                        fightPane.setEnabled(false);
                                    }
                                }
                                p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                                p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                                p2a3l.setText(String.valueOf(computer.chosen[2].HP));

                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                System.out.println("Computer " + computer.getDef().Class + " has " +computer.getDef().HP + " HP");
                                timer5.start();

                            }        
                        }
                        else {
                            if (m1.get(HA1.getText()).HP>0&& m1.get(HA1.getText()).HP< m1.get(HA1.getText()).cHP){
                                HA1.setEnabled(true);
                                p11h.setOpaque(true);
                                p11h.setBackground(Color.WHITE);
                            }
                            else{
                                HA1.setEnabled(false);
                                p11h.setOpaque(false);
                                p11h.setBackground(null);
                            }
                            if (m1.get(HA2.getText()).HP>0 && m1.get(HA2.getText()).HP< m1.get(HA2.getText()).cHP){
                                HA2.setEnabled(true);
                                p12h.setOpaque(true);
                                p12h.setBackground(Color.WHITE);
                            }
                            else{
                                HA2.setEnabled(false);
                                p12h.setOpaque(false);
                                p12h.setBackground(null);
                            }
                            if (m1.get(HA3.getText()).HP>0&& m1.get(HA3.getText()).HP< m1.get(HA3.getText()).cHP){
                                HA3.setEnabled(true);
                                p13h.setOpaque(true);
                                p13h.setBackground(Color.WHITE);
                            }
                            else{
                                HA3.setEnabled(false);
                                p12h.setOpaque(false);
                                p13h.setBackground(null);
                            }
                            healPane.setEnabled(true);
                            healPane.setVisible(true);

                            
                            fightPane.setEnabled(false);
                            fightPane.setVisible(false);
                            if (pvp&& p2.assassin!= null){
                                p2.assassin.CutCount= 0;
                            }
                            else if (!pvp && computer.FindAssassin()){
                                computer.getAssassin().CutCount= 0;
                            }
                            
                            fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        p1e1.setText("Energy: "+ m1.get(HA1.getText()).Energy);
                        p1attack1.setText("Attack Strength: "+ m1.get(HA1.getText()).Attack);
                        p1e2.setText("Energy: "+ m1.get(HA2.getText()).Energy);
                        p1attack2.setText("Attack Strength: "+ m1.get(HA2.getText()).Attack);
                        p1e3.setText("Energy: "+ m1.get(HA3.getText()).Energy);
                        p1attack3.setText("Attack Strength: "+ m1.get(HA3.getText()).Attack);
                    }
                    else{
                        n.setEnabled(false);
                        s.setEnabled(false);
                        S.setEnabled(false);
                        turn = 1;           
                        if (p2.assassin!=null && p2.assassin.CutCount>0){
                            m1.get(D1).HP-= p2.assassin.Bleed;
                            System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p2.assassin.CutCount--;
                            bleed1.setText("-"+p2.assassin.Bleed);
                            bleed1.setVisible(true);
                        }
                        else{
                            bleed1.setVisible(false);
                        }
                        if (p1.FindSupport()&& p1.support.nerfs>0){
                            m2.get(A2).Attack -= p1.support.Nerf();
                            System.out.println("Player 2 " +A2+ " was nerfed");
                            p1.support.nerfs--;
                            //p2reset();
                        }
                        if (p2.FindSupport() && p2.support.up>0){
                            m2.get(A2).Attack += p2.support.Buff();
                            p2.support.up=0;
                            p1reset();
                            System.out.println("Player 2 " +A2+ " was buffed");
                            
                        }
                        if(!m2.get(A2).Class.equals("healer")){
                            System.out.println("Player 1 " + D1 + " had " +m1.get(D1).HP + " HP");
                            damage = m2.get(A2).Skill();
                            try{
                                p2hit(A2);
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }  
                            
                            p1reset();
                            if (p2.FindSupport()&& p2.support.nerfs>0){
                                freeze1.setText("nerfed*");
                                freeze1.setForeground(new Color(3,75,3));
                                freeze1.setVisible(true);
                                try{
                                    nerfp1();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
                                
                            }
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
                            if (m1.get(D1).HP<=0){
                                m1.get(D1).HP = 0;
                                p1.alive--;
                                p2resetd();
                                try{
                                    killp1(A2, D1);
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }   
                                p2reset();
                                if (m1.get(p1d1.getText()).HP>0){
                                    p1d1.setEnabled(true);
                                    p11d.setBackground(Color.WHITE);
                                }
                                else{
                                    p1d1.setEnabled(false);
                                    p11d.setBackground(null);
                                }
                                if (m1.get(p1d2.getText()).HP>0){
                                    p1d2.setEnabled(true);
                                    p12d.setBackground(Color.WHITE);
                                }
                                else{
                                    p1d2.setEnabled(false);
                                    p12d.setBackground(null);
                                }
                                if (m1.get(p1d3.getText()).HP>0){
                                    p1d3.setEnabled(true);
                                    p13d.setBackground(Color.WHITE);
                                }
                                else{
                                    p1d3.setEnabled(false);
                                    p13d.setBackground(null);
                                }
                                if (p1.alive == 0){
                                    winPanelLabel.setText("Player 2 won!");
                                    winPane.setEnabled(true);
                                    winPane.setVisible(true);
                                }
                                else if((limited&& r <rounds)|| !limited){
                                    defendPanelLabel.setText("Player 1 select your defending hero");
                                    defendPane.setEnabled(true);
                                    defendPane.setVisible(true);
                                }
                                fightPane.setVisible(false);
                                fightPane.setEnabled(false);

                            }
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
							p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
							p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
							p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
							p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                            if (p2.support!= null && p2.support.Skips>0){
                                turn = 2;
                                System.out.println(("Player 1 was frozen"));
                                freeze1.setText("frozen*");
                                freeze1.setForeground(new Color(0,255,255));
                                freeze1.setVisible(true);
                                try{
                                    freezep1();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                } 
                                
                                //p2reset();
                                p2.support.Skips = 0;
                                fa1.setEnabled(false);
                                fa2.setEnabled(false);
                                fa3.setEnabled(false);
                                if (p1.assassin!=null && p1.assassin.CutCount>0){
                                    m2.get(D2).HP-= p1.assassin.Bleed;
                                    System.out.println("Player 2 " + D2 + " is bleeding \t HP -"+p1.assassin.Bleed);
                                    p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                    p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                    p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                    p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                    p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                    p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                    p1.assassin.CutCount--;
                                    bleed2.setText("-"+p1.assassin.Bleed);
                                    bleed2.setVisible(true);
                                }
                                else{
                                    bleed2.setVisible(false);
                                }
                            }
                            else{
                                fb1.setEnabled(false);
                                fb2.setEnabled(false);
                                fb3.setEnabled(false);
                                if (m1.get(HA1.getText()).HP==0){
                                    fa1.setEnabled(false);
                                }
                                else{
                                    fa1.setEnabled(true);
                                }
                                if (m1.get(HA2.getText()).HP== 0){
                                    fa2.setEnabled(false);
                                }
                                else{
                                    fa2.setEnabled(true);
                                }
                                if (m1.get(HA3.getText()).HP== 0){
                                    fa3.setEnabled(false);
                                }
                                else{
                                    fa3.setEnabled(true);
                                }
                            }
                            if(p2.FindSupport()&&p2.support.up>0){
                                try{
                                    buffp2();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }
                                freeze2.setText("buffed*");
                                freeze2.setForeground(new Color(255,95,31));
                                freeze2.setVisible(true);
                            }
                            r++;
                            //fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        else {
                            if (m2.get(HB1.getText()).HP>0&& m2.get(HB1.getText()).HP< m2.get(HB1.getText()).cHP){
                                HB1.setEnabled(true);
                                p21h.setOpaque(true);
                                p21h.setBackground(Color.WHITE);
                            }
                            else{
                                HB1.setEnabled(false);
                                p21h.setOpaque(false);
                                p21h.setBackground(null);
                            }
                            if (m2.get(HB2.getText()).HP>0&& m2.get(HB2.getText()).HP< m2.get(HB2.getText()).cHP){
                                HB2.setEnabled(true);
                                p22h.setOpaque(true);
                                p22h.setBackground(Color.WHITE);
                            }
                            else{
                                HB2.setEnabled(false);
                                p22h.setOpaque(false);
                                p22h.setBackground(null);
                            }
                            if (m2.get(HB3.getText()).HP>0&& m2.get(HB3.getText()).HP< m2.get(HB3.getText()).cHP){
                                HB3.setEnabled(true);
                                p23h.setOpaque(true);
                                p23h.setBackground(Color.WHITE);
                            }
                            else{
                                HB3.setEnabled(false);
                                p23h.setOpaque(false);
                                p23h.setBackground(null);
                            }
                            healPane.setVisible(true);
                            healPane.setEnabled(true);
                            fightPane.setEnabled(false);
                            fightPane.setVisible(false);
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
                            if (m1.get(HA1.getText()).HP==0){
                                fa1.setEnabled(false);
                            }
                            else{
                                fa1.setEnabled(true);
                            }
                            if (m1.get(HA2.getText()).HP== 0){
                                fa2.setEnabled(false);
                            }
                            else{
                                fa2.setEnabled(true);
                            }
                            if (m1.get(HA3.getText()).HP== 0){
                                fa3.setEnabled(false);
                            }
                            else{
                                fa3.setEnabled(true);
                            }
                            
                        }
                        p2e1.setText("Energy: "+ m2.get(HB1.getText()).Energy);
                        p2attack1.setText("Attack Strength: "+ m2.get(HB1.getText()).Attack);
                        p2e2.setText("Energy: "+ m2.get(HB2.getText()).Energy);
                        p2attack2.setText("Attack Strength: "+ m2.get(HB2.getText()).Attack);
                        p2e3.setText("Energy: "+ m2.get(HB3.getText()).Energy);
                        p2attack3.setText("Attack Strength: "+ m2.get(HB3.getText()).Attack);
                    
                    }
                    if (pvp){
                        fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                    }
                    else{
                        fightPanelLabel.setText("       Round "+ r);
                    }
                    if ( pvp && limited && r == rounds+1){
                        if (p1.alive>p2.alive){
                            winPanelLabel.setText("Player 1 won!");
                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                        }
                        else if (p1.alive<p2.alive){
                            winPanelLabel.setText("Player 2 won!");
                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                            try{
                                playDraw();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                        }
                        winPane.setVisible(true);
                        winPane.setEnabled(true);
                        fightPane.setEnabled(false);
                        fightPane.setVisible(false);
                    }
                    
                }
            }
    });

        fightPane.add(S,JLayeredPane.DRAG_LAYER);
        S.setBounds(900,600,100,120);
        S.setText("super");
        S.setEnabled(true);
        S.setVisible(true);
        S.setFocusable(false);
        S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== S){
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    p11f.setOpaque(false);
                    p12f.setOpaque(false);
                    p13f.setOpaque(false);
                    p21f.setOpaque(false);
                    p22f.setOpaque(false);
                    p23f.setOpaque(false);
                    p11f.setBackground(null);
                    p12f.setBackground(null);
                    p13f.setBackground(null);
                    p21f.setBackground(null);
                    p22f.setBackground(null);
                    p23f.setBackground(null);
                    p1p1.setEnabled(false);
                    p1p2.setEnabled(false);
                    p1p3.setEnabled(false);
                    p2p1.setEnabled(false);
                    p2p2.setEnabled(false);
                    p2p3.setEnabled(false);


                    freeze1.setVisible(false);
                    freeze2.setVisible(false);
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
                            p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                            p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                            p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                            p1.assassin.CutCount--;
                            bleed2.setText("-"+p1.assassin.Bleed);
                            bleed2.setVisible(true);
                        }
                        else{
                            bleed2.setVisible(false);
                        }
                        if (computer!= null && computer.FindSupport()&& computer.getSupport().nerfs>0){
                            m1.get(A1).Attack -= computer.getSupport().Nerf();
                            System.out.println("Player 1 " +A1+ " was nerfed");
                            computer.getSupport().nerfs--;
                        }

                        if (p1.FindSupport() && p1.support.up>0){
                            m1.get(A1).Attack += p1.support.Buff();
                            p1.support.up=0;
                            p1reset();

                        }
                        if(!m1.get(A1).Class.equals("healer")){
                            damage = m1.get(A1).Super();
                            try{
                                 p1hit(A1);
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }  
        
                           
                            p2reset();
                            if (p1.FindSupport()&& p1.support.nerfs>0){
                                freeze2.setText("nerfed*");
                                freeze2.setForeground(new Color(3,75,3));
                                freeze2.setVisible(true);
                                try{
                                    nerfp2();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
                                
                            }
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
                                    p1resetd();
                                    try{
                                        killp2(A1, D2);
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                                    p1reset();
                                    if (m2.get(p2d1.getText()).HP>0){
                                        p2d1.setEnabled(true);
                                        p21d.setBackground(Color.WHITE);
                                    }
                                    else{
                                        p2d1.setEnabled(false);
                                        p21d.setBackground(null);
                                    }
                                    if (m2.get(p2d2.getText()).HP>0){
                                        p2d2.setEnabled(true);
                                        p22d.setBackground(Color.WHITE);
                                    }
                                    else{
                                        p2d2.setEnabled(false);
                                        p22d.setBackground(null);
                                    }
                                    if (m2.get(p2d3.getText()).HP>0){
                                        p2d3.setEnabled(true);
                                        p23d.setBackground(Color.WHITE);
                                    }
                                    else{
                                        p2d3.setEnabled(false);
                                        p23d.setBackground(null);
                                    }
                                    
                                    if (p2.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        winPane.setEnabled(true);
                                        winPane.setVisible(true);
                                    }
                                    else if((limited&& r <rounds)|| !limited){
                                        defendPanelLabel.setText("Player 2 select defending hero");
                                        defendPane.setEnabled(true);
                                        defendPane.setVisible(true);
                                    }
                                    fightPane.setVisible(false);
                                    fightPane.setEnabled(false);
                                }
                                p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
								p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
								p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
								p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
								p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                System.out.println("Player 2 " + D2 + " has " +m2.get(D2).HP + " HP");
                                if (p1.support != null && p1.support.Skips>0){
                                    System.out.println(("Player 2 was frozen"));
                                    freeze2.setText("frozen*");
                                    p1reset();
                                    try{
                                        freezep2();
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                
                                    
                                    //p1reset();
                                    freeze2.setForeground(new Color(0,255,255));
                                    freeze2.setVisible(true);
                                    turn = 1;
                                    fb1.setEnabled(false);
                                    fb2.setEnabled(false);
                                    fb3.setEnabled(false);
                                    p1.support.Skips = 0;
                                    r++;
                                    if (p2.assassin!=null && p2.assassin.CutCount>0){
                                        m1.get(D1).HP-= p2.assassin.Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                                        p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                                        p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                                        p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                                        p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                                        p2.assassin.CutCount--;
                                        bleed1.setText("-"+p2.assassin.Bleed);
                                        bleed1.setVisible(true);
                                    }
                                    else{
                                        bleed1.setVisible(false);

                                    }
                                }
                                else{
                                    fa1.setEnabled(false);
                                    fa2.setEnabled(false);
                                    fa3.setEnabled(false);
                                if (m2.get(HB1.getText()).HP>0){
                                        fb1.setEnabled(true);
                                    }
                                    else{
                                        fb1.setEnabled(false);
                                    }
                                    if (m2.get(HB2.getText()).HP>0){
                                        fb2.setEnabled(true);
                                    }
                                    else{
                                        fb2.setEnabled(false);
                                    }
                                    if (m2.get(HB3.getText()).HP>0){
                                        fb3.setEnabled(true);
                                    }
                                    else{
                                        fb3.setEnabled(false);
                                    }
                                }
                                if(p1.FindSupport()&&p1.support.up>0){
                                    try{
                                        buffp1();
                                    }
                                    catch(UnsupportedAudioFileException x){
                                        x.getStackTrace();
                                    }
                                    catch(IOException f){
                                        f.getStackTrace();
                                    }
                                    catch(LineUnavailableException g){
                                        g.getStackTrace();
                                    }
                                    freeze1.setText("buffed*");
                                    freeze1.setForeground(new Color(255,95,31));
                                    freeze1.setVisible(true);
                                }
                                fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                            }
                            else{
                                String DC = computer.getDef().Class;
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
                                if (m2.get(DC).HP< 0){
                                    m2.get(DC).HP = 0;
                                    computer.alive--;
                                    try{
                                        killp2(A1, D2);
                                    p1hit(A1);
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                                    
                                    p1resetd();
                                    sortButtons();
                                    if (computer.alive == 0){
                                        winPanelLabel.setText("Player 1 won!");
                                        winPane.setEnabled(true);
                                        winPane.setVisible(true);
                                        fightPane.setVisible(false);
                                        fightPane.setEnabled(false);
                                    }
                                }
                                p2a1l.setText(String.valueOf(computer.chosen[0].HP));
                                p2a2l.setText(String.valueOf(computer.chosen[1].HP));
                                p2a3l.setText(String.valueOf(computer.chosen[2].HP));

                                p2life1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
								p2life2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
								p2life3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
								p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
								p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));

                                System.out.println("Computer " + computer.getDef().Class + " has " +computer.getDef().HP + " HP");
                                if (p1.FindSupport() && p1.support.nerfs > 0) {
                                    try{
                                        nerfp2();
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                                    
                                }
                                if (p1.support != null && p1.support.Skips>0){
                                    turn =1;
                                    r--;
                                    System.out.println(("computer was frozen"));
                                    freeze2.setText("frozen*");
                                    try{
                                        freezep2();
                                    }
                                    catch(IOException ex){
                                        ex.getStackTrace();
                                    }
                                    catch(UnsupportedAudioFileException g){
                                        g.getStackTrace();
                                    }
                                    catch(LineUnavailableException f){
                                        f.getStackTrace();
                                    }  
                                    
                                    p1reset();
                                    freeze2.setForeground(new Color(0,255,255));
                                    freeze2.setVisible(true);
                                    p1.support.Skips = 0;
                                    r++;
                                    fightPanelLabel.setText("       Round "+ r);
                                    if (computer.FindAssassin() && computer.getAssassin().CutCount>0){
                                        m1.get(D1).HP-= computer.getAssassin().Bleed;
                                        System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+computer.getAssassin().Bleed);
                                        computer.getAssassin().CutCount--;
                                        bleed1.setText("-"+computer.assassin.Bleed);
                                        bleed1.setVisible(true);
                                    }
                                    if (limited && r == rounds+1){
                                        if (p1.alive>computer.alive){
                                            winPanelLabel.setText("Player 1 won!");
                                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                                        }
                                        else if (p1.alive<computer.alive){
                                            winPanelLabel.setText("Computer won!");
                                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                                        }
                                        else{
                                            winPanelLabel.setText("Draw !");
                                            try{
                                playDraw();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                                        }
                                        winPane.setVisible(true);
                                        winPane.setEnabled(true);
                                        fightPane.setEnabled(false);
                                        fightPane.setVisible(false);
                                    }
                                }
                                else{
                                    timer4.start();
                                }
                            }
                        }
                        else {
                            if (m1.get(HA1.getText()).HP== m1.get(HA1.getText()).cHP){
                                HA1.setEnabled(false);
                                p11h.setOpaque(false);
                                p11h.setBackground(null);
                            }
                            else{
                                HA1.setEnabled(true);
                                p11h.setOpaque(true);
                                p11h.setBackground(Color.WHITE);
                                
                            }
                            if (m1.get(HA2.getText()).HP== m1.get(HA2.getText()).cHP){
                                HA2.setEnabled(false);
                                p12h.setOpaque(false);
                                p12h.setBackground(null);
                            }
                            else{
                                HA2.setEnabled(true);
                                p12h.setOpaque(true);
                                p12h.setBackground(Color.WHITE);
                                
                            }
                            if (m1.get(HA3.getText()).HP== m1.get(HA3.getText()).cHP){
                                HA3.setEnabled(false);
                                p13h.setOpaque(false);
                                p13h.setBackground(null);
                            }
                            else{
                                HA3.setEnabled(true);
                                p13h.setOpaque(true);
                                p13h.setBackground(Color.WHITE);
                            }
                            healPane.setEnabled(true);
                            healPane.setVisible(true);

                            HB1.setEnabled(false);
                            HB2.setEnabled(false);
                            HB3.setEnabled(false);
                            fightPane.setEnabled(false);
                            fightPane.setVisible(false);
                            if (pvp&& p2.assassin!= null){
                                p2.assassin.CutCount= 0;
                            }
                            else if (!pvp && computer.FindAssassin()){
                                computer.getAssassin().CutCount= 0;
                            }
                            fa1.setEnabled(false);
                            fa2.setEnabled(false);
                            fa3.setEnabled(false);
                            try{
                                p1hit(A1);
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }  
                            
                             p2reset();
                            fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                        }
                        p1e1.setText("Energy: "+ m1.get(HA1.getText()).Energy);
                        p1attack1.setText("Attack Strength: "+ m1.get(HA1.getText()).Attack);
                        p1e2.setText("Energy: "+ m1.get(HA2.getText()).Energy);
                        p1attack2.setText("Attack Strength: "+ m1.get(HA2.getText()).Attack);
                        p1e3.setText("Energy: "+ m1.get(HA3.getText()).Energy);
                        p1attack3.setText("Attack Strength: "+ m1.get(HA3.getText()).Attack);
                    }
                    else{
                        turn = 1;
                        if (p2.assassin!=null && p2.assassin.CutCount>0){
                            m1.get(D1).HP-= p2.assassin.Bleed;
                            System.out.println("Player 1 " + D1 + " is bleeding \t HP -"+p2.assassin.Bleed);
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p2.assassin.CutCount--;
                            bleed1.setText("-"+p2.assassin.Bleed);
                            bleed1.setVisible(true);
                        }
                        else{
                            bleed1.setVisible(false);
                        }
                        if (p1!= null && p1.FindSupport()&& p1.support.nerfs>0) {
                            m2.get(A2).Attack -= p1.support.Nerf();
                            System.out.println("Player 2 " + A2 + " was nerfed");
                            p1.support.nerfs--;
                            //p2reset();
                        }
                        if (p2.FindSupport() && p2.support.up>0){
                            m2.get(A2).Attack += p2.support.Buff();
                            p2.support.up=0;
                            p2reset();
                            System.out.println("Player 2 " +A2+ " was buffed");
                            freeze1.setText("buffed*");
                            freeze1.setForeground(new Color(255,95,31));
                            freeze1.setVisible(true);

                        }
                        if(!m2.get(A2).Class.equals("healer")){
                            try{
                                p2hit(A2);
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }  
                            
                            p1reset();
                            System.out.println("Player 1 " + D1 + " had " +m1.get(D1).HP + " HP");
                            damage = m2.get(A2).Super();
                            /*if (p2.FindSupport() && p2.support.up>0){
                                freeze2.setText("buffed*");
                                freeze2.setForeground(new Color(255,95,31));
                                freeze2.setVisible(true);
                            }*/
                            if (p2.FindSupport()&& p2.support.nerfs>0){
                                freeze1.setText("nerfed*");
                                freeze1.setForeground(new Color(3,75,3));
                                freeze1.setVisible(true);
                                try{
                                    nerfp1();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
            
                                
                            }
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
                            
                            if (m1.get(HA1.getText()).HP>0){
                                fa1.setEnabled(true);
                            }
                            else{
                                fa1.setEnabled(false);
                            }
                            if (m1.get(HA2.getText()).HP>0){
                                fa2.setEnabled(true);
                            }
                            else{
                                fa2.setEnabled(false);
                            }
                            if (m1.get(HA3.getText()).HP>0){
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
                            if (m1.get(D1).HP<= 0){
                                m1.get(D1).HP = 0;
                                p1.alive--;
                                p2resetd();
                                try{
                                    killp1(A2, D1);
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
                                
                                p2reset();
                                if (m1.get(p1d1.getText()).HP>0){
                                    p1d1.setEnabled(true);
                                    p11d.setBackground(Color.WHITE);
                                }
                                else{
                                    p1d1.setEnabled(false);
                                    p11d.setBackground(null);
                                }
                                if (m1.get(p1d2.getText()).HP>0){
                                    p1d2.setEnabled(true);
                                    p12d.setBackground(Color.WHITE);
                                }
                                else{
                                    p1d2.setEnabled(false);
                                    p12d.setBackground(null);
                                }
                                if (m1.get(p1d3.getText()).HP>0){
                                    p1d3.setEnabled(true);
                                    p13d.setBackground(Color.WHITE);
                                }
                                else{
                                    p1d3.setEnabled(false);
                                    p13d.setBackground(null);
                                }
                                if (p1.alive == 0){
                                    winPanelLabel.setText("Player 2 won!");
                                    winPane.setEnabled(true);
                                    winPane.setVisible(true);
                                }
                                else if((limited&& r <rounds)|| !limited){
                                    defendPanelLabel.setText("Player 1 select your defending hero");
                                    defendPane.setEnabled(true);
                                    defendPane.setVisible(true);
                                }
                                fightPane.setVisible(false);
                                fightPane.setEnabled(false);

                            }
                            p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                            p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                            p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p1life1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
							p1life2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
							p1life3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
							p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
							p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));

                            System.out.println("Player 1 " + D1 + " has " +m1.get(D1).HP + " HP");
                            if (p2.support!= null && p2.support.Skips>0){
                                turn = 2;
                                System.out.println(("Player 1 was frozen"));
                                freeze1.setText("frozen*");
                                p2reset();
                                try{
                                    freezep1();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
                                
                                //p2reset();
                                freeze1.setForeground(new Color(0,255,255));
                                freeze1.setVisible(true);
                                p2.support.Skips = 0;
                                fa1.setEnabled(false);
                                fa2.setEnabled(false);
                                fa3.setEnabled(false);
                                if (p1.assassin!=null && p1.assassin.CutCount>0){
                                    m2.get(D2).HP-= p1.assassin.Bleed;
                                    System.out.println("Player 2 " + D2 + " is bleeding \t HP -"+p1.assassin.Bleed);
                                    p2a2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                    p2a1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                    p2a3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                    p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                                    p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                                    p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                                    p1.assassin.CutCount--;
                                    bleed2.setText("-"+p1.assassin.Bleed);
                                    bleed2.setVisible(true);
                                }
                                else{
                                    bleed2.setVisible(false);
                                }
                            }
                            if(p2.FindSupport()&&p2.support.up>0){
                                freeze2.setText("buffed*");
                                freeze2.setForeground(new Color(255,95,31));
                                freeze2.setVisible(true);
                                try{
                                    buffp2();
                                }
                                catch(IOException ex){
                                    ex.getStackTrace();
                                }
                                catch(UnsupportedAudioFileException g){
                                    g.getStackTrace();
                                }
                                catch(LineUnavailableException f){
                                    f.getStackTrace();
                                }  
                            }
                            else{
                                fb1.setEnabled(false);
                                fb2.setEnabled(false);
                                fb3.setEnabled(false);
                                if (m1.get(HA1.getText()).HP>0){
                                    fa1.setEnabled(true);
                                }
                                else{
                                    fa1.setEnabled(false);
                                }
                                if (m1.get(HA2.getText()).HP>0){
                                    fa2.setEnabled(true);
                                }
                                else{
                                    fa2.setEnabled(false);
                                }
                                if (m1.get(HA3.getText()).HP>0){
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
                                p21h.setOpaque(false);
                                p21h.setBackground(null);
                            }
                            else{
                                HB1.setEnabled(true);
                                p21h.setOpaque(true);
                                p21h.setBackground(Color.WHITE);
                                
                            }
                            if (m2.get(HB2.getText()).HP== m2.get(HB2.getText()).cHP){
                                HB2.setEnabled(false);
                                p22h.setOpaque(false);
                                p22h.setBackground(null);
                            }
                            else{
                                HB2.setEnabled(true);
                                p22h.setOpaque(true);
                                p22h.setBackground(Color.WHITE);
                                
                            }
                            if (m2.get(HB3.getText()).HP== m2.get(HB3.getText()).cHP){
                                HB3.setEnabled(false);
                                p23h.setOpaque(false);
                                p23h.setBackground(null);
                            }
                            else{
                                HB3.setEnabled(true);
                                p23h.setOpaque(true);
                                p23h.setBackground(Color.WHITE);
                                
                            }
                            healPane.setVisible(true);
                            healPane.setEnabled(true);
                            fightPane.setEnabled(false);
                            fightPane.setVisible(false);
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
                            if (m1.get(HA1.getText()).HP==0){
                                fa1.setEnabled(false);
                            }
                            else{
                                fa1.setEnabled(true);
                            }
                            if (m1.get(HA2.getText()).HP== 0){
                                fa2.setEnabled(false);
                            }
                            else{
                                fa2.setEnabled(true);
                            }
                            if (m1.get(HA3.getText()).HP== 0){
                                fa3.setEnabled(false);
                            }
                            else{
                                fa3.setEnabled(true);
                            }
                        }
                        p2e1.setText("Energy: "+ m2.get(HB1.getText()).Energy);
                        p2attack1.setText("Attack Strength: "+ m2.get(HB1.getText()).Attack);
                        p2e2.setText("Energy: "+ m2.get(HB2.getText()).Energy);
                        p2attack2.setText("Attack Strength: "+ m2.get(HB2.getText()).Attack);
                        p2e3.setText("Energy: "+ m2.get(HB3.getText()).Energy);
                        p2attack3.setText("Attack Strength: "+ m2.get(HB3.getText()).Attack);
                    }
                    if(pvp){
                        fightPanelLabel.setText("Round "+ r+ " Player "+ turn+ " turn");
                    }
                    else{
                        fightPanelLabel.setText("       Round "+ r);
                    }
                    n.setEnabled(false);
                    s.setEnabled(false);
                    S.setEnabled(false);
                    if (pvp&& limited && r == rounds+1){
                        if (p1.alive>p2.alive){
                            winPanelLabel.setText("Player 1 won!");
                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                        }
                        else if (p1.alive<p2.alive){
                            winPanelLabel.setText("Player 2 won!");
                            try{
                                playWin();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                        }
                        else{
                            winPanelLabel.setText("Draw !");
                            try{
                                playDraw();
                            }
                            catch(IOException ex){
                                ex.getStackTrace();
                            }
                            catch(UnsupportedAudioFileException g){
                                g.getStackTrace();
                            }
                            catch(LineUnavailableException f){
                                f.getStackTrace();
                            }
                        }
                        winPane.setVisible(true);
                        winPane.setEnabled(true);
                        fightPane.setEnabled(false);
                        fightPane.setVisible(false);
                    }
                    /*else if (!pvp && computer.FindAssassin()&& computer.assassin.CutCount==0){
                        bleed1.setVisible(false);
                    }*/
                }
            }
        });



        healPanel.setLayout(null);
        healPanel.setBackground(new Color(100, 60, 140));
        healPanel.setSize(1600, 800);
        //this.add(healPanel);
        healPane.setVisible(false);
        healPane.setEnabled(false);

        healPanelLabel.setText("Choose your character to heal");
        healPanelLabel.setBounds(200, 150, 1200, 100);
        healPanelLabel.setFont(new Font("Press Start 2P", Font.BOLD, 60));
        healPanelLabel.setForeground(new Color(255, 30, 0));
        healPanelLabel.setVisible(true);
        healPane.add(healPanelLabel,JLayeredPane.DRAG_LAYER);
        healPane.add(charha1,JLayeredPane.DRAG_LAYER);
        healPane.add(charha2,JLayeredPane.DRAG_LAYER);
        healPane.add(charha3,JLayeredPane.DRAG_LAYER);
        healPane.add(charhb1,JLayeredPane.DRAG_LAYER);
        healPane.add(charhb2,JLayeredPane.DRAG_LAYER);
        healPane.add(charhb3,JLayeredPane.DRAG_LAYER);
        healPane.add(p1health1l,JLayeredPane.DRAG_LAYER);
        healPane.add(p1health2l,JLayeredPane.DRAG_LAYER);
        healPane.add(p1health3l,JLayeredPane.DRAG_LAYER);
        healPane.add(p2health1l,JLayeredPane.DRAG_LAYER);
        healPane.add(p2health2l,JLayeredPane.DRAG_LAYER);
        healPane.add(p2health3l,JLayeredPane.DRAG_LAYER);
        healPane.add(bgh,JLayeredPane.DEFAULT_LAYER);

        p11h.setOpaque(false);
        p12h.setOpaque(false);
        p13h.setOpaque(false);
        p21h.setOpaque(false);
        p22h.setOpaque(false);
        p23h.setOpaque(false);
        
        charha1.setForeground(Color.BLUE);
        charha1.setVisible(true);
        charha1.setFont(new Font("Press Start 2P",Font.PLAIN,20));


        charha2.setForeground(Color.BLUE);
        charha2.setVisible(true);
        charha2.setFont(new Font("Press Start 2P",Font.PLAIN,20));


        charha3.setForeground(Color.BLUE);
        charha3.setVisible(true);
        charha3.setFont(new Font("Press Start 2P",Font.PLAIN,20));


        charhb1.setForeground(Color.RED);
        charhb1.setVisible(true);
        charhb1.setFont(new Font("Press Start 2P",Font.PLAIN,20));


        charhb2.setForeground(Color.RED);
        charhb2.setVisible(true);
        charhb2.setFont(new Font("Press Start 2P",Font.PLAIN,20));

        charhb3.setForeground(Color.RED);
        charhb3.setVisible(true);
        charhb3.setFont(new Font("Press Start 2P",Font.PLAIN,20));

        p1health1l.setForeground(Color.GREEN);
        p1health1l.setBounds(50,400,300,50);
        p1health1l.setFont(new Font("Comic Sans", Font.PLAIN,35));    
        p1health1l.setVisible(true);

	    p1health2l.setForeground(Color.GREEN);
        p1health2l.setBounds(150,500,300,50);
        p1health2l.setFont(new Font("Comic Sans", Font.PLAIN,35));     
        p1health2l.setVisible(true);

	    p1health3l.setForeground(Color.GREEN);
        p1health3l.setBounds(50,600,300,50);
        p1health3l.setFont(new Font("Comic Sans", Font.PLAIN,35));
        p1health3l.setVisible(true);


        p2health1l.setForeground(Color.GREEN);
        p2health1l.setBounds(1050,400,300,50);
        p2health1l.setFont(new Font("Comic Sans", Font.PLAIN,35)); 
        p2health1l.setVisible(true);


        p2health2l.setForeground(Color.GREEN);
        p2health2l.setBounds(900,500,300,50);
        p2health2l.setFont(new Font("Comic Sans", Font.PLAIN,35));  
        p2health2l.setVisible(true);


        p2health3l.setForeground(Color.GREEN);
        p2health3l.setBounds(1050,600,300,50);
        p2health3l.setFont(new Font("Comic Sans", Font.PLAIN,35));  
        p2health3l.setVisible(true);



        p11h.setBounds(50, 350,100,100);
        healPane.add(p11h,JLayeredPane.DRAG_LAYER);
        p11h.setBackground(null);
        p11h.setVisible(true);

        p12h.setBounds(150, 450,100,100);
        healPane.add(p12h,JLayeredPane.DRAG_LAYER);
        p12h.setBackground(null);
        p12h.setVisible(true);

        p13h.setBounds(50, 550,100,100);
        healPane.add(p13h,JLayeredPane.DRAG_LAYER);
        p13h.setBackground(null);
        p13h.setVisible(true);

        p21h.setBounds(1050, 350,100,100);
        healPane.add(p21h,JLayeredPane.DRAG_LAYER);
        p21h.setBackground(null);
        p21h.setVisible(true);

        p22h.setBounds(900, 450,100,100);
        healPane.add(p22h,JLayeredPane.DRAG_LAYER);
        p22h.setBackground(null);
        p22h.setVisible(true);

        p23h.setBounds(1050, 550,100,100);
        healPane.add(p23h,JLayeredPane.DRAG_LAYER);
        p23h.setBackground(null);
        p23h.setVisible(true);      

        HA1.setFocusable(false);
        HA1.setBounds(410,270,100,100);
        HA1.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPane.add(HA1,JLayeredPane.DEFAULT_LAYER);
        HA1.setVisible(true);
        HA1.setEnabled(true);
        HA1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HA1) {
                    p11h.setBackground(null);
                    p12h.setBackground(null);
                    p13h.setBackground(null);
                    p21h.setBackground(null);
                    p22h.setBackground(null);
                    p23h.setBackground(null);
                    p11h.setOpaque(false);
                    p12h.setOpaque(false);
                    p13h.setOpaque(false);
                    p21h.setOpaque(false);
                    p22h.setOpaque(false);
                    p23h.setOpaque(false);
                    p1d1l.setForeground(new Color(10,255,120));
                    p1d2l.setForeground(new Color(10,255,120));
                    p1d3l.setForeground(new Color(10,255,120));
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
                    p1d1l.setVisible(true);
                    p1a1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                    p1health1l.setText(String.valueOf(m1.get(HA1.getText()).HP));
                    System.out.println(HA1.getText()+" was healed to "+  m1.get(HA1.getText()).HP +" HP");
                    try{
                        p1heal(HA1.getText());
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    }  
                    
                    
                    healPane.setVisible(false);
                    healPane.setEnabled(false);
                    if (pvp){
                        fa1.setEnabled(false);
                        fa2.setEnabled(false);
                        fa3.setEnabled(false);
                        if (m2.get(HB1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(HB2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(HB3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        timer5.start();
                    }
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);

                }
            }
        });

        HA2.setFocusable(false);
        HA2.setBounds(560,350,100,100);
        HA2.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPane.add(HA2,JLayeredPane.DEFAULT_LAYER);
        HA2.setVisible(true);
        HA2.setEnabled(true);
        HA2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HA2) {
                    p11h.setBackground(null);
                    p12h.setBackground(null);
                    p13h.setBackground(null);
                    p21h.setBackground(null);
                    p22h.setBackground(null);
                    p23h.setBackground(null);
                    p11h.setOpaque(false);
                    p12h.setOpaque(false);
                    p13h.setOpaque(false);
                    p21h.setOpaque(false);
                    p22h.setOpaque(false);
                    p23h.setOpaque(false);
                    p1d1l.setForeground(new Color(10,255,120));
                    p1d2l.setForeground(new Color(10,255,120));
                    p1d3l.setForeground(new Color(10,255,120));
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
                    p1d2l.setVisible(true);
                    p1a2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                    p1health2l.setText(String.valueOf(m1.get(HA2.getText()).HP));
                    System.out.println(HA2.getText()+" was healed to "+  m1.get(HA2.getText()).HP +" HP");
                    try{
                        p1heal(HA2.getText());
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    }  

                    
                    healPane.setVisible(false);
                    healPane.setEnabled(false);
                    if (pvp){
                        fa1.setEnabled(false);
                        fa2.setEnabled(false);
                        fa3.setEnabled(false);
                        if (m2.get(HB1.getText()).HP>0){
                            fb1.setEnabled(true);
                        }
                        else{
                            fb1.setEnabled(false);
                        }
                        if (m2.get(HB2.getText()).HP>0){
                            fb2.setEnabled(true);
                        }
                        else{
                            fb2.setEnabled(false);
                        }
                        if (m2.get(HB3.getText()).HP>0){
                            fb3.setEnabled(true);
                        }
                        else{
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        timer6.start();
                    }
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);

                }
            }
        });


        HA3.setFocusable(false);
        HA3.setBounds(410,430,100,100);
        HA3.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPane.add(HA3,JLayeredPane.DEFAULT_LAYER);
        HA3.setVisible(true);
        HA3.setEnabled(true);
        HA3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HA3) {
                    p11h.setBackground(null);
                    p12h.setBackground(null);
                    p13h.setBackground(null);
                    p21h.setBackground(null);
                    p22h.setBackground(null);
                    p23h.setBackground(null);
                    p11h.setOpaque(false);
                    p12h.setOpaque(false);
                    p13h.setOpaque(false);
                    p21h.setOpaque(false);
                    p22h.setOpaque(false);
                    p23h.setOpaque(false);
                    p1d1l.setForeground(new Color(10,255,120));
                    p1d2l.setForeground(new Color(10,255,120));
                    p1d3l.setForeground(new Color(10,255,120));
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
                    p1d3l.setVisible(true);
                    p1a3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                    p1health3l.setText(String.valueOf(m1.get(HA3.getText()).HP));
                    System.out.println(HA3.getText()+" was healed to "+  m1.get(HA3.getText()).HP +" HP");
                   try{
                        p1heal(HA3.getText());
                   }
                   catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    
                    healPane.setVisible(false);
                    healPane.setEnabled(false);
                    if (pvp) {
                        fa1.setEnabled(false);
                        fa2.setEnabled(false);
                        fa3.setEnabled(false);
                        if (m2.get(HB1.getText()).HP > 0) {
                            fb1.setEnabled(true);
                        } else {
                            fb1.setEnabled(false);
                        }
                        if (m2.get(HB2.getText()).HP > 0) {
                            fb2.setEnabled(true);
                        } else {
                            fb2.setEnabled(false);
                        }
                        if (m2.get(HB3.getText()).HP > 0) {
                            fb3.setEnabled(true);
                        } else {
                            fb3.setEnabled(false);
                        }
                    }
                    else{
                        timer7.start();
                    }
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);


                }
            }
        });


        HB1.setFocusable(false);
        HB1.setBounds(1100,270,100,100);
        HB1.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPane.add(HB1,JLayeredPane.DEFAULT_LAYER);
        HB1.setVisible(true);
        HB1.setEnabled(true);
        HB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HB1) {
                    p11h.setBackground(null);
                    p12h.setBackground(null);
                    p13h.setBackground(null);
                    p21h.setBackground(null);
                    p22h.setBackground(null);
                    p23h.setBackground(null);
                    p11h.setOpaque(false);
                    p12h.setOpaque(false);
                    p13h.setOpaque(false);
                    p21h.setOpaque(false);
                    p22h.setOpaque(false);
                    p23h.setOpaque(false);
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
                    p2health1l.setText(String.valueOf(m2.get(HB1.getText()).HP));
                    System.out.println(HB1.getText()+" was healed to "+  m2.get(HB1.getText()).HP +" HP");
                    //p2reset();
                    try{
                        p2heal(HB1.getText());
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    }  
                    
                    healPane.setVisible(false);
                    healPane.setEnabled(false);
                    if (m1.get(HA1.getText()).HP>0){
                        fa1.setEnabled(true);
                    }
                    else{
                        fa1.setEnabled(false);
                    }
                    if (m1.get(HA2.getText()).HP>0){
                        fa2.setEnabled(true);
                    }
                    else{
                        fa2.setEnabled(false);
                    }
                    if (m1.get(HA3.getText()).HP>0){
                        fa3.setEnabled(true);
                    }
                    else{
                        fa3.setEnabled(false);
                    }
                    fb1.setEnabled(false);
                    fb2.setEnabled(false);
                    fb3.setEnabled(false);
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);
                }
            }
        });


        HB2.setFocusable(false);
        HB2.setBounds(950,350,100,100);
        HB2.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPane.add(HB2,JLayeredPane.DEFAULT_LAYER);
        HB2.setVisible(true);
        HB2.setEnabled(true);
        HB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HB2) {
                    p11h.setBackground(null);
                    p12h.setBackground(null);
                    p13h.setBackground(null);
                    p21h.setBackground(null);
                    p22h.setBackground(null);
                    p23h.setBackground(null);
                    p11h.setOpaque(false);
                    p12h.setOpaque(false);
                    p13h.setOpaque(false);
                    p21h.setOpaque(false);
                    p22h.setOpaque(false);
                    p23h.setOpaque(false);
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
                    p2health2l.setText(String.valueOf(m2.get(HB2.getText()).HP));
                    System.out.println(HB2.getText()+" was healed to "+  m2.get(HB2.getText()).HP +" HP");
                    //p2reset();
                    try{
                        p2heal(HB2.getText());
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    } 
                    
                    healPane.setVisible(false);
                    healPane.setEnabled(false);
                    if (m1.get(HA1.getText()).HP>0){
                        fa1.setEnabled(true);
                    }
                    else{
                        fa1.setEnabled(false);
                    }
                    if (m1.get(HA2.getText()).HP>0){
                        fa2.setEnabled(true);
                    }
                    else{
                        fa2.setEnabled(false);
                    }
                    if (m1.get(HA3.getText()).HP>0){
                        fa3.setEnabled(true);
                    }
                    else{
                        fa3.setEnabled(false);
                    }
                    fb1.setEnabled(false);
                    fb2.setEnabled(false);
                    fb3.setEnabled(false);
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);
                }
            }
        });


        HB3.setFocusable(false);
        HB3.setBounds(1100,430,100,100);
        HB3.setFont(new Font("Comic Sans", Font.BOLD,35));
        healPane.add(HB3,JLayeredPane.DEFAULT_LAYER);
        HB3.setVisible(true);
        HB3.setEnabled(true);
        HB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == HB3) {
                    p11h.setBackground(null);
                    p12h.setBackground(null);
                    p13h.setBackground(null);
                    p21h.setBackground(null);
                    p22h.setBackground(null);
                    p23h.setBackground(null);
                    p11h.setOpaque(false);
                    p12h.setOpaque(false);
                    p13h.setOpaque(false);
                    p21h.setOpaque(false);
                    p22h.setOpaque(false);
                    p23h.setOpaque(false);
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
                    p2health3l.setText(String.valueOf(m2.get(HB3.getText()).HP));
                    System.out.println(HB3.getText()+" was healed to "+  m2.get(HB3.getText()).HP +" HP");
                    //p2reset();
                    try{
                        p2heal(HB3.getText());
                    }
                    catch(IOException ex){
                        ex.getStackTrace();
                    }
                    catch(UnsupportedAudioFileException g){
                        g.getStackTrace();
                    }
                    catch(LineUnavailableException f){
                        f.getStackTrace();
                    }  

                    
                    healPane.setVisible(false);
                    healPane.setEnabled(false);
                    if (m1.get(HA1.getText()).HP>0){
                        fa1.setEnabled(true);
                    }
                    else{
                        fa1.setEnabled(false);
                    }
                    if (m1.get(HA2.getText()).HP>0){
                        fa2.setEnabled(true);
                    }
                    else{
                        fa2.setEnabled(false);
                    }
                    if (m1.get(HA3.getText()).HP>0){
                        fa3.setEnabled(true);
                    }
                    else{
                        fa3.setEnabled(false);
                    }
                    fb1.setEnabled(false);
                    fb2.setEnabled(false);
                    fb3.setEnabled(false);
                    fightPane.setEnabled(true);
                    fightPane.setVisible(true);
                }
            }
        });
        winPane = new JLayeredPane();

        this.add(winPane);
        winPane.setVisible(false);
        winPane.setEnabled(false);
        winPane = new JLayeredPane();
        winPane.setLayout(null);
        winPane.setBackground(new Color(100, 60, 140));
        winPane.setSize(1600, 800);
        this.add(winPane);
        winPane.setVisible(false);
        winPane.setEnabled(false);
        winPane.add(bgw,JLayeredPane.DEFAULT_LAYER);

        winPanelLabel = new JLabel();
        winPanelLabel.setVisible(true);
        winPanelLabel.setBounds(500,300,1200,100);
        winPanelLabel.setFont(new Font("Press Start 2P",Font.BOLD,120));
        winPanelLabel.setForeground(new Color(255,30,0));
        winPanelLabel.setVisible(true);
        winPane.add(winPanelLabel,JLayeredPane.DRAG_LAYER);

        Home.setBounds(1100, 150, 120, 90);
        winPane.add(Home,JLayeredPane.DRAG_LAYER);
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
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    turn = 1;
                    Player1.setVisible(true);
                    Player2.setVisible(true);
                    Player11.setText("");
                    Player12.setText("");
                    Player13.setText("");
                    Player21.setText("");
                    Player22.setText("");
                    Player23.setText("");
                    Player1.setVisible(true);
                    Player2.setVisible(true);
                    bleed1.setVisible(false);
                    bleed2.setVisible(false);
                    freeze1.setVisible(false);
                    freeze2.setVisible(false);
                    p1 = new Player();
                    p2 = null;
                    D2 = null;
                    selected = 0;
                    r = 1;
                    if (pvp){
                        fightPanelLabel.setText("Round "+r+ " Player "+turn+" turn" );
                        
                    }
                    else{
                        fightPanelLabel.setText("       Round "+r );
                    }
                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

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

                    p1d1.setBounds(410,270,100,100);
                    p1d2.setBounds(560,350,100,100);
                    p1d3.setBounds(410,430,100,100);

                    p11d.setBounds(410, 270,100,100);
                    p12d.setBounds(560, 350,100,100);
                    p13d.setBounds(410, 430,100,100);

                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);

                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(950,350,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p22d.setBounds(950, 350,100,100);
                    p23d.setBounds(1100, 430,100,100);


                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    winPane.setEnabled(false);
                    winPane.setVisible(false);
                    startPane.setEnabled(true);
                    startPane.setVisible(true);
                    NextB2.setEnabled(false);
                }
            }
        });

        playAgain.setBounds(600, 500, 400, 90);
        winPane.add(playAgain,JLayeredPane.DRAG_LAYER);
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
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    p1reset();
                    p1resetd();
                    p2reset();
                    p2resetd();
                    selected = 0;
                    turn = 1;
                    r = 1;
                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);


                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);


                    p1 = new Player();
                    if (pvp){
                        pvpPanel3Label.setText("Player 1 choose 3 Heroes");
                        fightPanelLabel.setText("Round "+r+ " Player "+turn+" turn" );
                        p2 = new Player();
                        D2 = null;
                    }
                    else{
                        pvpPanel3Label.setText("Choose 3 Heroes");
                        fightPanelLabel.setText("       Round "+r );
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
                        p2health1l.setText(String.valueOf(computer.chosen[0].HP));
                        p2health2l.setText(String.valueOf(computer.chosen[1].HP));
                        p2health3l.setText(String.valueOf(computer.chosen[2].HP));
                        sortButtons();
                    }

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
                    

                    p1d1.setBounds(410,270,100,100);
                    p1d2.setBounds(560,350,100,100);
                    p1d3.setBounds(410,430,100,100);

                    p11d.setBounds(410, 270,100,100);
                    p12d.setBounds(560, 350,100,100);
                    p13d.setBounds(410, 430,100,100);

                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);



                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(950,350,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p22d.setBounds(950, 350,100,100);
                    p23d.setBounds(1100, 430,100,100);


                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    winPane.setEnabled(false);
                    winPane.setVisible(false);
                    pane2.setEnabled(true);
                    pane2.setVisible(true);
                    NextB2.setEnabled(false);
                    bleed1.setVisible(false);
                    bleed2.setVisible(false);
                    freeze1.setVisible(false);
                    freeze2.setVisible(false);
                }
            }
        });

        
        p1p1.setBackground(Color.BLACK);
        p1p1.setLayout(null);
        p1p1.setVisible(true);
        p1p1.setEnabled(true);
        p1p1.setBounds(10, 100, 200, 100);
        
        p1s1.setBounds(10, 10, 200, 20);
        p1s1.setForeground(Color.white);
        p1s1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1s1.setVisible(true);
        
        p1attack1.setBounds(10, 30, 200, 25);
        p1attack1.setForeground(Color.white); 
        p1attack1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1attack1.setVisible(true);
        
        
        p1e1.setBounds(10, 50, 200, 25);
        p1e1.setForeground(Color.white);
        p1e1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1e1.setVisible(true);

        
        p1spec1.setBounds(10, 70, 200, 25);
        p1spec1.setForeground(Color.white); 
        p1spec1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1spec1.setVisible(true);


        ImageIcon cIcon = new ImageIcon("exit.png");

        p1b1.setFocusable(false);
        p1b1.setIcon(cIcon);
        p1b1.setVisible(true);
        p1b1.addActionListener(this);
        p1b1.setEnabled(true);
        p1b1.setBounds(180, 0, 20, 20);     
        p1b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == p1b1){
                    p1p1.setEnabled(false);
                    p1p1.setVisible(false);
                }
            }
        });

        p1p1.add(p1s1);
        p1p1.add(p1attack1);
        p1p1.add(p1e1);
        p1p1.add(p1spec1);
        p1p1.add(p1b1);

        fightPane.add(p1p1,JLayeredPane.DRAG_LAYER);

        p11f.setBounds(50, 350, 150, 150);
        fightPane.add(p11f,JLayeredPane.DRAG_LAYER);
        p11f.setBackground(null);
        p11f.setOpaque(false);
        p11f.setVisible(true);

	    p12f.setBounds(150, 450, 150, 150);
        fightPane.add(p12f,JLayeredPane.DRAG_LAYER);
        p12f.setBackground(null);
        p12f.setOpaque(false);
        p12f.setVisible(true);

	    p13f.setBounds(50, 550,100,100);
        fightPane.add(p13f,JLayeredPane.DRAG_LAYER);
        p13f.setBackground(null);
        p13f.setOpaque(false);
        p13f.setVisible(true);

	    p21f.setBounds(1050, 350, 150, 150);
        fightPane.add(p21f,JLayeredPane.DRAG_LAYER);
        p21f.setBackground(null);
        p21f.setOpaque(false);
        p21f.setVisible(true);

	    p22f.setBounds(900, 450, 150, 150);
        fightPane.add(p22f,JLayeredPane.DRAG_LAYER);
        p22f.setBackground(null);
        p22f.setOpaque(false);
        p22f.setVisible(true);

	    p23f.setBounds(1050, 550,150,150);
        fightPane.add(p23f,JLayeredPane.DRAG_LAYER);
        p23f.setBackground(null);
        p23f.setOpaque(false);
        p23f.setVisible(true);


        p1p2.setBackground(Color.BLACK);
        p1p2.setLayout(null);
        p1p2.setVisible(true);
        p1p2.setEnabled(true);
        p1p2.setBounds(10,200,200,100);
        
        
        p1s2.setBounds(10, 10, 200, 20);
        p1s2.setForeground(Color.white);
        p1s2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1s2.setVisible(true);
        
        
        p1attack2.setBounds(10, 30, 200, 25);
        p1attack2.setForeground(Color.white); 
        p1attack2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1attack2.setVisible(true);
        
        
        p1e2.setBounds(10, 50, 200, 25);
        p1e2.setForeground(Color.white);
        p1e2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1e2.setVisible(true);

        
        p1spec2.setBounds(10, 70, 200, 25);
        p1spec2.setForeground(Color.white); 
        p1spec2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1spec2.setVisible(true);

        p1b2.setFocusable(false);
        p1b2.setVisible(true);
        p1b2.addActionListener(this);
        p1b2.setIcon(cIcon);
        p1b2.setEnabled(true);
        p1b2.setBounds(180, 0, 20, 20);      
        p1b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == p1b2){
                    p1p2.setEnabled(false);
                    p1p2.setVisible(false);
                }
            }
        });

        p1p2.add(p1s2);
        p1p2.add(p1attack2);
        p1p2.add(p1e2);
        p1p2.add(p1spec2);
        p1p2.add(p1b2);

        fightPane.add(p1p2,JLayeredPane.DRAG_LAYER);

        
        p1p3.setBackground(Color.BLACK);
        p1p3.setLayout(null);
        p1p3.setVisible(true);
        p1p3.setEnabled(true);
        p1p3.setBounds(10,300,200,100);
        
        
        p1s3.setBounds(10, 10, 200, 20);
        p1s3.setForeground(Color.white);
        p1s3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1s3.setVisible(true);
        
        
        p1attack3.setBounds(10, 30, 200, 25);
        p1attack3.setForeground(Color.white); 
        p1attack3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1attack3.setVisible(true);
        
        
        p1e3.setBounds(10, 50, 200, 25);
        p1e3.setForeground(Color.white);
        p1e3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1e3.setVisible(true);

        
        p1spec3.setBounds(10, 70, 200, 25);
        p1spec3.setForeground(Color.white); 
        p1spec3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p1spec3.setVisible(true);

        p1b3.setFocusable(false);
        p1b3.setVisible(true);
        p1b3.addActionListener(this);
        p1b3.setIcon(cIcon);
        p1b3.setEnabled(true);
        p1b3.setBounds(180, 0, 20, 20);   
        p1b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == p1b3){
                    p1p3.setEnabled(false);
                    p1p3.setVisible(false);
                }
            }
        });

        p1p3.add(p1s3);
        p1p3.add(p1attack3);
        p1p3.add(p1e3);
        p1p3.add(p1spec3);
        p1p3.add(p1b3);
        
        fightPane.add(p1p3,JLayeredPane.DRAG_LAYER);

        
        p2p1.setBackground(Color.BLACK);
        p2p1.setLayout(null);
        p2p1.setVisible(true);
        p2p1.setEnabled(true);
        p2p1.setBounds(1200, 100, 200, 100);		//1050,350,300,60
        
        
        p2s1.setBounds(10, 10, 200, 20);
        p2s1.setForeground(Color.white);
        p2s1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2s1.setVisible(true);
        
        
        p2attack1.setBounds(10, 30, 200, 25);
        p2attack1.setForeground(Color.white); 
        p2attack1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2attack1.setVisible(true);
        
        
        p2e1.setBounds(10, 50, 200, 25);
        p2e1.setForeground(Color.white);
        p2e1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        //p2e1.setVisible(true);
        p2e1.setVisible(true);

        
        p2spec1.setBounds(10, 70, 200, 25);
        p2spec1.setForeground(Color.white); 
        p2spec1.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2spec1.setVisible(true);


        p2b1.setFocusable(false);
        p2b1.setVisible(true);
        p2b1.addActionListener(this);
        p2b1.setIcon(cIcon);
        p2b1.setEnabled(true);
        p2b1.setBounds(180, 0, 20, 20);     
        p2b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == p2b1){
                    p2p1.setEnabled(false);
                    p2p1.setVisible(false);
                }
            }
        });

        p2p1.add(p2s1);
        p2p1.add(p2attack1);
        p2p1.add(p2spec1);
        p2p1.add(p2b1);
        p2p1.add(p2e1);
        
        fightPane.add(p2p1,JLayeredPane.DRAG_LAYER);


        
        p2p2.setBackground(Color.BLACK);
        p2p2.setLayout(null);
        p2p2.setVisible(true);
        p2p2.setEnabled(true);
        p2p2.setBounds(1200, 200, 200, 100);		//900,450,300,60
        
        
        p2s2.setBounds(10, 10, 200, 20);
        p2s2.setForeground(Color.white);
        p2s2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2s2.setVisible(true);
        
        
        p2attack2.setBounds(10, 30, 200, 25);
        p2attack2.setForeground(Color.white); 
        p2attack2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2attack2.setVisible(true);
        
        
        p2e2.setBounds(10, 50, 200, 25);
        p2e2.setForeground(Color.white);
        p2e2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2e2.setVisible(true);

        
        p2spec2.setBounds(10, 70, 200, 25);
        p2spec2.setForeground(Color.white); 
        p2spec2.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2spec2.setVisible(true);


        
        p2b2.setFocusable(false);
        p2b2.setVisible(true);
        p2b2.addActionListener(this);
        p2b2.setIcon(cIcon);
        p2b2.setEnabled(true);
        p2b2.setBounds(180, 0, 20, 20);   
        p2b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == p2b2){
                    p2p2.setEnabled(false);
                    p2p2.setVisible(false);
                }
            }
        });

        p2p2.add(p2s2);
        p2p2.add(p2attack2);
        p2p2.add(p2spec2);
        p2p2.add(p2b2);
        p2p2.add(p2e2);
        

        fightPane.add(p2p2,JLayeredPane.DRAG_LAYER);

        
        p2p3.setBackground(Color.BLACK);
        p2p3.setLayout(null);
        p2p3.setVisible(true);
        p2p3.setEnabled(true);
        p2p3.setBounds(1200, 300, 200, 100);			//1050,550,300,60
        
        
        p2s3.setBounds(10, 10, 200, 20);
        p2s3.setForeground(Color.white);
        p2s3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2s3.setVisible(true);
        
        
        p2attack3.setBounds(10, 30, 200, 25);
        p2attack3.setForeground(Color.white); 
        p2attack3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2attack3.setVisible(true);
        
        
        p2e3.setBounds(10, 50, 200, 25);
        p2e3.setForeground(Color.white);
        p2e3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2e3.setVisible(true);

        
        p2spec3.setBounds(10, 70, 200, 25);
        p2spec3.setForeground(Color.white); 
        p2spec3.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        p2spec3.setVisible(true);


        
        p2b3.setFocusable(false);
        p2b3.setVisible(true);
        p2b3.addActionListener(this);
        p2b3.setEnabled(true);
        p2b3.setBounds(0, 0, 300, 400);   
        p2b3.setIcon(cIcon);
        p2b3.setEnabled(true);
        p2b3.setBounds(180, 0, 20, 20);   
        p2b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == p2b3){
                    p2p3.setEnabled(false);
                    p2p3.setVisible(false);
                }
            }
        });

        p2p3.add(p2s3);
        p2p3.add(p2attack3);
        p2p3.add(p2spec3);
        p2p3.add(p2b3);
        p2p3.add(p2e3);
        
        fightPane.add(p2p3,JLayeredPane.DRAG_LAYER);

        helpPanel.setBackground(Color.BLACK);
        helpPanel.setLayout(null);
        helpPanel.setVisible(false);
        helpPanel.setEnabled(false);
        helpPanel.setSize(1600, 800);
	    this.add(helpPanel);

        JPanel helpPanel1 = new JPanel();
        helpPanel1.setBackground(Color.BLACK);
        helpPanel1.setLayout(null);
        helpPanel1.setVisible(false);
        helpPanel1.setEnabled(false);
        helpPanel1.setSize(1600, 800);
	    this.add(helpPanel1);

	    helpButton.setFocusable(false);
        //helpButton.setIcon(cIcon);
        helpButton.setEnabled(true);
        helpButton.setVisible(true);
        helpButton.addActionListener(this);
        helpButton.setFont(new Font("Comic Sans", Font.BOLD,10));
        helpButton.setBounds(1400, 40, 40, 40);  
	    fightPane.add(helpButton,JLayeredPane.DRAG_LAYER); 
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == helpButton){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
		            helpPanel.setEnabled(true);
                    helpPanel.setVisible(true);
                    fightPane.setEnabled(false);
                    fightPane.setVisible(false);
                }
            }
        });


        JButton helpButton1 = new JButton("?");
        helpButton1.setFont(new Font("Comic Sans", Font.BOLD,10));
        helpButton1.setFocusable(false);
        //helpButton.setIcon(cIcon);
        helpButton1.setVisible(true);
        helpButton1.addActionListener(this);
        helpButton1.setEnabled(true);
        helpButton1.setBounds(1300, 40, 40, 40);  
	    pane3.add(helpButton1,JLayeredPane.DRAG_LAYER); 
        helpButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == helpButton1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    helpPanel1.setEnabled(true);
                    helpPanel1.setVisible(true);
                    pane3.setVisible(false);
                    pane3.setEnabled(false);
                    
                }
            }
        });

        JButton helpClose1 = new JButton();
        helpClose1.setFocusable(false);
        helpClose1.setIcon(cIcon);
        helpClose1.setVisible(true);
        helpClose1.addActionListener(this);
        helpClose1.setEnabled(true);
        helpClose1.setBounds(1400, 20, 40, 40); 
	    helpPanel1.add(helpClose1);    
        helpClose1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == helpClose1){
                    try{
                            playBack();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
		    helpPanel1.setVisible(false);
		    helpPanel1.setEnabled(false);
            pane3.setEnabled(true);
            pane3.setVisible(true);
                }
            }
        });

	    helpClose.setFocusable(false);
        helpClose.setIcon(cIcon);
        helpClose.setVisible(true);
        helpClose.addActionListener(this);
        helpClose.setEnabled(true);
        helpClose.setBounds(1400, 20, 40, 40); 
	    helpPanel.add(helpClose);    
        helpClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == helpClose){
                    try{
                            playBack();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
		    helpPanel.setVisible(false);
		    helpPanel.setEnabled(false);
            fightPane.setEnabled(true);
            fightPane.setVisible(true);
                }
            }
        });

	    assaultPanel.setBackground(Color.BLACK);
        assaultPanel.setLayout(null);
        assaultPanel.setVisible(false);
        assaultPanel.setEnabled(false);
        assaultPanel.setSize(1600, 800);

        JTextArea assaultText = new JTextArea("Assault is a heavy damage dealer. \nNormal: does temperate damage to enemy. \nSkill: does moderate damage to enemy. \nSuper: does heavy damage to enemy.");
        assaultText.setVisible(true);
        assaultText.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        assaultText.setBounds(30, 50, 1600, 800);
        assaultText.setForeground(Color.white);
        assaultText.setBackground(Color.BLACK);
        assaultText.setEditable(false);
        assaultPanel.add(assaultText);

	    apc.setFocusable(false);
        apc.setIcon(cIcon);
        apc.setVisible(true);
        apc.addActionListener(this);
        apc.setEnabled(true);
        assaultPanel.add(apc);
        apc.setBounds(1400, 20, 40, 40);     
        apc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == apc){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    assaultPanel.setEnabled(false);
                    assaultPanel.setVisible(false);
                    assaultb.setVisible(true);
                    assaultb.setEnabled(true);  
                    assassinb.setVisible(true);
                    assassinb.setEnabled(true);
                    healerb.setVisible(true);
                    healerb.setEnabled(true);
                    supportb.setVisible(true);
                    supportb.setEnabled(true);
                    tankb.setVisible(true);
                    tankb.setEnabled(true);
                    helpClose.setEnabled(true);
                    helpClose.setVisible(true);
                }
            }
        });

	    assassinPanel.setBackground(Color.BLACK);
        assassinPanel.setLayout(null);
        assassinPanel.setVisible(false);
        assassinPanel.setEnabled(false);
        assassinPanel.setSize(1600, 800);

        JTextArea assassinText = new JTextArea("Assassin is a secondary damage dealer. \nNormal: does temperate damage to enemy. \nSkill: does moderate damge to enemy and \ninflicts passive damage for the next 2 rounds. \nSuper: does modest damge to enemy and \ninflicts passive damage for the next 4 rounds .");
        assassinText.setVisible(true);
        assassinText.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        assassinText.setBounds(30, 50, 1600, 800);
        assassinText.setForeground(Color.white);
        assassinText.setBackground(Color.BLACK);
        assassinText.setEditable(false);
        assassinPanel.add(assassinText);

	    aspc.setFocusable(false);
        aspc.setIcon(cIcon);
        aspc.setVisible(true);
        aspc.addActionListener(this);
        aspc.setEnabled(true);
        assassinPanel.add(aspc);
        aspc.setBounds(1400, 20, 40, 40);     
        aspc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aspc){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    assassinPanel.setEnabled(false);
                    assassinPanel.setVisible(false);
                    assaultb.setVisible(true);
                    assaultb.setEnabled(true);
                    assassinb.setVisible(true);
                    assassinb.setEnabled(true);
                    healerb.setVisible(true);
                    healerb.setEnabled(true);
                    supportb.setVisible(true);
                    supportb.setEnabled(true);
                    tankb.setVisible(true);
                    tankb.setEnabled(true);
                    helpClose.setEnabled(true);
                    helpClose.setVisible(true);
                }
            }
        });
	
	    healerPanel.setBackground(Color.BLACK);
        healerPanel.setLayout(null);
        healerPanel.setVisible(false);
        healerPanel.setEnabled(false);
        healerPanel.setSize(1600, 800);

        JTextArea healerText = new JTextArea("Healer is a team support unit. \nNormal: does low damage to enemy. \nSkill: heals a character who is alive and \nhas been attacked, and also cancels any \npassive damage. \nSuper: can heal a character that has taken damage, or \nrevive a dead character, and also cancels any \npassive damage.");
        healerText.setVisible(true);
        healerText.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        healerText.setBounds(30, 50, 1600, 800);
        healerText.setForeground(Color.white);
        healerText.setBackground(Color.BLACK);
        healerText.setEditable(false);
        healerPanel.add(healerText);

	    hpc.setFocusable(false);
        hpc.setIcon(cIcon);
        hpc.setVisible(true);
        hpc.addActionListener(this);
        hpc.setEnabled(true);
        healerPanel.add(hpc);
        hpc.setBounds(1400, 20, 40, 40);     
        hpc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == hpc){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    healerPanel.setEnabled(false);
                    healerPanel.setVisible(false);
                    assaultb.setVisible(true);
                    assaultb.setEnabled(true);
                    assassinb.setVisible(true);
                    assassinb.setEnabled(true);
                    healerb.setVisible(true);
                    healerb.setEnabled(true);
                    supportb.setVisible(true);
                    supportb.setEnabled(true);
                    tankb.setVisible(true);
                    tankb.setEnabled(true);
                    helpClose.setEnabled(true);
                    helpClose.setVisible(true);
                }
            }
        });

	    supportPanel.setBackground(Color.BLACK);
        supportPanel.setLayout(null);
        supportPanel.setVisible(false);
        supportPanel.setEnabled(false);
        supportPanel.setSize(1600, 800);

        JTextArea supportText = new JTextArea("Support is a team support unit. \nNormal: does temperate damage to enemy. \nSkill:does moderate damage to enemy and can: \n-freeze the oponent for 1 round \n- reduce the enemy's damage for 1 round (nerf) \n-Increase the atttacking character's damage for 1 round. \nSuper:does high damage to enemy and can: \n-freeze the oponent for 1 round \n- reduce the enemy's damage for 1 round (nerf) \n-Increase the atttacking character's damage for 1 round.");
        supportText.setVisible(true);
        supportText.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        supportText.setBounds(30, 50, 1600, 800);
        supportText.setForeground(Color.white);
        supportText.setBackground(Color.BLACK);
        supportText.setEditable(false);
        supportPanel.add(supportText);


	    spc.setFocusable(false);
        spc.setIcon(cIcon);
        spc.setVisible(true);
        spc.addActionListener(this);
        spc.setEnabled(true);
        supportPanel.add(spc);
        spc.setBounds(1400, 20, 40, 40);     
        spc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == spc){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    supportPanel.setEnabled(false);
                    supportPanel.setVisible(false);
                    assaultb.setVisible(true);
                    assaultb.setEnabled(true);
                    assassinb.setVisible(true);
                    assassinb.setEnabled(true);
                    healerb.setVisible(true);
                    healerb.setEnabled(true);
                    supportb.setVisible(true);
                    supportb.setEnabled(true);
                    tankb.setVisible(true);
                    tankb.setEnabled(true);
                    helpClose.setEnabled(true);
                    helpClose.setVisible(true);
                }
            }
        });


	    tankPanel.setBackground(Color.BLACK);
        tankPanel.setLayout(null);
        tankPanel.setVisible(false);
        tankPanel.setEnabled(false);
        tankPanel.setSize(1600,800);

        JTextArea tankText = new JTextArea("Tank is a team defense unit with high \nHP(Hit points/ Health) and damage reduction. \nNormal: does low damage to enemy. \nSkill: does moderate damage to enemy, and increases \nshield strength for 1 round. \nSuper: does moderate damage to enemy, and makes \nshield impenetrable for 1 round");
        tankText.setVisible(true);
        tankText.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        tankText.setBounds(30, 50, 1600, 800);
        tankText.setForeground(Color.white);
        tankText.setBackground(Color.BLACK);
        tankText.setEditable(false);
        tankPanel.add(tankText);

	    tpc.setFocusable(false);
        tpc.setIcon(cIcon);
        tpc.setVisible(true);
        tpc.addActionListener(this);
        tpc.setEnabled(true);
        tankPanel.add(tpc);
        tpc.setBounds(1400, 20, 40, 40);     
        tpc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tpc){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    tankPanel.setEnabled(false);
                    tankPanel.setVisible(false);
                    //helpPanel.setVisible(true);
                    //helpPanel.setEnabled(true);
                    assaultb.setVisible(true);
                    assaultb.setEnabled(true);
                    assassinb.setVisible(true);
                    assassinb.setEnabled(true);
                    healerb.setVisible(true);
                    healerb.setEnabled(true);
                    supportb.setVisible(true);
                    supportb.setEnabled(true);
                    tankb.setVisible(true);
                    tankb.setEnabled(true);
                    helpClose.setEnabled(true);
                    helpClose.setVisible(true);
                }
            }
        });

	
	helpPanel.add(assaultPanel);
	helpPanel.add(assassinPanel);
	helpPanel.add(healerPanel);
	helpPanel.add(supportPanel);
	helpPanel.add(tankPanel);




	    assaultb.setVisible(true);
        assaultb.setEnabled(true);
        assaultb.setBounds(400, 100, 700, 100);
        assaultb.addActionListener(this);
        assaultb.setText("assault");
        assaultb.setFocusable(false);
        assaultb.setFont(new Font("Comic Sans", Font.BOLD,80));
        assaultb.setBorder(BorderFactory.createCompoundBorder());
        helpPanel.add(assaultb);
	    assaultb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== assaultb){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
			    assaultPanel.setVisible(true);
		        assaultPanel.setEnabled(true);
		        //helpPanel.setVisible(false);
		        //helpPanel.setEnabled(false);
                assaultb.setVisible(false);
                assaultb.setEnabled(false);
                assassinb.setVisible(false);
                assassinb.setEnabled(false);
                healerb.setVisible(false);
                healerb.setEnabled(false);
                supportb.setVisible(false);
                supportb.setEnabled(false);
                tankb.setVisible(false);
                tankb.setEnabled(false);
                helpClose.setVisible(false);
                helpClose.setEnabled(false);
                
                    
                }
            }
        });

	    assassinb.setVisible(true);
        assassinb.setEnabled(true);
        assassinb.setBounds(400, 220, 700, 100);
        assassinb.addActionListener(this);
        assassinb.setText("assassin");
        assassinb.setFocusable(false);
        assassinb.setFont(new Font("Comic Sans", Font.BOLD,80));
        assassinb.setBorder(BorderFactory.createCompoundBorder());
        helpPanel.add(assassinb);
	    assassinb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== assassinb){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    assassinPanel.setVisible(true);
		            assassinPanel.setEnabled(true);
                    //helpPanel.setVisible(false);
                    //helpPanel.setEnabled(false);
                    assaultb.setVisible(false);
                    assaultb.setEnabled(false);
                    assassinb.setVisible(false);
                    assassinb.setEnabled(false);
                    healerb.setVisible(false);
                    healerb.setEnabled(false);
                    supportb.setVisible(false);
                    supportb.setEnabled(false);
                    tankb.setVisible(false);
                    tankb.setEnabled(false);
                    helpClose.setVisible(false);
                    helpClose.setEnabled(false);
                }
            }
        });

	    healerb.setVisible(true);
        healerb.setEnabled(true);
        healerb.setBounds(400, 340, 700, 100);
        healerb.addActionListener(this);
        healerb.setText("healer");
        healerb.setFocusable(false);
        healerb.setFont(new Font("Comic Sans", Font.BOLD,80));
        healerb.setBorder(BorderFactory.createCompoundBorder());
        helpPanel.add(healerb);
	    healerb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== healerb){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    healerPanel.setVisible(true);
                    healerPanel.setEnabled(true);
                    //helpPanel.setVisible(false);
                    //helpPanel.setEnabled(false);
                    assaultb.setVisible(false);
                    assaultb.setEnabled(false);
                    assassinb.setVisible(false);
                    assassinb.setEnabled(false);
                    healerb.setVisible(false);
                    healerb.setEnabled(false);
                    supportb.setVisible(false);
                    supportb.setEnabled(false);
                    tankb.setVisible(false);
                    tankb.setEnabled(false);
                    helpClose.setVisible(false);
                    helpClose.setEnabled(false);
                }
            }
        });

	    supportb.setVisible(true);
        supportb.setEnabled(true);
        supportb.setBounds(400, 450, 700, 100);
        supportb.addActionListener(this);
        supportb.setText("support");
        supportb.setFocusable(false);
        supportb.setFont(new Font("Comic Sans", Font.BOLD,80));
        supportb.setBorder(BorderFactory.createCompoundBorder());
        helpPanel.add(supportb);
	    supportb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== supportb){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    supportPanel.setVisible(true);
                    supportPanel.setEnabled(true);
                    //helpPanel.setVisible(false);
                    //helpPanel.setEnabled(false);
                    assaultb.setVisible(false);
                    assaultb.setEnabled(false);
                    assassinb.setVisible(false);
                    assassinb.setEnabled(false);
                    healerb.setVisible(false);
                    healerb.setEnabled(false);
                    supportb.setVisible(false);
                    supportb.setEnabled(false);
                    tankb.setVisible(false);
                    tankb.setEnabled(false);
                    helpClose.setVisible(false);
                    helpClose.setEnabled(false);
                }
            }
        });

	    tankb.setVisible(true);
        tankb.setEnabled(true);
        tankb.setBounds(400, 580, 700, 100);
        tankb.addActionListener(this);
        tankb.setText("tank");
        tankb.setFocusable(false);
        tankb.setFont(new Font("Comic Sans", Font.BOLD,80));
        tankb.setBorder(BorderFactory.createCompoundBorder());
        helpPanel.add(tankb);
	    tankb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== tankb){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    tankPanel.setVisible(true);
                    tankPanel.setEnabled(true);
                    //helpPanel.setVisible(false);
                    //helpPanel.setEnabled(false);
                    assaultb.setVisible(false);
                    assaultb.setEnabled(false);
                    assassinb.setVisible(false);
                    assassinb.setEnabled(false);
                    healerb.setVisible(false);
                    healerb.setEnabled(false);
                    supportb.setVisible(false);
                    supportb.setEnabled(false);
                    tankb.setVisible(false);
                    tankb.setEnabled(false);
                    helpClose.setVisible(false);
                    helpClose.setEnabled(false);
                }
            }
        });
        assaultPanel1 = new JPanel();
        assassinPanel1 = new JPanel();
        healerPanel1 = new JPanel();
        supportPanel1 = new JPanel();
        tankPanel1 = new JPanel();

        assaultPanel1.setBackground(Color.BLACK);
        assaultPanel1.setLayout(null);
        assaultPanel1.setVisible(false);
        assaultPanel1.setEnabled(false);
        assaultPanel1.setSize(1600,800);

        JTextArea assaultText1 = new JTextArea("Assault is a heavy damage dealer. \nNormal: does temperate damage to enemy. \nSkill: does moderate damage to enemy. \nSuper: does heavy damage to enemy.");
        assaultText1.setVisible(true);
        assaultText1.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        assaultText1.setBounds(30, 50, 1600, 800);
        assaultText1.setForeground(Color.white);
        assaultText1.setBackground(Color.BLACK);
        assaultText1.setEditable(false);
        assaultPanel1.add(assaultText1);

        apc1 = new JButton();
        aspc1 = new JButton();
        hpc1 = new JButton();
        spc1 = new JButton();
        tpc1 = new JButton();
	    apc1.setFocusable(false);
        apc1.setIcon(cIcon);
        apc1.setVisible(true);
        apc1.addActionListener(this);
        apc1.setEnabled(true);
        assaultPanel1.add(apc1);
        apc1.setBounds(1400, 20, 40, 40);     
        apc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == apc1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    assaultPanel1.setEnabled(false);
                    assaultPanel1.setVisible(false);
                    assaultb1.setVisible(true);
                    assaultb1.setEnabled(true);  
                    assassinb1.setVisible(true);
                    assassinb1.setEnabled(true);
                    healerb1.setVisible(true);
                    healerb1.setEnabled(true);
                    supportb1.setVisible(true);
                    supportb1.setEnabled(true);
                    tankb1.setVisible(true);
                    tankb1.setEnabled(true);
                    helpClose1.setEnabled(true);
                    helpClose1.setVisible(true);
                }
            }
        });

	    assassinPanel1.setBackground(Color.BLACK);
        assassinPanel1.setLayout(null);
        assassinPanel1.setVisible(false);
        assassinPanel1.setEnabled(false);
        assassinPanel1.setSize(1600,800);

        JTextArea assassinText1 = new JTextArea("Assassin is a secondary damage dealer. \nNormal: does temperate damage to enemy. \nSkill: does moderate damge to enemy and \ninflicts passive damage for the next 2 rounds. \nSuper: does modest damge to enemy and \ninflicts passive damage for the next 4 rounds .");
        assassinText1.setVisible(true);
        assassinText1.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        assassinText1.setBounds(30, 50, 1600, 800);
        assassinText1.setForeground(Color.white);
        assassinText1.setBackground(Color.BLACK);
        assassinText1.setEditable(false);
        assassinPanel1.add(assassinText1);

	    aspc1.setFocusable(false);
        aspc1.setIcon(cIcon);
        aspc1.setVisible(true);
        aspc1.addActionListener(this);
        aspc1.setEnabled(true);
        assassinPanel1.add(aspc1);
        aspc1.setBounds(1400, 20, 40, 40);     
        aspc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aspc1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    assassinPanel1.setEnabled(false);
                    assassinPanel1.setVisible(false);
                    assaultb1.setVisible(true);
                    assaultb1.setEnabled(true);
                    assassinb1.setVisible(true);
                    assassinb1.setEnabled(true);
                    healerb1.setVisible(true);
                    healerb1.setEnabled(true);
                    supportb1.setVisible(true);
                    supportb1.setEnabled(true);
                    tankb1.setVisible(true);
                    tankb1.setEnabled(true);
                    helpClose1.setEnabled(true);
                    helpClose1.setVisible(true);
                }
            }
        });
	
	    healerPanel1.setBackground(Color.BLACK);
        healerPanel1.setLayout(null);
        healerPanel1.setVisible(false);
        healerPanel1.setEnabled(false);
        healerPanel1.setSize(1600,800);

        JTextArea healerText1 = new JTextArea("Healer is a team support unit. \nNormal: does low damage to enemy. \nSkill: heals a character who is alive and \nhas been attacked, and also cancels any \npassive damage. \nSuper: can heal a character that has taken damage, or \nrevive a dead character, and also cancels any \npassive damage.");
        healerText1.setVisible(true);
        healerText1.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        healerText1.setBounds(30, 50, 1600, 800);
        healerText1.setForeground(Color.white);
        healerText1.setBackground(Color.BLACK);
        healerText1.setEditable(false);
        healerPanel1.add(healerText1);

	    hpc1.setFocusable(false);
        hpc1.setIcon(cIcon);
        hpc1.setVisible(true);
        hpc1.addActionListener(this);
        hpc1.setEnabled(true);
        healerPanel1.add(hpc1);
        hpc1.setBounds(1400, 20, 40, 40);     
        hpc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == hpc1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    healerPanel1.setEnabled(false);
                    healerPanel1.setVisible(false);
                    assaultb1.setVisible(true);
                    assaultb1.setEnabled(true);
                    assassinb1.setVisible(true);
                    assassinb1.setEnabled(true);
                    healerb1.setVisible(true);
                    healerb1.setEnabled(true);
                    supportb1.setVisible(true);
                    supportb1.setEnabled(true);
                    tankb1.setVisible(true);
                    tankb1.setEnabled(true);
                    helpClose1.setEnabled(true);
                    helpClose1.setVisible(true);
                }
            }
        });

	    supportPanel1.setBackground(Color.BLACK);
        supportPanel1.setLayout(null);
        supportPanel1.setVisible(false);
        supportPanel1.setEnabled(false);
        supportPanel1.setSize(1600,800);

        JTextArea supportText1 = new JTextArea("Support is a team support unit. \nNormal: does temperate damage to enemy. \nSkill:does moderate damage to enemy and can: \n-freeze the oponent for 1 round \n- reduce the enemy's damage for 1 round (nerf) \n-Increase the atttacking character's damage for 1 round. \nSuper:does high damage to enemy and can: \n-freeze the oponent for 1 round \n- reduce the enemy's damage for 1 round (nerf) \n-Increase the atttacking character's damage for 1 round.");
        supportText1.setVisible(true);
        supportText1.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        supportText1.setBounds(30, 50, 1600, 800);
        supportText1.setForeground(Color.white);
        supportText1.setBackground(Color.BLACK);
        supportText1.setEditable(false);
        supportPanel1.add(supportText1);


	    spc1.setFocusable(false);
        spc1.setIcon(cIcon);
        spc1.setVisible(true);
        spc1.addActionListener(this);
        spc1.setEnabled(true);
        supportPanel1.add(spc1);
        spc1.setBounds(1400, 20, 40, 40);     
        spc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == spc1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    supportPanel1.setEnabled(false);
                    supportPanel1.setVisible(false);
                    assaultb1.setVisible(true);
                    assaultb1.setEnabled(true);
                    assassinb1.setVisible(true);
                    assassinb1.setEnabled(true);
                    healerb1.setVisible(true);
                    healerb1.setEnabled(true);
                    supportb1.setVisible(true);
                    supportb1.setEnabled(true);
                    tankb1.setVisible(true);
                    tankb1.setEnabled(true);
                    helpClose1.setEnabled(true);
                    helpClose1.setVisible(true);
                }
            }
        });


	    tankPanel1.setBackground(Color.BLACK);
        tankPanel1.setLayout(null);
        tankPanel1.setVisible(false);
        tankPanel1.setEnabled(false);
        tankPanel1.setSize(1600,800);

        JTextArea tankText1 = new JTextArea("Tank is a team defense unit with high \nHP(Hit points/ Health) and damage reduction. \nNormal: does low damage to enemy. \nSkill: does moderate damage to enemy, and increases \nshield strength for 1 round. \nSuper: does moderate damage to enemy, and makes \nshield impenetrable for 1 round");
        tankText1.setVisible(true);
        tankText1.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        tankText1.setBounds(30, 50, 1600, 800);
        tankText1.setForeground(Color.white);
        tankText1.setBackground(Color.BLACK);
        tankText1.setEditable(false);
        tankPanel1.add(tankText1);

	    tpc1.setFocusable(false);
        tpc1.setIcon(cIcon);
        tpc1.setVisible(true);
        tpc1.addActionListener(this);
        tpc1.setEnabled(true);
        tankPanel1.add(tpc1);
        tpc1.setBounds(1400, 20, 40, 40);     
        tpc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tpc1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    tankPanel1.setEnabled(false);
                    tankPanel1.setVisible(false);
                    //helpPanel1.setVisible(true);
                    //helpPanel1.setEnabled(true);
                    assaultb1.setVisible(true);
                    assaultb1.setEnabled(true);
                    assassinb1.setVisible(true);
                    assassinb1.setEnabled(true);
                    healerb1.setVisible(true);
                    healerb1.setEnabled(true);
                    supportb1.setVisible(true);
                    supportb1.setEnabled(true);
                    tankb1.setVisible(true);
                    tankb1.setEnabled(true);
                    helpClose1.setEnabled(true);
                    helpClose1.setVisible(true);
                }
            }
        });

	
	helpPanel1.add(assaultPanel1);
	helpPanel1.add(assassinPanel1);
	helpPanel1.add(healerPanel1);
	helpPanel1.add(supportPanel1);
	helpPanel1.add(tankPanel1);


        assaultb1 = new JButton();
        assassinb1 = new JButton();
        healerb1 = new JButton();
        supportb1 = new JButton();
        tankb1 = new JButton();

        assaultb1.setEnabled(true);
	    assaultb1.setVisible(true);
        
        assaultb1.setBounds(400, 100, 700, 100);
        assaultb1.addActionListener(this);
        assaultb1.setText("assault");
        assaultb1.setFocusable(false);
        assaultb1.setFont(new Font("Comic Sans", Font.BOLD,80));
        assaultb1.setBorder(BorderFactory.createCompoundBorder());
        helpPanel1.add(assaultb1);
	    assaultb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== assaultb1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                assaultPanel1.setEnabled(true);
			    assaultPanel1.setVisible(true);
		        //helpPanel1.setVisible(false);
		        //helpPanel1.setEnabled(false);
                assaultb1.setVisible(false);
                assaultb1.setEnabled(false);
                assassinb1.setVisible(false);
                assassinb1.setEnabled(false);
                healerb1.setVisible(false);
                healerb1.setEnabled(false);
                supportb1.setVisible(false);
                supportb1.setEnabled(false);
                tankb1.setVisible(false);
                tankb1.setEnabled(false);
                helpClose1.setVisible(false);
                helpClose1.setEnabled(false);
                
                    
                }
            }
        });

	    assassinb1.setVisible(true);
        assassinb1.setEnabled(true);
        assassinb1.setBounds(400, 220, 700, 100);
        assassinb1.addActionListener(this);
        assassinb1.setText("assassin");
        assassinb1.setFocusable(false);
        assassinb1.setFont(new Font("Comic Sans", Font.BOLD,80));
        assassinb1.setBorder(BorderFactory.createCompoundBorder());
        helpPanel1.add(assassinb1);
	    assassinb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== assassinb1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    assassinPanel1.setVisible(true);
		            assassinPanel1.setEnabled(true);
                    //helpPanel1.setVisible(false);
                    //helpPanel1.setEnabled(false);
                    assaultb1.setVisible(false);
                    assaultb1.setEnabled(false);
                    assassinb1.setVisible(false);
                    assassinb1.setEnabled(false);
                    healerb1.setVisible(false);
                    healerb1.setEnabled(false);
                    supportb1.setVisible(false);
                    supportb1.setEnabled(false);
                    tankb1.setVisible(false);
                    tankb1.setEnabled(false);
                    helpClose1.setVisible(false);
                    helpClose1.setEnabled(false);
                }
            }
        });

	    healerb1.setVisible(true);
        healerb1.setEnabled(true);
        healerb1.setBounds(400, 340, 700, 100);
        healerb1.addActionListener(this);
        healerb1.setText("healer");
        healerb1.setFocusable(false);
        healerb1.setFont(new Font("Comic Sans", Font.BOLD,80));
        healerb1.setBorder(BorderFactory.createCompoundBorder());
        helpPanel1.add(healerb1);
	    healerb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== healerb1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    healerPanel1.setVisible(true);
                    healerPanel1.setEnabled(true);
                    //helpPanel1.setVisible(false);
                    //helpPanel1.setEnabled(false);
                    assaultb1.setVisible(false);
                    assaultb1.setEnabled(false);
                    assassinb1.setVisible(false);
                    assassinb1.setEnabled(false);
                    healerb1.setVisible(false);
                    healerb1.setEnabled(false);
                    supportb1.setVisible(false);
                    supportb1.setEnabled(false);
                    tankb1.setVisible(false);
                    tankb1.setEnabled(false);
                    helpClose1.setVisible(false);
                    helpClose1.setEnabled(false);
                }
            }
        });

	    supportb1.setVisible(true);
        supportb1.setEnabled(true);
        supportb1.setBounds(400, 450, 700, 100);
        supportb1.addActionListener(this);
        supportb1.setText("support");
        supportb1.setFocusable(false);
        supportb1.setFont(new Font("Comic Sans", Font.BOLD,80));
        supportb1.setBorder(BorderFactory.createCompoundBorder());
        helpPanel1.add(supportb1);
	    supportb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== supportb1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    supportPanel1.setVisible(true);
                    supportPanel1.setEnabled(true);
                    //helpPanel1.setVisible(false);
                    //helpPanel1.setEnabled(false);
                    assaultb1.setVisible(false);
                    assaultb1.setEnabled(false);
                    assassinb1.setVisible(false);
                    assassinb1.setEnabled(false);
                    healerb1.setVisible(false);
                    healerb1.setEnabled(false);
                    supportb1.setVisible(false);
                    supportb1.setEnabled(false);
                    tankb1.setVisible(false);
                    tankb1.setEnabled(false);
                    helpClose1.setVisible(false);
                    helpClose1.setEnabled(false);
                }
            }
        });

	    tankb1.setVisible(true);
        tankb1.setEnabled(true);
        tankb1.setBounds(400, 580, 700, 100);
        tankb1.addActionListener(this);
        tankb1.setText("tank");
        tankb1.setFocusable(false);
        tankb1.setFont(new Font("Comic Sans", Font.BOLD,80));
        tankb1.setBorder(BorderFactory.createCompoundBorder());
        helpPanel1.add(tankb1);
	    tankb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== tankb1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    tankPanel1.setVisible(true);
                    tankPanel1.setEnabled(true);
                    //helpPanel1.setVisible(false);
                    //helpPanel1.setEnabled(false);
                    assaultb1.setVisible(false);
                    assaultb1.setEnabled(false);
                    assassinb1.setVisible(false);
                    assassinb1.setEnabled(false);
                    healerb1.setVisible(false);
                    healerb1.setEnabled(false);
                    supportb1.setVisible(false);
                    supportb1.setEnabled(false);
                    tankb1.setVisible(false);
                    tankb1.setEnabled(false);
                    helpClose1.setVisible(false);
                    helpClose1.setEnabled(false);
                }
            }
        });

        JPanel pausePanel = new JPanel();
pausePanel.setBackground(Color.BLACK);
        pausePanel.setLayout(null);
        pausePanel.setVisible(false);
        pausePanel.setEnabled(false);
        pausePanel.setSize(1600,800);
	    this.add(pausePanel);
JLabel pauseLabel = new JLabel("Pause");
pausePanel.add(pauseLabel);
pauseLabel.setBounds(550, 150 , 1200, 150);
pauseLabel.setVisible(true);
pauseLabel.setForeground(Color.white);
pauseLabel.setFont(new Font("Press Start 2P",Font.BOLD, 100));


		JButton pauseButton = new JButton("||");
	    pauseButton.setFocusable(false);
        //pauseButton.setIcon(cIcon);
        pauseButton.setVisible(true);
        pauseButton.addActionListener(this);
        pauseButton.setEnabled(true);
        pauseButton.setBounds(1200, 40, 40, 40);  
	    fightPane.add(pauseButton,JLayeredPane.DRAG_LAYER);   
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == pauseButton){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    pausePanel.setEnabled(true);
                    pausePanel.setVisible(true);
		            fightPane.setVisible(false);
                    fightPane.setEnabled(false);
                    
                }
            }
        });

	    JButton pauseClose = new JButton();
	    pauseClose.setFocusable(false);
        pauseClose.setIcon(cIcon);
        pauseClose.setVisible(true);
        pauseClose.addActionListener(this);
        pauseClose.setEnabled(true);
        pauseClose.setBounds(1400, 20, 40, 40); 
	    pausePanel.add(pauseClose);    
        pauseClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == pauseClose){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
		    pausePanel.setVisible(false);
		    pausePanel.setEnabled(false);
            fightPane.setEnabled(true);
            fightPane.setVisible(true);
                }
            }
        });


        JButton Home1 = new JButton();
        Home1.addActionListener(this);
        Home1.setText("Home");
        Home1.setFocusable(false);
        Home1.setFont(new Font("Comic Sans", Font.BOLD,80));       
        Home1.setBorder(BorderFactory.createCompoundBorder());
        Home1.setEnabled(true);
        Home1.setVisible(true);
        pausePanel.add(Home1);
        Home1.setBounds(950,400,400,100);
        Home1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Home1){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    Player1.setVisible(true);
                    Player2.setVisible(true);
                    Player11.setText("");
                    Player12.setText("");
                    Player13.setText("");
                    Player21.setText("");
                    Player22.setText("");
                    Player23.setText("");
                    turn = 1;
                    p1reset();
                    p2reset();

                    p1 = new Player();
                    p2 = null;
                    D2 = null;
                    selected = 0;
                    r = 1;
                    if (pvp){
                        fightPanelLabel.setText("Round "+r+ " Player "+turn+" turn" );
                    }
                    else{
                        fightPanelLabel.setText("       Round "+r );
                    }
                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);
                    bleed1.setVisible(false);
                    bleed2.setVisible(false);
                    freeze1.setVisible(false);
                    freeze2.setVisible(false);

                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

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

                    p1d1.setBounds(410,270,100,100);
                    p1d2.setBounds(560,350,100,100);
                    p1d3.setBounds(410,430,100,100);

                    p11d.setBounds(410, 270,100,100);
                    p12d.setBounds(560, 350,100,100);
                    p13d.setBounds(410, 430,100,100);

                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);



                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(950,350,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p22d.setBounds(950, 350,100,100);
                    p23d.setBounds(1100, 430,100,100);


                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    pausePanel.setVisible(false);
                    pausePanel.setEnabled(false);
                    fightPane.setVisible(false);
                    fightPane.setEnabled(false);
                    startPane.setEnabled(true);
                    startPane.setVisible(true);
                    NextB2.setEnabled(false);
                }
            }
        });

        JButton restart = new JButton();
        restart.addActionListener(this);
        restart.setText("Restart");
        restart.setFocusable(false);
        restart.setFont(new Font("Comic Sans", Font.BOLD,80));
        restart.setBorder(BorderFactory.createCompoundBorder());
        restart.setEnabled(true);
        restart.setVisible(true);
	    pausePanel.add(restart);
	    restart.setBounds(150,400,400,100);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == restart){
                    try{
                            playClick();
                        }
                        catch(IOException ex){
                            ex.getStackTrace();
                        }
                        catch(UnsupportedAudioFileException g){
                            g.getStackTrace();
                        }
                        catch(LineUnavailableException f){
                            f.getStackTrace();
                        } 
                    D2 = "";   
                    
                    turn = 1;
                    r = 1;
		            p1.alive = 3;
                    if(p1.FindAssassin()){
                        p1.assassin. CutCount = 0;
                    }
                    if(p1.FindSupport()){
                        p1.support.up = 0;
                        p1.support.nerfs = 0;
                    }
                    if (pvp){
                        fightPanelLabel.setText("Round "+r+ " Player "+turn+" turn" );
                        defendPanelLabel.setText("Player 1 choose your defending hero");
			            p2.alive = 3;
                        if(p2.FindAssassin()){
                            p2.assassin.CutCount = 0;
                        }
                        if(p2.FindSupport()){
                            p2.support.up = 0;
                            p2.support.nerfs = 0;
                        }
                    }
                    else{
                        defendPanelLabel.setText("Choose your defending hero");
                        fightPanelLabel.setText("       Round "+r );
			            computer.alive = 3;
                        if(computer.FindAssassin()){
                            computer.assassin.CutCount = 0;
                        }
                        if(computer.FindSupport()){
                            computer.support.up = 0;
                            computer.support.nerfs = 0;
                        }
                    }
                    
                    m1.get(HA1.getText()).HP = m1.get(HA1.getText()).cHP;
                    m1.get(HA1.getText()).Energy = 0;
                    
                    m1.get(HA2.getText()).HP = m1.get(HA2.getText()).cHP;
                    m1.get(HA2.getText()).Energy = 0;
                    
                    m1.get(HA3.getText()).HP = m1.get(HA3.getText()).cHP;
                    m1.get(HA3.getText()).Energy = 0;

                
                    m2.get(HB1.getText()).HP = m2.get(HB1.getText()).cHP;
                    m2.get(HB1.getText()).Energy = 0;
                    m2.get(HB2.getText()).HP = m2.get(HB2.getText()).cHP;
                    m2.get(HB2.getText()).Energy = 0;    
                    m2.get(HB3.getText()).HP = m2.get(HB3.getText()).cHP;
                    m2.get(HB3.getText()).Energy = 0;

                    p1reset();
                    p2reset();
                    p1resetd();
                    p2resetd();

                    p1a1l.setText(String.valueOf(m1.get(HA1.getText()).cHP));
                    p1a2l.setText(String.valueOf(m1.get(HA2.getText()).cHP));
                    p1a3l.setText(String.valueOf(m1.get(HA3.getText()).cHP));

                    p1life1l.setText(String.valueOf(m1.get(HA1.getText()).cHP));
                    p1life2l.setText(String.valueOf(m1.get(HA2.getText()).cHP));
                    p1life3l.setText(String.valueOf(m1.get(HA3.getText()).cHP));
                    p1health1l.setText(String.valueOf(m1.get(HA1.getText()).cHP));
                    p1health2l.setText(String.valueOf(m1.get(HA2.getText()).cHP));
                    p1health3l.setText(String.valueOf(m1.get(HA3.getText()).cHP));

                    p2a1l.setText(String.valueOf(m2.get(HB1.getText()).cHP));
                    p2a2l.setText(String.valueOf(m2.get(HB2.getText()).cHP));
                    p2a3l.setText(String.valueOf(m2.get(HB3.getText()).cHP));

                    p2life1l.setText(String.valueOf(m2.get(HB1.getText()).cHP));
                    p2life2l.setText(String.valueOf(m2.get(HB2.getText()).cHP));
                    p2life3l.setText(String.valueOf(m2.get(HB3.getText()).cHP));

                    p2health1l.setText(String.valueOf(m2.get(HB1.getText()).cHP));
                    p2health2l.setText(String.valueOf(m2.get(HB2.getText()).cHP));
                    p2health3l.setText(String.valueOf(m2.get(HB3.getText()).cHP));

                    p1d1l.setVisible(false);
                    p1d2l.setVisible(false);
                    p1d3l.setVisible(false);

                    p2d1l.setVisible(false);
                    p2d2l.setVisible(false);
                    p2d3l.setVisible(false);

                    freeze1.setVisible(false);
                    freeze2.setVisible(false);
                    bleed1.setVisible(false);
                    bleed2.setVisible(false);
                    p1d1.setEnabled(true);
                    p1d2.setEnabled(true);
                    p1d3.setEnabled(true);
                    
                    fa1.setEnabled(true);
                    fa2.setEnabled(true);
                    fa3.setEnabled(true);

                    p2d1.setEnabled(false);
                    p2d2.setEnabled(false);
                    p2d3.setEnabled(false);
                    pausePanel.setEnabled(false);
                    pausePanel.setVisible(false);
                    fightPane.setVisible(false);
                    fightPane.setEnabled(false);
                    defendPane.setEnabled(true);
                    defendPane.setVisible(true);

                    p1e1.setText("Energy: "+ m1.get(HA1.getText()).Energy);
                    p1attack1.setText("Attack Strength: "+ m1.get(HA1.getText()).Attack);
                    p1e2.setText("Energy: "+ m1.get(HA2.getText()).Energy);
                    p1attack2.setText("Attack Strength: "+ m1.get(HA2.getText()).Attack);
                    p1e3.setText("Energy: "+ m1.get(HA3.getText()).Energy);
                    p1attack3.setText("Attack Strength: "+ m1.get(HA3.getText()).Attack);



                    p2e1.setText("Energy: "+ m2.get(HB1.getText()).Energy);
                    p2attack1.setText("Attack Strength: "+ m2.get(HB1.getText()).Attack);
                    p2e2.setText("Energy: "+ m2.get(HB2.getText()).Energy);
                    p2attack2.setText("Attack Strength: "+ m2.get(HB2.getText()).Attack);
                    p2e3.setText("Energy: "+ m2.get(HB3.getText()).Energy);
                    p2attack3.setText("Attack Strength: "+ m2.get(HB3.getText()).Attack);

                    p11d.setBackground(Color.WHITE);
                    p12d.setBackground(Color.WHITE);
                    p13d.setBackground(Color.WHITE);

                    p21d.setBackground(null);
                    p22d.setBackground(null);
                    p23d.setBackground(null);
                    p21f.setBackground(null);
                    p22f.setBackground(null);
                    p23f.setBackground(null);
                    p21h.setBackground(null);
                    p22h.setBackground(null);
                    p23h.setBackground(null);
                    p21d.setOpaque(false);
                    p22d.setOpaque(false);
                    p23d.setOpaque(false);
                    p1d1.setBounds(410,270,100,100);
                    p1d2.setBounds(560,350,100,100);
                    p1d3.setBounds(410,430,100,100);       

                    p11d.setBounds(410, 270,100,100);
                    p11f.setBounds(410, 270,100,100);
                    p11h.setBounds(410, 270,100,100);

                    p12d.setBounds(560, 350,100,100);
                    p12f.setBounds(560, 350,100,100);
                    p12h.setBounds(560, 350,100,100);

                    p13d.setBounds(410, 430,100,100);
                    p13f.setBounds(410, 430,100,100);
                    p13h.setBounds(410, 430,100,100);

                    charda1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charda2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charda3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charha1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charha2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charha3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);
                    charfa1.setBounds(p11d.getX()+20, p11d.getY()+100, 100, 40);
                    charfa2.setBounds(p12d.getX()+20, p12d.getY()+100, 100, 40);
                    charfa3.setBounds(p13d.getX()+20, p13d.getY()+100, 100, 40);


                    fa1.setBounds(410,270,100,100);
                    fa2.setBounds(560,350,100,100);
                    fa3.setBounds(410,430,100,100);

                    HA1.setBounds(410,270,100,100);
                    HA2.setBounds(560,350,100,100);
                    HA3.setBounds(410,430,100,100);

                    p1d1l.setBounds(570, 295,300,50);
                    p1d2l.setBounds(570, 295,300,50);
                    p1d3l.setBounds(570, 295,300,50);

                    p1a1l.setBounds(420,400,300,50);
                    p1a2l.setBounds(570,480,300,50);
                    p1a3l.setBounds(420,550,300,50);

                    p1life1l.setBounds(420,400,300,50);
                    p1life2l.setBounds(570,480,300,50);
                    p1life3l.setBounds(420,550,300,50);

                    p1health1l.setBounds(420,400,300,50);
                    p1health2l.setBounds(570,480,300,50);
                    p1health3l.setBounds(420,550,300,50);

                    p2d1.setBounds(1100,270,100,100);
                    p2d2.setBounds(950,350,100,100);
                    p2d3.setBounds(1100,430,100,100);

                    p21d.setBounds(1100, 270,100,100);
                    p21f.setBounds(1100, 270,100,100);
                    p21h.setBounds(1100, 270,100,100);

                    p22d.setBounds(950, 350,100,100);
                    p22f.setBounds(950, 350,100,100);
                    p22h.setBounds(950, 350,100,100);

                    p23d.setBounds(1100, 430,100,100);
                    p23f.setBounds(1100, 430,100,100);
                    p23h.setBounds(1100, 430,100,100);

                    chardb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    chardb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    chardb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charfb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charfb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charfb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);
                    charhb1.setBounds(p21d.getX(), p21d.getY()+100, 100, 40);
                    charhb2.setBounds(p22d.getX(), p22d.getY()+100, 100, 40);
                    charhb3.setBounds(p23d.getX(), p23d.getY()+100, 100, 40);

                    fb1.setBounds(1100,270,100,100);
                    fb2.setBounds(950,350,100,100);
                    fb3.setBounds(1100,430,100,100);

                    HB1.setBounds(1100,270,100,100);
                    HB2.setBounds(950,350,100,100);
                    HB3.setBounds(1100,430,100,100);

                    p2d1l.setBounds(920,295,300,50);
                    p2d2l.setBounds(920,295,300,50);
                    p2d3l.setBounds(920,295,300,50);

                    p2a1l.setBounds(1100,400,300,50);
                    p2a2l.setBounds(950,480,300,50);
                    p2a3l.setBounds(1100,550,300,50);

                    p2life1l.setBounds(1100,400,300,50);
                    p2life2l.setBounds(950,480,300,50);
                    p2life3l.setBounds(1100,550,300,50);

                    p2health1l.setBounds(1100,400,300,50);
                    p2health2l.setBounds(950,480,300,50);
                    p2health3l.setBounds(1100,550,300,50);

                    p11d.setOpaque(true);
                    p12d.setOpaque(true);
                    p13d.setOpaque(true);

                    p11d.setBackground(Color.WHITE);
                    p12d.setBackground(Color.WHITE);
                    p13d.setBackground(Color.WHITE);

                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== startButton){
            try{
                playHit();
            }
            catch(IOException ex){
                ex.getStackTrace();
            }
            catch(UnsupportedAudioFileException g){
                g.getStackTrace();
            }
            catch(LineUnavailableException f){
                f.getStackTrace();
            }  
            startPane.setVisible(false);
            startPane.setEnabled(false);
            pane1.setVisible(true);
            pane1.setEnabled(true);
            //thePane.setVisible(true);
            //thePane.setEnabled(true);
        }
    }

}
