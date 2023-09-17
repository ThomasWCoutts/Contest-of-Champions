import java.util.Random;

public class Hero {
	int HP;
	int cHP;
	int Attack;
	int Defense;
	int Dexterity;
    int Crit;
	int Energy;
	String Class;
    int Shield;

    public Hero(String type){
        Random RandomNumber = new Random();
        switch (type){
            case  "assault":
                Energy = 0;
                Attack = RandomNumber.nextInt(181-150)+150;
                Crit = 180;
                HP = RandomNumber.nextInt(1201-1000)+1000;
                Defense = RandomNumber.nextInt(26-15)+15;
                Dexterity = RandomNumber.nextInt(31 - 20)+20;
                Class = "assault";
                cHP = HP;
                break;
            case "assassin":
                
                Energy = 0;
                Crit = 140;
                Attack = RandomNumber.nextInt(141-110)+110;
                HP = RandomNumber.nextInt(1001-850)+850;
                Defense = RandomNumber.nextInt(16-5)+5;
                Dexterity = RandomNumber.nextInt(46 - 35)+35;
                cHP = HP;
                Class = "assassin";
                break;
            case "healer":
                
                Energy = 0;
                Attack = RandomNumber.nextInt(81-60)+60;
                HP = RandomNumber.nextInt(1201-1000)+1000;
                Defense = RandomNumber.nextInt(21-10)+10;
                Dexterity = RandomNumber.nextInt(16- 10)+10;
                Class = "healer";
                cHP = HP;
                break;
            case "support":
                
                Energy = 0;
                Crit = 130;
                Attack = RandomNumber.nextInt(131-100)+100;
                HP = RandomNumber.nextInt(1401-1200)+1200;
                Defense = RandomNumber.nextInt(26-15)+15;
                Dexterity = RandomNumber.nextInt(31 - 20)+20;
                Class = "support";
                cHP = HP;
                break;
            case "tank":
                
                Energy = 0;
                Crit =100;
                Attack = RandomNumber.nextInt(101-80)+80;
                HP = RandomNumber.nextInt(1801-1600)+1600;
                Defense = RandomNumber.nextInt(41-30)+30;
                Dexterity = RandomNumber.nextInt(13 - 8 )+ 8;
                Class = "tank";
                cHP = HP;
                break;
            default:
                System.out.println("You can't code ka boy");
        }
		
    }
    public int Normal(){
        return 1;
    }
    public int Skill(){
        return 1;
    }
    public int Super(){
        return 1;
    }
}
