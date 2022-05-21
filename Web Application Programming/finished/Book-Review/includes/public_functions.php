<?php 
//Returns all published posts
function getPublishedPosts() {
	global $conn;
	$sql = "SELECT * FROM posts WHERE published=true";
	$result = mysqli_query($conn, $sql);
	$posts = mysqli_fetch_all($result, MYSQLI_ASSOC);

	$final_posts = array();
	foreach ($posts as $post) {
		$post['genre'] = getPostGenre($post['id']); 
		array_push($final_posts, $post);
	}
	return $final_posts;
}
// Receives a post id and Returns genre of the post 
function getPostGenre($post_id){
	global $conn;
	$sql = "SELECT * FROM genres WHERE id=
			(SELECT genre_id FROM post_genre WHERE post_id=$post_id) LIMIT 1";
	$result = mysqli_query($conn, $sql);
	$genre = mysqli_fetch_assoc($result);
	return $genre;
}

// Returns all posts under a genre
function getPublishedPostsByGenre($genre_id) {
	global $conn;
	$sql = "SELECT * FROM posts ps 
			WHERE ps.id IN 
			(SELECT pt.post_id FROM post_genre pt 
				WHERE pt.genre_id=$genre_id GROUP BY pt.post_id 
				HAVING COUNT(1) = 1)";
	$result = mysqli_query($conn, $sql);
	$posts = mysqli_fetch_all($result, MYSQLI_ASSOC);

	$final_posts = array();
	foreach ($posts as $post) {
		$post['genre'] = getPostGenre($post['id']); 
		array_push($final_posts, $post);
	}
	return $final_posts;
}
// Returns genre name by genre id
function getGenreNameById($id)
{
	global $conn;
	$sql = "SELECT name FROM genres WHERE id=$id";
	$result = mysqli_query($conn, $sql);
	$genre = mysqli_fetch_assoc($result);
	return $genre['name'];
}

/*  Returns a single post */
function getPost($slug){
	global $conn;
	// Get single post slug
	$post_slug = $_GET['post-slug'];
	$sql = "SELECT * FROM posts WHERE slug='$post_slug' AND published=true";
	$result = mysqli_query($conn, $sql);
	$post = mysqli_fetch_assoc($result);
	if ($post) {
		// get the genre to which this post belongs
		$post['genre'] = getPostGenre($post['id']);
	}
	return $post;
}
// Returns all genres
function getAllGenres()
{
	global $conn;
	$sql = "SELECT * FROM genres";
	$result = mysqli_query($conn, $sql);
	$genres = mysqli_fetch_all($result, MYSQLI_ASSOC);
	return $genres;
}


?>

