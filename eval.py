import pandas as pd

data = pd.read_csv('target/iter_counts.csv')
columns = ['unweighted', 'neg_temp', 'pos_temp']

mean = data.mean()
print(mean)