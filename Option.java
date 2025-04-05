
public class Option {

	// Option Class attributes
	String optName; // name of the option
	int optNum; // the number of the option within a given event
	int resultEventIndex; // event triggered as a result
	
	public Option() {
		this("Continue", 1, 1);
		
	}
	
	public Option(String n, int num) {
		 this(n, 1, num);
		
	}
	
	public Option(String n, int num, int result) {
		this.optName = n;
		this.optNum = num;
		this.resultEventIndex = result;
		
	}
	
	String optionString() {
		String str = "";
		str = "[" + optNum + "] " + optName;
		return str;
		
	}
	
}
