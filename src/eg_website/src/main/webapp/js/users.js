/*
 * Code from: http://code.tutsplus.com/tutorials/using-jquery-to-manipulate-and-filter-data--net-5351
 */



$(document).on("click", ".action", function() {
    var $action = $(this).attr("id");
    if ($action == "ap")
    {
        var actionDetails = new Object();
        actionDetails.action = "ap";
        actionDetails.points = $("#pta").val(); 
        actionDetails.type = $("#ptaType").val();
        actionDetails.selected = $(".visible td").find("input:checked")
                .map(function() {
                    return $( this ).val();
                }).get().join( ", " );
        $.ajax({
            url: "/eg_website/Admin/manageUsers",
            type: 'POST',
            datatype: 'json',
            data: JSON.stringify(actionDetails),
            contentType: 'application/json',
            mimeType: 'application/json',
            async: false
        });        
    }
    else if ($action == "rp")
    {
        var actionDetails = new Object();
        actionDetails.action = "rp";
        actionDetails.points = $("#ptr").val(); 
        actionDetails.type = $("#ptrType").val();
        actionDetails.selected = $(".visible td").find("input:checked")
                .map(function() {
                    return $( this ).val();
                }).get().join( ", " );
        $.ajax({
            url: "/eg_website/Admin/manageUsers",
            type: 'POST',
            datatype: 'json',
            data: JSON.stringify(actionDetails),
            contentType: 'application/json',
            mimeType: 'application/json',
            async: false
        }); 
    } 
    else if ($action == "chgrp")
    {
        var actionDetails = new Object();
        actionDetails.action = "chgrp";
        actionDetails.groupID = $("#newgroup").val();
        actionDetails.selected = $(".visible td").find("input:checked")
                .map(function() {
                    return $( this ).val();
                }).get().join( ", " );
        $.ajax({
            url: "/eg_website/Admin/manageUsers",
            type: 'POST',
            datatype: 'json',
            data: JSON.stringify(actionDetails),
            contentType: 'application/json',
            mimeType: 'application/json',
            async: false
        }); 
    }
    else if ($action === "checkUsername")
    {
        var actionDetails = new Object();
        actionDetails.action = "checkUsername";
        //actionDetails. =
        actionDetails.username = $("#username").val();
        
        $.ajax({
            url: "/eg_website/UserRegisterValidation",
            type: 'GET',
            datatype: 'json',
            data: JSON.stringify(actionDetails),
            contentType: 'application/json',
            mimeType: 'application/json',
            async: true
        }); 
    }
    else if ($action === "markUsersAsAttended")
    {
        var actionDetails = new Object();
        actionDetails.action = "markUsersAsAttended";
        actionDetails.eventID = $("#eventID").val();
        actionDetails.selected = $(".visible td").find("input:checked")
                .map(function() {
                    return $( this ).val();
                }).get().join( ", " );
        
        $.ajax({
            url: "/eg_website/Admin/markUsersAsAttended",
            type: 'POST',
            datatype: 'json',
            data: JSON.stringify(actionDetails),
            contentType: 'application/json',
            mimeType: 'application/json',
            async: false
        }); 
    }
    
    
});

