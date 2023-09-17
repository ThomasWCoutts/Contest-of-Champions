import java.util.*;

public class Computer {
	Assault assault;
	Assassin assassin;
	Healer healer;
	Support support;
	Tank tank;
	Hero[] chosen = new Hero[3];
	int alive;
	int HP;
	
	public Computer(){
        Random random = new Random();
		HP = 0;
		int i = 0;
		int x = 0;
		String[] types = {"assault","assassin","healer","support","tank"};
        int range = 5;
		while(chosen[2]== null && i <3){
            int index = random.nextInt(range);
			String type = types[index];
            String sub = type;
            for (int j = index+1; j < types.length; j ++){
                types[j-1] = types[j];
            }
            types[4] = sub;
            range--;				
			switch (type){
				case "assault":
					assault = new Assault();
					switch(x){
						case 0:
							this.chosen[0] = assault;
							break;
						case 1:
							this.chosen[1] = assault;
							break;
						case 2:
							this.chosen[2] = assault;
						default:
					}
					break;
				case "assassin":
					assassin = new Assassin();
					switch(x){
						case 0:
							this.chosen[0] = assassin;
							break;
						case 1:
							this.chosen[1] = assassin;
							break;
						case 2:
							this.chosen[2] = assassin;
						default:
					}
					break;
				case "healer":
					healer = new Healer();
					switch(x){
						case 0:
							this.chosen[0] = healer;
							break;
						case 1:
							this.chosen[1] = healer;
							break;
						case 2:
							this.chosen[2]= healer;
						default:
					}
					break;
				case "support":
					support = new Support();
						switch(x){
						case 0:
							this.chosen[0] = support;
							break;
						case 1:
							this.chosen[1] = support;
							break;
						case 2:
							this.chosen[2] = support;
						default:
					}

					
					break;
				case "tank":
					tank = new Tank();
						switch(x){
						case 0:
							this.chosen[0] = tank;
							break;
						case 1:
							this.chosen[1] = tank;
							break;
						case 2:
							this.chosen[2] = tank;
						default:
					}
					break;
				default:
					System.out.println("Hameno");				
			}
			x++;
			i++;
		}
		this.alive = 3;
		for (Hero o: chosen){
			HP += o.HP;
		}
		
	}
	

	public void Display(){
		System.out.println();
		System.out.println("Enemy team");
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

	public Healer getHealer(){
		return healer;
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

    public boolean FindHealer(){
       boolean ans = false;
		for (Hero x: chosen){
			if(x.Class.equals("healer"))
				ans = true;
		}
		return ans; 
    }

    public Hero getDef(){
        for (int i = 0; i < chosen.length; i++){
			for (int j = 1; j< chosen.length-1;j++) {
				if (chosen[i].cHP < chosen[j].cHP) {
					Hero temp = chosen[i];
					chosen[i] = chosen[j];
					chosen[j] = temp;
				}
			}
        }
		if(chosen[0].HP==0){
			if (chosen[1].HP==0){
				return chosen[2];
			}
			else{
				return chosen[1];
			}
		}
		else{
			return chosen[0];
		}
    }

    public Hero getAt(){
        int at = 0;
        for (int i =0; i < 2; i++){
            if(chosen[i].Attack>chosen[i+1].Attack && chosen[i].HP>0){
                at = i;
            }
            else{
                at = (i+1);
            }
        }
        return chosen[at];
    }
}

