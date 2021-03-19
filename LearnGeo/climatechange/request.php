<?php
include "conn.php";
$conn = conn();
if (isset($_POST["case"])) {
    switch ($_POST["case"]) {
        case "login":{
           login();
            break;
        }
        case "register":{
            register();
            break;
        }
        case "course":{
            getcourse();
            break;
        }
         case "youtube":{
            getyoutube();
            break;
        }
        case"quiz":{
            getquiz();
            break;
        } 
        case "news":{
            getnews();
            break;
        }
    }
}
