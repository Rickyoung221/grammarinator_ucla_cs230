import matplotlib.pyplot as plt
import pandas as pd

file_path = 'target/iter_counts.csv'
data = pd.read_csv(file_path)

data_for_plot = [data['unweighted'], data['neg_temp'], data['pos_temp']]
labels = ['unweighted', 'neg_temp', 'pos_temp']

plt.figure(figsize=(8, 6))

box = plt.boxplot(data_for_plot, labels=labels,patch_artist=True, meanline=True, showmeans=True)
colors = ['#add8e6', '#f4a6a7', '#f4a6e7']  
for patch, color in zip(box['boxes'], colors):
    patch.set_facecolor(color)

for median in box['medians']:
    median.set(color='red', linewidth=2)

plt.xlabel("Weight Method")
plt.ylabel('Number of Iterations')
plt.title('Texas Holdem')
plt.show()