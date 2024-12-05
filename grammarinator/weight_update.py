def scale_weights(data, alpha=1, decay_factor=0.95):
    """
    Apply softmax-based scaling with decay to the weights in a nested JSON structure.
    """
    def softmax_scaling(weights, alpha, decay_factor):
        mean = np.mean(list(weights.values()))
        # Applying decay to each weight
        decayed_weights = {k: v * decay_factor for k, v in weights.items()}
        scaled = {k: np.exp(-alpha * abs(v - mean)) for k, v in decayed_weights.items()}
        total = sum(scaled.values())
        return {k: (v / total) for k, v in scaled.items()}

    # Traverse the JSON and apply scaling with decay
    for key, sub_dict in data.items():
        for sub_key, weights in sub_dict.items():
            data[key][sub_key] = softmax_scaling(weights, alpha, decay_factor)
    
    return data

# Load the JSON
import json
import numpy as np
with open('target/trace.json', 'r') as f:
    data = json.load(f)

# Update the JSON
updated_data = scale_weights(data)

# Output the updated JSON

#writing the updated data to a file
with open('target/trace.json', 'w') as f:
    json.dump(updated_data, f, indent=4)
