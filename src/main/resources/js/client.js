
$(document).ready(function() {


    assignDataToTable();

    showTeam();
    showMatch();

    $("#addTable").click(function () {
        $.ajax({
            type: "GET",
            url: "/addUser"
        })
    })

    $('table').on('click', 'button[id="edit"]', function(e) {
        var id = $(this).closest('tr').children('td:first').text();
        var name = $(this).closest('tr').children('td:nth-child(2)').text();
        var age = $(this).closest('tr').children('td:nth-child(3)').text();
        var login = $(this).closest('tr').children('td:nth-child(4)').text();
        var password = $(this).closest('tr').children('td:nth-child(5)').text();

        $("#idChange").val(id);
        $("#nameChange").val(name);
        $("#ageChange").val(age);
        $("#loginChange").val(login);
        $("#passwordChange").val(password);

        $('#save').click(function () {
            $.ajax ({
                type : "POST",
                url: "/changeUser",
                data: {
                    idChange : $("#idChange").val(),
                    nameChange : $("#nameChange").val(),
                    ageChange: $("#ageChange").val(),
                    loginChange: $("#loginChange").val(),
                    passwordChange: $("#passwordChange").val(),
                },

                success: function(){
                    location.reload();
                }
            });
        });
    });
    $('table').on('click', 'button[id="delete"]', function (e){
        var id = $(this).closest('tr').children('td:first').text();
        $.ajax ({
            type: "GET",
            url: "/removeUser/" + id,
            success: function(){
                assignDataToTable()
            }
        })
    });

    function assignDataToTable() {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/list",
            typeDate: "json",
            success: function(data) {

                var users = JSON.parse(JSON.stringify(data));
                for (var i in users)  {
                    $("#userBody").
                    append("<tr> \
                            <td>" +  users[i].id + "</td> \
                            <td>" +  users[i].name + "</td> \
                            <td>" +  users[i].age + "</td> \
                            <td>" +  users[i].login + "</td> \
                            <td>" +  users[i].password + "</td> \
                            <td> \ <button id='delete' class='btn btn-danger'>delete</button> \</td> \
                          <td> \ <button id='edit' class='btn btn-warning' data-toggle='modal' data-target='#EditModal' >Edit</button> \ </td> \
                        </tr>");
                }
            },
        });
    }
});


function showTeam() {
    $.ajax({
        type : "GET",
        contexType: "application/json",
        url: "/listTeam",
        typeDate: "json",
        success: function (data) {
            for(var i = 0; i < data.length; i++) {
                // for(var j = 0; j< data.length; j++)
                $("#teamBody").append("<tr> \
                            <td>" + data[i].id + "</td> \
                            <td>" + data[i].nameTeam + "</td> \
                            <td>" + data[i].sportTeam[0].nameSport + "</td> \
                            <td>" + data[i].leagueTeam[0].nameLeague + "</td> \
                            <td> \ <button id='deleteTeam' class='btn btn-danger'>delete</button> \</td> \
                          <td> \ <button id='editTeam' class='btn btn-warning' data-toggle='modal' data-target='#TeamEditModal' >Edit</button> \ </td> \
                        </tr>");

            }
        }
    })
}

$("#teamTable").on('click', 'button[id="deleteTeam"]', function (e){
    var id = $(this).closest('tr').children('td:first').text();
    $.ajax ({
        type: "GET",
        url: "/removeTeam/" + id,
        success: function(html){
            $("#container").html(html)
        }
    })
});

$("#teamTable").on('click', 'button[id="editTeam"]', function(e) {
    var id = $(this).closest('tr').children('td:first').text();
    var name = $(this).closest('tr').children('td:nth-child(2)').text();
    var age = $(this).closest('tr').children('td:nth-child(3)').text();
    var league = $(this).closest('tr').children('td:nth-child(4)').text();

    $("#idTeamChange").val(id);
    $("#nameTeamChange").val(name);
    $("#sportChange").val(age);
    $("#leagueChange").val(league);

    $('#saveTeam').click(function () {
        $.ajax ({
            type : "POST",
            url: "/editTeam",
            data: {
                idTeamChange : $("#idTeamChange").val(),
                nameTeamChange : $("#nameTeamChange").val(),
                sportChange: $("#sportChange").val(),
                leagueChange: $("#leagueChange").val(),
            },

            success: function(){
                location.reload();
            }
        });
    });
});

function showMatch() {
    $.ajax({
        type: "GET",
        url: "/listMatches",
        typeData: "JSON",
        success: function (data) {
            for(var i = 0; i < data.length; i++) {
                // for(var j = 0; j< data.length; j++)
                $("#matchBody").append("<tr> \
                            <td>" + data[i].id + "</td> \
                            <td>" + data[i].forMatchesSet[0].teamName1 + "</td> \
                            <td>" + data[i].scoreTeam1 + " : " + data[i].scoreTeam2 + "</td> \
                            <td>" + data[i].forMatchesSet[1].teamName1 + "</td> \
                            <td>" + data[i].matchDate + "." + data[i].matchMonth + " " + data[i].matchTimeHours + ":" + data[i].matchTimeMinutes + "</td> \
                            <td> \ <button id='deleteMatch' class='btn btn-danger'>delete</button> \</td> \
                          <td> \ <button id='editMatch' class='btn btn-warning' data-toggle='modal' data-target='#MatchEditModal' >Edit</button> \ </td> \
                        </tr>");

            }
        }
    })
}

$("#matchTable").on('click', 'button[id="deleteMatch"]', function (e){
    var id = $(this).closest('tr').children('td:first').text();
    $.ajax ({
        type: "GET",
        url: "/removeMatch/" + id,
        success: function(html){
            $("#container").html(html)
        }
    })
});

$("#matchTable").on('click', 'button[id="editMatch"]', function(e) {
    var id = $(this).closest('tr').children('td:first').text();
    var name1 = $(this).closest('tr').children('td:nth-child(2)').text();
    var name2 = $(this).closest('tr').children('td:nth-child(4)').text();
    var date = $(this).closest('tr').children('td:nth-child(5)').text();

    $("#idMatchChange").val(id);
    $("#nameMatchChange1").val(name1);
    $("#nameMatchChange2").val(name2);
    $("#dateMatchChange1").val(date);

    $('#saveMatch').click(function () {
        $.ajax ({
            type : "POST",
            url: "/editMatch",
            data: {
                idMatchChange : $("#idMatchChange").val(),
                nameMatchChange1 : $("#nameMatchChange1").val(),
                nameMatchChange2 : $("#nameMatchChange2").val(),
                dateChange: $("#dateChange").val(),
            },

            success: function(){
                location.reload();
            }
        });
    });
});