import csv

columns = ['unweighted', 'neg_temp', 'pos_temp']
sums = {col: 0.0 for col in columns}
counts = {col: 0 for col in columns}

with open('target/iter_counts.csv', 'r', newline='', encoding='utf-8') as file:
    reader = csv.DictReader(file)
    for row in reader:
        for col in columns:
            val = row.get(col, "").strip()
            if val:
                try:
                    value = float(val)
                    sums[col] += value
                    counts[col] += 1
                except ValueError:
                    # If the value is not numeric, we skip it
                    pass

mean = {col: (sums[col] / counts[col] if counts[col] > 0 else 0) for col in columns}
print(mean)

# Debug: Check if any columns had zero counts
for col in columns:
    if counts[col] == 0:
        print(f"Warning: No numeric data found for column '{col}'.")
