import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Player{
	Assault assault;
	Assassin assassin;
	Healer healer;
	Support support;
	Tank tank;
	Hero[] chosen = new Hero[3];
	int alive;
	int HP;


	public Player(){
		assassin = null;
		assault = null;
		healer = null;
		support = null;
		tank = null;
		alive = 3;
	}
	

	public void Display(){
		System.out.println();
		System.out.println("Team");
		for (int i = 0; i < chosen.length; i++){
			System.out.print("Slot " + (i+1)+ ": ");
			System.out.println(chosen[i].Class);
		}
	}

	public boolean FindSupport(){
		boolean ans = false;
		for (Hero x: chosen){
			if(x.Class.equals("support"))
				ans = true;
		}
		return ans;
	}
	public Support getSupport(){
		return support;
	}

	public boolean FindAssassin(){
			boolean ans = false;
		for (Hero x: chosen){
			if(x.Class.equals("assassin"))
				ans = true;
		}
		return ans;
	}
	public Assassin getAssassin(){
		return assassin;
	}

}