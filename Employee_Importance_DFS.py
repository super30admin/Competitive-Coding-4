# Created by Aashish Adhikari at 12:31 PM 1/22/2021

'''
Time Complexity:
O(n) as we iterate through the employees list to create the hashmap

Space Complexity:
O(n) since we store all the employees once in the hashmap in the worst case.

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

    def dfs_recursive(self, id):
        print(id)
        # add the importance of this employee
        self.total_importance += self.hm[id].importance

        # and go to all the subordinates of this employee
        for subordinate in range(0, len(self.hm[id].subordinates)):

            self.dfs_recursive(self.hm[id].subordinates[subordinate])


    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """

        if len(employees) == 0:
            return 0

        self.hm = {}

        for idx in range(len(employees)):

            self.hm[employees[idx].id] = employees[idx]

            if employees[idx].id == id:
                master_id = employees[idx].id


        self.set = set()
        self.set.add(id)


        self.total_importance = 0

        self.dfs_recursive(master_id)

        return self.total_importance



