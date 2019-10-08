function postsubmit(e) {

    	e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/bin/check",
            data: $('form').serialize(),
            success: function(data) {
                console.log("got");
                alert("Name :"+ data.name + "  Description: "+data.description);


        	}
        });
    }
