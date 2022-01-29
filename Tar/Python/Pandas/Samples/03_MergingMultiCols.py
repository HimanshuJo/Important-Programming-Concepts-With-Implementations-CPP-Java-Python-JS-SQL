# Merging multiple table and saving the result in a variable

# E.g:

	ridership_cal=ridership.merge(cal, on=['year', 'month', 'day'])
	
	print(ridership_cal)

# -------

# Merging more than two tables

# E.g:

	ridership_cal_stations=ridership.merge(cal, on=['year', 'month', 'day'])\
	.merge(stations, on='station_id')

# -------

# Applying filter criteria to select the appropriate rows from the merged table

# E.g:

	ridership_cal_stations=ridership.merge(cal, on=['year', 'month', 'day'])\
	.merge(stations, on='station_id')

	filter_criteria=((ridership_cal_stations['month']==7)&
					 (ridership_cal_stations['day_type']=='Weekday')&
					 (ridership_cal_stations['station_name']=='Wilson'))

# -------

# Merge three tables and group them by a particular column name

# E.g:

	licenses_zip_ward=licenses.merge(zip_demo, on='zip')\
	                  .merge(wards, on='ward')

	print(licenses_zip_ward.groupby('alderman').agg({'income': 'median'}))

# -------

# Merging three tables, adding suffixes for the columns with same name

# E.g:

	land_cen_lic=land_use.merge(census, on='ward')\
	.merge(licenses, on='ward', suffixes=['_cen', '_lic'])

# -------

# Grouping merged tables on multiple columns

# E.g:

	land_cen_lic=land_use.merge(census, on='ward')\
	.merge(licenses, on='ward', suffixes=('_cen', '_lic'))

	pop_vac_lic=land_cen_lic.groupby(['ward', 'pop_2010', 'vacant'], as_index=False).agg({'account':'count'})

# -------

# Sorting grouped merged tables based on different columns

# E.g:

	land_cen_lic=land_use.merge(census, on='ward')\
	.merge(licenses, on='ward', suffixes=('_cen', '_lic'))

	pop_vac_lic=land_cen_lic.groupby(['ward', 'pop_2010', 'vacant'], as_index=False).agg({'account':'count'})

	sorted_pop_val_lic=pop_vac_lic.sort_values(['vacant', 'account', 'pop_2010'], ascending=[False, True, True])

	print(sorted_pop_val_lic)