<?php  

function makeTable($headerarray, $numrows) {
  
   echo "<table>";
        foreach($headerarray as $header) {
           echo "<th>" . $header . "</th>";}
    
       $class = 'light';
       $numcolumns = count($headerarray);
 
            for ($row = 1; $row <= $numrows; $row++) {
                echo "<tr class=\"" . $class . "\">";
            for ($column = 1; $column <= $numcolumns; $column++) {
                      echo "<td>";
                          if($column == 1) { 
                             echo "Row " . $row;}
                          else { 
                             echo "Column " . $column;} 
                
                        echo "</td>";} 
                  echo "</tr>";
            if($class == 'light') {
            $class = 'dark';}
            else {
            $class = 'light';}
        
    }
    echo "</table>";
  
}
$headers = array(
     " ",
    "Book Title",
    "Book Author",
    "Publication Date",
    "Book Pages",
    "Finished Book"
);


makeTable($headers, 5); 
?>  

<!DOCTYPE html>
<html>

      <head>
          <meta charset="UTF-8">
          <link rel="stylesheet" href="moduletwo.css">
      </head>
      <body>


      </body>
</html>