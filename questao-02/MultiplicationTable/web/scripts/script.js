var form = document.getElementById("formMultiplication");
var startGreaterThanEnd = document.getElementById("startGreaterThanEnd");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    let start = parseInt(form["start"].value);
    let end = parseInt(form["end"].value);

    if (start < end) {
        form.submit();
    } else {
        startGreaterThanEnd.style.display = "block";
        form["start"].focus();
    }
});