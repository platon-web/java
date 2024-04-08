<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%--task 1--%>

<%--<h1>Current Time and Date</h1>--%>

<%--<p>Current Date and Time: <%--%>
<%--    Date date = new Date();--%>
<%--    SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd, yyyy HH:mm:ss z");--%>
<%--    out.print(formatter.format(date));--%>
<%--%></p>--%>


<%--    task 2--%>
<%--<h2>Countdown Timer</h2>--%>
<%--<form id="timerForm">--%>
<%--    <label for="timeInput">Enter time in seconds:</label>--%>
<%--    <input type="text" id="timeInput" name="timeInput" required>--%>
<%--    <button type="button" onclick="startTimer()">Start Timer</button>--%>
<%--</form>--%>

<%--<div id="timerDisplay"></div>--%>

<%--<script>--%>
<%--    function startTimer() {--%>
<%--        var timeInSeconds = document.getElementById("timeInput").value;--%>
<%--        var countdownDisplay = document.getElementById("timerDisplay");--%>

<%--        if (isNaN(timeInSeconds) || timeInSeconds <= 0) {--%>
<%--            countdownDisplay.textContent = "Please enter a valid positive number for time.";--%>
<%--            return;--%>
<%--        }--%>

<%--        var countdown = setInterval(function() {--%>
<%--            if (timeInSeconds <= 0) {--%>
<%--                clearInterval(countdown);--%>
<%--                countdownDisplay.textContent = "Time's up!";--%>
<%--            } else {--%>
<%--                countdownDisplay.textContent = "Time remaining: " + timeInSeconds + " seconds";--%>
<%--                timeInSeconds--;--%>
<%--            }--%>
<%--        }, 1000);--%>
<%--    }--%>
<%--</script>--%>

<%--task 3--%>
<%--<h2>Random Quote</h2>--%>
<%--<div id="quoteDisplay"></div>--%>

<%--<script>--%>
<%--    var quotes = [--%>
<%--        "Be yourself; everyone else is already taken. - Oscar Wilde",--%>
<%--        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe. - Albert Einstein",--%>
<%--        "So many books, so little time. - Frank Zappa",--%>
<%--        "Be the change that you wish to see in the world. - Mahatma Gandhi",--%>
<%--        "In three words I can sum up everything I've learned about life: it goes on. - Robert Frost"--%>
<%--    ];--%>

<%--    function displayRandomQuote() {--%>
<%--        var randomIndex = Math.floor(Math.random() * quotes.length);--%>
<%--        var quoteDisplay = document.getElementById("quoteDisplay");--%>
<%--        quoteDisplay.textContent = quotes[randomIndex];--%>
<%--    }--%>

<%--    displayRandomQuote();--%>
<%--</script>--%>

<%--task 4--%>
<h2>Random Quote</h2>
<label for="categorySelect">Select a category:</label>
<select id="categorySelect" onchange="displayRandomQuote()">
    <option value="education">Education</option>
    <option value="personalDevelopment">Personal Development</option>
    <option value="relationships">Relationships</option>
    <option value="history">History</option>
</select>
<br><br>
<div id="quoteDisplay"></div>

<script>
    var quotesByCategory = {
        education: [
            "Education is the most powerful weapon which you can use to change the world. - Nelson Mandela",
            "The only true wisdom is in knowing you know nothing. - Socrates",
            "Education is not the filling of a pail, but the lighting of a fire. - William Butler Yeats"
        ],
        personalDevelopment: [
            "You must be the change you wish to see in the world. - Mahatma Gandhi",
            "The only way to do great work is to love what you do. - Steve Jobs",
            "The journey of a thousand miles begins with one step. - Lao Tzu"
        ],
        relationships: [
            "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela",
            "The only way to have a friend is to be one. - Ralph Waldo Emerson",
            "Keep love in your heart. A life without it is like a sunless garden when the flowers are dead. - Oscar Wilde"
        ],
        history: [
            "Those who cannot remember the past are condemned to repeat it. - George Santayana",
            "History will be kind to me for I intend to write it. - Winston Churchill",
            "History is a relentless master. It has no present, only the past rushing into the future. - Dwight D. Eisenhower"
        ]
    };

    function displayRandomQuote() {
        var categorySelect = document.getElementById("categorySelect");
        var category = categorySelect.value;
        var quotes = quotesByCategory[category];
        var randomIndex = Math.floor(Math.random() * quotes.length);
        var quoteDisplay = document.getElementById("quoteDisplay");
        quoteDisplay.textContent = quotes[randomIndex];
    }

    // Display a random quote when the page loads
    displayRandomQuote();
</script>

</body>
</html>