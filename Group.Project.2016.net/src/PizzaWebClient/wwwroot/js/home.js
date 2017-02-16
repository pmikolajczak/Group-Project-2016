$(document).ready(function () {
    var model = {
        ingredients: ko.observableArray([{ IngredientID: 0, Name: ""}]),
        ingredientsSelected: ko.observableArray(),
        latitude: ko.observable(),
        longitude: ko.observable(),
        maxSize: ko.observable(),
        minSize: ko.observable()
    }

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(getPosition);
    }
    else {
        $("#locationDisabled").toggleClass("hidden");
        $("#locationWaiting").toggleClass("hidden");
    }

    function getPosition(position) {
        $("#locationWaiting").toggleClass("hidden");

        $.ajax({
            url: "/Home/GetIngredients",
            type: "GET",
            dataType: 'json',
            success: function (data) {
                model.latitude(position.coords.latitude);
                model.longitude(position.coords.longitude);
                model.ingredients(JSON.parse(data));

                $("#content").toggleClass("hidden");
            },
            error: function (xhr, status, error) {
                console.log("error");
            }
        })
    }

    $("#pizzeriasForm").submit(function (event) {
        event.preventDefault();

        var modelJS = ko.toJS(model);
        delete modelJS.ingredients;

        var query = $.param(modelJS);
        query = query.replace(/%5B%5D/g, "");

        window.location.replace($("#pizzeriasForm").prop("action") + "?" + query);
    });

    ko.applyBindings(model);
});