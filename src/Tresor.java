public class Tresor
{
	private int zu;
	private String pin;

	public Tresor()
	{
		zu = 0;
		pin = "710";
	}

	public int delta(char e){
		if(zu == -1) zu = pin.length();
		else if(zu == pin.length() && e == 'n') zu = -1;
		else if(zu >= pin.length() && e == 'c') zu = 0;
		else if(zu < pin.length()){
			if(e == pin.charAt(zu))zu++;
			else zu = (pin.length() + 1);
		}
		return zu;
	}

	public void setPin(String s){
		pin = s;
	}

	public int state(){
		if(zu == -1) return -1;
		if(zu == 0) return 0;
		else if(zu < pin.length()) return 1;
		else if(zu == pin.length())return 2;
		else return 3;
	}
}
