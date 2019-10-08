$(document).ready(function(){
                  $("#submit1).click(function(){
                      console.log("woo");
    $.ajax({
        type : "POST",
        url : '/bin/check',
        data : $('form').serialize(),

        success : function(data) {


            

            console.log(data);
            }
    });
});
});






<!--/*

 $(document).ready(function() {
         $("#somebutton").click(function() {
             servletCall();
         });

     });
     function servletCall() {
         $.post(
             "GetUserServlet", 
             {name : "Message from jsp"}, //meaasge you want to send
             function(result) {
             $('#somediv').html('Here is your result : <strong>' + result + '</strong>'); //message you want to show
         });
     };  */-->