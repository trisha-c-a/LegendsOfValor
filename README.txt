# CS611-Assignment 4
## Legends of Valor
---------------------------------------------------------------------------
Chun To Pun					Trisha Celine Anil
chuntpun@bu.edu				tcanil@bu.edu
U41461275					U12239724

## Files
---------------------------------------------------------------------------
Main.java -- create Legends and valor game class and creates a instance. Calls play game.
Game.java -- parent class of Legends and Valor, has attributes name.
HerosAndMonsters.java -- Legends and Valor Game class.
Armory.java -- Child class of Item class, has attribute relative to armor
Battle Interface -- Implemented by Heroes class and Monsters Class
Bush.java -- Creates an instance of bush cell which increase the dexterity of Hero when entered implements ModifyAttribute interface
Cave.java -- Creates an instance of cave cell which increase the agility of Hero when entered implements Modify Attribute interface
Cell.java -- parent class of all cell types
Character.java -- parent class of Hero class and Monster class
Common.java -- creates a plain space instance
Controls.java -- Used to display information and function user input during game
Dragons.java -- Dragons extends Monsters class
EnhancePotion.java -- Potions that have a single enhance attribute
Equipments.java -- Parent Class of Armor and Weaponry, extends InventoryItem class
Exoskeletons.java -- Extends Monsters class
FavoredSkill Interface -- Implemented by the hero class and monster class
FireSpells.java -- Extends Spells class
Group Interface -- Ensure proper function to determine game stats of hero and monster is implemented
Hero.java -- Parent class of Paladins, Sorcerers, Warriors
HeroGroup.java -- Implements group interface, keep track of all 3 heroes' stats
IceSpells.java -- Extends spells class
Inaccessible.java -- Extends cell class, represent space that is not accessible
Inventory.java -- Class that holds a list of all inventory items reads information from txt file
Item.java -- Parent class of all classes that classified as items
Koulou.java -- Creates an instance of cave cell which increase the strength of Hero when entered  implements Modify Attribute Interface
LightSpells.java -- Extends spells class
Market.java -- Contains a list of items when initialize
ModifyAttribute Interface -- ensures all cells that should be able to increase attribute implement the function
Monsters.java -- Parent class of all monsters
MonsterPack.java -- Implements group interface, keep track of all 3 monsters' stats
Nexus.java -- Creates an instance of nexus cell enable market entrance
Paladins.java -- type of hero
Potions.java -- Parent class of all potion classes, extends consumables
Random.java -- Class to randomly generate cell types
Reader.java -- reads information from txt files
Sorceror.java -- type of hero
Spell.java -- parent class of all spell classes
Spirit.java -- type of monster
Warrior.java -- type of hero
Weapon.java -- Child class of Item class, has attribute relative to armor
World.java -- Creates the map for the game

## How to compile and run
---------------------------------------------------------------------------
1. Unzip the files
2. Run the following instructions:
	- javac *.java
	- java Main
#############


## Input/Output Example
---------------------------------------------------------------------------
