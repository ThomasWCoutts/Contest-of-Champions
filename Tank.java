import java.util.*;

public class Tank extends Hero{
	int Shield;

	public Tank(){
	super("tank");
		Shield = 50;
		
	}

	
	public void DisplayStats(){
		System.out.println("Tank");
		System.out.println("HP: "+ HP);
		System.out.println("Attack: "+ Attack);
		System.out.println("Defense: "+ Defense);
		System.out.println("Crit: "+ Crit);
		System.out.println("Dexterity: "+ Dexterity);
		System.out.println("Energy: "+ Energy);
		System.out.println("Shield: "+ Shield);
	}
	
	@Override
	public int Normal(){
		Random RandomNumber = new Random();
		int Hit = Attack;
		if (Hit == Crit){
			Hit = Hit + 15;
		}
		Attack = RandomNumber.nextInt(101-80)+80;
		Energy += 25;
		return Hit;
		
	}

	@Override
	public int Skill(){
		double Damage = Attack;
		Damage = Damage * 1.8;
		int D = (int) Damage;
		Energy += 35;
		return D;
	}
	
	@Override
	public int Super(){
		int Power = (Attack * 2);
		if (Attack == Crit){
			Power += 30; 
		}
		Energy = 50;
		Shield = 1000;
		return Power;
	}
	
}
	