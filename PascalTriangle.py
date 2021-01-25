class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        # Time Complexity - O(M*N) rows*cols
        # Space Complexity - O(Row*Col) for output result
        output = []
        # base condition
        if numRows == 0:
            return output
        
        for i in range(0,numRows):
            row=[]
            
            for j in range(0,i+1):
                if j == 0 or j ==i: # As the first and last value for every row is 1
                    row.append(1)
                
                else:
                    left = output[i-1][j-1] 
                    right = output[i-1][j]
                    row.append(left + right)
                    
            output.append(row)
        
        return output