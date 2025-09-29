<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текстовый квест - Игра</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <style>
        body { background-color: rgba(0, 0, 0, 0.07); }
        .container {
            max-width: 800px; margin-top: 30px; background-color: white;
            padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .question { background-color: #f8f9fa; padding: 20px; border-radius: 5px; border-left: 4px solid #0d6efd; }
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

    <h1 class="text-center mb-4">Текстовый квест: Поиски сокровищ</h1>

    <div class="question mb-4">
        <p class="lead">${question.text}</p>
    </div>

    <c:if test="${showOptions}">
        <form action="${pageContext.request.contextPath}/game" method="post">
            <button type="submit" name="choice" value="1" class="btn btn-primary w-100 mb-2">
                    ${question.option1}
            </button>
            <button type="submit" name="choice" value="2" class="btn btn-outline-primary w-100">
                    ${question.option2}
            </button>
        </form>
    </c:if>
</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
</body>
</html>