# Created by Aashish Adhikari at 12:25 PM 1/22/2021

'''
Time Complexity:
O(n) for iterating through the whole list first to create the hashmap, n is the number of employees.

O(n) for the bfs while loop as in the worst case the employee given could have all the other employees as subordinates and this we might have
run the while loop for all the subordinates.

So O(n) + O(n) ~ O(n)


Space Complexity:
O(n) as we store all the employees in the hashmap.
'''

"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """


        if len(employees) == 0:
            return 0

        hm = {}
        from collections import deque

        q = deque()

        for idx in range(len(employees)):

            if employees[idx].id == id:
                q.append(employees[idx])

            hm[employees[idx].id] = employees[idx]


        total_imp = 0
        while len(q) != 0:

            total_imp += q[0].importance

            # add the subordinates
            for idx in range(0, len(q[0].subordinates)):
                q.append(hm[q[0].subordinates[idx]])

            # pop this employee
            q.popleft()

        return total_imp
