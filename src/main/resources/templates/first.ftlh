<!DOCTYPE html>
<html>
<style>
    body {background-color: powderblue;}
    p    {color: deeppink;}
</style>
<body>

<h1 style="color:blue;"> Polish Notation</h1>

<p>Choose the type of file.</p>

    <form action="/type" method="post"style="color:blue;">
    <input id="1" type="radio" name="file" value="txt" checked/>
    <label for="1">txt</label>

    <input id="2" type="radio" value="xml" name="file"/>
    <label for="2">xml</label>

    <input id="3" type="radio" value="json" name="file"/>
    <label for="3">json</label>
  <br/> <br/> <br/> <input type="submit" value="Choose type" style="color:deeppink;">
</form>
<textarea style="color:hotpink;" id="w3review" name="w3review" rows="5" cols="50" >
${result}
</textarea>
</body>
</html>

