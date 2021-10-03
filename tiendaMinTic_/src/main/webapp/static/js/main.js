$(document).ready(function(){
  $("#login-button").click(function(){
    $("#login-button").fadeOut("slow",function(){
      $("#container").fadeIn();
    });
  });

$(".close-btn").click(function(){
  $("#container, #container-recuperar").fadeOut(800, function(){
    $("#login-button").fadeIn(800);
  });
});

/* RecuperarPassword */
$('#forgotten').click(function(){
  $("#container").fadeOut(function(){
    $("#container-recuperar").fadeIn();
  });
});

});