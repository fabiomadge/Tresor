import java.io.Console;

public class UI
{
	private Tresor t;
	private Console c;
	
	public UI()
	{
		c = System.console();
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		t = new Tresor();
		greet();
	}

	public void interact(){
		char [] cs;
		if(t.state() < 0) cs = toCAr("null");
		else if(t.state() < 2) cs = c.readPassword();
		else cs = toCAr(c.readLine());
		char ch;
		if(cs.length == 0)ch = 'x';
		else ch = cs[0];
		t.delta(ch);
		if(t.state() == -1){
			System.out.print("\nPlease enter the new PIN and hit enter: ");
			t.setPin(c.readLine());
			interact();
		}
		else if(t.state() == 0){
			System.out.print("\nPlease start by entering your PIN digit by digit: ");
			interact();
		}
		else if(t.state() == 1){
			System.out.print("Please enter the next digit: ");
			interact();
		}   
		else if(t.state() == 2){
			System.out.print("\nCongratulations the safe is now open.\nClose it by pressing >c<: ");
			interact();
		}
		else if(t.state() == 3){
			System.out.print("\nYour input wasn't correct.\nStart over by pressing >c<: ");
			interact();
		}
	}
	
	public void greet(){
		System.out.println("\nHello, welcome the the digital safe.\n");
		System.out.print("Please start by entering your PIN digit by digit: ");
		interact();
	}

	public char[] toCAr(String s){
		char [] cse = new char [s.length()];
		for(int i = 0; i < s.length(); i++){
			cse[i] = s.charAt(i);
		}
		return cse;
	}
}
