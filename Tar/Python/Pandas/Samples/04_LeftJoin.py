# Left join on two tables

# E.g:

	movies_financials=movies.merge(financial, on="id", how="left")

	print(movies_financials.shape)

# -------

# After left join count number of rows and columns with null entries which couldn't find any matching values

# E.g:

	movies_financials=movies.merge(financial, on="id", how="left")
	number_of_missing_fin=movies_financials['budget'].isnull().sum().sum()
	
	print(number_of_missing_fin)

# -------

'''
	A left join will return all of the rows from the left table. If these rows in the left table
	match multple rows in the right table, then all of those rows will be returned
'''

# E.g:

	left_table.merge(one_to_many, on="id", how="left").shape