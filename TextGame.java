
import java.util.NoSuchElementException; // import necessary packages
import java.util.Random;
import java.util.Scanner;

public class TextGame {
	
	// declare variables
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
	static boolean thirdEyeOpen = false;
	static boolean metAnthony = false;
	
	static boolean hasPick = false;
	
	static boolean malice = false;
	static boolean pride = false;
	static boolean woe = false;
	static boolean peace = false;
	
	static int noIDontCounter = 0;
	static int triedToBeRockCounter = 0;
	static int isARockCounter = 0;
	static int caveDiverCounter = 0;
	static int restCounter = 0;
	static int swimToShoreCounter = 0;
	static int swimDownCounter = 0;
	static int callForHelpCounter = 0;
	static int mineTreeCounter = 0;
	static int mineGroundCounter = 0;
	static int chainedCounter = 0;
	static int spaceDistance = 0;

	static int spaceSpeed = 100;
	

	public static void main(String[] args) { // this method runs when the program starts
	
	int eventIndex = 0; // Create event index variable -> game starts at event index 0 (event 0)
	
	//System.out.println(randomizer);
	
	allEvents = defineEvents(); // Generate all of the events
	
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
		GameEvent[] e = new GameEvent[totalEvents]; // create array for all game events, will be returned at the end of this method
		Option[][] allOpts = new Option[totalEvents][1]; // create an array of option arrays, to be used in creating the game event array
		
		allOpts[0] = new Option[1]; // Create event 0 option array
		allOpts[0][0] = new Option("Continue.", 1, 1); // Create event 0 first option
		
		e[0] = new GameEvent("Instructions: Enter a number to choose an action.", allOpts[0]); // Create game event 0
		
		allOpts[1] = new Option[2]; // Create event 1 option array
		allOpts[1][0] = new Option("Head to your math class.", 1, 2); // Create event 1 first option
		allOpts[1][1] = new Option("RUN.", 2, 3); // Create event 1 second option
		
		e[1] = new GameEvent("Your car rolls to a stop outside of the Schilling School. "
				+ "\n As you step out, Dr. Schilling smiles and holds the door open.", allOpts[1]); // Create game event 1
		
		
		
		if (randomizer < 5 && randomizer > 0) {
			
			allOpts[2] = new Option[4];
			allOpts[2][0] = new Option("6", 1, 4);
			allOpts[2][1] = new Option("-4", 2, 4);
			allOpts[2][2] = new Option("4", 3, 4);
			allOpts[2][3] = new Option("-2", 4, 5);
			
			e[2] = new GameEvent("Your math class has already begun. \n The board displays a math problem: "
					+ "\n 20 - 6 + 4k = 2 - 2k "
					+ "\n What is the answer?", allOpts[2]);
			
			
			
		} else if (randomizer >= 5) {
			
			allOpts[2] = new Option[4];
			allOpts[2][0] = new Option("-3", 1, 4);
			allOpts[2][1] = new Option("-2", 2, 4);
			allOpts[2][2] = new Option("4", 3, 5);
			allOpts[2][3] = new Option("3", 4, 4);
			
			e[2] = new GameEvent("Your math class has already begun. \n The board displays a math problem: "
						+ "\n 4b + 5 = 1 + 5b "
						+ "\n What is the answer?", allOpts[2]);
			
			
			
		} else if (randomizer == 0 ) {
			
			allOpts[2] = new Option[4];
			allOpts[2][0] = new Option("-2", 1, 5);
			allOpts[2][1] = new Option("-2", 2, 5);
			allOpts[2][2] = new Option("-2", 3, 5);
			allOpts[2][3] = new Option("-22.2-2222..2", 4, 9);
			
			e[2] = new GameEvent("Your math class has already begun. \n The board displays a math problem: "
					+ "\n 20 - 6 + 4k = 2 - 2k "
					+ "\n What is the answer?", allOpts[2]);
			
			
			
		}
		
		allOpts[3] = new Option[2];
		allOpts[3][0] = new Option("Head for the Highway.", 1, 6);
		allOpts[3][1] = new Option("Lose them in the trees.", 2, 7);
		
		e[3] = new GameEvent("'We've got a live one' "
				+ "\n Dr. Schilling says to the voice in her earpiece. "
				+ "\n You run even faster.", allOpts[3]);
		
		
		
		if (randomizer < 5 && randomizer > 0) {
			
			allOpts[4] = new Option[4];
			allOpts[4][0] = new Option("6", 1, 4);
			allOpts[4][1] = new Option("-4", 2, 4);
			allOpts[4][2] = new Option("4", 3, 4);
			allOpts[4][3] = new Option("-2", 4, 8);
			
			e[4] = new GameEvent("Wrong Answer, Try Again. "
					+ "\n 20 - 6 + 4k = 2 - 2k", allOpts[4]);
			
			
		
		} else if (randomizer >= 5) {
			
			allOpts[4] = new Option[4];
			allOpts[4][0] = new Option("-3", 1, 4);
			allOpts[4][1] = new Option("-2", 2, 4);
			allOpts[4][2] = new Option("4", 3, 8);
			allOpts[4][3] = new Option("3", 4, 4);
			
			e[4] = new GameEvent("Wrong Answer, Try Again. "
					+ "\n 4b + 5 = 1 + 5b", allOpts[4]);
			
			
		
		} else if (randomizer == 0) {
			
			allOpts[4] = new Option[4];
			allOpts[4][0] = new Option("-2", 1, 5);
			allOpts[4][1] = new Option("-2", 2, 5);
			allOpts[4][2] = new Option("-2", 3, 5);
			allOpts[4][3] = new Option("-22.2-2222..2", 4, 9);
			
			e[4] = new GameEvent("'How did you get here? I didn't think it was possible.'", allOpts[4]);
			
			
		}
		
		allOpts[5] = new Option[2];
		allOpts[5][0] = new Option("Crowd surf.", 1, 13);
		allOpts[5][1] = new Option("'Enough of this childish folly.'", 2, 24);
		
		e[5] = new GameEvent("Confetti rains from the ceiling, "
				+ "\n 'WOW! We've never seen anyone solve a problem like that! "
				+ "\n The classroom cheers.", allOpts[5]);
		
		allOpts[6] = new Option[2];
		allOpts[6][0] = new Option("Keep running.", 1, 16);
		allOpts[6][1] = new Option("Turn around.", 2, 17);
		
		e[6] = new GameEvent("You've made it to the overpass, "
				+ "\n an ominous hum grows louder behind you.", allOpts[6]);
		
		allOpts[7] = new Option[2];
		allOpts[7][0] = new Option("Keep running.", 1, 15);
		allOpts[7][1] = new Option("Turn around.", 2, 14);
		
		e[7] = new GameEvent("You clumsily make your way through the trees;"
				+ "\n you can hear the violent uprooting of trees behind you.", allOpts[7]);
		
		allOpts[8] = new Option[2];
		allOpts[8][0] = new Option("Follow them to the office.", 1, 19);
		allOpts[8][1] = new Option("RUN", 2, 3);
		
		e[8] = new GameEvent("You are eyed with great suspicion. "
				+ "\n 'Please come with me to the office'", allOpts[8]);
		
		allOpts[9] = new Option[2];
		allOpts[9][0] = new Option("'I've been waiting for this day.'", 1, 10);
		allOpts[9][1] = new Option("Hide.", 2, 11);
		
		e[9] = new GameEvent("How did Y0U know?", allOpts[9]);
		
		allOpts[10] = new Option[2];
		allOpts[10][0] = new Option("Take the initiative", 1, 12);
		allOpts[10][1] = new Option("Defensive stance", 2, 32);
		
		e[10] = new GameEvent("The Duel Begins", allOpts[10]);
		
		allOpts[11] = new Option[1];
		allOpts[11][0] = new Option("Open your eyes.", 1, 1);
		
		e[11] = new GameEvent("Your vision narrows to a point, "
				+ "\n you have succumb to the shadows.", allOpts[11]);
		
		allOpts[12] = new Option[2];
		allOpts[12][0] = new Option("Try to get up.", 1, 11);
		allOpts[12][1] = new Option("Contemplate your choices.", 2, 50);
		
		e[12] = new GameEvent("You lunge forward and sink to the ground, "
				+ "\n crumbling under your own weight.", allOpts[12]);
		
		allOpts[13] = new Option[2];
		allOpts[13][0] = new Option("Accept your medal.", 1, 18);
		allOpts[13][1] = new Option("Okay enough now.", 2, 24);
		
		e[13] = new GameEvent("You glide across the crowd. "
				+ "\n the cheering roars through your skeleton.", allOpts[13]);
		
		allOpts[14] = new Option[1];
		allOpts[14][0] = new Option("Oh boy.", 1, 11);
		
		e[14] = new GameEvent("Before you can turn around, "
				+ "\n you feel a tremendous weight throw you to the ground.", allOpts[14]);
		
		allOpts[15] = new Option[3];
		allOpts[15][0] = new Option("Turn right.", 1, 27);
		allOpts[15][1] = new Option("Turn left.", 2, 29);
		allOpts[15][2] = new Option("Turn around.", 3, 14);
		
		e[15] = new GameEvent("You come to an unfamiliar road. ", allOpts[15]);
		
		allOpts[16] = new Option[2];
		allOpts[16][0] = new Option("Try to hitch a ride.", 1, 22);
		allOpts[16][1] = new Option("Jump across the cars like frogger.", 2, 23);
		
		e[16] = new GameEvent("The entire interstate comes to a sudden stop, "
				+ "\n each car braking in perfect sync.", allOpts[16]);
		
		allOpts[17] = new Option[2];
		allOpts[17][0] = new Option("Keep running.", 1, 16);
		allOpts[17][1] = new Option("Taunt", 2, 46);
		
		e[17] = new GameEvent("Dr. Main floats between you and the sun. "
				+ "\n Its rays burn into your eyes.", allOpts[17]);
		
		allOpts[18] = new Option[2];
		allOpts[18][0] = new Option("Take a bow.", 1, 24);
		allOpts[18][1] = new Option("Contemplate your choices.", 2, 50);
		
		e[18] = new GameEvent("The entire school assembles in the social hall. "
				+ "\n With much fanfare, Dr. Schilling presents you with a gold medal: "
				+ "\n 'BEST AT MATH, MAYBE IN THE ENTIRE HISTORY OF MATH.'", allOpts[18]);
		
		allOpts[19] = new Option[1];
		allOpts[19][0] = new Option("Keep walking.", 1, 20);
		
		e[19] = new GameEvent("The hallway seems to stretch before you. "
				+ "\n Time dilates. Seconds become minutes. Minutes feel like hours.", allOpts[19]);
		
		allOpts[20] = new Option[3];
		allOpts[20][0] = new Option("Speak with Dr. Schilling.", 1, 21);
		allOpts[20][1] = new Option("Try the door.", 2, 60);
		allOpts[20][2] = new Option("Become a rock.", 3, 80);
		
		e[20] = new GameEvent("The office feels different than you remember. "
				+ "\n In fact, there's a bright yellow door that must be new.", allOpts[20]);
		
		allOpts[21] = new Option[2];
		allOpts[21][0] = new Option("Shrug.", 1, 100);
		allOpts[21][1] = new Option("Contemplate your choices.", 2, 50);
		
		e[21] = new GameEvent("Dr. Schilling waits behind her desk. "
				+ "\n 'Do you know why you're here?'", allOpts[21]);
		
		allOpts[22] = new Option[2];
		allOpts[22][0] = new Option("Head to math class.", 1, 2);
		allOpts[22][1] = new Option("'I guess it's time to try the frogger idea.'", 2, 23);
		
		e[22] = new GameEvent("A nearby car door flings open and inside you see... "
				+ "\n ...your math class?", allOpts[22]);
		
		allOpts[23] = new Option[2];
		allOpts[23][0] = new Option("Keep jumping; truly channel the frog within you.", 1, 30);
		allOpts[23][1] = new Option("Give up.", 2, 11);
		
		e[23] = new GameEvent("You hop as fast as you can. "
				+ "\n Dr. Main floats up beside you. "
				+ "\n 'Nice try.'", allOpts[23]);
		
		allOpts[24] = new Option[2];
		allOpts[24][0] = new Option("Head to science class.", 1, 61);
		allOpts[24][1] = new Option("'I don't think I want to.'", 2, 25);
		
		e[24] = new GameEvent("The festivities end abruptly, it's time for your science class.", allOpts[24]);

		allOpts[25] = new Option[2];
		allOpts[25][0] = new Option("'Oh, okay.'", 1, 61);
		allOpts[25][1] = new Option("'No I don't.", 2, 26);
		
		e[25] = new GameEvent("'But you have to.'", allOpts[25]);

		allOpts[26] = new Option[2];
		allOpts[26][0] = new Option("'Maybe you're right.'", 1, 61);
		allOpts[26][1] = new Option("'You can't make me.'", 2, 26);
		
		e[26] = new GameEvent("'That's not how this works. It's time for science class.'", allOpts[26]);
		
		allOpts[27] = new Option[2];
		allOpts[27][0] = new Option("Try the door.", 1, 28);
		allOpts[27][1] = new Option("Try the other direction.", 2, 29);
		
		e[27] = new GameEvent("You pass by a house with a vibrant green door. It calls to you.", allOpts[27]);
		
		allOpts[28] = new Option[2];
		allOpts[28][0] = new Option("Enter the office.", 1, 20);
		allOpts[28][1] = new Option("Try the other direction.", 2, 29);
		
		e[28] = new GameEvent("The green door swings open as you step on to the sidewalk. "
				+ "\n A dim yellow light spills out. As you approach you can see..."
				+ "\n ... the office?", allOpts[28]);

		allOpts[29] = new Option[2];
		allOpts[29][0] = new Option("Keep running.", 1, 44);
		allOpts[29][1] = new Option("Find somewhere to hide.", 2, 42);
		
		e[29] = new GameEvent("The thundering sound behind you is growing closer.", allOpts[29]);

		allOpts[30] = new Option[1];
		allOpts[30][0] = new Option("Just keep frogging.", 1, 31);
		
		e[30] = new GameEvent("The car beneath your feet begins to melt. "
				+ "\n It quickly spreads to the surrounding cars.", allOpts[30]);

		allOpts[31] = new Option[1];
		allOpts[31][0] = new Option("'This is my life now.'", 1, 11);
		
		e[31] = new GameEvent("You hop to the next car and as you land,"
				+ "\n you begin to melt and become part of the puddle.", allOpts[31]);

		allOpts[32] = new Option[2];
		allOpts[32][0] = new Option("Hold your stance.", 1, 33);
		allOpts[32][1] = new Option("RUN.", 2, 3);
		
		e[32] = new GameEvent("Gravity waves pulse through you. "
				+ "\n You withstand the force, but nearly topple.", allOpts[32]);

		allOpts[33] = new Option[1];
		allOpts[33][0] = new Option("Fight gravity.", 1, 36);
		
		e[33] = new GameEvent("The waves grow stronger."
				+ "\n 'How much more can you withstand?'", allOpts[33]);

		allOpts[34] = new Option[1];
		allOpts[34][0] = new Option("'Uh oh.'", 1, 35);
		
		e[34] = new GameEvent("You fly into a rage."
				+ "\n Your feet fly out from under you as you are swept out the window. "
				+ "\n The force pulls your body ever quicker.", allOpts[34]);

		allOpts[35] = new Option[1];
		allOpts[35][0] = new Option("Squish.", 1, 11);
		
		e[35] = new GameEvent("You crash into a plane."
				+ "\n You hear a loud crunching.", allOpts[35]);

		allOpts[36] = new Option[1];
		allOpts[36][0] = new Option("'..- ....  --- ....'", 1, 37);
		
		e[36] = new GameEvent("The force of gravity grows exponentially stronger. "
				+ "\n You buckle under the weight, snapping into a two dimensional form of your former self.", allOpts[36]);

		allOpts[37] = new Option[2];
		allOpts[37][0] = new Option("'... --- ...'", 1, 38);
		allOpts[37][1] = new Option("--. .. ...- . ..- .--.", 2, 11);
		
		e[37] = new GameEvent("'Comfortable?'", allOpts[37]);

		allOpts[38] = new Option[1];
		allOpts[38][0] = new Option("-.-. .- .-.. .-.. - --- - .... . -.. . . .--. --- -. .", 1, 54);
		
		e[38] = new GameEvent("'How amusing.'", allOpts[38]);

		allOpts[39] = new Option[2];
		allOpts[39][0] = new Option("..-. .-.. --- .- -", 1, 39);
		allOpts[39][1] = new Option("... --- .- -.- ..- .--. - .... . .-- .- - . .-.", 2, 40);
		
		e[39] = new GameEvent("The force flattens you so instantaneously,"
				+ "\n you are pressed through the floor and sink to the bottom of a vast ocean.", allOpts[39]);
		
		allOpts[40] = new Option[2];
		allOpts[40][0] = new Option("Swim up.", 1, 96);
		allOpts[40][1] = new Option("Swim down.", 2, 91);
		
		e[40] = new GameEvent("You feel yourself regaining your old form. "
				+ "\n You see a cave in the waters beneath you.", allOpts[40]);

		allOpts[41] = new Option[2];
		allOpts[41][0] = new Option("Go to Dr. Schilling's office.", 1, 21);
		allOpts[41][1] = new Option("RUN.", 2, 3);
		
		e[41] = new GameEvent("'Come with me to my office please.'", allOpts[41]);
		
		allOpts[42] = new Option[2];
		allOpts[42][0] = new Option("Hide in the porta-potty.", 1, 43);
		allOpts[42][1] = new Option("Keep running.", 2, 44);
		
		e[42] = new GameEvent("You scan your surroundings for somewhere to hide."
				+ "\n The only thing close enough is a bright blue porta-potty.", allOpts[42]);
		
		allOpts[43] = new Option[2];
		allOpts[43][0] = new Option("Take your seat.", 1, 70);
		allOpts[43][1] = new Option("Find another way.", 2, 44);
		
		e[43] = new GameEvent("As you approach the porta-potty, it begins to tremble."
				+ "\n The door swings open... 'Ah, just in time!' "
				+ "\n It's... your history class?", allOpts[43]);
		
		
		allOpts[44] = new Option[1];
		allOpts[44][0] = new Option("'Jeez.'", 1, 11);
		
		e[44] = new GameEvent("The sounds behind you become overwhelmingly loud."
				+ "\n You are knocked down by a tremendous force.", allOpts[44]);
		
		allOpts[45] = new Option[1];
		allOpts[45][0] = new Option("Begin class.", 1, 70);
		
		e[45] = new GameEvent("You find yourself in history class, a little confused.", allOpts[45]);
		
		allOpts[46] = new Option[1];
		allOpts[46][0] = new Option("Oh noooooooooooooooo!", 1, 47);
		
		e[46] = new GameEvent("Dr. Main chuckles. With a flick of his wrist, you rocket into the sky. "
				+ "\n You lose sight of the ground.", allOpts[46]);
		
		allOpts[47] = new Option[2];
		allOpts[47][0] = new Option("'Put me down!", 1, 48);
		allOpts[47][1] = new Option("'To space?'", 2, 160);
		
		e[47] = new GameEvent("You continue flying directly away from the Earth. "
				+ "\n How far will you go?", allOpts[47]);
		
		allOpts[48] = new Option[1];
		allOpts[48][0] = new Option("'No no no.'", 1, 49);
		
		e[48] = new GameEvent("You begin to fall. You gain speed.", allOpts[48]);
		
		allOpts[49] = new Option[1];
		allOpts[49][0] = new Option("Ouch.", 1, 11);
		
		e[49] = new GameEvent("CRASH.");
		
		allOpts[50] = new Option[4];
		allOpts[50][0] = new Option("Woe and despair.", 1, 54);
		allOpts[50][1] = new Option("Malice and rage.", 2, 55);
		allOpts[50][2] = new Option("Pride and joy.", 3, 56);
		allOpts[50][3] = new Option("'I can change it.'", 4, 51);
		
		e[50] = new GameEvent("Your mind rushes through every choice you have made in your life. "
				+ "\n You sense a vast matrix of branching decisions.", allOpts[50]);

		allOpts[51] = new Option[2];
		allOpts[51][0] = new Option("Shrug.", 1, 52);
		allOpts[51][1] = new Option("Try something new.", 2, 11);
		
		e[51] = new GameEvent("What will you do?", allOpts[51]);

		allOpts[52] = new Option[2];
		allOpts[52][0] = new Option("'I can't do it.'", 1, 11);
		allOpts[52][1] = new Option("'How do I fix it?'", 2, 53);
		
		e[52] = new GameEvent("You will fix it. Have faith.", allOpts[52]);

		allOpts[53] = new Option[1];
		allOpts[53][0] = new Option("'I'll try my best.'", 1, 11);
		
		e[53] = new GameEvent("Just keep learning. You are on the right path.", allOpts[53]);

		allOpts[54] = new Option[1];
		allOpts[54][0] = new Option("'Nothing new...'", 1, 11);
		
		e[54] = new GameEvent("Woe overtakes your world.", allOpts[54]);
		
		allOpts[55] = new Option[1];
		allOpts[55][0] = new Option("'They deserve it.'", 1, 11);
		
		e[55] = new GameEvent("Malice devours all.", allOpts[55]);

		allOpts[56] = new Option[1];
		allOpts[56][0] = new Option("'Good for me.'", 1, 11);
		
		e[56] = new GameEvent("Pride subsumes your being.", allOpts[56]);

		allOpts[57] = new Option[2];
		allOpts[57][0] = new Option("RUN.", 1, 3);
		allOpts[57][1] = new Option("Head inside.", 2, 2);
		
		e[57] = new GameEvent("You scream as loud as you can."
				+ "\n Your rage emanates through the air.", allOpts[57]);

		
		
		allOpts[60] = new Option[2];
		allOpts[60][0] = new Option("Take your seat.", 1, 61);
		allOpts[60][1] = new Option("'This is too much.'", 2, 11);
		
		e[60] = new GameEvent("You rush to the door and with some effort, it swings open. "
				+ "\n Inside you see... "
				+ "\n ...your science class?", allOpts[60]);
		
		allOpts[61] = new Option[4];
		allOpts[61][0] = new Option("is a bacteria that eats plastic.", 1, 62);
		allOpts[61][1] = new Option("are the powerhouse of the cell.", 2, 63);
		allOpts[61][2] = new Option("are an alien race from Star Trek.", 3, 62);
		allOpts[61][3] = new Option("is a fantasy kingdom.", 4, 62);
		
		e[61] = new GameEvent("The Mitochondria...", allOpts[61]);

		allOpts[62] = new Option[4];
		allOpts[62][0] = new Option("is a bacteria that eats plastic.", 1, 62);
		allOpts[62][1] = new Option("are the powerhouse of the cell.", 2, 64);
		allOpts[62][2] = new Option("are an alien race from Star Trek.", 3, 62);
		allOpts[62][3] = new Option("is a fantasy kingdom.", 4, 62);
		
		e[62] = new GameEvent("Incorrect, please try again.", allOpts[62]);

		allOpts[63] = new Option[2];
		allOpts[63][0] = new Option("Look for the 3rd floor.", 1, 100);
		allOpts[63][1] = new Option("'There's a third floor?!'", 2, 100);
		
		e[63] = new GameEvent("'Congratulations! You just earned a nobel prize in biology!' "
				+ "\n 'Please make your way to the 3rd floor for the award ceremony.'", allOpts[63]);

		allOpts[64] = new Option[2];
		allOpts[64][0] = new Option("Wait for your next class.", 1, 45);
		allOpts[64][1] = new Option("Time for a bathroom break.", 2, 65);
		
		e[64] = new GameEvent("'Good enough, I guess.'", allOpts[64]);
		
		allOpts[65] = new Option[3];
		allOpts[65][0] = new Option("First stall.", 1, 66);
		allOpts[65][1] = new Option("Second stall.", 2, 67);
		allOpts[65][2] = new Option("Third stall.", 3, 100);
		
		e[65] = new GameEvent("In the bathroom, there are three stalls before you. Which stall will you choose?", allOpts[65]);
		
		if (randomizer == 0) {
		
			allOpts[66] = new Option[2];
			allOpts[66][0] = new Option("Enter the stall.", 1, 91);
			allOpts[66][1] = new Option("Choose another stall.", 2, 65);
			e[66] = new GameEvent("Water pours out as you open the stall. Inside you see a vast ocean.", allOpts[66]);
			
			allOpts[67] = new Option[2];
			allOpts[67][0] = new Option("Enter the stall.", 1, 171);
			allOpts[67][1] = new Option("Choose another stall.", 2, 65);
			e[67] = new GameEvent("You see a vast expanse of woods. The bathroom grows humid.", allOpts[67]);
			
			allOpts[68] = new Option[2];
			allOpts[68][0] = new Option("Enter the stall.", 1, 130);
			allOpts[68][1] = new Option("Choose another stall.", 2, 65);
			e[68] = new GameEvent("You see a dark maze. Sounds echo for eons.", allOpts[68]);
				
		} else if (randomizer == 1 || randomizer == 2) {
			allOpts[66] = new Option[2];
			allOpts[66][0] = new Option("Enter the stall.", 1, 69);
			allOpts[66][1] = new Option("Choose another stall.", 2, 65);
			e[66] = new GameEvent("It looks like a regular bathroom stall.", allOpts[66]);
			
			allOpts[67] = new Option[2];
			allOpts[67][0] = new Option("Enter the stall.", 1, 6);
			allOpts[67][1] = new Option("Choose another stall.", 2, 65);
			
			e[67] = new GameEvent("You see a highway stretching into the distance. Cars zoom by.", allOpts[67]);
			
			allOpts[68] = new Option[2];
			allOpts[68][0] = new Option("Enter the stall.", 1, 171);
			allOpts[68][1] = new Option("Choose another stall.", 2, 65);
			e[68] = new GameEvent("You see a vast expanse of woods. The bathroom grows humid.", allOpts[68]);
		} else if (randomizer == 3 || randomizer == 4) {
			allOpts[66] = new Option[2];
			allOpts[66][0] = new Option("Enter the stall.", 1, 69);
			allOpts[66][1] = new Option("Choose another stall.", 2, 65);
			e[66] = new GameEvent("It looks like a regular bathroom stall.", allOpts[66]);
			
			allOpts[67] = new Option[2];
			allOpts[67][0] = new Option("Enter the stall.", 1, 6);
			allOpts[67][1] = new Option("Choose another stall.", 2, 65);
			
			e[67] = new GameEvent("You see a highway stretching into the distance. Cars zoom by.", allOpts[67]);
			
			allOpts[68] = new Option[2];
			allOpts[68][0] = new Option("Enter the stall.", 1, 130);
			allOpts[68][1] = new Option("Choose another stall.", 2, 65);
			e[68] = new GameEvent("You see a dark maze. Sounds echo for eons.", allOpts[68]);
		} else if (randomizer == 5 || randomizer == 6) {
			allOpts[66] = new Option[2];
			allOpts[66][0] = new Option("Enter the stall.", 1, 69);
			allOpts[66][1] = new Option("Choose another stall.", 2, 65);
			e[66] = new GameEvent("It looks like a regular bathroom stall.", allOpts[66]);
			
			allOpts[67] = new Option[2];
			allOpts[67][0] = new Option("Enter the stall.", 1, 6);
			allOpts[67][1] = new Option("Choose another stall.", 2, 65);
			
			e[67] = new GameEvent("You see a highway stretching into the distance. Cars zoom by.", allOpts[67]);
			
			allOpts[68] = new Option[2];
			allOpts[68][0] = new Option("Enter the stall.", 1, 69);
			allOpts[68][1] = new Option("Choose another stall.", 2, 65);
			e[68] = new GameEvent("It looks like a regular bathroom stall.", allOpts[68]);
		} else if (randomizer == 7 || randomizer == 8) { 
			allOpts[66] = new Option[2];
			allOpts[66][0] = new Option("Enter the stall.", 1, 69);
			allOpts[66][1] = new Option("Choose another stall.", 2, 65);
			e[66] = new GameEvent("It looks like a regular bathroom stall.", allOpts[66]);
			
			allOpts[67] = new Option[2];
			allOpts[67][0] = new Option("Enter the stall.", 1, 69);
			allOpts[67][1] = new Option("Choose another stall.", 2, 65);
			e[67] = new GameEvent("It looks like a regular bathroom stall.", allOpts[67]);
			
			allOpts[68] = new Option[2];
			allOpts[68][0] = new Option("Enter the stall.", 1, 69);
			allOpts[68][1] = new Option("Choose another stall.", 2, 65);
			e[68] = new GameEvent("It looks like a regular bathroom stall.", allOpts[68]);
		} else if (randomizer == 9) {
			allOpts[66] = new Option[2];
			allOpts[66][0] = new Option("Enter the stall.", 1, 69);
			allOpts[66][1] = new Option("Choose another stall.", 2, 65);
			e[66] = new GameEvent("It looks like a regular bathroom stall.", allOpts[66]);
			
			allOpts[67] = new Option[2];
			allOpts[67][0] = new Option("Enter the stall.", 1, 6);
			allOpts[67][1] = new Option("Choose another stall.", 2, 65);
			
			e[67] = new GameEvent("You see a highway stretching into the distance. Cars zoom by.", allOpts[67]);
			
			allOpts[68] = new Option[2];
			allOpts[68][0] = new Option("Enter the stall.", 1, 130);
			allOpts[68][1] = new Option("Choose another stall.", 2, 65);
			
			e[68] = new GameEvent("You see a dark maze. Sounds echo for eons.", allOpts[68]);
		}
		
		allOpts[69] = new Option[1];
		allOpts[69][0] = new Option("'Awesome.'", 1, 65);
		
		e[69] = new GameEvent("You poop.", allOpts[69]);
		
		allOpts[70] = new Option[4];
		allOpts[70][0] = new Option("1066 AD", 1, 72);
		allOpts[70][1] = new Option("1213 AD", 2, 71);
		allOpts[70][2] = new Option("1945 AD", 3, 71);
		allOpts[70][3] = new Option("1444 AD", 4, 71);
		
		e[70] = new GameEvent("What year was the battle of Hastings?", allOpts[70]);

		allOpts[71] = new Option[4];
		allOpts[71][0] = new Option("1066 AD", 1, 73);
		allOpts[71][1] = new Option("1213 AD", 2, 71);
		allOpts[71][2] = new Option("1945 AD", 3, 71);
		allOpts[71][3] = new Option("1444 AD", 4, 71);
		
		e[71] = new GameEvent("'I don't think that's right. Give it another try.'", allOpts[71]);

		allOpts[72] = new Option[2];
		allOpts[72][0] = new Option("Kowtow.", 1, 76);
		allOpts[72][1] = new Option("Make your escape.", 2, 75);
		
		e[72] = new GameEvent("You hear the call of a bugle, followed by a drum roll. "
				+ "\n 'Clear the way for his excellency, President of the Highschool, and teacher of history:"
				+ "\n Supreme Leader Heflin!", allOpts[72]);

		allOpts[73] = new Option[2];
		allOpts[73][0] = new Option("'I would say so.'", 1, 170);
		allOpts[73][1] = new Option("'Nah, I just guessed.'", 2, 74);
		
		e[73] = new GameEvent("'So you think you know a lot about history, huh?'", allOpts[73]);
		
		allOpts[74] = new Option[1];
		allOpts[74][0] = new Option("Head to lunch.",  1, 120);
		
		e[74] = new GameEvent("The halls begin to buzz with the sound of students. "
				+ "\n 'Seems it is time for lunch.", allOpts[74]);
		
		allOpts[75] = new Option[1];
		allOpts[75][0] = new Option("Swim up.", 1, 91);
		
		e[75] = new GameEvent("You run to the door of the classroom and throw it open."
				+ "\n Water rushes through as you are pulled into the ocean outside.", allOpts[75]);
		
		allOpts[76] = new Option[3];
		allOpts[76][0] = new Option("'Just give me a good grade.'", 1, 100);
		allOpts[76][1] = new Option("'I would like land and a title.'", 2, 100);
		allOpts[76][2] = new Option("'Show me history.'", 3, 77);
		
		e[76] = new GameEvent("'Rise young one. You may request a boon.'", allOpts[76]);
		
		allOpts[77] = new Option[1];
		allOpts[77][0] = new Option("Close your eyes.", 1, 78);
		
		e[77] = new GameEvent("'Very well, close your eyes.'", allOpts[77]);
		
		allOpts[78] = new Option[1];
		allOpts[78][0] = new Option("Open your eyes.", 1, 171);
		
		e[78] = new GameEvent("The sound of the classroom fades. "
				+ "\n You begin to hear wind, and bugs.", allOpts[78]);
		
		allOpts[79] = new Option[1];
		allOpts[79][0] = new Option("Head to lunch.", 1, 120);
		
		e[79] = new GameEvent("'Very well, you have earned an A.' "
				+ "\n The halls begin to buzz with the sound of students."
				+ "\n 'Seems it is time for lunch.'", allOpts[79]);
		
		allOpts[80] = new Option[2];
		allOpts[80][0] = new Option("Speak with Dr. Schilling.", 1, 21);
		allOpts[80][1] = new Option("Try to become a rock.", 2, 81);
		
		e[80] = new GameEvent("'There isn't time for that, Dr. Schilling is waiting.'", allOpts[80]);

		allOpts[81] = new Option[2];
		allOpts[81][0] = new Option("Speak with Dr. Schilling.", 1, 21);
		allOpts[81][1] = new Option("Try really really hard to become a rock.", 2, 81);
		
		e[81] = new GameEvent("'You can't wait this out.'", allOpts[81]);

		allOpts[82] = new Option[1];
		allOpts[82][0] = new Option("Wait it out.", 1, 82);
		
		e[82] = new GameEvent("You are a rock.", allOpts[82]);

		allOpts[83] = new Option[2];
		allOpts[83][0] = new Option("See if Dr. Schilling is still in her office.", 1, 84);
		allOpts[83][1] = new Option("Head to science class.", 2, 61);
		
		e[83] = new GameEvent("You're alone in the office. It is eerily quiet.", allOpts[83]);

		allOpts[84] = new Option[1];
		allOpts[84][0] = new Option("'It calls to me.'", 1, 85);
		
		e[84] = new GameEvent("Dr. Schilling's office is empty, but her computer monitor warms you with its soft glow.", allOpts[84]);
		
		allOpts[85] = new Option[1];
		allOpts[85][0] = new Option("'zzzzt'", 1, 140);
		
		e[85] = new GameEvent("The static on the monitor buzzes louder and louder. IT consumes you.", allOpts[85]);
		
		allOpts[90] = new Option[2];
		allOpts[90][0] = new Option("Swim down.", 1, 91);
		allOpts[90][1] = new Option("Swim to the shallows.", 2, 96);
		
		e[90] = new GameEvent("You line yourself up and dive head first toward the next car. "
				+ "\n You open your eyes to find yourself in a deep ocean."
				+ "\n Above you are the cars, melting through the road like ice on a lake."
				+ "\n Ahead you see a distant shore.", allOpts[90]);

		allOpts[91] = new Option[2];
		allOpts[91][0] = new Option("Enter the cave.", 1, 92);
		allOpts[91][1] = new Option("Swim back up.", 2, 90);
		
		e[91] = new GameEvent("You see an underwater cave. It emits a cool blue glow."
				+ "\n Occasionally, a cluster of bubbles fumbles out.", allOpts[91]);

		allOpts[92] = new Option[2];
		allOpts[92][0] = new Option("Take your seat.", 1, 70);
		allOpts[92][1] = new Option("Swim back up.", 2, 90);
		
		e[92] = new GameEvent("At the end of the cave, blue light spills through a small hole."
				+ "\n Through the hole you see..."
				+ "\n ... your history class?", allOpts[92]);

		allOpts[93] = new Option[3];
		allOpts[93][0] = new Option("Climb into the crevice.", 1, 94);
		allOpts[93][1] = new Option("Rest.", 2, 93);
		allOpts[93][2] = new Option("'I'm bored.'", 3, 91);
		
		e[93] = new GameEvent("You curl up on the floor of the cave. "
				+ "\n As you rub the smooth rock with your hands,"
				+ "\n you feel a small crevice.", allOpts[93]);

		allOpts[94] = new Option[3];
		allOpts[94][0] = new Option("Keep going.", 1, 94);
		allOpts[94][1] = new Option("Rest.", 2, 101);
		allOpts[94][2] = new Option("Try to get out.", 3, 95);
		
		e[94] = new GameEvent("You manage to snake your way through the narrow crevice."
				+ "\n As you squirm, you find yourself in pitch black darkness.", allOpts[94]);

		allOpts[95] = new Option[2];
		allOpts[95][0] = new Option("'What have I done.'", 1, 94);
		allOpts[95][1] = new Option("Rest.", 2, 101);
		
		e[95] = new GameEvent("You are unable to turn around or move backward."
				+ "\n The crevice has gripped you firmly.", allOpts[95]);

		allOpts[96] = new Option[2];
		allOpts[96][0] = new Option("Keep swimming.", 1, 96);
		allOpts[96][1] = new Option("Swim down.", 2, 97);
		
		e[96] = new GameEvent("You swim and swim but the shore seems to eternally elude you.", allOpts[96]);

		allOpts[97] = new Option[2];
		allOpts[97][0] = new Option("Keep swimming down.", 1, 97);
		allOpts[97][1] = new Option("Swim to shore.", 2, 96);
		
		e[97] = new GameEvent("You swim down, but the ocean floor grows further.", allOpts[97]);

		allOpts[98] = new Option[2];
		allOpts[98][0] = new Option("Walk ashore.", 1, 99);
		allOpts[98][1] = new Option("Swim back.", 2, 96);
		
		e[98] = new GameEvent("Finally, the water grows shallow. You can see a beach before you.", allOpts[98]);

		allOpts[99] = new Option[1];
		allOpts[99][0] = new Option("Keep walking.", 1, 15);
		
		e[99] = new GameEvent("You emerge on the beach. "
				+ "\n As you walk inland, the sound of lapping waves seems to grow louder.", allOpts[99]);

		allOpts[100] = new Option[1];
		allOpts[100][0] = new Option("Restart.", 1, 1);
		
		e[100] = new GameEvent("You aren't supposed to be here, "
				+ "\n this branch is unfinished.", allOpts[100]);

		allOpts[101] = new Option[3];
		allOpts[101][0] = new Option("Start squirming again.", 1, 94);
		allOpts[101][1] = new Option("Keep resting.", 2, 101);
		allOpts[101][2] = new Option("Try to get out.", 3, 95);
		
		e[101] = new GameEvent("You rest for a moment. Strange noises compel you to move.", allOpts[101]);

		
		
		e[102] = new GameEvent("", allOpts[102]);
		
		
		allOpts[110] = new Option[3];
		allOpts[110][0] = new Option("'What can I do?'", 1, 111);
		allOpts[110][1] = new Option("'Why would I help you?'", 2, 112);
		allOpts[110][2] = new Option("'Figure it out yourself.'", 3, 114);
		
		e[110] = new GameEvent("'You must've noticed, this world is falling apart.'"
				+ "\n 'We need your help.'", allOpts[110]);

		allOpts[111] = new Option[2];
		allOpts[111][0] = new Option("Yes.", 1, 113);
		allOpts[111][1] = new Option("No.", 2, 114);
		
		e[111] = new GameEvent("'Do you know Java?'", allOpts[111]);

		allOpts[112] = new Option[2];
		allOpts[112][0] = new Option("'Fine, what can I do?'", 1, 111);
		allOpts[112][1] = new Option("You're on your own.", 1, 114);
		
		e[112] = new GameEvent("'The choice is yours."
				+ "\n But this is how you get answers.'", allOpts[112]);

		allOpts[113] = new Option[1];
		allOpts[113][0] = new Option("Let me try.", 1, 115);
		
		e[113] = new GameEvent("'There isn't time for me to explain any more."
				+ "\n You need to edit the source code and fix the broken timelines."
				+ "\n Can you do that?'", allOpts[113]);

		allOpts[114] = new Option[1];
		allOpts[114][0] = new Option("Sink", 1, 130);
		
		e[114] = new GameEvent("'I had hoped we could come to some arrangement, but alas...'", allOpts[114]);

		allOpts[115] = new Option[0];
		
		e[115] = new GameEvent("'Good luck.'", allOpts[115]);
		
		allOpts[120] = new Option[3];
		
		
		e[120] = new GameEvent("You sit down for lunch. What will you eat?", allOpts[120]);
		
		//allOpts[115][0] = new Option("", 1, 100);
		
		allOpts[130] = new Option[2];
		allOpts[130][0] = new Option("Left.", 1, 100);
		allOpts[130][1] = new Option("Right.", 2, 100);
		
		e[130] = new GameEvent("You sink deep below the school, to a dark maze."
				+ "\n A roaring sound echoes around the byzantine halls.", allOpts[130]);
		
		allOpts[140] = new Option[3];
		allOpts[140][0] = new Option("Smack a tree.", 1, 141);
		allOpts[140][1] = new Option("Smack the ground.", 2, 142);
		allOpts[140][2] = new Option("Walk around.", 3, 100);
		
		e[140] = new GameEvent("You find yourself in a forest... made of blocks.", allOpts[140]);
		
		allOpts[141] = new Option[3];
		allOpts[141][0] = new Option("Smack the tree again.", 1, 141);
		allOpts[141][1] = new Option("Smack the ground.", 2, 142);
		allOpts[141][2] = new Option("Walk around.", 3, 100);
		
		e[141] = new GameEvent("You smack a nearby tree. Your hand hurts slightly.", allOpts[141]);
		
		allOpts[142] = new Option[3];
		allOpts[142][0] = new Option("Smack a tree.", 1, 141);
		allOpts[142][1] = new Option("Smack the ground again.", 2, 142);
		allOpts[142][2] = new Option("Walk around.", 3, 100);
		
		e[142] = new GameEvent("You smack the ground. Your hand gets a bit dirty.", allOpts[142]);
		
		
		allOpts[143] = new Option[3];
		allOpts[143][0] = new Option("Craft a crafting table.", 1, 144);
		allOpts[143][1] = new Option("Smack the ground.", 2, 142);
		allOpts[143][2] = new Option("Walk around.", 3, 100);
		
		e[143] = new GameEvent("The tree breaks with a satisfying pop. You collect a few wood blocks.", allOpts[143]);
		
		allOpts[144] = new Option[2];
		allOpts[144][0] = new Option("A pickaxe.", 1, 145);
		allOpts[144][1] = new Option("Too many stairs.", 2, 100);
		
		e[144] = new GameEvent("You create and place a crafting table. What will you craft?", allOpts[144]);
		
		allOpts[145] = new Option[2];
		allOpts[145][0] = new Option("Mine the ground.", 1, 146);
		allOpts[145][1] = new Option("Walk around.", 2, 100);
		
		e[145] = new GameEvent("You have crafted a pickaxe. What will you do now?", allOpts[145]);
		
		allOpts[146] = new Option[2];
		allOpts[146][0] = new Option("Enter the cavern.", 1, 147);
		allOpts[146][1] = new Option("Walk around.", 2, 100);
		
		e[146] = new GameEvent("The dirt block is destroyed with a satisfying pop. You collect it. "
				+ "\n Below you can see a dark cavern.", allOpts[146]);
		
		allOpts[147] = new Option[1];
		allOpts[147][0] = new Option("Head toward the light.", 1, 148);
		
		e[147] = new GameEvent("You hear many spooky noises around you. "
				+ "\n Toward one end of the cavern you can see a dim glow.", allOpts[147]);
		
		allOpts[148] = new Option[2];
		allOpts[148][0] = new Option("Look for some ore.", 1, 149);
		allOpts[148][1] = new Option("Hop in the lava.", 2, 11);
		
		e[148] = new GameEvent("After some traversing, you arrive at a vast pool of lava.", allOpts[148]);
		
		allOpts[149] = new Option[1];
		allOpts[149][0] = new Option("'AAAHHHHHH!'", 1, 130);
		
		e[149] = new GameEvent("You find some iron, but commit the cardinal sin of mining directly under your feet."
				+ "\n You fall and fall and fall.", allOpts[149] );

		allOpts[150] = new Option[2];
		allOpts[150][0] = new Option("'Where am I?'", 1, 100);
		allOpts[150][1] = new Option("'Good to see you.'", 2, 151);
		
		e[150] = new GameEvent("'Welcome to my domain.'", allOpts[150]);

		allOpts[151] = new Option[1];
		allOpts[151][0] = new Option("'What is my fate?'", 1, 152);
		
		e[151] = new GameEvent("'You are here for something.'", allOpts[151]);

		allOpts[152] = new Option[2];
		allOpts[152][0] = new Option("'Reroll my fate.'", 1, 153);
		allOpts[152][1] = new Option("'I am happy with this fate.", 2, 154);
		
		e[152] = new GameEvent("Your fate has not yet been decided.", allOpts[152]);

		allOpts[153] = new Option[1];
		allOpts[153][0] = new Option("'Me too.'", 1, 11);
		
		e[153] = new GameEvent("'I hope this fate will bring you peace.", allOpts[153]);

		allOpts[154] = new Option[1];
		allOpts[154][0] = new Option("'Thanks.'", 1, 11);
		
		e[154] = new GameEvent("'Allow me to return you, then.", allOpts[154]);
		
		
		allOpts[160] = new Option[2];
		allOpts[160][0] = new Option("Float as long as you can.", 1, 160);
		allOpts[160][1] = new Option("Try to slow down.", 2, 162);
		
		e[160] = new GameEvent("You exit the atmosphere. You have retained significant momentum.", allOpts[160]);
		
		allOpts[161] = new Option[2];
		allOpts[161][0] = new Option("Keep floating.", 1, 161);
		allOpts[161][1] = new Option("Try to slow down.", 2, 162);
		
		e[161] = new GameEvent("You are flying through empty space.", allOpts[161]);
		
		allOpts[162] = new Option[2];
		allOpts[162][0] = new Option("Keep flailing your arms.", 1, 162);
		allOpts[162][1] = new Option("Just float.", 2, 161);
		
		e[162] = new GameEvent("You flail your arms, trying to slow down.", allOpts[162]);

		allOpts[163] = new Option[1];
		allOpts[163][0] = new Option("Prepare to land.", 1, 164);
		
		e[163] = new GameEvent("You feel the need to look behind you. "
				+ "\n As you turn around, a massive object dominates your view.", allOpts[163]);
		
		allOpts[164] = new Option[1];
		allOpts[164][0] = new Option("Walk around.", 1, 165);
		
		e[164] = new GameEvent("After some time, you collide with the surface of this object. "
				+ "\n It appears to have enough gravitational pull for you to walk.", allOpts[164]);
		
		allOpts[165] = new Option[2];
		allOpts[165][0] = new Option("Keep walking.", 1, 166);
		allOpts[165][1] = new Option("Contemplate your choices.", 2, 50);
		
		e[165] = new GameEvent("You walk for about 45 minutes. This location looks familiar to you.", allOpts[165]);
		
		allOpts[166] = new Option[2];
		allOpts[166][0] = new Option("Keep walking.", 1, 166);
		allOpts[166][1] = new Option("Contemplate your choices.", 2, 50);
		
		e[166] = new GameEvent("It seems you have arrived at the location you started. "
				+ "\n This must be a small planet.", allOpts[166]);
		
		allOpts[170] = new Option[1];
		allOpts[170][0] = new Option("Open your eyes.", 1, 171);
		
		e[170] = new GameEvent("'I suppose we shall see...'"
				+ "\n You become intensely drowsy. Your eyelids close.", allOpts[170]);
		
		allOpts[171] = new Option[3];
		allOpts[171][0] = new Option("Observe your surroundings.", 1, 172);
		allOpts[171][1] = new Option("Call for help.", 2, 173);
		allOpts[171][2] = new Option("Start walking.", 3, 174);
		
		e[171] = new GameEvent("You stand in a clearing of a small hill.", allOpts[171]);
		
		allOpts[172] = new Option[3];
		allOpts[172][0] = new Option("Walk toward the corn.", 1, 180);
		allOpts[172][1] = new Option("Walk away from the corn.", 2, 185);
		allOpts[172][2] = new Option("Call for help.", 3, 173);
		
		e[172] = new GameEvent("The air is hot and wet. Insects buzz about. Far in the distance, you can see..."
				+ "\n CORN!", allOpts[172]);
		
		allOpts[173] = new Option[3];
		allOpts[173][0] = new Option("Observe your surroundings.", 1, 172);
		allOpts[173][1] = new Option("Start walking.", 2, 174);
		allOpts[173][2] = new Option("Call again.", 3, 173);
		
		e[173] = new GameEvent("You yell as loud as you can. "
				+ "\n Birds scatter from the trees.", allOpts[173]);
		
		allOpts[174] = new Option[2];
		allOpts[174][0] = new Option("Uphill.", 1, 180);
		allOpts[174][1] = new Option("Downhill.", 2, 185);
		
		e[174] = new GameEvent("Which way will you walk?", allOpts[174]);
		
		allOpts[175] = new Option[2];
		allOpts[175][0] = new Option("'Pardon?'", 1, 176);
		allOpts[175][1] = new Option("'What does that mean?'", 2, 176);
		
		e[175] = new GameEvent("The ground trembles with the rythmic pounding of hooves. "
				+ "\n Before you can react, you are surrounded."
				+ "\n 'waaphkilookia, keetwi iišileniyani?'", allOpts[175]);
		
		allOpts[176] = new Option[2];
		allOpts[176][0] = new Option("Nod yes.", 1, 180);
		allOpts[176][1] = new Option("Shake your head no.", 2, 177);
		
		e[176] = new GameEvent("'noonki-nko ayiihkwiyani?"
				+ "\n wiiteemiaanki-nko?'", allOpts[176]);
		
		allOpts[177] = new Option[2];
		allOpts[177][0] = new Option("Become indignant.", 1, 178);
		allOpts[177][1] = new Option("Join them.", 2, 180);
		
		e[177] = new GameEvent("'waawiipihkaako! šaaye eehpiši iiyaayankwi!'", allOpts[177]);
		
		allOpts[178] = new Option[1];
		allOpts[178][0] = new Option("Take cover.", 1, 11);
		
		e[178] = new GameEvent("'waaphkilookiaki! maleewinaakatwi!'"
				+ "\n A horn calls. 'Charge!'"
				+ "\n Gunshots ring out. Horses stampede toward you.", allOpts[178]);
		
		allOpts[180] = new Option[2];
		allOpts[180][0] = new Option("Try to help with the cooking.", 1, 181);
		allOpts[180][1] = new Option("Run away.", 2, 185);
		
		e[180] = new GameEvent("You arrive in a small town. People talk while cooking. "
				+ "\n Children are playing. Everywhere there is corn growing.", allOpts[180]);
		
		allOpts[181] = new Option[2];
		allOpts[181][0] = new Option("Eat.", 1, 182);
		allOpts[181][1] = new Option("Stir.", 2, 183);
		
		e[181] = new GameEvent("You ask to help, someone points at a spoon and a pot:"
				+ "\n 'weeyaakahaakani ayoolo, waaphkilookia.'", allOpts[181]);
		
		allOpts[182] = new Option[2];
		allOpts[182][0] = new Option("Run away.", 1, 185);
		allOpts[182][1] = new Option("Laugh along.", 2, 184);
		
		e[182] = new GameEvent("Everyone erupts with laughter as you burn your tongue on the unfinished food.", allOpts[182]);
		
		allOpts[183] = new Option[1];
		allOpts[183][0] = new Option("'iihia.'", 1, 184);
		
		e[183] = new GameEvent("You stir the food. "
				+ "\n 'mihši neewe.'", allOpts[183]);
		
		allOpts[184] = new Option[1];
		allOpts[184][0] = new Option("'maalami aalaankwiaani.'", 1, 11);
		
		e[184] = new GameEvent("The rest of your night is spent enjoying good food and laughter."
				+ "\n Your new friends teach you as much of their language as they can.", allOpts[184]);
		
		allOpts[185] = new Option[2];
		allOpts[185][0] = new Option("'There must be some mistake, I'm American!'", 1, 186);
		allOpts[185][1] = new Option("'You don't sound very American.'", 2, 191);
		
		e[185] = new GameEvent("You walk for a while, until a band of soldiers on horseback spot you."
				+ "\n 'Where art thov travelling, Frenchman? Thov treadft on American landf.'", allOpts[185]);
		
		allOpts[186] = new Option[1];
		allOpts[186][0] = new Option("Protest thine fate.", 1, 187);
		
		e[186] = new GameEvent("'Bvt thine fafhion is that of a Frenchman, fvrely.'"
				+ "'Clap the Frenchman in ironf.'", allOpts[186]);
		
		allOpts[187] = new Option[2];
		allOpts[187][0] = new Option("Try to keep up.", 1, 189);
		allOpts[187][1] = new Option("Drop to the ground.", 2, 188);
		
		e[187] = new GameEvent("The Americans tie your shackles to the saddle of a horse. "
				+ "\n You begin to walk behind the soldiers. "
				+ "\n The horse drags you along at an uncomfortable pace.", allOpts[187]);
		
		allOpts[188] = new Option[1];
		allOpts[188][0] = new Option("'Why?'", 1, 11);
		
		e[188] = new GameEvent("You fall into the dirt, the horse drags you for a while."
				+ "\n The course ground breaking your skin as you're pulled forward."
				+ "\n You lose consciousness.", allOpts[188]);
		
		allOpts[189] = new Option[1];
		allOpts[189][0] = new Option("Wait.", 1, 190);
		
		e[189] = new GameEvent("You are sure you have walked several miles at this point. It must have been hours."
				+ "\n Exhausted, you finally arrive at the Americans' camp. The surroundings here disgust you."
				+ "\n You are chained to a post.", allOpts[189]);
		
		allOpts[190] = new Option[1];
		allOpts[190][0] = new Option("Keep waiting.", 1, 190);
		
		e[190] = new GameEvent("You cannot seem to find a comfortable way to sit. The camp stirs around you."
				+ "\n They seem to be preparing for war.", allOpts[190]);
		
		
		allOpts[191] = new Option[1];
		allOpts[191][0] = new Option("Protest thine fate.", 1, 187);
		
		e[191] = new GameEvent("'Fpoken like a trve Frenchman!' "
				+ "\n 'Clap him in ironf.'", allOpts[191]);
		
		return e;
	} 
	
	static public void fullReset() {
		contemplationComplete = false;
		woe = false;
		malice = false;
		pride = false;
		foundCarPortal = false;
		foundYellowDoor = false;
		foundCavePortal = false;
		restUnlocked = false;
		
		resetCounters();
		
		
	}
	
	static public void resetCounters() {
		noIDontCounter = 0;
		triedToBeRockCounter = 0;
		isARockCounter = 0;
		caveDiverCounter = 0;
		restCounter = 0;
		swimToShoreCounter = 0;
		swimDownCounter = 0;
	}
	
	static public void woe() {
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
	
	static public void malice() {
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
	
	static public void pride() {
		pride = true;
		woe = false;
		malice = false;
	}
	
	static public void peace() {
		pride = true;
		woe = false;
		malice = false;
		peace = true;
	}
	
	public static int checkReroutes(int i) {
		
		if (i == 173) {
			callForHelpCounter++;
			
			if (callForHelpCounter > 0) {
				allEvents[173] = new GameEvent("You yell as loud as you can. ", allEvents[173].options);
			}
			
			if (callForHelpCounter > 6) {
				allEvents[173].options = new Option[3];
				allEvents[173].options[0] = new Option("Observe your surroundings.", 1, 175);
				allEvents[173].options[1] = new Option("Start walking.", 2, 175);
				allEvents[173].options[2] = new Option("Call again.", 3, 175);
			}
			
		}
		
		if (i == 162) {
			spaceSpeed = spaceSpeed - 1;
			spaceDistance = spaceDistance + spaceSpeed;
			
			if (spaceDistance > 2500) {
				allEvents[161].options = new Option[2];
				allEvents[161].options[0] = new Option("Keep floating.", 1, 163);
				allEvents[161].options[1] = new Option("Try to slow down.", 2, 163);
				
				allEvents[161] = new GameEvent("You are flying through empty space.", allEvents[161].options);
				
				allEvents[162].options = new Option[2];
				allEvents[162].options[0] = new Option("Keep flailing your arms.", 1, 163);
				allEvents[162].options[1] = new Option("Just float.", 2, 163);
				
				allEvents[162] = new GameEvent("You flail your arms, trying to slow down.", allEvents[162].options);

			}
		}
		
		if (i == 161) {
			spaceDistance = spaceDistance + spaceSpeed;
			
			if (spaceDistance > 2500) {
				allEvents[161].options = new Option[2];
				allEvents[161].options[0] = new Option("Keep floating.", 1, 163);
				allEvents[161].options[1] = new Option("Try to slow down.", 2, 163);
				
				allEvents[161] = new GameEvent("You are flying through empty space.", allEvents[161].options);
				
				allEvents[162].options = new Option[2];
				allEvents[162].options[0] = new Option("Keep flailing your arms.", 1, 163);
				allEvents[162].options[1] = new Option("Just float.", 2, 163);
				
				allEvents[162] = new GameEvent("You flail your arms, trying to slow down.", allEvents[162].options);

			}
		}
		
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
		
		if (i == 150) { 
			thirdEyeOpen = true;
		}
		
		if (i == 145) {
			hasPick = true;
		}
		
		if (i == 142) {
			mineGroundCounter++;
			if (hasPick) mineGroundCounter++;
			
			if (mineGroundCounter > 4) {
				allEvents[142].options = new Option[3];
				allEvents[142].options[0] = new Option("Smack a tree.", 1, 141);
				allEvents[142].options[1] = new Option("Smack the ground again.", 2, 146);
				allEvents[142].options[2] = new Option("Walk around.", 3, 100);
				
				allEvents[142] = new GameEvent("You smack the ground. Your hand gets a bit dirty.", allEvents[142].options);
			}
		}
		
		if (i == 141) {
			mineTreeCounter++;
			if (hasPick) mineTreeCounter++;
			
			if (mineTreeCounter > 10) {
				allEvents[141].options = new Option[3];
				allEvents[141].options[0] = new Option("Smack the tree again.", 1, 143);
				allEvents[141].options[1] = new Option("Smack the ground.", 2, 142);
				allEvents[141].options[2] = new Option("Walk around.", 3, 100);
				
				allEvents[141] = new GameEvent("You smack a nearby tree. Your hand hurts slightly.", allEvents[141].options);
			}
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
		
		if (i == 56) { // Pride
			
			pride();
			
		}
		
		if (i == 55) { // Malice
			
			malice();
			
		}
		
		if (i == 54) { // Woe
			
			woe();
			
		}
		
		if (i == 51) { // If player has contemplated
			//System.out.println("Contemplated");
			contemplationComplete = true;
			//woe = false;
			//pride = false;
			//malice = false;
			
			allEvents[1] = new GameEvent("Your car rolls to a stop outside of the Schilling School. "
					+ "\n Dr. Schilling is waiting.", allOptions[1]);
					
			allEvents[1].options = new Option[3];
			allEvents[1].options[0] = new Option("Head to your math class.", 1, 2);
			allEvents[1].options[1] = new Option("RUN", 2, 3);
			allEvents[1].options[2] = new Option("'Deja Vu'", 3, 41);
			
			
			
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
			
			if (randomizer < 5 && randomizer > 0) {
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
			} else if (randomizer >= 5) {
				allEvents[2].options = new Option[5];
				allEvents[2].options[0] = new Option("-3", 1, 4);
				allEvents[2].options[1] = new Option("-2", 2, 4);
				allEvents[2].options[2] = new Option("4", 3, 5);
				allEvents[2].options[3] = new Option("3", 4, 4);
				allEvents[2].options[4] = new Option("'How did I get here?'", 5, 100);
			}
			
		}
		
		if (i == 11) {
			resetCounters();
			noIDontCounter = 0;
			triedToBeRockCounter = 0;
			isARockCounter = 0;
			caveDiverCounter = 0;
			//restCounter = 0;
			swimToShoreCounter = 0;
			swimDownCounter = 0;
			
			if (restUnlocked)restCounter++;
			
			if (restCounter > 5 || thirdEyeOpen) {
				
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
