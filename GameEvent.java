
public class GameEvent {
	
	// Event Class attributes
	String eventName; // name of the event
	Option[] options; // array of player options for event
	
	public GameEvent() {
		this("Event", new Option[1]);
	}
	
	public GameEvent(String n) {
		this(n, new Option[1]);
		
	}
	
	public GameEvent(String n, Option[] opts) {
		this.eventName = n;
		this.options = opts;
		
	}
	
	String eventString() {
		String str = "\n";
		str = str + " ~ " + eventName + " ~ " + "\n";
		for (int i = 0; i < options.length; i++) {
			str = str + "\n" + options[i].optionString();
		}
		return str;
	}

}
