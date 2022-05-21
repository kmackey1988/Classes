<?php  
//define default `$numrows` in function declaration
function makeTable($headerarray, $numrows = 5) {
    
    //create table beginning
    echo "<table>";
    
    //create first row, which is your header
    //this needs to be done OUTSIDE of the header loop, as there is only 1 set of headers.
    echo "<tr>";
    
    //loop through headers using FOREACH
    foreach($headerarray as $header) {
        //add <th> element for each header
        echo "<th>" . $header . "</th>";
    }
    
    //end table row (header)
    echo "</tr>";
    
    //define ODD class. The first loop is ALWAYS ODD.
    $class = 'light';
    
    //get a count of columns
    $numcolumns = count($headerarray);
    
    //loop a specific number of times (number of rows), using a FOR loop
    for ($row = 1; $row <= $numrows; $row++) {
    
        //create table row inside FIRST FOR LOOP. This creates a row each time.
        //also add `$class` to row.
        echo "<tr class=\"" . $class . "\">";
        
        //loop a specific number of times (number of columns). This creates a column each time.
        for ($column = 1; $column <= $numcolumns; $column++) {
        
            //create a <td> element (cell)
            echo "<td>";
            
            
            if($column == 1) { //if column is 1
            
                //use row number as cell content
                echo "Row " . $row;
                
            } else { //if column IS NOT 1
            
                //use column number as content
                echo "Column " . $column; #show column number as content
                
            }
            
            //end <td> element (cell)
            echo "</td>"; #end row
        }
        
        //end table row
        echo "</tr>";
        
        //AT THE END OF ROW LOOP, switch `$class` to 'dark' if it is currently 'light'
        //or switch it to 'light' if it is currently 'dark'
        //since this is at the end of the row loop, it takes effect on the next loop. That means it should alternate between the 2
        /***
            This solution has several benefits. First, you don't need to know if the current row is even or odd.
            second, you could use this to check if the row is even/odd IF YOU NEED TO
            (if `$class` is 'light', you know the row is ODD)
        **/
        if($class == 'light') {
            $class = 'dark';
        } else {
            $class = 'light';
        }
        
    }
    
    //end table
    echo "</table>";
  
}


$headers = array(
    "Book Title",
    "Book Author",
    "Publication Date",
    "Book Pages",
    "Finished Book"
);


makeTable($headers, 5); #create a table with 5 empty rows under the header
?>  

<!DOCTYPE html>
<html>
<body>



</body>
</html>










<?php  

function makeTable($headerarray, $numrows = 5) {
    
   
    echo "<table>";
  
    echo "<tr>";
    foreach($headerarray as $header) {
        
        echo "<th>" . $header . "</th>";
    }
    
    echo "</tr>";
    
    $class = 'light';
    $numcolumns = count($headerarray);
 
    for ($row = 1; $row <= $numrows; $row++) {
    
        echo "<tr class=\"" . $class . "\">";
        
        for ($column = 1; $column <= $numcolumns; $column++) {
        
            echo "<td>";
            
            
            if($column == 1) { 
                echo "Row " . $row;
                
            } else { 
                echo "Column " . $column; 
                
            }
            echo "</td>"; 
        }
        
     
        echo "</tr>";
        
       
        if($class == 'light') {
            $class = 'dark';
        } else {
            $class = 'light';
        }
        
    }
    
    //end table
    echo "</table>";
  
}


$headers = array(
    "Book Title",
    "Book Author",
    "Publication Date",
    "Book Pages",
    "Finished Book"
);


makeTable($headers, 5); #create a table with 5 empty rows under the header
?>  

<!DOCTYPE html>
<html>
<body>



</body>
</html>
