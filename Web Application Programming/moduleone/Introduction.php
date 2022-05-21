<!DOCTYPE html>
<html>
<head>
  <title>Introduction</title>
  <!-- A top HTML comment block that describes this exercise. 
Start with the basic HTML document structure with DOCTYPE, head and title, and body.
A PHP code block that defines the following variables:
Your full name
Your home campus name (Wheeling, Weirton, New Martinsville)
An integer for how many credit hours you have taken so far at WVNCC
An integer for how many credit hours you have left.  Hint: subtract your current hours from 60.
Add PHP comments that describe each variable
Another, separate PHP code block that generates the following HTML:
A large heading that introduces yourself using the full name variable
A paragraph that uses the home campus variable in a sentence describing where you are from and what your home campus is
A second paragraph that states how many credit hours you have taken, and how many you have left to graduate. -->
</head>
<body>
<?php
$fname = "Kimberly Mackey"; # vairable for full name
$campus = 'Wheeling';       #vairable for campus location
$credit = 48;            #vairable for how many credits taken
$creditleft = 12;      # vairable for how many credits left.
?>

<?php
echo "<h1>Hello! My name is $fname!</h1>";
echo "<p> I live in Windsor Heights.I am closer to $campus therefor I attend classes from the $campus campus. </p>";
echo "<p> I currently have completed $credit credit hours. I only have $creditleft left in order to get my degree. So this is my last semester... well as long as i pass </p>";
?>

</body>

</html>
