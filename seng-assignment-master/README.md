# seng-assignment
Classes

Players (3 max)
-Name[No two pets can have same name - MAYBE] 
-List of pets(max 3 pets per player)
-Toys currently available
-Food currently available
-Money, balance
(Toys and food will default to 0)

Pets
-Species{has its own class}
-Name[No two pets can have same name]
-Mood (happy, sad etc)
-hunger(full, hungry etc  [species have different hunger degradation])
-health (healthy, sick etc)
-Sleep(Some species have different sleep time than others) - ACTION
-weight(species will be different  [will gain weight as they eat])
-bathroom[after eating will go toilet and lose weight] - ACTION
-Play with toys[could make tired or hungry depending on toy] - ACTION
-Feed the pet[feed pet] - ACTION
-Random event[Might gain an illness or misbehaviour]
-Ded [ stats go low ]
-Revive[ Only used on pet once ]
-Damage to toys
-Favourite food
-Hated food
-Stats[Show stats/attributes]
-Status[Show status of pet]

Species
Name
Attributes(Base stats[includings stats like damage, weight and size etc] (6 is enough))
Traits
Preference

Inventory
Show toys(show durability of toy as well)
Show food
Show money
Remove toy
Remove food

Toys
[Playing with toys will increase happiness]
-toy id
-Different types of toys(6 will be enough)
-Price(vary between toys)
-Durability [after being played with a certain amount of times it will break or if the species plays too hard]
-Break[Broken toys removed from inventory]

Food 
-Different types of food(6 will be enough)
-Price(vary between food)
-Food nutrition (Food will also differ in nutrition and tastiness)[the nutrition value can perhaps reduce hunger of pet by X amount][Bad nutrition can leave pets still hungry and good food can full them up etc]
-Feast[After eating a big meal the pet will need to go to the bathroom]
-Tasy value[Depends on pets tastes]

Store
-purchase food (price and attributes)
-purchase toys (price and attributes)
-view stock
-view player inv
-view balance
-Buy[removes balance]



Game Environment
-Game starts
-Amount of players and player data
-initializer of game
-days/rounds [ Skip day]
-help section my dude
-Show score[Daily and final
-Actions (maximum = 2)

-Save (Optional)
-Save results (Optional)
-Create Custom Pet (Optional)
-Create Custom Toy (Optional)

Relationship / Inheritance 
-Pets and species 
