<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Twój projekt został ukończony!</h1>
<h2>Dane projektu</h2>
Numer: ${projectCompleted.id}<br>
System: ${projectCompleted.system.name}<br>
Nazwa szpitala: ${projectCompleted.hospital.name} (${projectCompleted.hospital.hospitalDetails.city})<br>
Osoba odpowiedzialna za realizację: ${projectCompleted.engineer.fullName}<br><br>
<h2>Zobacz komentarze do zamówienia:</h2>

<p>
    ${comments}
</p>


Dziękujemy za współpracę i pozdrawiamy!
</body>
</html>