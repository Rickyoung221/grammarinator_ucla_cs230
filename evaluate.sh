#!/bin/bash

# Initialize sums
sum_weight_update=0
sum_baseline=0

# Number of iterations
iterations=200

for (( i=1; i<=iterations; i++ ))
do
    # Execute the script, get the last percentage, and add to sum
    output=$(./baseline.sh | tail -1 | awk '{print $NF}' | tr -d '%')
    sum_baseline=$((sum_baseline + output))
    echo "Iteration $i: $output%" 
done

echo "====================================="


# Loop to run weight_update.sh 20 times and sum the percentages
for (( i=1; i<=iterations; i++ ))
do
    # Execute the script, get the last percentage, and add to sum
    output=$(./weight_update.sh | tail -1 | awk '{print $NF}' | tr -d '%')
    sum_weight_update=$((sum_weight_update + output))
    echo "Iteration $i: $output%"
done


# Loop to run baseline.sh 20 times and sum the percentages

# Calculate average percentages
avg_weight_update=$((sum_weight_update / iterations))
avg_baseline=$((sum_baseline / iterations))

# Print results
echo "Average percentage for weight_update.sh: $avg_weight_update%"
echo "Average percentage for baseline.sh: $avg_baseline%"
