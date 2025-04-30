# 118. Pascal's Triangle

# TC: O(numRows²) because we have to calculate each value in the triangle, and the total number of values is approximately numRows²/2.
# SC: O(numRows²) because we're storing all the values in the triangle.
# Approach : This approach uses a padding technique to simplify the generation of Pascal's Triangle. Here's a detailed explanation:
            # result = [[1]] - Starts with the first row of Pascal's Triangle containing just the number 1.
            # for i in range(numRows - 1) - Loops numRows-1 times to generate the remaining rows (since we already have 1 row).
            # prev_row = [0] + result[-1] + [0] - This is the key insight of this approach:
            #     Takes the previous row (result[-1])
            #     Adds a 0 at the beginning and end of that row
            #     This padding eliminates the need for special handling of edge cases
            # row = [] - Creates an empty list to hold the new row we're about to calculate.
            # for j in range(len(result[-1])+1) - Loops through each position in the new row. 
            # The new row will have one more element than the previous row.
            # row.append(prev_row[j] + prev_row[j+1]) - The core logic of Pascal's Triangle:
            #     For each position, adds the two numbers above it
            #     Because we padded with zeros, the edge calculations work automatically
            #     For the leftmost element: 0 + 1 = 1
            #     For the rightmost element: 1 + 0 = 1
            #     For middle elements: it's the sum of the two numbers above
            # result.append(row) - Adds the completed row to our triangle.
            # return result - Returns the complete Pascal's Triangle with numRows rows.

            



def generate(numRows):
    # Initialize result with the first row of Pascal's triangle
    result = [[1]]
    
    # Loop to generate (numRows-1) more rows (we already have 1 row)
    for i in range(numRows - 1):
        # Create a new version of the previous row with 0s padded at both ends
        # This clever trick eliminates the need to handle edge cases separately
        prev_row = [0] + result[-1] + [0]
        
        # Initialize an empty row to store the current row values
        row = []
        
        # For each position in the new row (length of previous row + 1)
        for j in range(len(result[-1]) + 1):
            # Calculate the value by adding adjacent elements from the padded previous row
            # This uses the fundamental Pascal's triangle property where each value is the sum
            # of the two values above it, with the padded zeros handling the edges naturally
            row.append(prev_row[j] + prev_row[j+1])
            
        # Add the completed row to our result
        result.append(row)
        
    # Return the completed Pascal's triangle
    return result
