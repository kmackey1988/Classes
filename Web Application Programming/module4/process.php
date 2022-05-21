<! DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <h1> Your form input is:</h1>
            <?php
                $fname = $POST['firstName']
                $lname = $POST['LirstName']
                $password = $POST['password']
                $campus = $POST['campus']
                $inseat = $POST['inseat']
                $online = $POST['online']
                $hybrid = $POST['hybrid']
                $birthday = $Post['birthday']
                $program =$POST['program']
             ?>

             <p> First name is: <?php echo $fname; ?></p>  
             <p> Last name is: <?php echo $lname; ?></p>  
             <p> Password is: <?php echo $passwprd; ?></p>
             <p> Birthday is: <?php echo $birthday; ?></p>    
             <p> Campus is: <?php echo $campus; ?></p> 
             <p> CIT Program is: <?php echo $program; ?></p> 
             <p> Modalities: <?php 
                  echo $inseat . " ";
                  echo $online . " ";
                  echo $hybrid;
                 ?></p>   

        </body>

</html>    