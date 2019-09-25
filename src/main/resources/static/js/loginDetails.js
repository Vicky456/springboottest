loginDetails={
  loginSubmit:function () {
        var username = $("#usernameapi").val();
        var password = $("#passwordapi").val();
      $("#eror").hide();

        var data = {
            "username":username,
            "password":password
        };

      var settings = {
          "url": "/api/userlogin",
          "method": "POST",
          "headers": {
              "Content-Type": "application/json"
          },
          "data": JSON.stringify(data)
      };

      $.ajax(settings) .done(function (response) {
          if(response.userid!==undefined){
            window.location.href="/search"
          }
      }).fail(function () {
          $("#eror").show();
      });
  },


    usersearch:function () {

        var userid = $("#usernameapi").val();
        $("#res").hide();
        $("#resc").html("");
        var settings = {
            "url": "/api/user/"+userid,
            "method": "GET",
            "headers": {
                "Content-Type": "application/json"
            }

        };

        $.ajax(settings) .done(function (response) {
            var inhtml = "<p>" +
                "userid: "+response.userid+"<br/>" +
                "username: "+response.username+"<br/>"+
                "createdDate: "+new Date(response.createdDate).toLocaleString()+"<br/>" +
                "dob: "+response.dob+"<br/>" +
                "modifiedDate: "+new Date(response.modifiedDate).toLocaleString()+"<br/>" +
                "</p>";
            $("#resc").html(inhtml);
           console.log(response)
        }).fail(function () {
            $("#res").show();
        });
    }
};