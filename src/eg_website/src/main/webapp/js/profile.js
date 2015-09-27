$("#instSelect").change(function () {
    var id = this.value;
    var newOptions = $('#inst'+id+' option');
    var $oldDD = $('#collegeSelector');
    $oldDD.empty();
    $.each(newOptions, function(i,item) {
      $oldDD.append($('<option>', { 
          value: item.value,
          text : item.text 
      }));
    });
    $oldDD.val('');
    $("#degrees").addClass("hidden");
    if (newOptions.length <= 0)
    {
        $("#colleges").addClass("hidden");
    }
    else
    {
        $("#colleges").removeClass("hidden");
    }
 });
    
$("#collegeSelector").change(function () {
    var id = this.value;
    var newOptions = $('#coll'+id+' option');
    var $oldDD = $('#degreeSelector');
    $oldDD.empty();
    $.each(newOptions, function(i,item) {
        $oldDD.append($('<option>', { 
            value: item.value,
            text : item.text 
        }));
    });
    $oldDD.val('');
    if (newOptions.length <= 0)
    {
        $("#degrees").addClass("hidden");
    }
    else
    {
        $("#degrees").removeClass("hidden");
    }
});
    


