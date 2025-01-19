<!DOCTYPE html>
<html>
<style>
    body {background-color: powderblue;}
    p    {color: deeppink;}
</style>
<script>
    // Функция для изменения action формы
    function updateFormAction(selectedAction) {
        document.getElementById("dynamicForm").action = selectedAction;
    }
</script>

<body>

<h1 style="color:blue;"> Polish Notation</h1>

<p>Choose the type of file.</p>

<form id="dynamicForm" method="POST" action="">
    <!-- Радио-кнопки -->
    <label>
        <input type="radio" name="action" value="/action1" onclick="updateFormAction('/action1')">
        txt
    </label><br>
    <label>
        <input type="radio" name="action" value="/action2" onclick="updateFormAction('/action2')">
        xml
    </label><br>
    <label>
        <input type="radio" name="action" value="/action3" onclick="updateFormAction('/action3')">
        json

    </label><br>
    <label>
        <input type="radio" name="action" value="/action4" onclick="updateFormAction('/action4')">
        encription
    </label><br>
    <label>
        <input type="radio" name="action" value="/action5" onclick="updateFormAction('/action5')">
        archive
    </label><br>

    <!-- Кнопка отправки -->
    <button type="submit">choose type</button>
</form>
<label for="w3review"></label><textarea style="color:hotpink;" id="w3review" name="w3review" rows="5" cols="50" >
${result}
</textarea>
</body>
</html>

