package GUI;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

import Game.Food;
import Game.Pet;
import Game.Player;
import Game.Toys;
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

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * The GUIMain class is for creating the main GUI of the game this includes all
 * of the features including store, inventory and pets and their actions.
 * <p>
 * The class defines all the elements of the main GUI frame. This includes the
 * Main frame, The GUIMain first starts out by defining the the frames and text
 * panes then goes on to define the labels The GUIMain uses a range of buttons
 * and check boxes to recieve user input and act of the player input The three
 * main frames are Pet which holds the pets actions and stats, Store which holds
 * the store and the player inventory and the Inventory which holds the
 * inventory At the end of each day all the labels and frames are updated with
 * the new infomation with either the next player or refreshed stats for the
 * same player
 * 
 * @author Jade Martin
 * @author Kyran Stagg
 *
 */
public class GUIMain {
	/**
	 * Represents all the players in a list.
	 */
	private ArrayList<Player> playerList;
	/**
	 * Represents all the toys in a list.
	 */
	private ArrayList<Toys> toyList;
	/**
	 * Represents all the foods in a list.
	 */
	private ArrayList<Food> foodList;
	/**
	 * Represents the current round for the game.
	 */
	private Integer rounds;
	/**
	 * Represents the frame for the main GUI the Pet simulator.
	 */
	JFrame frmPetSimulator;
	/**
	 * Represents the current players index in the player list.
	 */
	private Integer index = 0;
	/**
	 * Represents a counter.
	 */
	private Integer count = 1;
	/**
	 * Represents the total price for the store.
	 */
	private double totalPrice = 0;
	/**
	 * Represents pet 1 actions.
	 */
	private Integer pet1Action = 0;
	/**
	 * Represents pet 2 actions.
	 */
	private Integer pet2Action = 0;
	/**
	 * Represents pet 3 actions.
	 */
	private Integer pet3Action = 0;
	/**
	 * Represents the current pet being used for actions.
	 */
	private Pet currentPet;
	/**
	 * Represents the player list but is used for if a player gets knocked out
	 * of the game.
	 */
	private ArrayList<Player> playerListRounds;

	/**
	 * This method is used to set the player rounds.
	 * 
	 * @param playerInputint
	 *            Integer input that sets the rounds.
	 */
	public void setRounds(Integer playerInputint) {
		rounds = playerInputint;
	}

	/**
	 * This method is used to set the current player index
	 * 
	 * @param playerInputint
	 *            Integer input that sets the index.
	 */
	public void setIndex(Integer playerInputint) {
		index = playerInputint;
	}

	/**
	 * This method is used to set the counter.
	 * 
	 * @param playerInputint
	 *            Integer input that sets the count.
	 */
	public void setCount(Integer playerInputint) {
		count = playerInputint;
	}

	/**
	 * This method is used to set the playerList.
	 * 
	 * @param playerInputList
	 *            ArrayList<Player> Array input with players that sets the
	 *            player list.
	 */
	public void currentPlayer(ArrayList<Player> playerInputList) {
		playerList = playerInputList;
	}

	/**
	 * This method is used to set the toys list.
	 * 
	 * @param toyListInput
	 *            ArrayList<Toy> Array input with players that sets the toys
	 *            list.
	 */
	public void setToyList(ArrayList<Toys> toyListInput) {
		toyList = toyListInput;
	}

	/**
	 * This method is used to set the food list.
	 * 
	 * @param foodListInput
	 *            ArrayList<Food> Array input with players that sets the food
	 *            list.
	 */
	public void setFoodList(ArrayList<Food> foodListInput) {
		foodList = foodListInput;
	}

	/**
	 * Initialize the contents of the frame. This method does not return
	 * anything and initializes everything. This method is also used to check
	 * and keep track of player input and actions. The main frames are pet,
	 * inventory and store.
	 * 
	 */
	public void initialize() {
		rounds = (rounds * playerList.size());
		playerListRounds = new ArrayList<Player>(playerList);
		currentPet = playerList.get(index).getPlayerPets().get(0);
		frmPetSimulator = new JFrame();
		frmPetSimulator.setTitle("Pet Simulator");
		frmPetSimulator.setBounds(100, 100, 1280, 720);
		frmPetSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetSimulator.getContentPane().setLayout(null);

		ArrayList<String> petStrings = new ArrayList<String>();
		for (Pet i : playerList.get(index).getPlayerPets()) {
			petStrings.add(i.getPetName());
		}

		JPanel pnlStore = new JPanel();
		pnlStore.setVisible(false);

		JPanel pnlInventory = new JPanel();
		pnlInventory.setVisible(false);

		JPanel pnlGameOver = new JPanel();
		pnlGameOver.setVisible(false);
		pnlGameOver.setBounds(0, 0, 1264, 681);
		frmPetSimulator.getContentPane().add(pnlGameOver);
		pnlGameOver.setLayout(null);

		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setBounds(505, 29, 185, 59);
		pnlGameOver.add(lblGameOver);

		JTextPane txtpnScores = new JTextPane();
		txtpnScores.setEditable(false);
		txtpnScores.setText("Scores");
		txtpnScores.setBounds(285, 105, 712, 332);
		pnlGameOver.add(txtpnScores);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			/**
			 * Method closes the game.
			 */
			public void actionPerformed(ActionEvent arg0) {
				frmPetSimulator.dispose();
			}
		});
		btnQuit.setBounds(32, 535, 197, 118);
		pnlGameOver.add(btnQuit);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			/**
			 * method creates a new game.
			 */
			public void actionPerformed(ActionEvent e) {
				GUICreation.main(null);
				frmPetSimulator.dispose();
			}
		});
		btnNewGame.setBounds(1036, 535, 197, 118);
		pnlGameOver.add(btnNewGame);

		JTextPane txtpnToys = new JTextPane();
		txtpnToys.setText("Display Toys");
		txtpnToys.setEditable(false);
		txtpnToys.setBackground(SystemColor.menu);
		txtpnToys.setBounds(20, 120, 500, 412);

		JTextPane txtpnFood = new JTextPane();
		txtpnFood.setText("Display Food");
		txtpnFood.setEditable(false);
		txtpnFood.setBackground(SystemColor.menu);
		txtpnFood.setBounds(530, 120, 494, 412);

		JTextPane txtpnInventoryToys = new JTextPane();
		txtpnInventoryToys.setText("Player Toys:");
		txtpnInventoryToys.setEditable(false);
		txtpnInventoryToys.setBackground(SystemColor.menu);
		txtpnInventoryToys.setBounds(10, 109, 385, 188);

		JTextPane txtpnPlayerFood = new JTextPane();
		txtpnPlayerFood.setText("Player Food:");
		txtpnPlayerFood.setEditable(false);
		txtpnPlayerFood.setBackground(SystemColor.menu);
		txtpnPlayerFood.setBounds(10, 295, 385, 188);

		JPanel pnlPetInfo = new JPanel();

		pnlPetInfo.setBounds(10, 11, 1034, 543);
		frmPetSimulator.getContentPane().add(pnlPetInfo);
		pnlPetInfo.setLayout(null);

		JLabel lblPetDead = new JLabel("Pet Dead");
		lblPetDead.setVisible(false);
		lblPetDead.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPetDead.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetDead.setBounds(352, 197, 269, 64);
		pnlPetInfo.add(lblPetDead);

		JLabel lblEnergyVar = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetHealth().toString());
		lblEnergyVar.setBounds(143, 347, 123, 14);
		pnlPetInfo.add(lblEnergyVar);

		JLabel lblHealthVar = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetHealth().toString());
		lblHealthVar.setBounds(143, 322, 123, 14);
		pnlPetInfo.add(lblHealthVar);

		JLabel lblPetName = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetName());
		lblPetName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPetName.setBounds(10, 0, 914, 61);
		pnlPetInfo.add(lblPetName);

		JLabel lblPetSpecies = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetSpecies());
		lblPetSpecies.setBounds(143, 72, 123, 14);
		pnlPetInfo.add(lblPetSpecies);

		JLabel lblFavFood = new JLabel(
				playerList.get(index).getPlayerPets().get(0).getPetFavouriteFood().getFoodName());
		lblFavFood.setBounds(143, 97, 123, 14);
		pnlPetInfo.add(lblFavFood);

		JLabel lblFavToy = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetFavouriteToy().getToyName());
		lblFavToy.setBounds(143, 122, 123, 14);
		pnlPetInfo.add(lblFavToy);

		JLabel lblWeight = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetWeight().toString());
		lblWeight.setBounds(143, 147, 123, 14);
		pnlPetInfo.add(lblWeight);

		JLabel lblDamage = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetDamage().toString());
		lblDamage.setBounds(143, 172, 123, 14);
		pnlPetInfo.add(lblDamage);

		JLabel lblHunger = new JLabel(Double.toString(playerList.get(index).getPlayerPets().get(0).getPetHunger()));
		lblHunger.setBounds(143, 197, 123, 14);
		pnlPetInfo.add(lblHunger);

		JLabel lblSickness = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetSickness().toString());
		lblSickness.setBounds(143, 222, 123, 14);
		pnlPetInfo.add(lblSickness);

		JLabel lblMisbehaving = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetMisbehaving().toString());
		lblMisbehaving.setBounds(143, 247, 123, 14);
		pnlPetInfo.add(lblMisbehaving);

		JLabel lblTiredness = new JLabel(
				Double.toString(playerList.get(index).getPlayerPets().get(0).getPetTiredness()));
		lblTiredness.setBounds(143, 272, 123, 14);
		pnlPetInfo.add(lblTiredness);

		JLabel lblToiletVar = new JLabel(playerList.get(index).getPlayerPets().get(0).getPetToiletLevel().toString());
		lblToiletVar.setBounds(143, 297, 123, 14);
		pnlPetInfo.add(lblToiletVar);

		JLabel lblSpecies_1 = new JLabel("Species");
		lblSpecies_1.setBounds(10, 72, 46, 14);
		pnlPetInfo.add(lblSpecies_1);

		JLabel lblFavfood = new JLabel("FavFood");
		lblFavfood.setBounds(10, 97, 46, 14);
		pnlPetInfo.add(lblFavfood);

		JLabel lblFavtoy = new JLabel("FavToy");
		lblFavtoy.setBounds(10, 122, 46, 14);
		pnlPetInfo.add(lblFavtoy);

		JLabel lblWeight_1 = new JLabel("Weight");
		lblWeight_1.setBounds(10, 147, 46, 14);
		pnlPetInfo.add(lblWeight_1);

		JLabel lblDamage_1 = new JLabel("Damage");
		lblDamage_1.setBounds(10, 172, 63, 14);
		pnlPetInfo.add(lblDamage_1);

		JLabel lblHunger_1 = new JLabel("Hunger");
		lblHunger_1.setBounds(10, 197, 46, 14);
		pnlPetInfo.add(lblHunger_1);

		JLabel lblSickness_1 = new JLabel("Sickness");
		lblSickness_1.setBounds(10, 222, 63, 14);
		pnlPetInfo.add(lblSickness_1);

		JLabel lblMisbehaving_1 = new JLabel("Misbehaving");
		lblMisbehaving_1.setBounds(10, 247, 75, 14);
		pnlPetInfo.add(lblMisbehaving_1);

		JLabel lblTiredness_1 = new JLabel("Tiredness");
		lblTiredness_1.setBounds(10, 272, 63, 14);
		pnlPetInfo.add(lblTiredness_1);

		JLabel lblToiletLevel_1 = new JLabel("Toilet Level");
		lblToiletLevel_1.setBounds(10, 297, 75, 14);
		pnlPetInfo.add(lblToiletLevel_1);

		JButton btnSleepPet = new JButton("Sleep Pet");
		btnSleepPet.addActionListener(new ActionListener() {
			/**
			 * Method is used to put pet to sleep and restore tiredness.
			 */
			public void actionPerformed(ActionEvent e) {
				Integer currentAction = 0;
				if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
					currentAction = pet1Action;
				} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
					currentAction = pet2Action;
				} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
					currentAction = pet3Action;
				}

				if (currentAction == 2) {
					JOptionPane.showMessageDialog(null, "No actions for pet currently available.");
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int confimationOption = JOptionPane.showConfirmDialog(null, "Sleep Pet?", "Confirm", dialogButton);
					if (confimationOption == 0) {
						if (currentPet.getPetMisbehaving() == true && (Math.round(Math.random() * 1) == 1)) {
							JOptionPane.showMessageDialog(null, "Pet is Misbehaving and refuses to follow your action");
							if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
								pet1Action = pet1Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
								pet2Action = pet2Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
								pet3Action = pet3Action + 1;
							}
						} else {
							currentPet.sleep();
							lblTiredness.setText(Double.toString(currentPet.getPetTiredness()));
							if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
								pet1Action = pet1Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
								pet2Action = pet2Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
								pet3Action = pet3Action + 1;
							}
						}
					}
				}

			}
		});
		btnSleepPet.setBounds(10, 458, 256, 23);
		pnlPetInfo.add(btnSleepPet);

		JButton btnGoToilet = new JButton("Go Toilet");
		btnGoToilet.addActionListener(new ActionListener() {
			/**
			 * Method is used for the pet to go toilet.
			 */
			public void actionPerformed(ActionEvent e) {
				Integer currentAction = 0;
				if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
					currentAction = pet1Action;
				} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
					currentAction = pet2Action;
				} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
					currentAction = pet3Action;
				}

				if (currentAction == 2) {
					JOptionPane.showMessageDialog(null, "No actions for pet currently available.");
				} else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int confimationOption = JOptionPane.showConfirmDialog(null, "Make Pet Go Toilet?", "Confirm",
							dialogButton);
					if (confimationOption == 0) {
						if (currentPet.getPetMisbehaving() == true && (Math.round(Math.random() * 1) == 1)) {
							JOptionPane.showMessageDialog(null, "Pet is Misbehaving and refuses to follow your action");
							if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
								pet1Action = pet1Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
								pet2Action = pet2Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
								pet3Action = pet3Action + 1;
							}
						} else {
							currentPet.bathroom();
							lblToiletVar.setText(currentPet.getPetToiletLevel().toString());
							lblWeight.setText(currentPet.getPetWeight().toString());
							if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
								pet1Action = pet1Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
								pet2Action = pet2Action + 1;
							} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
								pet3Action = pet3Action + 1;
							}
						}
					}
				}
			}
		});
		btnGoToilet.setBounds(276, 458, 256, 23);
		pnlPetInfo.add(btnGoToilet);

		JButton btnPlayWithToy = new JButton("Play with Toy");
		btnPlayWithToy.addActionListener(new ActionListener() {
			/**
			 * Method is used for the pet to play with a toy.
			 */
			public void actionPerformed(ActionEvent e) {
				Integer currentAction = 0;
				if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
					currentAction = pet1Action;
				} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
					currentAction = pet2Action;
				} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
					currentAction = pet3Action;
				}

				if (currentAction == 2) {
					JOptionPane.showMessageDialog(null, "No actions for pet currently available.");
				} else {
					ArrayList<String> toysArrayList = new ArrayList<String>();
					if (playerList.get(index).getPlayerToys().size() == 0) {
						JOptionPane.showMessageDialog(null, "No toys currently available.");
					} else {
						for (Toys i : playerList.get(index).getPlayerToys()) {
							toysArrayList.add(i.getToyName());
						}
						String[] toysStringList = toysArrayList.toArray(new String[toysArrayList.size()]);
						String toyUsed = (String) JOptionPane.showInputDialog(null, "Use which Toy?", "Confirm",
								JOptionPane.QUESTION_MESSAGE, null, toysStringList, toysStringList[0]);
						if (toyUsed != null) {
							if (playerList.get(index).getPlayerToys().size() == 1) {
								if (playerList.get(index).getPlayerToys().get(0)
										.getToyName() == "Whip to cure misbhavouring"
										&& (currentPet.getPetMisbehaving() == true)) {
									if (currentPet.getPetMisbehaving() == true
											&& (Math.round(Math.random() * 1) == 1)) {
										JOptionPane.showMessageDialog(null,
												"Pet is Misbehaving and refuses to follow your action");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									} else {
										currentPet.setPetMisbehaving(false);
										playerList.get(index)
												.removeInventoryToy(playerList.get(index).getPlayerToys().get(0));
										JOptionPane.showMessageDialog(null, "Pet is no longer misbehavouring.");
										lblMisbehaving.setText(currentPet.getPetMisbehaving().toString());
										String outputString = ("");
										txtpnInventoryToys.setText("");
										txtpnToys.setText("");
										for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
											outputString += playerList.get(index).getPlayerToys().get(i).getToyName()
													+ "\n";
										}
										txtpnInventoryToys.setText(outputString);
										txtpnToys.setText(outputString);
										outputString = ("");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									}
								} else if (playerList.get(index).getPlayerToys().get(0).getToyDurability() > currentPet
										.getPetDamage()) {
									if (currentPet.getPetMisbehaving() == true
											&& (Math.round(Math.random() * 1) == 1)) {
										JOptionPane.showMessageDialog(null,
												"Pet is Misbehaving and refuses to follow your action");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									} else {
										currentPet.play(playerList.get(index).getPlayerToys().get(0));
										playerList.get(index).getPlayerToys().get(0)
												.removeToyDurability(currentPet.getPetDamage());
										if (playerList.get(index).getPlayerToys().get(0).getToyDurability() == 0) {
											JOptionPane.showMessageDialog(null,
													"Pet was too rough and destroyed the toy");
											playerList.get(index)
													.removeInventoryToy(playerList.get(index).getPlayerToys().get(0));
										}
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									}
								} else if (playerList.get(index).getPlayerToys().get(0).getToyDurability() == currentPet
										.getPetDamage()) {
									if (currentPet.getPetMisbehaving() == true
											&& (Math.round(Math.random() * 1) == 1)) {
										JOptionPane.showMessageDialog(null,
												"Pet is Misbehaving and refuses to follow your action");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									} else {
										JOptionPane.showMessageDialog(null, "Pet was too rough and destroyed the toy");
										playerList.get(index)
												.removeInventoryToy(playerList.get(index).getPlayerToys().get(0));
										currentPet.play(playerList.get(index).getPlayerToys().get(0));
										String outputString = ("");
										txtpnInventoryToys.setText("");
										txtpnToys.setText("");
										for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
											outputString += playerList.get(index).getPlayerToys().get(i).getToyName()
													+ "\n";
										}
										txtpnInventoryToys.setText(outputString);
										txtpnToys.setText(outputString);
										outputString = ("");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									}
								} else {
									if (currentPet.getPetMisbehaving() == true
											&& (Math.round(Math.random() * 1) == 1)) {
										JOptionPane.showMessageDialog(null,
												"Pet is Misbehaving and refuses to follow your action");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									} else {
										JOptionPane.showMessageDialog(null,
												"Toy was broken and shattered into nothing");
										playerList.get(index)
												.removeInventoryToy(playerList.get(index).getPlayerToys().get(0));
										String outputString = ("");
										txtpnInventoryToys.setText("");
										txtpnToys.setText("");
										for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
											outputString += playerList.get(index).getPlayerToys().get(i).getToyName()
													+ "\n";
										}
										txtpnInventoryToys.setText(outputString);
										txtpnToys.setText(outputString);
										outputString = ("");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									}
								}
							} else {
								ArrayList<Toys> toyList1 = new ArrayList<Toys>(playerList.get(index).getPlayerToys());
								for (Toys useToyOption : toyList1) {
									if (toyUsed == useToyOption.getToyName()) {
										if (useToyOption.getToyName() == "Whip to cure misbhavouring"
												&& (currentPet.getPetMisbehaving() == true)) {
											if (currentPet.getPetMisbehaving() == true
													&& (Math.round(Math.random() * 1) == 1)) {
												JOptionPane.showMessageDialog(null,
														"Pet is Misbehaving and refuses to follow your action");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											} else {
												currentPet.setPetMisbehaving(false);
												playerList.get(index).removeInventoryToy(useToyOption);
												JOptionPane.showMessageDialog(null, "Pet is no longer misbehavouring.");
												lblMisbehaving.setText(currentPet.getPetMisbehaving().toString());
												String outputString = ("");
												txtpnInventoryToys.setText("");
												txtpnToys.setText("");
												for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
													outputString += playerList.get(index).getPlayerToys().get(i)
															.getToyName() + "\n";
												}
												txtpnInventoryToys.setText(outputString);
												txtpnToys.setText(outputString);
												outputString = ("");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											}
										} else if (useToyOption.getToyDurability() > currentPet.getPetDamage()) {
											if (currentPet.getPetMisbehaving() == true
													&& (Math.round(Math.random() * 1) == 1)) {
												JOptionPane.showMessageDialog(null,
														"Pet is Misbehaving and refuses to follow your action");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											} else {
												currentPet.play(useToyOption);
												useToyOption.removeToyDurability(currentPet.getPetDamage());
												if (useToyOption.getToyDurability() == 0) {
													JOptionPane.showMessageDialog(null,
															"Pet was too rough and destroyed the toy");
													playerList.get(index).removeInventoryToy(useToyOption);
												}
												lblEnergyVar.setText(currentPet.getPetPlayfullness().toString());
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											}
										} else if (useToyOption.getToyDurability() > currentPet.getPetDamage()) {
											if (currentPet.getPetMisbehaving() == true
													&& (Math.round(Math.random() * 1) == 1)) {
												JOptionPane.showMessageDialog(null,
														"Pet is Misbehaving and refuses to follow your action");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											} else {
												JOptionPane.showMessageDialog(null,
														"Pet was too rough and destroyed the toy");
												playerList.get(index).removeInventoryToy(useToyOption);
												currentPet.play(useToyOption);
												String outputString = ("");
												txtpnInventoryToys.setText("");
												txtpnToys.setText("");
												for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
													outputString += playerList.get(index).getPlayerToys().get(i)
															.getToyName() + "\n";
												}
												txtpnInventoryToys.setText(outputString);
												txtpnToys.setText(outputString);
												outputString = ("");
												lblEnergyVar.setText(currentPet.getPetPlayfullness().toString());
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											}
										} else {
											if (currentPet.getPetMisbehaving() == true
													&& (Math.round(Math.random() * 1) == 1)) {
												JOptionPane.showMessageDialog(null,
														"Pet is Misbehaving and refuses to follow your action");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											} else {
												JOptionPane.showMessageDialog(null,
														"Toy was broken and shattered into nothing");
												playerList.get(index).removeInventoryToy(useToyOption);
												String outputString = ("");
												txtpnInventoryToys.setText("");
												txtpnToys.setText("");
												for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
													outputString += playerList.get(index).getPlayerToys().get(i)
															.getToyName() + "\n";
												}
												txtpnInventoryToys.setText(outputString);
												txtpnToys.setText(outputString);
												outputString = ("");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											}
										}

									}
								}
							}
						}
					}
				}
			}
		});
		btnPlayWithToy.setBounds(276, 424, 256, 23);
		pnlPetInfo.add(btnPlayWithToy);

		JButton btnFeedPet = new JButton("Feed Pet");
		btnFeedPet.addActionListener(new ActionListener() {
			/**
			 * Method is used for the pet to have a stack.
			 */
			public void actionPerformed(ActionEvent e) {
				Integer currentAction = 0;
				if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
					currentAction = pet1Action;
				} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
					currentAction = pet2Action;
				} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
					currentAction = pet3Action;
				}

				if (currentAction == 2) {
					JOptionPane.showMessageDialog(null, "No actions for pet currently available.");
				} else {
					ArrayList<String> foodArrayList = new ArrayList<String>();
					if (playerList.get(index).getPlayerFood().size() == 0) {
						JOptionPane.showMessageDialog(null, "No food currently available.");
					} else {
						for (Food i : playerList.get(index).getPlayerFood()) {
							foodArrayList.add(i.getFoodName());
						}
						String[] foodStringList = foodArrayList.toArray(new String[foodArrayList.size()]);
						String foodUsed = (String) JOptionPane.showInputDialog(null, "Which Food To Feed?", "Confirm",
								JOptionPane.QUESTION_MESSAGE, null, foodStringList, foodStringList[0]);
						if (foodUsed != null) {
							if (playerList.get(index).getPlayerFood().size() == 1) {
								if (playerList.get(index).getPlayerFood().get(0).getFoodName() == "Sickness Potion"
										&& (currentPet.getPetSickness() == true)) {
									if (currentPet.getPetMisbehaving() == true
											&& (Math.round(Math.random() * 1) == 1)) {
										JOptionPane.showMessageDialog(null,
												"Pet is Misbehaving and refuses to follow your action");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									} else {
										currentPet.setPetSickness(false);
										playerList.get(index)
												.removeInventoryFood(playerList.get(index).getPlayerFood().get(0));
										JOptionPane.showMessageDialog(null, "Pet is no longer sick");
										lblSickness.setText(currentPet.getPetSickness().toString());
										String outputString = ("");
										txtpnPlayerFood.setText("");
										txtpnFood.setText("");
										for (int i = 0; i < playerList.get(index).getPlayerFood().size(); i++) {
											outputString += playerList.get(index).getPlayerFood().get(i).getFoodName()
													+ " Food Nutrition: "
													+ playerList.get(index).getPlayerFood().get(i).getNutritionValue()
													+ "\n" + "\n";
										}
										txtpnPlayerFood.setText(outputString);
										txtpnFood.setText(outputString);
										outputString = ("");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}

									}
								} else {
									if (currentPet.getPetMisbehaving() == true
											&& (Math.round(Math.random() * 1) == 1)) {
										JOptionPane.showMessageDialog(null,
												"Pet is Misbehaving and refuses to follow your action");
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									} else {
										currentPet.feed(
												playerList.get(index).getPlayerFood().get(0).getNutritionValue(),
												playerList.get(index).getPlayerFood().get(0));
										playerList.get(index)
												.removeInventoryFood(playerList.get(index).getPlayerFood().get(0));
										String outputString = ("");
										txtpnPlayerFood.setText("");
										txtpnFood.setText("");
										for (int i = 0; i < playerList.get(index).getPlayerFood().size(); i++) {
											outputString += playerList.get(index).getPlayerFood().get(i).getFoodName()
													+ " Food Nutrition: "
													+ playerList.get(index).getPlayerFood().get(i).getNutritionValue()
													+ "\n" + "\n";
										}
										txtpnPlayerFood.setText(outputString);
										txtpnFood.setText(outputString);
										outputString = ("");
										lblHunger.setText(Double.toString(currentPet.getPetHunger()));
										lblToiletVar.setText(currentPet.getPetToiletLevel().toString());
										lblWeight.setText(currentPet.getPetWeight().toString());
										if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
											pet1Action = pet1Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
											pet2Action = pet2Action + 1;
										} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
											pet3Action = pet3Action + 1;
										}
									}
								}
							} else {
								ArrayList<Food> foodList1 = new ArrayList<Food>(playerList.get(index).getPlayerFood());
								for (Food useFoodOption : foodList1) {
									if (foodUsed == useFoodOption.getFoodName()) {
										if (useFoodOption.getFoodName() == "Sickness Potion"
												&& (currentPet.getPetSickness() == true)) {
											if (currentPet.getPetMisbehaving() == true
													&& (Math.round(Math.random() * 1) == 1)) {
												JOptionPane.showMessageDialog(null,
														"Pet is Misbehaving and refuses to follow your action");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											} else {
												currentPet.setPetSickness(false);
												playerList.get(index).removeInventoryFood(useFoodOption);
												String outputString = ("");
												txtpnPlayerFood.setText("");
												txtpnFood.setText("");
												for (int i = 0; i < playerList.get(index).getPlayerFood().size(); i++) {
													outputString += playerList.get(index).getPlayerFood().get(i)
															.getFoodName() + " Food Nutrition: "
															+ playerList.get(index).getPlayerFood().get(i)
																	.getNutritionValue()
															+ "\n" + "\n";
												}
												txtpnPlayerFood.setText(outputString);
												txtpnFood.setText(outputString);
												outputString = ("");
												JOptionPane.showMessageDialog(null, "Pet is no longer sick");
												lblSickness.setText(currentPet.getPetSickness().toString());
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											}
										} else {
											if (currentPet.getPetMisbehaving() == true
													&& (Math.round(Math.random() * 1) == 1)) {
												JOptionPane.showMessageDialog(null,
														"Pet is Misbehaving and refuses to follow your action");
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											} else {
												currentPet.feed(useFoodOption.getNutritionValue(), useFoodOption);
												playerList.get(index).removeInventoryFood(useFoodOption);
												String outputString = ("");
												txtpnPlayerFood.setText("");
												txtpnFood.setText("");
												for (int i = 0; i < playerList.get(index).getPlayerFood().size(); i++) {
													outputString += playerList.get(index).getPlayerFood().get(i)
															.getFoodName() + " Food Nutrition: "
															+ playerList.get(index).getPlayerFood().get(i)
																	.getNutritionValue()
															+ "\n" + "\n";
												}
												txtpnPlayerFood.setText(outputString);
												txtpnFood.setText(outputString);
												outputString = ("");
												lblHunger.setText(Double.toString(currentPet.getPetHunger()));
												lblToiletVar.setText(currentPet.getPetToiletLevel().toString());
												lblWeight.setText(currentPet.getPetWeight().toString());
												if (playerList.get(index).getPlayerPets().get(0) == currentPet) {
													pet1Action = pet1Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(1) == currentPet) {
													pet2Action = pet2Action + 1;
												} else if (playerList.get(index).getPlayerPets().get(2) == currentPet) {
													pet3Action = pet3Action + 1;
												}
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		btnFeedPet.setBounds(10, 424, 256, 23);
		pnlPetInfo.add(btnFeedPet);

		JLabel lblHealth_1 = new JLabel("Health");
		lblHealth_1.setBounds(10, 322, 75, 14);
		pnlPetInfo.add(lblHealth_1);

		JLabel lblEnergy_1 = new JLabel("Energy");
		lblEnergy_1.setBounds(10, 347, 75, 14);
		pnlPetInfo.add(lblEnergy_1);

		JButton btnRevive = new JButton("Revive");
		btnRevive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int confimationOption = JOptionPane.showConfirmDialog(null, "Use Revive Item?", "Confirm",
						dialogButton);
				if (currentPet.getRevived() == false && confimationOption == 0) {
					currentPet.revivePet();
					lblPetSpecies.setEnabled(true);
					lblFavFood.setEnabled(true);
					lblFavToy.setEnabled(true);
					lblWeight.setEnabled(true);
					lblDamage.setEnabled(true);
					lblHunger.setEnabled(true);
					lblSickness.setEnabled(true);
					lblMisbehaving.setEnabled(true);
					lblTiredness.setEnabled(true);
					lblToiletVar.setEnabled(true);
					lblHealthVar.setEnabled(true);
					lblEnergyVar.setEnabled(true);
					lblSpecies_1.setEnabled(true);
					lblFavfood.setEnabled(true);
					lblFavtoy.setEnabled(true);
					lblWeight_1.setEnabled(true);
					lblDamage_1.setEnabled(true);
					lblHunger_1.setEnabled(true);
					lblSickness_1.setEnabled(true);
					lblMisbehaving_1.setEnabled(true);
					lblTiredness_1.setEnabled(true);
					lblToiletLevel_1.setEnabled(true);
					lblHealth_1.setEnabled(true);
					lblEnergy_1.setEnabled(true);
					btnSleepPet.setEnabled(true);
					btnPlayWithToy.setEnabled(true);
					btnFeedPet.setEnabled(true);
					btnGoToilet.setEnabled(true);
					lblPetDead.setVisible(false);
					btnRevive.setEnabled(false);
					lblPetName.setText(currentPet.getPetName());
					lblPetSpecies.setText(currentPet.getPetSpecies());
					lblFavFood.setText(currentPet.getPetFavouriteFood().getFoodName());
					lblFavToy.setText(currentPet.getPetFavouriteToy().getToyName());
					lblWeight.setText(currentPet.getPetWeight().toString());
					lblDamage.setText(currentPet.getPetDamage().toString());
					lblHunger.setText(Double.toString(currentPet.getPetHunger()));
					lblSickness.setText(currentPet.getPetSickness().toString());
					lblMisbehaving.setText(currentPet.getPetMisbehaving().toString());
					lblTiredness.setText(Double.toString(currentPet.getPetTiredness()));
					lblToiletVar.setText(currentPet.getPetToiletLevel().toString());
					lblHealthVar.setText(currentPet.getPetHealth().toString());
					lblEnergyVar.setText(currentPet.getPetPlayfullness().toString());
				} else {
					JOptionPane.showMessageDialog(null,
							"Pet has already been revived once and cannot be revived again.");
				}
			}
		});
		btnRevive.setEnabled(false);
		btnRevive.setBounds(542, 424, 256, 23);
		pnlPetInfo.add(btnRevive);

		JComboBox<Object> comboBox = new JComboBox<Object>(petStrings.toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int isSelected = comboBox.getSelectedIndex();
				currentPet = playerList.get(index).getPlayerPets().get(isSelected);
				lblPetName.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetName());
				lblPetSpecies.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetSpecies());
				lblFavFood.setText(
						playerList.get(index).getPlayerPets().get(isSelected).getPetFavouriteFood().getFoodName());
				lblFavToy.setText(
						playerList.get(index).getPlayerPets().get(isSelected).getPetFavouriteToy().getToyName());
				lblWeight.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetWeight().toString());
				lblDamage.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetDamage().toString());
				lblHunger
						.setText(Double.toString(playerList.get(index).getPlayerPets().get(isSelected).getPetHunger()));
				lblSickness.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetSickness().toString());
				lblMisbehaving
						.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetMisbehaving().toString());
				lblTiredness.setText(
						Double.toString(playerList.get(index).getPlayerPets().get(isSelected).getPetTiredness()));
				lblToiletVar
						.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetToiletLevel().toString());
				lblHealthVar.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetHealth().toString());
				lblEnergyVar
						.setText(playerList.get(index).getPlayerPets().get(isSelected).getPetPlayfullness().toString());
				if (playerList.get(index).getPlayerPets().get(isSelected).getPetDead() == false) {
					lblPetSpecies.setEnabled(true);
					lblFavFood.setEnabled(true);
					lblFavToy.setEnabled(true);
					lblWeight.setEnabled(true);
					lblDamage.setEnabled(true);
					lblHunger.setEnabled(true);
					lblSickness.setEnabled(true);
					lblMisbehaving.setEnabled(true);
					lblTiredness.setEnabled(true);
					lblToiletVar.setEnabled(true);
					lblHealthVar.setEnabled(true);
					lblEnergyVar.setEnabled(true);
					lblSpecies_1.setEnabled(true);
					lblFavfood.setEnabled(true);
					lblFavtoy.setEnabled(true);
					lblWeight_1.setEnabled(true);
					lblDamage_1.setEnabled(true);
					lblHunger_1.setEnabled(true);
					lblSickness_1.setEnabled(true);
					lblMisbehaving_1.setEnabled(true);
					lblTiredness_1.setEnabled(true);
					lblToiletLevel_1.setEnabled(true);
					lblHealth_1.setEnabled(true);
					lblEnergy_1.setEnabled(true);
					btnSleepPet.setEnabled(true);
					btnPlayWithToy.setEnabled(true);
					btnFeedPet.setEnabled(true);
					btnGoToilet.setEnabled(true);

					lblPetDead.setVisible(false);
					btnRevive.setEnabled(false);

				} else if (playerList.get(index).getPlayerPets().get(isSelected).getPetDead() == true) {
					lblPetSpecies.setEnabled(false);
					lblFavFood.setEnabled(false);
					lblFavToy.setEnabled(false);
					lblWeight.setEnabled(false);
					lblDamage.setEnabled(false);
					lblHunger.setEnabled(false);
					lblSickness.setEnabled(false);
					lblMisbehaving.setEnabled(false);
					lblTiredness.setEnabled(false);
					lblToiletVar.setEnabled(false);
					lblHealthVar.setEnabled(false);
					lblEnergyVar.setEnabled(false);
					lblSpecies_1.setEnabled(false);
					lblFavfood.setEnabled(false);
					lblFavtoy.setEnabled(false);
					lblWeight_1.setEnabled(false);
					lblDamage_1.setEnabled(false);
					lblHunger_1.setEnabled(false);
					lblSickness_1.setEnabled(false);
					lblMisbehaving_1.setEnabled(false);
					lblTiredness_1.setEnabled(false);
					lblToiletLevel_1.setEnabled(false);
					lblHealth_1.setEnabled(false);
					lblEnergy_1.setEnabled(false);
					btnSleepPet.setEnabled(false);
					btnPlayWithToy.setEnabled(false);
					btnFeedPet.setEnabled(false);
					btnGoToilet.setEnabled(false);

					lblPetDead.setVisible(true);
					btnRevive.setEnabled(true);
				}
			}
		});
		comboBox.setBounds(10, 512, 171, 20);
		pnlPetInfo.add(comboBox);

		btnRevive.setEnabled(false);
		btnRevive.setBounds(542, 424, 256, 23);
		pnlPetInfo.add(btnRevive);
		
		pnlInventory.setLayout(null);
		pnlInventory.setBounds(10, 11, 1034, 543);

		frmPetSimulator.getContentPane().add(pnlInventory);

		JLabel lblToysHeader = new JLabel("Player Toys");
		lblToysHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblToysHeader.setBounds(20, 70, 500, 26);
		pnlInventory.add(lblToysHeader);

		pnlInventory.add(txtpnToys);

		pnlInventory.add(txtpnFood);

		JLabel lblInventory = new JLabel("Player Inventory");
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblInventory.setBounds(10, 11, 1014, 48);
		pnlInventory.add(lblInventory);

		JLabel lblFoodHeader = new JLabel("Player Food");
		lblFoodHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFoodHeader.setBounds(530, 70, 500, 26);
		pnlInventory.add(lblFoodHeader);

		pnlStore.setBounds(10, 11, 1034, 543);
		frmPetSimulator.getContentPane().add(pnlStore);
		pnlStore.setLayout(null);

		JLabel lblTotalPrice = new JLabel("$" + String.valueOf(totalPrice));
		lblTotalPrice.setBounds(478, 491, 164, 41);
		pnlStore.add(lblTotalPrice);

		pnlStore.add(txtpnInventoryToys);

		pnlStore.add(txtpnPlayerFood);

		JLabel foodLabel = new JLabel();
		pnlStore.add(foodLabel);
		foodLabel.setText("Player Food:");
		foodLabel.setBackground(SystemColor.menu);
		foodLabel.setBounds(0, 60, 103, -60);

		JPanel pnlStoreItems = new JPanel();
		pnlStoreItems.setLayout(null);
		pnlStoreItems.setBounds(405, 109, 619, 374);
		pnlStore.add(pnlStoreItems);

		JPanel pnlStoreToys = new JPanel();
		pnlStoreToys.setBounds(6, 11, 303, 352);
		pnlStoreItems.add(pnlStoreToys);
		pnlStoreToys.setLayout(null);

		ArrayList<JCheckBox> checkBoxListToys = new ArrayList<JCheckBox>();

		JCheckBox checkboxRedBall = new JCheckBox("1");
		checkboxRedBall.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store.
			 */
			public void actionPerformed(ActionEvent arg0) {
				if (checkboxRedBall.isSelected() == true) {
					totalPrice += toyList.get(0).getToyPrice();
				} else if (checkboxRedBall.isSelected() == false) {
					totalPrice -= toyList.get(0).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		checkboxRedBall.setToolTipText("Price: $5 Durability: 50");
		checkboxRedBall.setBounds(6, 35, 291, 23);
		pnlStoreToys.add(checkboxRedBall);
		checkboxRedBall.setText(toyList.get(0).getToyName());
		checkBoxListToys.add(checkboxRedBall);

		JCheckBox chckbxShortRope = new JCheckBox("2");
		chckbxShortRope.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxShortRope.isSelected() == true) {
					totalPrice += toyList.get(1).getToyPrice();
				} else if (chckbxShortRope.isSelected() == false) {
					totalPrice -= toyList.get(1).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxShortRope.setToolTipText("Price: $5 Durability: 50");
		chckbxShortRope.setBounds(6, 61, 291, 23);
		pnlStoreToys.add(chckbxShortRope);
		chckbxShortRope.setText(toyList.get(1).getToyName());
		checkBoxListToys.add(chckbxShortRope);

		JCheckBox chckbxOldTeddy = new JCheckBox("3");
		chckbxOldTeddy.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxOldTeddy.isSelected() == true) {
					totalPrice += toyList.get(2).getToyPrice();
				} else if (chckbxOldTeddy.isSelected() == false) {
					totalPrice -= toyList.get(2).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxOldTeddy.setToolTipText("Price: $5 Durability: 50");
		chckbxOldTeddy.setBounds(6, 87, 291, 23);
		pnlStoreToys.add(chckbxOldTeddy);
		chckbxOldTeddy.setText(toyList.get(2).getToyName());
		checkBoxListToys.add(chckbxOldTeddy);

		JCheckBox chckbxSoftDuck = new JCheckBox("4");
		chckbxSoftDuck.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSoftDuck.isSelected() == true) {
					totalPrice += toyList.get(3).getToyPrice();
				} else if (chckbxSoftDuck.isSelected() == false) {
					totalPrice -= toyList.get(3).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSoftDuck.setToolTipText("Price: $5 Durability: 50");
		chckbxSoftDuck.setBounds(6, 113, 291, 23);
		pnlStoreToys.add(chckbxSoftDuck);
		chckbxSoftDuck.setText(toyList.get(3).getToyName());
		checkBoxListToys.add(chckbxSoftDuck);

		JCheckBox chckbxSmallFrizbee = new JCheckBox("5");
		chckbxSmallFrizbee.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSmallFrizbee.isSelected() == true) {
					totalPrice += toyList.get(4).getToyPrice();
				} else if (chckbxSmallFrizbee.isSelected() == false) {
					totalPrice -= toyList.get(4).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSmallFrizbee.setToolTipText("Price: $5 Durability: 50");
		chckbxSmallFrizbee.setBounds(6, 139, 291, 23);
		pnlStoreToys.add(chckbxSmallFrizbee);
		chckbxSmallFrizbee.setText(toyList.get(4).getToyName());
		checkBoxListToys.add(chckbxSmallFrizbee);

		JCheckBox chckbxBigBlueBall = new JCheckBox("6");
		chckbxBigBlueBall.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxBigBlueBall.isSelected() == true) {
					totalPrice += toyList.get(5).getToyPrice();
				} else if (chckbxBigBlueBall.isSelected() == false) {
					totalPrice -= toyList.get(5).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxBigBlueBall.setToolTipText("Price: $10 Durability: 100");
		chckbxBigBlueBall.setBounds(6, 165, 291, 23);
		pnlStoreToys.add(chckbxBigBlueBall);
		chckbxBigBlueBall.setText(toyList.get(5).getToyName());
		checkBoxListToys.add(chckbxBigBlueBall);

		JCheckBox chckbxFluffyTeddy = new JCheckBox("7");
		chckbxFluffyTeddy.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxFluffyTeddy.isSelected() == true) {
					totalPrice += toyList.get(6).getToyPrice();
				} else if (chckbxFluffyTeddy.isSelected() == false) {
					totalPrice -= toyList.get(6).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxFluffyTeddy.setToolTipText("Price: $10 Durability: 100");
		chckbxFluffyTeddy.setBounds(6, 191, 291, 23);
		pnlStoreToys.add(chckbxFluffyTeddy);
		chckbxFluffyTeddy.setText(toyList.get(6).getToyName());
		checkBoxListToys.add(chckbxFluffyTeddy);

		JCheckBox chckbxSqueakyDuck = new JCheckBox("8");
		chckbxSqueakyDuck.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSqueakyDuck.isSelected() == true) {
					totalPrice += toyList.get(7).getToyPrice();
				} else if (chckbxSqueakyDuck.isSelected() == false) {
					totalPrice -= toyList.get(7).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSqueakyDuck.setToolTipText("Price: $10 Durability: 100");
		chckbxSqueakyDuck.setBounds(6, 217, 291, 23);
		pnlStoreToys.add(chckbxSqueakyDuck);
		chckbxSqueakyDuck.setText(toyList.get(7).getToyName());
		checkBoxListToys.add(chckbxSqueakyDuck);

		JCheckBox chckbxBigFrizbee = new JCheckBox("9");
		chckbxBigFrizbee.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxBigFrizbee.isSelected() == true) {
					totalPrice += toyList.get(8).getToyPrice();
				} else if (chckbxBigFrizbee.isSelected() == false) {
					totalPrice -= toyList.get(8).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxBigFrizbee.setToolTipText("Price: $10 Durability: 100");
		chckbxBigFrizbee.setBounds(6, 243, 291, 23);
		pnlStoreToys.add(chckbxBigFrizbee);
		chckbxBigFrizbee.setText(toyList.get(8).getToyName());
		checkBoxListToys.add(chckbxBigFrizbee);

		JCheckBox chckbxLongRope = new JCheckBox("10");
		chckbxLongRope.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxLongRope.isSelected() == true) {
					totalPrice += toyList.get(9).getToyPrice();
				} else if (chckbxLongRope.isSelected() == false) {
					totalPrice -= toyList.get(9).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxLongRope.setToolTipText("Price: $10 Durability: 100");
		chckbxLongRope.setBounds(6, 269, 291, 23);
		pnlStoreToys.add(chckbxLongRope);
		chckbxLongRope.setText(toyList.get(9).getToyName());
		checkBoxListToys.add(chckbxLongRope);

		JCheckBox chckbxMisbehavingWhip = new JCheckBox("11");
		chckbxMisbehavingWhip.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxMisbehavingWhip.isSelected() == true) {
					totalPrice += toyList.get(10).getToyPrice();
				} else if (chckbxMisbehavingWhip.isSelected() == false) {
					totalPrice -= toyList.get(10).getToyPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxMisbehavingWhip.setToolTipText("Price: $100 Cures Misbehaving, One Time Use");
		chckbxMisbehavingWhip.setBounds(6, 322, 291, 23);
		pnlStoreToys.add(chckbxMisbehavingWhip);
		chckbxMisbehavingWhip.setText(toyList.get(10).getToyName());
		checkBoxListToys.add(chckbxMisbehavingWhip);

		JLabel lblToys = new JLabel("Toys");
		lblToys.setBounds(10, 11, 30, 17);
		pnlStoreToys.add(lblToys);
		lblToys.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel pnlStoreFood = new JPanel();
		pnlStoreFood.setBounds(319, 11, 290, 352);
		pnlStoreItems.add(pnlStoreFood);
		pnlStoreFood.setLayout(null);

		JLabel lblFood = new JLabel("Food");
		lblFood.setBounds(6, 11, 90, 28);
		pnlStoreFood.add(lblFood);
		lblFood.setFont(new Font("Tahoma", Font.PLAIN, 14));

		ArrayList<JCheckBox> checkBoxListFoods = new ArrayList<JCheckBox>();

		JCheckBox chckbxJellyMeat = new JCheckBox("10");
		chckbxJellyMeat.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxJellyMeat.isSelected() == true) {
					totalPrice += foodList.get(0).getFoodPrice();
				} else if (chckbxJellyMeat.isSelected() == false) {
					totalPrice -= foodList.get(0).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxJellyMeat.setToolTipText("Price: $5 Nutrition: 10");
		chckbxJellyMeat.setBounds(6, 35, 168, 23);
		pnlStoreFood.add(chckbxJellyMeat);
		chckbxJellyMeat.setText(foodList.get(9).getFoodName());
		checkBoxListFoods.add(chckbxJellyMeat);

		JCheckBox chckbxGrapes = new JCheckBox("9");
		chckbxGrapes.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxGrapes.isSelected() == true) {
					totalPrice += foodList.get(1).getFoodPrice();
				} else if (chckbxGrapes.isSelected() == false) {
					totalPrice -= foodList.get(1).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxGrapes.setToolTipText("Price: $5 Nutrition: 10");
		chckbxGrapes.setBounds(6, 61, 168, 23);
		pnlStoreFood.add(chckbxGrapes);
		chckbxGrapes.setText(foodList.get(1).getFoodName());
		checkBoxListFoods.add(chckbxGrapes);

		JCheckBox chckbxTacos = new JCheckBox("8");
		chckbxTacos.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxTacos.isSelected() == true) {
					totalPrice += foodList.get(2).getFoodPrice();
				} else if (chckbxTacos.isSelected() == false) {
					totalPrice -= foodList.get(2).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxTacos.setToolTipText("Price: $5 Nutrition: 10");
		chckbxTacos.setBounds(6, 87, 168, 23);
		pnlStoreFood.add(chckbxTacos);
		chckbxTacos.setText(foodList.get(2).getFoodName());
		checkBoxListFoods.add(chckbxTacos);

		JCheckBox chckbxSoup = new JCheckBox("7");
		chckbxSoup.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSoup.isSelected() == true) {
					totalPrice += foodList.get(3).getFoodPrice();
				} else if (chckbxSoup.isSelected() == false) {
					totalPrice -= foodList.get(3).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSoup.setToolTipText("Price: $5 Nutrition: 10");
		chckbxSoup.setBounds(6, 113, 168, 23);
		pnlStoreFood.add(chckbxSoup);
		checkBoxListFoods.add(chckbxSoup);
		chckbxSoup.setText(foodList.get(3).getFoodName());

		JCheckBox chckbxSeed = new JCheckBox("6");
		chckbxSeed.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSeed.isSelected() == true) {
					totalPrice += foodList.get(4).getFoodPrice();
				} else if (chckbxSeed.isSelected() == false) {
					totalPrice -= foodList.get(4).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSeed.setToolTipText("Price: $5 Nutrition: 10");
		chckbxSeed.setBounds(6, 139, 168, 23);
		pnlStoreFood.add(chckbxSeed);
		checkBoxListFoods.add(chckbxSeed);
		chckbxSeed.setText(foodList.get(4).getFoodName());

		JCheckBox chckbxDryBiscuit = new JCheckBox("5");
		chckbxDryBiscuit.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxDryBiscuit.isSelected() == true) {
					totalPrice += foodList.get(5).getFoodPrice();
				} else if (chckbxDryBiscuit.isSelected() == false) {
					totalPrice -= foodList.get(5).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxDryBiscuit.setToolTipText("Price: $5 Nutrition: 5");
		chckbxDryBiscuit.setBounds(6, 165, 168, 23);
		pnlStoreFood.add(chckbxDryBiscuit);
		checkBoxListFoods.add(chckbxDryBiscuit);
		chckbxDryBiscuit.setText(foodList.get(5).getFoodName());

		JCheckBox chckbxSalmon = new JCheckBox("4");
		chckbxSalmon.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSalmon.isSelected() == true) {
					totalPrice += foodList.get(6).getFoodPrice();
				} else if (chckbxSalmon.isSelected() == false) {
					totalPrice -= foodList.get(6).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSalmon.setToolTipText("Price: $20 Nutrition: 25");
		chckbxSalmon.setBounds(6, 191, 168, 23);
		pnlStoreFood.add(chckbxSalmon);
		checkBoxListFoods.add(chckbxSalmon);
		chckbxSalmon.setText(foodList.get(6).getFoodName());

		JCheckBox chckbxLasagna = new JCheckBox("3");
		chckbxLasagna.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxLasagna.isSelected() == true) {
					totalPrice += foodList.get(7).getFoodPrice();
				} else if (chckbxLasagna.isSelected() == false) {
					totalPrice -= foodList.get(7).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxLasagna.setToolTipText("Price: $15 Nutrition: 20");
		chckbxLasagna.setBounds(6, 217, 168, 23);
		pnlStoreFood.add(chckbxLasagna);
		checkBoxListFoods.add(chckbxLasagna);
		chckbxLasagna.setText(foodList.get(7).getFoodName());

		JCheckBox chckbxSteak = new JCheckBox("1");
		chckbxSteak.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSteak.isSelected() == true) {
					totalPrice += foodList.get(8).getFoodPrice();
				} else if (chckbxSteak.isSelected() == false) {
					totalPrice -= foodList.get(8).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSteak.setToolTipText("Price: $35 Nutrition: 35");
		chckbxSteak.setBounds(6, 243, 168, 23);
		pnlStoreFood.add(chckbxSteak);
		checkBoxListFoods.add(chckbxSteak);
		chckbxSteak.setText(foodList.get(8).getFoodName());

		JCheckBox chckbxBurrito = new JCheckBox("2");
		chckbxBurrito.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxBurrito.isSelected() == true) {
					totalPrice += foodList.get(9).getFoodPrice();
				} else if (chckbxBurrito.isSelected() == false) {
					totalPrice -= foodList.get(9).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxBurrito.setToolTipText("Price: $13 Nutrition: 18");
		chckbxBurrito.setBounds(6, 269, 168, 23);
		pnlStoreFood.add(chckbxBurrito);
		checkBoxListFoods.add(chckbxBurrito);
		chckbxBurrito.setText(foodList.get(9).getFoodName());

		JCheckBox chckbxSicknessCure = new JCheckBox("11");
		chckbxSicknessCure.addActionListener(new ActionListener() {
			/**
			 * Method is used to update the total price for the store
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxSicknessCure.isSelected() == true) {
					totalPrice += foodList.get(10).getFoodPrice();
				} else if (chckbxSicknessCure.isSelected() == false) {
					totalPrice -= foodList.get(10).getFoodPrice();
				}
				lblTotalPrice.setText("$" + String.valueOf(totalPrice));
			}
		});
		chckbxSicknessCure.setToolTipText("Price: $50 Nutrition: 1 Cures Sickness");
		chckbxSicknessCure.setBounds(6, 322, 168, 23);
		pnlStoreFood.add(chckbxSicknessCure);
		chckbxSicknessCure.setText(foodList.get(10).getFoodName());
		checkBoxListFoods.add(chckbxSicknessCure);

		JLabel lblInventoryHeader = new JLabel("Inventory");
		lblInventoryHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryHeader.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInventoryHeader.setBounds(10, 55, 385, 46);
		pnlStore.add(lblInventoryHeader);

		JLabel lblItemsHeader = new JLabel("Items For Sale");
		lblItemsHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemsHeader.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblItemsHeader.setBounds(405, 55, 619, 46);
		pnlStore.add(lblItemsHeader);

		JLabel lblPlayerBalance = new JLabel("Player Balance: $" + playerList.get(index).getPlayerBalance());
		lblPlayerBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerBalance.setBounds(10, 494, 243, 38);
		pnlStore.add(lblPlayerBalance);

		String outputString = ("");
		for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
			outputString += playerList.get(index).getPlayerToys().get(i).getToyName() + "\n";
		}
		txtpnInventoryToys.setText(outputString);
		txtpnToys.setText(outputString);
		outputString = ("");
		for (int i = 0; i < playerList.get(index).getPlayerFood().size(); i++) {
			outputString += playerList.get(index).getPlayerFood().get(i).getFoodName() + " Food Nutrition: "
					+ playerList.get(index).getPlayerFood().get(i).getNutritionValue() + "\n" + "\n";
		}
		txtpnPlayerFood.setText(outputString);
		txtpnFood.setText(outputString);
		outputString = ("");

		JButton btnPurchase = new JButton("Confirm Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			/**
			 * Method is used to confirm the purchase for the store.
			 */
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int confimationOption = JOptionPane.showConfirmDialog(null, "Confirm Purchase?", "Confirm",
						dialogButton);
				if (confimationOption == 0 && totalPrice <= playerList.get(index).getPlayerBalance()) {
					for (JCheckBox toyBox : checkBoxListToys) {
						if (toyBox.isSelected()) {
							toyBox.setSelected(false);
							if (toyBox.getText() == "Big Frizbee") {
								playerList.get(index).setPlayerToys(new BigFrizbee());
								playerList.get(index).setNegativePlayerBalance(10.00);
							} else if (toyBox.getText() == "Soft, Fluffy Teddy") {
								playerList.get(index).setPlayerToys(new FluffyTeddy());
								playerList.get(index).setNegativePlayerBalance(10.00);
							} else if (toyBox.getText() == "Long Rope") {
								playerList.get(index).setPlayerToys(new LongRope());
								playerList.get(index).setNegativePlayerBalance(10.00);
							} else if (toyBox.getText() == "Whip to cure misbhavouring") {
								playerList.get(index).setPlayerToys(new MisbehavouringWhip());
								playerList.get(index).setNegativePlayerBalance(100.00);
							} else if (toyBox.getText() == "Old Teddy Bear") {
								playerList.get(index).setPlayerToys(new OldTeddy());
								playerList.get(index).setNegativePlayerBalance(5.00);
							} else if (toyBox.getText() == "Short Rope") {
								playerList.get(index).setPlayerToys(new ShortRope());
								playerList.get(index).setNegativePlayerBalance(5.00);
							} else if (toyBox.getText() == "Small Frizbee") {
								playerList.get(index).setPlayerToys(new SmallFrizbee());
								playerList.get(index).setNegativePlayerBalance(5.00);
							} else if (toyBox.getText() == "Soft Toy Duck") {
								playerList.get(index).setPlayerToys(new SoftDuck());
								playerList.get(index).setNegativePlayerBalance(5.00);
							} else if (toyBox.getText() == "Squeaky Toy Duck") {
								playerList.get(index).setPlayerToys(new SqueakyDuck());
								playerList.get(index).setNegativePlayerBalance(10.00);
							} else if (toyBox.getText() == "Red Ball") {
								playerList.get(index).setPlayerToys(new RedBall());
								playerList.get(index).setNegativePlayerBalance(5.00);
							} else if (toyBox.getText() == "Big Blue Ball") {
								playerList.get(index).setPlayerToys(new BigBall());
								playerList.get(index).setNegativePlayerBalance(10.00);
							}
						}
						String outputString = ("");
						txtpnInventoryToys.setText("");
						txtpnToys.setText("");
						for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
							outputString += playerList.get(index).getPlayerToys().get(i).getToyName() + "\n";
						}
						txtpnInventoryToys.setText(outputString);
						txtpnToys.setText(outputString);
						outputString = ("");
					}
					for (JCheckBox foodBox : checkBoxListFoods) {
						if (foodBox.isSelected()) {
							foodBox.setSelected(false);
							for (Food food : foodList) {
								if (food.getFoodName() == foodBox.getText()) {
									playerList.get(index).setPlayerFood(food);
									playerList.get(index).setNegativePlayerBalance(food.getFoodPrice());
								}
							}
						}
						String outputString = ("");
						txtpnPlayerFood.setText("");
						txtpnFood.setText("");
						lblPlayerBalance.setText("Player Balance: $" + playerList.get(index).getPlayerBalance());
						totalPrice = 0;
						lblTotalPrice.setText("$" + String.valueOf(totalPrice));
						for (int i = 0; i < playerList.get(index).getPlayerFood().size(); i++) {
							outputString += playerList.get(index).getPlayerFood().get(i).getFoodName()
									+ " Food Nurition: "
									+ playerList.get(index).getPlayerFood().get(i).getNutritionValue() + "\n";
						}
						txtpnPlayerFood.setText(outputString);
						txtpnFood.setText(outputString);
						outputString = ("");

					}
				} else if (totalPrice > playerList.get(index).getPlayerBalance()) {
					JOptionPane.showMessageDialog(null, "Insuficent Funds to Make Purchase.");
				}

			}
		});

		btnPurchase.setBounds(860, 494, 164, 38);
		pnlStore.add(btnPurchase);

		ArrayList<JPanel> pnlList = new ArrayList<JPanel>();
		pnlList.add(pnlStore);
		pnlList.add(pnlInventory);
		pnlList.add(pnlPetInfo);

		JPanel pnlBackgroundUI = new JPanel();
		pnlBackgroundUI.setBounds(0, 0, 1264, 681);
		pnlBackgroundUI.setLayout(null);
		frmPetSimulator.getContentPane().add(pnlBackgroundUI);

		JLabel lblDaynumber = new JLabel("Day Number ");
		lblDaynumber.setBounds(1063, 572, 97, 21);
		pnlBackgroundUI.add(lblDaynumber);
		lblDaynumber.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblDayCounter = new JLabel("1");
		lblDayCounter.setBounds(1063, 604, 73, 21);
		pnlBackgroundUI.add(lblDayCounter);

		JButton btnDisplayPets = new JButton("Pets");
		btnDisplayPets.setBounds(10, 562, 166, 99);
		pnlBackgroundUI.add(btnDisplayPets);

		JButton btnDisplayInventory = new JButton("Inventory");
		btnDisplayInventory.setBounds(186, 562, 166, 97);
		pnlBackgroundUI.add(btnDisplayInventory);

		JButton btnDisplayStore = new JButton("Store");
		btnDisplayStore.setBounds(362, 562, 166, 97);
		pnlBackgroundUI.add(btnDisplayStore);

		JButton btnEndDay = new JButton("End Day");
		btnEndDay.setBounds(872, 563, 166, 97);
		pnlBackgroundUI.add(btnEndDay);

		JLabel lblCurrentPlayerHeader = new JLabel("Current Player:");
		lblCurrentPlayerHeader.setBounds(1063, 498, 115, 14);
		pnlBackgroundUI.add(lblCurrentPlayerHeader);

		JLabel lblCurrentPlayer = new JLabel("CurrentPlayer");
		lblCurrentPlayer.setBounds(1063, 523, 97, 14);
		lblCurrentPlayer.setText(playerList.get(index).getPlayerName());

		pnlBackgroundUI.add(lblCurrentPlayer);

		JPanel pnlPet1Status = new JPanel();
		pnlPet1Status.setBounds(1050, 11, 204, 145);
		pnlBackgroundUI.add(pnlPet1Status);
		pnlPet1Status.setLayout(null);

		JLabel lblPet1Name = new JLabel("Pet 1 Name");
		lblPet1Name.setBounds(10, 11, 151, 35);
		pnlPet1Status.add(lblPet1Name);
		lblPet1Name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblPet1Hp = new JLabel("HP");
		lblPet1Hp.setBounds(10, 57, 46, 14);
		pnlPet1Status.add(lblPet1Hp);

		JButton btnPet1Status = new JButton("Status");
		btnPet1Status.setBounds(10, 82, 89, 23);
		pnlPet1Status.add(btnPet1Status);

		JPanel pnlPet2Status = new JPanel();
		pnlPet2Status.setBounds(1050, 159, 204, 145);
		pnlBackgroundUI.add(pnlPet2Status);
		pnlPet2Status.setLayout(null);

		JLabel lblPet2Name = new JLabel("Pet 2 Name");
		lblPet2Name.setBounds(10, 11, 151, 14);
		pnlPet2Status.add(lblPet2Name);
		lblPet2Name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblPet2HP = new JLabel("HP");
		lblPet2HP.setBounds(10, 36, 46, 14);
		pnlPet2Status.add(lblPet2HP);

		JButton btnPet2Status = new JButton("Status");
		btnPet2Status.addActionListener(new ActionListener() {
			/**
			 * Method is used to change what pet is being viewed.
			 */
			public void actionPerformed(ActionEvent e) {
				for (JPanel i : pnlList) {
					i.setVisible(false);
				}
				pnlPetInfo.setVisible(true);
				currentPet = playerList.get(index).getPlayerPets().get(1);
				lblPetName.setText(playerList.get(index).getPlayerPets().get(1).getPetName());
				lblPetSpecies.setText(playerList.get(index).getPlayerPets().get(1).getPetSpecies());
				lblFavFood.setText(playerList.get(index).getPlayerPets().get(1).getPetFavouriteFood().getFoodName());
				lblFavToy.setText(playerList.get(index).getPlayerPets().get(1).getPetFavouriteToy().getToyName());
				lblWeight.setText(playerList.get(index).getPlayerPets().get(1).getPetWeight().toString());
				lblDamage.setText(playerList.get(index).getPlayerPets().get(1).getPetDamage().toString());
				lblHunger.setText(Double.toString(playerList.get(index).getPlayerPets().get(1).getPetHunger()));
				lblSickness.setText(playerList.get(index).getPlayerPets().get(1).getPetSickness().toString());
				lblMisbehaving.setText(playerList.get(index).getPlayerPets().get(1).getPetMisbehaving().toString());
				lblTiredness.setText(Double.toString(playerList.get(index).getPlayerPets().get(1).getPetTiredness()));
				lblToiletVar.setText(playerList.get(index).getPlayerPets().get(1).getPetToiletLevel().toString());
				lblHealthVar.setText(playerList.get(index).getPlayerPets().get(1).getPetHealth().toString());
				lblEnergyVar.setText(playerList.get(index).getPlayerPets().get(1).getPetPlayfullness().toString());
				if (playerList.get(index).getPlayerPets().get(1).getPetDead() == false) {
					lblPetSpecies.setEnabled(true);
					lblFavFood.setEnabled(true);
					lblFavToy.setEnabled(true);
					lblWeight.setEnabled(true);
					lblDamage.setEnabled(true);
					lblHunger.setEnabled(true);
					lblSickness.setEnabled(true);
					lblMisbehaving.setEnabled(true);
					lblTiredness.setEnabled(true);
					lblToiletVar.setEnabled(true);
					lblHealthVar.setEnabled(true);
					lblEnergyVar.setEnabled(true);
					lblSpecies_1.setEnabled(true);
					lblFavfood.setEnabled(true);
					lblFavtoy.setEnabled(true);
					lblWeight_1.setEnabled(true);
					lblDamage_1.setEnabled(true);
					lblHunger_1.setEnabled(true);
					lblSickness_1.setEnabled(true);
					lblMisbehaving_1.setEnabled(true);
					lblTiredness_1.setEnabled(true);
					lblToiletLevel_1.setEnabled(true);
					lblHealth_1.setEnabled(true);
					lblEnergy_1.setEnabled(true);
					btnSleepPet.setEnabled(true);
					btnPlayWithToy.setEnabled(true);
					btnFeedPet.setEnabled(true);
					btnGoToilet.setEnabled(true);

					lblPetDead.setVisible(false);
					btnRevive.setEnabled(false);

				} else if (playerList.get(index).getPlayerPets().get(1).getPetDead() == true) {
					lblPetSpecies.setEnabled(false);
					lblFavFood.setEnabled(false);
					lblFavToy.setEnabled(false);
					lblWeight.setEnabled(false);
					lblDamage.setEnabled(false);
					lblHunger.setEnabled(false);
					lblSickness.setEnabled(false);
					lblMisbehaving.setEnabled(false);
					lblTiredness.setEnabled(false);
					lblToiletVar.setEnabled(false);
					lblHealthVar.setEnabled(false);
					lblEnergyVar.setEnabled(false);
					lblSpecies_1.setEnabled(false);
					lblFavfood.setEnabled(false);
					lblFavtoy.setEnabled(false);
					lblWeight_1.setEnabled(false);
					lblDamage_1.setEnabled(false);
					lblHunger_1.setEnabled(false);
					lblSickness_1.setEnabled(false);
					lblMisbehaving_1.setEnabled(false);
					lblTiredness_1.setEnabled(false);
					lblToiletLevel_1.setEnabled(false);
					lblHealth_1.setEnabled(false);
					lblEnergy_1.setEnabled(false);
					btnSleepPet.setEnabled(false);
					btnPlayWithToy.setEnabled(false);
					btnFeedPet.setEnabled(false);
					btnGoToilet.setEnabled(false);

					lblPetDead.setVisible(true);
					btnRevive.setEnabled(true);
				}
			}
		});
		btnPet2Status.setBounds(10, 61, 89, 23);
		pnlPet2Status.add(btnPet2Status);

		JPanel pnlPet3Status = new JPanel();
		pnlPet3Status.setBounds(1050, 307, 204, 145);
		pnlBackgroundUI.add(pnlPet3Status);
		pnlPet3Status.setLayout(null);

		JLabel lblPet3Name = new JLabel("Pet 3 Name");
		lblPet3Name.setBounds(10, 11, 151, 14);
		pnlPet3Status.add(lblPet3Name);
		lblPet3Name.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblPet3HP = new JLabel("HP");
		lblPet3HP.setBounds(10, 36, 46, 14);
		pnlPet3Status.add(lblPet3HP);

		JButton btnPet3Status = new JButton("Status");
		btnPet3Status.addActionListener(new ActionListener() {
			/**
			 * Method is used to change what pet is being viewed.
			 */
			public void actionPerformed(ActionEvent e) {
				for (JPanel i : pnlList) {
					i.setVisible(false);
				}
				pnlPetInfo.setVisible(true);
				currentPet = playerList.get(index).getPlayerPets().get(2);
				lblPetName.setText(playerList.get(index).getPlayerPets().get(2).getPetName());
				lblPetSpecies.setText(playerList.get(index).getPlayerPets().get(2).getPetSpecies());
				lblFavFood.setText(playerList.get(index).getPlayerPets().get(2).getPetFavouriteFood().getFoodName());
				lblFavToy.setText(playerList.get(index).getPlayerPets().get(2).getPetFavouriteToy().getToyName());
				lblWeight.setText(playerList.get(index).getPlayerPets().get(2).getPetWeight().toString());
				lblDamage.setText(playerList.get(index).getPlayerPets().get(2).getPetDamage().toString());
				lblHunger.setText(Double.toString(playerList.get(index).getPlayerPets().get(2).getPetHunger()));
				lblSickness.setText(playerList.get(index).getPlayerPets().get(2).getPetSickness().toString());
				lblMisbehaving.setText(playerList.get(index).getPlayerPets().get(2).getPetMisbehaving().toString());
				lblTiredness.setText(Double.toString(playerList.get(index).getPlayerPets().get(2).getPetTiredness()));
				lblToiletVar.setText(playerList.get(index).getPlayerPets().get(2).getPetToiletLevel().toString());
				lblHealthVar.setText(playerList.get(index).getPlayerPets().get(2).getPetHealth().toString());
				lblEnergyVar.setText(playerList.get(index).getPlayerPets().get(2).getPetPlayfullness().toString());
				if (playerList.get(index).getPlayerPets().get(2).getPetDead() == false) {
					lblPetSpecies.setEnabled(true);
					lblFavFood.setEnabled(true);
					lblFavToy.setEnabled(true);
					lblWeight.setEnabled(true);
					lblDamage.setEnabled(true);
					lblHunger.setEnabled(true);
					lblSickness.setEnabled(true);
					lblMisbehaving.setEnabled(true);
					lblTiredness.setEnabled(true);
					lblToiletVar.setEnabled(true);
					lblHealthVar.setEnabled(true);
					lblEnergyVar.setEnabled(true);
					lblSpecies_1.setEnabled(true);
					lblFavfood.setEnabled(true);
					lblFavtoy.setEnabled(true);
					lblWeight_1.setEnabled(true);
					lblDamage_1.setEnabled(true);
					lblHunger_1.setEnabled(true);
					lblSickness_1.setEnabled(true);
					lblMisbehaving_1.setEnabled(true);
					lblTiredness_1.setEnabled(true);
					lblToiletLevel_1.setEnabled(true);
					lblHealth_1.setEnabled(true);
					lblEnergy_1.setEnabled(true);
					btnSleepPet.setEnabled(true);
					btnPlayWithToy.setEnabled(true);
					btnFeedPet.setEnabled(true);
					btnGoToilet.setEnabled(true);

					lblPetDead.setVisible(false);
					btnRevive.setEnabled(false);

				} else if (playerList.get(index).getPlayerPets().get(2).getPetDead() == true) {
					lblPetSpecies.setEnabled(false);
					lblFavFood.setEnabled(false);
					lblFavToy.setEnabled(false);
					lblWeight.setEnabled(false);
					lblDamage.setEnabled(false);
					lblHunger.setEnabled(false);
					lblSickness.setEnabled(false);
					lblMisbehaving.setEnabled(false);
					lblTiredness.setEnabled(false);
					lblToiletVar.setEnabled(false);
					lblHealthVar.setEnabled(false);
					lblEnergyVar.setEnabled(false);
					lblSpecies_1.setEnabled(false);
					lblFavfood.setEnabled(false);
					lblFavtoy.setEnabled(false);
					lblWeight_1.setEnabled(false);
					lblDamage_1.setEnabled(false);
					lblHunger_1.setEnabled(false);
					lblSickness_1.setEnabled(false);
					lblMisbehaving_1.setEnabled(false);
					lblTiredness_1.setEnabled(false);
					lblToiletLevel_1.setEnabled(false);
					lblHealth_1.setEnabled(false);
					lblEnergy_1.setEnabled(false);
					btnSleepPet.setEnabled(false);
					btnPlayWithToy.setEnabled(false);
					btnFeedPet.setEnabled(false);
					btnGoToilet.setEnabled(false);
					txtpnScores.setText("");

					lblPetDead.setVisible(true);
					btnRevive.setEnabled(true);
				}
			}
		});
		btnPet3Status.setBounds(10, 61, 89, 23);
		pnlPet3Status.add(btnPet3Status);

		JLabel lblScore = new JLabel("Score: ");
		lblScore.setBounds(1063, 547, 46, 14);
		pnlBackgroundUI.add(lblScore);

		JLabel lblCurrentScore = new JLabel(playerList.get(0).getPlayerScore().toString());
		lblCurrentScore.setBounds(1119, 547, 73, 14);
		pnlBackgroundUI.add(lblCurrentScore);
		btnPet1Status.addActionListener(new ActionListener() {
			/**
			 * Method is used to change what pet is being viewed.
			 */
			public void actionPerformed(ActionEvent e) {
				for (JPanel i : pnlList) {
					i.setVisible(false);
				}
				pnlPetInfo.setVisible(true);
				currentPet = playerList.get(index).getPlayerPets().get(0);
				lblPetName.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
				lblPetSpecies.setText(playerList.get(index).getPlayerPets().get(0).getPetSpecies());
				lblFavFood.setText(playerList.get(index).getPlayerPets().get(0).getPetFavouriteFood().getFoodName());
				lblFavToy.setText(playerList.get(index).getPlayerPets().get(0).getPetFavouriteToy().getToyName());
				lblWeight.setText(playerList.get(index).getPlayerPets().get(0).getPetWeight().toString());
				lblDamage.setText(playerList.get(index).getPlayerPets().get(0).getPetDamage().toString());
				lblHunger.setText(Double.toString(playerList.get(index).getPlayerPets().get(0).getPetHunger()));
				lblSickness.setText(playerList.get(index).getPlayerPets().get(0).getPetSickness().toString());
				lblMisbehaving.setText(playerList.get(index).getPlayerPets().get(0).getPetMisbehaving().toString());
				lblTiredness.setText(Double.toString(playerList.get(index).getPlayerPets().get(0).getPetTiredness()));
				lblToiletVar.setText(playerList.get(index).getPlayerPets().get(0).getPetToiletLevel().toString());
				lblHealthVar.setText(playerList.get(index).getPlayerPets().get(0).getPetHealth().toString());
				lblEnergyVar.setText(playerList.get(index).getPlayerPets().get(0).getPetPlayfullness().toString());
				if (playerList.get(index).getPlayerPets().get(0).getPetDead() == false) {
					lblPetSpecies.setEnabled(true);
					lblFavFood.setEnabled(true);
					lblFavToy.setEnabled(true);
					lblWeight.setEnabled(true);
					lblDamage.setEnabled(true);
					lblHunger.setEnabled(true);
					lblSickness.setEnabled(true);
					lblMisbehaving.setEnabled(true);
					lblTiredness.setEnabled(true);
					lblToiletVar.setEnabled(true);
					lblHealthVar.setEnabled(true);
					lblEnergyVar.setEnabled(true);
					lblSpecies_1.setEnabled(true);
					lblFavfood.setEnabled(true);
					lblFavtoy.setEnabled(true);
					lblWeight_1.setEnabled(true);
					lblDamage_1.setEnabled(true);
					lblHunger_1.setEnabled(true);
					lblSickness_1.setEnabled(true);
					lblMisbehaving_1.setEnabled(true);
					lblTiredness_1.setEnabled(true);
					lblToiletLevel_1.setEnabled(true);
					lblHealth_1.setEnabled(true);
					lblEnergy_1.setEnabled(true);
					btnSleepPet.setEnabled(true);
					btnPlayWithToy.setEnabled(true);
					btnFeedPet.setEnabled(true);
					btnGoToilet.setEnabled(true);

					lblPetDead.setVisible(false);
					btnRevive.setEnabled(false);

				} else if (playerList.get(index).getPlayerPets().get(0).getPetDead() == true) {
					lblPetSpecies.setEnabled(false);
					lblFavFood.setEnabled(false);
					lblFavToy.setEnabled(false);
					lblWeight.setEnabled(false);
					lblDamage.setEnabled(false);
					lblHunger.setEnabled(false);
					lblSickness.setEnabled(false);
					lblMisbehaving.setEnabled(false);
					lblTiredness.setEnabled(false);
					lblToiletVar.setEnabled(false);
					lblHealthVar.setEnabled(false);
					lblEnergyVar.setEnabled(false);
					lblSpecies_1.setEnabled(false);
					lblFavfood.setEnabled(false);
					lblFavtoy.setEnabled(false);
					lblWeight_1.setEnabled(false);
					lblDamage_1.setEnabled(false);
					lblHunger_1.setEnabled(false);
					lblSickness_1.setEnabled(false);
					lblMisbehaving_1.setEnabled(false);
					lblTiredness_1.setEnabled(false);
					lblToiletLevel_1.setEnabled(false);
					lblHealth_1.setEnabled(false);
					lblEnergy_1.setEnabled(false);
					btnSleepPet.setEnabled(false);
					btnPlayWithToy.setEnabled(false);
					btnFeedPet.setEnabled(false);
					btnGoToilet.setEnabled(false);

					lblPetDead.setVisible(true);
					btnRevive.setEnabled(true);
				}
			}
		});

		btnDisplayStore.addActionListener(new ActionListener() {
			/**
			 * Method is used to change panel and display the store.
			 */
			public void actionPerformed(ActionEvent e) {
				for (JPanel i : pnlList) {
					i.setVisible(false);
				}
				pnlStore.setVisible(true);
			}
		});
		btnDisplayInventory.addActionListener(new ActionListener() {
			/**
			 * Method is used to change panel and display the Inventory.
			 */
			public void actionPerformed(ActionEvent e) {
				for (JPanel i : pnlList) {
					i.setVisible(false);
				}
				pnlInventory.setVisible(true);
			}
		});
		btnDisplayPets.addActionListener(new ActionListener() {
			/**
			 * Method is used to change panel and display the Pet info.
			 */
			public void actionPerformed(ActionEvent e) {
				for (JPanel i : pnlList) {
					i.setVisible(false);
				}
				pnlPetInfo.setVisible(true);
			}
		});

		btnEndDay.addActionListener(new ActionListener() {
			/**
			 * Method is used to end day and this method updates the labels and
			 * drains the pets stats.
			 */
			public void actionPerformed(ActionEvent e) {
				int counter = 0;
				double playerScore = 0.00;
				for (Pet i : playerList.get(index).getPlayerPets()) {
					playerScore = playerScore + i.getPetHealth();
					if (i.getPetDead() == false) {
						i.drainStats();
					}
					if (i.getPetDead() == true && i.getRevived() == true) {
					} else {
						counter = counter + 1;
					}
				}
				playerScore = (playerScore / (playerList.get(index).getPlayerPets().size()));
				playerList.get(index).setPlayerScore(playerScore);
				playerList.get(index).setPlayerBalance(playerScore);
				Boolean flag1 = false;
				if (counter == 0) {
					if (playerList.size() == 1) {
						pnlPetInfo.setVisible(false);
						pnlInventory.setVisible(false);
						pnlStore.setVisible(false);
						pnlBackgroundUI.setVisible(false);
						pnlGameOver.setVisible(true);
						txtpnScores.setText("");
						ArrayList<Double> playerScoreList = new ArrayList<Double>();
						for (Player i : playerListRounds) {
							playerScoreList.add(i.getPlayerScore());
						}
						Collections.sort(playerScoreList);
						Collections.reverse(playerScoreList);
						String outputString = ("");
						Integer counter1 = 1;
						for (Double x : playerScoreList) {
							for (Player i : playerListRounds) {
								if (i.getPlayerScore() == x) {
									outputString += "Player:" + i.getPlayerName() + " Score is " + i.getPlayerScore()
											+ " and came in position " + counter1 + "\n";
									counter1 += 1;
								}
							}
						}
						txtpnScores.setText(outputString);
						flag1 = true;
					} else {
						playerList.remove(playerList.get(index));
						if (index == 0) {
							setIndex(index + 1);
						} else {
							setIndex(index - 1);
						}
					}
				}
				if (count != rounds && flag1 == false) {
					if (index == playerList.size() - 1) {
						setCount(count + 1);
						setIndex(0);
					} else {
						setCount(count + 1);
						setIndex(index + 1);
					}
					ArrayList<String> petStrings = new ArrayList<String>();
					for (Pet i : playerList.get(index).getPlayerPets()) {
						petStrings.add(i.getPetName());
					}
					DefaultComboBoxModel<Object> petsCombo = new DefaultComboBoxModel<Object>(petStrings.toArray());
					comboBox.setModel(petsCombo);
					pet1Action = 0;
					pet2Action = 0;
					pet3Action = 0;
					currentPet = playerList.get(index).getPlayerPets().get(0);
					lblPetName.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
					lblPetSpecies.setText(playerList.get(index).getPlayerPets().get(0).getPetSpecies());
					lblFavFood
							.setText(playerList.get(index).getPlayerPets().get(0).getPetFavouriteFood().getFoodName());
					lblFavToy.setText(playerList.get(index).getPlayerPets().get(0).getPetFavouriteToy().getToyName());
					lblWeight.setText(playerList.get(index).getPlayerPets().get(0).getPetWeight().toString());
					lblDamage.setText(playerList.get(index).getPlayerPets().get(0).getPetDamage().toString());
					lblHunger.setText(Double.toString(playerList.get(index).getPlayerPets().get(0).getPetHunger()));
					lblSickness.setText(playerList.get(index).getPlayerPets().get(0).getPetSickness().toString());
					lblMisbehaving.setText(playerList.get(index).getPlayerPets().get(0).getPetMisbehaving().toString());
					lblTiredness
							.setText(Double.toString(playerList.get(index).getPlayerPets().get(0).getPetTiredness()));
					lblToiletVar.setText(playerList.get(index).getPlayerPets().get(0).getPetToiletLevel().toString());
					lblPlayerBalance.setText("Player Balance: $" + playerList.get(index).getPlayerBalance());
					lblPetName.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
					lblPetSpecies.setText(playerList.get(index).getPlayerPets().get(0).getPetSpecies());
					lblFavFood
							.setText(playerList.get(index).getPlayerPets().get(0).getPetFavouriteFood().getFoodName());
					lblFavToy.setText(playerList.get(index).getPlayerPets().get(0).getPetFavouriteToy().getToyName());
					lblWeight.setText(playerList.get(index).getPlayerPets().get(0).getPetWeight().toString());
					lblDamage.setText(playerList.get(index).getPlayerPets().get(0).getPetDamage().toString());
					lblHunger.setText(Double.toString(playerList.get(index).getPlayerPets().get(0).getPetHunger()));
					lblSickness.setText(playerList.get(index).getPlayerPets().get(0).getPetSickness().toString());
					lblMisbehaving.setText(playerList.get(index).getPlayerPets().get(0).getPetMisbehaving().toString());
					lblTiredness
							.setText(Double.toString(playerList.get(index).getPlayerPets().get(0).getPetTiredness()));
					lblToiletVar.setText(playerList.get(index).getPlayerPets().get(0).getPetToiletLevel().toString());
					lblHealthVar.setText(playerList.get(index).getPlayerPets().get(0).getPetHealth().toString());
					lblEnergyVar.setText(playerList.get(index).getPlayerPets().get(0).getPetPlayfullness().toString());
					if (playerList.get(index).getPlayerPets().get(0).getPetDead() == false) {
						lblPetSpecies.setEnabled(true);
						lblFavFood.setEnabled(true);
						lblFavToy.setEnabled(true);
						lblWeight.setEnabled(true);
						lblDamage.setEnabled(true);
						lblHunger.setEnabled(true);
						lblSickness.setEnabled(true);
						lblMisbehaving.setEnabled(true);
						lblTiredness.setEnabled(true);
						lblToiletVar.setEnabled(true);
						lblHealthVar.setEnabled(true);
						lblEnergyVar.setEnabled(true);
						lblSpecies_1.setEnabled(true);
						lblFavfood.setEnabled(true);
						lblFavtoy.setEnabled(true);
						lblWeight_1.setEnabled(true);
						lblDamage_1.setEnabled(true);
						lblHunger_1.setEnabled(true);
						lblSickness_1.setEnabled(true);
						lblMisbehaving_1.setEnabled(true);
						lblTiredness_1.setEnabled(true);
						lblToiletLevel_1.setEnabled(true);
						lblHealth_1.setEnabled(true);
						lblEnergy_1.setEnabled(true);
						btnSleepPet.setEnabled(true);
						btnPlayWithToy.setEnabled(true);
						btnFeedPet.setEnabled(true);
						btnGoToilet.setEnabled(true);

						lblPetDead.setVisible(false);
						btnRevive.setEnabled(false);

					} else if (playerList.get(index).getPlayerPets().get(0).getPetDead() == true) {
						lblPetSpecies.setEnabled(false);
						lblFavFood.setEnabled(false);
						lblFavToy.setEnabled(false);
						lblWeight.setEnabled(false);
						lblDamage.setEnabled(false);
						lblHunger.setEnabled(false);
						lblSickness.setEnabled(false);
						lblMisbehaving.setEnabled(false);
						lblTiredness.setEnabled(false);
						lblToiletVar.setEnabled(false);
						lblHealthVar.setEnabled(false);
						lblEnergyVar.setEnabled(false);
						lblSpecies_1.setEnabled(false);
						lblFavfood.setEnabled(false);
						lblFavtoy.setEnabled(false);
						lblWeight_1.setEnabled(false);
						lblDamage_1.setEnabled(false);
						lblHunger_1.setEnabled(false);
						lblSickness_1.setEnabled(false);
						lblMisbehaving_1.setEnabled(false);
						lblTiredness_1.setEnabled(false);
						lblToiletLevel_1.setEnabled(false);
						lblHealth_1.setEnabled(false);
						lblEnergy_1.setEnabled(false);
						btnSleepPet.setEnabled(false);
						btnPlayWithToy.setEnabled(false);
						btnFeedPet.setEnabled(false);
						btnGoToilet.setEnabled(false);

						lblPetDead.setVisible(true);
						btnRevive.setEnabled(true);
					}
					if (playerList.get(index).getPlayerPets().size() == 1) {
						lblPet1Name.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
						pnlPet1Status.setVisible(true);
						pnlPet2Status.setVisible(false);
						pnlPet3Status.setVisible(false);

					} else if (playerList.get(index).getPlayerPets().size() == 2) {
						lblPet1Name.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
						lblPet2Name.setText(playerList.get(index).getPlayerPets().get(1).getPetName());
						pnlPet1Status.setVisible(true);
						pnlPet2Status.setVisible(true);
						pnlPet3Status.setVisible(false);
					} else if (playerList.get(index).getPlayerPets().size() == 3) {
						lblPet1Name.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
						lblPet2Name.setText(playerList.get(index).getPlayerPets().get(1).getPetName());
						lblPet3Name.setText(playerList.get(index).getPlayerPets().get(2).getPetName());
						pnlPet1Status.setVisible(true);
						pnlPet2Status.setVisible(true);
						pnlPet3Status.setVisible(true);
					}
					for (JPanel i : pnlList) {
						i.setVisible(false);
					}
					txtpnInventoryToys.setText("");
					txtpnPlayerFood.setText("");
					txtpnToys.setText("");
					txtpnFood.setText("");
					String outputString = ("");
					for (int i = 0; i < playerList.get(index).getPlayerToys().size(); i++) {
						outputString += playerList.get(index).getPlayerToys().get(i).getToyName() + "\n";
					}
					txtpnInventoryToys.setText(outputString);
					txtpnToys.setText(outputString);
					outputString = ("");
					for (int i = 0; i < playerList.get(index).getPlayerFood().size(); i++) {
						outputString += playerList.get(index).getPlayerFood().get(i).getFoodName() + "\n"
								+ " Food Nurition: " + playerList.get(index).getPlayerFood().get(i).getNutritionValue()
								+ "\n";
					}
					txtpnPlayerFood.setText(outputString);
					txtpnFood.setText(outputString);
					outputString = ("");
					pnlPetInfo.setVisible(true);
					lblCurrentPlayer.setText(playerList.get(index).getPlayerName());
					double dayCount = (Math.ceil((double)count/(double)playerList.size()));
					lblDayCounter.setText(Integer.toString((int) dayCount));
					lblCurrentScore.setText(playerList.get(index).getPlayerScore().toString());
				} else {
					pnlPetInfo.setVisible(false);
					pnlInventory.setVisible(false);
					pnlStore.setVisible(false);
					pnlBackgroundUI.setVisible(false);
					txtpnScores.setText("");
					ArrayList<Long> playerScoreList = new ArrayList<Long>();
					for (Player i : playerListRounds) {
						Integer counta = 0;
						for (Long x : playerScoreList){
							if (x == Math.round(i.getPlayerScore())){
								counta = 1;
							}
						}
						if (counta == 0){
						playerScoreList.add(Math.round(i.getPlayerScore()));
						}
					}
					Collections.sort(playerScoreList);
					Collections.reverse(playerScoreList);
					String outputString = ("");
					Integer counter1 = 1;
					for (Long x : playerScoreList) {
						for (Player i : playerListRounds) {
							if (Math.round(i.getPlayerScore()) == x) {
								outputString += counter1 + ") Player:" + i.getPlayerName() + " Score is "
										+ i.getPlayerScore() + "  \n";
								counter1 += 1;
								
							}
						}
					}
					txtpnScores.setText(outputString);
					// playerListRounds
					pnlGameOver.setVisible(true);
				}
			}
		});

		if (playerList.get(index).getPlayerPets().size() == 1) {
			lblPet1Name.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
			pnlPet1Status.setVisible(true);
			pnlPet2Status.setVisible(false);
			pnlPet3Status.setVisible(false);

		} else if (playerList.get(index).getPlayerPets().size() == 2) {
			lblPet1Name.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
			lblPet2Name.setText(playerList.get(index).getPlayerPets().get(1).getPetName());
			pnlPet1Status.setVisible(true);
			pnlPet2Status.setVisible(true);
			pnlPet3Status.setVisible(false);
		} else if (playerList.get(index).getPlayerPets().size() == 3) {
			lblPet1Name.setText(playerList.get(index).getPlayerPets().get(0).getPetName());
			lblPet2Name.setText(playerList.get(index).getPlayerPets().get(1).getPetName());
			lblPet3Name.setText(playerList.get(index).getPlayerPets().get(2).getPetName());
			pnlPet1Status.setVisible(true);
			pnlPet2Status.setVisible(true);
			pnlPet3Status.setVisible(true);
		}
	}

	/**
	 * Info box method to create a info box that returns 0 or 1 depending on
	 * confirm or cancel.
	 * 
	 * @param infoMessage
	 *            String the message of the info box.
	 * @param titleBar
	 *            String the title of the info box.
	 * @return boolean Returns true or false depending on what is clicked.
	 */
	public static boolean infoBox(String infoMessage, String titleBar) {
		int dialogResult = JOptionPane.showConfirmDialog(null, infoMessage, "InfoBox: " + titleBar,
				JOptionPane.INFORMATION_MESSAGE);
		if (dialogResult == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
}