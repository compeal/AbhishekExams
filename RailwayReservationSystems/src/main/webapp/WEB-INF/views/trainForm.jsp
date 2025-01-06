<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TrainForm</title>
</head>
<body>
    <form method="post" action="saveTrainInfo">
        <div>
            <label for="trainName">Train Name:</label>
            <input type="text" id="trainName" name="trainName"/>
        <div>
            <label for="noOfCoaches">No. Of Coaches:</label>
            <input type="text" id="noOfCoaches" name="noOfCoaches"/>
        </div>
        <div>
            <label for="startStation">Start Station:</label>
            <input type="text" id="startStation" name="startStation"/>
        </div>
        <div>
             <label for="endStation">End Station:</label>
             <input type="text" id="endStation" name="endStation"/>
        </div>
        <div>
              <label for="trainType">Train Type:</label>
              <select id="trainType" name="trainType">
                <option value="Local Train">Local Train</option>
                <option value="Super Fast">Super Fast</option>
                <option value="Intercity Express">Intercity Express</option>
                <option value="Goods Train">Goods Train</option>
              </select>
        </div>
        <div>
             <label for="endStation">End Station:</label>
             <input type="text" id="endStation" name="endStation"/>
        </div>
        <div>
            <input type="submit" name="Submit" value="Submit"/>
        </div>
    </form>
</body>
</html>