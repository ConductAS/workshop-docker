function finnPoststed(inputId, outputId) {

    var input, output, url, request;

    function handleResponse(response) {
        output.value = response;
    }

    input = document.getElementById(inputId);
    output = document.getElementById(outputId);
    if (input.value.length === 4) {

        url = "http://localhost:8080/registrering/" + input.value;

        request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                handleResponse(request.responseText);
            }
        };
        request.open("GET", url, true);
        request.setRequestHeader("Accept", "text/plain");
        request.send(null);

    } else {
        output.value = "";
    }

}