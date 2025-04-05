
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class TextGame {
	static int totalEvents = 201;
	static Random rand = new Random();
	static int randomizer = rand.nextInt(10);
	
	static String playerChoice;
	static Option[][] allOptions = new Option[totalEvents][1];
	static GameEvent[] allEvents = new GameEvent[totalEvents];
	 
	
	static boolean gameInProgress = false;
	
	static boolean endedABranch = false;
	static boolean contemplationComplete = false;
	static boolean foundCarPortal = false;
	static boolean foundYellowDoor = false;
	static boolean foundCavePortal = false;
	static boolean restUnlocked = false;
	static boolean malice = false;
	static boolean pride = false;
	static boolean woe = false;
	
	static int noIDontCounter = 0;
	static int triedToBeRockCounter = 0;
	static int isARockCounter = 0;
	static int caveDiverCounter = 0;
	static int restCounter = 0;
	static int swimToShoreCounter = 0;
	static int swimDownCounter = 0;

	public static void main(String[] args) {
		
		//System.out.println("randomizer = " + randomizer);
	
	
	int eventIndex = 0;
	//String playerChoice;
	//Option[][] allOptions = new Option[totalEvents][1];
	//GameEvent[] allEvents = new GameEvent[totalEvents];
	
	allEvents = defineEvents();
	allOptions = defineOptions();
	
	do {
		gameInProgress = true;
		//System.out.println(eventIndex);
		System.out.println(allEvents[eventIndex].eventString());
		Scanner scanner = new Scanner(System.in);
		playerChoice = scanner.nextLine();
		//gameInProgress = false;
		try {
		int choiceNum = Integer.parseInt(playerChoice) - 1;
		eventIndex = allEvents[eventIndex].options[choiceNum].resultEventIndex;
		
		eventIndex = checkReroutes(eventIndex);
		
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Entry not valid. ");
		}
		catch (NumberFormatException e) {
			System.out.println("Entry not valid.");
		}
		catch (NoSuchElementException e) {
			System.out.println("Entry not valid.");
		}
		//scanner.close();
	} 
	while (gameInProgress);
	
	}
	
	static public GameEvent[] defineEvents(){
		GameEvent[] e = new GameEvent[totalEvents];
		Option[][] allOpts = defineOptions();
		e[0] = new GameEvent("Instructions: Enter a number to choose an action.", allOpts[0]);
		
		e[1] = new GameEvent("Your car rolls to a stop outside of the Schilling School. "
				+ "\n As you step out, Dr. Schilling smiles and holds the door open.", allOpts[1]);
		
		if (randomizer < 5) {
		e[2] = new GameEvent("Your math class has already begun. \n The board displays a math problem: "
				+ "\n 20 - 6 + 4k = 2 - 2k "
				+ "\n What is the answer?", allOpts[2]);
		} else if (randomizer >= 5) {
		e[2] = new GameEvent("Your math class has already begun. \n The board displays a math problem: "
					+ "\n 4b + 5 = 1 + 5b "
					+ "\n What is the answer?", allOpts[2]);
		} 
		
		e[3] = new GameEvent("'We've got a live one' "
				+ "\n Dr. Schilling says to the voice in her earpiece. "
				+ "\n You run even faster.", allOpts[3]);
		
		if (randomizer < 5) {
		e[4] = new GameEvent("Wrong Answer, Try Again. "
				+ "\n 20 - 6 + 4k = 2 - 2k", allOpts[4]);
		} else {
		e[4] = new GameEvent("Wrong Answer, Try Again. "
					+ "\n 4b + 5 = 1 + 5b", allOpts[4]);
		}
		
		e[5] = new GameEvent("Confetti rains from the ceiling, "
				+ "\n 'WOW! We've never seen anyone solve a problem like that! "
				+ "\n The classroom cheers.", allOpts[5]);
		
		e[6] = new GameEvent("You've made it to the overpass, "
				+ "\n an ominous hum grows louder behind you.", allOpts[6]);
		
		e[7] = new GameEvent("You clumsily make your way through the trees;"
				+ "\n you can hear the violent uprooting of trees behind you.", allOpts[7]);
		
		e[8] = new GameEvent("You are eyed with great suspicion. "
				+ "\n 'Please come with me to the office'", allOpts[8]);
		
		e[9] = new GameEvent("How did Y0U know?", allOpts[9]);
		
		e[10] = new GameEvent("The Duel Begins", allOpts[10]);
		
		e[11] = new GameEvent("Your vision narrows to a point, "
				+ "\n you have succumb to the shadows.", allOpts[11]);
		
		e[12] = new GameEvent("You lunge forward and sink to the ground, "
				+ "\n crumbling under your own weight.", allOpts[12]);
		
		e[13] = new GameEvent("You glide across the crowd. "
				+ "\n the cheering roars through your skeleton.", allOpts[13]);
		
		e[14] = new GameEvent("Before you can turn around, "
				+ "\n you feel a tremendous weight throw you to the ground.", allOpts[14]);
		
		e[15] = new GameEvent("You come to an unfamiliar road. ", allOpts[15]);
		
		e[16] = new GameEvent("The entire interstate comes to a sudden stop, "
				+ "\n each car braking in perfect sync.", allOpts[16]);
		
		e[17] = new GameEvent("Dr. Main floats between you and the sun. "
				+ "\n Its rays burn into your eyes.", allOpts[17]);
		
		e[18] = new GameEvent("The entire school assembles in the social hall. "
				+ "\n With much fanfare, Dr. Schilling presents you with a gold medal: "
				+ "\n 'BEST AT MATH, MAYBE IN THE ENTIRE HISTORY OF MATH.'", allOpts[18]);
		
		e[19] = new GameEvent("The hallway seems to stretch before you. "
				+ "\n Time dilates. Seconds become minutes. Minutes feel like hours.", allOpts[19]);
		
		e[20] = new GameEvent("The office feels different than you remember. "
				+ "\n In fact, there's a bright yellow door that must be new.", allOpts[20]);
		
		e[21] = new GameEvent("Dr. Schilling waits behind her desk. "
				+ "\n 'Do you know why you're here?'", allOpts[21]);
		
		e[22] = new GameEvent("A nearby car door flings open and inside you see... "
				+ "\n ...your math class?", allOpts[22]);
		
		e[23] = new GameEvent("You hop as fast as you can. "
				+ "\n Dr. Main floats up beside you. "
				+ "\n 'Nice try.'", allOpts[23]);
		
		e[24] = new GameEvent("The festivities end abruptly, it's time for your science class.", allOpts[24]);
		
		e[25] = new GameEvent("'But you have to.'", allOpts[25]);
		
		e[26] = new GameEvent("'That's not how this works. It's time for science class.'", allOpts[26]);
		
		e[27] = new GameEvent("You pass by a house with a vibrant green door. It calls to you.", allOpts[27]);
		
		e[28] = new GameEvent("The green door swings open as you step on to the sidewalk. "
				+ "\n A dim yellow light spills out. As you approach you can see..."
				+ "\n ... the office?", allOpts[28]);
		
		e[29] = new GameEvent("The thundering sound behind you is growing closer.", allOpts[29]);
		
		e[30] = new GameEvent("The car beneath your feet begins to melt. "
				+ "\n It quickly spreads to the surrounding cars.", allOpts[30]);
		
		e[31] = new GameEvent("You hop to the next car and as you land,"
				+ "\n you begin to melt and become part of the puddle.", allOpts[31]);
		
		e[32] = new GameEvent("Gravity waves pulse through you. "
				+ "\n You withstand the force, but nearly topple.", allOpts[32]);
		
		e[33] = new GameEvent("The waves grow stronger."
				+ "\n 'How much more can you withstand?'", allOpts[33]);
		
		e[34] = new GameEvent("You fly into a rage."
				+ "\n Your feet fly out from under you as you are swept out the window. "
				+ "\n The force pulls your body ever quicker.", allOpts[34]);
		
		e[35] = new GameEvent("You crash into a plane."
				+ "\n You hear a loud crunching.", allOpts[35]);
		
		e[36] = new GameEvent("The force of gravity grows exponentially stronger. "
				+ "\n You buckle under the weight, snapping into a two dimensional form of your former self.", allOpts[36]);
		
		e[37] = new GameEvent("'Comfortable?'", allOpts[37]);
		
		e[38] = new GameEvent("'How amusing.'", allOpts[38]);
		
		e[39] = new GameEvent("You drop through the floor and sink to the bottom of a vast ocean.", allOpts[39]);
		
		e[40] = new GameEvent("You feel yourself regaining your old form. "
				+ "\n You see a cave in the waters beneath you.", allOpts[40]);
		
		e[50] = new GameEvent("Your mind rushes through every choice you have made in your life. "
				+ "\n You sense a vast matrix of branching decisions.", allOpts[50]);
		
		e[51] = new GameEvent("What will you do?", allOpts[51]);
		
		e[52] = new GameEvent("You will fix it. Have faith.", allOpts[52]);
		
		e[53] = new GameEvent("Just keep learning. You are on the right path.", allOpts[53]);
		
		e[54] = new GameEvent("Woe overtakes your world.", allOpts[54]);
		
		e[55] = new GameEvent("Malice devours all.", allOpts[55]);
		
		e[56] = new GameEvent("Pride subsumes your being.", allOpts[56]);
		
		e[57] = new GameEvent("You scream as loud as you can."
				+ "\n Your rage emanates through the air.", allOpts[57]);
		
		e[60] = new GameEvent("You rush to the door and with some effort, it swings open. "
				+ "\n Inside you see... "
				+ "\n ...your science class?", allOpts[60]);
		
		e[61] = new GameEvent("The Mitochondria...", allOpts[61]);
		
		e[62] = new GameEvent("Incorrect, please try again.", allOpts[62]);
		
		e[63] = new GameEvent("'Congratulations! You just earned a nobel prize in biology!' "
				+ "\n 'Please make your way to the 3rd floor for the award ceremony.'", allOpts[63]);
		
		e[64] = new GameEvent("'Good enough, I guess.'", allOpts[64]);
		
		e[70] = new GameEvent("What year did William the Conquerer invade England?", allOpts[70]);
		
		e[71] = new GameEvent("'I don't think that's right. Give it another try.'", allOpts[71]);
		
		e[72] = new GameEvent("You hear the call of a bugle, followed by a drum roll. "
				+ "\n 'Clear the way for his excellency, President of the Highschool, and teacher of history:"
				+ "\n Supreme Leader Heflin!", allOpts[72]);
		
		e[73] = new GameEvent("'So you think you know a lot about history, huh?'", allOpts[73]);
		
		e[80] = new GameEvent("'There isn't time for that, Dr. Schilling is waiting.'", allOpts[80]);
		
		e[81] = new GameEvent("'You can't wait this out.'", allOpts[81]);
		
		e[82] = new GameEvent("You are a rock.", allOpts[82]);
		
		e[83] = new GameEvent("You're alone in the office. It is eerily quiet.", allOpts[83]);
		
		e[90] = new GameEvent("You line yourself up and dive head first toward the next car. "
				+ "\n You open your eyes to find yourself in a deep ocean."
				+ "\n Above you are the cars, melting through the road like ice on a lake."
				+ "\n Ahead you see a distant shore.", allOpts[90]);
		
		e[91] = new GameEvent("You see an underwater cave. It emits a cool blue glow."
				+ "\n Occasionally, a cluster of bubbles fumbles out.", allOpts[91]);
		
		e[92] = new GameEvent("At the end of the cave, blue light spills through a small hole."
				+ "\n Through the hole you see..."
				+ "\n ... your history class?", allOpts[92]);
		
		e[93] = new GameEvent("You curl up on the floor of the cave. "
				+ "\n As you rub the smooth rock with your hands,"
				+ "\n you feel a small crevice.", allOpts[93]);
		
		e[94] = new GameEvent("You manage to snake your way through the narrow crevice."
				+ "\n As you squirm, you find yourself in pitch black darkness.", allOpts[94]);
		
		e[95] = new GameEvent("You are unable to turn around or move backward."
				+ "\n The crevice has gripped you firmly.", allOpts[95]);
		
		e[96] = new GameEvent("You swim and swim but the shore seems to eternally elude you.", allOpts[96]);
		
		e[97] = new GameEvent("You swim down, but the ocean floor grows further.", allOpts[97]);
		
		e[98] = new GameEvent("Finally, the water grows shallow. You can see a beach before you.", allOpts[98]);
		
		e[99] = new GameEvent("You emerge on the beach. "
				+ "\n As you walk inland, the sound of lapping waves seems to grow louder.", allOpts[99]);
		
		e[100] = new GameEvent("You aren't supposed to be here, "
				+ "\n this branch is unfinished.", allOpts[100]);
		
		e[101] = new GameEvent("You rest for a moment. Strange noises compel you to move.", allOpts[101]);
		
		e[102] = new GameEvent("", allOpts[102]);
		
		e[110] = new GameEvent("'You must've noticed, this world is falling apart.'"
				+ "\n 'We need your help.'", allOpts[110]);
		
		e[111] = new GameEvent("'Do you know Java?'", allOpts[111]);
		
		e[112] = new GameEvent("'The choice is yours."
				+ "\n But this is how you get answers.'", allOpts[112]);
		
		e[113] = new GameEvent("'There isn't time for me to explain any more."
				+ "\n You need to edit the source code and fix the broken timelines."
				+ "\n Can you do that?'", allOpts[113]);
		
		e[114] = new GameEvent("'I had hoped we could come to some arrangement, but alas...'", allOpts[114]);
		
		e[115] = new GameEvent("'Good luck.'", allOpts[115]);
		
		e[130] = new GameEvent("You sink deep below the school, to a dark maze."
				+ "\n A roaring sound echoes around the byzantine halls.", allOpts[130]);
		
		e[150] = new GameEvent("'Welcome to my domain.'", allOpts[150]);
		
		e[151] = new GameEvent("'You are here for something.'", allOpts[151]);
		
		e[152] = new GameEvent("Your fate has not yet been decided.", allOpts[152]);
		
		e[153] = new GameEvent("'I hope this fate will bring you peace.", allOpts[153]);
		
		e[154] = new GameEvent("'Allow me to return you, then.", allOpts[154]);
		
		return e;
	} 
	
	static public Option[][] defineOptions() {
		Option[][] allOpts = new Option[totalEvents][1];
		//System.out.println("randomizer = " + randomizer);
		allOpts[0] = new Option[1];
		allOpts[0][0] = new Option("Continue.", 1, 1);
		
		allOpts[1] = new Option[2];
		allOpts[1][0] = new Option("Head to your math class.", 1, 2);
		allOpts[1][1] = new Option("RUN.", 2, 3);
		
		if (randomizer < 5 && randomizer > 0) {
			allOpts[2] = new Option[4];
			allOpts[2][0] = new Option("6", 1, 4);
			allOpts[2][1] = new Option("-4", 2, 4);
			allOpts[2][2] = new Option("4", 3, 4);
			allOpts[2][3] = new Option("-2", 4, 5);
		} else if (randomizer == 0){
			allOpts[2] = new Option[4];
			allOpts[2][0] = new Option("-2", 1, 5);
			allOpts[2][1] = new Option("-2", 2, 5);
			allOpts[2][2] = new Option("-2", 3, 5);
			allOpts[2][3] = new Option("-22.2-2222..2", 4, 9);
		} else if (randomizer >= 5) {
			allOpts[2] = new Option[4];
			allOpts[2][0] = new Option("-3", 1, 4);
			allOpts[2][1] = new Option("-2", 2, 4);
			allOpts[2][2] = new Option("4", 3, 5);
			allOpts[2][3] = new Option("3", 4, 4);
		}
		
		allOpts[3] = new Option[2];
		allOpts[3][0] = new Option("Head for the Highway.", 1, 6);
		allOpts[3][1] = new Option("Lose them in the trees.", 2, 7);
		
		if (randomizer > 0 && randomizer < 5) {
			allOpts[4] = new Option[4];
			allOpts[4][0] = new Option("6", 1, 4);
			allOpts[4][1] = new Option("-4", 2, 4);
			allOpts[4][2] = new Option("4", 3, 4);
			allOpts[4][3] = new Option("-2", 4, 8);
		} else if (randomizer == 0){
			allOpts[4] = new Option[4];
			allOpts[4][0] = new Option("-2", 1, 5);
			allOpts[4][1] = new Option("-2", 2, 5);
			allOpts[4][2] = new Option("-2", 3, 5);
			allOpts[4][3] = new Option("-22.2-2222..2", 4, 9);
		} else if (randomizer >= 5) {
			allOpts[4] = new Option[4];
			allOpts[4][0] = new Option("-3", 1, 4);
			allOpts[4][1] = new Option("-2", 2, 4);
			allOpts[4][2] = new Option("4", 3, 8);
			allOpts[4][3] = new Option("3", 4, 4);
		}
		
		
		allOpts[5] = new Option[2];
		allOpts[5][0] = new Option("Crowd surf.", 1, 13);
		allOpts[5][1] = new Option("'Enough of this childish folly.'", 2, 24);
		
		allOpts[6] = new Option[2];
		allOpts[6][0] = new Option("Keep running.", 1, 16);
		allOpts[6][1] = new Option("Turn around.", 2, 17);
		
		allOpts[7] = new Option[2];
		allOpts[7][0] = new Option("Keep running.", 1, 15);
		allOpts[7][1] = new Option("Turn around.", 2, 14);
		
		allOpts[8] = new Option[2];
		allOpts[8][0] = new Option("Follow them to the office.", 1, 19);
		allOpts[8][1] = new Option("RUN", 2, 3);
		
		allOpts[9] = new Option[2];
		allOpts[9][0] = new Option("'I've been waiting for this day.'", 1, 10);
		allOpts[9][1] = new Option("Hide.", 2, 11);
		
		allOpts[10] = new Option[2];
		allOpts[10][0] = new Option("Take the initiative", 1, 12);
		allOpts[10][1] = new Option("Defensive stance", 2, 32);
		
		allOpts[11] = new Option[1];
		allOpts[11][0] = new Option("Open your eyes.", 1, 1);
		
		allOpts[12] = new Option[2];
		allOpts[12][0] = new Option("Try to get up.", 1, 100);
		allOpts[12][1] = new Option("Contemplate your choices.", 2, 50);
		
		allOpts[13] = new Option[2];
		allOpts[13][0] = new Option("Accept your medal.", 1, 18);
		allOpts[13][1] = new Option("Okay enough now.", 2, 24);
		
		allOpts[14] = new Option[1];
		allOpts[14][0] = new Option("Oh boy.", 1, 11);
		
		allOpts[15] = new Option[3];
		allOpts[15][0] = new Option("Turn right.", 1, 27);
		allOpts[15][1] = new Option("Turn left.", 2, 29);
		allOpts[15][2] = new Option("Turn around.", 3, 14);
		
		allOpts[16] = new Option[2];
		allOpts[16][0] = new Option("Try to hitch a ride.", 1, 22);
		allOpts[16][1] = new Option("Jump across the cars like frogger.", 2, 23);
		
		allOpts[17] = new Option[2];
		allOpts[17][0] = new Option("Keep running.", 1, 16);
		allOpts[17][1] = new Option("Taunt", 2, 100);
		
		allOpts[18] = new Option[2];
		allOpts[18][0] = new Option("Take a bow.", 1, 24);
		allOpts[18][1] = new Option("Contemplate your choices.", 2, 50);
		
		allOpts[19] = new Option[1];
		allOpts[19][0] = new Option("Keep walking.", 1, 20);
		
		allOpts[20] = new Option[3];
		allOpts[20][0] = new Option("Speak with Dr. Schilling.", 1, 21);
		allOpts[20][1] = new Option("Try the door.", 2, 60);
		allOpts[20][2] = new Option("Become a rock.", 3, 80);
		
		allOpts[21] = new Option[2];
		allOpts[21][0] = new Option("Shrug.", 1, 100);
		allOpts[21][1] = new Option("Contemplate your choices.", 2, 50);
		
		allOpts[22] = new Option[2];
		allOpts[22][0] = new Option("Head to math class.", 1, 2);
		allOpts[22][1] = new Option("'I guess it's time to try the frogger idea.'", 2, 23);
		
		allOpts[23] = new Option[2];
		allOpts[23][0] = new Option("Keep jumping; truly channel the frog within you.", 1, 30);
		allOpts[23][1] = new Option("Give up.", 2, 11);
		
		allOpts[24] = new Option[2];
		allOpts[24][0] = new Option("Head to science class.", 1, 61);
		allOpts[24][1] = new Option("'I don't think I want to.'", 2, 25);
		
		allOpts[25] = new Option[2];
		allOpts[25][0] = new Option("'Oh, okay.'", 1, 61);
		allOpts[25][1] = new Option("'No I don't.", 2, 26);
		
		allOpts[26] = new Option[2];
		allOpts[26][0] = new Option("'Maybe you're right.'", 1, 61);
		allOpts[26][1] = new Option("'You can't make me.'", 2, 26);
				
		allOpts[27] = new Option[2];
		allOpts[27][0] = new Option("Try the door.", 1, 28);
		allOpts[27][1] = new Option("Try the other direction.", 2, 100);
		
		allOpts[28] = new Option[2];
		allOpts[28][0] = new Option("Enter the office.", 1, 20);
		allOpts[28][1] = new Option("Try the other direction.", 2, 100);
		
		allOpts[29] = new Option[2];
		allOpts[29][0] = new Option("Keep running.", 1, 100);
		allOpts[29][1] = new Option("Find somewhere to hide.", 2, 100);
		
		allOpts[30] = new Option[1];
		allOpts[30][0] = new Option("Just keep frogging.", 1, 31);
		
		allOpts[31] = new Option[1];
		allOpts[31][0] = new Option("'This is my life now.'", 1, 11);
		
		allOpts[32] = new Option[2];
		allOpts[32][0] = new Option("Hold your stance.", 1, 33);
		allOpts[32][1] = new Option("RUN.", 2, 3);
		
		allOpts[33] = new Option[1];
		allOpts[33][0] = new Option("Fight gravity.", 1, 36);
		
		allOpts[34] = new Option[1];
		allOpts[34][0] = new Option("'Uh oh.'", 1, 35);
		
		allOpts[35] = new Option[1];
		allOpts[35][0] = new Option("Squish.", 1, 11);
		
		allOpts[36] = new Option[1];
		allOpts[36][0] = new Option("'..- ....  --- ....'", 1, 37);
		
		allOpts[37] = new Option[2];
		allOpts[37][0] = new Option("'... --- ...'", 1, 38);
		allOpts[37][1] = new Option("--. .. ...- . ..- .--.", 2, 11);
		
		allOpts[38] = new Option[1];
		allOpts[38][0] = new Option("-.-. .- .-.. .-.. - --- - .... . -.. . . .--. --- -. .", 1, 54);
		
		allOpts[39] = new Option[2];
		allOpts[39][0] = new Option("..-. .-.. --- .- -", 1, 39);
		allOpts[39][1] = new Option("... --- .- -.- ..- .--. - .... . .-- .- - . .-.", 2, 40);
		
		allOpts[40] = new Option[2];
		allOpts[40][0] = new Option("Swim up.", 1, 100);
		allOpts[40][1] = new Option("Swim down.", 2, 91);
		
		
		
		allOpts[50] = new Option[4];
		allOpts[50][0] = new Option("Woe and despair.", 1, 54);
		allOpts[50][1] = new Option("Malice and rage.", 2, 55);
		allOpts[50][2] = new Option("Pride and joy.", 3, 56);
		allOpts[50][3] = new Option("'I can change it.'", 4, 51);
		
		allOpts[51] = new Option[2];
		allOpts[51][0] = new Option("Shrug.", 1, 52);
		allOpts[51][1] = new Option("Try something new.", 2, 11);
		
		allOpts[52] = new Option[2];
		allOpts[52][0] = new Option("'I can't do it.'", 1, 11);
		allOpts[52][1] = new Option("'How do I fix it?'", 2, 53);
		
		allOpts[53] = new Option[1];
		allOpts[53][0] = new Option("'I'll try my best.'", 1, 11);
		
		allOpts[54] = new Option[1];
		allOpts[54][0] = new Option("'Nothing new...'", 1, 11);
		
		allOpts[55] = new Option[1];
		allOpts[55][0] = new Option("'They deserve it.'", 1, 11);
		
		allOpts[56] = new Option[1];
		allOpts[56][0] = new Option("'Good for me.'", 1, 11); 
		
		allOpts[57] = new Option[2];
		allOpts[57][0] = new Option("RUN.", 1, 3);
		allOpts[57][1] = new Option("Head inside.", 2, 2);
		
		allOpts[60] = new Option[2];
		allOpts[60][0] = new Option("Take your seat.", 1, 61);
		allOpts[60][1] = new Option("'This is too much.'", 2, 100);
		
		allOpts[61] = new Option[4];
		allOpts[61][0] = new Option("is a bacteria that eats plastic.", 1, 62);
		allOpts[61][1] = new Option("are the powerhouse of the cell.", 2, 63);
		allOpts[61][2] = new Option("are an alien race from Star Trek.", 3, 62);
		allOpts[61][3] = new Option("is a fantasy kingdom.", 4, 62);
		
		allOpts[62] = new Option[4];
		allOpts[62][0] = new Option("is a bacteria that eats plastic.", 1, 62);
		allOpts[62][1] = new Option("are the powerhouse of the cell.", 2, 64);
		allOpts[62][2] = new Option("are an alien race from Star Trek.", 3, 62);
		allOpts[62][3] = new Option("is a fantasy kingdom.", 4, 62);
		
		allOpts[63] = new Option[2];
		allOpts[63][0] = new Option("Look for the 3rd floor.", 1, 100);
		allOpts[63][1] = new Option("'There's a third floor?!'", 2, 100);
		
		allOpts[64] = new Option[2];
		allOpts[64][0] = new Option("Wait for your next class.", 1, 100);
		allOpts[64][1] = new Option("Time for a bathroom break.", 2, 100);
		
		allOpts[70] = new Option[4];
		allOpts[70][0] = new Option("1066 AD", 1, 72);
		allOpts[70][1] = new Option("1213 AD", 2, 71);
		allOpts[70][2] = new Option("1945 AD", 3, 71);
		allOpts[70][3] = new Option("1444 AD", 4, 71);
		
		allOpts[71] = new Option[4];
		allOpts[71][0] = new Option("1066 AD", 1, 73);
		allOpts[71][1] = new Option("1213 AD", 2, 71);
		allOpts[71][2] = new Option("1945 AD", 3, 71);
		allOpts[71][3] = new Option("1444 AD", 4, 71);
		
		allOpts[72] = new Option[2];
		allOpts[72][0] = new Option("Kowtow.", 1, 100);
		allOpts[72][1] = new Option("Make your escape.", 2, 100);
		
		allOpts[73] = new Option[2];
		allOpts[73][0] = new Option("'I would say so.'", 1, 100);
		allOpts[73][1] = new Option("'Nah, I just guessed.'", 2, 100);
		
		
		
		allOpts[80] = new Option[2];
		allOpts[80][0] = new Option("Speak with Dr. Schilling.", 1, 21);
		allOpts[80][1] = new Option("Try to become a rock.", 2, 81);
		
		allOpts[81] = new Option[2];
		allOpts[81][0] = new Option("Speak with Dr. Schilling.", 1, 21);
		allOpts[81][1] = new Option("Try really really hard to become a rock.", 2, 81);
		
		allOpts[82] = new Option[1];
		allOpts[82][0] = new Option("Wait it out.", 1, 82);
		
		allOpts[83] = new Option[2];
		allOpts[83][0] = new Option("See if Dr. Schilling is still in her office.", 1, 100);
		allOpts[83][1] = new Option("Head to science class.", 2, 61);
		
		allOpts[90] = new Option[2];
		allOpts[90][0] = new Option("Swim down.", 1, 91);
		allOpts[90][1] = new Option("Swim to the shallows.", 2, 96);
		
		allOpts[91] = new Option[2];
		allOpts[91][0] = new Option("Enter the cave.", 1, 92);
		allOpts[91][1] = new Option("Swim back up.", 2, 90);
		
		allOpts[92] = new Option[2];
		allOpts[92][0] = new Option("Take your seat.", 1, 70);
		allOpts[92][1] = new Option("Swim back up.", 2, 90);
		
		allOpts[93] = new Option[3];
		allOpts[93][0] = new Option("Climb into the crevice.", 1, 94);
		allOpts[93][1] = new Option("Rest.", 2, 93);
		allOpts[93][2] = new Option("'I'm bored.'", 3, 91);
		
		allOpts[94] = new Option[3];
		allOpts[94][0] = new Option("Keep going.", 1, 94);
		allOpts[94][1] = new Option("Rest.", 2, 101);
		allOpts[94][2] = new Option("Try to get out.", 3, 95);
		
		allOpts[95] = new Option[2];
		allOpts[95][0] = new Option("'What have I done.'", 1, 94);
		allOpts[95][1] = new Option("Rest.", 2, 101);
		
		allOpts[96] = new Option[2];
		allOpts[96][0] = new Option("Keep swimming.", 1, 96);
		allOpts[96][1] = new Option("Swim down.", 2, 97);
		
		allOpts[97] = new Option[2];
		allOpts[97][0] = new Option("Keep swimming down.", 1, 97);
		allOpts[97][1] = new Option("Swim to shore.", 2, 96);
		
		allOpts[98] = new Option[2];
		allOpts[98][0] = new Option("Walk ashore.", 1, 99);
		allOpts[98][1] = new Option("Swim back.", 2, 96);
		
		allOpts[99] = new Option[1];
		allOpts[99][0] = new Option("Keep walking.", 1, 15);
		
		allOpts[100] = new Option[1];
		allOpts[100][0] = new Option("Restart.", 1, 1);
		
		allOpts[101] = new Option[3];
		allOpts[101][0] = new Option("Start squirming again.", 1, 94);
		allOpts[101][1] = new Option("Keep resting.", 2, 101);
		allOpts[101][2] = new Option("Try to get out.", 3, 95);
		
		//allOpts[102]
		
		
		allOpts[110] = new Option[3];
		allOpts[110][0] = new Option("'What can I do?'", 1, 111);
		allOpts[110][1] = new Option("'Why would I help you?'", 2, 112);
		allOpts[110][2] = new Option("'Figure it out yourself.'", 3, 114);
		
		allOpts[111] = new Option[2];
		allOpts[111][0] = new Option("Yes.", 1, 113);
		allOpts[111][1] = new Option("No.", 2, 114);
		
		allOpts[112] = new Option[2];
		allOpts[112][0] = new Option("'Fine, what can I do?'", 1, 111);
		allOpts[112][1] = new Option("You're on your own.", 1, 114);
		
		allOpts[113] = new Option[1];
		allOpts[113][0] = new Option("Let me try.", 1, 115);
		
		allOpts[114] = new Option[1];
		allOpts[114][0] = new Option("Sink", 1, 130);
		
		allOpts[115] = new Option[0];
		//allOpts[115][0] = new Option("", 1, 100);
		
		allOpts[130] = new Option[2];
		allOpts[130][0] = new Option("Left.", 1, 100);
		allOpts[130][1] = new Option("Right.", 2, 100);
		
		allOpts[150] = new Option[2];
		allOpts[150][0] = new Option("'Where am I?'", 1, 100);
		allOpts[150][1] = new Option("'Good to see you.'", 2, 151);
		
		allOpts[151] = new Option[1];
		allOpts[151][0] = new Option("'What is my fate?'", 1, 152);
		
		allOpts[152] = new Option[2];
		allOpts[152][0] = new Option("'Reroll my fate.'", 1, 153);
		allOpts[152][1] = new Option("'I am happy with this fate.", 2, 154);
		
		allOpts[153] = new Option[1];
		allOpts[153][0] = new Option("'Me too.'", 1, 11);
		
		allOpts[154] = new Option[1];
		allOpts[154][0] = new Option("'Thanks.'", 1, 11);
		
		
		return allOpts;
	}
	
	public static int checkReroutes(int i) {
		
		if (i == 154) {
			contemplationComplete = false;
			woe = false;
			malice = false;
			pride = false;
			foundCarPortal = false;
			foundYellowDoor = false;
			foundCavePortal = false;
			
			noIDontCounter = 0;
			triedToBeRockCounter = 0;
			isARockCounter = 0;
			caveDiverCounter = 0;
			restCounter = 0;
			swimToShoreCounter = 0;
			swimDownCounter = 0;
		}
		
		if (i == 153) {
			randomizer = rand.nextInt(10);
			
			contemplationComplete = false;
			woe = false;
			malice = false;
			pride = false;
			foundCarPortal = false;
			foundYellowDoor = false;
			foundCavePortal = false;
			
			noIDontCounter = 0;
			triedToBeRockCounter = 0;
			isARockCounter = 0;
			caveDiverCounter = 0;
			restCounter = 0;
			swimToShoreCounter = 0;
			swimDownCounter = 0;
			
			allEvents[11].options = new Option[1];
			allEvents[11].options[0] = new Option("Open your eyes.", 1, 1);
		}
		
		if (i == 151) {
			if (woe) allEvents[152] = new GameEvent("You are in timeline " + randomizer + ", woe variant.", allEvents[152].options);
			else if (malice) allEvents[152] = new GameEvent("You are in timeline " + randomizer + ", malice variant.", allEvents[152].options);
			else if (woe) allEvents[152] = new GameEvent("You are in timeline " + randomizer + ", pride variant.", allEvents[152].options);
			else allEvents[152] = new GameEvent("You are in timeline " + randomizer + ".", allEvents[152].options);

		}
		
		if (i == 115) {
			gameInProgress = false;
			
		}
		
		if (i == 101) {
		caveDiverCounter++;
		if (caveDiverCounter > 25) {
			allEvents[11].options = new Option[2];
			allEvents[11].options[0] = new Option("Open your eyes.", 1, 1);
			allEvents[11].options[1] = new Option("Rest.", 2, 11);
			
			allEvents[101].options = new Option[1];
			allEvents[101].options[0] = new Option("Close your eyes.", 1, 11);
			
			restUnlocked = true;
		}
			
		}
		
		if (i == 100) { // If player reaches the end of a branch
			//System.out.println("Ended a branch");
			endedABranch = true;
			
			allEvents[21].options = new Option[3];
			allEvents[21].options[0] = new Option("Shrug.", 1, 100);
			allEvents[21].options[1] = new Option("Contemplate your choices.", 2, 50);
			allEvents[21].options[2] = new Option("'I must be the chosen one.'", 3, 110);
		}
		
		if (i == 96) {
			if (swimDownCounter > 0) {
				swimDownCounter--;
			} else {
				swimToShoreCounter++;
			}
			if (swimToShoreCounter > 12) {
				allEvents[96].options = new Option[2];
				allEvents[96].options[0] = new Option("Keep swimming.", 1, 98);
				allEvents[96].options[1] = new Option("Swim down.", 2, 97);
				
			}
		}
		
		if (i == 97) {
			if (swimToShoreCounter > 0) {
				swimToShoreCounter--;
			} else {
				swimDownCounter++;
			}
			if (swimDownCounter > 20) {
				allEvents[97].options = new Option[2];
				allEvents[97].options[0] = new Option("Swim to the bottom. ", 1, 91);
				allEvents[97].options[1] = new Option("Swim back up", 2, 96);
				
			}
		}
		
		if (i == 94) {
			caveDiverCounter++;
			
			if (caveDiverCounter > 25) {
				
				allEvents[11].options = new Option[2];
				allEvents[11].options[0] = new Option("Open your eyes.", 1, 1);
				allEvents[11].options[1] = new Option("Rest.", 2, 11);
				
				restUnlocked = true;
				
				allEvents[94].options = new Option[3];
				allEvents[94].options[0] = new Option("Keep going.", 1, 94);
				allEvents[94].options[1] = new Option("Close your eyes.", 2, 11);
				allEvents[94].options[2] = new Option("Try to get out.", 3, 95);
			}
			
		}
		
		if (i == 82) {
			isARockCounter++;
			
			if (isARockCounter > 50) {
				allEvents[82].options = new Option[2];
				allEvents[82].options[0] = new Option("'Keep being a rock.'", 1, 82);
				allEvents[82].options[1] = new Option("'Okay I'm ready.'", 2, 83);
				
			}
			
		}
		
		if (i == 81 ) { // If player has tried to be a rock
			//System.out.println("tried to be a rock");
			triedToBeRockCounter++;
			if (triedToBeRockCounter > 14) {
				
				allEvents[81].options = new Option[1];
				allEvents[81].options[0] = new Option("Be the rock.", 1, 82);
				
				allEvents[81] = new GameEvent("You can feel it, something is happening.", allEvents[81].options);
			}
		}
		
		if (i == 56) {
			
			pride = true;
			woe = false;
			malice = false;
			
		}
		
		if (i == 55) {
			
			malice = true;
			pride = false;
			woe = false;
			
			allEvents[1].options = new Option[2];
			allEvents[1].options[0] = new Option("Head to your math class.", 1, 2);
			allEvents[1].options[1] = new Option("RAGE.", 2, 100);
			
			allEvents[32].options = new Option[2];
			allEvents[32].options[0] = new Option("Hold your stance.", 1, 33);
			allEvents[32].options[1] = new Option("RAGE", 2, 34);
			
		}
		
		if (i == 54) {
			
			woe = true;
			pride = false;
			malice = false;
			allEvents[1].options = new Option[2];
			allEvents[1].options[0] = new Option("Head to your math class.", 1, 2);
			allEvents[1].options[1] = new Option("Give up.", 2, 11);
			
			allEvents[11] = new GameEvent("Your vision narrows to a point,"
					+ "\n You have become the shadows.", allEvents[11].options);
			
			allEvents[92].options = new Option[3];
			allEvents[92].options[0] = new Option("Take your seat.", 1, 70);
			allEvents[92].options[1] = new Option("Swim back up.", 2, 100);
			allEvents[92].options[2] = new Option("'I wish I could just stay here.'", 3, 93);
			
		}
		
		if (i == 51) { // If player has contemplated
			//System.out.println("Contemplated");
			contemplationComplete = true;
			//woe = false;
			//pride = false;
			//malice = false;
			
					
			allEvents[1].options = new Option[3];
			allEvents[1].options[0] = new Option("Head to your math class.", 1, 2);
			allEvents[1].options[1] = new Option("RUN", 2, 3);
			allEvents[1].options[2] = new Option("'Deja Vu'", 3, 100);
			
			allEvents[1] = new GameEvent("Your car rolls to a stop outside of the Schilling School. "
					+ "\n Dr. Schilling is waiting.", allOptions[1]);
			
			allEvents[11] = new GameEvent("Your vision narrows to a point.", allEvents[11].options);
			
			allEvents[30].options = new Option[2];
			allEvents[30].options[0] = new Option("Just keep frogging.", 1, 31);
			allEvents[30].options[1] = new Option("Try swimming?", 2, 90);
			
			allEvents[33].options = new Option[2];
			allEvents[33].options[0] = new Option("Fight gravity.", 1, 36);
			allEvents[33].options[1] = new Option("Embrace gravity.", 2, 39);
			
			allEvents[50].options = new Option[4];
			allEvents[50].options[0] = new Option("Woe and despair.", 1, 54);
			allEvents[50].options[1] = new Option("Malice and rage.", 2, 55);
			allEvents[50].options[2] = new Option("Pride and joy.", 3, 56);
			allEvents[50].options[3] = new Option("'I'm back.'", 4, 51);
			
			allEvents[51].options = new Option[2];
			allEvents[51].options[0] = new Option("Shrug.", 1, 52);
			allEvents[51].options[1] = new Option("Keep trying.", 2, 11);
		}
		
		if (i == 26) {
			noIDontCounter++;
			if(noIDontCounter > 4) {
				
				allEvents[26] = new GameEvent("'Fine, you win!'", allEvents[26].options);
				
				allEvents[26].options = new Option[2];
				allEvents[26].options[0] = new Option("'I was just messing with you, jeez.'", 1, 61);
				allEvents[26].options[1] = new Option("'Told you so.'", 2, 100);
				
				
			}
			
		}
		
		if (i == 22) {
			foundCarPortal = true;
			
			if (randomizer == 1 || randomizer == 2) {
				allEvents[2].options = new Option[5];
				allEvents[2].options[0] = new Option("6", 1, 4);
				allEvents[2].options[1] = new Option("-4", 2, 4);
				allEvents[2].options[2] = new Option("4", 3, 4);
				allEvents[2].options[3] = new Option("-2", 4, 5);
				allEvents[2].options[4] = new Option("'How did I get here?'", 5, 100);
			} else if (randomizer == 0){
				allEvents[2].options = new Option[5];
				allEvents[2].options[0] = new Option("-2", 1, 5);
				allEvents[2].options[1] = new Option("-2", 2, 5);
				allEvents[2].options[2] = new Option("-2", 3, 5);
				allEvents[2].options[3] = new Option("-22.2-2222..2", 4, 9);
				allEvents[2].options[4] = new Option("'I'm here.'", 5, 10);
			} else if (randomizer == 3 || randomizer == 4) {
				allEvents[2].options = new Option[5];
				allEvents[2].options[0] = new Option("-3", 1, 4);
				allEvents[2].options[1] = new Option("-2", 2, 4);
				allEvents[2].options[2] = new Option("4", 3, 5);
				allEvents[2].options[3] = new Option("3", 4, 4);
				allEvents[2].options[4] = new Option("'How did I get here?'", 5, 100);
			}
			
		}
		
		if (i == 11) {
			
			noIDontCounter = 0;
			triedToBeRockCounter = 0;
			isARockCounter = 0;
			caveDiverCounter = 0;
			//restCounter = 0;
			swimToShoreCounter = 0;
			swimDownCounter = 0;
			
			if (restUnlocked)restCounter++;
			
			if (restCounter > 5) {
				
				allEvents[94].options = new Option[1];
				allEvents[94].options[0] = new Option("Close your eyes", 1, 11);
				
				allEvents[95].options = new Option[1];
				allEvents[95].options[0] = new Option("Close your eyes.", 1, 11);
				
				allEvents[11].options = new Option[3];
				allEvents[11].options[0] = new Option("Open your eyes.", 1, 1);
				allEvents[11].options[1] = new Option("Rest.", 2, 11);
				allEvents[11].options[2] = new Option("Open your third eye.", 3, 150);
				//restCounter = 0;
			}
			
		}
		
		if (i == 1) {
			
			foundCarPortal = false;
			foundYellowDoor = false;
			foundCavePortal = false;
			
			noIDontCounter = 0;
			triedToBeRockCounter = 0;
			isARockCounter = 0;
			caveDiverCounter = 0;
			restCounter = 0;
			swimToShoreCounter = 0;
			swimDownCounter = 0;
			
		}
		
		
		
		return i;
		
	}

}
