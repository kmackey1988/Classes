
<?php 
// Admin variables
$admin_id = 0;
$isEditingUser = false;
$username = "";
$role = "";
$email = "";
// general variables
$errors = [];
// genres variables
$genre_id = 0;
$isEditingGenre = false;
$genre_name = "";

// Admin users actions
// if user clicks the create admin button
if (isset($_POST['create_admin'])) {
	createAdmin($_POST);
}
// if user clicks the Edit admin button
if (isset($_GET['edit-admin'])) {
	$isEditingUser = true;
	$admin_id = $_GET['edit-admin'];
	editAdmin($admin_id);
}
// if user clicks the update admin button
if (isset($_POST['update_admin'])) {
	updateAdmin($_POST);
}
// if user clicks the Delete admin button
if (isset($_GET['delete-admin'])) {
	$admin_id = $_GET['delete-admin'];
	deleteAdmin($admin_id);
}

// genre actions
// if user clicks the create genre button
if (isset($_POST['create_genre'])) { createGenre($_POST); }
// if user clicks the Edit genre button
if (isset($_GET['edit-genre'])) {
	$isEditingGenre = true;
	$genre_id = $_GET['edit-genre'];
	editGenre($genre_id);
}
// if user clicks the update genre button
if (isset($_POST['update_genre'])) {
	updateGenre($_POST);
}
// if user clicks the Delete genre button
if (isset($_GET['delete-genre'])) {
	$genre_id = $_GET['delete-genre'];
	deleteGenre($genre_id);
}

// Admin users functions

function createAdmin($request_values){
	global $conn, $errors, $role, $username, $email;
	$username = esc($request_values['username']);
	$email = esc($request_values['email']);
	$password = esc($request_values['password']);
	$passwordConfirmation = esc($request_values['passwordConfirmation']);

	if(isset($request_values['role'])){
		$role = esc($request_values['role']);
	}
	// form validation: ensure that the form is correctly filled
	if (empty($username)) { array_push($errors, "Uhmm...We gonna need the username"); }
	if (empty($email)) { array_push($errors, "Oops.. Email is missing"); }
	if (empty($role)) { array_push($errors, "Role is required for admin users");}
	if (empty($password)) { array_push($errors, "uh-oh you forgot the password"); }
	if ($password != $passwordConfirmation) { array_push($errors, "The two passwords do not match"); }
	// Ensure that no user is registered twice. 
	// the email and usernames should be unique
	$user_check_query = "SELECT * FROM users WHERE username='$username' 
							OR email='$email' LIMIT 1";
	$result = mysqli_query($conn, $user_check_query);
	$user = mysqli_fetch_assoc($result);
	if ($user) { // if user exists
		if ($user['username'] === $username) {
		  array_push($errors, "Username already exists");
		}

		if ($user['email'] === $email) {
		  array_push($errors, "Email already exists");
		}
	}
	// register user if there are no errors in the form
	if (count($errors) == 0) {
		$password = md5($password);//encrypt the password before saving in the database
		$query = "INSERT INTO users (username, email, role, password, created_at, updated_at) 
				  VALUES('$username', '$email', '$role', '$password', now(), now())";
		mysqli_query($conn, $query);

		$_SESSION['message'] = "Admin user created successfully";
		header('location: users.php');
		exit(0);
	}
}

//genres functions
// get all genres from DB
function getAllGenres() {
	global $conn;
	$sql = "SELECT * FROM genres";
	$result = mysqli_query($conn, $sql);
	$genres = mysqli_fetch_all($result, MYSQLI_ASSOC);
	return $genres;
}
function createGenre($request_values){
	global $conn, $errors, $genre_name;
	$genre_name = esc($request_values['genre_name']);
	// create slug
	$genre_slug = makeSlug($genre_name);
	// validate form
	if (empty($genre_name)) { 
		array_push($errors, "Genre name required"); 
	}
	// Ensure that no genre is saved twice. 
	$genre_check_query = "SELECT * FROM genres WHERE slug='$genre_slug' LIMIT 1";
	$result = mysqli_query($conn, $genre_check_query);
	if (mysqli_num_rows($result) > 0) { // if genre exists
		array_push($errors, "Genre already exists");
	}
	// register genre if there are no errors in the form
	if (count($errors) == 0) {
		$query = "INSERT INTO genres (name, slug) 
				  VALUES('$genre_name', '$genre_slug')";
		mysqli_query($conn, $query);

		$_SESSION['message'] = "Genre created successfully";
		header('location: genres.php');
		exit(0);
	}
}


// alows admins only to edit
function editAdmin($admin_id)
{
	global $conn, $username, $role, $isEditingUser, $admin_id, $email;

	$sql = "SELECT * FROM users WHERE id=$admin_id LIMIT 1";
	$result = mysqli_query($conn, $sql);
	$admin = mysqli_fetch_assoc($result);

	// set form values ($username and $email) on the form to be updated
	$username = $admin['username'];
	$email = $admin['email'];
}

// gets genre info through id 
function editGenre($genre_id) {
	global $conn, $genre_name, $isEditingGenre, $genre_id;
	$sql = "SELECT * FROM genres WHERE id=$genre_id LIMIT 1";
	$result = mysqli_query($conn, $sql);
	$genre = mysqli_fetch_assoc($result);
	// set form values 
	$genre_name = $genre['name'];
}
function updateGenre($request_values) {
	global $conn, $errors, $genre_name, $genre_id;
	$genre_name = esc($request_values['genre_name']);
	$genre_id = esc($request_values['genre_id']);
	// create slug
	// validate form
	if (empty($genre_name)) { 
		array_push($errors, "Genre name required"); 
	}
	// register genre if there are no errors in the form
	if (count($errors) == 0) {
		$query = "UPDATE genres SET name='$genre_name', slug='$genre_slug' WHERE id=$genre_id";
		mysqli_query($conn, $query);

		$_SESSION['message'] = "Genre updated successfully";
		header('location: genres.php');
		exit(0);
	}
}


// Receives admin request from form and updates in database

function updateAdmin($request_values){
	global $conn, $errors, $role, $username, $isEditingUser, $admin_id, $email;
	// get id of the admin to be updated
	$admin_id = $request_values['admin_id'];
	// set edit state to false
	$isEditingUser = false;


	$username = esc($request_values['username']);
	$email = esc($request_values['email']);
	$password = esc($request_values['password']);
	$passwordConfirmation = esc($request_values['passwordConfirmation']);
	if(isset($request_values['role'])){
		$role = $request_values['role'];
	}
	// register user if there are no errors in the form
	if (count($errors) == 0) {
		//encrypt the password (security purposes)
		$password = md5($password);

		$query = "UPDATE users SET username='$username', email='$email', role='$role', password='$password' WHERE id=$admin_id";
		mysqli_query($conn, $query);

		$_SESSION['message'] = "Admin user updated successfully";
		header('location: users.php');
		exit(0);
	}
}
// delete admin user 
function deleteAdmin($admin_id) {
	global $conn;
	$sql = "DELETE FROM users WHERE id=$admin_id";
	if (mysqli_query($conn, $sql)) {
		$_SESSION['message'] = "User successfully deleted";
		header("location: users.php");
		exit(0);
	}
}

// delete genre 
function deleteGenre($genre_id) {
	global $conn;
	$sql = "DELETE FROM genres WHERE id=$genre_id";
	if (mysqli_query($conn, $sql)) {
		$_SESSION['message'] = "Genre successfully deleted";
		header("location: genres.php");
		exit(0);
	}
}




// Returns all admin users 
function getAdminUsers(){
	global $conn, $roles;
	$sql = "SELECT * FROM users WHERE role IS NOT NULL";
	$result = mysqli_query($conn, $sql);
	$users = mysqli_fetch_all($result, MYSQLI_ASSOC);

	return $users;
}
//Escapes form submitted value
function esc(String $value){
	global $conn;
	// remove empty space sorrounding string
	$val = trim($value); 
	$val = mysqli_real_escape_string($conn, $value);
	return $val;
}
// Receives a string like 'Some Sample String'
// and returns 'some-sample-string'
function makeSlug(String $string){
	$string = strtolower($string);
	$slug = preg_replace('/[^A-Za-z0-9-]+/', '-', $string);
	return $slug;
}
?>