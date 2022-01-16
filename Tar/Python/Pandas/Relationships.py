# Grouping the results by a particular column and counting the number of entries
# for a particular column

# E.g:

	counted_df=licenses_owners.groupby('title').agg({'account':'count'})

# -------

# Sorting the result of a grouped by table in desending order

# E.g:

	sorted_df=counted_df.sort_values('account', axis=0, ascending=False)

# -------

# Printing first few rows

# E.g:

	print(sorted_df.head())