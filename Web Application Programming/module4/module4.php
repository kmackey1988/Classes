<! DOCTYPE html>
<html>
    <head>

    </head>
    <body>

        <h1> Example Form </h1>
        <form action="process.php" method="post">
            <p> First name: <input type="text" name="firstName"></p>
            <p> Last name: <input type="text" name="lastName"></p>
            <p> Password: <input type="password" name="password"></p>
            <label for="birthday">Birthday:</label>
            <input type="date" id="birthday" name="birthday">

            <p> Campus: <input type="radio" id="wtn" name="campus" value="weirton">
                        <label for="wtn">weirton</label>
                        <input type="radio" id="wgh" name="campus" value="wheeling">
                        <label for="wgh">Wheeling</label>
                        <input type="radio" id="nm" name="campus" value="New Martinsville">
                        <label for="mn">New Martinsville</label></p>

            <p> Cit Program:
            <select name="program">
                <option value="helpdesk">App & Helpdesk</option>
                <option value="security">Cyber Security</option> 
                <option value="software">Software engineering</option> 
             </select>   
                       



            
            <p> Course modalities:
                <input type="checkbox" id="inseat" name="inseat" value="In Seat">
                <label for="inseat">Inseat</label> 
                <input type="checkbox" id="inseat" name="online" value="Online">
                <label for="online">Inseat</label> 
                <input type="checkbox" id="hybrid" name="hybrid" value="Hybrid">
                <label for="hybrid">Inseat</label></p>

                <p><input type="submit" value="Submit"></p>

                </form>





    </body>

</html> 