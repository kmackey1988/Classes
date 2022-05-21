<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<!-- Kimberly mackey 
	 cit253
     09/26/2021 
	For the Exercise you will take an already existing HTML 4 template and modularize it by using PHP includes.  You will divide index.html into multiple modules, each in its own separate PHP file, then use PHP to include those so that the template page retains its original appearance. You should be able to divide the page into 6-7 modules.  Don't forget that some sections/modules could be further divided.  

Properly document all PHP files with comments and use good coding style.

Make sure to test your project.  When finished, zip the project folder and submit the zip file to Blackboard.

	 	-->


<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="main.css" media="screen" title="style (screen)" />
<title>Night Shots</title>
<!--[if IE]>
<link rel="stylesheet" href='ie_fixes.css' type="text/css" media="screen, projection" />
<![endif]-->
</head>
<body>

	<!-- start container -->
	<?php
		require_once  "includes/container.php";
	?>
	<!-- end container -->

		<!-- start content -->
		<?php
		require  "includes/content.php";
		?>
		<!-- end content -->

		
		<!-- start content -->
		<?php
		require  "includes/footer.php";
		?>
		<!-- end content -->
	
</body>
</html>