
<?php
/* Kimberly Mackey
cit215 
09/13/2020 */
echo $_SERVER['REMOTE_ADDR'];
 
	function makeList($litem) {
      
   
    echo "<ul>"; # create unordered list
          $languages = array("PHP", "SQL", "Python", "C-Sharp", "C", "Javascript", "Java", "Ruby", "GoLang", "Basic"); #language index array
               $arrlength = count($languages);     
                     for($x = 0; $x < $arrlength; $x++) {
                     echo "<li> $languages[$x]</li> <br>";}  # first loop as list item
                     
                     array_push($languages, "Viper", "Jade"); #add language
                     
                     foreach ($languages as $value) {   #second loop printing list again with added languages
                      echo "<li> $value </li>";}
   echo "</ul>";
    }
    $RPG = array("Name"=>"The Chosen One", "Character class"=>"Mage", "Level"=>"110",
    "Strength"=>"65", "Agility"=>"43", "Intelligence"=>"100,000", "Charisma"=>"100"); #create associative array

    print "<h1> Name: "  . $RPG['Name'] . "</h1>"; #print name in h1
    print "<h2> Character Class: " . $RPG['Character class'] . "</h2>"; #print character class in h2
    print "<p> Level: " . $RPG['Level'] . "</p>"; #print the rest in paragraph
    print "<p> Strength: " . $RPG['Strength'] . "</p>";  #print the rest in paragraph
    print "<p> Agility: " . $RPG['Agility'] . "</p>";   #print the rest in paragraph
    print "<p> Intelligence: " . $RPG['Intelligence'] . "</p>";  #print the rest in paragraph
    print "<p> Charisma: " . $RPG['Charisma'] . "</p>"; #print the rest in paragraph

 
                   
makelist($languages);
 

?>




<!DOCTYPE html>

<html>
<body>

</body>
</html>