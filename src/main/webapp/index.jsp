<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Добро пожаловать в текстовый квест!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            max-width: 800px;
            margin-top: 30px;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center mb-4">Добро пожаловать на остров сокровищ!</h1>

    <p class="lead">
        Вы — смелый искатель приключений на таинственном острове.
        Легенда гласит, что здесь спрятаны сокровища. Готовы начать?
    </p>

    <form action="${pageContext.request.contextPath}/start" method="post">
        <div class="mb-3">
            <label for="playerName" class="form-label">Введите ваше имя:</label>
            <input type="text" class="form-control" id="playerName" name="playerName" required pattern=".*\S.*"
                   title="Имя не может состоять только из пробелов">
        </div>
        <button type="submit" class="btn btn-primary w-100">Начать игру</button>
    </form>
</div>
</body>
</html>