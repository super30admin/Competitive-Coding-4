# 532. K-diff Pairs in an Array

# TC : O(n) time complexity, where n is the length of the input array
# SC : O(n) space complexity for storing the frequency counter
# Approach : First, we handle the edge case where k is negative (there can't be any valid pairs).
            # We create a Counter object to count the occurrences of each number in the array.
            # Then we iterate through each unique number in our counter:
                # For k = 0: We check if any number appears more than once
                # For k > 0: We check if the current number + k exists in our counter
            # The final count represents the number of unique k-diff pairs.

from collections import Counter

def findPairs(nums, k):
    # If k is negative, there can't be any valid pairs
    if k < 0:
        return 0
    
    # Use Counter to count occurrences of each number
    counter = Counter(nums)
    result = 0
    
    # Iterate through the unique numbers
    for num in counter:
        # Special case: if k=0, we need pairs of the same number
        # This means we need at least 2 occurrences of the number
        if k == 0:
            if counter[num] > 1:
                result += 1
        # Otherwise, check if num+k exists in our counter
        else:
            if num + k in counter:
                result += 1
    
    return result



# ____________________________________________________________________________________
# 2 POINTER APPROACH

# TC: O(n log n) due to sorting
# SC: O(1) extra space (or O(n) if we consider the space used for sorting)
# Approach:
    # Algorithm Steps:
        # First, we sort the input array to make the two-pointer approach work effectively
        # We use a slow pointer i to iterate through each unique element
        # For each i, we use a fast pointer j to find elements where nums[j] - nums[i] == k
        # We skip duplicates to ensure we only count unique pairs

    # Key Insights
        # Sort first: By sorting the array, we can make efficient decisions about which pointer to move
        # Skip duplicates: We skip duplicates for both pointers to avoid counting the same pair multiple times
        # Early termination: When the difference exceeds k, we can immediately break the inner loop since all further differences will be larger (array is sorted)

    # Comparison with Hash Map Solution
        # Pros of Two-Pointer Approach:
            # Does not require additional data structures (lower space complexity)
            # Works well with sorted data
            # Can handle the two cases (k=0 and k>0) in a unified way
        # Cons:
            # Requires sorting (O(n log n) time), making it slower than the hash map approach (O(n))
            # More complex logic to handle duplicates



def findPairs(nums, k):
    # Handle edge cases
    if not nums or k < 0:
        return 0
    
    # Sort the array to use two-pointer approach
    nums.sort()
    n = len(nums)
    count = 0
    
    # Use two pointers: slow (i) and fast (j)
    i = 0
    
    # Handle unique pairs
    while i < n:
        # Skip duplicates for i to ensure unique pairs
        if i > 0 and nums[i] == nums[i-1]:
            i += 1
            continue
        
        # For each unique i, find a valid j
        j = i + 1
        while j < n:
            # Calculate the difference
            diff = nums[j] - nums[i]
            
            if diff < k:
                # Difference is too small, increase j
                j += 1
            elif diff > k:
                # Difference is too large, no need to check further
                # Since the array is sorted, all further differences will be larger
                break
            else:
                # Found a valid pair
                count += 1
                
                # Move j to the next distinct value
                while j + 1 < n and nums[j] == nums[j+1]:
                    j += 1
                j += 1
                break  # Found one valid j for current i, move to next i
        
        i += 1
    
    return count