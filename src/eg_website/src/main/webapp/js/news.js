$(document).on("click", ".newsPage", function() {        // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    var $newsPage = $(this).attr("value");
    $.get("moreNews/" + $newsPage, function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $newsList = $('<div class="row" id="newsList">');
        $.each(responseJson, function(index, news) {    // Iterate over the JSON array.
                var $newsItem = $('<div class="newsItem">');
                var $dateColumn = $('<div class=col-md-1 text-center">');
                var $date = new Date(news.postedTime.iMillis);
                var $newsDate = $("<p>").text($date.toString('dd/MM/yyyy'));
                var $it = $("<i>")
                $it.attr('class', "fa fa-camera fa-4x")
                var $p = $("<p>").append($it);
                $p.appendTo($dateColumn);
                $newsDate.appendTo($dateColumn);
                $dateColumn.appendTo($newsItem);
                var $contentColumn = $('<div class="newsContent">');
//                
                var $imageDetails = $('<div class="col-md-5">');
                var $image = $('<img id="dynamic">');
                $image.attr('src', news.newsImage);
                $image.appendTo($imageDetails);
                $imageDetails.appendTo($contentColumn);
//                
                var $contentDetails = $('<div class="col-md-6">');
                var $title = $('<h2>');
                var $link = $('<a>').text(news.content.contentTitle);
                $link.attr('href', news.content.contentPath);
                $link.appendTo($title);
                var $contentSummary = $('<p>').text(news.content.contentSummary);
                $title.appendTo($contentDetails);
                $contentSummary.appendTo($contentDetails);
                $contentDetails.appendTo($contentColumn);
//
                $contentColumn.appendTo($newsItem);             
                $newsItem.appendTo($newsList);
        });
        $("div#newsList").replaceWith($newsList)
        $("div#newsList").trigger("create");
    });
});
