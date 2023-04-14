# CS611-Assignment 3
LMH
---------------------------------------------------------------------------
Chun To Pun
chuntpun@bu.edu
U41461275

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
#############


## Input/Output Example
---------------------------------------------------------------------------
Initialization

Welcome to the game world!
The following games exist:
(1) Legends of Valor
Please enter the number of the game you would like to play or enter 'q' to quit
1
Welcome to Legends of Valor!
                            RULES
The game is played in a square world with heroes and monsters.
You will pick a world size and heroes for the game.
Your heroes will travel in a pack across the world filled with markets, common spaces and inaccessible areas.
Markets are marked as "M". Inaccessible areas are marked as "I". Points in the world with no marking represent common spaces. Your hero group position is determined by a "H".
The following can occur as you move across the world:
1 - If you enter a common space, you might have to take part in a battle. The battle is against a random pack of monsters that you will have to defeat using your heroes to end the battle. If all your heroes faint, you lose the game. If you defeat all the monsters, you win the battle and earn incentives.
2 - If you enter a market, you can buy and sell items using your hero's gold. These items could aid your heroes during a battle. You can only visit a market one hero at a time. Additionally, each hero has its own inventory and cannot share items. Heroes also have their own gold and cannot share amongst themselves.
Once your hero with the highest level levels-up, a new world is generated!
The following controls are available:
1 - "w": Move up
2 - "a": Move left
3 - "s": Move down
4 - "d": Move right
5 - "i": Access hero party information outside a battle. Access hero and monster pack information during battle
6 - "m": Enter a market if on market cell
7 - "e": Check hero inventory and consume a potion
8 - "z": Display world map

Enjoy the game!
Here are all the heroes available to you ->
Sorcerers->
Name: Rillifane_Rallathil Mana: 1300 Strength: 750 Agility: 450 Dexterity: 500 Starting_Money: 2500 Starting_Experience: 9
Name: Segojan_Earthcaller Mana: 900 Strength: 800 Agility: 500 Dexterity: 650 Starting_Money: 2500 Starting_Experience: 5
Name: Reign_Havoc Mana: 800 Strength: 800 Agility: 800 Dexterity: 800 Starting_Money: 2500 Starting_Experience: 8
Name: Reverie_Ashels Mana: 900 Strength: 800 Agility: 700 Dexterity: 400 Starting_Money: 2500 Starting_Experience: 7
Name: Kalabar Mana: 800 Strength: 850 Agility: 400 Dexterity: 600 Starting_Money: 2500 Starting_Experience: 6
Name: Skye_Soar Mana: 1000 Strength: 700 Agility: 400 Dexterity: 500 Starting_Money: 2500 Starting_Experience: 5
Warriors->
Name: Gaerdal_Ironhand Mana: 100 Strength: 700 Agility: 500 Dexterity: 600 Starting_Money: 1354 Starting_Experience: 7
Name: Sehanine_Monnbow Mana: 600 Strength: 700 Agility: 800 Dexterity: 500 Starting_Money: 2500 Starting_Experience: 8
Name: Muamman_Duathall Mana: 300 Strength: 900 Agility: 500 Dexterity: 750 Starting_Money: 2546 Starting_Experience: 6
Name: Flandal_Steelskin Mana: 200 Strength: 750 Agility: 650 Dexterity: 700 Starting_Money: 2500 Starting_Experience: 7
Name: Undefeated_Yoj Mana: 400 Strength: 800 Agility: 400 Dexterity: 700 Starting_Money: 2500 Starting_Experience: 7
Name: Eunoia_Cyn Mana: 400 Strength: 700 Agility: 800 Dexterity: 600 Starting_Money: 2500 Starting_Experience: 6
Paladins->
Name: Parzival Mana: 300 Strength: 750 Agility: 650 Dexterity: 700 Starting_Money: 2500 Starting_Experience: 7
Name: Sehanine_Moonbow Mana: 300 Strength: 750 Agility: 700 Dexterity: 700 Starting_Money: 2500 Starting_Experience: 7
Name: Skoraeus_Stonebones Mana: 250 Strength: 650 Agility: 600 Dexterity: 350 Starting_Money: 2500 Starting_Experience: 4
Name: Garl_Glittergold Mana: 100 Strength: 600 Agility: 500 Dexterity: 400 Starting_Money: 2500 Starting_Experience: 5
Name: Amaryllis_Astra Mana: 500 Strength: 500 Agility: 500 Dexterity: 500 Starting_Money: 2500 Starting_Experience: 5
Name: Caliber_Heist Mana: 400 Strength: 400 Agility: 400 Dexterity: 400 Starting_Money: 2500 Starting_Experience: 8
Please enter the name of hero 1:Rillifane_Rallathil
Lanes are: 
Top, Middle and Bottom
Please enter which lane you would like to place your hero in: 
Top
Please enter the name of hero 2:Sehanine_Monnbow
Lanes are: 
Top, Middle and Bottom
Please enter which lane you would like to place your hero in: 
Middle
Please enter the name of hero 3:Caliber_Heist
Lanes are: 
Top, Middle and Bottom
Please enter which lane you would like to place your hero in: 
Bottom
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N    M1  N   I  X  X  I   N        N   N    M2  N   I  X  X  I   N        N   N    M3  N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   
B        B   C        C   I  X  X  I   K        K   K        K   I  X  X  I   P        P   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   
K        K   B        B   I  X  X  I   P        P   K        K   I  X  X  I   K        K   P        P   
K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   C        C   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   

C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
C        C   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   
P        P   P        P   I  X  X  I   B        B   P        P   I  X  X  I   B        B   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N  H1    N   N        N   I  X  X  I   N  H2    N   N        N   I  X  X  I   N  H3    N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H1

------------------------------------------------
Enter Market and Purchase

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H1
m
You can do the following at the market:
1 - View what the market has to offer
2 - Purchase an item
3 - Sell an item
4 - Leave the market

Please enter a number between 1 and 4 to determine what you would like to do:
1
Market Inventory

                                Potion
Name       Price       Level       Attribute Increase       Attribute Affected       Stock
Strength_Potion       200.0       1       75       Strength       1

                                Light Spell
Name       Price       Level       Damage       MP       Stock
Electric_Arrows       550.0       5       650.0       200.0       1

                                Armor
Name       Price       Level       Damage Reduction       Stock
Guardian_Angel       1000.0       10       1000       1

                                Fire Spell
Name       Price       Level       Damage       MP       Stock
Heat_Wave       450.0       2       600.0       150.0       1

                                Ice Spell
Name       Price       Level       Damage       MP       Stock
Frost_Blizzard       750.0       5       850.0       350.0       1

                                Weapon
Name       Price       Level       Damage Value       Number of Hands       Stock
Bow       300.0       2       500.0       2       1
You can do the following at the market:
1 - View what the market has to offer
2 - Purchase an item
3 - Sell an item
4 - Leave the market

Please enter a number between 1 and 4 to determine what you would like to do:
2
Items available in stock:

                                Potion
Name       Price       Level       Attribute Increase       Attribute Affected       Stock
Strength_Potion       200.0       1       75       Strength       1

                                Light Spell
Name       Price       Level       Damage       MP       Stock
Electric_Arrows       550.0       5       650.0       200.0       1

                                Armor
Name       Price       Level       Damage Reduction       Stock
Guardian_Angel       1000.0       10       1000       1

                                Fire Spell
Name       Price       Level       Damage       MP       Stock
Heat_Wave       450.0       2       600.0       150.0       1

                                Ice Spell
Name       Price       Level       Damage       MP       Stock
Frost_Blizzard       750.0       5       850.0       350.0       1

                                Weapon
Name       Price       Level       Damage Value       Number of Hands       Stock
Bow       300.0       2       500.0       2       1

Enter the type of item you would like to purchase (Weapon,Potion,etc):
Weapon
Enter the name of the item:
Bow
You are not at the right level/do not have enough gold. You have the following options:
Enter '1' to buy a different item
1
Items available in stock:

                                Potion
Name       Price       Level       Attribute Increase       Attribute Affected       Stock
Strength_Potion       200.0       1       75       Strength       1

                                Light Spell
Name       Price       Level       Damage       MP       Stock
Electric_Arrows       550.0       5       650.0       200.0       1

                                Armor
Name       Price       Level       Damage Reduction       Stock
Guardian_Angel       1000.0       10       1000       1

                                Fire Spell
Name       Price       Level       Damage       MP       Stock
Heat_Wave       450.0       2       600.0       150.0       1

                                Ice Spell
Name       Price       Level       Damage       MP       Stock
Frost_Blizzard       750.0       5       850.0       350.0       1

                                Weapon
Name       Price       Level       Damage Value       Number of Hands       Stock
Bow       300.0       2       500.0       2       1

Enter the type of item you would like to purchase (Weapon,Potion,etc):
Potion
Enter the name of the item:
Strength_Potion
Purchase successful.
Would you like to buy another item? Enter 1 for yes
no
You can do the following at the market:
1 - View what the market has to offer
2 - Purchase an item
3 - Sell an item
4 - Leave the market

Please enter a number between 1 and 4 to determine what you would like to do:
4

-------------------------------------------------------------------------
Move

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N    M1  N   I  X  X  I   N        N   N    M2  N   I  X  X  I   N        N   N    M3  N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   
B        B   C        C   I  X  X  I   K        K   K        K   I  X  X  I   P        P   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   
K        K   B        B   I  X  X  I   P        P   K        K   I  X  X  I   K        K   P        P   
K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   C        C   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   

C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
C        C   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   
P        P   P        P   I  X  X  I   B        B   P        P   I  X  X  I   B        B   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N  H1    N   N        N   I  X  X  I   N  H2    N   N        N   I  X  X  I   N  H3    N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H1
w
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N    M1  N   I  X  X  I   N        N   N    M2  N   I  X  X  I   N        N   N    M3  N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   
B        B   C        C   I  X  X  I   K        K   K        K   I  X  X  I   P        P   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   
K        K   B        B   I  X  X  I   P        P   K        K   I  X  X  I   K        K   P        P   
K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   C        C   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   

C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
C        C   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   
P  H1     P   P        P   I  X  X  I   B        B   P        P   I  X  X  I   B        B   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N  H2    N   N        N   I  X  X  I   N  H3    N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H2
d
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N    M1  N   I  X  X  I   N        N   N    M2  N   I  X  X  I   N        N   N    M3  N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   
B        B   C        C   I  X  X  I   K        K   K        K   I  X  X  I   P        P   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   
K        K   B        B   I  X  X  I   P        P   K        K   I  X  X  I   K        K   P        P   
K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   C        C   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   

C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
C        C   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   
P  H1     P   P        P   I  X  X  I   B        B   P        P   I  X  X  I   B        B   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N  H2    N   I  X  X  I   N  H3    N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H3
w
You have entered a bush
Increasing your dexterity to aid your battles....
Updated dexterity: 400.0
                            Hero Statistics

Name       DisplayName       HP       MP       Strength       Agility       Dexterity       Gold       Experience       Level
Rillifane_Rallathil       H1       200.0       1573.0000000000005       787.5       496.125       496.125       2400.0       11       2
Sehanine_Monnbow       H2       200.0       726.0000000000001       771.75       882.0       882.0       2600.0       10       2
Caliber_Heist       H3       200.0       484.0000000000001       441.0       420.0       420.0       2600.0       10       2
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   
B        B   C     M1  C   I  X  X  I   K        K   K     M2  K   I  X  X  I   P        P   B     M3  B   
B  B  B  B   C  C  C  C   I  I  I  I   K  K  K  K   K  K  K  K   I  I  I  I   P  P  P  P   B  B  B  B   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   
K        K   B        B   I  X  X  I   P        P   K        K   I  X  X  I   K        K   P        P   
K  K  K  K   B  B  B  B   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   
P        P   P        P   I  X  X  I   P        P   C        C   I  X  X  I   P        P   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   I  I  I  I   P  P  P  P   P  P  P  P   

C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   
C        C   P        P   I  X  X  I   P        P   P        P   I  X  X  I   P        P   P        P   
C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   P  P  P  P   

P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   
P  H1     P   P        P   I  X  X  I   B        B   P        P   I  X  X  I   B  H3     B   P        P   
P  P  P  P   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N  H2    N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N


----------------------------------------------------------------------------------------
Battle

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H2
u

                                Weapon
Name       Price       Level       Damage Value       Number of Hands       Stock
Dagger       200.0       1       250.0       1       1
Please enter if you'd like to pick a Weapon or Armor: 
Weapon

                                Weapon
Name       Price       Level       Damage Value       Number of Hands       Stock
Dagger       200.0       1       250.0       1       1
Please enter the name of the item: 
Dagger
You have successfully equipped the Dagger
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   K        K   I  X  X  I   K        K   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   B        B   I  X  X  I   P        P   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P    M1  P   I  X  X  I   C        C   P    M2  P   I  X  X  I   P        P   C    M3  C   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   
B  H1    B   C        C   I  X  X  I   C  H2    C   K        K   I  X  X  I   K  H3    K   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   

K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
K        K   P        P   I  X  X  I   B        B   P        P   I  X  X  I   P        P   C        C   
K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   
P        P   P        P   I  X  X  I   C        C   P        P   I  X  X  I   B        B   B        B   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H3
u


                                Weapon
Name       Price       Level       Damage Value       Number of Hands       Stock
Sword       500.0       1       800.0       1       1
Please enter if you'd like to pick a Weapon or Armor: 
Weapon

                                Weapon
Name       Price       Level       Damage Value       Number of Hands       Stock
Sword       500.0       1       800.0       1       1
Please enter the name of the item: 
Sword
You have successfully equipped the Sword
H1 has dodged M1 attack!
H2 has dodged M2 attack!
M3 has attacked H3 for 100.0 damage!
                            Hero Statistics

Name       DisplayName       HP       MP       Strength       Agility       Dexterity       Gold       Experience       Level
Parzival       H1       242.00000000000006       483.1530000000002       947.6390601562503       682.5       682.5       2700.0       15       2
Caliber_Heist       H2       266.2000000000001       644.2040000000004       510.51262500000007       457.3800000000001       457.3800000000001       2700.0       16       2
Sehanine_Moonbow       H3       132.00000000000003       483.1530000000002       1052.9322890625       735.0       735.0       2400.0       15       2
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   K        K   I  X  X  I   K        K   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   B        B   I  X  X  I   P        P   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P    M1  P   I  X  X  I   C        C   P    M2  P   I  X  X  I   P        P   C    M3  C   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   
B  H1    B   C        C   I  X  X  I   C  H2    C   K        K   I  X  X  I   K  H3    K   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   

K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
K        K   P        P   I  X  X  I   B        B   P        P   I  X  X  I   P        P   C        C   
K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   
P        P   P        P   I  X  X  I   C        C   P        P   I  X  X  I   B        B   B        B   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H1
Incorrect move entered.
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   K        K   I  X  X  I   K        K   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   B        B   I  X  X  I   P        P   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P    M1  P   I  X  X  I   C        C   P    M2  P   I  X  X  I   P        P   C    M3  C   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   
B  H1    B   C        C   I  X  X  I   C  H2    C   K        K   I  X  X  I   K  H3    K   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   

K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
K        K   P        P   I  X  X  I   B        B   P        P   I  X  X  I   P        P   C        C   
K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   
P        P   P        P   I  X  X  I   C        C   P        P   I  X  X  I   B        B   B        B   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H2
x
H2 has attacked M2 for 250.0 damage!
M2 has fainted!
Heroes gold and experience levels have increased!
                            Hero Statistics

Name       DisplayName       HP       MP       Strength       Agility       Dexterity       Gold       Experience       Level
Parzival       H1       242.00000000000006       483.1530000000002       947.6390601562503       682.5       682.5       500.0       2       2
Caliber_Heist       H2       266.2000000000001       644.2040000000004       510.51262500000007       457.3800000000001       457.3800000000001       500.0       2       2
Sehanine_Moonbow       H3       132.00000000000003       483.1530000000002       1052.9322890625       735.0       735.0       500.0       2       2
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   K        K   I  X  X  I   K        K   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   B        B   I  X  X  I   P        P   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P    M1  P   I  X  X  I   C        C   P        P   I  X  X  I   P        P   C    M3  C   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   
B  H1    B   C        C   I  X  X  I   C  H2    C   K        K   I  X  X  I   K  H3    K   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   

K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
K        K   P        P   I  X  X  I   B        B   P        P   I  X  X  I   P        P   C        C   
K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   
P        P   P        P   I  X  X  I   C        C   P        P   I  X  X  I   B        B   B        B   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N

----------------------------------------------------------------------
Win Game

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N    M6  N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   
P  H1    P   P    M4  P   I  X  X  I   P  H2    P   K        K   I  X  X  I   K  H3    K   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   K  K  K  K   I  I  I  I   K  K  K  K   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P        P   I  X  X  I   P        P   B        B   I  X  X  I   P        P   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   P  P  P  P   B  B  B  B   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
P        P   P        P   I  X  X  I   C        C   P        P   I  X  X  I   P        P   C        C   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   
B        B   C        C   I  X  X  I   C        C   K        K   I  X  X  I   K        K   B        B   
B  B  B  B   C  C  C  C   I  I  I  I   C  C  C  C   K  K  K  K   I  I  I  I   K  K  K  K   B  B  B  B   

K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   
K        K   P        P   I  X  X  I   B        B   P        P   I  X  X  I   P        P   C        C   
K  K  K  K   P  P  P  P   I  I  I  I   B  B  B  B   P  P  P  P   I  I  I  I   P  P  P  P   C  C  C  C   

P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   
P        P   P        P   I  X  X  I   C        C   P        P   I  X  X  I   B        B   B        B   
P  P  P  P   P  P  P  P   I  I  I  I   C  C  C  C   P  P  P  P   I  I  I  I   B  B  B  B   B  B  B  B   

N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   
N        N   N        N   I  X  X  I   N        N   N        N   I  X  X  I   N        N   N        N   
N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   I  I  I  I   N  N  N  N   N  N  N  N   

Here are all the options available: 
w - move up
a - move left
s - move down
d - move right
u - change equipment
p - use a potion
x - attack
c - cast a spell
t - teleport
r - recall
i - show hero statistics
e - show inventory
m - enter market
z - display world map
q - quit game
Please enter a key H2
w
A hero has reached the monster nexus! You have won the game!