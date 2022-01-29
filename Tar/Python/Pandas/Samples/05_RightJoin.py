# Mergin two tables via right join based on a particular column

# E.g:

	action_scifi=action_movies.merge(scifi_movies, on="movie_id", how="right")

# -------

# Merging two tables via right join and adding suffixes for the left and the right table

# E.g:

	action_scifi=action_movies.merge(scifi_movies, on="movie_id", how="right", suffixes=['_act', '_sci'])

# -------

# Select only those rows where a corresponding column entry is null

# E.g:

	action_scifi=action_movies(scifi_movies, on="movie_id", how="right", suffixes=['_act', '_sci'])
	scifi_only=action_scifi[action_scifi['genere_act'].isnull()]

# -------

# Applying merge on the tables using left_on and right on

'''
	It might happen that the column on which you want to merge the DataFrames have different names. 
	For such merges, we will specify the left_on as the left DataFrame name and right_on as the right
'''

# E.g:
	
	action_scifi=action_movies(scifi_movies, on="movie_id", how="right", suffixes=['_act', '_sci'])
	scifi_only=action_scifi[action_scifi['genere_act'].isnull()]
	movies_and_scifi_only=movies.merge(scifi_only, left_on="id", right_on="movie_id", how="inner")

	print(movies_and_scifi_only.head())
	print(movies_and_scifi_only.shape)

# -------

# Joining two tables using right join, based on particular left_on and right_on, and finding the number of
# entries in the merged tables based on a particular column

# E.g:

	genres_movies=movie_to_genres.merge(pop_movies, how="right", left_on="movie_id", right_on="id")
	genre_count=genres_movies.groupby('genre').agg({'id':'count'})
	genre_count.plot(kind="bar")
	
	plt.show()