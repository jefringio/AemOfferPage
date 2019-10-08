
function submit(){

        $.ajax({
            type : "GET",
            url : '/bin/test.json?q=testing',

             dataType: "json",
            success : function(data) {
                console.log(data);
    
                alert(JSON.stringify(data));


                }
        

        });

}



