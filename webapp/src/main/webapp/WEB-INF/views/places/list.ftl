<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#list places as place>
    <tr><td>${place.mapsId}<td>${place.name}
</#list>
</body>
</html>