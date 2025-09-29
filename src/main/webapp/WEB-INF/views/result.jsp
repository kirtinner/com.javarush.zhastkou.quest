<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текстовый квест - Результат</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .container {
            max-width: 800px; margin-top: 30px; background-color: white;
            padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .result { padding: 20px; border-radius: 5px; margin: 20px 0; }
        .win { background-color: #d1ecf1; border: 1px solid #bee5eb; color: #0c5460; }
        .lose { background-color: #f8d7da; border: 1px solid #f5c6cb; color: #721c24; }
        .player-info { text-align: right; font-style: italic; color: #6c757d; margin-bottom: 20px; }
    </style>
</head>
<body>
<div class="container">
    <div class="player-info">
        Игрок: ${gameState.player.name} |
        Сыграно игр: ${gameState.player.gamesPlayed} |
        Побед: ${gameState.player.wins}
    </div>

    <h1 class="text-center mb-4">Результат игры</h1>

    <div class="result ${gameState.victory ? 'win' : 'lose'}">
        <c:choose>
            <c:when test="${gameState.victory}">
                <h2 class="text-center">🎉 Поздравляем! Вы победили!</h2>
                <p class="lead text-center">${gameState.currentQuestion.text}</p>
            </c:when>
            <c:otherwise>
                <h2 class="text-center">😢 К сожалению, вы проиграли...</h2>
                <p class="lead text-center">${gameState.currentQuestion.text}</p>
            </c:otherwise>
        </c:choose>
    </div>

    <form action="${pageContext.request.contextPath}/start" method="post">
        <input type="hidden" name="playerName" value="${gameState.player.name}">
        <button type="submit" class="btn btn-success w-100">Начать новую игру</button>
    </form>
</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
</body>
</html>