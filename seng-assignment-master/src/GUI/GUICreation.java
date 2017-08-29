package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;

import FoodContainer.Burrito;
import FoodContainer.DryBiscuit;
import FoodContainer.Grapes;
import FoodContainer.JellyMeat;
import FoodContainer.Lasagna;
import FoodContainer.Salmon;
import FoodContainer.Seed;
import FoodContainer.SicknessCure;
import FoodContainer.Soup;
import FoodContainer.Steak;
import FoodContainer.Tacos;
import Game.Food;
import Game.Pet;
import Game.Player;
import Game.Species;
import Game.Toys;
import SpeciesContainer.Budgie;
import SpeciesContainer.Cat;
import SpeciesContainer.Dog;
import SpeciesContainer.Manatee;
import SpeciesContainer.Rabbit;
import SpeciesContainer.Sloth;
import ToyContainer.BigBall;
import ToyContainer.BigFrizbee;
import ToyContainer.FluffyTeddy;
import ToyContainer.LongRope;
import ToyContainer.MisbehavouringWhip;
import ToyContainer.OldTeddy;
import ToyContainer.RedBall;
import ToyContainer.ShortRope;
import ToyContainer.SmallFrizbee;
import ToyContainer.SoftDuck;
import ToyContainer.SqueakyDuck;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

/**
 * The GUICreation class is for starting the game up and for a player to create their player and pets.
 * <p>
 * The class defines all the elements of the creation frame. This includes the starting frame, 
 * the help section and the player creation. The class then initializes the GUIMain class for the game to be played
 * 
 * @author Jade Martin
 * @author Kyran Stagg
 *
 */
public class GUICreation {
	/**
	 * Represents the Frame for creating a player
	 */
	private JFrame frmcreation;
	/**
	 * Represents the player name
	 */
	private JTextField txtPlayerName;
	/**
	 * Represents the pet 1 name
	 */
	private JTextField txtPet1name;
	/**
	 * Represents the pet 2 name
	 */
	private JTextField txtPet2Name;
	/**
	 * Represents the pet 3 name
	 */
	private JTextField txtPet3Name;
	/**
	 * Represents the Amount of players to play the game
	 */
	private Integer playerAmount;
	/**
	 * Represents the Amount of game rounds to be played
	 */
	private Integer gameRounds;
	/**
	 * Represents All players in the game
	 */
	private ArrayList<Player> playerList = new ArrayList<Player>();
	/**
	 * Represents all the pet string names in the game
	 */
	private ArrayList<String> petCheckList = new ArrayList<String>();
	/**
	 * Represents all the species available 
	 */
	private ArrayList<Species> petList = createSpecies();
	/**
	 * Represents all the Toys available
	 */
	private ArrayList<Toys> toyList = createToys();
	/**
	 * Represents all the food available
	 */
	private ArrayList<Food> foodList = createFood();
	/**
	 * Represents the text field where the rounds are input.
	 */
	private JTextField txtRounds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICreation window = new GUICreation();
					window.frmcreation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Initialize the GUICreation frame.
	 */
	public GUICreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * This Method has 3 main frames. The starting frame, the help frame and the player creation frame.
	 * The starting frame displays the game name and prompts the user to enter the game rounds and amount of players.
	 * The help frame provides information on how the game is played. 
	 * The Player creation frame asks the user for player names, pet names and pet attributes 
	 * and does so by looping for the amount of players.
	 */
	public void initialize() {
		frmcreation = new JFrame();
		frmcreation.setTitle("Pet Simulator - Creation");
		frmcreation.setBounds(100, 100, 1280, 720);
		frmcreation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmcreation.getContentPane().setLayout(null);

		JPanel pnlCreation = new JPanel();
		pnlCreation.setVisible(false);

		JPanel pnlStart = new JPanel();
		pnlStart.setBounds(10, 11, 1244, 659);
		frmcreation.getContentPane().add(pnlStart);
		pnlStart.setLayout(null);

		JLabel lblNeoPets = new JLabel("Pet Simulator 2017");
		lblNeoPets.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeoPets.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblNeoPets.setBounds(298, 158, 641, 263);
		pnlStart.add(lblNeoPets);

		JTextPane txtpnHelpSection = new JTextPane();
		txtpnHelpSection.setEditable(false);
		txtpnHelpSection.setVisible(false);
		txtpnHelpSection.setText( "Help Section\n\n"
				+ "This Game is about taking care of your pets!\n"
				+ "The game is split into days each day you will get two actions with each pet\n"
				+ "You can feed your pet, play with your pet, sleep with your pet and make it go toilet \n"
				+ "You can buy toys and food in the store you get money at the end of each day. \n"
				+ "The more you take care of you pets the more money you will recieve. \n"
				+ "Your pet can die if you do not take good care of it you will recieve one free revive. \n"
				+ "The higher the weight is of the species the more it will need to eat \n"
				+ "The higher the weight the less sleep your pet will need \n"
				+ "The higher the damage value the more the pet will enjoy playing \n"
				+ "The higher the damage value the faster toys durability will decrease \n"
				+ "With theses factors in mind picking a pet is very important as each pet will have different needs \n");
		txtpnHelpSection.setBounds(10, 11, 1224, 332);
		pnlStart.add(txtpnHelpSection);

		JButton btnStart = new JButton("Start");

		btnStart.setBounds(998, 526, 236, 122);
		pnlStart.add(btnStart);
		pnlCreation.setBounds(10, 11, 1244, 659);
		frmcreation.getContentPane().add(pnlCreation);
		pnlCreation.setLayout(null);

		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(10, 526, 236, 122);
		pnlStart.add(btnHelp);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnHelpSection.setVisible(false);
				lblNeoPets.setVisible(true);
				btnBack.setVisible(false);
				btnHelp.setVisible(true);
			}
		});
		btnBack.setVisible(false);
		btnBack.setBounds(10, 526, 236, 122);
		pnlStart.add(btnBack);

		Integer[] playerAmountList = { 1, 2, 3 };
		JComboBox<?> comboBoxPlayerAmount = new JComboBox<Object>(playerAmountList);
		comboBoxPlayerAmount.setBounds(637, 526, 74, 20);
		pnlStart.add(comboBoxPlayerAmount);

		JLabel lblHowManyPlayers = new JLabel("How Many Players?");
		lblHowManyPlayers.setBounds(494, 529, 133, 14);
		pnlStart.add(lblHowManyPlayers);

		JLabel lblHowManyRounds = new JLabel("How Many Rounds?");
		lblHowManyRounds.setBounds(494, 580, 133, 14);
		pnlStart.add(lblHowManyRounds);

		txtRounds = new JTextField();
		txtRounds.setText("10");
		((AbstractDocument) txtRounds.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
		txtRounds.setBounds(637, 577, 86, 20);
		pnlStart.add(txtRounds);
		txtRounds.setColumns(10);

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtRounds.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter amount of rounds!");
				} else {
					gameRounds = Integer.parseInt(txtRounds.getText());
					playerAmount = (Integer) comboBoxPlayerAmount.getSelectedItem();
					pnlStart.setVisible(false);
					pnlCreation.setVisible(true);
				}
			}
		});

		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnHelpSection.setVisible(true);
				lblNeoPets.setVisible(false);
				btnBack.setVisible(true);
				btnHelp.setVisible(false);
			}
		});

		JPanel pnlPet1 = new JPanel();
		pnlPet1.setBounds(644, 59, 590, 195);
		pnlCreation.add(pnlPet1);
		pnlPet1.setLayout(null);

		JLabel lblPet1 = new JLabel("Pet 1");
		lblPet1.setBounds(271, 11, 46, 14);
		pnlPet1.add(lblPet1);

		JLabel lblPet1Name = new JLabel("Pet Name");
		lblPet1Name.setBounds(10, 36, 58, 14);
		pnlPet1.add(lblPet1Name);

		txtPet1name = new JTextField();
		txtPet1name.setBounds(78, 33, 141, 20);
		pnlPet1.add(txtPet1name);
		txtPet1name.setColumns(10);

		JRadioButton rdbtnPet1Manatee = new JRadioButton("Manatee");
		rdbtnPet1Manatee.setSelected(true);
		rdbtnPet1Manatee.setToolTipText("Weight: 100 Damage: 4");
		rdbtnPet1Manatee.setBounds(10, 88, 81, 23);
		pnlPet1.add(rdbtnPet1Manatee);

		JRadioButton rdbtnPet1Dog = new JRadioButton("Dog");
		rdbtnPet1Dog.setToolTipText("Weight: 20 Damage: 16");
		rdbtnPet1Dog.setBounds(10, 114, 67, 23);
		pnlPet1.add(rdbtnPet1Dog);

		JRadioButton rdbtnPet1Budgie = new JRadioButton("Budgie");
		rdbtnPet1Budgie.setToolTipText("Weight: 1 Damage: 6");
		rdbtnPet1Budgie.setBounds(10, 140, 67, 23);
		pnlPet1.add(rdbtnPet1Budgie);

		JLabel lblPet1Species = new JLabel("Species");
		lblPet1Species.setBounds(10, 67, 46, 14);
		pnlPet1.add(lblPet1Species);

		JRadioButton rdbtnPet1Cat = new JRadioButton("Cat");
		rdbtnPet1Cat.setToolTipText("Weight: 15 Damage: 10");
		rdbtnPet1Cat.setBounds(93, 88, 67, 23);
		pnlPet1.add(rdbtnPet1Cat);

		JRadioButton rdbtnPet1Sloth = new JRadioButton("Sloth");
		rdbtnPet1Sloth.setToolTipText("Weight: 15 Damage: 18");
		rdbtnPet1Sloth.setBounds(93, 114, 67, 23);
		pnlPet1.add(rdbtnPet1Sloth);

		JRadioButton rdbtnPet1Rabbit = new JRadioButton("Rabbit");
		rdbtnPet1Rabbit.setToolTipText("Weight: 5 Damage: 10");
		rdbtnPet1Rabbit.setBounds(93, 140, 67, 23);
		pnlPet1.add(rdbtnPet1Rabbit);

		ButtonGroup pet1Species = new ButtonGroup();
		pet1Species.add(rdbtnPet1Manatee);
		pet1Species.add(rdbtnPet1Dog);
		pet1Species.add(rdbtnPet1Budgie);
		pet1Species.add(rdbtnPet1Cat);
		pet1Species.add(rdbtnPet1Sloth);
		pet1Species.add(rdbtnPet1Rabbit);

		JLabel lblPet1FavouriteFood = new JLabel("Favourite Food");
		lblPet1FavouriteFood.setBounds(254, 32, 88, 14);
		pnlPet1.add(lblPet1FavouriteFood);

		JRadioButton rdbtnPet1JellyMeat = new JRadioButton("Jelly Meat");
		rdbtnPet1JellyMeat.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet1JellyMeat.setSelected(true);
		rdbtnPet1JellyMeat.setBounds(254, 53, 109, 23);
		pnlPet1.add(rdbtnPet1JellyMeat);

		JRadioButton rdbtnPet1Grapes = new JRadioButton("Grapes");
		rdbtnPet1Grapes.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet1Grapes.setBounds(254, 79, 109, 23);
		pnlPet1.add(rdbtnPet1Grapes);

		JRadioButton rdbtnPet1Tacos = new JRadioButton("Tacos");
		rdbtnPet1Tacos.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet1Tacos.setBounds(254, 105, 109, 23);
		pnlPet1.add(rdbtnPet1Tacos);

		JRadioButton rdbtnPet1Soup = new JRadioButton("Soup");
		rdbtnPet1Soup.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet1Soup.setBounds(254, 131, 109, 23);
		pnlPet1.add(rdbtnPet1Soup);

		JRadioButton rdbtnPet1BagofSeeds = new JRadioButton("Bag of Seeds");
		rdbtnPet1BagofSeeds.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet1BagofSeeds.setBounds(254, 157, 109, 23);
		pnlPet1.add(rdbtnPet1BagofSeeds);

		ButtonGroup pet1Food = new ButtonGroup();
		pet1Food.add(rdbtnPet1JellyMeat);
		pet1Food.add(rdbtnPet1Grapes);
		pet1Food.add(rdbtnPet1Tacos);
		pet1Food.add(rdbtnPet1Soup);
		pet1Food.add(rdbtnPet1BagofSeeds);

		JLabel lblPet1FavouriteToy = new JLabel("Favourite Toy");
		lblPet1FavouriteToy.setBounds(418, 32, 93, 14);
		pnlPet1.add(lblPet1FavouriteToy);

		JRadioButton rdbtnPet1RedBall = new JRadioButton("Red Ball");
		rdbtnPet1RedBall.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet1RedBall.setSelected(true);
		rdbtnPet1RedBall.setBounds(418, 53, 109, 23);
		pnlPet1.add(rdbtnPet1RedBall);

		JRadioButton rdbtnPet1ShortRope = new JRadioButton("Short Rope");
		rdbtnPet1ShortRope.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet1ShortRope.setBounds(418, 79, 109, 23);
		pnlPet1.add(rdbtnPet1ShortRope);

		JRadioButton rdbtnPet1OldTeddyBear = new JRadioButton("Old Teddy Bear");
		rdbtnPet1OldTeddyBear.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet1OldTeddyBear.setBounds(418, 105, 126, 23);
		pnlPet1.add(rdbtnPet1OldTeddyBear);

		JRadioButton rdbtnPet1SoftDuck = new JRadioButton("Soft Duck");
		rdbtnPet1SoftDuck.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet1SoftDuck.setBounds(418, 131, 109, 23);
		pnlPet1.add(rdbtnPet1SoftDuck);

		JRadioButton rdbtnPet1SmallFrizbee = new JRadioButton("Small Frizbee");
		rdbtnPet1SmallFrizbee.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet1SmallFrizbee.setBounds(418, 157, 109, 23);
		pnlPet1.add(rdbtnPet1SmallFrizbee);

		ButtonGroup pet1Toy = new ButtonGroup();
		pet1Toy.add(rdbtnPet1RedBall);
		pet1Toy.add(rdbtnPet1ShortRope);
		pet1Toy.add(rdbtnPet1OldTeddyBear);
		pet1Toy.add(rdbtnPet1SoftDuck);
		pet1Toy.add(rdbtnPet1SmallFrizbee);

		JPanel pnlPet2 = new JPanel();
		pnlPet2.setVisible(false);
		pnlPet2.setLayout(null);
		pnlPet2.setBounds(10, 265, 590, 195);
		pnlCreation.add(pnlPet2);

		JLabel lblPet2 = new JLabel("Pet 2");
		lblPet2.setBounds(271, 11, 46, 14);
		pnlPet2.add(lblPet2);

		JLabel lblPet2Name = new JLabel("Pet Name");
		lblPet2Name.setBounds(10, 36, 58, 14);
		pnlPet2.add(lblPet2Name);

		txtPet2Name = new JTextField();
		txtPet2Name.setColumns(10);
		txtPet2Name.setBounds(78, 33, 141, 20);
		pnlPet2.add(txtPet2Name);

		JRadioButton rdbtnPet2Manatee = new JRadioButton("Manatee");
		rdbtnPet2Manatee.setToolTipText("Weight: 100 Damage: 4");
		rdbtnPet2Manatee.setSelected(true);
		rdbtnPet2Manatee.setBounds(10, 88, 81, 23);
		pnlPet2.add(rdbtnPet2Manatee);

		JRadioButton rdbtnPet2Dog = new JRadioButton("Dog");
		rdbtnPet2Dog.setToolTipText("Weight: 20 Damage: 16");
		rdbtnPet2Dog.setBounds(10, 114, 67, 23);
		pnlPet2.add(rdbtnPet2Dog);

		JRadioButton rdbtnPet2Budgie = new JRadioButton("Budgie");
		rdbtnPet2Budgie.setToolTipText("Weight: 1 Damage: 6");
		rdbtnPet2Budgie.setBounds(10, 140, 67, 23);
		pnlPet2.add(rdbtnPet2Budgie);

		JLabel lblPet2Species = new JLabel("Species");
		lblPet2Species.setBounds(10, 67, 46, 14);
		pnlPet2.add(lblPet2Species);

		JRadioButton rdbtnPet2Cat = new JRadioButton("Cat");
		rdbtnPet2Cat.setToolTipText("Weight: 15 Damage: 10");
		rdbtnPet2Cat.setBounds(93, 88, 67, 23);
		pnlPet2.add(rdbtnPet2Cat);

		JRadioButton rdbtnPet2Sloth = new JRadioButton("Sloth");
		rdbtnPet2Sloth.setToolTipText("Weight: 15 Damage: 18");
		rdbtnPet2Sloth.setBounds(93, 114, 67, 23);
		pnlPet2.add(rdbtnPet2Sloth);

		JRadioButton rdbtnPet2Rabbit = new JRadioButton("Rabbit");
		rdbtnPet2Rabbit.setToolTipText("Weight: 5 Damage: 10");
		rdbtnPet2Rabbit.setBounds(93, 140, 67, 23);
		pnlPet2.add(rdbtnPet2Rabbit);

		ButtonGroup pet2Species = new ButtonGroup();
		pet2Species.add(rdbtnPet2Manatee);
		pet2Species.add(rdbtnPet2Dog);
		pet2Species.add(rdbtnPet2Budgie);
		pet2Species.add(rdbtnPet2Cat);
		pet2Species.add(rdbtnPet2Sloth);
		pet2Species.add(rdbtnPet2Rabbit);

		JLabel lblPet2FavouriteFood = new JLabel("Favourite Food");
		lblPet2FavouriteFood.setBounds(254, 32, 88, 14);
		pnlPet2.add(lblPet2FavouriteFood);

		JRadioButton rdbtnPet2JellyMeat = new JRadioButton("Jelly Meat");
		rdbtnPet2JellyMeat.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet2JellyMeat.setSelected(true);
		rdbtnPet2JellyMeat.setBounds(254, 53, 109, 23);
		pnlPet2.add(rdbtnPet2JellyMeat);

		JRadioButton rdbtnPet2Grapes = new JRadioButton("Grapes");
		rdbtnPet2Grapes.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet2Grapes.setBounds(254, 79, 109, 23);
		pnlPet2.add(rdbtnPet2Grapes);

		JRadioButton rdbtnPet2Tacos = new JRadioButton("Tacos");
		rdbtnPet2Tacos.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet2Tacos.setBounds(254, 105, 109, 23);
		pnlPet2.add(rdbtnPet2Tacos);

		JRadioButton rdbtnPet2Soup = new JRadioButton("Soup");
		rdbtnPet2Soup.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet2Soup.setBounds(254, 131, 109, 23);
		pnlPet2.add(rdbtnPet2Soup);

		JRadioButton rdbtnPet2BagofSeeds = new JRadioButton("Bag of Seeds");
		rdbtnPet2BagofSeeds.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet2BagofSeeds.setBounds(254, 157, 109, 23);
		pnlPet2.add(rdbtnPet2BagofSeeds);

		ButtonGroup pet2Food = new ButtonGroup();
		pet2Food.add(rdbtnPet2JellyMeat);
		pet2Food.add(rdbtnPet2Grapes);
		pet2Food.add(rdbtnPet2Tacos);
		pet2Food.add(rdbtnPet2Soup);
		pet2Food.add(rdbtnPet2BagofSeeds);

		JLabel lblPet2FavouriteToy = new JLabel("Favourite Toy");
		lblPet2FavouriteToy.setBounds(418, 32, 93, 14);
		pnlPet2.add(lblPet2FavouriteToy);

		JRadioButton rdbtnPet2RedBall = new JRadioButton("Red Ball");
		rdbtnPet2RedBall.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet2RedBall.setSelected(true);
		rdbtnPet2RedBall.setBounds(418, 53, 109, 23);
		pnlPet2.add(rdbtnPet2RedBall);

		JRadioButton rdbtnPet2ShortRope = new JRadioButton("Short Rope");
		rdbtnPet2ShortRope.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet2ShortRope.setBounds(418, 79, 109, 23);
		pnlPet2.add(rdbtnPet2ShortRope);

		JRadioButton rdbtnPet2OldTeddyBear = new JRadioButton("Old Teddy Bear");
		rdbtnPet2OldTeddyBear.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet2OldTeddyBear.setBounds(418, 105, 125, 23);
		pnlPet2.add(rdbtnPet2OldTeddyBear);

		JRadioButton rdbtnPet2SoftDuck = new JRadioButton("Soft Duck");
		rdbtnPet2SoftDuck.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet2SoftDuck.setBounds(418, 131, 109, 23);
		pnlPet2.add(rdbtnPet2SoftDuck);

		JRadioButton rdbtnPet2SmallFrizbee = new JRadioButton("Small Frizbee");
		rdbtnPet2SmallFrizbee.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet2SmallFrizbee.setBounds(418, 157, 109, 23);
		pnlPet2.add(rdbtnPet2SmallFrizbee);

		ButtonGroup pet2Toy = new ButtonGroup();
		pet2Toy.add(rdbtnPet2RedBall);
		pet2Toy.add(rdbtnPet2ShortRope);
		pet2Toy.add(rdbtnPet2OldTeddyBear);
		pet2Toy.add(rdbtnPet2SoftDuck);
		pet2Toy.add(rdbtnPet2SmallFrizbee);

		JPanel pnlPet3 = new JPanel();
		pnlPet3.setVisible(false);
		pnlPet3.setLayout(null);
		pnlPet3.setBounds(644, 265, 590, 195);
		pnlCreation.add(pnlPet3);

		JLabel lblPet3 = new JLabel("Pet 3");
		lblPet3.setBounds(271, 11, 46, 14);
		pnlPet3.add(lblPet3);

		JLabel lblPet3Name = new JLabel("Pet Name");
		lblPet3Name.setBounds(10, 36, 58, 14);
		pnlPet3.add(lblPet3Name);

		txtPet3Name = new JTextField();
		txtPet3Name.setColumns(10);
		txtPet3Name.setBounds(78, 33, 141, 20);
		pnlPet3.add(txtPet3Name);

		JRadioButton rdbtnPet3Manatee = new JRadioButton("Manatee");
		rdbtnPet3Manatee.setToolTipText("Weight: 100 Damage: 4");
		rdbtnPet3Manatee.setSelected(true);
		rdbtnPet3Manatee.setBounds(10, 88, 81, 23);
		pnlPet3.add(rdbtnPet3Manatee);

		JRadioButton rdbtnPet3Dog = new JRadioButton("Dog");
		rdbtnPet3Dog.setToolTipText("Weight: 20 Damage: 16");
		rdbtnPet3Dog.setBounds(10, 114, 67, 23);
		pnlPet3.add(rdbtnPet3Dog);

		JRadioButton rdbtnPet3Budgie = new JRadioButton("Budgie");
		rdbtnPet3Budgie.setToolTipText("Weight: 1 Damage: 6");
		rdbtnPet3Budgie.setBounds(10, 140, 67, 23);
		pnlPet3.add(rdbtnPet3Budgie);

		JLabel lblPet3Species = new JLabel("Species");
		lblPet3Species.setBounds(10, 67, 46, 14);
		pnlPet3.add(lblPet3Species);

		JRadioButton rdbtnPet3Cat = new JRadioButton("Cat");
		rdbtnPet3Cat.setToolTipText("Weight: 15 Damage: 10");
		rdbtnPet3Cat.setBounds(93, 88, 67, 23);
		pnlPet3.add(rdbtnPet3Cat);

		JRadioButton rdbtnPet3Sloth = new JRadioButton("Sloth");
		rdbtnPet3Sloth.setToolTipText("Weight: 15 Damage: 18");
		rdbtnPet3Sloth.setBounds(93, 114, 67, 23);
		pnlPet3.add(rdbtnPet3Sloth);

		JRadioButton rdbtnPet3Rabbit = new JRadioButton("Rabbit");
		rdbtnPet3Rabbit.setToolTipText("Weight: 5 Damage: 10");
		rdbtnPet3Rabbit.setBounds(93, 140, 67, 23);
		pnlPet3.add(rdbtnPet3Rabbit);

		ButtonGroup pet3Species = new ButtonGroup();
		pet3Species.add(rdbtnPet3Manatee);
		pet3Species.add(rdbtnPet3Dog);
		pet3Species.add(rdbtnPet3Budgie);
		pet3Species.add(rdbtnPet3Cat);
		pet3Species.add(rdbtnPet3Sloth);
		pet3Species.add(rdbtnPet3Rabbit);

		JLabel lblPet3FavouriteFood = new JLabel("Favourite Food");
		lblPet3FavouriteFood.setBounds(254, 32, 88, 14);
		pnlPet3.add(lblPet3FavouriteFood);

		JRadioButton rdbtnPet3JellyMeat = new JRadioButton("Jelly Meat");
		rdbtnPet3JellyMeat.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet3JellyMeat.setSelected(true);
		rdbtnPet3JellyMeat.setBounds(254, 53, 109, 23);
		pnlPet3.add(rdbtnPet3JellyMeat);

		JRadioButton rdbtnPet3Grapes = new JRadioButton("Grapes");
		rdbtnPet3Grapes.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet3Grapes.setBounds(254, 79, 109, 23);
		pnlPet3.add(rdbtnPet3Grapes);

		JRadioButton rdbtnPet3Tacos = new JRadioButton("Tacos");
		rdbtnPet3Tacos.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet3Tacos.setBounds(254, 105, 109, 23);
		pnlPet3.add(rdbtnPet3Tacos);

		JRadioButton rdbtnPet3Soup = new JRadioButton("Soup");
		rdbtnPet3Soup.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet3Soup.setBounds(254, 131, 109, 23);
		pnlPet3.add(rdbtnPet3Soup);

		JRadioButton rdbtnPet3BagofSeeds = new JRadioButton("Bag of Seeds");
		rdbtnPet3BagofSeeds.setToolTipText("Price: $5 Nutrition: 10");
		rdbtnPet3BagofSeeds.setBounds(254, 157, 109, 23);
		pnlPet3.add(rdbtnPet3BagofSeeds);

		ButtonGroup pet3Food = new ButtonGroup();
		pet3Food.add(rdbtnPet3JellyMeat);
		pet3Food.add(rdbtnPet3Grapes);
		pet3Food.add(rdbtnPet3Tacos);
		pet3Food.add(rdbtnPet3Soup);
		pet3Food.add(rdbtnPet3BagofSeeds);

		JLabel lblPet3FavouriteToy = new JLabel("Favourite Toy");
		lblPet3FavouriteToy.setBounds(418, 32, 93, 14);
		pnlPet3.add(lblPet3FavouriteToy);

		JRadioButton rdbtnPet3RedBall = new JRadioButton("Red Ball");
		rdbtnPet3RedBall.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet3RedBall.setSelected(true);
		rdbtnPet3RedBall.setBounds(418, 53, 109, 23);
		pnlPet3.add(rdbtnPet3RedBall);

		JRadioButton rdbtnPet3ShortRope = new JRadioButton("Short Rope");
		rdbtnPet3ShortRope.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet3ShortRope.setBounds(418, 79, 109, 23);
		pnlPet3.add(rdbtnPet3ShortRope);

		JRadioButton rdbtnPet3OldTeddyBear = new JRadioButton("Old Teddy Bear");
		rdbtnPet3OldTeddyBear.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet3OldTeddyBear.setBounds(418, 105, 121, 23);
		pnlPet3.add(rdbtnPet3OldTeddyBear);

		JRadioButton rdbtnPet3SoftDuck = new JRadioButton("Soft Duck");
		rdbtnPet3SoftDuck.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet3SoftDuck.setBounds(418, 131, 109, 23);
		pnlPet3.add(rdbtnPet3SoftDuck);

		JRadioButton rdbtnPet3SmallFrizbee = new JRadioButton("Small Frizbee");
		rdbtnPet3SmallFrizbee.setToolTipText("Price: $5 Durability: 50");
		rdbtnPet3SmallFrizbee.setBounds(418, 157, 109, 23);
		pnlPet3.add(rdbtnPet3SmallFrizbee);

		ButtonGroup pet3Toy = new ButtonGroup();
		pet3Toy.add(rdbtnPet3RedBall);
		pet3Toy.add(rdbtnPet3ShortRope);
		pet3Toy.add(rdbtnPet3OldTeddyBear);
		pet3Toy.add(rdbtnPet3SoftDuck);
		pet3Toy.add(rdbtnPet3SmallFrizbee);

		JPanel pnlPlayer = new JPanel();
		pnlPlayer.setBounds(10, 59, 590, 195);
		pnlCreation.add(pnlPlayer);
		pnlPlayer.setLayout(null);

		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setBounds(10, 11, 81, 30);
		pnlPlayer.add(lblPlayerName);

		txtPlayerName = new JTextField();
		txtPlayerName.setBounds(123, 11, 204, 20);
		pnlPlayer.add(txtPlayerName);
		txtPlayerName.setColumns(10);

		JLabel lblHowManyPets = new JLabel("How Many Pets:");
		lblHowManyPets.setBounds(10, 52, 100, 14);
		pnlPlayer.add(lblHowManyPets);

		JRadioButton rdbtn1pet = new JRadioButton("1");
		rdbtn1pet.setSelected(true);
		rdbtn1pet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlPet1.setVisible(true);
				pnlPet2.setVisible(false);
				pnlPet3.setVisible(false);
			}
		});
		rdbtn1pet.setBounds(116, 43, 109, 23);
		pnlPlayer.add(rdbtn1pet);

		JRadioButton rdbtn2pet = new JRadioButton("2");
		rdbtn2pet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPet1.setVisible(true);
				pnlPet2.setVisible(true);
				pnlPet3.setVisible(false);
			}
		});
		rdbtn2pet.setBounds(116, 68, 109, 23);
		pnlPlayer.add(rdbtn2pet);

		JRadioButton rdbtn3pet = new JRadioButton("3");
		rdbtn3pet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPet1.setVisible(true);
				pnlPet2.setVisible(true);
				pnlPet3.setVisible(true);
			}
		});
		rdbtn3pet.setBounds(116, 94, 109, 23);
		pnlPlayer.add(rdbtn3pet);

		ButtonGroup petAmount = new ButtonGroup();
		petAmount.add(rdbtn1pet);
		petAmount.add(rdbtn2pet);
		petAmount.add(rdbtn3pet);

		JLabel lblPlayerCreation = new JLabel("Player Creation");
		lblPlayerCreation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayerCreation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerCreation.setBounds(543, 11, 151, 14);
		pnlCreation.add(lblPlayerCreation);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtn1pet.isSelected()
						&& (txtPlayerName.getText().equals("") || txtPet1name.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Please Enter all fields.");
				} else if (rdbtn2pet.isSelected() && (txtPlayerName.getText().equals("")
						|| txtPet1name.getText().equals("") || txtPet2Name.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Please Enter all fields.");
				} else if (rdbtn3pet.isSelected()
						&& (txtPlayerName.getText().equals("") || txtPet1name.getText().equals("")
								|| txtPet2Name.getText().equals("") || txtPet3Name.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Please Enter all fields.");
				} else if (checkValidName(playerList, txtPlayerName.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Please Enter a Unique Player Name.");
				} else if (rdbtn1pet.isSelected() == true && checkValidPetName(petCheckList, txtPet1name.getText(), "", "") == false){
					JOptionPane.showMessageDialog(null, "Please Enter a Unique Pet Name.");
				} else if (rdbtn2pet.isSelected() == true && checkValidPetName(petCheckList, txtPet1name.getText(), txtPet2Name.getText(), "") == false){
					JOptionPane.showMessageDialog(null, "Please Enter a Unique Pet Name.");
				} else if (rdbtn3pet.isSelected() == true && checkValidPetName(petCheckList, txtPet1name.getText(), txtPet2Name.getText(), txtPet3Name.getText()) == false){
					JOptionPane.showMessageDialog(null, "Please Enter a Unique Pet Name.");
				} else if (playerAmount != 1) {
					Player player1 = new Player();
					player1.setPlayerName(txtPlayerName.getText());
					Pet playerPet = new Pet();
					playerPet.setPetName(txtPet1name.getText());

					if (rdbtnPet1Manatee.isSelected()) {
						playerPet.setPetSpecies(petList.get(0));
					} else if (rdbtnPet1Dog.isSelected()) {
						playerPet.setPetSpecies(petList.get(1));
					} else if (rdbtnPet1Budgie.isSelected()) {
						playerPet.setPetSpecies(petList.get(2));
					} else if (rdbtnPet1Cat.isSelected()) {
						playerPet.setPetSpecies(petList.get(3));
					} else if (rdbtnPet1Sloth.isSelected()) {
						playerPet.setPetSpecies(petList.get(4));
					} else if (rdbtnPet1Rabbit.isSelected()) {
						playerPet.setPetSpecies(petList.get(5));
					}

					if (rdbtnPet1RedBall.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(0));
					} else if (rdbtnPet1ShortRope.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(1));
					} else if (rdbtnPet1OldTeddyBear.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(2));
					} else if (rdbtnPet1SoftDuck.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(3));
					} else if (rdbtnPet1SmallFrizbee.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(4));
					}

					if (rdbtnPet1JellyMeat.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(0));
					} else if (rdbtnPet1Grapes.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(1));
					} else if (rdbtnPet1Tacos.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(2));
					} else if (rdbtnPet1Soup.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(3));
					} else if (rdbtnPet1BagofSeeds.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(4));
					}
					player1.setPlayerPets(playerPet);
					player1.setPlayerFood(playerPet.getPetFavouriteFood());
					player1.setPlayerToys(playerPet.getPetFavouriteToy());
					petCheckList.add(txtPet1name.getText());
					if (rdbtn2pet.isSelected() || rdbtn3pet.isSelected()) {
						Pet playerPet2 = new Pet();
						playerPet2.setPetName(txtPet2Name.getText());

						if (rdbtnPet2Manatee.isSelected()) {
							playerPet2.setPetSpecies(petList.get(0));
						} else if (rdbtnPet2Dog.isSelected()) {
							playerPet2.setPetSpecies(petList.get(1));
						} else if (rdbtnPet2Budgie.isSelected()) {
							playerPet2.setPetSpecies(petList.get(2));
						} else if (rdbtnPet2Cat.isSelected()) {
							playerPet2.setPetSpecies(petList.get(3));
						} else if (rdbtnPet2Sloth.isSelected()) {
							playerPet2.setPetSpecies(petList.get(4));
						} else if (rdbtnPet2Rabbit.isSelected()) {
							playerPet2.setPetSpecies(petList.get(5));
						}

						if (rdbtnPet2RedBall.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(0));
						} else if (rdbtnPet2ShortRope.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(1));
						} else if (rdbtnPet2OldTeddyBear.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(2));
						} else if (rdbtnPet2SoftDuck.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(3));
						} else if (rdbtnPet2SmallFrizbee.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(4));
						}

						if (rdbtnPet2JellyMeat.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(0));
						} else if (rdbtnPet2Grapes.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(1));
						} else if (rdbtnPet2Tacos.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(2));
						} else if (rdbtnPet2Soup.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(3));
						} else if (rdbtnPet2BagofSeeds.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(4));
						}
						player1.setPlayerPets(playerPet2);
						player1.setPlayerFood(playerPet2.getPetFavouriteFood());
						player1.setPlayerToys(playerPet2.getPetFavouriteToy());
						petCheckList.add(txtPet2Name.getText());
					}

					if (rdbtn3pet.isSelected()) {
						Pet playerPet3 = new Pet();
						playerPet3.setPetName(txtPet3Name.getText());

						if (rdbtnPet3Manatee.isSelected()) {
							playerPet3.setPetSpecies(petList.get(0));
						} else if (rdbtnPet3Dog.isSelected()) {
							playerPet3.setPetSpecies(petList.get(1));
						} else if (rdbtnPet3Budgie.isSelected()) {
							playerPet3.setPetSpecies(petList.get(2));
						} else if (rdbtnPet3Cat.isSelected()) {
							playerPet3.setPetSpecies(petList.get(3));
						} else if (rdbtnPet3Sloth.isSelected()) {
							playerPet3.setPetSpecies(petList.get(4));
						} else if (rdbtnPet3Rabbit.isSelected()) {
							playerPet3.setPetSpecies(petList.get(5));
						}

						if (rdbtnPet3RedBall.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(0));
						} else if (rdbtnPet3ShortRope.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(1));
						} else if (rdbtnPet3OldTeddyBear.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(2));
						} else if (rdbtnPet3SoftDuck.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(3));
						} else if (rdbtnPet3SmallFrizbee.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(4));
						}

						if (rdbtnPet3JellyMeat.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(0));
						} else if (rdbtnPet3Grapes.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(1));
						} else if (rdbtnPet3Tacos.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(2));
						} else if (rdbtnPet3Soup.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(3));
						} else if (rdbtnPet3BagofSeeds.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(4));
						}
						player1.setPlayerPets(playerPet3);
						player1.setPlayerFood(playerPet3.getPetFavouriteFood());
						player1.setPlayerToys(playerPet3.getPetFavouriteToy());
						petCheckList.add(txtPet3Name.getText());
					}

					petAmount.clearSelection();
					txtPlayerName.setText(null);

					txtPet1name.setText(null);
					pet1Species.clearSelection();
					pet1Food.clearSelection();
					pet1Toy.clearSelection();
					txtPet2Name.setText(null);
					pet2Species.clearSelection();
					pet2Food.clearSelection();
					pet2Toy.clearSelection();
					txtPet3Name.setText(null);
					pet3Species.clearSelection();
					pet3Food.clearSelection();
					pet3Toy.clearSelection();

					playerList.add(player1);
					playerAmount -= 1;
					// set defaults
					rdbtn1pet.setSelected(true);
					rdbtnPet1Manatee.setSelected(true);
					rdbtnPet1JellyMeat.setSelected(true);
					rdbtnPet1RedBall.setSelected(true);
					rdbtnPet2Manatee.setSelected(true);
					rdbtnPet2JellyMeat.setSelected(true);
					rdbtnPet2RedBall.setSelected(true);
					rdbtnPet3Manatee.setSelected(true);
					rdbtnPet3JellyMeat.setSelected(true);
					rdbtnPet3RedBall.setSelected(true);

				} else {
					Player player1 = new Player();
					player1.setPlayerName(txtPlayerName.getText());
					Pet playerPet = new Pet();
					playerPet.setPetName(txtPet1name.getText());

					if (rdbtnPet1Manatee.isSelected()) {
						playerPet.setPetSpecies(petList.get(0));
					} else if (rdbtnPet1Dog.isSelected()) {
						playerPet.setPetSpecies(petList.get(1));
					} else if (rdbtnPet1Budgie.isSelected()) {
						playerPet.setPetSpecies(petList.get(2));
					} else if (rdbtnPet1Cat.isSelected()) {
						playerPet.setPetSpecies(petList.get(3));
					} else if (rdbtnPet1Sloth.isSelected()) {
						playerPet.setPetSpecies(petList.get(4));
					} else if (rdbtnPet1Rabbit.isSelected()) {
						playerPet.setPetSpecies(petList.get(5));
					}

					if (rdbtnPet1RedBall.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(0));
					} else if (rdbtnPet1ShortRope.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(1));
					} else if (rdbtnPet1OldTeddyBear.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(2));
					} else if (rdbtnPet1SoftDuck.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(3));
					} else if (rdbtnPet1SmallFrizbee.isSelected()) {
						playerPet.setPetFavouriteToy(toyList.get(4));
					}

					if (rdbtnPet1JellyMeat.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(0));
					} else if (rdbtnPet1Grapes.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(1));
					} else if (rdbtnPet1Tacos.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(2));
					} else if (rdbtnPet1Soup.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(3));
					} else if (rdbtnPet1BagofSeeds.isSelected()) {
						playerPet.setPetFavouriteFood(foodList.get(4));
					}
					player1.setPlayerPets(playerPet);
					player1.setPlayerFood(playerPet.getPetFavouriteFood());
					player1.setPlayerToys(playerPet.getPetFavouriteToy());

					if (rdbtn2pet.isSelected() || rdbtn3pet.isSelected()) {
						Pet playerPet2 = new Pet();
						playerPet2.setPetName(txtPet2Name.getText());

						if (rdbtnPet2Manatee.isSelected()) {
							playerPet2.setPetSpecies(petList.get(0));
						} else if (rdbtnPet2Dog.isSelected()) {
							playerPet2.setPetSpecies(petList.get(1));
						} else if (rdbtnPet2Budgie.isSelected()) {
							playerPet2.setPetSpecies(petList.get(2));
						} else if (rdbtnPet2Cat.isSelected()) {
							playerPet2.setPetSpecies(petList.get(3));
						} else if (rdbtnPet2Sloth.isSelected()) {
							playerPet2.setPetSpecies(petList.get(4));
						} else if (rdbtnPet2Rabbit.isSelected()) {
							playerPet2.setPetSpecies(petList.get(5));
						}

						if (rdbtnPet2RedBall.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(0));
						} else if (rdbtnPet2ShortRope.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(1));
						} else if (rdbtnPet2OldTeddyBear.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(2));
						} else if (rdbtnPet2SoftDuck.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(3));
						} else if (rdbtnPet2SmallFrizbee.isSelected()) {
							playerPet2.setPetFavouriteToy(toyList.get(4));
						}

						if (rdbtnPet2JellyMeat.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(0));
						} else if (rdbtnPet2Grapes.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(1));
						} else if (rdbtnPet2Tacos.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(2));
						} else if (rdbtnPet2Soup.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(3));
						} else if (rdbtnPet2BagofSeeds.isSelected()) {
							playerPet2.setPetFavouriteFood(foodList.get(4));
						}
						player1.setPlayerPets(playerPet2);
						player1.setPlayerFood(playerPet2.getPetFavouriteFood());
						player1.setPlayerToys(playerPet2.getPetFavouriteToy());
					}

					if (rdbtn3pet.isSelected()) {
						Pet playerPet3 = new Pet();
						playerPet3.setPetName(txtPet3Name.getText());

						if (rdbtnPet3Manatee.isSelected()) {
							playerPet3.setPetSpecies(petList.get(0));
						} else if (rdbtnPet3Dog.isSelected()) {
							playerPet3.setPetSpecies(petList.get(1));
						} else if (rdbtnPet3Budgie.isSelected()) {
							playerPet3.setPetSpecies(petList.get(2));
						} else if (rdbtnPet3Cat.isSelected()) {
							playerPet3.setPetSpecies(petList.get(3));
						} else if (rdbtnPet3Sloth.isSelected()) {
							playerPet3.setPetSpecies(petList.get(4));
						} else if (rdbtnPet3Rabbit.isSelected()) {
							playerPet3.setPetSpecies(petList.get(5));
						}

						if (rdbtnPet3RedBall.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(0));
						} else if (rdbtnPet3ShortRope.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(1));
						} else if (rdbtnPet3OldTeddyBear.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(2));
						} else if (rdbtnPet3SoftDuck.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(3));
						} else if (rdbtnPet3SmallFrizbee.isSelected()) {
							playerPet3.setPetFavouriteToy(toyList.get(4));
						}

						if (rdbtnPet3JellyMeat.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(0));
						} else if (rdbtnPet3Grapes.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(1));
						} else if (rdbtnPet3Tacos.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(2));
						} else if (rdbtnPet3Soup.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(3));
						} else if (rdbtnPet3BagofSeeds.isSelected()) {
							playerPet3.setPetFavouriteFood(foodList.get(4));
						}
						player1.setPlayerPets(playerPet3);
						player1.setPlayerFood(playerPet3.getPetFavouriteFood());
						player1.setPlayerToys(playerPet3.getPetFavouriteToy());
					}
					playerList.add(player1);
					GUIMain gui = new GUIMain();
					gui.setRounds(gameRounds);
					gui.setToyList(toyList);
					gui.setFoodList(foodList);
					gui.currentPlayer(playerList);
					gui.initialize();
					gui.frmPetSimulator.setVisible(true);
					frmcreation.dispose();
				}

			}

		});
		btnNext.setBounds(943, 519, 260, 106);
		pnlCreation.add(btnNext);
	}

	/**
	 * This Method is used to create a list of all types of species
	 * @return ArrayList<Species> The list of all species
	 */
	public ArrayList<Species> createSpecies() {
		// Create species and pets

		ArrayList<Species> petList = new ArrayList<Species>();
		petList.add(new Manatee());
		petList.add(new Dog());
		petList.add(new Budgie());
		petList.add(new Cat());
		petList.add(new Sloth());
		petList.add(new Rabbit());

		return petList;
	}

	
	/**
	 * This Method is used to create a list of all types of Toys
	 * @return ArrayList<Toys> The list of all Toys
	 */
	public ArrayList<Toys> createToys() {
		// create toys
		ArrayList<Toys> toyList = new ArrayList<Toys>();
		toyList.add(new RedBall());
		toyList.add(new ShortRope());
		toyList.add(new OldTeddy());
		toyList.add(new SoftDuck());
		toyList.add(new SmallFrizbee());

		toyList.add(new BigBall());
		toyList.add(new FluffyTeddy());
		toyList.add(new SqueakyDuck());
		toyList.add(new BigFrizbee());
		toyList.add(new LongRope());
		toyList.add(new MisbehavouringWhip());
		return toyList;
	}

	/**
	 * This Method is used to create a list of all types of Food
	 * @return ArrayList<Food> The list of all Foods
	 */
	public ArrayList<Food> createFood() {
		// create Foods
		ArrayList<Food> foodList = new ArrayList<Food>();
		foodList.add(new JellyMeat());
		foodList.add(new Grapes());
		foodList.add(new Tacos());
		foodList.add(new Soup());
		foodList.add(new Seed());

		foodList.add(new DryBiscuit());
		foodList.add(new Salmon());
		foodList.add(new Lasagna());
		foodList.add(new Steak());
		foodList.add(new Burrito());
		foodList.add(new SicknessCure());
		return foodList;
	}

	
	/**
	 * This method is used to check if pet names are duplicates and to return a boolean value stating if they are.
	 * @param petCheckList Array List of all pets already in game.
	 * @param pet1Name String Name of pet 1.
	 * @param pet2Name String Name of pet 2.
	 * @param pet3Name String Name of pet 3.
	 * @return Boolean stating if the pets have a duplicate name.
	 */
	public Boolean checkValidPetName(ArrayList<String> petCheckList, String pet1Name, String pet2Name,
			String pet3Name) {
		Boolean boolOutput = true;
		for (String i : petCheckList) {
			if (pet1Name.toLowerCase().equals(i.toLowerCase()) || pet2Name.toLowerCase().equals(i.toLowerCase()) || pet3Name.toLowerCase().equals(i.toLowerCase())) {
				boolOutput = false;
			}
		}
		if (pet1Name.toLowerCase().equals(pet2Name.toLowerCase()) || pet2Name.toLowerCase().equals(pet3Name.toLowerCase()) || pet1Name.toLowerCase().equals(pet3Name.toLowerCase())){
			if (pet2Name.equals("") == false || pet3Name.equals("") == false){
				boolOutput = false;
			}
		}
		return boolOutput;
	}

	
	/**
	 * This method is used to check if a player name is a duplicate and to return a boolean value stating if they are.
	 * @param playerList An Array List of all players currently in the game.
	 * @param inputName A String of the next player name to be added.
	 * @return Boolean stating if the player name is a duplicate name.
	 */
	public Boolean checkValidName(ArrayList<Player> playerList, String inputName) {
		Boolean boolOutput = true;
		Integer count = 0;
		for (Player i : playerList) {
			if (i.getPlayerName().toLowerCase().equals(inputName.toLowerCase())) {
				count = 1;
			}
		}
		if (count != 0) {
			boolOutput = false;
		}
		return boolOutput;
	}
}
