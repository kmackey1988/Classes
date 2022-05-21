<! DOCTYPE html>
<html>
    <head>
      

    </head>
    <body>
        <h1> Survey answers:</h1>
            <?php
                $fname = $POST['firstName']
                $lname = $POST['LirstName']
                $snum = $POST['streetNum']
                $sname = $POST['streetName']
                $city = $POST['city']
                $zip = $POST['zip']
                $state = $POST['']
                $email = $POST['email']
                $visited = $Post['visited']
                $fquality = $POST['fquality']
                $squality = $POST['squality']
                $clean = $POST['clean']
                $branch = $POST['branch']
                $news = $post['news']
                $comment = ['comment']
              
          
             ?>

             <p> First name is: <?php echo $fname; ?></p>  
             <p> Last name is: <?php echo $lname; ?></p> 
             <p> Address is: <?php echo $snum . " " . $sname . " " . $city . " " . $zip; ?></p> 
             <p> Email is: <?php echo $email; ?></p>
             <p> Date and location: <?php echo $visited . " " . $branch; ?></p> 
             <P> Average Rating: <?php $numbersInSet = 3; if(is_numeric($fquality) &&is_numeric($squality)&&is_numeric($clean)){
                                  $sum=$fquality+$squality+$clean; $average = $sum / $numbersInSet; echo $average; ?></p>
             <p> Comments: <?php echo $comment; ?></p>
             <?php  If ($news ==yes){ echo "Email Newsletter" } else { echo ""};   ?>

               

        </body>

</html>    