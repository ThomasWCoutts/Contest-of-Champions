import java.util.*;

public class Assault extends Hero{

	public Assault(){
	super("assault");
	}

			
	public void DisplayStats(){
		System.out.println("Assault");
		System.out.println("HP: "+ HP);
		System.out.println("Attack: "+ Attack);
		System.out.println("Defense: "+ Defense);
		System.out.println("Crit: "+ Crit);
		System.out.println("Dexterity: "+ Dexterity);
		System.out.println("Energy: "+ Energy);
	}

	@Override
	public int Normal(){
		Random RandomNumber = new Random();
		int Hit = Attack;
		if (Hit == Crit){
			Hit += 23;
		}
		Attack = RandomNumber.nextInt(181-150)+150;
		Energy += 25;
		return Hit;
	}
	
	@Override
	public int Skill(){
		Random RandomNumber = new Random();
		double Damage = Attack;
		Attack = RandomNumber.nextInt(181-150)+150;
		Damage = Damage * 1.8;
		int D = (int) Damage;
		if (Attack == Crit){
			D +=30;
		}
		Energy += 35;
		return D;
	}
	
	@Override
	public int Super(){
		Random RandomNumber = new Random();
		int Power = (Attack * 3) + 69;
		if (Attack == Crit){
			Power += 37; 
		}
		Energy = 50;
		Attack = RandomNumber.nextInt(181-150)+150;
		return Power;
	}

	
}