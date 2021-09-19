<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Admin Page</title>
  <link rel="stylesheet" href="../css/admin.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Serif&display=swap" rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

  <style>
    table {
      width: 350px;
      border-collapse: collapse;
      margin: 50px auto;
    }
    a{
      color: black;
    }

    /* Zebra striping */
    tr:nth-of-type(odd) {
      background: linear-gradient(to right, #74c567, #28b487);//
    }

    th {
     background: white;
    color: black;
      font-weight: bold;
    }

    td,
    th {
      padding: 10px;
      border: 1px solid #ccc;
      text-align: center;
      font-size: 15px;
    }

    /* 
Max width before this PARTICULAR table gets nasty
This query will take effect for any screen smaller than 760px
and also iPads specifically.
*/
    @media only screen and (max-width: 760px),
    (min-device-width: 768px) and (max-device-width: 1024px) {

      table {
       
      }

      /* Force table to not be like tables anymore */
     /* table,
      thead,
      tbody,
      th,
      td,
      tr {
        display: block;
      }*/

      /* Hide table headers (but not display: none;, for accessibility) */
      thead tr {
      
        top: -9999px;
        left: -9999px;
        
      }
     /* tr:hover {
     background: grey;
  }
  th a {
    display: block;
    }
*/
      tr {
        border: 1px solid #ccc;
        background-color: black;
      }

      td {
        /* Behave  like a "row" */
        border: none;
        border-bottom: 1px solid #eee;
        position: relative;
        padding-left: 50%;
      }

      td:before {
        /* Now like a table header */
        position: absolute;
        /* Top/left values mimic padding */
        top: 6px;
        left: 6px;
        width: 45%;
        padding-right: 10px;
        white-space: nowrap;
        /* Label the data */
        content: attr(data-column);

        color: #000;
        font-weight: bold;
      }

    }

    a:hover {
      text-decoration: none;
    }

    /* #img_contain{
  border:1px solid grey;
  margin-top:10px;
  width:350px; */

    /* } */

    #file-input {

      padding: 10px;
      background-color: gray;
    }

    #image-preview {
      height: 150px;
      width: auto;
      display: block;
      margin-left: auto;
      margin-right: auto;
      padding: 5px;
      float: right;
      border: black;
      border-radius: 18px;

    }

    .photo {
      display: none;
    }

    label {
      text-align: center;
    }

    label span {
      position: relative;
      display: inline-block;
      margin: 0 auto;
      padding: 10px;
      border-radius: 50px;
      background: linear-gradient(45deg, blue, #00ffa1);
      color: #fff;
      font-weight: 700;
      overflow: hidden;
      cursor: pointer;
    }

    label.progress-photo-bar span:before {
      content: '';
      position: absolute;
      top: -100px;
      left: -400px;
      width: 250px;
      height: 400px;
      background: #00000080;
      border-radius: 30% 40% 50% 40%;
      animation: rotate 20s linear infinite;
    }


    @keyframes rotate {
      100% {
        left: 0;
        transform: rotate(720deg);
      }
    }

    label.upload-photo-complete span:after {
      content: 'Edit Profile';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: linear-gradient(45deg, #00de59, #4caf50);
      text-align: center;
      padding: 10px;
      font-weight: 700;
    }

    label.upload-photo-complete span {
      padding: 10px;
      transition: all ease 0.5s;

    }

    label.progress-photo-bar {
      pointer-events: none;

    }
  </style>
</head>

<body>
  <nav>

    <header>
    </header>

    <ul style="color: black; list-style-type:none;padding: 38px;
    margin-top: 97px;">
      <li>Name</li><br>
      <li>Email</li><br>
      <li>Last logged-in:</li>
    </ul>

  </nav>

  <main>

    <h1>Admin Dashboard</h1>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <section id="my_details">

      <table>
        
        <thead>
          <h4 style="text-align:center">List of Meeting rooms</h4></thead>
          <h5 style="color: black;margin-top: 40px;margin-left: 650px;"><a href="Create_room.html">+Create Room</h5>
          <tbody>
          <tr>
            <th><a href="">Meeting Room 1</a></th>
          </tr>

          <tr>
            <th><a href="">Meeting Room 2</a></th>
          </tr>
          <tr>
            <th><a href="">Meeting Room 3</a></th>
          </tr>
          <tr>
            <th><a href="">Meeting Room 4</a></th>
          </tr>
          <tr>
            <th><a href="">Meeting Room 5</a></th>
          </tr>
           </tbody>
      
      </table>
    </section>
  </main>

</body>


</html>