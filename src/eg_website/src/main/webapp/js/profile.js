$("#instSelect").change(function () {
        var id = this.value;
        //$('#inst'+id).removeClass('hidden');
        var old = $('#colleges').find("select");
        var newC = $('#inst'+id);
        $('#colleges').find("select").replaceWith(newC);
        old.appendTo('#collegeStore');
        if ($('#inst'+ id +' option').length == 0)
        {
            $('#colleges').addClass('hidden');
        }
        else
        {
            $('#colleges').removeClass('hidden');
        }
    });
    
$(".collSelect").change(function () {
        var id = this.value;
        //$('#inst'+id).removeClass('hidden');
        var old = $('#degree').find("select");
        var newD = $('#coll'+id);
        $('#degree').find("select").replaceWith(newD);
        old.appendTo('#degreeStore');
        if ($('#coll'+ id +' option').length == 0)
        {
            $('#degree').addClass('hidden');
        }
        else
        {
            $('#degree').removeClass('hidden');
        }
    });
