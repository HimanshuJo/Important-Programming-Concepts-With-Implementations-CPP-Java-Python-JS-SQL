import pandas as pd

# stock names
df_names = pd.DataFrame({
    'Name': ['Apple', 'Mircosoft', 'Tesla', 'Google', 'Netflix'],
    'Symbol': ['APPL', 'MSFT', 'TSLA', 'GOOG', 'NFLX']
})

# sample porfolio
df_portfolio = pd.DataFrame({
    'Symbol': ['TSLA', 'APPL', 'GOOG', 'AMZN'],
    'Shares': [20, 50, 50, 100]
})

# df_merged = pd.merge(df_names, df_portfolio, on='Symbol', how='left')
df_merged = df_names.merge(df_portfolio, on='Symbol', how='left')
print(df_merged)
print('-------')
print(df_names)