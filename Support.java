import java.util.*;

public class Support extends Hero{
	String[] Skills = new String[3];
	int Skips;
	int up;
	int nerfs;
	int boost;
	int dec;

	public Support(){
	super("support");
		Skips = 0;
		Skills[0] = "Buff";
		Skills[1] = "Freeze";
		Skills[2] = "Nerf"; 
		up = 0;
		boost = 0;
		nerfs = 0;
		dec = (Defense*2);
		Skips = 0;
		boost = Attack;
	}

	
	public void DisplayStats(){
		System.out.println("Support");
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
			Hit += 16;
		}
		Attack = RandomNumber.nextInt(131-100)+100;
		Energy += 25;
		return Hit;
	}
	
	
	public int Buff(){
		return boost+200;
	}

	
	public void Freeze(){
		Skips ++;
		return;
	}

	
	public int Nerf(){
		nerfs = 1;
		return dec;
	}

	@Override
	public int Skill(){
		Random RandomNumber = new Random();
		double Damage = Attack;
		Damage = Damage * 1.8;
		int D = (int) Damage;
		if (Attack == Crit){
			D +=18;
		}
		int x = RandomNumber.nextInt(3);
		String Ability = Skills[x];
		switch (Ability){
			case "Buff":
				Buff();		
				break;
			case "Nerf":
				Nerf();
				break;
			case "Freeze":
				Freeze();
				break;
			default:
				System.out.println("no ability was used");
		}
		Attack = RandomNumber.nextInt(131-100)+100;
		Energy += 35;
		return D;
	}
	
	@Override
	public int Super(){
		Random RandomNumber = new Random();	
		int Power = (Attack * 2) + 30;
		if (Attack == Crit){
			Power += 24; 
		}
		int x = RandomNumber.nextInt(3);
		String Ability = Skills[x];
		switch (Ability){
			case "Buff":
				boost = (Buff()+400);
				break;
			case "Nerf":
				dec = (Nerf()*2);
				break;
			case "Freeze":
				Freeze();
				break;
			default:
				System.out.println("no ability was used");
		}
		Attack = RandomNumber.nextInt(131-100)+100;
		Energy = 50;
		int p = Power;
		return p;
	}


}