# Merging two tables on a particular column and saving a result to another variable

# E.g.:

	taxi_own_veh=taxi_owners.merge(taxi_veh, on='vid')

	print(taxi_own_veh.columns)

# -------

# Setting the left and right table suffixes for overlapping columns of the merge to
# particular names respectively

# E.g:

	taxi_own_veh=taxi_owners.merge(taxi_veh, on='vid', suffixes=['_own', '_veh'])

	print(taxi_own_veh.columns)

# -------

# Selecting a particular column from a merged table and printing the values count associated with it

# E.g:

	taxi_own_veh=taxi_owners.merge(taxi_veh, on='vid', suffixes=('_own', '_veh'))

	print(taxi_own_veh['fuel_type'].value_counts())

# -------

# Merging two tables on a particular column and printing the shape of the resultant table

# E.g:

	wards_census=wards.merge(census, on='ward')
	
	print('wards_census table shape:', wards_census.shape)

# -------

# Printing the first few rows of a table

# E.g:

	print(wards_altered[['ward']].head())