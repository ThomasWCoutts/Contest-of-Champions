import java.util.*;

public class Assassin extends Hero{
	int Bleed;
	int CutCount;

	public Assassin(){
	super("assassin");
		double P = Attack;
		Bleed =(int) (P/2.0);
		CutCount = 0;
	}
	
	
	public void DisplayStats(){
		System.out.println("Assassin");
		System.out.println("HP: "+ HP);
		System.out.println("Attack: "+ Attack);
		System.out.println("Defense: "+ Defense);
		System.out.println("Crit: "+ Crit);
		System.out.println("Dexterity: "+ Dexterity);
		System.out.println("Energy: "+ Energy);
		System.out.println("Bleed: "+ Bleed);
	}

	@Override
	public int Normal(){
		Random RandomNumber = new Random();
		int Hit = Attack;
		if (Hit == Crit){
			Hit += 16;
		}
		Attack = RandomNumber.nextInt(141-110)+110;
		Energy += 25;
		CutCount--;
		return Hit;
		
	}
	
	
	public void Cut(){
		CutCount += 2;
		return;
	}		

	@Override
	public int Skill(){
		Random RandomNumber = new Random();
		double Damage = Attack;
		Damage = Damage * 1.8;
		int D = (int) Damage;
		Energy += 35;
		Cut();
		Attack = RandomNumber.nextInt(141-110)+110;
		return D;
	}
	
	@Override
	public int Super(){
		Random RandomNumber = new Random();
		int Power = (Attack * 2) + 50;
		if (Attack == Crit){
			Power += 27; 
		}
		Cut();
		Cut();
		Energy = 50;
		Attack = RandomNumber.nextInt(141-110)+110;
		return Power;
	}

}