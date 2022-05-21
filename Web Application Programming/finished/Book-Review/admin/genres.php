<?php  include('../config.php'); ?>
<?php  include(ROOT_PATH . '/admin/includes/admin_functions.php'); ?>
<?php include(ROOT_PATH . '/admin/includes/head_section.php'); ?>
<!-- Get all genres from DB -->
<?php $genres = getAllGenres();	?>
	<title>Manage Genres</title>
</head>
<body>
	<!-- admin navbar -->
	<?php include(ROOT_PATH . '/admin/includes/navbar.php') ?>
	<div class="container content">
		<!-- Left side menu -->
		<?php include(ROOT_PATH . '/admin/includes/menu.php') ?>

		<!-- Middle form - to create and edit -->
		<div class="action">
			<h1 class="page-title">Create/Edit Genres</h1>
			<form method="post" action="<?php echo BASE_URL . 'admin/genres.php'; ?>" >
				<!-- validation errors for the form -->
				<?php include(ROOT_PATH . '/includes/errors.php') ?>
				<!-- if editing genre, the id is required to identify that Genre -->
				<?php if ($isEditingGenre === true): ?>
					<input type="hidden" name="genre_id" value="<?php echo $genre_id; ?>">
				<?php endif ?>
				<input type="text" name="genre_name" value="<?php echo $genre_name; ?>" placeholder="genre">
				<!-- if editing Genre, display the update button instead of create button -->
				<?php if ($isEditingGenre === true): ?> 
					<button type="submit" class="btn" name="update_genre">UPDATE</button>
				<?php else: ?>
					<button type="submit" class="btn" name="create_genre">Save Genre</button>
				<?php endif ?>
			</form>
		</div>
		<!-- // Middle form - to create and edit -->

		<!-- Display records from DB-->
		<div class="table-div">
			<!-- Display notification message -->
			<?php include(ROOT_PATH . '/includes/messages.php') ?>
			<?php if (empty($genres)): ?>
				<h1>No genres in the database.</h1>
			<?php else: ?>
				<table class="table">
					<thead>
						<th>N</th>
						<th>Genre Name</th>
						<th colspan="2">Action</th>
					</thead>
					<tbody>
					<?php foreach ($genres as $key => $genre): ?>
						<tr>
							<td><?php echo $key + 1; ?></td>
							<td><?php echo $genre['name']; ?></td>
							<td>
								<a class="fa fa-pencil btn edit"
									href="genres.php?edit-genre=<?php echo $genre['id'] ?>">
								</a>
							</td>
							<td>
								<a class="fa fa-trash btn delete"								
									href="genres.php?delete-genre=<?php echo $genre['id'] ?>">
								</a>
							</td>
						</tr>
					<?php endforeach ?>
					</tbody>
				</table>
			<?php endif ?>
		</div>
	</div>
</body>
</html>