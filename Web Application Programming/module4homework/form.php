<! DOCTYPE html>
<html>
    <head>
        <title> module 4 homework restraunt review
       </title>

    </head>
    <body>

        <h1> Restraunt Review </h1>
        <form action="process.php" method="post">
            <p> First name: <input type="text" name="firstName"></p>
            <p> Last name: <input type="text" name="lastName"></p>
            <P> Eneter Address, Street number: <input type="number" name="streetNum">
                                Street name: <input type="text" name="streetName">
                                City: <input type="text" name="city">
                                State: <input type="text" name="State"> 
                                zipcode: <input type="text" id="zip" name="zip" pattern="[0-9]*"> </P>          
            <p> Email Address: <input type="email" id="email" name="email"></p>
            <P> Date Visited: <input type="date" id="visited" name="visited">  
            <p> Branch Visited:
            <select name="branch">
                <option value="wtn">Weirton</option>
                <option value="wgh">wheeling</option> 
                <option value="nm">New Martinsville</option> 
             </select>   
            </P>                   
            <p> Rate Food Quality (1 being the worst 5 being the best): <input type="number" id="fquality" name="fquality" min="1" max="5"></p> 
            <p> Rate Service Quality (1 being the worst 5 being the best): <input type="number" id="squality" name="squality" min="1" max="5"></p>     
            <p> Rate Store Cleanliness (1 being diry 5 being clean): <input type="number" id="clean" name="clean" min="1" max="5"></p>   

             <p> Subsribe to email Newsletter: <input type="radio" id="y" name="news" value="yes">
                        <label for="y">YES</label>
                        <input type="radio" id="n" name="news" value="no">
                        <label for="n">NO</label>            

            <p> Leave Comment: <textarea name="comment" rows="5" cols="40"></textarea> </P>

            <p> <input type="submit" name="submit" value="sunmit"></p>
             <p> <input type="reset" name="reset" value="reset"></p>   
             
                </form>





    </body>

</html> 