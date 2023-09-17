import java.util.*;

public class Healer extends Hero{
	int HealPotency;
	int revs;

	public Healer(){
	super("healer");
		double Health = HP;
		HealPotency = (int) (Health * 0.3);
	}

	
	public void DisplayStats(){
		System.out.println("Healer");
		System.out.println("HP: "+ HP);
		System.out.println("Attack: "+ Attack);
		System.out.println("Defense: "+ Defense);
		System.out.println("Dexterity: "+ Dexterity);
		System.out.println("Heal Potency: "+ HealPotency);
		System.out.println("Energy: "+ Energy);
	}
	
	@Override
	public int Normal(){
		Random RandomNumber = new Random();
		int Hit = Attack;
		Attack = RandomNumber.nextInt(81-60)+60;
		Energy += 25;
		return Hit;
	}

	@Override
	public int Skill(){
		int Heal = HealPotency;
		Energy += 35;
		return Heal;
	}
	
	@Override
	public int Super(){
		double H = HealPotency; 
		int Up = (int) (H * 1.8);
		Energy = 50;
		return Up;
	}
	
}
