<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PassengerForm</title>
</head>
<body>
    <form method="post" action="savePassengerInfo">
        <div>
            <label for="passName">User Name:</label>
            <input type="text" id="passName" name="passName"/>
        <div>
            <label for="email">Password:</label>
            <input type="text" id="email" name="email"/>
        </div>
        <div>
            <label for="mobile">User Email:</label>
            <input type="text" id="mobile" name="mobile"/>
        </div>
        <div>
            <label for="passengerType">Train Type:</label>
             <select id="passengerType" name="passengerType">
                <option value="General">General</option>
                <option value="Senior Citizen">Senior Citizen</option>
                <option value="Physically Handicapped Proof">Physically Handicapped Proof</option>
             </select>

        </div>
        <div>
            <input type="submit" name="Submit" value="Submit"/>
        </div>
    </form>
</body>
</html>