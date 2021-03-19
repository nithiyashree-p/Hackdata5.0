<?php
function conn()
{
    $conn = new mysqli("localhost", "root", "", "climatechange")or die("Unable to connect");
    return $conn;
}
function saveme($con, $string)
{
    return htmlentities(saveme2($con, $string));
}
function saveme2($con, $string)
{
    if (get_magic_quotes_gpc()) {
        $string = stripcslashes($string);
    }

    return $con->real_escape_string($string);
}
function checkAccountExist($mobile)
{
    $con = conn();
    $res = $con->query("select * from credentials where mobile = '$mobile' ");
    if ($res) {
        if ($res->num_rows == 0) {
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}
function NewLogin($mobile, $password)
{
    $con = conn();
    $res = $con->query("select uid,type from credentials where mobile = '$mobile' and password = '$password'");
    $result = array();
    if ($res->num_rows!= 0) {
        $row = $res->fetch_assoc();
        array_push($result, true);
        array_push($result, $row["uid"]);
        array_push($result, $row["type"]);
        return $result;
    } else {
        array_push($result, false);
        return $result;
    }
}
function checkUidexist($uid)
{
    $con = conn();
    $res = $con->query("select * from credentials where id = '$uid' ");

    if ($res) {
        if ($res->num_rows == 0) {
            return false;
        } else {
            return true;
        }
    } else {
        return true;
    }
}
function random_number()
{
    return(rand(1, 10000));
}
function login()
{
    $con = conn();
    if (isset($_POST["mobile"]) && $_POST["password"]) {
        $password = saveme($con, $_POST["password"]);
        $mobile = saveme($con, $_POST["mobile"]);
        $accexist = checkAccountExist($mobile);
        if ($accexist) {
            $creAct =NewLogin($mobile, $password);
            if ($creAct[0]) {
                $arr = array("status" => 200, "Message" => "Login Success", "uid" => $creAct[1],"type"=>$creAct[2]);
                $myJSON = json_encode($arr);
                echo $myJSON;
            } else {
                $arr = array("status" => 202, "Message" => "Password Wrong");
                $myJSON = json_encode($arr);
                echo $myJSON;
            }
        } else {
            $arr = array("status" => 202, "Message" => "Try Again");
            $myJSON = json_encode($arr);
            echo $myJSON;
        }
    }
}
function register()
{
    $conn = conn();
    if (
    isset($_POST['mobile'])
    && isset($_POST['password'])
    && isset($_POST['name'])
    && isset($_POST['type'])
    && isset($_POST['email'])
) {
        $uid             = random_number();
        $mobile          = $_POST['mobile'];
        $password        = $_POST['password'];
        $name            = $_POST['name'];
        $type       = $_POST['type'];
        $email           = $_POST['email'];

        $result = false;
        $resultCheck = $conn->query("SELECT * FROM credentials WHERE mobile='$mobile' LIMIT 1");
        $num_rows    = mysqli_num_rows($resultCheck);

        if ($num_rows > 0) {
            $response["success"] = 1;
            $response["message"] = "Account already exist";
        } else {
            $result = $conn->query("INSERT INTO credentials(`uid`,`mobile`,`email`,`password`,`name`,`type`) VALUES('$uid','$mobile','$email','$password','$name','$type')");
            if ($result) {
                $response["success"] = 1;
                $response["message"] = "Registration Successful";
                $response["uid"] =$uid;
            }
        }

        echo json_encode($response);
    }
}
function getcourse(){
    $conn=conn();
 $result = "SELECT `course` FROM `data` WHERE 1";
        $r = mysqli_query($conn, $result);
        if ($r) {
            $row = mysqli_fetch_array($r);
            $data = ($row['course']);
            echo $data;
        }

}
function getyoutube()
{
        $conn=conn();

     $result = "SELECT `youtube` FROM `data` WHERE 1";
        $r = mysqli_query($conn, $result);
        if ($r) {
            $row = mysqli_fetch_array($r);
            $data = ($row['youtube']);
            echo $data;
        }

}
function getquiz()
{
        $conn=conn();

     $result = "SELECT `quiz` FROM `data` WHERE 1";
        $r = mysqli_query($conn, $result);
        if ($r) {
            $row = mysqli_fetch_array($r);
            $data = ($row['quiz']);
            echo $data;
        }

}
function getnews()
{
        $conn=conn();

     $result = "SELECT `news` FROM `data` WHERE 1";
        $r = mysqli_query($conn, $result);
        if ($r) {
            $row = mysqli_fetch_array($r);
            $data = ($row['news']);
            echo $data;
        }

}

