'''
	Important aspect of outer join is that it returns all the rows from both the merged tables and
	null where they do not match.
'''

# Merging two tables using outer join

# E.g:

	iron_1_and_2=iron_1_actors.merge(iron_2_actors, on="id", how="outer", suffixes=['_1', '_2'])
	m=((iron_1_and_2['name_1'].isnull())|(iron_1_and_2['name_2'].isnull()))

	print(iron_1_and_2[m].head())